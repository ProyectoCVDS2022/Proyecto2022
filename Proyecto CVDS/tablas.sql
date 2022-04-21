--Drops
--Crear tablas
CREATE TABLE USUARIOS(
	id INT not null,
	rol VARCHAR(30) not null,
	correo VARCHAR(30) not null,
	clave VARCHAR(30) not null,
	CONSTRAINT USUARIOS_PK PRIMARY KEY (id)
);

CREATE TABLE RECURSOS(
	id int NOT NULL,
	tipo int NOT NULL,
	fechaInicio DATE not null,
	fechaFin DATE not null,
	ubicacion int NOT NULL,
	observaciones varchar(30) NOT NULL,
	CONSTRAINT RECURSOS_PK PRIMARY KEY (id)
);

CREATE TABLE TIPO_RECURSOS(
	id int NOT NULL,
	nombre varchar(30) NOT NULL,
	descripcion varchar(30),
	CONSTRAINT TIPO_RECURSOS_PK PRIMARY KEY (id)
);

CREATE TABLE UBICACIONES(
	id int NOT NULL,
	lugar varchar(30) NOT NULL,
	CONSTRAINT UBICACIONES_PK PRIMARY KEY (id)
);

CREATE TABLE RESERVAS(
	id int NOT NULL,
	usuario INT not null,
	recurso INT NOT NULL,
	fechaIncio DATE not null,
	fechaFin DATE not null,
	CONSTRAINT RESERVAS_PK PRIMARY KEY (id)
);

--FKs
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

insert into usuarios (id, rol, correo, clave) values (1, 'administrador', 'admon', 'admon');
--Primarias
--Forareas
--Unicas