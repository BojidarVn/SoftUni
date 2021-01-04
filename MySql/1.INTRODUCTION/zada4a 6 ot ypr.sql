CREATE TABLE `people` (
 `id` INT UNIQUE PRIMARY KEY AUTO_INCREMENT NOT NULL,
 `name` VARCHAR(200) NOT NULL,
 `picture` BLOB,
 `height` DOUBLE(6,2),
 `weight` DOUBLE(4,2),
 `gender` CHAR(1) NOT NULL,
 `birthday` DATE NOT NULL,
 `biography` TEXT
);

INSERT INTO `people` (`id`,`name`,`picture`, `height`, `weight`, `gender`, `birthday`, `biography`)
VALUES
(1,'Toshko','sad',1.21,3.42,'m','2001-10-11','fdsfarrdfsf'),
(2,'Goshka','asd',3.21,4.41,'f','2011-11-22','gggeww'),
(3,'Pesho','aaa',3.91,4.11,'m','2011-01-10','wwwww'),
(4,'Kiko','ddd',1.91,1.11,'m','2011-02-08','aaaaaaa'),
(5,'Jivko','qqq',11.11,12.11,'m','2009-03-02','fffffffffff');
