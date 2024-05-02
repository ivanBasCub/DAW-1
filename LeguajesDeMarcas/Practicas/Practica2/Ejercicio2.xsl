<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <title> Ejercicio 2 XSLT </title>
                <style>
                </style>
            </head>
            <body>
                <h3> Listas de Discografias </h3>
                <ul>
                    <xsl:for-each select="//discograficas/discografica">
                        <li><xsl:value-of select="nombre"/></li>
                        <li><xsl:value-of select="nacionalidad"/></li>
                        <li><a href="{web}" target="_blank">Enlace Web</a></li>
                        <ol>
                            <xsl:for-each select="//cds/cd[@disc = current()/@id]">
                                <xsl:sort select="titulo"/>
                                <li><xsl:value-of select="titulo"/></li>
                            </xsl:for-each>
                        </ol>
                    </xsl:for-each>
                </ul>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>