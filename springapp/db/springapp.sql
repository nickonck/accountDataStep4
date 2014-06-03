CREATE DATABASE springapp;

GRANT ALL ON springapp.* TO springappuser@'%' IDENTIFIED BY 'pspringappuser';
GRANT ALL ON springapp.* TO springappuser@localhost IDENTIFIED BY 'pspringappuser';

USE springapp;

CREATE TABLE accounthandlers (
	Id BIGINT PRIMARY KEY AUTO_INCREMENT,
	bank varchar(4),
	office varchar(4),
	dc varchar(2),
	accountnumber varchar(10)
);


CREATE TABLE accounts (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
	accountHandler BIGINT,
		FOREIGN KEY (id)
		REFERENCES accountHandlers(Id)
			ON DELETE CASCADE
			ON UPDATE CASCADE,
    balance decimal(15 , 2 ),
    maxOverdraft decimal(15 , 2 )
);


CREATE TABLE clients (
	dni varchar(9) PRIMARY KEY,
	name varchar(50),
	account BIGINT, CONSTRAINT
		FOREIGN KEY (account)
		REFERENCES accounts(id)
			ON DELETE CASCADE
			ON UPDATE CASCADE
);


