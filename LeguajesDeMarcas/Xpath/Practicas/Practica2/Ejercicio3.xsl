<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <title>Ejercicio 3 XSLT</title>
                <style>
                    table{
                        border-collapse: collapse;
                    }
                    .nom_autor{
                        color: purple;
                    }
                </style>
            </head>
            <body>
                <h3>Listado de artistas</h3>
                <ol>
                    <xsl:for-each select="//artistas/artista">
                        <li>Nombre: <label class="nom_autor"><xsl:value-of select="nombre"/></label></li>
                        <table border="1">
                                <tr>
                                    <th>Titulo</th>
                                    <th>Precio</th>
                                </tr>
                                <xsl:for-each select="//cds/cd[@autor = current()/@id]">
                                    <tr>
                                        <td><xsl:value-of select="titulo"/></td>
                                        <td><xsl:value-of select="precio"/></td>
                                    </tr>
                                </xsl:for-each>
                                <tr>
                                    <td>Total CDs: <xsl:value-of select="count(//cds/cd[@autor = current()/@id])"/></td>
                                    <td>Total CDs: <xsl:value-of select="sum(//cds/cd[@autor = current()/@id]/precio)"/></td>
                                </tr>

                        </table>
                    </xsl:for-each>
                </ol> 
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>