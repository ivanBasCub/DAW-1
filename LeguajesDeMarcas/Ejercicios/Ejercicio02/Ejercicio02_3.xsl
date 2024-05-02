<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<head>
			<title>Ejercicio 2 Parte 3</title>
			<style>
				table{
					border-collapse:collapse;
				}
			</style>
		</head>

		<body>
			<table border = "1">
				<tr>
					<th> Carrera </th>
					<th> Alumnos </th>
				</tr>
				<xsl:for-each select="//carreras/carrera">
					<tr>
						<td><xsl:value-of select="nombre"/></td>
						<td>
							<xsl:for-each select="//alumno[estudios/carrera/@codigo = current()/@id]">
								<xsl:sort select="nombre"/>
								<xsl:value-of select="nombre"/> /
							</xsl:for-each>
						</td>
					</tr>
					
				</xsl:for-each>
			</table>
		</body>
	</xsl:template>

</xsl:stylesheet>