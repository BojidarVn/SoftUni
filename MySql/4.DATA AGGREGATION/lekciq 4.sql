SELECT `department_id`,
		ROUND(SUM(`salary`),2) AS `Salary Sum` FROM `employees`
GROUP BY `department_id`
ORDER BY `department_id`;

SELECT `department_id`, ROUND(AVG(`salary`),2) AS `Salary Sum` FROM `employees`
GROUP BY `department_id`
ORDER BY `department_id`;

#zad 1 LAB
USE `restaurant`;
SELECT `department_id`, COUNT(`id`) AS `Number of employees`
FROM `employees`
GROUP BY `department_id`
ORDER BY `department_id`;

#dryga versiq na purva zad 
USE `restaurant`;
SELECT `department_id`, COUNT(`id`) AS `Number of employees`
FROM `employees`
GROUP BY `department_id`
ORDER BY COUNT(`id`);

#vtori na4in na gornata zaqvka 
USE `restaurant`;
SELECT `department_id`, COUNT(`id`) AS `Number of employees`
FROM `employees`
GROUP BY `department_id`
ORDER BY `Number of employees`;


#tova e su6toto kato SELECT * FROM no 6te izkara taka vsi4ki a dolnoto pokazva kolko reda ima cqlata tablica kato 4islo
SELECT COUNT(`employee_id`) FROM `soft_uni`.`employees`;

SELECT `department_id`, COUNT(DISTINCT `salary`) AS `Number of salaries`
FROM `employees`
GROUP BY `department_id`
ORDER BY `department_id` DESC;

#zad 2
SELECT `department_id`,
ROUND(AVG(`salary`),2) AS `Average Salary`
FROM `employees`
GROUP BY `department_id`
ORDER BY `department_id`;

#zad 3
SELECT `department_id`,
ROUND(MIN(`salary`),2) AS `Min Salary`
FROM `employees`
GROUP BY `department_id`
HAVING `Min Salary`>800
ORDER BY `department_id`;

#zad 4
SELECT COUNT(*) AS 'Count'
 FROM `products`
WHERE `category_id` =2
AND `price` >8;

#zad 5
SELECT `category_id`,
ROUND(AVG(`price`),2) AS `Average Price`,
ROUND(MIN(`price`),2) AS `Cheapest Product`,
ROUND(MAX(`price`),2) AS `Most Expensive Product`
FROM `products`
GROUP BY `category_id`;

#dopulnitelna zada4a
ALTER TABLE `products`
ADD COLUMN `country` VARCHAR(30) NULL default 'Italy' /* AFTER `price` - tova pole ne e zaduljitelno 
													i kazva kude da se zapishe poleto country */ ;

SELECT `category_id`,`country`,
COUNT(`price`) AS `Number of Products`,
ROUND(AVG(`price`),2) AS `Averige Price`
FROM `products`
GROUP BY `category_id`,`country`
HAVING `Number of Products` >= 2;

SELECT `country`,
	COUNT(`price`) AS `Number of Products`,
	ROUND(SUM(`price`),2) AS `Total Price`
FROM `products`
GROUP BY `country`  WITH ROLLUP
HAVING `Number of Products` >= 2;














