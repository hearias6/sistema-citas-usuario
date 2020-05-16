
insert into usuarios (username, estado, intentos, ultimo_cambio_password, password) values ('hans.arias',0, 0, NOW(), '$2a$10$dpX2xx0TEcUXqCyH7M3ot.5Mzn6FcUT4u40JKhWaH5dOjaN5UMj6e');

insert into roles (id, descripcion) values (1,'admin');
insert into roles (id, descripcion) values (2,'paciente');

insert into usuarios_roles (usuario_id, role_id) values ('hans.arias',1);