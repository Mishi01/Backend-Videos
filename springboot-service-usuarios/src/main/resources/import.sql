INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('alix', '12345', 1, 'Alissa', 'Garcia', 'alissa@gmail.com')
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('felixx', '12345', 1, 'Elian', 'Bocanegra', 'felixx@gmail.com');

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES (1,1);
INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES (2,2);
INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES (2,1);