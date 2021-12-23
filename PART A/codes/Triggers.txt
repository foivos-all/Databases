DROP TRIGGER IF EXISTS set_worker_salary;
DROP TRIGGER IF EXISTS check_if_chief_editor;
DROP TRIGGER IF EXISTS check_if_pages_are_full;

DELIMITER $

CREATE TRIGGER set_worker_salary BEFORE INSERT
ON worker
FOR EACH ROW
BEGIN
	SET NEW.salary = 650.00;
END$

DELIMITER ;

DELIMITER $

CREATE TRIGGER check_if_chief_editor AFTER INSERT
ON submits
FOR EACH ROW
BEGIN
	DECLARE c_editor VARCHAR(255);

	SELECT worker.email INTO c_editor
	FROM worker
	INNER JOIN journalist ON worker.email = journalist.worker_email
	INNER JOIN chief_editor ON journalist.worker_email = chief_editor.worker_email
	INNER JOIN submits ON chief_editor.worker_email = submits.journalist_email
	INNER JOIN article ON submits.article_path = article.path
	WHERE worker.email = NEW.journalist_email AND article.path = NEW.article_path;

	IF(c_editor = NEW.journalist_email) THEN
		UPDATE article SET article.state = 'accepted', article.date_approved = curdate() WHERE article.path = NEW.article_path;
	END IF;
END$

DELIMITER $

CREATE TRIGGER check_if_pages_are_full BEFORE INSERT
ON article
FOR EACH ROW
BEGIN
	DECLARE total_pages INT;

	SELECT paper.pages INTO total_pages
	FROM paper
	INNER JOIN article ON paper.number = article.paper_number
    WHERE paper.number = NEW.paper_number;

	IF (NEW.ending_page > total_pages)
	THEN
		BEGIN
			SIGNAL SQLSTATE VALUE '45000'
			SET MESSAGE_TEXT = 'Article size too big to fit into this paper.';

		END;
	END IF;	
END$

DELIMITER ;