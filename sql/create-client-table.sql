CREATE DATABASE 'customer;
USE customer;

create table client (
	id int(5) NOT NULL AUTO_INCREMENT,
    lastName varchar(100) NOT NULL,
    firstName varchar(100) NOT NULL,
    middleInitial varchar(10),
    birthDate  ,
    gender varchar(3),
    ssn varchar(11),
    mailAddress varchar(200),
    PRIMARY KEY (id)
);

