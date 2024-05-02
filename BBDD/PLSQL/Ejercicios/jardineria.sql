set SERVEROUTPUT on;

-- Ejercicio 02
declare
    contador number(5);
begin
    select count(*) into contador from pedidos;
    dbms_output.put_line('El numeros de pedidos totales es: ' || contador);
end;
/

-- Ejercicio 03
create or replace function numPedidos
return int is
resultado int;
begin
    select count(*) into resultado from pedidos;
    return resultado;
end;
/
declare
    pedidos number := numPedidos;
begin
    dbms_output.put_line('El numeros de pedidos totales es: ' || pedidos);
end;
/

-- Ejercicio 04
create or replace procedure nomPorductos(nombre productos.nombre%type) is
nomProd productos.nombre%type := nombre;
cursor listProductos is (
    select *
    from productos
    where nombre like nomProd
);
fila productos%rowtype;
begin
    nomProd := nomProd || '%';
    open listProductos;
    fetch listProductos into fila;
    while(listProductos%found = True) loop
        dbms_output.put_line('Nombre: ' || fila.nombre || ' \ Gama: '|| fila.gama);
        fetch listProductos into fila;
    end loop;
    
    close listProductos;
end;
/
exec nomPorductos('Rosa');

-- Ejercicio 05
create or replace function codFoundProd(codigo productos.codigoproducto%type) 
return int is
total int;
begin
    select count(*) into total from productos
    where codigoproducto = codigo;
    return total;
end;
/
declare
    cod varchar2(15) := 'FR-100';
    total number;
begin
    total := codFoundProd(cod);
    dbms_output.put_line('El numero de productos con el codigo ' || cod || ' es: ' || total);
end;
/

-- Ejercicio 06
create or replace procedure cantidades is
cursor cantidades is(
    select codigoproducto, cantidadenstock
    from productos
);
begin
    for prod in cantidades loop
        if(prod.cantidadenstock = 0) then
            dbms_output.put_line(prod.codigoproducto || ', No hay nada de stock');
        elsif(prod.cantidadenstock <= 20) then
            dbms_output.put_line(prod.codigoproducto || ', Hay poco stock');
        elsif(prod.cantidadenstock <= 50) then
            dbms_output.put_line(prod.codigoproducto || ', El stock es adecuado');
        elsif(prod.cantidadenstock <= 100) then
            dbms_output.put_line(prod.codigoproducto || ', El stock es muy adecuado');
        elsif(prod.cantidadenstock > 100) then
            dbms_output.put_line(prod.codigoproducto || ', Sobresaliente');
        end if;
    end loop;
end;
/
exec cantidades;

-- Ejercicio 07
CREATE TABLE Jefes AS SELECT * FROM Empleados WHERE 1=0;

create or replace procedure insertJefes is 
cursor codJefes is(
    select distinct codigojefe
    from empleados
);
codigo empleados.codigojefe%type;

begin
  open codJefes;
    FETCH codjefes into codigo;
    while(codJefes%found) loop
        insert into jefes select * from empleados where codigoempleado = codigo;
        FETCH codjefes into codigo;
    end loop;
  close codJefes;  
end;
/
exec insertJefes();

-- Ejercicio 08
create or replace function cantidadPagos(tipodepago pagos.formapago%type)
return number is
total number;
begin
    select count(*) into total
    from pagos
    where formapago = tipodepago;
    
    return total;
end;
/ 
declare 
    pago pagos.formapago%type := 'PayPal';
    total number;
begin
    total := cantidadPagos(pago);
    dbms_output.put_line('El numero de pagos realizados a traves de ' || pago || ' es la siguiente: '|| total);
end;
/
