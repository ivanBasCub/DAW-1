<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<!-- Elemento principal -->
	<xsl:template match="/">
		<html>
			<head>
				<title>Ejemplo XSLT</title>
			</head>
			<body>
		<!-- LLamado a una plantilla creada del codigo -->
				<p><xsl:apply-templates select="//nombre"/></p>
				<p><xsl:apply-templates select="//habitantes"/></p>
			</body>
		</html>
	</xsl:template>

	<!-- Crear una plantilla para mostrar una información especifica del documento xml -->
	
<!--
	<xsl:template match="//ciudad">
		<p>
			<xsl:value-of select="nombre"/> - habitantes: <xsl:value-of select="habitantes"/>
		</p>
	</xsl:template>
-->

	<xsl:template match="//nombre">
		<xsl:value-of select="."/> - 
	</xsl:template>

	<xsl:template match="//habitantes">
		<xsl:value-of select="."/> - 
	</xsl:template>
</xsl:stylesheet>