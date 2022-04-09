# Proyecto 2022 Ciclillos

Host: ec2-3-230-122-20.compute-1.amazonaws.com

Database: d4gsagactd5tb4

User: ttlpdzwqtuszgz

Port: 5432

Password: 91521990bffc598c3c02c525232ae99b73beeeec7db54d4f9335b6a0f2c5c983

URI: postgres://ttlpdzwqtuszgz:91521990bffc598c3c02c525232ae99b73beeeec7db54d4f9335b6a0f2c5c983@ec2-3-230-122-20.compute-1.amazonaws.com:5432/d4gsagactd5tb4

Heroku CLI: heroku pg:psql postgresql-lively-75408 --app proyect2022cdvs
--Drops\
drop table "Proyecto".usuarios;\
drop table "Proyecto".recursos;\
drop table "Proyecto".tipoRecurso;\
drop table "Proyecto".ubicacionRecursos;\
--Crear tablas\
CREATE TABLE  "Proyecto".usuarios(\
	id INT not null,\
	rol VARCHAR(30) not null,\
	correo VARCHAR(30) not null,\
	clave VARCHAR(30) not null\
);\

CREATE TABLE "Proyecto".recursos (\
	id int NOT NULL,\
	tipo int NOT NULL,\
	fechaIncio DATE not null,\
	fechaFin DATE not null,\
	observaciones varchar(30) NOT NULL
);\
create table "Proyecto".tipoRecursos(\
	id int NOT NULL,\
	nombre varchar(30) NOT NULL,\
	descripcion varchar(30)\
);\
create table "Proyecto".ubicacionRecursos(\
	id int NOT NULL,\
	lugar varchar(30) NOT NULL\
);\
--Primarias\
--Forareas\
--Unicas
