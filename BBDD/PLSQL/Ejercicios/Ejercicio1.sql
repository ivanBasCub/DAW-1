aset SERVEROUTPUT on

-- Ejercicio 1
declare
    v_num number(3):=0;
begin 
    select count(*) into v_num
    from articulo;
    
    dbms_output.put_line('El numero de articulos es: '|| v_num);
    
end;
/  
-- Ejercicio 2
create or replace procedure suma (num1 number, num2 number) is
suma number(5);
begin
    suma :=  num1 + num2;
    dbms_output.put_line('El resultado de la suma es:' || suma);
end;
/
-- Ejecucion
exec suma(7,8);

-- Ejercicio 3
create or replace procedure reverseString (cadena varchar2) is
reverseCadena varchar2(32767);
longitud INT;
begin
    longitud := length(cadena);
    
    -- Bucle de for inverso 
    for i in reverse 1..longitud loop
        reverseCadena := reverseCadena || substr(cadena,i,1);
    end loop;
    
    dbms_output.put_line(reverseCadena);
end;
/

-- Prueba del procedimiento
exec reverseString('Buenos dias');
    
-- Ejercicio 4
declare
    cadena varchar2(500) := 'Buenos dias';
    reverseCadena varchar2(1000);
    limite int;
begin
    limite := length(cadena);
    
    for i in reverse 1..limite loop
        reverseCadena := reverseCadena || substr(cadena,i,1);
    end loop;
    
    dbms_output.put_line(reverseCadena);
end;
/
-- Ejercicio 5
create or replace function cantidadMeses (fech1 date, fech2 date)
return int is
total int;
begin
    total := trunc(months_between(fech1,fech2)/12);
    return total;
end cantidadMeses;
/

-- Prueba de la funcion
declare
    total number;
    fecha1 date := to_date('15-05-2022','DD-MM-YYYY');
    fecha2 date := to_date('15-05-2027','DD-MM-YYYY');
begin 
    total := cantidadMeses(fecha2,fecha1);
    
    dbms_output.put_line(total);
end;
/

-- Ejercicio 6
create or replace function trienios (fech1 date, fech2 date)
return int is
anios int;
total int;
begin
    anios := cantidadMeses(fech1,fech2);
    total := trunc(anios/3);
    return total;
end;
/

--Prueba de la función
declare
    total number;
    fecha1 date := to_date('15-05-2020','DD-MM-YYYY');
    fecha2 date := to_date('15-05-2023','DD-MM-YYYY');
begin 
    total := trienios(fecha2,fecha1);
    
    dbms_output.put_line(total);
end;
/

-- Ejercicio 7
create or replace procedure suma (num1 int default 0,num2 int default 0, num3 int default 0, num4 int default 0, num5 int default 0) is 
total number;
begin
    total := num1 + num2 + num3+num4+num5;
    
    dbms_output.put_line('La suma de los siguientes numeros es: ' || total);
end;
/

-- Probamos el codigo
exec suma(1,2,3,4);

-- Ejercicio 8
create or replace function letras (cadena varchar2)
return varchar2 is
resultado varchar2(3000);
begin
    for i in 1..length(cadena) loop
        -- No pilla la letra ñ en la siguiente seleccion
        if substr(cadena,i,1) between 'A' and 'Z' or substr(cadena,i,1) between 'a' and 'z' then
            resultado := resultado || substr(cadena,i,1);
        else
            resultado := resultado || ' ';
        end if;
    end loop;
    
    return resultado;
end;
/

-- Prueba de la funcion
declare
    frase varchar2(3000) := 'Buenos dias a las 11 de la mañana';
    resultado varchar2(3000);
begin 
    resultado := letras(frase);
    
    dbms_output.put_line(resultado);
end;
/
