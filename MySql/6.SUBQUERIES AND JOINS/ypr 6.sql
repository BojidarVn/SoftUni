#zad 1
SELECT e.employee_id,e.job_title,a.`address_id`,a.`address_text`
FROM `employees` AS e
JOIN addresses AS a
ON e.address_id=a.address_id
ORDER BY address_id
LIMIT 5;

#zad 2

SELECT e.first_name, e.last_name,t.`name` AS town,a.address_text
FROM `employees` AS e
JOIN `addresses` AS a
ON e.address_id=a.address_id
JOIN `towns` AS t
ON a.town_id=t.town_id
ORDER BY first_name,last_name
LIMIT 5;

#zad 3
SELECT e.employee_id, e.first_name,e.last_name,d.`name` AS department_name
FROM `employees` AS e
JOIN departments AS d
ON e.department_id=d.department_id
WHERE d.name = 'sales' 
ORDER BY e.employee_id DESC;

#zad 3 bez join
SELECT e.employee_id, e.first_name,e.last_name, 'Sales' 
FROM `employees` AS e
WHERE department_id = 3
ORDER BY e.employee_id DESC;

#zad 4
SELECT 
    e.employee_id,
    e.first_name,
    e.salary,
    d.`name` AS department_name
FROM
    employees AS e
        JOIN
    departments AS d
    ON e.department_id = d.department_id
WHERE
    e.salary > 15000
ORDER BY d.department_id DESC
LIMIT 5;

#zad 5 s vlojena zaqvka
SELECT e.employee_id,e.first_name
FROM `employees` AS e
WHERE e.employee_id NOT IN(SELECT employee_id FROM employees_projects)
ORDER BY e.employee_id DESC
LIMIT 3;

/* tova e vlojenata zaqvka za gornata zada4a
SELECT employee_id FROM employees_projects; */
#zad 5 s join
SELECT  e.employee_id,e.first_name
FROM employees e
LEFT JOIN employees_projects AS ep
ON ep.employee_id=e.employee_id
WHERE ep.project_id IS NULL
ORDER BY e.employee_id DESC
LIMIT 3;


#zad 6
SELECT e.first_name,e.last_name,e.hire_date,d.`name` AS dept_name
FROM employees AS e
JOIN departments AS d
ON e.department_id=d.department_id
WHERE DATE( e.hire_date) > '1999-01-01' 
AND d.name IN ('Sales', 'Finance')
ORDER BY hire_date;


#zad 7
SELECT e.employee_id,e.first_name, p.`name` AS project_name
FROM employees e
JOIN employees_projects AS ep
ON e.employee_id=ep.employee_id
JOIN projects AS p
ON ep.project_id=p.project_id
WHERE DATE ( p.start_date) > 2002-08-13 
AND DATE (p.end_date) IS NULL
ORDER BY e.first_name, p.`name`
LIMIT 5;


#zad 8
SELECT e.employee_id,e.first_name,
IF(YEAR(p.`start_date`)<2005,p.`name`,NULL) AS 'project_name'
FROM employees AS e
JOIN employees_projects AS ep
ON e.employee_id=ep.employee_id
JOIN projects AS p
ON ep.project_id=p.project_id
WHERE e.employee_id = 24
ORDER BY `project_name`;


#zad 17

SELECT 
    c.country_name,
    MAX(p.elevation) AS 'highest_peak_elevation',
    MAX(r.length) AS 'longest_river_length'
FROM
    countries AS c
        JOIN
    countries_rivers AS cr ON c.country_code = cr.country_code
        JOIN
    rivers AS r ON cr.river_id = r.id
        JOIN
    mountains_countries AS mc ON c.country_code = mc.country_code
        JOIN
    mountains AS m ON mc.mountain_id = m.id
        JOIN
    peaks AS p ON m.id = p.mountain_id
GROUP BY c.country_name
ORDER BY `highest_peak_elevation` DESC , `longest_river_length` DESC , country_name
LIMIT 5;

