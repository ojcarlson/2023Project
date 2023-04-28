/*
Olaf Carlson
ocarlson@iu.edu
Spring 2023 Project
Indiana University Southeast
This file demonstrates mySQL commands to create mySQL database, to Insert and Delete

 */

CREATE TABLE loginPassword (
                               login varchar(255),
                               password varchar(255));

INSERT INTO loginPassword (login, password) VALUES ('oc9243', 'LillyMarie1!!!!');
INSERT INTO loginPassword (login, password) VALUES ('dg9999', 'JacobLilly2');
INSERT INTO loginPassword (login, password) VALUES ('jg9999', 'JacobTitus1');

DELETE FROM loginPassword WHERE login = 'oc9243'AND password = 'LillyMarie1!!!!';