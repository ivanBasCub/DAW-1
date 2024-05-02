<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet  xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
    <html>
      <head>
        <title>Ejercicio 1 parte 3</title>
      </head>
      <body>
        <ol>
          <xsl:apply-templates select="//ciclo"/>
        </ol>
      </body>
    </html>
  </xsl:template>

  <xsl:template match="//ciclo">
    <li>
      Nombre: <xsl:value-of select="nombre"/> - ID <xsl:value-of select="@id"/> - Anio Decreto <xsl:value-of select="/decretoTitulo/@ano"/>
    </li>
  </xsl:template>
</xsl:stylesheet>