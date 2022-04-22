--Crear tablas
CREATE TABLE USUARIOS(
	id INT not null,
	rol VARCHAR(30) not null,
	correo VARCHAR(30) not null,
	clave VARCHAR(30) not null
);

CREATE TABLE RECURSOS(
	id int NOT NULL,
	nombre varchar(30) NOT NULL,
	tipo int NOT NULL,
	capacidad int NOT NULL,
	fechaInicio DATE not null,
	fechaFin DATE not null,
	ubicacion int NOT NULL,
	disponibilidad varchar(15),
	observaciones varchar(30) NOT NULL,
);

CREATE TABLE TIPO_RECURSOS(
	id int NOT NULL,
	nombre varchar(30) NOT NULL,
	descripcion varchar(30)
);

CREATE TABLE UBICACIONES(
	id int NOT NULL,
	lugar varchar(30) NOT NULL
);

CREATE TABLE RESERVAS(
	id int NOT NULL,
	usuario INT not null,
	recurso INT NOT NULL,
	fechaIncio DATE not null,
	fechaFin DATE not null
);
--Primarias
alter table usuarios add constraint USUARIOS_PK primary key (id);
alter table recursos add constraint RECURSOS_PK primary key (id);
alter table tipo_recursos add constraint TIPO_RECURSOS_PK primary key (id);
alter table ubicaciones add constraint UBICACIONES_PK primary key (id);
alter table reservas add constraint RESERVAS_PK primary key (id);
--Forareas
alter TABLE recursos
add CONSTRAINT RECURSOS_TIPO_FK
FOREIGN KEY (tipo) REFERENCES TIPO_RECURSOS(id);

alter TABLE recursos
add CONSTRAINT RECURSOS_UBICACION_FK
FOREIGN KEY (ubicacion) REFERENCES UBICACIONES(id);

alter TABLE reservas
add CONSTRAINT RESERVAS_USUARIO_FK
FOREIGN KEY (usuario) REFERENCES USUARIOS(id);

alter TABLE reservas
add CONSTRAINT RESERVAS_RECURSO_FK
FOREIGN KEY (recurso) REFERENCES RECURSOS(id);

--Poblar
insert into usuarios (id, rol, correo, clave) values (1, 'administrador', 'admon', 'admon');
insert into usuarios (id, rol, correo, clave) values (2, 'secretaria', 'secre@gmail.com', 'admon');
insert into usuarios (id, rol, correo, clave) values (3, 'Pedro', 'pedro@gmail.com', 'admon');
insert into usuarios (id, rol, correo, clave) values (4, 'Laura', 'laura@gmail.com', 'admon');
insert into usuarios (id, rol, correo, clave) values (5, 'Andres', 'andres@gmail.com', 'admon');
insert into usuarios (id, rol, correo, clave) values (6, 'Felipe', 'felipe@gmial.com', 'admon');
insert into usuarios (id, rol, correo, clave) values (7, 'David', 'david@gmail.com', 'admon');
insert into usuarios (id, rol, correo, clave) values (8, 'Alejandra', 'alejandra@gmail.com', 'admon');

insert into tipo_recursos (	id, nombre, descripcion) values (1, 'Libros', 'Libros de la escuela');
insert into tipo_recursos (	id, nombre, descripcion) values (2, 'Sala de estudio', '');
insert into tipo_recursos (	id, nombre, descripcion) values (3, 'Portatil', '');
insert into tipo_recursos (	id, nombre, descripcion) values (4, 'Tablet', '');
insert into tipo_recursos (	id, nombre, descripcion) values (5, 'Computador de mesa', '');

insert into ubicaciones ( id, lugar) values (1, 'Biblioteca del edificio B');
insert into ubicaciones ( id, lugar) values (2, 'Biblioteca del edificio G');

insert into recursos (	id, nombre, tipo, capacidad, fechaInicio, fechaFin, ubicacion, observaciones) values (25478, 'Probabilidad y estadistica', 1, 1, '2022-02-02', '2022-03-03', 1, 'Pasta en mal estado');
insert into recursos (	id, nombre, tipo, capacidad, fechaInicio, fechaFin, ubicacion, observaciones) values (58749, 'Fisica para ingenieros', 1, 1, '2022-01-02', '2022-02-03', 2, 'Perdida de hojas');
insert into recursos (	id, nombre, tipo, capacidad, fechaInicio, fechaFin, ubicacion, observaciones) values (79451, 'Sala de estudio 1', 2, 1, '2022-04-02', '2022-07-20', 1, 'Borrador dañado');
insert into recursos (	id, nombre, tipo, capacidad, fechaInicio, fechaFin, ubicacion, observaciones) values (23058, 'Portatil026', 3, 1, '2022-02-02', '2022-03-03', 2, '');
insert into recursos (	id, nombre, tipo, capacidad, fechaInicio, fechaFin, ubicacion, observaciones) values (95847, 'tablet78', 4, 1, '2022-02-08', '2022-09-03', 1, 'Pantalla rayada');
insert into recursos (	id, nombre, tipo, capacidad, fechaInicio, fechaFin, ubicacion, observaciones) values (28748, 'computador21', 5, 1, '2022-02-02', '2022-03-03', 2, 'tecla A dañada');

insert into reservas (	id, usuario, recurso, fechaIncio, fechaFin) values (134, 3, 25478, '2022-02-02', '2022-03-03');
insert into reservas (	id, usuario, recurso, fechaIncio, fechaFin) values (135, 4, 58749, '2022-01-02', '2022-01-03');
insert into reservas (	id, usuario, recurso, fechaIncio, fechaFin) values (136, 5, 79451, '2022-02-23', '2022-03-24');
insert into reservas (	id, usuario, recurso, fechaIncio, fechaFin) values (137, 8, 23058, '2022-04-08', '2022-03-10');
insert into reservas (	id, usuario, recurso, fechaIncio, fechaFin) values (138, 6, 95847, '2022-02-15', '2022-03-15');
insert into reservas (	id, usuario, recurso, fechaIncio, fechaFin) values (139, 7, 28748, '2022-08-02', '2022-08-02');
