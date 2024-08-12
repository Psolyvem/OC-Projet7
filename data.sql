DROP DATABASE IF EXISTS poseidon;

CREATE DATABASE poseidon;
USE poseidon;

CREATE TABLE bid_list 
(
  `bid_list_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `account` VARCHAR(30) NOT NULL,
  `type` VARCHAR(30) NOT NULL,
  `bid_quantity` DOUBLE,
  `ask_quantity` DOUBLE,
  `bid` DOUBLE,
  `ask` DOUBLE,
  `benchmark` VARCHAR(125),
  `bid_list_date` TIMESTAMP,
  `commentary` VARCHAR(125),
  `security` VARCHAR(125),
  `status` VARCHAR(10),
  `trader` VARCHAR(125),
  `book` VARCHAR(125),
  `creation_name` VARCHAR(125),
  `creation_date` TIMESTAMP,
  `revision_name` VARCHAR(125),
  `revision_date` TIMESTAMP,
  `deal_name` VARCHAR(125),
  `deal_type` VARCHAR(125),
  `source_list_id` VARCHAR(125),
  `side` VARCHAR(125)
);

CREATE TABLE trade 
(
  `trade_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  `account` VARCHAR(30) NOT NULL,
  `type` VARCHAR(30) NOT NULL,
  `buy_quantity` DOUBLE,
  `sell_quantity` DOUBLE,
  `buy_price` DOUBLE,
  `sell_price` DOUBLE,
  `trade_date` TIMESTAMP,
  `security` VARCHAR(125),
  `status` VARCHAR(10),
  `trader` VARCHAR(125),
  `benchmark` VARCHAR(125),
  `book` VARCHAR(125),
  `creation_name` VARCHAR(125),
  `creation_date` TIMESTAMP,
  `revision_name` VARCHAR(125),
  `revision_date` TIMESTAMP,
  `deal_name` VARCHAR(125),
  `deal_type` VARCHAR(125),
  `source_list_id` VARCHAR(125),
  `side` VARCHAR(125)
);

CREATE TABLE curve_point 
(
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `curve_id` tinyint,
  `as_of_date` TIMESTAMP,
  `term` DOUBLE,
  `value` DOUBLE,
  `creation_date` TIMESTAMP
);

CREATE TABLE rating 
(
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `moodys_rating` VARCHAR(125),
  `s_and_p_rating` VARCHAR(125),
  `fitch_rating` VARCHAR(125),
  `order_number` tinyint UNSIGNED
);

CREATE TABLE rule_name 
(
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(125),
  `description` VARCHAR(125),
  `json` VARCHAR(125),
  `template` VARCHAR(512),
  `sql_str` VARCHAR(125),
  `sql_part` VARCHAR(125)
);

CREATE TABLE users 
(
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `username` VARCHAR(125),
  `password` VARCHAR(125),
  `fullname` VARCHAR(125),
  `role` VARCHAR(125)
);

INSERT INTO users (fullname, username, password, role) 
VALUES
("Administrator", "admin", "$2y$10$pgv0ViGXboDRavr7iGOo7.g.AzG7niz53dHcK46IH2SqqpiJambia", "ADMIN"),
("User", "user", "$2y$10$rHEvLPDxKP9jC86PU5cE7.yyRXQ.74jP1Krtc1dtP3qTFp5k.7VX2", "USER");