/* Create the database */
CREATE DATABASE pupsims_db;

/* Create attendance table */
CREATE TABLE pupsims_db.attendance (
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	security_guard_id BIGINT NOT NULL,
	log_date DATE NOT NULL,
	log_status VARCHAR(10) NOT NULL
);

/* Create the main application user */
CREATE USER 'pupsims'@localhost IDENTIFIED BY 'pupsimspass_123';

/* Grant privileges to the database */
GRANT ALL PRIVILEGES ON pupsims_db.* TO pupsims@localhost;
