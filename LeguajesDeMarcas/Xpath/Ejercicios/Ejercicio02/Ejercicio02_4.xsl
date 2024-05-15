<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<head>
			<title>Ejercicio 2 parte 4</title>
			<style>
				table{
				border-collapse: collapse;
				}
			</style>
		</head>

		<body>
			<xsl:for-each select="//alumno">
				<xsl:sort select="nombre"/>
				<p> Nombre Completo: <xsl:value-of select ="nombre"/> <xsl:value-of select ="apellido1"/> <xsl:value-of select ="apellido2"/> / Sexo: <xsl:value-of select="sexo"/>
				</p>

				<table border="1">
					<tr>
						<th colspan ="4 ">Asignaturas</th>
					</tr>
					<tr>
						<th>Nombre</th>
						<th>Creditos Teoricos</th>
						<th>Creditos Practicos</th>
						<th>Creditos Totales</th>
					</tr>

					<xsl:for-each select="//asignaturas/asignatura[current()/estudios/asignaturas/asignatura/@codigo = @id]">
						<xsl:sort select="nombre"/>
						<tr>
							<td><xsl:value-of select="nombre"/></td>
							<td><xsl:value-of select ="creditos_teoricos"/></td>
							<td><xsl:value-of select ="creditos_practicos"/></td>
							<td><xsl:value-of select="creditos_practicos + creditos_teoricos"/></td>
						</tr>
					</xsl:for-each>
				</table>
			</xsl:for-each>
		</body>
	</xsl:template>

</xsl:stylesheet>