create user c##ejer4BDOR identified by ejer4;

grant all privileges to c##ejer4BDOR;

set serveroutput on;

-- Ejercicio 1

create or replace type tObjSucursal as object(
	CodSucursal number(5),
	Telefono number(9),
	Domicilio varchar2(20)
)
/

create or replace type tObjEmpleado as object(
	DNI varchar2(9),
	NomEmp varchar2(15),
	ApeEmp varchar2(15),
	DirEmp varchar2(50),
	Sucursal ref tObjSucursal,
	map member function ordenarApe return varchar2
)
not final
/

create or replace type body tObjEmpleado as
    map member function ordenarApe return varchar2 is
    begin
        return (self.ApeEmp);
    end ordenarApe;
end;
/

create or replace type tObjPeriodista under tObjEmpleado(
	Especialidad varchar2(15),
	-- Ejercicio 2
	constructor function tObjPeriodista(dni varchar2, nombre varchar2, apellido varchar2, direc varchar2, especial varchar2) return self as result,
	member procedure getPeriodista,
	member procedure setSucursal(cod number)

)
/
create or replace type body tObjPeriodista as
	-- Constructor
	constructor function tObjPeriodista(dni varchar2, nombre varchar2, apellido varchar2, direc varchar2, especial varchar2)
	return self as result is
	begin
		self.DNI := dni;
		self.NomEmp := nombre;
		self.ApeEmp := apellido;
		self.DirEmp := direc;
		self.Especialidad := especial;
		return;
	end;

	-- Funciones

	-- Metodo getPeriodista
	member procedure getPeriodista is
	begin
		dbms_output.put_line('Datos del Periodista:');
		dbms_output.put_line('DNI: ' || self.DNI);
		dbms_output.put_line('Nombre: ' || self.NomEmp);
		dbms_output.put_line('Apellido: ' || self.ApeEmp);
		dbms_output.put_line('Direccion: ' || self.DirEmp);
		dbms_output.put_line('Especialidad: ' || self.Especialidad);
		dbms_output.put_line('Sucursal: ');
	end getPeriodista;	

	-- Metodo setSucursal
	member procedure setSucursal(cod number) is
	begin
		select ref(s) into self.Sucursal from Sucursales s where s.CodSucursal = cod;
	end setSucursal;
end;
/

-- Tablas Anidadas
create table Periodistas of tObjPeriodista;
create table Sucursales of tObjSucursal;

-- Insertar datos de ejemplo de Sucursales
insert into Sucursales values(10,979458123,'C/Mayor');
insert into Sucursales values(20,987654321,'C/Menor');
insert into Sucursales values(30,123456789,'C/Mediana');

-- Insertar datos de ejemplo de Periodistas
insert into Periodistas values('12345678A','Ivan','Bascones','C/Alumno',
    (select ref(s) from Sucursales s where s.CodSucursal = 20)
,'Informatica');
insert into Periodistas values('98765432B','Jose','Pezer','C/Profesor',
(select ref(s) from Sucursales s where s.CodSucursal = 10)
,'Magisterio');
insert into Periodistas values('11111111C','Rogelio','Copas','C/Expulsado',
(select ref(s) from Sucursales s where s.CodSucursal = 30)
,'Mierda');

-- Mostrar informacion de las tablas periodista y Sucursal
declare
	perio tObjPeriodista;
begin
	select value(p) into perio from Periodistas p where p.DNI = '11111111C';
	perio.getPeriodista;
end;
/