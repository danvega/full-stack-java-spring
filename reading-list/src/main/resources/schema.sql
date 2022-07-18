-- noinspection SqlNoDataSourceInspectionForFile

-- noinspection SqlDialectInspectionForFile

DROP TABLE IF EXISTS book;

CREATE TABLE book(
    id SERIAL NOT NULL PRIMARY KEY,
    title varchar(255) NOT NULL,
    pages int NOT NULL,
    author varchar(255) NOT NULL,
    status varchar(20) NOT NULL
);