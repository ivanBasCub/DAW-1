

create or replace type TObjCliente as object(
	CodCl number,
	Nombre varchar2(50),
	prApellido varchar2(50),
	Domicilio TObjDomicilio,
	Telefonos tTelefono
	-- Constructor
	constructor function TObjCliente(cod number, Nom varchar2, Ape varchar2, tel number, Via number, NomVia varchar2, Numero number, CPro number, Cloc number) return self as result,
	-- Funciones
	menber procedure getCliente
);