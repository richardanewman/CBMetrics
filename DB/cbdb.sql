-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema cbdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `cbdb` ;

-- -----------------------------------------------------
-- Schema cbdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cbdb` DEFAULT CHARACTER SET utf8 ;
USE `cbdb` ;

-- -----------------------------------------------------
-- Table `user_account`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_account` ;

CREATE TABLE IF NOT EXISTS `user_account` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(50) NOT NULL,
  `password` VARCHAR(60) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  `enabled` TINYINT NOT NULL DEFAULT 1,
  `registration_timestamp` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_profile`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_profile` ;

CREATE TABLE IF NOT EXISTS `user_profile` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_account_id` INT NOT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `business` VARCHAR(45) NULL,
  `website` VARCHAR(45) NULL,
  `bio` TEXT NULL,
  `profile_pic` VARCHAR(500) NULL,
  `city` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_profile_user_account_idx` (`user_account_id` ASC),
  CONSTRAINT `fk_user_profile_user_account`
    FOREIGN KEY (`user_account_id`)
    REFERENCES `user_account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `product` ;

CREATE TABLE IF NOT EXISTS `product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cb_id` VARCHAR(45) NULL,
  `popularity_rank` INT NULL,
  `title` VARCHAR(100) NULL,
  `description` TEXT NULL,
  `has_recurring_products` TINYINT NULL,
  `gravity` DOUBLE NULL,
  `percent_per_sale` DOUBLE NULL,
  `percent_per_rebill` DOUBLE NULL,
  `average_earnings_per_sale` DOUBLE NULL,
  `initial_earnings_per_sale` DOUBLE NULL,
  `total_rebill_amt` DOUBLE NULL,
  `referred` DOUBLE NULL,
  `commission` INT NULL,
  `active_date` DATE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `popularity_rank`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `popularity_rank` ;

CREATE TABLE IF NOT EXISTS `popularity_rank` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `date` TIMESTAMP NULL,
  `rank_value` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_popularity_rank_product1_idx` (`product_id` ASC),
  CONSTRAINT `fk_popularity_rank_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gravity`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gravity` ;

CREATE TABLE IF NOT EXISTS `gravity` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `date` DATE NULL,
  `gravity_value` DOUBLE NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_gravity_product1_idx` (`product_id` ASC),
  CONSTRAINT `fk_gravity_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `percent_per_sale`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `percent_per_sale` ;

CREATE TABLE IF NOT EXISTS `percent_per_sale` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `date_changed` DATE NULL,
  `percentage_value` DOUBLE NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_percent_per_sale_product1_idx` (`product_id` ASC),
  CONSTRAINT `fk_percent_per_sale_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `percent_per_rebill`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `percent_per_rebill` ;

CREATE TABLE IF NOT EXISTS `percent_per_rebill` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `date_changed` DATE NULL,
  `percent_rebill_value` DOUBLE NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_percent_per_rebill_product1_idx` (`product_id` ASC),
  CONSTRAINT `fk_percent_per_rebill_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `average_earnings_per_sale`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `average_earnings_per_sale` ;

CREATE TABLE IF NOT EXISTS `average_earnings_per_sale` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `date` DATE NULL,
  `avg_earnings_value` DOUBLE NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_average_earnings_per_sale_product1_idx` (`product_id` ASC),
  CONSTRAINT `fk_average_earnings_per_sale_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `initial_earnings_per_sale`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `initial_earnings_per_sale` ;

CREATE TABLE IF NOT EXISTS `initial_earnings_per_sale` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `date` DATE NULL,
  `initial_earnings_value` DOUBLE NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_initial_earnings_per_sale_product1_idx` (`product_id` ASC),
  CONSTRAINT `fk_initial_earnings_per_sale_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `total_rebill_amt`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `total_rebill_amt` ;

CREATE TABLE IF NOT EXISTS `total_rebill_amt` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `date` DATE NULL,
  `total_rebill_value` DOUBLE NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_total_rebill_amt_product1_idx` (`product_id` ASC),
  CONSTRAINT `fk_total_rebill_amt_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `referred`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `referred` ;

CREATE TABLE IF NOT EXISTS `referred` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `date` DATE NULL,
  `referred_value` DOUBLE NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_referred_product1_idx` (`product_id` ASC),
  CONSTRAINT `fk_referred_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `commission`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `commission` ;

CREATE TABLE IF NOT EXISTS `commission` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `date_changed` DATE NULL,
  `commission_value` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_commission_product1_idx` (`product_id` ASC),
  CONSTRAINT `fk_commission_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `category` ;

CREATE TABLE IF NOT EXISTS `category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `category_has_product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `category_has_product` ;

CREATE TABLE IF NOT EXISTS `category_has_product` (
  `category_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  PRIMARY KEY (`category_id`, `product_id`),
  INDEX `fk_category_has_product_product1_idx` (`product_id` ASC),
  INDEX `fk_category_has_product_category1_idx` (`category_id` ASC),
  CONSTRAINT `fk_category_has_product_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_category_has_product_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `product_notes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `product_notes` ;

