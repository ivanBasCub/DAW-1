-- Ejercicio 01
create user c##pr0601IvanBascones identified by pr0601;

grant all privileges to c##pr0601IvanBascones;
-- Ejercicio 03
insert into oficinas(codigooficina,ciudad,pais,codigopostal,telefono,lineadireccion1) 
values('PAL-ES','Palencia','España','34001','+34 979 888 777','C/ Mayor 31')
-- Ejercicio 04
create view VEES as
	select *
	from empleados e join oficinas o on o.codigooficina = e.codigooficina
	where o.pais = 'España';

-- Ejercicio 05
create table EMPLEADOSEEUU as select e.*,o.pais from empleados e join oficinas o on o.codigooficina = e.codigooficina where 1=0;

-- Ejercicio 06
insert into EMPLEADOSEEUU as select e.*,o.pais from empleados e join oficinas o on o.codigooficina = e.codigooficina where o.pais = 'EEUU';

-- Ejercicio 07
set SERVEROUTPUT on;

declare 
    total number;
begin
    select count(*) into total from empleados;
    
    dbms_output.put_line('El numero de empleados totales es el siguiente: ' || total);
end;
/

-- Ejercicio 08
create or replace function numEmpleados return number as
total number;
begin
    select count(*) into total from empleados;
    return total;
end;
/

declare

begin
    dbms_output.put_line('El numero total de empleados es el siguente: ' || numEmpleados());
end;
/

-- Ejercicio 09
create or replace procedure datosEmpleados(codOficina oficinas.codigooficina%type) as
    cursor empleadosCodOfi is (
        select *
        from empleados 
        where codigooficina = codOficina
    );
    fila empleados%rowtype;
begin
    open empleadosCodOfi;
    fetch empleadosCodOfi into fila;
    while (empleadosCodOfi%found = True) loop
        dbms_output.put_line('Cod Empleado: ' || fila.codigoempleado || ' \ Nombre: ' || fila.nombre ||
        ' \ Apellido1: ' || fila.apellido1 || ' \ Apellido2: ' || fila.apellido2 || ' \ Extension: ' || fila.extension || 
        ' \ Email: ' || fila.email || ' \ Codigo Oficina: ' || fila.codigooficina || ' \ Codigo Jefe: ' || fila.codigoJefe ||
        ' \ Puesto: ' || fila.puesto);
        fetch empleadosCodOfi into fila;
    end loop;
    
    close empleadosCodOfi;
end;
/
exec datosEmpleados('MAD-ES');

-- Ejercicio 10

create or replace procedure pedidosProducto (nomProducto productos.nombre%type) as
cursor pedidosProducto is(
    SELECT p.codigopedido, p.fechapedido, p.fechaesperada, p.fechaentrega, p.estado, p.comentarios, p.codigocliente,dp.codigoproducto, dp.cantidad, dp.preciounidad, dp.numerolinea
    FROM detallepedidos dp 
    JOIN pedidos p ON p.codigopedido = dp.codigopedido
    JOIN productos pr ON pr.codigoproducto = dp.codigoproducto
    WHERE pr.nombre = nomProducto
);
begin 
    for pedido in pedidosProducto loop
        dbms_output.put_line(pedido.codigopedido || ' / ' || pedido.fechapedido || ' / ' || pedido.fechaesperada
        || ' / ' || pedido.fechaentrega || ' / ' || pedido.estado || ' / ' || pedido.comentarios || ' / ' || 
        pedido.codigocliente || ' / ' || pedido.codigoproducto || ' / ' || pedido.cantidad
         || ' / ' || pedido.cantidad  || ' / ' || pedido.preciounidad  || ' / ' || pedido.numerolinea);
    end loop;
end ;
/
exec pedidosProducto('Peral');