-- Créer la base de données hermy_recipe
CREATE DATABASE hermy_recipe;

-- Utiliser la base de données hermy_recipe
USE hermy_recipe;

-- Table Continent
CREATE TABLE continent (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

-- Table Country
CREATE TABLE country (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    continent_id INT,
    FOREIGN KEY (continent_id) REFERENCES continent(id)
);

-- Table Category
CREATE TABLE category (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255)
);

-- Table Ingredient
CREATE TABLE ingredient (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    calorie INT,
    quantity INT,
    price INT,
    type VARCHAR(255)
);

-- Table User
CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    firstname VARCHAR(255),
    pseudo VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255)
);

-- Table Recipe
CREATE TABLE recipe (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    preparation VARCHAR(255),
    duration VARCHAR(255),
    difficulty VARCHAR(255),
    budget VARCHAR(255),
    image VARCHAR(255),
    country_id INT,
    category_id INT,
    FOREIGN KEY (country_id) REFERENCES country(id),
    FOREIGN KEY (category_id) REFERENCES category(id)
);
-- Tables pour les relations Many-to-Many
CREATE TABLE ingredient_recipe (
    ingredient_id INT,
    recipe_id INT,
    FOREIGN KEY (ingredient_id) REFERENCES ingredient(id),
    FOREIGN KEY (recipe_id) REFERENCES recipe(id)
);

CREATE TABLE user_recipe (
    user_id INT,
    recipe_id INT,
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (recipe_id) REFERENCES recipe(id)
);