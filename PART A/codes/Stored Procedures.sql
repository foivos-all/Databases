DROP PROCEDURE IF EXISTS get_papers;
DROP PROCEDURE IF EXISTS adjust_journalist_salary;
DROP PROCEDURE IF EXISTS journalist_login;
DROP PROCEDURE IF EXISTS get_paygrade;
DROP PROCEDURE IF EXISTS show_articles;
DROP PROCEDURE IF EXISTS show_articles_c;
DROP PROCEDURE IF EXISTS sales_information;
DROP PROCEDURE IF EXISTS newspaper_information;
DROP PROCEDURE IF EXISTS paper_information_of_newspaper;
DROP PROCEDURE IF EXISTS get_journalists;
DROP PROCEDURE IF EXISTS get_journalist;
DROP PROCEDURE IF EXISTS get_journalists_p;
DROP PROCEDURE IF EXISTS get_chief_editor;
DROP PROCEDURE IF EXISTS get_path;
DROP PROCEDURE IF EXISTS get_paper_number;
DROP PROCEDURE IF EXISTS get_newspaper;
DROP PROCEDURE IF EXISTS get_path_c;

/* ----------- Mandatory Stored Procedures ----------- */

DELIMITER $

CREATE PROCEDURE get_papers(IN paper_num int, IN news_name varchar(255))
BEGIN 
	DECLARE final_article INT; 
	DECLARE paper_pages INT; 
	DECLARE pages_left INT; 
	DECLARE msg VARCHAR(255); 

	SELECT article.title, authors.author, article.date_approved, article.starting_page, (article.ending_page - article.starting_page + 1) AS page_count
    	FROM article
    	INNER JOIN authors ON article.path = authors.article_path
    	INNER JOIN paper ON article.paper_number = paper.number
    	WHERE article.paper_number = paper_num AND paper.newspaper_name = news_name
    	GROUP BY article.title
    	ORDER BY article.priority ASC; 
    
    	SELECT paper.pages, MAX(article.ending_page) INTO paper_pages, final_article
    	FROM paper
    	INNER JOIN article ON paper.number = article.paper_number
    	WHERE paper.number = paper_num;  
    
	SET pages_left = paper_pages - final_article;

    	IF (pages_left != 0)
    	THEN 
		BEGIN 
			SET msg = "PAPER NOT CLOSED! REMAINING PAGES: ";
			SELECT msg;
			SELECT pages_left;
		END; 
    	ELSE 
		BEGIN 
			SET msg = "PAPER CLOSED! NO MORE PAGES AVAILABLE";
			SELECT msg;
		END; 
    	END IF; 
END$ 

DELIMITER ;

DELIMITER $

CREATE PROCEDURE adjust_journalist_salary(IN j_email VARCHAR(255))
BEGIN 
	DECLARE cur_work_exp INT; 
	DECLARE total_work_exp INT; 
	DECLARE hired DATE; 
	DECLARE old_salary FLOAT(10,2); 
	DECLARE new_salary FLOAT(10,2); 
	DECLARE work_exp INT; 
    
	SELECT worker.salary, journalist.work_experience, worker.date_hired 
	INTO old_salary, work_exp, hired FROM worker
	INNER JOIN journalist ON worker.email = journalist.worker_email
	WHERE worker.email = j_email; 
    
	SET cur_work_exp = TIMESTAMPDIFF(month, hired, CURDATE()); 
	SET total_work_exp = cur_work_exp + work_exp;
	SET new_salary = old_salary + (old_salary*(total_work_exp*0.05));
	UPDATE worker SET worker.salary = new_salary WHERE worker.email = j_email; 
END$ 

DELIMITER ;

/* ----------- Extra Stored Procedures for the GUI ----------- */

DELIMITER $

CREATE PROCEDURE journalist_login(IN user_name VARCHAR(255)) /* Returns the article written by this specific journalist */
BEGIN
    SELECT path, paper_number, title, summary, state, priority, starting_page, ending_page, category_id, chief_editor_email,  date_approved, comments, author
    FROM article
    INNER JOIN authors ON article.path = authors.article_path
    INNER JOIN worker ON authors.author = worker.username
    WHERE authors.author = user_name; 
END$

DELIMITER ;

DELIMITER $

CREATE PROCEDURE get_paygrade(IN months INT, IN decision INT, IN user_name VARCHAR(255)) /* Returns the salary of workers multiplied by the months given */
BEGIN
	DECLARE news_name VARCHAR(255);
	DECLARE salaries_per_month FLOAT(10, 2);
    DECLARE result FLOAT(10, 2);
   
    SELECT newspaper_name INTO news_name /* First, we get the newspaper's name to which the user works at */
    FROM worker
    INNER JOIN newspaper ON worker.newspaper_name = newspaper.name
    WHERE worker.username = user_name;
    
    IF(decision = 1) THEN /* If the decision is 1 then we return the SUM of the salaries of each worker multiplied by the month */
		SELECT newspaper_name, (SUM(worker.salary)*months) AS total_expences
        FROM worker
		INNER JOIN newspaper ON worker.newspaper_name = newspaper.name
		WHERE newspaper_name = news_name;

	ELSEIF (decision = 2) THEN /* Else, if the decision is 2 then we return each worker's salary multiplied by the month */
		SELECT newspaper_name, name, lastname, salary AS salary_per_month, (salary*months) AS total_salaries FROM worker
        WHERE newspaper_name = news_name
        GROUP BY name;
	END IF;
	
