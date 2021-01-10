#zad 1

DROP FUNCTION IF EXISTS ufn_count_employees_by_town;
DELIMITER //
CREATE FUNCTION ufn_count_employees_by_town(town_name VARCHAR(50))
RETURNS INT DETERMINISTIC
BEGIN
	DECLARE emp_count INT;
    SET emp_count :=(SELECT COUNT(*) FROM employees
    JOIN addresses USING (address_id)
    JOIN towns AS t USING(town_id)
    WHERE t.`name` = town_name);
	RETURN emp_count;
END//
DELIMITER ;

SELECT ufn_count_employees_by_town ('Sofia');

SELECT employee_id, first_name, last_name, t.`name` FROM employees
	JOIN addresses USING (address_id)
	JOIN towns AS t USING (town_id)
    WHERE t.`name`= 'Sofia';

#zad 2

DROP PROCEDURE IF EXISTS usp_select_employees_by_seniority;
DELIMITER //
CREATE PROCEDURE  usp_select_employees_by_seniority(IN years_employed INT)
BEGIN
	SELECT employee_id, first_name,last_name, hire_date,
    ROUND(DATEDIFF(NOW(), hire_date) / 365.25)
    FROM employees
    WHERE ROUND(DATEDIFF(NOW(), hire_date) / 365.25) <years_employed;
END//
DELIMITER ;

CALL usp_select_employees_by_seniority(20);


#zad s fynkciq    IN OUT params

DROP procedure IF EXISTS `usp_add_numbers`;

DELIMITER $$

CREATE PROCEDURE `usp_add_numbers` (
IN a INT,
IN b INT,
out result INT
)
BEGIN
SET result := a + b;
END$$

DELIMITER ;

SET @answer = 0;
CALL usp_add_numbers(37,7,@answer);
SELECT @answer;        #za da startirame procedyrata trqbva da se startirat moslednite 3 reda

#spedva6ta procedyra

DROP procedure IF EXISTS `usp_incremet`;

DELIMITER $$
CREATE PROCEDURE `usp_incremet`
 (
INOUT result INT
)
BEGIN
SET result := result + 1;
END$$
DELIMITER ;

CALL usp_incremet(@answer);
SELECT @answer;    #tazi promenliva e ot po gore i prodyljavame da q izpolzvame


#zad 2
-- Procedure updating table
DROP procedure IF EXISTS `usp_raise_salaries`;
DELIMITER $$
CREATE PROCEDURE `usp_raise_salaries` (IN department_name VARCHAR(50))

BEGIN
	UPDATE employees JOIN departments d USING (department_id)
	SET salary =salary*1.05
	WHERE d.`name`=department_name;
	END$$
DELIMITER ;

CALL usp_raise_salaries('Sales');
SELECT employee_id,first_name,salary FROM employees
WHERE department_id = 3;

# sushtata zada4a no yveli4avame s parametur a ne s 5%

DROP procedure IF EXISTS `usp_raise_salaries`;
DELIMITER $$
CREATE PROCEDURE `usp_raise_salaries` (
IN department_name VARCHAR(50),
IN percentage DOUBLE)

BEGIN
	UPDATE employees JOIN departments d USING (department_id)
	SET salary =salary*(1 + percentage/100)
	WHERE d.`name`=department_name;
	END$$
DELIMITER ;

CALL usp_raise_salaries('Sales',-10);
SELECT employee_id,first_name,salary FROM employees
WHERE department_id = 3;


#zad 3 tranzakcii;
#usp_raise_salary_by_id(id int);

DROP procedure IF EXISTS `usp_raise_salary_by_id`;
DELIMITER $$
CREATE PROCEDURE usp_raise_salary_by_id (emp_id INT) 
BEGIN
	START TRANSACTION;
	IF ((SELECT COUNT(*) FROM employees WHERE employee_id=emp_id) <>1)
    THEN ROLLBACK;
    ELSE
    UPDATE employees 
	SET salary =salary*(1.05)
	WHERE employee_id= emp_id;
    COMMIT;
    END IF;
END$$
DELIMITER ;

CALL usp_raise_salary_by_id(268);
SELECT employee_id,first_name,salary FROM employees
WHERE employee_id = 268;


#zad 4
DROP TABLE IF EXISTS deleted_employees;
CREATE TABLE deleted_employees (
`employee_id` INT PRIMARY KEY ,
	`first_name` VARCHAR(50) NOT NULL,
	`last_name` VARCHAR(50) NOT NULL,
	`middle_name` VARCHAR(50) NOT NULL,
	`job_title` VARCHAR(50) NOT NULL,
	`department_id` INT(10) DEFAULT NULL,
	`salary` DECIMAL(19,4) NOT NULL
);
DROP TRIGGER IF EXISTS tr_deleted_employees;
DELIMITER $$
CREATE TRIGGER tr_deleted_employees
AFTER DELETE 
ON employees
FOR EACH ROW
BEGIN
  INSERT INTO deleted_employees (
  `employee_id` ,`first_name` ,`last_name` ,`middle_name` ,`job_title` ,`department_id`,`salary`  )
  VALUES ( OLD.employee_id ,OLD.first_name ,OLD.last_name ,OLD.middle_name ,OLD.job_title ,OLD.department_id,OLD.salary );
 END$$
DELIMITER ;

DELETE FROM `employees` WHERE employee_id = 290;