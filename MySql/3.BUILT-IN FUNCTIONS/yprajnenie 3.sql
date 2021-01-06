SELECT SUBSTRING('Softuni',4,3);
SELECT SUBSTRING('Softuni' FROM 4 FOR 3);

#zad 1
SELECT `first_name`,`last_name` FROM `employees`
WHERE LEFT(`first_name`,2) ='Sa'
ORDER BY `employee_id`;

#zad 1 II na4in
SELECT `first_name`,`last_name` FROM `employees`
WHERE SUBSTRING(`first_name`,1,2) ='Sa'
ORDER BY `employee_id`;

#zad 2
SELECT `first_name`,`last_name` FROM `employees`
WHERE `last_name` LIKE '%ei%'
ORDER BY `employee_id`;

#zad 3
SELECT `first_name` FROM `employees`
WHERE `department_id` IN (3,10) 
AND YEAR (`hire_date`) BETWEEN 1995 AND 2005
ORDER BY `employee_id`;

#3 II na4in
SELECT `first_name` FROM `employees`
WHERE `department_id`=3 OR `department_id`= 10 
AND `hire_date`>= 1995 OR `hire_date`<=2005
ORDER BY `employee_id`;

#zad 4
SELECT `first_name`,`last_name` FROM `employees`
WHERE `job_title` NOT LIKE '%engineer%'
ORDER BY `employee_id`;

#zad 5
SELECT `name` FROM `towns` 
WHERE CHAR_LENGTH(`name`) IN (5,6)
ORDER BY `name`;

#zad 5 II na4in
SELECT `name` FROM `towns` 
WHERE CHAR_LENGTH(`name`) >=5 AND CHAR_LENGTH(`name`) <=6
ORDER BY `name`;

#zad 5 III na4in
SELECT `name` FROM `towns` 
WHERE CHAR_LENGTH(`name`) BETWEEN 5 AND 6
ORDER BY `name`;

#zad 6
SELECT * FROM `towns`
WHERE LEFT(`name`,1) IN ('M', 'K', 'B', 'E' )
ORDER BY `name`;

#zad 6 II
SELECT * FROM `towns`
WHERE SUBSTRING(`name`,1,1) IN ('M', 'K', 'B', 'E' )
ORDER BY `name`;

#zad 7
SELECT * FROM `towns`
WHERE LEFT(`name`,1) NOT IN ('R', 'B', 'D')
ORDER BY `name`;

#zad 8
CREATE VIEW v_employees_hired_after_2000 AS
SELECT `first_name`,`last_name` FROM `employees`
WHERE YEAR(`hire_date`) >2000;

SELECT * FROM `v_employees_hired_after_2000`;

#zad 9
SELECT `first_name`,`last_name` FROM `employees`
WHERE CHAR_LENGTH(`last_name`) =5;

#zad 10
SELECT `country_name`,`iso_code` FROM `countries`
WHERE `country_name` LIKE '%A%A%A%'
ORDER BY `iso_code`;

#zad 11
SELECT p.`peak_name`,r.`river_name`,
LOWER(CONCAT(`peak_name`, SUBSTRING(`river_name`,2))) AS 'mix' 
FROM `peaks` AS p, `rivers` AS r
WHERE RIGHT(`peak_name`,1) = LEFT(`river_name`,1);

#zad 12
SELECT `name`, date_format(`start`, '%Y-%m-%d') AS `start`
FROM `games`
WHERE LEFT (`start`,4) IN (2011, 2012)
ORDER BY `start`,`name`
LIMIT 50;






#zad 13
SELECT `user_name`, 
SUBSTRING(`email` , LOCATE('@',`email`) +1)  AS `provider` 
FROM `users`
ORDER BY  `provider`,`user_name` ; 



#zad 14
SELECT `user_name`, `ip_address` FROM `users`
WHERE `ip_address` LIKE "___.1%.%.___"
ORDER BY `user_name`;

#zad 15
SELECT `name`,
(CASE 
WHEN HOUR(`start`) BETWEEN 0 AND 11 THEN 'Morning'
WHEN HOUR(`start`) BETWEEN 12 AND 17 THEN 'Afternoon'
ELSE 'Evening'
END
) AS 'Part of the Day',
(
 CASE 
 WHEN `Duration` BETWEEN 0 AND 3 THEN 'Extra Short'
 WHEN `Duration` BETWEEN 4 AND 6 THEN 'Short'
 WHEN `Duration` BETWEEN 7 AND 10 THEN 'Long'
 ELSE 'Extra Long'
 END
) AS 'Duration'
FROM `games`;


/*  SELECT `name`, date_format(`start`, '%Y-%m-%d') AS `start`
FROM `games`
WHERE LEFT (`start`,4) IN (2011, 2012)
ORDER BY `start`,`name`
LIMIT 50;  */


#zad 16

SELECT `product_name`,`order_date`,
 ADDDATE(`order_date`, INTERVAL 3 DAY) AS `pay_due`,
 ADDDATE(`order_date`, INTERVAL 1 MONTH) AS `deliver_due`
FROM `orders`;

 


	


