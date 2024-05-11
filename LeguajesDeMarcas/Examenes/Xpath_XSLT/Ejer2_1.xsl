<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<head>
				<title>Ejercicio 1</title>
				<link rel="stylesheet" type="text/css" href="examen.css"/>
			</head>
			<body>
				<!-- Ejercicio 1 -->
				<div class="Ejer1">
					<h2>Ejercicio 1</h2>
					<xsl:apply-templates select="//facturas/factura"/>

				</div>
			</body>
		</html>
	</xsl:template>

	<xsl:template match="//facturas/factura">
		<p>Factura <xsl:value-of select="@idfactura"/> - <xsl:value-of select="fecha"/></p>
		<table border="1">
			<tr>
				<th>Articulo</th>
				<th>Cantidad</th>
				<th>Precio</th>
				<th>Total</th>
			</tr>
			<xsl:apply-templates select="//facturas/factura/articulos"/>
		</table>
	</xsl:template>

	<xsl:template match="//facturas/factura/articulos">
		<tr>
			<td><xsl:value-of select="articulo/@id"/></td>
			<td><xsl:value-of select="articulo/cantidad"/></td>
			<td><xsl:value-of select="articulo/precio"/></td>
			<td><xsl:value-of select="articulo/cantidad * articulo/precio"/></td>
		</tr>
	</xsl:template>
	
</xsl:stylesheet>