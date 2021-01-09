#zad 1 
SELECT `employee_id` AS id,
CONCAT_WS(' ',`first_name`,`last_name`) AS name,
d.`department_id`,
`name` AS `department_name`
FROM `departments` AS d
JOIN `employees` AS e
ON d.`manager_id`=e.`employee_id`
ORDER BY `employee_id`
LIMIT 5;

#zad 4

SELECT COUNT(`employee_id`) AS count FROM `employees`
WHERE `salary` >(
SELECT AVG(`salary`) FROM `employees` );


#razshirenie na 4ta zad
SELECT `employee_id`, CONCAT_WS(' ',`first_name`,`last_name`) AS name , `salary`
 FROM `employees`
WHERE `salary` >(
SELECT AVG(`salary`) FROM `employees` );


#zad 2
SELECT a.`town_id`,t.`name` AS 'town_name',a.`address_text`
FROM `addresses` AS a, `towns` AS t
WHERE  a.town_id=t.town_id AND name IN ('San Francisco', 'Sofia', 'Carnation')
ORDER BY t.town_id;

#vtori na4in s JOIN
SELECT a.`town_id`,t.`name` AS 'town_name',a.`address_text`
FROM `addresses` AS a
JOIN `towns` AS t
ON  a.town_id=t.town_id AND name IN ('San Francisco', 'Sofia', 'Carnation')
ORDER BY t.town_id;


#zad 3

SELECT `employee_id`, `first_name`, `last_name`, d.`department_id` , `salary`
FROM `employees` AS e
JOIN `departments` AS d
ON e.`department_id` = d.`department_id`
WHERE e.`manager_id` IS NULL;


# dopulnitelni zada4i
SELECT e.`employee_id` id,e.first_name,e.last_name, d.`name` department, a.address_text AS addres, t.`name` AS town
FROM `departments` AS d
JOIN `employees` AS e
ON d.department_id=e.department_id
JOIN `addresses` a ON e.address_id=a.address_id
JOIN `towns` AS t ON a.town_id=t.town_id
ORDER BY e.employee_id;

#sega s WHERE kato gornata
SELECT e.`employee_id` id,e.first_name,e.last_name, d.`name` department, a.address_text AS addres, t.`name` AS town
FROM `departments` AS d,
`employees` AS e,
`addresses` a,
`towns` AS t 
WHERE d.department_id=e.department_id AND e.address_id=a.address_id AND a.town_id=t.town_id
ORDER BY e.employee_id;


#zad s index

CREATE INDEX ind_employees_job_title
ON employees(`job_title`);

DROP INDEX ind_employees_job_title
ON employees;






