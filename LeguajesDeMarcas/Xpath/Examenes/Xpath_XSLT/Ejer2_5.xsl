<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xsmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<head>
				<title>Ejercicio 2</title>
				<link rel="stylesheet" type="text/css" href="examen.css">
			</head>
			<body>
				<!-- Ejercicio 5 -->
				<div class="Ejer5">
					<h2> Ejercicio 5</h2>
					<h4> Listado de Facturas por Cliente</h4>
					<xsl:for-each select="//clientes/cliente">
						<p><xsl:value-of select="nombre"/> - CIF: <xsl:value-of select="cif_nif"/></p>
						<xsl:variable name="idcli" select="@id"/>
						<ul>
							<xsl:for-each select="//facturas/factura">
								<xsl:if test="@idcliente = $idcli">
									<li><xsl:value-of select="@idfactura"/></li>
								</xsl:if>
							</xsl:for-each>
						</ul>
					</xsl:for-each>
				</div>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>