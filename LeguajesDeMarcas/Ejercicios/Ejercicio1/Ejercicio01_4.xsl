<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html>
      <head>
        <title>Ejercicio 1 parte 4</title>
      </head>
      <body>
        <ul>
          <xsl:apply-templates select="//ciclo"/>
        </ul>
      </body>
    </html>
  </xsl:template>

  <xsl:template match="//ciclo">
    <li>
      <h1>
        <xsl:value-of select="nombre"/>
      </h1>
      <ul>
        <li>
          <xsl:value-of select = "grado"/>
        </li>
        <li>
          <xsl:value-of select = "decretoTitulo/@ano"/>
        </li>
      </ul>
    </li>


  </xsl:template>
</xsl:stylesheet>