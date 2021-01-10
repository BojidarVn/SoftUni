#zad 1

DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above_35000 ()
BEGIN

SELECT first_name, last_name
FROM `employees`
WHERE `salary` > 35000
ORDER BY first_name, last_name, employee_id;

END $$
DELIMITER ;

CALL usp_get_employees_salary_above_35000 ();

SELECT first_name, last_name
FROM `employees`
WHERE `salary` >= 35000
ORDER BY first_name, last_name, employee_id;





#zad 2

DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above(min_salary DECIMAL(19,4))
BEGIN

	SELECT first_name,last_name  FROM employees
	WHERE `salary` >= min_salary
	ORDER BY first_name,last_name, employee_id ;

END $$
DELIMITER ;

CALL usp_get_employees_salary_above(45000);


/* pomo6t kum gornata procedure
SELECT first_name,last_name  FROM employees
WHERE `salary` >= 45000
ORDER BY first_name,last_name, employee_id DESC;     */


#zad 3

DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with(start_str VARCHAR(20))
BEGIN

SELECT `name` FROM towns
WHERE `name` LIKE CONCAT(start_str,'%' )
ORDER BY `name`;

END $$
DELIMITER ; 

CALL usp_get_towns_starting_with('b');
/* pomo6tni zaqvki
SELECT `name` FROM towns
WHERE `name` like 'b%'
ORDER BY `name`; */


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



#zad 5

DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(e_salary DECIMAL)
RETURNS VARCHAR(10)
DETERMINISTIC
BEGIN

	RETURN (CASE 
    WHEN e_salary <30000 THEN 'Low'
    WHEN e_salary BETWEEN 30000 AND 50000 THEN 'Average'
    WHEN e_salary > 50000 THEN 'High'
    END
    );
END $$
DELIMITER ;

SELECT ufn_get_salary_level(50001);


#zad 6


DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level (s_level VARCHAR(10))
BEGIN

	SELECT first_name, last_name FROM employees
	WHERE ufn_get_salary_level(salary) = s_level
	ORDER BY first_name DESC, last_name DESC;

END $$
DELIMITER ;

CALL usp_get_employees_by_salary_level('High');

SELECT first_name, last_name FROM employees
WHERE ufn_get_salary_level(salary) > 'High'
ORDER BY first_name DESC, last_name DESC;


#zad 10

DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value (sum DECIMAL(19,4), interest DOUBLE, years INT)
RETURNS DECIMAL(19,4)
DETERMINISTIC
BEGIN

	RETURN(sum*POW(1+interest,years));

END $$
DELIMITER ;
 
SELECT ufn_calculate_future_value(1000,0.5,5);


#zad 11

DELIMITER $$
CREATE PROCEDURE usp_calculate_future_value_for_account(acc_id INT,interest DOUBLE)
BEGIN

	SELECT a.id, ah.first_name, ah.last_name, a.balance AS current_balance,
	ufn_calculate_future_value(a.balance, interest,5) AS balance_in_5_years
	FROM accounts AS a
	JOIN account_holders AS ah
	ON a.account_holder_id=ah.id
    WHERE a.id=acc_id;

END $$
DELIMITER ;

-- izpra6tame i dvete zada4i tazi i gornata s ; m/y tqh

CALL usp_calculate_future_value_for_account(1,0.1);

SELECT a.id, ah.first_name, ah.last_name, a.balance,
ufn_calculate_future_value(a.balance, 0.1,5)
FROM accounts AS a
JOIN account_holders AS ah
ON a.account_holder_id=ah.id;


#zad 12

DELIMITER $$
CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DECIMAL (19,4))
BEGIN

	START TRANSACTION;
	IF(SELECT COUNT(*) FROM accounts WHERE id = account_id) =0
		OR (money_amount <= 0)
	  THEN ROLLBACK;
	ELSE
    UPDATE accounts
    SET balance=balance + money_amount
    WHERE id= account_id;
  END IF;
END $$
DELIMITER ; 

CALL usp_deposit_money(1,10);

SELECT * FROM accounts;


#zad 15 

CREATE TABLE `logs`(
log_id INT PRIMARY KEY AUTO_INCREMENT,
account_id INT ,
old_sum DECIMAL (19,2),
new_sum DECIMAL (19,2)
);

DELIMITER $$
CREATE TRIGGER tr_update_account
AFTER UPDATE
ON accounts
FOR EACH ROW

BEGIN

INSERT INTO `logs` (`account_id`, `old_sum`, `new_sum`)
VALUES (OLD.id, OLD.balance, NEW.balance);

END $$
DELIMITER ;







