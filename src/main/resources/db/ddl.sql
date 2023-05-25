SET search_path TO p0;
DROP TABLE IF EXISTS roles CASCADE;
DROP TABLE IF EXISTS accounts CASCADE;
DROP TABLE IF EXISTS orders CASCADE;
DROP TABLE IF EXISTS categories CASCADE;
DROP TABLE IF EXISTS products CASCADE;
DROP TABLE IF EXISTS reviews CASCADE;
DROP TABLE IF EXISTS cart_items CASCADE;
DROP TABLE IF EXISTS cart CASCADE;
DROP TABLE IF EXISTS order_items CASCADE;

CREATE TABLE roles (
	id INT PRIMARY KEY,
	name VARCHAR NOT NULL
);

CREATE TABLE accounts (
	id VARCHAR PRIMARY KEY,
	username VARCHAR NOT NULL UNIQUE,
	password VARCHAR NOT NULL,
	role_id INT NOT NULL,
	FOREIGN KEY (role_id) REFERENCES roles (id)
);

CREATE TABLE categories (
	id INT PRIMARY KEY,
	name VARCHAR NOT NULL
);

CREATE TABLE products (
	id VARCHAR PRIMARY KEY,
	description VARCHAR NOT NULL,
	price DECIMAL NOT NULL,
	on_hand INT,
	category_id INT NOT NULL,
	FOREIGN KEY (category_id) REFERENCES categories (id)
);

CREATE TABLE orders (
	id VARCHAR PRIMARY KEY,
	total_cost DECIMAL NOT NULL,
	account_id VARCHAR NOT NULL,
	FOREIGN KEY (account_id) REFERENCES accounts (id)
);

CREATE TABLE reviews (
	id VARCHAR PRIMARY KEY,
	stars INT NOT NULL,
	comment VARCHAR NOT NULL,
	account_id VARCHAR NOT NULL,
	product_id VARCHAR NOT NULL,
	FOREIGN KEY (account_id) REFERENCES accounts (id),
	FOREIGN KEY (product_id) REFERENCES products (id)
);

CREATE TABLE cart (
	id INT PRIMARY KEY,
	account_id VARCHAR NOT NULL,
	FOREIGN KEY (account_id) REFERENCES accounts (id)
);

CREATE TABLE cart_items (
	id INT PRIMARY KEY,
	quantity INT NOT NULL,
	price DECIMAL NOT NULL,
	product_id VARCHAR NOT NULL,
	cart_id INT NOT NULL,
	FOREIGN KEY (product_id) REFERENCES products (id),
	FOREIGN KEY (cart_id) REFERENCES cart (id)
);

CREATE TABLE order_items (
	id INT PRIMARY KEY,
	quantity INT NOT NULL,
	product_id VARCHAR NOT NULL,
	order_id VARCHAR NOT NULL,
	FOREIGN KEY (product_id) REFERENCES products (id),
	FOREIGN KEY (order_id) REFERENCES orders (id)
);