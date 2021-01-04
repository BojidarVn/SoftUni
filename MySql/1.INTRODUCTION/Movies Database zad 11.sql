DROP SCHEMA IF EXISTS `movies`;
CREATE SCHEMA `movies` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci ;
USE movies;

CREATE TABLE `directors` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`directors_name` VARCHAR(30) NOT NULL,
`notes` BLOB	
);

CREATE TABLE `genres` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`genre_name` VARCHAR(30) NOT NULL,
`notes` BLOB
);

CREATE TABLE `categories` (
`id` INT PRIMARY KEY AUTO_INCREMENT ,
`category_name` VARCHAR(30) NOT NULL,
`notes` BLOB
);

CREATE TABLE `movies` (
id INT PRIMARY KEY AUTO_INCREMENT,
tittle VARCHAR(30) NOT NULL,
director_id INT NOT NULL,
copyright_year DATETIME NOT NULL,
length INT NOT NULL,
genre_id INT NOT NULL,
category_id INT NOT NULL,
rating INT,
notes BLOB
);

INSERT INTO directors (id,directors_name)
VALUES
(1, 'blq blq blq'),
(2, 'op op'),
(3, 'la la la'),
(4, 'chick chick'),
(5, 'bob bob');

INSERT INTO genres (id,genre_name)
VALUES
(1,'offf'),
(2,'ahii'),
(3,'cherno'),
(4,'bqlo'),
(5,'zeleno');

INSERT INTO categories (id,category_name)
VALUES
(1,'qdene'),
(2,'piine'),
(3,'hodene'),
(4,'kopane'),
(5,'kachvane');

INSERT INTO movies (id, tittle, director_id, copyright_year, length, genre_id, category_id, rating)
VALUES
(1,'dasf',2,'1999-06-19',123,1,4,22),
(2,'dasf',2,'1999-06-19',123,1,4,22),
(3,'dasf',2,'1999-06-19',123,1,4,22),
(4,'dasf',2,'1999-06-19',123,1,4,22),
(5,'dasf',2,'1999-06-19',123,1,4,22);




