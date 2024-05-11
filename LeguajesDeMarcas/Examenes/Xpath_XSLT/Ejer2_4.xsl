<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<head>
				<title>Ejercicio 2</title>
				<link rel="stylesheet" type="text/css" href="examen.css"/>
			</head>
			<body>
				<div class="Ejer4">
					<h2> Ejercicio 4 </h2>
					<h4>Tabla de articulos</h4>
					<table boder="1">
						<tr>
							<th>Nombre</th>
							<th>Descripción</th>
							<th>Precio</th>
							<th>Oferta</th>
						</tr>
						
							<xsl:for-each select="//articulos/articulo">
								<tr>
									<td><xsl:value-of select="nombre"/></td>
									<td><xsl:value-of select="descripcion"/></td>
									<td><xsl:value-of select="precio"/></td>
									<td>
										<xsl:if test="(descuento >= 1) and (descuento &lt; 20)">
											<label>OFERTA</label>
										</xsl:if>
										<xsl:if test ="descuento >= 20">
											<label>SUPER OFERTA</label>
										</xsl:if>
									</td>
								</tr>
							</xsl:for-each>
						
					</table>
				</div>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>