#zad 1 ot lekciqta
SELECT `title` AS `Book Title` FROM `books`
WHERE SUBSTRING(`title`,1,3) ='The'
ORDER BY `id`;

SELECT `id`, `title`, `cost`,SUBSTRING(`title` FROM 1 FOR 20) AS `Title_summery` FROM `books`;

#zad 2
SELECT REPLACE(`title`,'The','***') AS 'Title'
FROM `books`
WHERE SUBSTRING(`title`,1,3) = 'The';

#zada4a 2 sus INSERT funkciq
SELECT INSERT(`title`,1,3,'***') AS 'Title'
FROM `books`
WHERE SUBSTRING(`title`,1,3) = 'The';

SELECT INSERT (`title`,LOCATE('The',`title`),3,'***') AS 'Title'
FROM `books`
WHERE SUBSTRING(`title`, 1,3)='The';

SELECT`title`,LOCATE('The',`title`),3,'***' AS 'Index of The'
FROM `books`
WHERE SUBSTRING(`title`, 1,3)='The';

SELECT`title`,LOCATE('The' ,`title` COLLATE utf8mb4_0900_as_cs) AS 'Index of The'
FROM `books`;
#WHERE SUBSTRING(`title`, 1,3)='The';

#zad 3
SELECT ROUND(SUM(`cost`),-2) AS `Total Cost` FROM `books`;

#zad 4
SELECT CONCAT(`first_name`,' ',`last_name`) AS 'name',
TIMESTAMPDIFF(DAY,`born`,`died`) AS `Days Lived` FROM `authors`;


SELECT CONCAT(`first_name`,' ',`last_name`) AS 'name',
TIMESTAMPDIFF(YEAR,`born`,`died`) AS `Days Lived` FROM `authors`;

#kogato purvoto pole e null if-a vzima sledva6toto pole (vtoroto)
SELECT CONCAT(`first_name`,' ',`last_name`) AS 'name',
TIMESTAMPDIFF(YEAR,`born`,IFNULL(`died`, NOW())) AS `Days Lived` FROM `authors`;

SELECT CONCAT(`first_name`,' ',`last_name`) AS 'name',
DATE_FORMAT(`born`, '%b %D %Y') AS `Born`,
 DATE_FORMAT(`died`, '%b %D %Y') AS `DIED`,
TIMESTAMPDIFF(YEAR,`born`,IFNULL(`died`, NOW())) AS `YEARS Lived` FROM `authors`;

#zad 5
SELECT `title` FROM `books`
WHERE `title` LIKE '%Harry Potter%';


 SELECT `id`, `title` FROM `books`
WHERE `title` REGEXP '^.*\\s[tT]he\\s.*$';

 SELECT `id`, `title` FROM `books`
WHERE `title` RLIKE '(?i)^.*\\sthe\\s.*$';

 SELECT `id`, `title` FROM `books`
WHERE REGEXP_LIKE(`title`, '(?i)^.*\\sthe\\s.*$'); 

SELECT CASE `id`
	WHEN 1 THEN 'one'
    WHEN 2 THEN 'two'
    WHEN 3 THEN 'tree'
    WHEN 4 THEN 'four'
    ELSE 'more...'
END AS `Case Expression`,
CONCAT_WS(' ',`first_name`,`last_name`) AS `name`
FROM `authors`;
