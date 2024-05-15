<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<head>
				<title>Ejercicio 6 XSLT</title>
				<style>
					table{
						border-collapse: collapse;
					}
				</style>
			</head>

			<body>
				<h3>Lista de discos con Descuentos</h3>
				<table border= "1">
					<tr>
						<th>Titulo</th>
						<th>Precio</th>
						<th>Descuento</th>
						<th>Precio Final</th>
					</tr>
					<xsl:for-each select="//cds/cd[dto]">
						<xsl:sort select="dto" data-type="number" order="descending"/>
						<tr>
							<td><xsl:value-of select="titulo"/></td>
							<td><xsl:value-of select="precio"/></td>
							<td><xsl:value-of select="dto"/></td>
							<td><xsl:value-of select="precio - (precio * (dto div 100))"/></td>
						</tr>
						
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>