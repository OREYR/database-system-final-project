create database insurance_claim;

use insurance_claim;

create table client (
    id int(5) not null auto_increment,
    lastName varchar(100) not null,
    firstName varchar(100) not null,
    middleInitial varchar(10),
    birthDate varchar(50),
    age int(50),
    gender varchar(3),
    ssn varchar(11),
    mailAddress varchar(200),
    fraudRate decimal(4,3),
    primary key (id)
);

create table claim_client_relation (
    id int(5) not null auto_increment,
    clientId int(5),
    age int(50),
    race varchar(20),
    state varchar(20),
    county varchar(20),
    diseaseCode int(500),
    claimStartDt varchar(50),
    claimEndDt varchar(50),
    provider varchar(100),
    annualReimbursementAmt double,
    annualDeductibleAmt double,
    potentialFraudRate decimal(4,3),
    primary key (id),
    constraint fk_category
    foreign key (clientID) 
        references client(id)
);
    


