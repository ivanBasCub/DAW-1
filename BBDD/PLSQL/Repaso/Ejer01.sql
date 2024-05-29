create or replace package paq_bajada_sueldo as
    porcentaje constant number := 5;
    procedure baja_sueldo;
    function hubo_errores return boolean;
    function dame_porcentaje_escala return number;
end paq_bajada_sueldo;
/
create or replace package body paq_bajada_sueldo as

    procedure baja_sueldo is 
        cursor suledos is(
            select *
            from nominas
        )
    begin
        for cambio in sueldos loop
            update nominas n
            set n.sueldo = n.sueldo - (n.sueldo * (porcentaje / 100))
            where n.nif = cambio.nif;
            exception
                when others
                    insert into ERR_BAJADA_SUELDO values(cambio.nif,SQLCODE,SUBSTR(SQLERRM,1,64));
        end loop;
    end baja_sueldo;

    function hubo_errores return boolean is
        filas number;
    begin
        select count(*) int filas from ERR_BAJADA_SUELDO;
        if (filas != 0) then
            return false;
        else:
            return true;
        end if;
    end hubo_errores;
end paq_bajada_sueldo;
/