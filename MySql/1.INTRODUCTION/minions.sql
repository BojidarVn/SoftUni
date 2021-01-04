SELECT * FROM minions.minions;

-- ALTER TABLE `minions`
-- ADD COLUMN `town_id` INT;

 -- ALTER TABLE `minions`
-- ADD CONSTRAINT fk_minions_towns
-- FOREIGN KEY (`town_id`)
-- REFERENCES `towns` (`id`);

USE `minions`;
INSERT INTO `towns` (`id`,`name`)
VALUES
(1,'Sofia'), (2,'Plovdiv'), (3,'Varna');


USE `minions`;
 INSERT INTO `minions` (`id`,`name`,`age`,`town_id`)
 VALUES
 (1,'Kevin',22,1),
 (2,'Bob',15,3),
 (3,'Steward',NULL,2); 
 
 TRUNCATE `minions`;
 
 DROP TABLE `minions`;
 DROP TABLE `towns`;