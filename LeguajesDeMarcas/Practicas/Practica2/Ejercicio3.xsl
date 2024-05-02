<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <title>Ejercicio 3 XSLT</title>
                <style></style>
            </head>
            <body>
                <h3>Listado de artistas</h3>
                <ol>
                    <xsl:for-each select="//artistas/artista">
                        <li class="nom_autor">Nombre: <xsl:value-of select="nombre"/></li>
                        <table border="1">
                                <tr>
                                    <th>Titulo</th>
                                    <th>Precio</th>
                                </tr>
                                <xsl:for-each select="//discos/disco[@autor = current()/@id]">
                                    <tr>
                                        <td><xsl:value-of select="titulo"/></td>
                                        <td><xsl:value-of select="precio"/></td>
                                    </tr>
                                    <xsl:if test="current()/position() = last()">
                                    <tr>

                                    </tr>
                                </xsl:for-each>
                        </table>
                    </xsl:for-each>
                </ol> 
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>