/*
#zad 16
SELECT  COUNT(c.country_code != (SELECT country_code FROM  mountains_countries) )  AS blq    #c.country_code,m.mountain_range, mc.country_code
FROM countries AS c
JOIN mountains_countries AS mc
ON mc.country_code=c.country_code
JOIN mountains AS m
ON m.id=mc.mountain_id
GROUP BY m.mountain_range;

SELECT country_code FROM  mountains_countries; */


#zad 16
SELECT COUNT(c.country_code) FROM countries AS c
LEFT JOIN mountains_countries AS mc
ON c.country_code=mc.country_code
WHERE mc.mountain_id IS NULL;

SELECT COUNT(*) FROM countries AS c
LEFT JOIN mountains_countries AS mc
ON c.country_code=mc.country_code
WHERE mc.mountain_id IS NULL;


#zad 9
SELECT e.employee_id, e.first_name,e.manager_id,
( IF(e.manager_id=7,(SELECT first_name
FROM employees
WHERE employee_id=7)  ,(SELECT first_name
FROM employees
WHERE employee_id=3)) ) AS manager_name
FROM `employees` AS e
WHERE e.manager_id IN (3,7)
ORDER BY e.first_name;

#zad 9 vtori na4in PRAVILNIQ !!!

SELECT e.employee_id, e.first_name,e2.manager_id,e2.first_name AS `manager_name` FROM employees AS e
JOIN employees AS e2
ON e2.employee_id=e.manager_id
WHERE e.manager_id IN (3,7)
ORDER BY e.first_name;

/*
 IF(e.manager_id=7,(SELECT first_name
FROM employees
WHERE employee_id=7)  ,(SELECT first_name
FROM employees
WHERE employee_id=3)) 

SELECT first_name
FROM employees
WHERE employee_id=3; */

#zad 10

SELECT e.employee_id, CONCAT(e.`first_name`,' ',e.`last_name`) AS 'employee_name',
CONCAT(e2.`first_name`,' ',e2.last_name) AS 'manager_name',
d.`name` AS 'department_name'
FROM employees AS e
JOIN employees AS e2
ON e2.employee_id=e.manager_id
JOIN departments AS d
ON d.department_id=e.department_id
ORDER BY e.employee_id
LIMIT 5;


#zad 11

SELECT AVG(`salary`) AS min_average_salary
FROM employees AS e
GROUP BY department_id
ORDER BY `min_average_salary`
LIMIT 1;

#zad 11 vtori na4in

SELECT MIN(min_average_salary) AS min_average_salary
FROM
(
   SELECT AVG(`salary`) AS min_average_salary
   FROM employees
   GROUP BY department_id
) AS min_salary;

#zad 12

SELECT c.country_code, m.mountain_range, p.peak_name, p.elevation
FROM countries AS c
JOIN mountains_countries AS mc
ON mc.country_code=c.country_code
JOIN mountains AS m
ON m.id=mc.mountain_id
JOIN peaks AS p
ON p.mountain_id=mc.mountain_id
WHERE p.elevation > 2835 AND 
c.country_code = 'BG'
ORDER BY p.elevation DESC;


#zad 13

SELECT c.country_code, COUNT(m.mountain_range) AS `mountain_range`
FROM countries AS c
JOIN mountains_countries AS mc
ON mc.country_code=c.country_code
JOIN mountains AS m
ON m.id=mc.mountain_id
WHERE c.country_code IN ('BG', 'RU','US')
GROUP BY c.country_code
ORDER BY `mountain_range` DESC;

#zad 14

SELECT c.country_name,r.river_name 
FROM countries AS c
LEFT JOIN countries_rivers AS cr
ON cr.country_code=c.country_code
LEFT JOIN rivers AS r
ON r.id=cr.river_id 
WHERE c.continent_code ='AF'
ORDER BY c.country_name
LIMIT 5;







