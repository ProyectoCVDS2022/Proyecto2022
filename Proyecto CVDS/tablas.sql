--Drops
drop table "Proyecto".usuarios;
drop table "Proyecto".recursos;
drop table "Proyecto".tipoRecurso;
drop table "Proyecto".ubicacionRecursos;
drop table "Proyecto".reservas;
--Crear tablas
CREATE TABLE  "Proyecto".usuarios(
	id INT not null,
	rol VARCHAR(30) not null,
	correo VARCHAR(30) not null,
	clave VARCHAR(30) not null
);

CREATE TABLE "Proyecto".recursos(
	id int NOT NULL,
	tipo int NOT NULL,
	fechaInicio DATE not null,
	fechaFin DATE not null,
	ubicacion int NOT NULL,
	observaciones varchar(30) NOT NULL
);
create table "Proyecto".tipoRecursos(
	id int NOT NULL,
	nombre varchar(30) NOT NULL,
	descripcion varchar(30)
);
create table "Proyecto".ubicaciones(
	id int NOT NULL,
	lugar varchar(30) NOT NULL
);
create table "Proyecto".reservas(
	id int NOT NULL,
	usuario INT not null,
	recurso INT NOT NULL,
	fechaIncio DATE not null,
	fechaFin DATE not null
);
--Primarias
--Forareas
--Unicas