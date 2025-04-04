drop table if exists payments;
drop table if exists order_details;
drop table if exists orders;
drop table if exists order_status;
drop table if exists payment_status;
drop table if exists method_payments;
drop table if exists customers;


CREATE TABLE `customers`
(
 `id`       integer NOT NULL AUTO_INCREMENT,
 `name`     varchar(45) NOT NULL ,
 `lastname` varchar(45) NOT NULL ,
 `email`    varchar(45) NOT NULL ,
 `phone`    varchar(45) NOT NULL ,
 `address`  varchar(45) NOT NULL ,

PRIMARY KEY (`id`)
);

insert into customers(name,lastname, email, phone, address) values ('Fabelio', 'Ajtun', 'fabelio@gmail.com', '+50258965478', 'Ciudad');

CREATE TABLE `method_payments`
(
 `id`   integer NOT NULL AUTO_INCREMENT,
 `code` varchar(45) NOT NULL ,
 `name` varchar(45) NOT NULL ,

PRIMARY KEY (`id`),
UNIQUE KEY `unique_1` (`code`)
);

insert into method_payments(code, name) values ('credit-card', 'tarjeta de credito');


CREATE TABLE `order_status`
(
 `id`   integer NOT NULL AUTO_INCREMENT,
 `code` varchar(45) NOT NULL ,
 `name` varchar(45) NOT NULL ,

PRIMARY KEY (`id`),
UNIQUE KEY `unique_2` (`code`)
);

insert into order_status(code, name) values ('created', 'Creada');
insert into order_status(code, name) values ('cancelled', 'Cancelada');
insert into order_status(code, name) values ('paid', 'Pagada');
insert into order_status(code, name) values ('rejected', 'Pago rechazado');
insert into order_status(code, name) values ('delivered', 'Entregada');

CREATE TABLE `payment_status`
(
 `id`   integer NOT NULL AUTO_INCREMENT,
 `code` varchar(45) NOT NULL ,
 `name` varchar(45) NOT NULL ,

PRIMARY KEY (`id`),
UNIQUE KEY `unique_3` (`code`)
);

insert into payment_status(code, name) values ('approved', 'Aprobado');
insert into payment_status(code, name) values ('rejected', 'Rechazado');

CREATE TABLE `orders`
(
 `id`          integer NOT NULL AUTO_INCREMENT,
 `date`        date NOT NULL ,
 `customer_id` integer NOT NULL ,
 `status_id`   integer NOT NULL ,

PRIMARY KEY (`id`),
CONSTRAINT `FK_1` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`),
CONSTRAINT `FK_2` FOREIGN KEY (`status_id`) REFERENCES `order_status` (`id`)
);

-- ************************************** `order_details`

CREATE TABLE `order_details`
(
 `id`         integer NOT NULL AUTO_INCREMENT,
 `product_id` varchar(45) NOT NULL ,
 `quantity`   integer NOT NULL ,
 `price`      decimal NOT NULL ,
 `order_id`   integer NOT NULL ,

PRIMARY KEY (`id`),
CONSTRAINT `FK_3` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
);


CREATE TABLE `payments`
(
 `id`                integer NOT NULL AUTO_INCREMENT,
 `order_id`          integer NOT NULL ,
 `date`              date NOT NULL ,
 `amount`            decimal NOT NULL ,
 `method_payment_id` integer NOT NULL ,
 `message` varchar(45) NULL ,
 `status_id`          integer NOT NULL ,
PRIMARY KEY (`id`),
CONSTRAINT `FK_4` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
CONSTRAINT `FK_5` FOREIGN KEY (`method_payment_id`) REFERENCES `method_payments` (`id`),
CONSTRAINT `FK_6` FOREIGN KEY (`status_id`) REFERENCES `payment_status` (`id`)
);

