--Drops
--Crear tablas
CREATE TABLE USUARIOS(
	id INT not null,
	rol VARCHAR(30) not null,
	correo VARCHAR(30) not null,
	clave VARCHAR(30) not null
);

CREATE TABLE RECURSOS(
	id int NOT NULL,
	tipo int NOT NULL,
	fechaInicio DATE not null,
	fechaFin DATE not null,
	ubicacion int NOT NULL,
	observaciones varchar(30) NOT NULL
);
create table TIPO_RECURSOS(
	id int NOT NULL,
	nombre varchar(30) NOT NULL,
	descripcion varchar(30)
);
create table UBICACIONES(
	id int NOT NULL,
	lugar varchar(30) NOT NULL
);
create table RESERVAS(
	id int NOT NULL,
	usuario INT not null,
	recurso INT NOT NULL,
	fechaIncio DATE not null,
	fechaFin DATE not null
);
--Primarias
--Forareas
--Unicas