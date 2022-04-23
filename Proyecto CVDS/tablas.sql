--Crear tablas
CREATE TABLE usuarios(
	`id` INT not null,
	`rol` VARCHAR(30) not null,
	`correo` VARCHAR(30) not null,
	`clave` VARCHAR(30) not null
);

CREATE TABLE RECURSOS(
	id int NOT NULL,
	nombre varchar(30) NOT NULL,
	capacidad int NOT NULL,
	fechaInicio DATE not null,
	fechaFin DATE not null,
	disponibilidad varchar(15),
	observaciones varchar(30) NOT NULL,
	tipo int NOT NULL,
	ubicacion int NOT NULL
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
insert into usuarios (id, rol, correo, clave) values (2, 'comunidad', 'julian@gmail.com', '12345');
insert into usuarios (id, rol, correo, clave) values (3, 'comunidad', 'Juank@gmail.com', '12345');

insert into tipo_recursos (	id, nombre, descripcion) values (1, 'Libros', 'Libros de la escuela');
insert into tipo_recursos (	id, nombre, descripcion) values (2, 'Sala de estudio', '');
insert into tipo_recursos (	id, nombre, descripcion) values (3, 'Portatil', '');
insert into tipo_recursos (	id, nombre, descripcion) values (4, 'Tablet', '');
insert into tipo_recursos (	id, nombre, descripcion) values (5, 'Computador de mesa', '');

insert into ubicaciones ( id, lugar) values (1, 'Biblioteca del edificio B');
insert into ubicaciones ( id, lugar) values (2, 'Biblioteca del edificio G');

insert into recursos (id, nombre, capacidad, fechaInicio, fechaFin, disponibilidad, observaciones, tipo, ubicacion) values (254, 'Probabilidad y estadistica', 1, '2022-02-02', '2022-03-03', 'Disponible', 'Pasta en mal estado', 1, 1);
insert into recursos (id, nombre, capacidad, fechaInicio, fechaFin, disponibilidad, observaciones, tipo, ubicacion) values (666, 'Cáculo en varias variables', 1, '2022-02-02', '2022-03-03', 'Disponible', '.', 1, 1);

--no está en la db
