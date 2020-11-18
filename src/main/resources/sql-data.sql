INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('Jordan', 'Harrison');
INSERT INTO `ims`.`items` (`item_title`, `quantity`, `price`) VALUES ('Fender Stratocaster - White', '100', '700.00');
INSERT INTO `ims`.`orders` (`customer_id`, `order_date`, `total_cost`) VALUES ('1', '2020-11-18', '700.');
INSERT INTO `ims`.`orderline` (`order_id`, `item_id`, `quantity_ordered`) VALUES ('1', '1', '1');

INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('Harry', 'Fresco');
INSERT INTO `ims`.`items` (`item_title`, `quantity`, `price`) VALUES ('Fender Telecaster - Black', '100', '700.00');
INSERT INTO `ims`.`orders` (`customer_id`, `order_date`, `total_cost`) VALUES ('2', '2020-11-17', '700.00');
INSERT INTO `ims`.`orderline` (`order_id`, `item_id`, `quantity_ordered`) VALUES ('2', '2', '1');

INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('Fred', 'Freddy');
INSERT INTO `ims`.`items` (`item_title`, `quantity`, `price`) VALUES ('PRS - Red', '100', '800.00');
INSERT INTO `ims`.`orders` (`customer_id`, `order_date`, `total_cost`) VALUES ('3', '2020-11-16', '1600.00');
INSERT INTO `ims`.`orderline` (`order_id`, `item_id`, `quantity_ordered`) VALUES ('3', '3', '1');
INSERT INTO `ims`.`orderline` (`order_id`, `item_id`, `quantity_ordered`) VALUES ('3', '3', '1');

INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('Alfie', 'Freddy');
INSERT INTO `ims`.`items` (`item_title`, `quantity`, `price`) VALUES ('PRS - Blue', '200', '800.00');
INSERT INTO `ims`.`orders` (`customer_id`, `order_date`, `total_cost`) VALUES ('4', '2020-11-15', '1600.00');
INSERT INTO `ims`.`orderline` (`order_id`, `item_id`, `quantity_ordered`) VALUES ('4', '4', '1');
INSERT INTO `ims`.`orderline` (`order_id`, `item_id`, `quantity_ordered`) VALUES ('4', '3', '1');