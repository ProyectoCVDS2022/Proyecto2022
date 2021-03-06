--Crear tablas
CREATE TABLE usuarios(
	id INT NOT NULL,
	rol VARCHAR(30) NOT NULL,
	correo VARCHAR(30) NOT NULL,
	clave VARCHAR(30) NOT NULL
);

CREATE TABLE RECURSOS(
	id int NOT NULL,
	nombre varchar(30) NOT NULL,
	capacidad int NOT NULL,
	fechaInicio TIME NOT NULL,
	fechaFin TIME NOT NULL,
	disponibilidad varchar(15) NOT NULL,
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
	lugar varchar(50) NOT NULL
);

CREATE TABLE RESERVAS(
	id int NOT NULL,
	usuario INT not null,
	recurso INT NOT NULL,
	fechaSolicitud TIMESTAMP not null,
	fechaIncio TIMESTAMP not null,
	fechaFin TIMESTAMP  not null,
	recurrente bool not null,
	recurrencia varchar(30),
	cancelada bool not null
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

insert into tipo_recursos (	id, nombre, descripcion) values (1, 'Libro', '');
insert into tipo_recursos (	id, nombre, descripcion) values (2, 'Sala de estudio', '');
insert into tipo_recursos (	id, nombre, descripcion) values (3, 'Portatil', '');
insert into tipo_recursos (	id, nombre, descripcion) values (4, 'Computador de escritorio', '');

insert into ubicaciones ( id, lugar) values (1, 'Biblioteca Jorge ??lvarez Lleras');
insert into ubicaciones ( id, lugar) values (2, 'Biblioteca del edificio G');

insert into recursos (id, nombre, capacidad, fechaInicio, fechaFin, disponibilidad, observaciones, tipo, ubicacion) values (101, 'Probabilidad y estadistica', 1, '07:00:00', '17:00:00', 'Disponible', 'Pasta en mal estado', 1, 2);
insert into recursos (id, nombre, capacidad, fechaInicio, fechaFin, disponibilidad, observaciones, tipo, ubicacion) values (102, 'C??lculo integral', 1, '07:00:00', '17:00:00', 'No disponible', '', 1, 2);
insert into recursos (id, nombre, capacidad, fechaInicio, fechaFin, disponibilidad, observaciones, tipo, ubicacion) values (103, 'C??lculo diferencial', 1, '07:00:00', '17:00:00', 'No disponible', '', 1, 2);
insert into recursos (id, nombre, capacidad, fechaInicio, fechaFin, disponibilidad, observaciones, tipo, ubicacion) values (301, 'Portatil 1', 1, '07:00:00', '17:00:00', 'Disponible', '', 3, 2);
insert into recursos (id, nombre, capacidad, fechaInicio, fechaFin, disponibilidad, observaciones, tipo, ubicacion) values (302, 'Portatil 2', 1, '07:00:00', '17:00:00', 'No disponible', '', 3, 1);
insert into recursos (id, nombre, capacidad, fechaInicio, fechaFin, disponibilidad, observaciones, tipo, ubicacion) values (303, 'Portatil 3', 1, '07:00:00', '17:00:00', 'Disponible', '', 3, 1);
insert into recursos (id, nombre, capacidad, fechaInicio, fechaFin, disponibilidad, observaciones, tipo, ubicacion) values (201, 'Sala de estudio 1', 5, '08:00:00', '17:00:00', 'Disponible', '', 2, 1);
insert into recursos (id, nombre, capacidad, fechaInicio, fechaFin, disponibilidad, observaciones, tipo, ubicacion) values (202, 'Sala de estudio 2', 5, '08:00:00', '17:00:00', 'Disponible', '', 2, 1);
insert into recursos (id, nombre, capacidad, fechaInicio, fechaFin, disponibilidad, observaciones, tipo, ubicacion) values (203, 'Sala de estudio 3', 5, '08:00:00', '17:00:00', 'No disponible', '', 2, 1);
insert into recursos (id, nombre, capacidad, fechaInicio, fechaFin, disponibilidad, observaciones, tipo, ubicacion) values (401, 'Computador 01', 1, '08:00:00', '17:00:00', 'Disponible', '', 4, 1);
insert into recursos (id, nombre, capacidad, fechaInicio, fechaFin, disponibilidad, observaciones, tipo, ubicacion) values (402, 'Computador 02', 1, '08:00:00', '17:00:00', 'Disponible', '', 4, 1);
insert into recursos (id, nombre, capacidad, fechaInicio, fechaFin, disponibilidad, observaciones, tipo, ubicacion) values (403, 'Computador 03', 1, '08:00:00', '17:00:00', 'No disponible', '', 4, 1);
--no est?? en la db
