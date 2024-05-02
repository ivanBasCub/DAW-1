<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<head>
			<title>Ejercicio 2 parte 5</title>
		</head>

		<body>
			<ol>
				<xsl:for-each select="//carreras/carrera">
					<xsl:sort select = "centro"/>
					<li>
						<xsl:value-of select="centro"/>
						<ul>
							<xsl:for-each select="//alumno[estudios/carrera/@codigo = current()/@id]">
								<li><xsl:value-of select="nombre"/></li>
							</xsl:for-each>
						</ul>
					</li>

					<xsl:if test="centro != centro[position()>1]">
						
					</xsl:if>
				</xsl:for-each>
			</ol>
		</body>
	</xsl:template>
</xsl:stylesheet>