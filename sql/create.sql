create table MEMBER (
    MEMBER_ID bigint primary key auto_increment,
    MEMBER_NAME varchar(20) unique not null,
    EMAIL varchar(100) unique not null,
    PASSWORD varchar(255) not null,
    ROLE varchar(4) not null,
    INS_TIME timestamp not null,
    UPD_TIME timestamp not null,
    INS_USER_EMAIL varchar(100) not null,
    UPD_USER_EMAIL varchar(100) not null
);

create table BOOK (
    BOOK_ID bigint primary key auto_increment,
    TITLE varchar(255) not null,
    AUTHOR varchar(100) not null,
    PUBLISHER varchar(255) not null,
    ISSUE_DATE timestamp not null,
    INS_TIME timestamp not null,
    UPD_TIME timestamp not null,
    INS_USER_EMAIL varchar(100) not null,
    UPD_USER_EMAIL varchar(100) not null
);

create table LIBRARY (
    LIBRARY_ID bigint primary key auto_increment,
    BOOK_ID bigint not null,
    INS_TIME timestamp not null,
    UPD_TIME timestamp not null,
    INS_USER_EMAIL varchar(100) not null,
    UPD_USER_EMAIL varchar(100) not null,
    foreign key(BOOK_ID) references BOOK(BOOK_ID)
);

create table RENTAL (
    RENTAL_ID bigint primary key auto_increment,
    MEMBER_ID bigint not null,
    LIBRARY_ID bigint not null,
    INS_TIME timestamp not null,
    UPD_TIME timestamp not null,
    INS_USER_EMAIL varchar(100) not null,
    UPD_USER_EMAIL varchar(100) not null,
    foreign key(MEMBER_ID) references MEMBER(MEMBER_ID),
    foreign key(LIBRARY_ID) references LIBRARY(LIBRARY_ID)
);
