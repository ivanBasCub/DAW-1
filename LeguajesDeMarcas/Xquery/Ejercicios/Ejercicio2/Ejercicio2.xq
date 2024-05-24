(:Ejercicio 1
for $p in //proveedores/proveedor
where $p/estado > 15
return <Proveedor>{string($p/nombreprov)}</Proveedor>
:)

(:Ejercicio 2
let $parte := //partes
return ("Cantidad de filas:",count($parte/parte))
:)

(:Ejercicio 3
for $parte in //partes/parte
return ($parte/nombreparte, $parte/color,$parte/ciudad,"---------------------")
:)

(:Ejercicio 4
for $prov in //proveedores/proveedor
where ends-with($prov/nombreprov,"s")
return $prov
:)

(:Ejercicio 5
for $prov in //proveedores/proveedor, $sumi in //suministros/suministra[cantidad >350]
where $prov/@numprov = $sumi/numprov
return <resultado>{$sumi/numproyecto,$sumi/cantidad}</resultado>
:)

(:Ejercicio 6
for $proy in //proyectos/proyecto, $sumi in //suministros/suministra
where (
  $proy/ciudad = "Paris" and $proy/@numproyecto = $sumi/numproyecto and $sumi/cantidad > 350
)
return $proy/nombreproyecto
:)

(:Ejercicio 7
for $proy in //proyectos/proyecto, $sumi in //suministros/suministra, $part in //partes/parte
where ($proy/@numproyecto = $sumi/numproyecto and $part/@numparte = $sumi/numparte)
return concat(
  string($part/nombreparte),
   "en la misma ciudad que ",
   string($proy/nombreproyecto), 
   "-Ciudad: ", string($proy/ciudad))
:)

(:Ejercicio 8
for $parte1 in //partes/parte, $parte2 in //partes/parte
where ($parte1/color = $parte2/color and $parte1/nombreparte != $parte2/nombreparte)
return 
  concat("Color: ",string($parte1/color)," // ", string($parte1/nombreparte)," - ",string($parte2/nombreparte))
:)



(:Ejercicio 9
let $sumi := //suministros/suministra, $part := //partes/parte
where ($sumi/numparte = $part/@numparte and $part/color = "Rojo")
return <Media>{avg($sumi/cantidad)}</Media>
:)

(:Ejercicio 10
for $sumi in //suministros/suministra
let $prov := $sumi/numprov
group by $prov
return concat("Proveedor: ",$prov," Media de los productos: ",avg($sumi/cantidad))
:)

for $sumi in //suministros/suministra
let $prov := $sumi/numprov
group by $prov
return concat("Proveedor: ",$prov," Media de los productos: ",avg($sumi/cantidad))