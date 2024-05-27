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
		dbms_output.put_line('Codigo: ' || self.Sucursal.CodSucursal);
		dbms_output.put_line('Telefono: ' || self.Sucursal.Telefono);
		dbms_output.put_line('Domicilio: ' || self.Sucursal.Domicilio);
	end getPeriodista;	

		-- Metodo setSucursal
	member procedure setSucursal(cod number) is
	begin
	end setSucursal;
		self.Sucursal := select ref(s) from tObjSucursal s where s.CodSucursal = cod;
end;
/

create table Periodistas of tObjPeriodista;
create table Sucursales of tObjSucursal;