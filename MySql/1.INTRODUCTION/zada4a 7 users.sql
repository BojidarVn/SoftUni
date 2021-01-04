CREATE TABLE `users` (
`id` BIGINT SIGNED PRIMARY KEY AUTO_INCREMENT,
`username` VARCHAR(30),
`password` VARCHAR(26),
`profile_picture` BLOB,
`last_login_time` DATETIME,
`is_deleted` boolean
);

INSERT INTO `users` (`id`,`username`,`password`,`profile_picture`,`last_login_time`,`is_deleted`)
VALUES
(1,'dddd','ffff',NULL,'2000-08-11 21-35-47',TRUE),
(2,'dddd','ffff',NULL,'2000-08-11 21-35-47',TRUE),
(3,'dddd','ffff',NULL,'2000-08-11 21-35-47',TRUE),
(4,'dddd','ffff',NULL,'2000-08-11 21-35-47',TRUE),
(5,'dddd','ffff',NULL,'2000-08-11 21-35-47',TRUE);

#zada4a 8ma Change Primary Key
ALTER TABLE `users`
  MODIFY `id` INT NOT NULL;
ALTER TABLE `users`
  DROP PRIMARY KEY;
ALTER TABLE `users`
  ADD CONSTRAINT pk_users PRIMARY KEY (id,username);
  
  # zada4a 9ta Set Default Value of a Field
ALTER TABLE users
MODIFY  COLUMN last_login_time 
TIMESTAMP 
NOT NULL DEFAULT CURRENT_TIMESTAMP;

#zada4a 10TA
ALTER TABLE `users` MODIFY id BIGINT NOT NULL;
ALTER TABLE `users`
DROP PRIMARY KEY;
ALTER TABLE `users`
ADD CONSTRAINT pk_users PRIMARY KEY(`id`);
ALTER TABLE `users`
ADD CONSTRAINT uq_username
UNIQUE (`username`);



