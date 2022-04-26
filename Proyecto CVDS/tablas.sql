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
insert into recursos (id, nombre, capacidad, fechaInicio, fechaFin, disponibilidad, observaciones, tipo, ubicacion) values (666, 'Calculo en varias variables', 1, '2022-02-02', '2022-03-03', 'Disponible', '.', 1, 1);
insert into recursos (id, nombre, capacidad, fechaInicio, fechaFin, disponibilidad, observaciones, tipo, ubicacion) values (784, 'Laptop acer', 1, '2022-02-02', '2022-03-03', 'Disponible', 'Tecla a no sirve', 3, 2);
insert into recursos (id, nombre, capacidad, fechaInicio, fechaFin, disponibilidad, observaciones, tipo, ubicacion) values (451, 'Ingles 2', 1, '2022-05-02', '2022-05-03', 'Disponible', '', 1, 2);
insert into recursos (id, nombre, capacidad, fechaInicio, fechaFin, disponibilidad, observaciones, tipo, ubicacion) values (101, 'Sala de estudio 06', 1, '2022-01-22', '2022-05-03', 'Disponible', '', 2, 1);
insert into recursos (id, nombre, capacidad, fechaInicio, fechaFin, disponibilidad, observaciones, tipo, ubicacion) values (102, 'Sala de estudio 05', 1, '2022-05-12', '2022-05-13', 'Disponible', '', 2, 1);
insert into recursos (id, nombre, capacidad, fechaInicio, fechaFin, disponibilidad, observaciones, tipo, ubicacion) values (100, 'Sala de estudio 04', 1, '2022-01-22', '2022-05-03', 'Disponible', '', 2, 1);
insert into recursos (id, nombre, capacidad, fechaInicio, fechaFin, disponibilidad, observaciones, tipo, ubicacion) values (990, 'Sala de estudio 03', 1, '2022-10-01', '2022-10-03', 'Disponible', '', 2, 1);
insert into recursos (id, nombre, capacidad, fechaInicio, fechaFin, disponibilidad, observaciones, tipo, ubicacion) values (245, 'Precalculo ', 1, '2022-05-02', '2022-05-03', 'Disponible', '', 1, 2);
insert into recursos (id, nombre, capacidad, fechaInicio, fechaFin, disponibilidad, observaciones, tipo, ubicacion) values (789, 'Calculo integral', 1, '2022-05-25', '2022-05-26', 'Disponible', '', 1, 1);
insert into recursos (id, nombre, capacidad, fechaInicio, fechaFin, disponibilidad, observaciones, tipo, ubicacion) values (157, 'Calculo diferencial', 1, '2022-05-14', '2022-05-16', 'Disponible', '', 1, 1);
insert into recursos (id, nombre, capacidad, fechaInicio, fechaFin, disponibilidad, observaciones, tipo, ubicacion) values (935, 'Calculo vectorial', 1, '2022-05-14', '2022-05-15', 'Disponible', '', 1, 2);
insert into recursos (id, nombre, capacidad, fechaInicio, fechaFin, disponibilidad, observaciones, tipo, ubicacion) values (521, 'Tablet asus', 1, '2022-01-22', '2022-05-03', 'Disponible', '', 4, 2);
insert into recursos (id, nombre, capacidad, fechaInicio, fechaFin, disponibilidad, observaciones, tipo, ubicacion) values (511, 'Tablet note 8', 1, '2022-04-22', '2022-05-03', 'Disponible', 'Pantalla rayada', 4, 1);
insert into recursos (id, nombre, capacidad, fechaInicio, fechaFin, disponibilidad, observaciones, tipo, ubicacion) values (571, 'Computador 8', 1, '2022-01-22', '2022-05-03', 'Disponible', 'Computador lento', 5, 1);
insert into recursos (id, nombre, capacidad, fechaInicio, fechaFin, disponibilidad, observaciones, tipo, ubicacion) values (851, 'Computador 1', 1, '2022-01-22', '2022-05-22', 'Disponible', 'Mouse con cable roto', 5, 1);
insert into recursos (id, nombre, capacidad, fechaInicio, fechaFin, disponibilidad, observaciones, tipo, ubicacion) values (365, 'Fisica 1', 1, '2022-05-14', '2022-05-15', 'Disponible', '', 1, 2);
insert into recursos (id, nombre, capacidad, fechaInicio, fechaFin, disponibilidad, observaciones, tipo, ubicacion) values (388, 'Fisica 2', 1, '2022-05-14', '2022-05-15', 'Disponible', '', 1, 1);
insert into recursos (id, nombre, capacidad, fechaInicio, fechaFin, disponibilidad, observaciones, tipo, ubicacion) values (461, 'Ingles 2', 1, '2022-05-22', '2022-05-23', 'Disponible', '', 1, 1);
insert into recursos (id, nombre, capacidad, fechaInicio, fechaFin, disponibilidad, observaciones, tipo, ubicacion) values (488, 'Ingles 3', 1, '2022-05-02', '2022-05-03', 'Disponible', '', 1, 1);
insert into recursos (id, nombre, capacidad, fechaInicio, fechaFin, disponibilidad, observaciones, tipo, ubicacion) values (499, 'Ingles 4', 1, '2022-08-02', '2022-08-23', 'Disponible', '', 1, 2);
insert into recursos (id, nombre, capacidad, fechaInicio, fechaFin, disponibilidad, observaciones, tipo, ubicacion) values (454, 'Ingles 1', 1, '2022-05-02', '2022-05-03', 'Disponible', '', 1, 2);
--no está en la db
