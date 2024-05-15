<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet  xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
    <html>
      <head>
        <title>Ejercicio 01 parte 2</title>
      </head>
      <body>
        <h1>Ciclos Impartidos</h1>
        <table>
          <tr>
            <xsl:apply-templates select="//nombre"/>
          </tr>
        </table>
      </body>
    </html>
  </xsl:template>
  <xsl:template match="//nombre">
    <td>
      <xsl:value-of select="."/>
    </td>
  </xsl:template>
</xsl:stylesheet>