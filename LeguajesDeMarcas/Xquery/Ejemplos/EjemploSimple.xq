(:
Guardo la información dentro de la variable creada y muestro con el return solo los titulo
:)

for $l in /biblioteca/libro
  return string ($l/titulo)
  
(:
Para hacer referencia a un archivo hay que poner doc(nombre del archivo XML)
:)

(: 
Uso del let ya que es la otra que se usa a partir del for. Es normalmente usado para buscar solamente un elemento
:)

(:
  let $t := //biblioteca/libro
  return <lib>{$li/titulo}</lib>
:)