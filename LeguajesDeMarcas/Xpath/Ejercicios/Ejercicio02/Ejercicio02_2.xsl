<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<head>
				<title>Ejercicio02 parte 2</title>
				<style>
					table{
						border-collapse: collapse;
					}
				</style>		
			</head>

			<body>
				
				<xsl:apply-templates select="//universidad"/>

				<h4>Carreras</h4>
				<table border="1">
					<tr>
						<th>Nombre</th>
						<th>Plan</th>
						<th>Centro</th>
						<th>Asignaturas</th>
					</tr>
					<xsl:for-each select="//carreras/carrera">
						<tr>
							<td><xsl:value-of select ="nombre"/></td>
							<td><xsl:value-of select ="plan"/></td>
							<td><xsl:value-of select ="centro"/></td>
							<td>
								<xsl:for-each select="//asignaturas/asignatura[@titulacion = current()/@id]">
									<xsl:value-of select="nombre"/> / 
								</xsl:for-each>
							</td>

						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>

	<xsl:template match="//universidad">
		<h2><xsl:value-of select="nombre"/></h2>
		<a href="{web}">Enlace a la web</a>
	</xsl:template>

</xsl:stylesheet>
