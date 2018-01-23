# Dump of table billing_address
# ------------------------------------------------------------

DROP TABLE IF EXISTS `billing_address`;

CREATE TABLE `billing_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `billing_address_city` varchar(255) DEFAULT NULL,
  `billing_address_country` varchar(255) DEFAULT NULL,
  `billing_address_name` varchar(255) DEFAULT NULL,
  `billing_address_state` varchar(255) DEFAULT NULL,
  `billing_address_street1` varchar(255) DEFAULT NULL,
  `billing_address_street2` varchar(255) DEFAULT NULL,
  `billing_address_zipcode` varchar(255) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjg6ji2vsfuqlc9vhvy4yi449h` (`order_id`),
  CONSTRAINT `FKjg6ji2vsfuqlc9vhvy4yi449h` FOREIGN KEY (`order_id`) REFERENCES `user_order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table product
# ------------------------------------------------------------

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `size` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `description` text,
  `servingType` varchar(255) DEFAULT NULL,
  `in_stock_number` int(11) NOT NULL,
  `roast` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  `our_price` double NOT NULL,
  `list_price` double NOT NULL,
  `caffeine` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;

INSERT INTO `product` (`id`, `active`, `name`, `category`, `description`, `size`, `in_stock_number`, `region`, `caffeine`, `list_price`, `servingType`, `our_price`, `roast`)
VALUES
	(1,b'1','French Roast Coffee','Coffee','The darkest roast on the planet. We begin with a quintessential Costa Rican coffee that can stand up to the heat and intensity of a French Roast. Caramelized sugars, a hint of chocolate and a deeply smoky flavor that attests to the heat of the roast characterize this intensely flavorful coffee.','1 Lb Bag',20,'North America','Regular',15,'Whole Bean',13,'	Dark & Distinctive'),
	(2,b'1','American Roast Coffee','Coffee','The darkest roast on the planet. We begin with a quintessential Costa Rican coffee that can stand up to the heat and intensity of a French Roast. Caramelized sugars, a hint of chocolate and a deeply smoky flavor that attests to the heat of the roast characterize this intensely flavorful coffee.','1 Lb Bag',30,'North America','Regular',14,'Whole Bean',12,'	Dark');

/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table book_to_cart_item
# ------------------------------------------------------------

DROP TABLE IF EXISTS `product_to_cart_item`;

CREATE TABLE `product_to_cart_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `cart_item_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK254kg9aacrs8uqa93ijc3garu` (`product_id`),
  KEY `FKbdyqr108hc7c06xtem0dhv9mk` (`cart_item_id`),
  CONSTRAINT `FK254kg9aacrs8uqa93ijc3garu` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FKbdyqr108hc7c06xtem0dhv9mk` FOREIGN KEY (`cart_item_id`) REFERENCES `cart_item` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table cart_item
# ------------------------------------------------------------

DROP TABLE IF EXISTS `cart_item`;

CREATE TABLE `cart_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `qty` int(11) NOT NULL,
  `subtotal` decimal(19,2) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `shopping_cart_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKis5hg85qbs5d91etr4mvd4tx6` (`product_id`),
  KEY `FKen9v41ihsnhcr0i7ivsd7i84c` (`order_id`),
  KEY `FKe89gjdx91fxnmkkssyoim8xfu` (`shopping_cart_id`),
  CONSTRAINT `FKe89gjdx91fxnmkkssyoim8xfu` FOREIGN KEY (`shopping_cart_id`) REFERENCES `shopping_cart` (`id`),
  CONSTRAINT `FKen9v41ihsnhcr0i7ivsd7i84c` FOREIGN KEY (`order_id`) REFERENCES `user_order` (`id`),
  CONSTRAINT `FKis5hg85qbs5d91etr4mvd4tx6` FOREIGN KEY (`productk_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table password_reset_token
# ------------------------------------------------------------

DROP TABLE IF EXISTS `password_reset_token`;

CREATE TABLE `password_reset_token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `expiry_date` datetime DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5lwtbncug84d4ero33v3cfxvl` (`user_id`),
  CONSTRAINT `FK5lwtbncug84d4ero33v3cfxvl` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table payment
# ------------------------------------------------------------

DROP TABLE IF EXISTS `payment`;

CREATE TABLE `payment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `card_number` varchar(255) DEFAULT NULL,
  `cvc` int(11) NOT NULL,
  `default_payment` bit(1) NOT NULL,
  `expiry_month` int(11) NOT NULL,
  `expiry_year` int(11) NOT NULL,
  `holder_name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKt7a73xusjdnnsuespcitb683h` (`order_id`),
  CONSTRAINT `FKt7a73xusjdnnsuespcitb683h` FOREIGN KEY (`order_id`) REFERENCES `user_order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;

INSERT INTO `role` (`role_id`, `name`)
VALUES
	(0,'ROLE_ADMIN'),
	(1,'ROLE_USER');

/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table shipping_address
# ------------------------------------------------------------

DROP TABLE IF EXISTS `shipping_address`;

CREATE TABLE `shipping_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shipping_address_city` varchar(255) DEFAULT NULL,
  `shipping_address_country` varchar(255) DEFAULT NULL,
  `shipping_address_name` varchar(255) DEFAULT NULL,
  `shipping_address_state` varchar(255) DEFAULT NULL,
  `shipping_address_street1` varchar(255) DEFAULT NULL,
  `shipping_address_street2` varchar(255) DEFAULT NULL,
  `shipping_address_zipcode` varchar(255) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKatbgaqk1hhhhkyyuebylpeh7q` (`order_id`),
  CONSTRAINT `FKatbgaqk1hhhhkyyuebylpeh7q` FOREIGN KEY (`order_id`) REFERENCES `user_order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table shopping_cart
# ------------------------------------------------------------

DROP TABLE IF EXISTS `shopping_cart`;

CREATE TABLE `shopping_cart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `grand_total` decimal(19,2) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK254qp5akhuaaj9n5co4jww3fk` (`user_id`),
  CONSTRAINT `FK254qp5akhuaaj9n5co4jww3fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `shopping_cart` WRITE;
/*!40000 ALTER TABLE `shopping_cart` DISABLE KEYS */;

INSERT INTO `shopping_cart` (`id`, `grand_total`, `user_id`)
VALUES
	(1,NULL,1);

/*!40000 ALTER TABLE `shopping_cart` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;

INSERT INTO `user` (`id`, `email`, `enabled`, `first_name`, `last_name`, `password`, `phone`, `username`)
VALUES
	(1,'buchynskalana@gmail.com',b'1','emma','Smith','$2a$12$GBAs7eP0WMwUV8zGNGYwKO4VyQWsZrpOa1tCQvFs.sLYVbDWzVpUu',NULL,'e'),
	(2,'Admin@gmail.com',b'1','Admin','Admin','$2a$12$W1T5RiIBN5Yp8vCQJSKE7uDH/ciVCcg/2z7KgoQ07isze5VJNwhum',NULL,'Admin');

/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user_billing
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_billing`;

CREATE TABLE `user_billing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_billing_city` varchar(255) DEFAULT NULL,
  `user_billing_country` varchar(255) DEFAULT NULL,
  `user_billing_name` varchar(255) DEFAULT NULL,
  `user_billing_state` varchar(255) DEFAULT NULL,
  `user_billing_street1` varchar(255) DEFAULT NULL,
  `user_billing_street2` varchar(255) DEFAULT NULL,
  `user_billing_zipcode` varchar(255) DEFAULT NULL,
  `user_payment_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3v6hd7snyc3g9s72u41k1fydu` (`user_payment_id`),
  CONSTRAINT `FK3v6hd7snyc3g9s72u41k1fydu` FOREIGN KEY (`user_payment_id`) REFERENCES `user_payment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table user_order
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_order`;

CREATE TABLE `user_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_date` datetime DEFAULT NULL,
  `order_status` varchar(255) DEFAULT NULL,
  `order_total` decimal(19,2) DEFAULT NULL,
  `shipping_date` datetime DEFAULT NULL,
  `shipping_method` varchar(255) DEFAULT NULL,
  `billing_address_id` bigint(20) DEFAULT NULL,
  `payment_id` bigint(20) DEFAULT NULL,
  `shipping_address_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbaytj4l2p74kc5dp2dcrhucjo` (`billing_address_id`),
  KEY `FKqjg5jrh5qwnhl2f9lk7n77454` (`payment_id`),
  KEY `FKo2lj94xaujs1se8whlhc37nj7` (`shipping_address_id`),
  KEY `FKj86u1x7csa8yd68ql2y1ibrou` (`user_id`),
  CONSTRAINT `FKbaytj4l2p74kc5dp2dcrhucjo` FOREIGN KEY (`billing_address_id`) REFERENCES `billing_address` (`id`),
  CONSTRAINT `FKj86u1x7csa8yd68ql2y1ibrou` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKo2lj94xaujs1se8whlhc37nj7` FOREIGN KEY (`shipping_address_id`) REFERENCES `shipping_address` (`id`),
  CONSTRAINT `FKqjg5jrh5qwnhl2f9lk7n77454` FOREIGN KEY (`payment_id`) REFERENCES `payment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table user_payment
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_payment`;

CREATE TABLE `user_payment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `card_name` varchar(255) DEFAULT NULL,
  `card_number` varchar(255) DEFAULT NULL,
  `cvc` int(11) NOT NULL,
  `default_payment` bit(1) NOT NULL,
  `expiry_month` int(11) NOT NULL,
  `expiry_year` int(11) NOT NULL,
  `holder_name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8fb9fr82lb1qk2cw55ito9rk6` (`user_id`),
  CONSTRAINT `FK8fb9fr82lb1qk2cw55ito9rk6` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table user_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `user_role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`user_role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;

INSERT INTO `user_role` (`user_role_id`, `role_id`, `user_id`)
VALUES
	(1,1,1),
	(2,0,2);

/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user_shipping
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_shipping`;

CREATE TABLE `user_shipping` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_shipping_city` varchar(255) DEFAULT NULL,
  `user_shipping_country` varchar(255) DEFAULT NULL,
  `user_shipping_default` bit(1) NOT NULL,
  `user_shipping_name` varchar(255) DEFAULT NULL,
  `user_shipping_state` varchar(255) DEFAULT NULL,
  `user_shipping_street1` varchar(255) DEFAULT NULL,
  `user_shipping_street2` varchar(255) DEFAULT NULL,
  `user_shipping_zipcode` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9hidca5hndj9y0b5jb0xtpn9u` (`user_id`),
  CONSTRAINT `FK9hidca5hndj9y0b5jb0xtpn9u` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



