--create data base
CREATE DATABASE EtudiantDB;
--create user
CREATE USER 'EtudiantAdmin'@localhost IDENTIFIED BY 'admin';
--check if the user create with
SELECT User FROM mysql.user;
--grand all privale of all tables to user
GRANT ALL PRIVILEGES ON *.* TO 'EtudiantAdmin'@localhost IDENTIFIED BY 'admin';
--grand all privaleges of specifi table ro user
GRANT ALL PRIVILEGES ON EtudiantDB.* TO 'EtudiantAdmin'@localhost;
--Refresh the privileges
FLUSH PRIVILEGES;
--o verify the right permissions you just granted to the user
SHOW GRANTS FOR 'EtudiantAdmin'@localhost;
--if you want to remove user
DROP USER 'EtudiantAdmin'@localhost;
