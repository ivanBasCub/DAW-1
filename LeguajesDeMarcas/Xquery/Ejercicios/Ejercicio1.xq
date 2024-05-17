(:Ejercicio 1
for $des in //producto
return $des/descripcion
:)

(:Ejercicio 2
for $p in //producto
where $p/precio <= 11
return ($p)
:)

(:Ejercicio 3
for $p in //producto
where $p/precio <= 11
return ($p/descripcion)
:)

(:Ejercicio 4
for $p in //producto
where $p/precio <= 13
return string ($p/descripcion)
:)

(:Ejercicio 5
for $p in //producto
where $p/caducidad = 2023
return ($p/descripcion,$p/fabricante,"CAD2023")
:)

(:Ejercicio 6
for $p in //producto
return ("caducidad: ", $p/caducidad)

let $cad := //producto/caducidad
return <lib>"caducidad"{$cad}</lib>
:)

(:Ejercicio 7
for $p in //producto
order by $p/@categoria
order by $p/descripcion
return $p
:)


(:Ejercicio 8
let $cant := //producto
return count($cant)
:)

(:Ejercicio 9
 
:)
let $p := //producto
return ($p/descripcion, "Total: ", count($p))
(:Ejercicio 10
let $p := //producto
return ("Precio Minimo:",min($p/precio),"Precio Maximo:",max($p/precio))
:)

