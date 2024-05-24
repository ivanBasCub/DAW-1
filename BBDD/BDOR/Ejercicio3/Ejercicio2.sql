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


-- Modificamos el objeto Venta
create or replace type tObjVenta as object(
    CodVenta number,
	Fecha date,
	Cliente ref TObjCliente,
    -- Funcion Order
    order member function ordenarCodVenta (e tObjVenta) return number
)
/
-- Creamos el body del Objeto
create or replace type body tObjVenta as
    -- Funcion order
    order member function ordenarCodVenta (e tObjVenta) return number is
    begin
        if self.CodVenta < e.CodVenta then
            return -1;
        elsif self.CodVenta > e.CodVenta then
            return 1;
        else
            return 0;
        end if;
    end ordenarCodVenta;
end;
/

-- Reponemos el objeto de TObjLineaVenta
create or replace type TObjLineaVenta as object(
	CodLinea number,
	Cantidad number,
	Producto ref TObjProducto,
	Venta ref tObjVenta
)
/

-- Creamos tablas anidadas a los objetos creados segun el ejercicio
create table Clientes of TObjCliente;
create table Ventas of tObjVenta;
create table LineasVentas of TObjLineaVenta;
create table Productos of TObjProducto;

-- Inserccion de los datos de pruebas en la BDOR

-- Tabla Clientes
insert into Clientes 
values (1,'Ivan','Bascones',
    TObjDomicilio(2,'Mayor',32,'n 7 p 4 p F',
        TObjCodPostal(34003,34003)
    ), tTelefono(634572817,979840219)
    );

insert into Clientes 
values (2,'Paula','Rodriguez',
    TObjDomicilio(1,'Federico Mayo',2,' P 2 p A',
        TObjCodPostal(34004,34003)
    ), tTelefono(48720164)
    );

-- Tabla Productos

insert into Productos values (190,'Pepino',15,10);
insert into Productos values (17,'Bolsa de Magdalenas',10,20);
insert into Productos values (52,'Chuces',20,15);

-- Tablas Ventas

insert into Ventas values(
    1001, to_date('12-02-2024','DD-MM-YYYY'),(select ref(c) from clientes c where c.CodCl = 1) 
    -- Para referenciar a un dato dentro de una tabla se realiza de la forma mostrada en la linea anterior
);	-- En el caso de que estemos haciendo un programa PL/SQL para referenciar un objeto dentro de otro usamos el siguiente comandos REF(nombre del objeto)
insert into Ventas values(
    1002, to_date('27-03-2024','DD-MM-YYYY'),(select ref(c) from clientes c where c.CodCl = 2)
);
insert into Ventas values(
    1003, to_date('03-04-2024','DD-MM-YYYY'),(select ref(c) from clientes c where c.CodCl = 1)
);
-- Tablas LineasVentas
insert into LineasVentas values(
    11,3,
    (select ref(p) from Productos p where p.CodProd = 17),
    (select ref(v) from Ventas v where v.CodVenta = 1002)
);

insert into LineasVentas values(
    12,13,
    (select ref(p) from Productos p where p.CodProd = 190),
    (select ref(v) from Ventas v where v.CodVenta = 1001)
);

insert into LineasVentas values(
    52,2,
    (select ref(p) from Productos p where p.CodProd = 52),
    (select ref(v) from Ventas v where v.CodVenta = 1003)
);

-- Mostrar la informacion almacenada en las BDOR