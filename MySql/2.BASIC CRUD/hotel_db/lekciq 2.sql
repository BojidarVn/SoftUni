/* zada4a 1 ot lekcii
SELECT `id`, `first_name`, `last_name`, `job_title` FROM `employees`
ORDER BY `id` ;  */

 /* zada4a 2 ot lekcii  concat(`first_name`,' ', `last_name`) dva razli4ni zapisa na edno ne6to 
SELECT `id`,            concat_ws(' ',`first_name`, `last_name`) AS `full_name`,
`job_title` AS `Job Title`, `salary` FROM `employees` 
WHERE `salary` >1000;   */


# SELECT DISTINCT `last_name`, `salary` FROM `employees`
# WHERE `salary`<= 1500

/* SELECT * FROM `employees`  
WHERE `department_id` IN (1,4) AND `salary`>=1500; */

/*
SELECT * FROM `employees`
WHERE `department_id` IN (1,4) AND `salary` BETWEEN 900 AND 1600; */

ALTER TABLE `employees` ADD COLUMN `manager_id` INT;

UPDATE `employees`
SET `manager_id` = 1
WHERE `id` != 1;

SELECT `id`, `first_name`, `last_name`, `manager_id`,`salary`
FROM `employees`
WHERE `manager_id` IS NOT NULL
ORDER BY `salary` DESC;

#tyka q suszdavame
CREATE VIEW `employees_name_and_salary` AS 
SELECT `id`,concat_ws(' ',`first_name`, `last_name`) AS `full_name`, 
`salary` FROM `employees`;

#tyka q promenqme s ALTER
ALTER VIEW `employees_name_and_salary` AS 
SELECT `id`,concat_ws(' ',`first_name`, `last_name`) AS `full_name`, 
`salary` FROM `employees`
ORDER BY `department_id`;

SELECT * FROM `employees_name_and_salary`;

CREATE VIEW `v_top_paid_employee` AS 
SELECT * FROM `employees` 
ORDER BY `salary` DESC 
LIMIT 1;

SELECT * FROM `v_top_paid_employee`;

CREATE TABLE `employees_salary` AS 
SELECT `id`, concat_ws(' ',`first_name`,`last_name`) AS `full_name`, `salary`
FROM `emploees` ORDER BY `salary` DESC;