CREATE TABLE IF NOT EXISTS `product_notes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_profile_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  `date_created` TIMESTAMP NULL,
  `notes` TEXT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_product_notes_user_profile1_idx` (`user_profile_id` ASC),
  INDEX `fk_product_notes_product1_idx` (`product_id` ASC),
  CONSTRAINT `fk_product_notes_user_profile1`
    FOREIGN KEY (`user_profile_id`)
    REFERENCES `user_profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_notes_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dm`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dm` ;

CREATE TABLE IF NOT EXISTS `dm` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `composer_id` INT NOT NULL,
  `recipient_id` INT NOT NULL,
  `message` TEXT NULL,
  `date_posted` DATE NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_dm_user_profile1_idx` (`composer_id` ASC),
  INDEX `fk_dm_user_profile2_idx` (`recipient_id` ASC),
  CONSTRAINT `fk_dm_user_profile1`
    FOREIGN KEY (`composer_id`)
    REFERENCES `user_profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dm_user_profile2`
    FOREIGN KEY (`recipient_id`)
    REFERENCES `user_profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `product_message`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `product_message` ;

CREATE TABLE IF NOT EXISTS `product_message` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_profile_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  `message` TEXT NULL,
  `replied_to_id` INT NULL,
  `date_posted` DATE NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_product_message_user_profile1_idx` (`user_profile_id` ASC),
  INDEX `fk_product_message_product1_idx` (`product_id` ASC),
  INDEX `fk_product_message_replied_to_id_idx` (`replied_to_id` ASC),
  CONSTRAINT `fk_product_message_user_profile1`
    FOREIGN KEY (`user_profile_id`)
    REFERENCES `user_profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_message_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_message_replied_to_id`
    FOREIGN KEY (`replied_to_id`)
    REFERENCES `user_profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS cbdb@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'cbdb'@'localhost' IDENTIFIED BY 'cbdb';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'cbdb'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user_account`
-- -----------------------------------------------------
START TRANSACTION;
USE `cbdb`;
INSERT INTO `user_account` (`id`, `email`, `password`, `role`, `enabled`, `registration_timestamp`) VALUES (1, 'rick@richardnewman.dev', '$2y$10$qxijAYpoT7SFIOxoSj66F.CHyh51ZNxXc2EtLKu9hmmfSBLWeoT/i', 'ADMIN', 1, '2020-02-20 00:00:01');
INSERT INTO `user_account` (`id`, `email`, `password`, `role`, `enabled`, `registration_timestamp`) VALUES (2, 'test@testemail.com', '$2y$10$qxijAYpoT7SFIOxoSj66F.CHyh51ZNxXc2EtLKu9hmmfSBLWeoT/i', 'STANDARD', 1, '2020-02-20 00:00:01');
INSERT INTO `user_account` (`id`, `email`, `password`, `role`, `enabled`, `registration_timestamp`) VALUES (3, 'test@testmail.com', '$2y$10$qxijAYpoT7SFIOxoSj66F.CHyh51ZNxXc2EtLKu9hmmfSBLWeoT/i', 'STANDARD', 1, '2020-02-20 00:00:01');

