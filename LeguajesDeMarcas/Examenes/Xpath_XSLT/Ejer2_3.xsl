<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xsmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<head>
				<title>Ejercicio 2</title>
				<link rel="stylesheet" type="text/css" href="examen.css">
			</head>
			<body>
				<!-- Ejercicio 3 -->
				<div class="Ejer3">
					<h2>Ejercicio 3</h2>
					<h4>Facturas con al menos 3 articulos distintos</h4>
					<ol>
						<xsl:for-each select="//facturas/factura[articulos/count(articulo)>=3]">
							<li>Factura: <xsl:value-of select="@idfactura"/> Fecha: <xsl:value-of select="fecha"/></li>
						</xsl:for-each>
					</ol>
				</div>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>