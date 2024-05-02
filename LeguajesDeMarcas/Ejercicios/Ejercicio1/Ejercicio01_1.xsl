<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html>
      <head>
        <title>Ejercicio 01 parte 1</title>
      </head>
      <body>
        <h1> Ciclos </h1>
        <ol>
          <xsl:apply-templates select="//nombre"/>
        </ol>
      </body>
    </html>
  </xsl:template>
      
  <xsl:template match="//nombre">
    <li>
      <xsl:value-of select ="."/>
    </li>
  </xsl:template>
  
</xsl:stylesheet>