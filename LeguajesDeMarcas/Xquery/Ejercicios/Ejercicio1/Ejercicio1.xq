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
order by $p/@categoria, $p/descripcion
return $p
:)


(:Ejercicio 8
let $cant := //producto
return count($cant)
:)

(:Ejercicio 9
   let $p := //producto
  return ($p/descripcion, "Total: ", count($p))
:)

(:Ejercicio 10
  let $p := //producto
  return ("Precio Minimo:",min($p/precio),"Precio Maximo:",max($p/precio))
:)

(:Ejercicio 11
for $p in //producto
order by ($p/precio)*1.21
return ("Descripcion:", string ($p/descripcion),"Precio Sin IVA:",string ($p/precio),"Precio con IVA",($p/precio)*1.21,"_______________________")
:)

(:Ejercicio 12
let $p := producto
return ("Total",sum($p/precio))
:)

(:Ejercicio 13
let $total := sum(//producto/precio)
return (
   for $p in //producto
  return ("Precio Producto:",string($p/precio)),"Sumatorio de todos los productos",$total)
:)

(:Ejercicio 14
for $p in //producto
return (<descripcion> {string($p/descripcion)}</descripcion>,
       <fabricantes> {count($p/fabricante)}</fabricantes>)
:)

(:Ejercicio 15
for $p in //producto
return <Producto>{string(concat($p/descripcion,"(",count($p/fabricante),")"))}</Producto>
:)

(:Ejercicio 16
for $p in //producto
where ends-with($p/caducidad,"3")
return $p
:)

(:Ejercicio 17
for $p in //producto
where starts-with($p/@categoria,"c")
return $p
:)

(:Ejercicio 18wqqqqqqqqqqqqqqqq
for $p in //producto
where contains($p/descripcion,"x") or contains($p/descripcion,"X")
return $p
:)

(:Ejercicio 19´
for $p in //producto
return (<descripcion>{string($p/descripcion)}</descripcion>,<longitud>{string-length($p/descripcion)}</longitud>)
:)

(:Ejercicio 20
for $año in distinct-values(//producto/caducidad)
order by $año
 return <año>{$año}</año>
:)

(: Ejercicio 21
for $fabricante in distinct-values(//producto/fabricante)
order by string-length($fabricante)
return <fabricante>{$fabricante}</fabricante>
:)

(:Ejercicio 22
let $des := //producto/descripcion
return (
  <table>
    <tr>
      <th>Descripcion</th>
    </tr>
    {
      for $p in $des
      return (
        <tr>
         <td>{string($p)}</td>
        </tr>
      )
    }
  </table>
)
:)

