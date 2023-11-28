INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('alix', '$2a$10$o84ELrcxSqr8Rpwz9Bo8ZuhsuLhLddX/7noz7gCuigmpccNtCtkkC', 1, 'Alissa', 'Garcia', 'alissa@gmail.com')
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('felixx', '$2a$10$qLoXNkgVWKai9BP0awimve7Yv5zAnKI8Y.kvzUKJ4ebEWe6tIcRZ6', 1, 'Elian', 'Bocanegra', 'felixx@gmail.com');

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES (1,1);
INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES (2,2);
INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES (2,1);