SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS
WHERE TABLE_SCHEMA = 'softuni_stores_system'
ORDER BY COLUMN_NAME, TABLE_NAME;



SELECT COLUMN_TYPE FROM INFORMATION_SCHEMA.COLUMNS
WHERE TABLE_SCHEMA = 'softuni_stores_system'
ORDER BY COLUMN_NAME, TABLE_NAME;



SELECT COLUMN_KEY FROM INFORMATION_SCHEMA.COLUMNS
WHERE TABLE_SCHEMA = 'softuni_stores_system'
  AND COLUMN_NAME IN ('id','product_id','store_id',
                      'town_id', 'address_id', 'category_id', 'picture_id','manager_id')
ORDER BY COLUMN_NAME, TABLE_NAME DESC, COLUMN_KEY DESC;




SELECT p.id, ps.store_id FROM `products` AS p
LEFT JOIN products_stores AS ps
ON ps.product_id=p.id;


INSERT INTO `products_stores` (`store_id`)
SELECT p.id, ps.store_id FROM `products` AS p
LEFT JOIN products_stores AS ps
ON ps.product_id=p.id
WHERE ps.store_id=1;

#istinskata 2ra
INSERT INTO products_stores (product_id, store_id)
SELECT p.id,1  FROM products as p
LEFT JOIN products_stores as ps
ON ps.product_id=p.id
WHERE ps.store_id IS NULL;


#zad 3

UPDATE 	employees
SET salary=salary-500, manager_id=3
WHERE store_id != 5 AND store_id != 14
AND   hire_date  >  '2003-01-01';


SELECT first_name, salary, hire_date, id 
FROM employees 
WHERE manager_id = 3;


#zad 4


DELETE FROM `employees`
WHERE manager_id IS NOT NULL AND salary >=6000;


SELECT first_name, salary, hire_date, id
FROM employees;

#zad 5

SELECT `first_name`, `middle_name`,`last_name`, `salary`, `hire_date`
FROM `employees`
ORDER BY `hire_date` DESC;


#zad 6

SELECT pr.`name` AS `product_name` , pr.`price`, pr.`best_before`, CONCAT(LEFT(pr.`description`,10),'...') AS `short_description`, pc.url
FROM `products` AS pr
JOIN pictures AS pc
ON pc.id=pr.picture_id
WHERE  `description`> LEFT(pr.`description`,100)
AND pc.`added_on`<'2019-01-01'
AND pr.price >20
ORDER BY pr.price DESC;



#zad 7



SELECT s.`name`, COUNT(pr.id) AS `product_count` , ROUND(AVG(pr.price),2) AS `avg`
FROM `products` AS pr
RIGHT JOIN products_stores AS ps
ON ps.product_id=pr.id
RIGHT JOIN `stores` AS s
ON s.id=ps.store_id
GROUP BY s.id
ORDER BY `product_count` DESC, `avg` DESC, s.id;



#zad 8


SELECT CONCAT_WS(' ',`first_name`,`last_name`) AS `full_name` ,s.`name` AS `Store_name`, a.`name` AS `address`, e.`salary`
FROM `employees` AS e
JOIN `stores` AS s
ON s.id=e.store_id
JOIN `addresses` AS a
ON a.id=s.address_id
WHERE e.`salary`<7000
AND locate('a', a.`name`)
AND  length(s.`name`) >5;



#zad 11


SELECT pr.`name`, pr.`price`, a.`name` AS adres
FROM `products` AS pr
JOIN products_stores AS ps
ON ps.`product_id`=pr.`id`
JOIN `stores` AS s
ON s.id=ps.store_id
JOIN `addresses` AS a
ON a.id=s.address_id
WHERE a.`name`= '07 Armistice Parkway';


DELIMITER $$
CREATE PROCEDURE udp_update_product_price(address_name VARCHAR(50))
BEGIN

UPDATE `products`
SET price= IF ( LEFT((SELECT a.`name`
	FROM (SELECT * FROM `products`) AS pr
	JOIN products_stores AS ps
	ON ps.`product_id`=pr.`id`
	JOIN `stores` AS s
	ON s.id=ps.store_id
	JOIN `addresses` AS a
	ON a.id=s.address_id
	WHERE a.`name`= address_name),1)=0, price=price+100, price=price+200);

END $$
DELIMITER ;


CALL udp_update_product_price('07 Armistice Parkway');




#zad 9

SELECT REVERSE(s.`name`) AS `reversed_name`, CONCAT(UPPER(tw.`name`),'-',a.`name`) AS `full_address` ,
COUNT(e.id) AS `employees_count`, MIN(pr.price) AS `min_price`,  COUNT( pr.id) AS `products_count`, 
 date_format(MAX( pc.`added_on`), '%D-%b-%Y' ) AS `newest_pic`
FROM `employees` AS e
RIGHT JOIN `stores` AS s
ON s.id=e.store_id
RIGHT JOIN `addresses` AS a
ON a.id=s.address_id
RIGHT JOIN towns AS tw
ON tw.id=a.`town_id`
RIGHT JOIN products_stores AS ps
ON ps.store_id=s.id
 JOIN products AS pr
ON pr.id=ps.product_id
RIGHT JOIN pictures AS pc
ON pc.id=pr.picture_id
GROUP BY s.id
HAVING `min_price` >10
ORDER BY `reversed_name`, `min_price`;



#zad 10
DELIMITER $$
 CREATE FUNCTION udf_top_paid_employee_by_store(store_name VARCHAR(50))
 RETURNS VARCHAR(300)
 DETERMINISTIC
 BEGIN
	RETURN(SELECT concat_ws(' ',concat_ws(' ',first_name , middle_name, last_name) ,'works in store' ,TIMESTAMPDIFF(YEAr,e.hire_date,'2020-10-18' ),'years')
	FROM employees AS e
	 JOIN stores AS s
	ON s.id = e.store_id
	WHERE s.name = store_name
	ORDER BY e.salary DESC
	LIMIT 1);    
 END; $$
DELIMITER ;

































