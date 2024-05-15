<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
			<html>
				<head>
					<title>Ejercicio 2 parte 7</title>
					<style>
						table{
							border-collapse:collapse;
						}
					</style>
				</head>
				<body>
					<h3>Lista de Asignaturas</h3>
					<table border="1">
						<tr>
							<th>Nombre</th>
							<th>Creditos</th>
							<th>Tipo</th>
						</tr>
						<xsl:for-each select="//asignaturas/asignatura[creditos_teoricos]">
							<tr>
								<td><xsl:value-of select="nombre"/></td>
								<td><xsl:value-of select="creditos_teoricos + creditos_practicos"/></td>
								<xsl:if test="creditos_teoricos > 3">
									<td>Troncal</td>
								</xsl:if>
								<xsl:if test="creditos_teoricos &lt;= 3">
									<td>Optativa</td>
								</xsl:if>
							</tr>
						</xsl:for-each>
					</table>
				</body>
			</html>
	</xsl:template>
</xsl:stylesheet>