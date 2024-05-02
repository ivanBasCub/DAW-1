<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html>
      <head>
        <title>Ejercicio 1 parte 6</title>
      </head>
      <body>
        <h1 style="color:blue">
          <xsl:apply-templates select="//ies"/>
        </h1>

        <ul>
          <xsl:apply-templates select="//ciclos/ciclo[decretoTitulo/@ano >= 2008]"/>
        </ul>
      </body>
    </html>
  </xsl:template>

  <xsl:template match="//ies">
    <xsl:value-of select="@nombre"/>
  </xsl:template>

  <xsl:template match="//ciclos/ciclo[decretoTitulo/@ano >= 2008]">
    <li>
      <xsl:value-of select="nombre"/>
    </li>
  </xsl:template>

</xsl:stylesheet>