<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xsmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<head>
				<title>Ejercicio 2</title>
				<link rel="stylesheet" type="text/css" href="examen.css">
			</head>
			<body>
				<!-- Ejercicio 2 -->
				<div class="Ejer2">
					<h2>Ejercicio 2</h2>
					<h4>Tabla de Clientes</h4>
					<table border="1">
						<tr>
							<th>Nombre</th>
							<th>CIF</th>
							<th>Dirección</th>
							<th>Email</th>
							<th>Web</th>
						</tr>
						<xsl:for-each select="//clientes/cliente">
							<xsl:sort select="nombre"/>
							<tr>
								<td><xsl:value-of select="nombre"/></td>
								<td><xsl:value-of select="cif_nif"/></td>
								<td><xsl:value-of select="direccion"/></td>
								<td><xsl:value-of select="email"/></td>
								<td>
									<a href="{web}">
										<xsl:value-of select="web"/>
									</a>
								</td>
							</tr>
						</xsl:for-each>
					</table>
				</div>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>