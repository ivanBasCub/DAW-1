create user c##tema7 identified by tema7;

grant all privileges to c##tema7;

set SERVEROUTPUT ON;

-- Ejercicio 1
create type tmodulos as varray(10) of number;

declare
	
	type talumno is record(
		nExp number,
		nombre varchar2(15),
		apellidos varchar2(30),
		modulos tmodulos
	);

	alumno1 talumno;
	alumno2 talumno;
begin

	-- Alumno 1
	alumno1.nExp := 0001;
	alumno1.nombre := 'Pedro';
	alumno1.apellidos := 'Melero San';
	alumno1.modulos(1) := 10;
	alumno1.modulos(2) := 20;

	-- Alumno 2
	alumno2.nExp := 0001;
	alumno2.nombre :='Maria';
	alumno2.apellidos :='Almeria';
	alumno2.modulos(1) := 10;

	-- Mostramos los datos de cada alumno
	dbms_output.put_line('Num Expediente: ' || alumno1.nExp || ' / Nombre: ' || alumno1.nombre || ' / Apellidos: ' || alumno1.apellidos || ' Modulos: ' || alumno1.modulos(1) || ',' || alumno1.modulos(2));
	dbms_output.put_line('Num Expediente: ' || alumno2.nExp || ' / Nombre: ' || alumno2.nombre || ' / Apellidos: ' || alumno2.apellidos || ' Modulos: ' || alumno2.modulos(1));

end;
/