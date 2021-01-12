



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
ORDER BY `reversed_name`, `min_price`, `newest_pic`;