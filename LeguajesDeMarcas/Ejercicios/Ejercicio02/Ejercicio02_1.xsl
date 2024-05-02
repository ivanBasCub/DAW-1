<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html>
      <head>
        <title>Ejercicio02 parte 1</title>
      </head>
      <style>
        table{
          border-collapse:collapse;
          text-align: center;
        }
        th{
          background-color: blue;
          color: white;
        }
      </style>
      <body>
        <table border="1">
          <tr>
            <th>Nombre</th>
            <th>Plan</th>
            <th>Créditos</th>
            <th>Centro</th>
            <th>Página web</th>
          </tr>
          <xsl:apply-templates select="//carrera"/>

        </table>
      </body>

    </html>
  </xsl:template>

  <xsl:template match="//carrera">
    <tr>
      <td><xsl:value-of select="nombre"/></td>
      <td><xsl:value-of select="plan"/></td>
      <td><xsl:value-of select="creditos"/></td>
      <td><xsl:value-of select="centro"/></td>
      <td><a href='{web}'>Enlace</a></td>
    </tr>
  </xsl:template>

</xsl:stylesheet>