END$

DELIMITER ;

DELIMITER $

CREATE PROCEDURE show_articles(IN user_name VARCHAR(255)) /* Return the articles that belong to the newspaper the user works at */
BEGIN
	DECLARE news_name VARCHAR(255);
    
    SELECT newspaper.name INTO news_name /* We get the newspaper's name that the user works at */
    FROM newspaper
    INNER JOIN worker ON newspaper.name = worker.newspaper_name
    WHERE worker.username = user_name;
    
    SELECT article.path, article.paper_number, article.title, article.summary, article.state, article.priority, article.starting_page, article.ending_page, article.category_id, article.chief_editor_email, article.date_approved, article.comments, authors.author
    FROM article
    INNER JOIN authors ON article.path = authors.article_path
    INNER JOIN paper ON article.paper_number = paper.number
    INNER JOIN newspaper ON paper.newspaper_name = newspaper.name
    WHERE newspaper.name = news_name;
END$

DELIMITER ;

DELIMITER $

CREATE PROCEDURE show_articles_c(IN user_name VARCHAR(255)) /* Return the articles that belong to the newspaper the user works at */
BEGIN
	DECLARE c_email VARCHAR(255);
    DECLARE news_name VARCHAR(255);
    
    SELECT newspaper.name INTO news_name /* We get the newspaper's name that the user works at */
    FROM newspaper
    INNER JOIN worker ON newspaper.name = worker.newspaper_name
    WHERE worker.username = user_name;
    
    SELECT worker.email INTO c_email
	FROM worker
    INNER JOIN chief_editor ON worker.email = chief_editor.worker_email
    WHERE worker.username = user_name AND worker.newspaper_name = news_name;
    
    SELECT article.path, article.paper_number, article.title, article.summary, article.state, article.priority, article.starting_page, article.ending_page, article.category_id, article.chief_editor_email, article.date_approved, article.comments, authors.author
    FROM article
    INNER JOIN authors ON article.path = authors.article_path
    INNER JOIN worker ON authors.author = worker.username
    INNER JOIN newspaper ON worker.newspaper_name = newspaper.name
    WHERE article.chief_editor_email = c_email AND newspaper.name = news_name;
END$

DELIMITER ;

DELIMITER $

CREATE PROCEDURE sales_information(IN user_name VARCHAR(255)) /* Return the amount of the papers sold */
BEGIN
	DECLARE p_email VARCHAR(255);
    
	SELECT worker.email INTO p_email /* Getting the publisher's email */
    FROM worker
    INNER JOIN publisher ON worker.email = publisher.worker_email
    WHERE worker.username = user_name;

	SELECT paper.number, newspaper.name, paper.publisher_email, (paper.copies - paper.returned_papers) AS total_sales /* We take the difference of the printed papers and the returned papers */
    FROM paper
    INNER JOIN newspaper ON paper.newspaper_name = newspaper.name
    WHERE newspaper.owner = p_email;
END$

DELIMITER ;

DELIMITER $

CREATE PROCEDURE newspaper_information(IN user_name VARCHAR(255)) /* We return the information of the newspaper that the user works at */
BEGIN
	DECLARE p_email VARCHAR(255);
    
    SELECT worker.email INTO p_email /* Getting the publisher's email */
    FROM worker
    INNER JOIN publisher ON worker.email = publisher.worker_email
    WHERE worker.username = user_name;
    
    SELECT * FROM newspaper WHERE owner = p_email;
END$

DELIMITER ;

DELIMITER $

CREATE PROCEDURE paper_information_of_newspaper(IN user_name VARCHAR(255)) /* We return the information of the papers of the newspaper that the user works at */
BEGIN
	DECLARE p_email VARCHAR(255);
    
    SELECT worker.email INTO p_email /* Getting the publisher's email */
    FROM worker
    INNER JOIN publisher ON worker.email = publisher.worker_email
    WHERE worker.username = user_name;
    
    SELECT  paper.number, paper.newspaper_name, paper.publisher_email, paper.copies FROM paper /* Returning the information */
    INNER JOIN publisher ON paper.publisher_email = publisher.worker_email
    INNER JOIN worker ON publisher.worker_email = worker.email
    WHERE worker.username = user_name;
END$

DELIMITER ;

DELIMITER $

CREATE PROCEDURE get_journalist(IN user_name VARCHAR(255))
BEGIN
	DECLARE j_email VARCHAR(255);
    
    SELECT worker.email FROM worker WHERE worker.username = user_name;
END$

DELIMITER ;

