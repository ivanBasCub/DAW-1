drop type TObjLineaVenta;
drop type tObjVenta;
drop type TObjCliente;

create or replace type TObjCliente as object(
	CodCl number,
	Nombre varchar2(50),
	prApellido varchar2(50),
	Domicilio TObjDomicilio,
	Telefonos tTelefono,
	-- Constructor
	constructor function TObjCliente(cod number, Nom varchar2, Ape varchar2, tel number, Via number, NomVia varchar2, Numero number, CPro number, Cloc number) return self as result,
	-- Funciones
	MEMBER PROCEDURE getCliente,
	MAP MEMBER FUNCTION ordenarEmpleado return varchar2,
	ORDER MEMBER FUNCTION ordenarCodigo(e TObjCliente) return number
);
/
create or replace type body TObjCliente as
	-- Procedimiento
	MEMBER PROCEDURE getCliente is
		numTel number;
		i number;
	begin
		dbms_output.put_line('Datos del Cliente: ');
		dbms_output.put_line('Codigo Cliente: '|| self.CodCl);
		dbms_output.put_line('Nombre: '||self.nombre);
		dbms_output.put_line('Apellido: '||self.prApellido);
		dbms_output.put_line('Telefonos: ');
		numTel := self.Telefonos.count;

		for i in 1..numtel loop
			dbms_output.put_line('-> ' ||self.Telefonos(i));
		end loop;
		
		dbms_output.put_line('Domicilio Via: '|| self.Domicilio.TipoVia || ' Calle:' || self.Domicilio.NomVia || ' Nº: ' || self.Domicilio.Numero || ' CP: ' || self.Domicilio.CP.CodProvincia || '//' || self.Domicilio.CP.CodLocalidad);
	
	end getCliente;

	-- Funcion Map
	map member function ordenarEmpleado return varchar2 is
	begin
		return (self.prApellido);
	end ordenarEmpleado;

	-- funcion Order
	order member function ordenarCodigo (e TObjCliente) return number is
		begin
			if self.CodCl < e.CodCl then
				return -1;
			elsif self.CodCl > e.CodCl then
				return 1;
			else
				return 0;
			end if;
	end ordenarCodigo;
end;
/

create table Clientes of TObjCliente;
create table Ventas of tObjVenta;
create table LineasVentas of TObjLineaVenta;
create table Productos of TObjProducto;


create or replace type TObjCliente as object(
    CodCl number,
    Nombre varchar2(50),
    prApellido varchar2(50),
    Domicilio TObjDomicilio,
    Telefonos tTelefono,
    -- Constructor
    constructor function TObjCliente(cod number, Nom varchar2, Ape varchar2, tel number, Via number, NomVia varchar2, Numero number, CPro number, Cloc number) return self as result,
    -- Funciones
    MEMBER PROCEDURE getCliente,
    MAP MEMBER FUNCTION ordenarEmpleado return varchar2,
    ORDER MEMBER FUNCTION ordenarCodigo(e TObjCliente) return number
);
/

create or replace type body TObjCliente as
    -- Procedimiento
    MEMBER PROCEDURE getCliente is
        numTel number;
        i number;
    begin
        dbms_output.put_line('Datos del Cliente: ');
        dbms_output.put_line('Codigo Cliente: '|| self.CodCl);
        dbms_output.put_line('Nombre: '||self.nombre);
        dbms_output.put_line('Apellido: '||self.prApellido);
        dbms_output.put_line('Telefonos: ');
        numTel := self.Telefonos.count;

        for i in 1..numtel loop
            dbms_output.put_line('-> ' ||self.Telefonos(i));
        end loop;

        dbms_output.put_line('Domicilio Via: '|| self.Domicilio.TipoVia || ' Calle:' || self.Domicilio.NomVia || ' Nº: ' || self.Domicilio.Numero || ' CP: ' || self.Domicilio.CP.CodProvincia || '//' || self.Domicilio.CP.CodLocalidad);
    end getCliente;

    -- Funcion Map
    map member function ordenarEmpleado return varchar2 is
    begin
        return (self.prApellido);
    end ordenarEmpleado;

    -- funcion Order
    order member function ordenarCodigo (e TObjCliente) return number is
    begin
        if self.CodCl < e.CodCl then
            return -1;
        elsif self.CodCl > e.CodCl then
            return 1;
        else
            return 0;
        end if;
    end ordenarCodigo;
end;
/

