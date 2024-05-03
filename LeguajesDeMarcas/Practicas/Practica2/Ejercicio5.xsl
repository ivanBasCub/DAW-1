<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <title>Ejercicio 5 XSLT</title>
                <style>
                    table {
                        border-collapse: collapse;
                    }
                </style>
            </head>
            <body>
                <h3>Listados de Discos v2</h3>
                <table border="1">
                    <tr>
                        <th>Titulo CD</th>
                        <th>Nombre Discografica</th>
                        <th>Nacionalidad Discografica</th>
                        <th>Nombre Autor</th>
                        <th>Nacionalidad Autor</th>
                    </tr>

                    <xsl:for-each select="//cds/cd">
                        <!-- ID de discoteca y artista del cd -->
                        <xsl:variable name="discId" select="@disc"/>
                        <xsl:variable name="artistaId" select="@autor"/>
                        
                        <!-- Nacionalidades de discoteca y artista -->
                        <xsl:variable name="discNac" select="//discograficas/discografica[@id = $discId]/nacionalidad"/>
                        <xsl:variable name="artistaNac" select="//artistas/artista[@id = $artistaId]/nacionalidad"/>

                        <!-- Nombre de las discotecas y artista -->
                        <xsl:variable name="discNom" select="//discograficas/discografica[@id = $discId]/nombre"/>
                        <xsl:variable name="artistaNom" select="//artistas/artista[@id = $artistaId]/nombre"/>

                        <!-- HTML -->
                        <xsl:if test="($discNac = 'USA') and ($artistaNac = 'USA')">
                            <tr>
                                <td><xsl:value-of select="titulo"/></td>
                                <td><xsl:value-of select="$discNom"/></td>
                                <td><xsl:value-of select="$discNac"/></td>
                                <td><xsl:value-of select="$artistaNom"/></td>
                                <td><xsl:value-of select="$artistaNac"/></td>
                            </tr>
                        </xsl:if>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>