DELIMITER $

CREATE PROCEDURE get_journalists(IN user_name VARCHAR(255)) /* We return the informations of the journalists that work at the newspaper that the user owns */
BEGIN
	DECLARE p_email VARCHAR(255);
    
    SELECT worker.email INTO p_email /* Getting the publisher's email */
    FROM worker
    INNER JOIN publisher ON worker.email = publisher.worker_email
    WHERE worker.username = user_name;
    
    SELECT worker.email, worker.name, worker.lastname, worker.date_hired, newspaper.name AS newspaper_name, worker.post /* and returing the information of the journalists */
    FROM worker
    INNER JOIN newspaper ON worker.newspaper_name = newspaper.name
    INNER JOIN journalist ON worker.email = journalist.worker_email
    WHERE newspaper.owner = p_email;
END$

DELIMITER ;

/* ----------- Extra Stored Procedures for the Bonus Question ----------- */

DELIMITER $

CREATE PROCEDURE get_journalists_p(IN user_name VARCHAR(255)) /* Getting only the email of the journalists that work at the newspaper that the user owns */
BEGIN
	DECLARE p_email VARCHAR(255);
    
    SELECT worker.email INTO p_email /* Getting the email of the publisher */
    FROM worker
    INNER JOIN publisher ON worker.email = publisher.worker_email
    WHERE worker.username = user_name;
    
    SELECT worker.email /* and returning the emails of the journalists */
    FROM worker
    INNER JOIN newspaper ON worker.newspaper_name = newspaper.name
    INNER JOIN journalist ON worker.email = journalist.worker_email
    WHERE newspaper.owner = p_email;
END$

DELIMITER ;

DELIMITER $

CREATE PROCEDURE get_chief_editor(IN user_name VARCHAR(255)) /* Returning the chief editor of the newspaper that the user owns */
BEGIN
	DECLARE p_email VARCHAR(255);
    
    SELECT worker.email INTO p_email /* Getting the  publisher's email */
    FROM worker
    INNER JOIN publisher ON worker.email = publisher.worker_email
    WHERE worker.username = user_name;
    
    SELECT worker.email /* and returning the email of the chief editor*/
    FROM worker
    INNER JOIN newspaper ON worker.newspaper_name = newspaper.name
    INNER JOIN journalist ON worker.email = journalist.worker_email
    WHERE newspaper.owner = p_email AND worker.post = 'C';
END$

DELIMITER ;

DELIMITER $

CREATE PROCEDURE get_path(IN user_name VARCHAR(255)) /* Getting the paths of the articles that the user submitted */
BEGIN
	DECLARE j_email VARCHAR(255);
    
    SELECT distinct(worker.email) INTO j_email /* First, we get the email of the journalist that the user submitted */
    FROM worker
    INNER JOIN journalist ON worker.email = journalist.worker_email
    INNER JOIN submits ON journalist.worker_email = submits.journalist_email
    INNER JOIN article ON submits.article_path = article.path
    INNER JOIN authors ON article.path = authors.article_path
    WHERE authors.author = user_name;
    
    SELECT article.path FROM article /* and returning the path of the articles */
    INNER JOIN submits ON article.path = submits.article_path
    INNER JOIN journalist ON submits.journalist_email = journalist.worker_email
    WHERE journalist.worker_email = j_email;
END$

DELIMITER ;

DELIMITER $

CREATE PROCEDURE get_paper_number(IN user_name VARCHAR(255)) /* Getting the paper's number  */
BEGIN
	DECLARE news_name VARCHAR(255);
    
    SELECT newspaper.name INTO news_name /* Getting the newspaper's name that the user works at */
    FROM newspaper
    INNER JOIN worker ON newspaper.name = worker.newspaper_name
    WHERE worker.username = user_name;
    
    SELECT paper.number FROM paper WHERE paper.newspaper_name = news_name; /* and returing the number */
END$

DELIMITER ;

DELIMITER $

CREATE PROCEDURE get_newspaper(IN user_name VARCHAR(255)) /* Returning the name of the newspaper that the users works at */
BEGIN
	SELECT newspaper.name
    FROM newspaper
    INNER JOIN worker ON newspaper.name = worker.newspaper_name
    WHERE worker.username = user_name;
END$

DELIMITER ;

DELIMITER $

CREATE PROCEDURE get_path_c(IN user_name VARCHAR(255)) /* Returing the paths of the articles of the newspaper that the user works at */
BEGIN
	DECLARE c_email VARCHAR(255);
    
    SELECT worker.email INTO c_email /* Getting the chief editor's email */
    FROM worker
    INNER JOIN newspaper ON worker.newspaper_name = newspaper.name
    WHERE worker.username = user_name;
    
    SELECT article.path FROM article /* Returning the articles' paths */
    INNER JOIN chief_editor ON article.chief_editor_email = chief_editor.worker_email
    INNER JOIN worker ON chief_editor.worker_email = worker.email
    WHERE chief_editor.worker_email = c_email;
END$

DELIMITER ;