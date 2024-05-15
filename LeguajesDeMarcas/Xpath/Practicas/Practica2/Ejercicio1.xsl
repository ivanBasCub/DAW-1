<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html>
        <head>
            <title> Ejercicio 1 Practica </title>
            <style>
                table{
                    border-collapse: collapse;
                }
                .economico{
                    background-color: blue;
                }
                .estandar{
                    background-color: green;
                }
                .especial{
                    background-color: orange;
                }
            </style>
        </head>
        <body>
            <table border="1">
                <tr>
                    <th>Titulo</th>
                    <th>Año</th>
                    <th colspan="2">Precio</th>
                </tr>
                <xsl:for-each select="//cds/cd">
                   
                    <xsl:if test="precio &lt; 12">
                        <tr class="economico">
                            <td><xsl:value-of select="titulo"/></td>
                            <td><xsl:value-of select="anio"/></td>
                            <td><xsl:value-of select="precio"/></td>
                            <td>Economico</td>
                        </tr>
                    </xsl:if>
                    <xsl:if test="(precio > 12) and (precio &lt; 15)">
                        <tr class="estandar">
                            <td><xsl:value-of select="titulo"/></td>
                            <td><xsl:value-of select="anio"/></td>
                            <td><xsl:value-of select="precio"/></td>
                            <td>Estandar</td>
                        </tr>
                    </xsl:if>
                    <xsl:if test="precio > 15">
                        <tr class="especial">
                            <td><xsl:value-of select="titulo"/></td>
                            <td><xsl:value-of select="anio"/></td>
                            <td><xsl:value-of select="precio"/></td>
                            <td>Especial</td>
                        </tr>
                    </xsl:if>
                    
                </xsl:for-each>
            </table>
        </body>
    </html>
  </xsl:template>
</xsl:stylesheet>