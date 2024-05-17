create user c##tema7 identified by tema7;

grant all privileges to c##tema7;

set SERVEROUTPUT ON;

	create or replace type vcomisiones is varray(5) of number(6,2);
	
	create table vendedores (
		cod_ven number(3),
		nom_ven varchar2(25),
		fecha_na date,
		salar number(5),
		commis vcomisiones
	);

	insert into vendedores values(001,'Pedro','01/10/1990',1200,vcomisiones(50.1,40,20.5,645,77));
	insert into vendedores values(002,'Angela','20/12/2000',1500,vcomisiones(15,654,1.5,7843,1));
	insert into vendedores values(003,'Miguel','15/02/1970',2000,vcomisiones(100,98,45.2,12,8));
	insert into vendedores values(004,'Judit','17/05/1900',1700,vcomisiones(45,7,12.5,1000,4));



	declare
		total number;
		filas number;
	begin
		select count(*) into filas from vendedores;

		for vendedor in 1..filas loop
				for i in 1..vendedores.commis.COUNT loop
					total := vendedores.commis(i);
				end loop; 
					dbms_output.put_line('Cod vendedor: ' || vendedores.cod_ven || ' Total de comisiones: ' || total);
					total :=0;
		end loop;
 
	end;
	/