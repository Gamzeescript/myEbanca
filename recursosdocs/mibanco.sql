drop database if exists mibanco;
create database if not exists mibanco;
use mibanco;

-- Tablas padres

create table rol(
id_rol int not null primary key auto_increment,
rol varchar(50) not null
);

insert into rol values(1, 'jefe');
insert into rol values(2, 'secretario');
insert into rol values(3, 'gerente');

create table gerencia(
id_gerencia int not null primary key auto_increment,
nombre_gerencia varchar(50) not null,
jefe_gerencia varchar(100) not null
);

insert into gerencia values(1,'gerencia de marca','Zulma Aparicio');
insert into gerencia values(2,'gerencia de estrategia','Alberto Dominguez');
insert into gerencia values(3,'gerencia general','Javier Olivo');

create table departamento(
id_departamento int not null primary key auto_increment,
nombre_departamento varchar(70) not null,
jefe_departamento varchar(100) not null
);

insert into departamento values(1,'cobros','Reina Alarcon');
insert into departamento values(2,'gestion','Yolanda Avelar');
insert into departamento values(3,'RRHH','David Solano');

create table area( 
id_area int not null primary key auto_increment,
nombre_area varchar(70) not null,
cuenta varchar(16) not null
);

insert into area values(1,'area ejecutiva','444101111');
insert into area values(2,'atencion al cliente','77889922');
insert into area values(3,'area de contratos','222110044');
insert into area values(4,'tarjeta de credito','887425555');
insert into area values(5,'area prestamos','998884477');
insert into area values(6,'area marketing','445712222');
insert into area values(7,'area ventas','7885222525');

create table banco(
id_banco int not null primary key auto_increment,
nombre_banco varchar(70) not null
);

insert into banco values(1,'banco Azul');
insert into banco values(2,'Cooperativa de los trabajores');
insert into banco values(3,'BTS');
insert into banco values(4,'Davivienda');
insert into banco values(5,'Caja de credito');


create table estado(
id_estado int not null primary key auto_increment,
nombre_estado varchar(20) not null
);

insert into estado values(1,'Entregado');
insert into estado values(2,'En Proceso');
insert into estado values(3,'Autorizado');


-- tablas hijas

create table usuario(
id_usuario int not null primary key auto_increment,
usuario varchar(50) not null,
clave varchar(50) not null,
id_rol int not null,
id_area int not null,
constraint fk_rol foreign key (id_rol) references rol(id_rol) ON UPDATE CASCADE ON DELETE CASCADE,
constraint fk_u_area foreign key (id_area) references area(id_area) ON UPDATE CASCADE ON DELETE CASCADE
);

insert into usuario values(1,'jef01','jefe110',1,1);
insert into usuario values(2,'sec01','secretaria110',2,1);
insert into usuario values(3,'ger01','gerente110',3,1);

create table presupuesto(
id_presupuesto int not null primary key auto_increment,
fecha date, 
id_gerencia int not null,
id_departamento int not null,
id_area int not null,
constraint fk_gerencia foreign key (id_gerencia) references gerencia(id_gerencia) ON UPDATE CASCADE ON DELETE CASCADE,
constraint fk_departamento foreign key (id_departamento) references departamento(id_departamento) ON UPDATE CASCADE ON DELETE CASCADE,
constraint fk_area foreign key (id_area) references area(id_area) ON UPDATE CASCADE ON DELETE CASCADE
);

create table estado_presupuesto(
id_estado_presupuesto int not null primary key auto_increment,
id_presupuesto int not null,
id_estado int not null,
constraint fk_presupuesto foreign key (id_presupuesto) references presupuesto(id_presupuesto) ON UPDATE CASCADE ON DELETE CASCADE,
constraint fk_estado foreign key (id_estado) references estado(id_estado) ON UPDATE CASCADE ON DELETE CASCADE
);

create table movimientos(
id_movimiento int not null primary key auto_increment,
tipo_movimiento varchar(20) not null,
fecha date,
id_banco int not null,
saldo decimal,
id_area int not null,
constraint fk_banco_m foreign key (id_banco) references banco(id_banco) ON UPDATE CASCADE ON DELETE CASCADE,
constraint fk_area_m foreign key (id_area) references area(id_area) ON UPDATE CASCADE ON DELETE CASCADE
);

create table comprobante(
id_comprobante int not null primary key auto_increment,
codigo varchar(8) not null,
id_estado_presupuesto int not null,
constraint fk_estado_p foreign key (id_estado_presupuesto) references estado_presupuesto(id_estado_presupuesto) ON UPDATE CASCADE ON DELETE CASCADE
);

-- Bloque de codigo para auto-generar la fecha de registro

DELIMITER //
CREATE TRIGGER tr_fecha_mov
BEFORE INSERT ON movimientos
FOR EACH ROW
BEGIN 
set new.fecha = now(); 
END;
//

DELIMITER //
CREATE TRIGGER tr_fecha_presupuesto
BEFORE INSERT ON presupuesto
FOR EACH ROW
BEGIN 
set new.fecha = now(); 
END;
//

DELIMITER //
CREATE TRIGGER tr_comprobante
BEFORE INSERT ON comprobante
FOR EACH ROW
BEGIN
SET new.codigo = LPAD(FLOOR(1000+ RAND() * 8999),6,'0');
END;
//




