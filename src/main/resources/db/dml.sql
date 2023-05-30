INSERT INTO category (id, name) VALUES ('1', 'category 1');
INSERT INTO category (id, name) VALUES ('2', 'category 2');
INSERT INTO category (id, name) VALUES ('3', 'category 3');
INSERT INTO category (id, name) VALUES ('4', 'category 4');

INSERT INTO products (id, description, price, on_hand, category_id) VALUES ('product 1', 'product 1 desc', 100, 10, '1');
INSERT INTO products (id, description, price, on_hand, category_id) VALUES ('product 2', 'product 2 desc', 50, 10, '1');
INSERT INTO products (id, description, price, on_hand, category_id) VALUES ('product 3', 'product 3 desc', 20, 10, '2');
INSERT INTO products (id, description, price, on_hand, category_id) VALUES ('product 4', 'product 4 desc', 10, 10, '2');
INSERT INTO products (id, description, price, on_hand, category_id) VALUES ('product 5', 'product 5 desc', 5, 10, '3');
INSERT INTO products (id, description, price, on_hand, category_id) VALUES ('product 6', 'product 6 desc', 80, 10, '3');
INSERT INTO products (id, description, price, on_hand, category_id) VALUES ('product 7', 'product 7 desc', 45, 10, '4');
INSERT INTO products (id, description, price, on_hand, category_id) VALUES ('product 8', 'product 8 desc', 30, 10, '4');

INSERT INTO roles (id, name) VALUES ('1', 'ADMIN');
INSERT INTO roles (id, name) VALUES ('2', 'USER');