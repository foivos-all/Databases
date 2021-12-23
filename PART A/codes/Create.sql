DROP TABLE IF EXISTS newspaper;
DROP TABLE IF EXISTS article;
DROP TABLE IF EXISTS authors;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS chief_editor;
DROP TABLE IF EXISTS images;
DROP TABLE IF EXISTS journalist;
DROP TABLE IF EXISTS keywords;
DROP TABLE IF EXISTS administrator;
DROP TABLE IF EXISTS paper;
DROP TABLE IF EXISTS publisher;
DROP TABLE IF EXISTS submits;
DROP TABLE IF EXISTS telephones;
DROP TABLE IF EXISTS worker;

CREATE TABLE IF NOT EXISTS newspaper (
    name VARCHAR(255) NOT NULL,
    owner VARCHAR(255) NOT NULL,
    publishing_frequency ENUM('daily', 'weekly', 'monthly') NOT NULL,
    PRIMARY KEY (name),
    FOREIGN KEY (owner)
        REFERENCES publisher (email)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS worker (
    email VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    newspaper_name VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    date_hired DATE NOT NULL,
    salary FLOAT(10 , 2 ),
    post ENUM('J', 'A', 'C', 'P') NOT NULL,
    PRIMARY KEY (email),
    FOREIGN KEY (newspaper_name)
        REFERENCES newspaper (name)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS administrator (
    worker_email VARCHAR(255) NOT NULL,
    street VARCHAR(255) NOT NULL,
    number VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    duties ENUM('secretary', 'logistics') NOT NULL,
    PRIMARY KEY (worker_email),
    FOREIGN KEY (worker_email)
        REFERENCES worker (email)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS telephones (
    administrator_email VARCHAR(255) NOT NULL,
    telephone BIGINT NOT NULL,
    PRIMARY KEY (administrator_email , telephone),
    FOREIGN KEY (administrator_email)
        REFERENCES administrator (email)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS publisher (
    worker_email VARCHAR(255) NOT NULL,
    PRIMARY KEY (worker_email),
    FOREIGN KEY (worker_email)
        REFERENCES worker (email)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS chief_editor (
    worker_email VARCHAR(255) NOT NULL,
    publisher_email VARCHAR(255) NOT NULL,
    PRIMARY KEY (worker_email),
    FOREIGN KEY (worker_email)
        REFERENCES worker (email)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (worker_email)
        REFERENCES journalist (worker_email)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (publisher_email)
        REFERENCES publisher (email)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS journalist (
    worker_email VARCHAR(255) NOT NULL,
    work_experience INT NOT NULL,
    resume TEXT NOT NULL,
    PRIMARY KEY (worker_email),
    FOREIGN KEY (worker_email)
        REFERENCES worker (email)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS category (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    parent_id INT,
    chief_editor_email VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (parent_id)
        REFERENCES category (id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (chief_editor_email)
        REFERENCES chief_editor (email)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS article (
    path VARCHAR(255) NOT NULL,
    paper_number INT,
    title VARCHAR(255) NOT NULL,
    summary TEXT NOT NULL,
    state ENUM('accepted', 'to_be_revised', 'rejected'),
    priority INT,
    starting_page INT NOT NULL,
    ending_page INT NOT NULL,
    category_id INT NOT NULL,
    chief_editor_email VARCHAR(255) NOT NULL,
    date_approved DATE,
    comments VARCHAR(255),
    PRIMARY KEY (path),
    FOREIGN KEY (paper_number)
        REFERENCES paper (number)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (chief_editor_email)
        REFERENCES chief_editor (email)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (category_id)
        REFERENCES category (id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS submits (
    journalist_email VARCHAR(255) NOT NULL,
    article_path VARCHAR(255) NOT NULL,
    date_of_submission DATE,
    PRIMARY KEY (journalist_email , article_path),
    FOREIGN KEY (journalist_email)
        REFERENCES journalist (email)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (article_path)
        REFERENCES article (path)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS keywords (
    article_path VARCHAR(255) NOT NULL,
    keyword VARCHAR(255) NOT NULL,
    PRIMARY KEY (article_path , keyword),
    FOREIGN KEY (article_path)
        REFERENCES article (path)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS authors (
    article_path VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    PRIMARY KEY (article_path , author),
    FOREIGN KEY (article_path)
        REFERENCES article (path)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS images (
    article_path VARCHAR(255) NOT NULL,
    image VARCHAR(255) NOT NULL,
    PRIMARY KEY (article_path , image),
    FOREIGN KEY (article_path)
        REFERENCES article (path)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS paper (
    number INT NOT NULL AUTO_INCREMENT,
    newspaper_name VARCHAR(255) NOT NULL,
    publisher_email VARCHAR(255) NOT NULL,
    returned_papers INT NOT NULL,
    published_date DATE NOT NULL,
    pages INT NOT NULL DEFAULT 30,
    copies INT NOT NULL,
    PRIMARY KEY (number , newspaper_name),
    FOREIGN KEY (newspaper_name)
        REFERENCES newspaper (name)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (publisher_email)
        REFERENCES publisher (email)
        ON UPDATE CASCADE ON DELETE CASCADE
);