

# zad 2
DROP PROCEDURE IF EXISTS usp_get_employees_salary_above;
DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above (target_salary DECIMAL (19,4))
BEGIN

SELECT first_name,last_name 
FROM employees
WHERE `salary` >= target_salary
ORDER BY first_name,last_name,employee_id;

END $$
DELIMITER ;

CALL usp_get_employees_salary_above (45000);

SELECT first_name,last_name 
FROM employees
WHERE `salary` >= 45000
ORDER BY first_name,last_name,employee_id;



#zad 3

SELECT `name` 
FROM `towns`
WHERE `name` LIKE CONCAT('b','%')
ORDER BY `name`;


DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with(letter VARCHAR(20))
BEGIN

SELECT `name` 
FROM `towns`
WHERE `name` LIKE CONCAT(letter,'%')
ORDER BY `name`;

END $$
DELIMITER ;

CALL usp_get_towns_starting_with('b');

#zad 4

DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town(name_town_for_check VARCHAR(50))
BEGIN

SELECT e.first_name,e.last_name
FROM `towns` AS t
JOIN  `addresses` AS a
ON t.town_id=a.town_id
JOIN `employees` AS e
ON a.address_id=e.address_id
WHERE t.`name`= name_town_for_check
ORDER BY e.first_name,e.last_name,e.employee_id;

END $$
DELIMITER ;

CALL usp_get_employees_from_town('Sofia');

SELECT e.first_name,e.last_name
FROM `towns` AS t
JOIN  `addresses` AS a
ON t.town_id=a.town_id
JOIN `employees` AS e
ON a.address_id=e.address_id
WHERE t.`name`= 'Sofia'
ORDER BY e.first_name,e.last_name,e.employee_id;



#zad 5 

DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(salary_for_check DECIMAL(19,4))
RETURNS VARCHAR(10)
DETERMINISTIC
BEGIN
 
 return (
	CASE
    WHEN salary_for_check <30000 THEN 'Low'
    WHEN salary_for_check BETWEEN 30000 AND 50000 THEN 'Avarage'
    WHEN salary_for_check >50000 THEN 'High'
	END
 );
 
END $$
DELIMITER ;

SELECT ufn_get_salary_level(13500.00);


SELECT `salary`
FROM `employees`
WHERE `salary`= (
	CASE 
		WHEN `salary` <30000 THEN 'Low'
		WHEN `salary` BETWEEN 30000 AND 50000 THEN'Average'
		WHEN `salary` >50000 THEN 'High'
	END
);


#zad 6

DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level (level_of_salary VARCHAR(10))
BEGIN

SELECT first_name,last_name
FROM employees
WHERE  ufn_get_salary_level(`salary`) = level_of_salary
ORDER BY first_name DESC, last_name DESC;

END $$
DELIMITER ;

CALL usp_get_employees_by_salary_level('High');


SELECT first_name,last_name
FROM employees
WHERE  ufn_get_salary_level(`salary`) >'High'
ORDER BY first_name DESC, last_name DESC;


#zad 11

#ufn_calculate_future_value`(sum_function DECIMAL(19,4), interest_rate DOUBLE(19,4),n_year INT)
# RETURNS decimal(19,4)

SELECT a.id, ah.first_name, ah.last_name,a.balance,
ufn_calculate_future_value(a.balance,0.1,5)
FROM account_holders AS ah
JOIN accounts AS a
USING (`id`);

DELIMITER $$
CREATE PROCEDURE usp_calculate_future_value_for_account(number_of_id INT, interest_rate DECIMAL(10,4))
BEGIN

SELECT a.id AS account_id, 
ah.first_name,
ah.last_name,
a.balance AS current_balance,
ufn_calculate_future_value(a.balance,interest_rate,5) AS balance_in_5_years
FROM account_holders AS ah
JOIN accounts AS a
USING (`id`)
WHERE a.id=number_of_id;

END $$
DELIMITER ;

CALL usp_calculate_future_value_for_account(1,0.1);


#zad 12

DELIMITER $$
CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount(19,4))
BEGIN



END 
DELIMITER ;


