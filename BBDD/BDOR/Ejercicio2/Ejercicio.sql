set serveroutput on;

-- Ejercicio A
create or replace type tipo_direccion as object(
	tipo varchar2(20),
	numero number(3),
	calle varchar2(30),
	piso varchar2(4)
)
/
-- Ejercicio B
create or replace type colec_direccion as varray(3) of tipo_direccion;
/
-- Ejercicio C
create or replace type tipo_empresa as object(
	CIF varchar2(20),
	nombre varchar2(30),
	direcciones colec_direccion
) not final
/

-- Ejercicio D
create or replace type sociedadAnonima under tipo_empresa (
	numAccionistas number(3),
	capitalSocual number(7),
	presupuesto number(8)
)
/

-- Ejercicio E
create table empleado_bdor (
	codEmpleado number primary key,
	nomEmpleado varchar2(30),
	emp ref sociedadAnonima
);
/
-- Ejercicio F
create table empresas_sociedad_anonima of sociedadAnonima (CIF primary key);


-- Apartago G
insert into empresas_sociedad_anonima values (
	sociedadAnonima(
		'B12888333','EmpresaPrueba', colec_direccion(
			tipo_direccion('fiscal',5,'C/ Mayor','3B'),
			tipo_direccion('postal',10,'C/San Antonio','2F')
		), 12, 300000, 1000000
	)
);

-- Apartado H
insert into empleado_bdor 
	select 1, 'Ivan', REF(e)
	from empresas_sociedad_anonima e
	where e.CIF = 'B12888333';

-- Empleado I
select codEmpleado, nomEmpleado , DEREF(emp)
from empleado_bdor