<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
  	<html>
  		<head>
  			<title>Ejercicio 1 parte 5</title>
  		</head>
  		<body>
  			<h2>Ciclos Impartidos</h2>
  			<table style="background-color: green;">
  				<tr style=" font-family: cursive;">
  					<xsl:apply-templates select="//nombre"/>
  				</tr>
  			</table>
  		</body>
  	</html>
  </xsl:template>

  <xsl:template match="//nombre">
  	<td><xsl:value-of select="."/></td>
  </xsl:template>

</xsl:stylesheet>