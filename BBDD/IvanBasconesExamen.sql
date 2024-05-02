-- Creación de usuario
create user c##nbaIvanBascones identified by nba;
grant all privileges to c##nbaIvanBascones;

-- Apartado a

delete Estadisticas
where temporada ='05/06' and jugador = (
                            select codigo
                            from jugadores
                            where nombre='Jose Calderon'
);

-- Apartado b

rollback;

-- Apartado c

Update Equipos 
set ciudad = 'Toronto'
where nombre = 'Celtics';

-- Apartado d

rollback;

-- Apartado e

create view ESTADESPA as
  select j.Nombre, e.temporada, e.puntos_por_partido, e.asistencias_por_partido, e.Tapones_por_partido, e.Rebotes_por_partido
	from estadisticas e join jugadores j on j.codigo = e.jugador
	where j.procedencia = 'Spain';

-- Apartado f
	-- Apartado 1

delete partidos
where equipo_local in (
    select nombre
    from equipos
    where ciudad = 'Los Angeles'
) 
or equipo_visitante in (
    select nombre
    from equipos
    where ciudad = 'Los Angeles'
);
	-- Apartado 2

update jugadores
set peso = peso + (peso *0.01)
where Nombre_equipo in (
    select nombre
    from equipos
    where ciudad = 'Los Angeles'
);

	-- Apartado 3

create view VTEMP0506 as
select j.nombre_equipo, j.nombre, avg(e.puntos_por_partido) as media
from estadisticas e join jugadores j on j.codigo = e.jugador
where e.temporada = '05/06'
group by (j.nombre_equipo, j.nombre);

	-- Apartado 4

delete estadisticas
where temporada = '03/04' and jugador in (
select jugador
from estadisticas
group by jugador
having avg(asistencias_por_partido) = min(asistencias_por_partido)
);