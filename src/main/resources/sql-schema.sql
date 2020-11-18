drop schema ims;
CREATE SCHEMA IF NOT EXISTS `ims`;
USE `ims` ;
CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) NULL DEFAULT NULL,
    `surname` VARCHAR(40) NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE IF NOT EXISTS `ims`.`orders` (
    `order_id` INT(11) NOT NULL AUTO_INCREMENT,
    `customer_id` INT(11) NOT NULL,
    `order_date` DATE NOT NULL,
    `total_cost` DOUBLE(7,2) NOT NULL,
    PRIMARY KEY (`order_id`),
    FOREIGN KEY (customer_id) REFERENCES customers(id) ON DELETE CASCADE
    
);
CREATE TABLE IF NOT EXISTS `ims`.`items` (
    `item_id` INT(11) NOT NULL AUTO_INCREMENT,
    `item_title` VARCHAR(255) NOT NULL,
    `quantity` INT NOT NULL,
    `price` DOUBLE(7,2) NOT NULL,
    PRIMARY KEY (`item_id`)

);
CREATE TABLE IF NOT EXISTS `ims`.`orderline` (
    `order_id` INT(11) NOT NULL,
    `item_id` INT(11) NOT NULL,
    `quantity_ordered` INT NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(order_id) ON DELETE CASCADE,
    FOREIGN KEY (item_id) REFERENCES items(item_id) ON DELETE CASCADE
);
