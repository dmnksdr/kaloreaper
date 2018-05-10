DROP DATABASE kaloreaper;
CREATE DATABASE IF NOT EXISTS kaloreaper;

ALTER DATABASE kaloreaper
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

GRANT ALL PRIVILEGES ON kaloreaper.* TO pc@localhost IDENTIFIED BY 'pc';

USE kaloreaper;

CREATE TABLE IF NOT EXISTS product_category (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(80),
  INDEX(name)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS product (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(80),
  calories FLOAT,
  proteins FLOAT,
  fats FLOAT,
  carbonhydrates FLOAT,
  product_category_id INT(4) UNSIGNED,
  INDEX(name),
  FOREIGN KEY (product_category_id) REFERENCES product_category(id)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS user_table (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  login VARCHAR (80),
  name VARCHAR (80),
  surname VARCHAR (80),
  age INT,
  weight FLOAT,
  height INT,
  calories_demand INT,
  proteins_demand INT,
  carbohydrates_demand INT,
  fats_demnad INT,
  INDEX(name)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS password (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  hash CHAR(32),
  user_id INT(4) UNSIGNED NOT NULL,
  INDEX(id),
  FOREIGN KEY (user_id) REFERENCES user_table(id)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS meal_diary (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  date DATE,
  user_id INT(4) UNSIGNED NOT NULL,
  INDEX(date),
  FOREIGN KEY (user_id) REFERENCES user_table(id)
)engine=InnoDB;

CREATE TABLE IF NOT EXISTS meal (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(80),
  user_id INT(4) UNSIGNED NOT NULL,
  INDEX(name),
  FOREIGN KEY (user_id) REFERENCES user_table(id)
)engine=InnoDB;

CREATE TABLE IF NOT EXISTS meal_diary_meal (
  meal_id INT(4) UNSIGNED NOT NULL,
  product_id INT(4) UNSIGNED NOT NULL,
  PRIMARY KEY (meal_id, product_id),
  FOREIGN KEY (meal_id) REFERENCES meal(id),
  FOREIGN KEY (product_id) REFERENCES product(id)
)engine=InnoDB;



CREATE TABLE IF NOT EXISTS vets (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  INDEX(last_name)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS specialties (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(80),
  INDEX(name)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS vet_specialties (
  vet_id INT(4) UNSIGNED NOT NULL,
  specialty_id INT(4) UNSIGNED NOT NULL,
  FOREIGN KEY (vet_id) REFERENCES vets(id),
  FOREIGN KEY (specialty_id) REFERENCES specialties(id),
  UNIQUE (vet_id,specialty_id)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS types (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(80),
  INDEX(name)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS owners (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  address VARCHAR(255),
  city VARCHAR(80),
  telephone VARCHAR(20),
  INDEX(last_name)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS pets (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30),
  birth_date DATE,
  type_id INT(4) UNSIGNED NOT NULL,
  owner_id INT(4) UNSIGNED NOT NULL,
  INDEX(name),
  FOREIGN KEY (owner_id) REFERENCES owners(id),
  FOREIGN KEY (type_id) REFERENCES types(id)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS visits (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  pet_id INT(4) UNSIGNED NOT NULL,
  visit_date DATE,
  description VARCHAR(255),
  FOREIGN KEY (pet_id) REFERENCES pets(id)
) engine=InnoDB;
