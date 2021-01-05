 SELECT concat_ws(' ', `first_name`, `middle_name`,`last_name`) AS 'Full_name'
 FROM employees ;
 
 CREATE VIEW v_full_name_and_salary AS
 SELECT `first_name`, `last_name`,`salary`
 FROM soft_uni.employees;
 
 SELECT salary FROM `v_full_name_and_salary`;
 
 SELECT `first_name`,`last_name`,`salary` FROM soft_uni.`employees`;
 
 #zad 1
SELECT * FROM `departments`;
 
 #zad 2
SELECT `name` FROM `departments`
ORDER BY `department_id`;

#zad 3
SELECT `first_name`, `last_name`, `salary` FROM `employees`;

#zad 4
SELECT `first_name`, `middle_name`, `last_name` FROM `employees`;

#zad 5
SELECT concat(`first_name`,'.', `last_name`,'@softuni.bg')
AS 'full_email_addres'
FROM `employees`;

#zad 6
SELECT DISTINCT `salary` FROM `employees`;

#zad 7
SELECT * FROM `employees`
WHERE `job_title` = 'Sales Representative'
ORDER BY `employee_id`;

#zad 8
SELECT `first_name`,`last_name`,`job_title` FROM `employees`
WHERE `salary` BETWEEN 20000 AND 30000;
-- WHERE `salary` >= 20000 AND `salary`<=30000;      vtori na4in


#zad 9
SELECT concat_ws(' ',`first_name`,`middle_name`,`last_name`) 
AS `full_name`
FROM `employees`
WHERE `salary` =25000 OR `salary` =14000 OR`salary` =12500 OR`salary` =23600;
-- WHERE `salary` IN (25000,14000,12500,23600);  vtori na4in

#zad 10
SELECT `first_name`,`last_name` FROM `employees`
WHERE manager_id IS NULL;

#zad 11
SELECT `first_name`,`last_name`,`salary` FROM `employees`
WHERE `salary`>50000
ORDER BY `salary` DESC;

#zad 12
SELECT `first_name`, `last_name` FROM `employees`
-- WHERE `salary` moje i s tova
ORDER BY `salary` DESC
LIMIT 5;

#zad 13
SELECT `first_name`, `last_name` FROM `employees`
WHERE `department_id` NOT IN (4);
#WHERE `department_id` != 4 tova stava samo za edna stoinost

#zad 14
SELECT * FROM `employees`
ORDER BY `salary` DESC, `first_name`, `last_name` DESC,`middle_name`;

#zad 15
CREATE VIEW v_employees_salaries AS
SELECT `first_name`,`last_name`,`salary`
FROM `employees`;

#zad 16
CREATE VIEW `v_employees_job_titles` AS
SELECT concat_ws(' ',`first_name`,`middle_name`,`last_name`) AS `full_name`, `job_title`
FROM `employees`;

#zad 17
SELECT DISTINCT `job_title` FROM `employees`
ORDER BY `job_title`;

#zad 18
SELECT *FROM `projects`
ORDER BY `start_date`,`name`
LIMIT 10;

#zad 19
SELECT `first_name`,`last_name`,`hire_date` FROM `employees`
ORDER BY `hire_date` DESC
LIMIT 7;

#zad 20
UPDATE `employees`
SET `salary` = `salary`*1.12
WHERE `department_id` IN (1,2,4,11);
SELECT `salary` FROM `employees`;






#zad 21
SELECT peak_name FROM peaks
ORDER BY `peak_name`;

#zad 22
SELECT `country_name`,`population` FROM `countries`
WHERE `continent_code` = 'EU'
ORDER BY `population` DESC,`country_name`
LIMIT 30;

#zad 23 - VAJNO SORTIRANE!!!!! 
SELECT `country_name`, `country_code`,
IF(`currency_code`= 'EUR','Euro','Not Euro') AS 'currency'
FROM `countries`
ORDER BY `country_name`;


#zad 24
SELECT `name` FROM diablo.characters
ORDER BY `name`;
