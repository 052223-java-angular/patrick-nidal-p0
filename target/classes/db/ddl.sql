DROP TABLE IF EXISTS account CASCADE;
DROP TABLE IF EXISTS role CASCADE;
DROP TABLE IF EXISTS order CASCADE;
DROP TABLE IF EXISTS category CASCADE;
DROP TABLE IF EXISTS product CASCADE;
DROP TABLE IF EXISTS review CASCADE;

CREATE TABLE account (
user_id VARCHAR PRIMARY KEY,
username VARCHAR NOT NULL UNIQUE,
password VARCHAR NOT NULL,
role_id VARCHAR NOT NULL,
FOREIGN KEY (role_id) REFERENCES role (role_id)
);

CREATE TABLE role (
    role_id INT PRIMARY KEY,
    role VARCHAR NOT NULL
);

CREATE TABLE order (
    order_id VARCHAR PRIMARY KEY,
    user_id VARCHAR NOT NULL,
    product_id VARCHAR NOT NULL,
    quantity VARCHAR NOT NULL,
    FOREIGN KEY (user_id) REFERENCES account (user_id),
    FOREIGN KEY (product_id) REFERENCES product (product_id)
);

CREATE TABLE product (
    product_id VARCHAR PRIMARY KEY,
    category_id VARCHAR NOT NULL,
    price INT NOT NULL,
    on_hand INT,
    FOREIGN KEY (category_id) REFERENCES category (category_id)
);

CREATE TABLE category (
category_id INT PRIMARY KEY,
name VARCHAR NOT NULL
);

CREATE TABLE review (
    review_id VARCHAR PRIMARY KEY,
    user_id VARCHAR NOT NULL,
    product_id VARCHAR NOT NULL,
    stars VARCHAR NOT NULL,
    comment VARCHAR NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user (user_id),
    FOREIGN KEY (product_id) REFERENCES product (product_id)
);
