<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<!--
			Sacar un listado de carreras, asginaturas y alumnos
		-->
		<html>
			<head>
				<title>Ejercicio 2 parte 6</title>
			</head>

			<body>
				<ol>
					<xsl:for-each select="//carreras/carrera">
						<li><xsl:value-of select="nombre"/></li>
						<ul>
							<li>Asignaturas:</li>
							<xsl:for-each select="//asignaturas/asignatura[@titulacion = current()/@id]">
								<li><xsl:value-of select="nombre"/></li>
								<ul>
									<li>Alumnos:</li>
									<xsl:for-each select="//alumnos/alumno[estudios/asignaturas/asignatura/@codigo = current()/@id]">
										<li><xsl:value-of select="nombre"/> / <xsl:value-of select="apellido1"/> / <xsl:value-of select="apellido2"/> </li>
									</xsl:for-each>
								</ul>
							</xsl:for-each>
						</ul>

					</xsl:for-each>
				</ol>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>