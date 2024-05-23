create user c##ejer3BDOR identified by ejer3;

grant all privileges to c##ejer3BDOR;


set serveroutput on;

create or replace type tTelefono as varray(4) of number(9);
/

create or replace type TObjCodPostal as object(
	CodProvincia number,
	CodLocalidad number
)
/

create or replace type TObjDomicilio as object(
	TipoVia number,
	NombreVia varchar2(50),
	Numero number,
	RestoDom varchar2(50),
	CP TObjCodPostal
)
/

create or replace type TObjCliente as object(
	CodCl number,
	Nombre varchar2(50),
	prApellido varchar2(50),
	Domicilio TObjDomicilio,
	Telefonos tTelefono
)
/

create or replace type tObjVenta as object(
	CodVenta number,
	Fecha date,
	Cliente ref TObjCliente
)
/

create or replace type TObjProducto as object(
	CodProd number,
	Nombre varchar2(50),
	Precio number,
	IVA number
)
/

create or replace type TObjLineaVenta as object(
	CodLinea number,
	Cantidad number,
	Producto ref TObjProducto,
	Venta ref tObjVenta
)
/

