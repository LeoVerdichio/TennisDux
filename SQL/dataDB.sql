use dbtest;

insert into
	rubro (rubro)
values
	("librería"),
	("electro"),
	("bazar");

insert into
	producto (codigo, nombre, fecha_creacion, id_rubro)
values
	("01", "lapicera", '2022-09-07', 1),
	("02", "hojas", '2022-09-07', 1),
	("03", "tijera", '2022-09-07', 1),
	("04", "goma", '2022-07-07', 1),
	("05", "carpeta", '2022-04-12', 1),
	("06", "vaso", '2022-05-16', 3),
	("07", "taza", '2022-02-22', 3),
	("08", "jarra", '2022-01-17', 3),
	("09", "jarron", '2021-08-08', 3),
	("010", "tostadora", '2021-11-23', 2),
	("011", "mouse", '2022-05-01', 2),
	("012", "tazon", '2022-01-01', 3);

insert into
	cliente (nombre, apellido, cuit)
values
	("Ivan", "Pineda", '1999-09-09'),
	("Rosario", "Carrasco", '2003-04-25'),
	("Azul", "Ordoñez", '1985-03-23'),
	("Leo", "Guevara", '1990-9-8'),
	("Agustín", "Clark", '2000-08-25');

insert into
	venta (codigo_producto, fecha, cantidad, precio_unitario, id_cliente)
values
	("01", '2022-09-07', 2, 150, 1),
	("01", '2022-09-07', 1, 150, 3),
	("02", '2022-09-07', 30, 100, 3),
	("03", '2022-09-07', 3, 70, 4),
	("03", '2022-05-23', 3, 70, 4),
	("07", '2021-06-04', 3, 200, 2),
	("10", '2021-12-07', 1, 780, 1),
	("012", '2022-01-05', 3, 950, 2),
	("09", '2021-10-10', 1, 150, 2);
