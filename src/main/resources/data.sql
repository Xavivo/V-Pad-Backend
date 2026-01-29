INSERT INTO dish (id, name, price, ingredients, description) VALUES (1, 'Pizza 4 queso', 10.00, 'Mozzarella, Gouda, Cheddar, Parmesano', 'Illooo que hambre colega');
INSERT INTO dish (id, name, price, ingredients, description) VALUES (2, 'Hamburguesa Clásica', 8.50, 'Carne de res, lechuga, tomate, cebolla, pepinillos, queso cheddar', 'La clásica de la avenida loquete');

INSERT INTO ingredient (id, name) VALUES (1, 'Mozzarella');
INSERT INTO ingredient (id, name) VALUES (2, 'Gouda');
INSERT INTO ingredient (id, name) VALUES (3, 'Cheddar');
INSERT INTO ingredient (id, name) VALUES (4, 'Parmesano');
INSERT INTO ingredient (id, name) VALUES (5, 'Carne de res');
INSERT INTO ingredient (id, name) VALUES (6, 'Lechuga');
INSERT INTO ingredient (id, name) VALUES (7, 'Tomate');
INSERT INTO ingredient (id, name) VALUES (8, 'Cebolla');
INSERT INTO ingredient (id, name) VALUES (9, 'Pepinillos');
INSERT INTO ingredient (id, name) VALUES (10, 'Queso cheddar');

INSERT INTO orders (id, date, total, status) VALUES (1, '2023-04-05T12:00:00', 18.50, 'PENDING');
INSERT INTO orders (id, date, total, status) VALUES (2, '2023-04-06T12:30:00', 10.00, 'COMPLETED');

INSERT INTO order_details (id, order_id, dish_id, quantity, unit_price) VALUES (1, 1, 1, 1, 10.00);
INSERT INTO order_details (id, order_id, dish_id, quantity, unit_price) VALUES (2, 2, 2, 1, 8.50);
