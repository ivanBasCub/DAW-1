set SERVEROUTPUT ON;


-- Apartado A
create or replace type T_direccion as object (
	direccion varchar2(40)
);
/
create or replace type T_telefonos as object(
	telefono varchar2(10)
);
/

-- Apartado B
create or replace type t_asignatura_alum as object(
	idasig number(3),
	des_asig varchar2(50),
	nota_asig number(4,2)
);
/
create or replace type tipo_asignatura_alumn as table of t_asignatura_alum;
/

-- Apartado C
create or replace type t_alumno_nota_total as object(
	
);