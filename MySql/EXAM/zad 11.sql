



DELIMITER $$
CREATE PROCEDURE udp_update_product_price(address_name VARCHAR(50))
BEGIN

UPDATE products AS pr
JOIN products_stores AS ps
ON ps.`product_id`=pr.`id`
JOIN `stores` AS s
ON s.id=ps.store_id
JOIN `addresses` AS a
ON a.id=s.address_id
SET pr.price = (
	CASE
    WHEN  substring(a.name,1,1)=0 THEN price+100
    WHEN  substring(a.name,1,1)!=0 THEN price+200
 
    END
)
WHERE a.name=address_name
;

END $$
DELIMITER ;

CALL udp_update_product_price('1 Cody Pass');
SELECT name, price FROM products WHERE id = 17;

CALL udp_update_product_price('07 Armistice Parkway');
SELECT name, price FROM products WHERE id = 15;


