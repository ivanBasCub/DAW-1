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
    MAP MEMBER FUNCTION ordenarEmpleado return varchar2
);
/

create or replace type body TObjCliente as
	-- Constructor
	constructor function TObjCliente(cod number, Nom varchar2, Ape varchar2, tel number, Via number,
	NomVia varchar2, Numero number, CPro number, Cloc number)
	return self as result is
	begin
		SELF.CodCl := CodCl;
        SELF.Nombre := Nombre;
        SELF.prApellido := prApellido;
        SELF.Telefonos := tTelefono(tel);
        SELF.Domicilio := tObjDomicilio(Via, NomVia, Numero, '', tObjCodPostal(CPro, Cloc));
        RETURN;
    END;
    -- Procedimiento
    MEMBER PROCEDURE getCliente is
        numTel number;
        i number;
    begin
        dbms_output.put_line('Datos del Cliente: ');
        dbms_output.put_line('Codigo Cliente: '|| self.CodCl);
        dbms_output.put_line('Nombre: '||self.Nombre);
        dbms_output.put_line('Apellido: '||self.prApellido);
        dbms_output.put_line('Telefonos: ');
        numTel := self.Telefonos.count;

        for i in 1..numtel loop
            dbms_output.put_line('-> ' ||self.Telefonos(i));
        end loop;

        dbms_output.put_line('Domicilio Via: '|| self.Domicilio.TipoVia || ' Calle:' || self.Domicilio.NombreVia || ' Nº: ' || self.Domicilio.Numero || ' CP: ' || self.Domicilio.CP.CodProvincia || '//' || self.Domicilio.CP.CodLocalidad);
    end getCliente;

    -- Funcion Map
    map member function ordenarEmpleado return varchar2 is
    begin
        return (self.prApellido);
    end ordenarEmpleado;
end;
/

create table Clientes of TObjCliente;
create table Ventas of tObjVenta;
create table LineasVentas of TObjLineaVenta;
create table Productos of TObjProducto;




