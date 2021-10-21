CREATE DATABASE `cinema`;

USE `cinema`;

CREATE TABLE `films` (
  `film_id` int NOT NULL AUTO_INCREMENT,
  `film_name` varchar(45) NOT NULL,
  PRIMARY KEY (`film_id`),
  UNIQUE KEY `film_id_UNIQUE` (`film_id`),
  UNIQUE KEY `film_name_UNIQUE` (`film_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `sessions` (
  `session_id` int NOT NULL AUTO_INCREMENT,
  `film_id` int NOT NULL,
  `session_start` datetime NOT NULL,
  `session_end` datetime NOT NULL,
  `sessiion_price` decimal(10,0) NOT NULL,
  PRIMARY KEY (`session_id`),
  UNIQUE KEY `session_id_UNIQUE` (`session_id`),
  KEY `session_film_idx` (`film_id`),
  CONSTRAINT `session_film` FOREIGN KEY (`film_id`) REFERENCES `films` (`film_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `orders` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `session_id` int NOT NULL,
  `session_seat` int NOT NULL,
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `order_id_UNIQUE` (`order_id`),
  KEY `orders_session_idx` (`session_id`),
  CONSTRAINT `orders_session` FOREIGN KEY (`session_id`) REFERENCES `sessions` (`session_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `cinema`.`films` (`film_name`) VALUES ('Terminator 2045');
INSERT INTO `cinema`.`films` (`film_name`) VALUES ('Matrix');
INSERT INTO `cinema`.`films` (`film_name`) VALUES ('Lord of the Rings');
INSERT INTO `cinema`.`films` (`film_name`) VALUES ('Batman');
INSERT INTO `cinema`.`films` (`film_name`) VALUES ('Spider-man');

INSERT INTO `cinema`.`sessions` (`film_id`, `session_start`, `session_end`, `sessiion_price`) VALUES ('1', '2021-10-19 09:00:00', '2021-10-19 10:40:00', '200');
INSERT INTO `cinema`.`sessions` (`film_id`, `session_start`, `session_end`, `sessiion_price`) VALUES ('2', '2021-10-19 11:00:00', '2021-10-19 12:50:00', '220');
INSERT INTO `cinema`.`sessions` (`film_id`, `session_start`, `session_end`, `sessiion_price`) VALUES ('3', '2021-10-19 11:30:00', '2021-10-19 13:00:00', '220');
INSERT INTO `cinema`.`sessions` (`film_id`, `session_start`, `session_end`, `sessiion_price`) VALUES ('4', '2021-10-19 13:20:00', '2021-10-19 15:10:00', '250');
INSERT INTO `cinema`.`sessions` (`film_id`, `session_start`, `session_end`, `sessiion_price`) VALUES ('5', '2021-10-19 15:25:00', '2021-10-19 17:20:00', '250');
INSERT INTO `cinema`.`sessions` (`film_id`, `session_start`, `session_end`, `sessiion_price`) VALUES ('2', '2021-10-19 18:00:00', '2021-10-19 20:00:00', '300');
INSERT INTO `cinema`.`sessions` (`film_id`, `session_start`, `session_end`, `sessiion_price`) VALUES ('1', '2021-10-19 18:10:00', '2021-10-19 20:00:00', '300');
INSERT INTO `cinema`.`sessions` (`film_id`, `session_start`, `session_end`, `sessiion_price`) VALUES ('4', '2021-10-19 20:35:00', '2021-10-19 22:00:00', '350');
INSERT INTO `cinema`.`sessions` (`film_id`, `session_start`, `session_end`, `sessiion_price`) VALUES ('3', '2021-10-19 22:10:00', '2021-10-19 23:45:00', '350');

INSERT INTO `cinema`.`orders` (`session_id`, `session_seat`) VALUES (1,1);
INSERT INTO `cinema`.`orders` (`session_id`, `session_seat`) VALUES (1,2);
INSERT INTO `cinema`.`orders` (`session_id`, `session_seat`) VALUES (1,3);
INSERT INTO `cinema`.`orders` (`session_id`, `session_seat`) VALUES (2,1);
INSERT INTO `cinema`.`orders` (`session_id`, `session_seat`) VALUES (2,2);
INSERT INTO `cinema`.`orders` (`session_id`, `session_seat`) VALUES (2,3);
INSERT INTO `cinema`.`orders` (`session_id`, `session_seat`) VALUES (3,13);
INSERT INTO `cinema`.`orders` (`session_id`, `session_seat`) VALUES (3,4);
INSERT INTO `cinema`.`orders` (`session_id`, `session_seat`) VALUES (4,1);
INSERT INTO `cinema`.`orders` (`session_id`, `session_seat`) VALUES (5,6);
INSERT INTO `cinema`.`orders` (`session_id`, `session_seat`) VALUES (5,7);
INSERT INTO `cinema`.`orders` (`session_id`, `session_seat`) VALUES (6,45);
INSERT INTO `cinema`.`orders` (`session_id`, `session_seat`) VALUES (6,50);
INSERT INTO `cinema`.`orders` (`session_id`, `session_seat`) VALUES (7,3);
INSERT INTO `cinema`.`orders` (`session_id`, `session_seat`) VALUES (8,9);
INSERT INTO `cinema`.`orders` (`session_id`, `session_seat`) VALUES (8,8);
INSERT INTO `cinema`.`orders` (`session_id`, `session_seat`) VALUES (8,10);
INSERT INTO `cinema`.`orders` (`session_id`, `session_seat`) VALUES (8,11);
INSERT INTO `cinema`.`orders` (`session_id`, `session_seat`) VALUES (9,5);
