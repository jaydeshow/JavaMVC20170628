CREATE TABLE `sakila`.`customers` (
  `customerid` CHAR(5) NOT NULL,
  `companyname` VARCHAR(45) NULL,
  `address` VARCHAR(100) NULL,
  `phone` VARCHAR(30) NULL,
  PRIMARY KEY (`customerid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '自建';

ALTER TABLE `sakila`.`customers` 
ADD COLUMN `aliasid` INT NULL AFTER `phone`;

CREATE TABLE `sakila`.`alias` (
  `aliasid` INT NOT NULL,
  `alias` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`aliasid`));

ALTER TABLE `sakila`.`alias` 
CHANGE COLUMN `aliasid` `aliasid` INT(11) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `sakila`.`customers` 
ADD INDEX `fk_alias_idx` (`aliasid` ASC);
ALTER TABLE `sakila`.`customers` 
ADD CONSTRAINT `fk_alias`
  FOREIGN KEY (`aliasid`)
  REFERENCES `sakila`.`alias` (`aliasid`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


INSERT INTO `sakila`.`alias` (`alias`) VALUES ('北區');
INSERT INTO `sakila`.`alias` (`alias`) VALUES ('中區');
INSERT INTO `sakila`.`alias` (`alias`) VALUES ('南區');
INSERT INTO `sakila`.`alias` (`alias`) VALUES ('花東');
INSERT INTO `sakila`.`alias` (`alias`) VALUES ('離島');
