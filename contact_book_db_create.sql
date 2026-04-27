CREATE DATABASE contact_book;
USE contact_book;

CREATE TABLE contact(
	contact_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL
);

CREATE TABLE category(
	cat_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    cat_name VARCHAR(20) NOT NULL
);

CREATE UNIQUE INDEX IX_category_name ON category(cat_name);

DELIMITER $$
CREATE FUNCTION func_get_cat (
	catname VARCHAR(20)
) RETURNS INT DETERMINISTIC BEGIN
	DECLARE catid INT;
    SELECT cat_id INTO catid FROM category WHERE cat_name = catname;
    RETURN catid;
END $$
DELIMITER ;

INSERT INTO category(cat_name) VALUES ('email address'), ('phone number');

CREATE TABLE detail(
	contact_id INT NOT NULL,
    detail_id INT NOT NULL,
    detail_value VARCHAR(30) NOT NULL,
    cat_id INT NOT NULL,
    PRIMARY KEY (contact_id, detail_id)
);

DELIMITER $$
CREATE PROCEDURE proc_read(
	IN contactid INT,
    IN detailid INT
) BEGIN
	DECLARE detailval VARCHAR(30);
    DECLARE catid INT;
    DECLARE catname VARCHAR(20);
    
    SELECT detail_value, cat_id INTO detailval, catid FROM detail WHERE contact_id = contactid AND detail_id = detailid;
    SELECT cat_name INTO catname FROM category WHERE cat_id = catid;
    
    SELECT contactid, detailid, detailval, catname;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE proc_add_detail (
	IN contactid INT,
    IN detailval VARCHAR(30),
    IN catname VARCHAR(20)
) BEGIN
	DECLARE detailid INT;
    DECLARE catid INT;
    SET catid = func_get_cat(catname);
    SELECT MAX(detail_id + 1) INTO detailid FROM detail WHERE contact_id = contactid;
    IF detailid IS NULL THEN
		SET detailid = 1;
    END IF;
    INSERT INTO detail(contact_id, detail_id, detail_value, cat_id) VALUES
		(contactid, detailid, detailval, catid);
END $$
DELIMITER ;