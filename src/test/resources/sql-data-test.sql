INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('Jordan', 'Harrison');
INSERT INTO `ims`.`items` (`item_title`, `quantity`, `price`) VALUES ('Fender Stratocaster - White', '100', '700.00');
INSERT INTO `ims`.`orders` (`customer_id`, `order_date`, `total_cost`) VALUES ('1', '2020-11-18', '700.00');
INSERT INTO `ims`.`orderline` (`order_id`, `item_id`, `quantity_ordered`) VALUES ('1', '1', '1');