COMMIT;


-- -----------------------------------------------------
-- Data for table `user_profile`
-- -----------------------------------------------------
START TRANSACTION;
USE `cbdb`;
INSERT INTO `user_profile` (`id`, `user_account_id`, `first_name`, `last_name`, `business`, `website`, `bio`, `profile_pic`, `city`, `state`) VALUES (1, 1, 'Richard', 'Newman', '#MakeBank', 'https://richardnewman.dev', 'Time to #makebank with ClickBank!', 'https://avatars0.githubusercontent.com/u/17536735?s=400&u=566cc933a34bf6f72cc9e68b34968dcf182222e8&v=4', 'Boise', 'Idaho');
INSERT INTO `user_profile` (`id`, `user_account_id`, `first_name`, `last_name`, `business`, `website`, `bio`, `profile_pic`, `city`, `state`) VALUES (2, 2, 'John', 'Crestani', 'Pendragon Labs LLC', 'https://johncrestani.com', 'John Crestani is an internationally-renowned expert in affiliate marketing. \n\nSince(involuntarily) leaving his crushy job in the corporate world, in just a couple of years he’s gone on to build an empire in the affiliate marketing space. And now he’s taken it upon himself to teach a handful of aspiring marketers how they too can get a piece of the affiliate marketing action.\nSo what are you waiting for? Join John and gain exposure to his unparalleled insight and experience, and become part of a community of people who share your aspirations. Now is the time for you to start living the dream.', 'https://johncrestani.com/press/bt2_3431/', 'Boise', 'Idaho');
INSERT INTO `user_profile` (`id`, `user_account_id`, `first_name`, `last_name`, `business`, `website`, `bio`, `profile_pic`, `city`, `state`) VALUES (3, 3, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ');

COMMIT;


-- -----------------------------------------------------
-- Data for table `product`
-- -----------------------------------------------------
START TRANSACTION;
USE `cbdb`;
INSERT INTO `product` (`id`, `cb_id`, `popularity_rank`, `title`, `description`, `has_recurring_products`, `gravity`, `percent_per_sale`, `percent_per_rebill`, `average_earnings_per_sale`, `initial_earnings_per_sale`, `total_rebill_amt`, `referred`, `commission`, `active_date`) VALUES (1, 'defaultprod1', 0, 'Default Product Title', 'Testing product description.', 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0, '2020-02-20 00:00:01');

COMMIT;


-- -----------------------------------------------------
-- Data for table `popularity_rank`
-- -----------------------------------------------------
START TRANSACTION;
USE `cbdb`;
INSERT INTO `popularity_rank` (`id`, `product_id`, `date`, `rank_value`) VALUES (1, 1, '2020-02-20', 0);

COMMIT;


-- -----------------------------------------------------
-- Data for table `gravity`
-- -----------------------------------------------------
START TRANSACTION;
USE `cbdb`;
INSERT INTO `gravity` (`id`, `product_id`, `date`, `gravity_value`) VALUES (1, 1, '2020-02-20', 0.0);

COMMIT;


-- -----------------------------------------------------
-- Data for table `percent_per_sale`
-- -----------------------------------------------------
START TRANSACTION;
USE `cbdb`;
INSERT INTO `percent_per_sale` (`id`, `product_id`, `date_changed`, `percentage_value`) VALUES (1, 1, '2020-02-20', 0.0);

COMMIT;


-- -----------------------------------------------------
-- Data for table `percent_per_rebill`
-- -----------------------------------------------------
START TRANSACTION;
USE `cbdb`;
INSERT INTO `percent_per_rebill` (`id`, `product_id`, `date_changed`, `percent_rebill_value`) VALUES (1, 1, '2020-02-20', 0.0);

COMMIT;


-- -----------------------------------------------------
-- Data for table `average_earnings_per_sale`
-- -----------------------------------------------------
START TRANSACTION;
USE `cbdb`;
INSERT INTO `average_earnings_per_sale` (`id`, `product_id`, `date`, `avg_earnings_value`) VALUES (1, 1, '2020-02-20', 0.0);

COMMIT;


-- -----------------------------------------------------
-- Data for table `initial_earnings_per_sale`
-- -----------------------------------------------------
START TRANSACTION;
USE `cbdb`;
INSERT INTO `initial_earnings_per_sale` (`id`, `product_id`, `date`, `initial_earnings_value`) VALUES (1, 1, '2020-02-20', 0.0);

COMMIT;


-- -----------------------------------------------------
-- Data for table `total_rebill_amt`
-- -----------------------------------------------------
START TRANSACTION;
USE `cbdb`;
INSERT INTO `total_rebill_amt` (`id`, `product_id`, `date`, `total_rebill_value`) VALUES (1, 1, '2020-02-20', 0.0);

COMMIT;


-- -----------------------------------------------------
-- Data for table `referred`
-- -----------------------------------------------------
START TRANSACTION;
USE `cbdb`;
INSERT INTO `referred` (`id`, `product_id`, `date`, `referred_value`) VALUES (1, 1, '2020-02-20', 0.0);

COMMIT;


-- -----------------------------------------------------
-- Data for table `commission`
-- -----------------------------------------------------
START TRANSACTION;
USE `cbdb`;
INSERT INTO `commission` (`id`, `product_id`, `date_changed`, `commission_value`) VALUES (1, 1, '2020-02-20', 0);

COMMIT;


-- -----------------------------------------------------
-- Data for table `category`
-- -----------------------------------------------------
START TRANSACTION;
USE `cbdb`;
INSERT INTO `category` (`id`, `name`) VALUES (1, 'Test Category');

COMMIT;


-- -----------------------------------------------------
-- Data for table `category_has_product`
-- -----------------------------------------------------
START TRANSACTION;
USE `cbdb`;
INSERT INTO `category_has_product` (`category_id`, `product_id`) VALUES (1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `product_notes`
-- -----------------------------------------------------
START TRANSACTION;
USE `cbdb`;
INSERT INTO `product_notes` (`id`, `user_profile_id`, `product_id`, `date_created`, `notes`) VALUES (1, 1, 1, '2020-02-20 00:00:01', 'Testing out product notes.');
INSERT INTO `product_notes` (`id`, `user_profile_id`, `product_id`, `date_created`, `notes`) VALUES (2, 2, 1, '2020-02-20 00:00:01', 'Testing out product notes with second user profile.');

COMMIT;


-- -----------------------------------------------------
-- Data for table `dm`
-- -----------------------------------------------------
START TRANSACTION;
USE `cbdb`;
INSERT INTO `dm` (`id`, `composer_id`, `recipient_id`, `message`, `date_posted`) VALUES (1, 1, 2, 'Hey John! Good to have you here.', '2020-02-20');
INSERT INTO `dm` (`id`, `composer_id`, `recipient_id`, `message`, `date_posted`) VALUES (2, 2, 1, 'Yeah good to be here!', '2020-02-20');

COMMIT;


-- -----------------------------------------------------
-- Data for table `product_message`
-- -----------------------------------------------------
START TRANSACTION;
USE `cbdb`;
INSERT INTO `product_message` (`id`, `user_profile_id`, `product_id`, `message`, `replied_to_id`, `date_posted`) VALUES (1, 1, 1, 'This looks like an interesting product. Has anyone promoted this lately?', 3, '2020-02-20 00:00:01');
INSERT INTO `product_message` (`id`, `user_profile_id`, `product_id`, `message`, `replied_to_id`, `date_posted`) VALUES (2, 2, 1, 'I did a little marketing for it awhile back. Shoot me a DM if you have any questions.', 1, '2020-02-20 00:00:01');

COMMIT;

