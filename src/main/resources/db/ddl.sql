DROP TABLE IF EXISTS accounts CASCADE;
DROP TABLE IF EXISTS roles CASCADE;
DROP TABLE IF EXISTS cart CASCADE;
DROP TABLE IF EXISTS cart_items CASCADE;
DROP TABLE IF EXISTS category CASCADE;
DROP TABLE IF EXISTS orders CASCADE;
DROP TABLE IF EXISTS products CASCADE;
DROP TABLE IF EXISTS reviews CASCADE;
DROP TABLE IF EXISTS order_items CASCADE;

CREATE TABLE roles (
	id VARCHAR PRIMARY KEY,
	name VARCHAR
);

CREATE TABLE accounts (
	id VARCHAR PRIMARY KEY,
	username VARCHAR,
	password VARCHAR NOT NULL,
	role_id VARCHAR,
);

CREATE TABLE category(
id VARCHAR PRIMARY KEY,
name VARCHAR
);

CREATE TABLE products(
id VARCHAR PRIMARY KEY,
description VARCHAR,
price DECIMAL,
on_hand INT,
category_id VARCHAR,
FOREIGN KEY (category_id) REFERENCES category (id)
);

CREATE TABLE cart (
	id VARCHAR PRIMARY KEY,
	account_id VARCHAR,
	FOREIGN KEY (account_id) REFERENCES accounts (id)
);

CREATE TABLE cart_items (
	id VARCHAR PRIMARY KEY,
	quantity INT NOT NULL,
	price DECIMAL NOT NULL,
	product_id VARCHAR NOT NULL,
	cart_id VARCHAR NOT NULL,
	FOREIGN KEY (product_id) REFERENCES products (id),
	FOREIGN KEY (cart_id) REFERENCES cart (id)
);

CREATE TABLE orders(
id VARCHAR PRIMARY KEY,
total_cost DECIMAL,
account_id VARCHAR,
FOREIGN KEY (account_id) REFERENCES accounts (id)
);

CREATE TABLE order_items(
id VARCHAR PRIMARY KEY,
quantity INT,
account_id VARCHAR,
order_id VARCHAR,
product_id VARCHAR,
FOREIGN KEY (order_id) REFERENCES orders (id),
FOREIGN KEY (product_id) REFERENCES products (id)
);

CREATE TABLE reviews(
id VARCHAR PRIMARY KEY,
stars INT,
comment VARCHAR,
account_id VARCHAR,
product_id VARCHAR,
FOREIGN KEY (account_id) REFERENCES accounts (id),
FOREIGN KEY (product_id) REFERENCES products (id)
);







