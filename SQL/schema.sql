
create database dbtest;

use dbtest;


create table if not exists rubro (
	id_rubro bigint not null auto_increment,
	rubro varchar(10) not null,

	primary key(id_rubro)
);

create table if not exists producto (
	codigo varchar(10) not null,
	nombre varchar(10) not null,
	fecha_creacion date not null,
	id_rubro bigint not null,

	primary key(codigo),
	foreign key(id_rubro) references rubro(id_rubro)
);


create table if not exists cliente (
	id_cliente bigint not null auto_increment,
	nombre varchar(10) not null,
	apellido varchar(10) not null,
	cuit date not null,

	primary key(id_cliente)
);


create table if not exists venta (
	id_venta bigint not null auto_increment,
	codigo_producto varchar(10) not null,
	fecha date not null,
	cantidad bigint not null,
	precio_unitario double not null,
	id_cliente bigint not null,

	primary key(id_venta),
	foreign key(id_cliente) references cliente(id_cliente),
	foreign key(codigo_producto) references producto(codigo)
);
