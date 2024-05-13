set SERVEROUTPUT ON;


-- Apartado A
create or replace type T_direccion as object(
	calle varchar2(40),
	numero number(3),
	ciudad varchar2(40),
	codigoPostal number(5)
);
/
create or replace type t_telefono as varray(3) of varchar2(9);
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
	idalum number(3),
	nom_alum varchar2(40),
	ape_alum varchar2(40),
	dir_alumn T_direccion,
	tel_alumn T_telefono,
	asig_alum tipo_asignatura_alumn,
	member function media_alum return number
);
/

create or replace type body t_alumno_nota_total as 
  member function media_alum return number is
    total number:= 0;
    media number:=0;
    lin t_asignatura_alum;
  begin
    for i in 1..asig_alum.count loop
      lin:= asig_alum(i);
      total := total + lin.nota_asig;
      media := total/i;
    end loop;
  
    return media;
    end;
end;
/

-- Apartado D
create table tabla_alumnos_total of t_alumno_nota_total (idalum primary key)
	nested table asig_alum store as tabla_asig2;

-- Apartado E
insert into tabla_alumnos_total values (1,'Ivan','Bascones', T_direccion('Calle Prueba',15,'Palencia',34004),t_telefono('634582174'),
tipo_asignatura_alumn(
	t_asignatura_alum(1,'BBDD',7.4),
	t_asignatura_alum(2,'Programacion',7.2)));