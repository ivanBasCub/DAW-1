set SERVEROUTPUT on

-- Ejercicio 1
create or replace procedure articulosFab (codigoFab Articulo.codFab%TYPE) is
codFab Articulo.codFab%TYPE := codigoFab;
cursor curArt is (
    select a.*
    from articulo a
    where a.codFab = codFab
);
begin
    for productos in curArt loop
        dbms_output.put_line(productos.codart || ' / ' || productos.nomart || ' / '
        || productos.precio);
    
    end loop;

end articulosFab;
/
exec articulosFab('0000000001');

-- Ejercicio 2
create or replace function numArticulos
return int is
total int;
begin
    select count(*) into total from articulo;
    return total;
end numArticulos;
/
declare 
articulos number;
begin 
    articulos := numArticulos();
    dbms_output.put_line('El numero total de articulos: ' || articulos);
end;
/

-- Ejercicio 3
create or replace procedure modifyCodFabArticulos(codigoArticulo articulo.codart%TYPE,codigoFab articulo.codfab%TYPE) is
codFabricante articulo.codfab%TYPE := codigoFab;
codarticulo articulo.codart%TYPE := codigoArticulo;
begin
    update articulo a
    set a.codFab = codFabricante
    where a.codart = codarticulo;
end;
/
exec modifyCodFabArticulos('0000000004','0000000006');



-- Ejercicio 4
create or replace procedure viewArticulosPrecio(usuPrecio articulo.precio%type) is 
precioComp articulo.precio%type := usuPrecio;
cursor articulosVisibles is (
    select a.*
    from articulo a 
    where a.precio > precioComp
);
begin
    for productos in articulosVisibles loop
        dbms_output.put_line(productos.codart || ' / ' || productos.nomart || ' / '
        || productos.precio);
    end loop;
end;
/

exec viewArticulosPrecio(100);