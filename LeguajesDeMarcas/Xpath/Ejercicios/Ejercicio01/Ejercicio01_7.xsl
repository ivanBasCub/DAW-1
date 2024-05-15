<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html>
      <head>
        <title>Ejercicio 1 parte 7</title>
        <style>
          table{
            border-collapse: collapse;
            text-align: center;
          }
          th{
            background-color: blue;
          }
        </style>
      </head>

      <body>
        <xsl:apply-templates select="//ies"/>
        <table border = "1">
          <tr>
            <th> Nombre </th>
            <th> Grado </th>
            <th> Decreto </th>
          </tr>
          <xsl:apply-templates select="//ciclo">
            <xsl:sort select="nombre" order="descending"/>
          </xsl:apply-templates> 
        </table>
      </body>
    </html>
  </xsl:template>

  <xsl:template match="//ciclo">
    <tr>
      <td> <xsl:value-of select="nombre"/> </td>
      <td> <xsl:value-of select="grado"/> </td>
      <td> <xsl:value-of select="decretoTitulo/@ano"/> </td>   
    </tr>
  </xsl:template>


  <xsl:template match="//ies">
    <h1><xsl:value-of select="@nombre"/></h1>
    <!-- Forma Rapida encontrada en internet para la seleccion de atributos -->
    <a href='{@web}'> Enlace a la web </a>
    <!--Forma que se da en clase -->
    <a>
      <xsl:attribute name="href">
        <xsl:value-of select="@web"/>
      </xsl:attribute>
       Enlace al instituto
    </a>

  </xsl:template>

</xsl:stylesheet>