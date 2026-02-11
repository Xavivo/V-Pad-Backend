INSERT INTO dish (id, name, price, ingredients, description) VALUES (1, 'Pizza 4 queso', 10.00, '1, Gouda, Cheddar, Parmesano', 'Illooo que hambre colega');
INSERT INTO dish (id, name, price, ingredients, description) VALUES (2, 'Hamburguesa Clásica', 8.50, 'Carne de res, Lechuga, Tomate, Cebolla, Pepinillos, Queso cheddar', 'La clásica de la avenida loquete');
INSERT INTO dish (id, name, price, ingredients, description) VALUES (3, 'Ensalada César', 7.00, 'Lechuga, Pollo a la parrilla, Pan, Queso parmesano, Salsa césar', 'Fresca y deliciosa para los amantes de las ensaladas');
INSERT INTO dish (id, name, price, ingredients, description) VALUES (4, 'Tacos al Pastor', 9.00, 'Carne de cerdo marinada, Piña, Cebolla, Cilantro, Salsa al pastor', 'Un clásico mexicano con un toque dulce y picante');
INSERT INTO dish (id, name, price, ingredients, description) VALUES (5, 'Dalas Burguer', 14.50, 'Carne de vacuno, Lechuga, Aros de cebolla, Cebolla, Pepinillos, Queso curado, Mayonesa', 'Doble smash de ternera retinta, BBQ pulled pork, cheddar, topping bacon, salsa cheddar y aros de cebolla.');

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
INSERT INTO ingredient (id, name) VALUES (11, 'Pollo a la parrilla');
INSERT INTO ingredient (id, name) VALUES (12, 'Pan');
INSERT InTO ingredient (id, name) VALUES (13, 'Salsa césar');
INSERT INTO ingredient (id, name) VALUES (14, 'Carne de cerdo marinada');
INSERT INTO ingredient (id, name) VALUES (15, 'Piña');
INSERT INTO ingredient (id, name) VALUES (16, 'Cilantro');
INSERT INTO ingredient (id, name) VALUES (17, 'Salsa al pastor');
INSERT INTO ingredient (id, name) VALUES (18, 'Carne de vacuno');
INSERT INTO ingredient (id, name) VALUES (19, 'Aros de cebolla');
INSERT INTO ingredient (id, name) VALUES (20, 'Queso curado');
INSERT INTO ingredient (id, name) VALUES (21, 'Mayonesa');

INSERT INTO orders (id, date, total, status) VALUES (1, '2023-04-05T12:00:00', 18.50, 'PENDING');
INSERT INTO orders (id, date, total, status) VALUES (2, '2023-04-06T12:30:00', 10.00, 'COMPLETED');

INSERT INTO order_details (id, order_id, dish_id, quantity, unit_price) VALUES (1, 1, 1, 1, 10.00);
INSERT INTO order_details (id, order_id, dish_id, quantity, unit_price) VALUES (2, 2, 2, 1, 8.50);
