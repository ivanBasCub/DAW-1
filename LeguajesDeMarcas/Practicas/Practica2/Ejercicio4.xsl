<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <title>Ejercicio 4 XSLT</title>
                <style>
                    table{
                        border-collapse: collapse;
                    }
                    .espana{
                        background-color: blue;
                        color: white;
                    }
                </style>
            </head>
            <body>
                <h3>Lista de Discos</h3>
                <table border="1">
                    <tr>
                        <th>Titulo</th>
                        <th>Autor</th>
                        <th>Discografía</th>
                        <th>País</th>
                    </tr>
                    <xsl:for-each select="//cds/cd">
                        <xsl:if test="anio >= 2000">
            
                            <xsl:variable name="discId" select="@disc"/>
                            <xsl:variable name="autorId" select="@autor"/>
                            <xsl:variable name="discNacionalidad" select="/catalogo/discograficas/discografica[@id = $discId]/nacionalidad"/>
                            <xsl:variable name="autorNombre" select="/catalogo/artistas/artista[@id = $autorId]/nombre"/>
                            <xsl:variable name="discNombre" select="/catalogo/discograficas/discografica[@id = $discId]/nombre"/>

                            <xsl:choose>
                                <xsl:when test="$discNacionalidad = 'España'">
                                    <tr class="espana">
                                        <td><xsl:value-of select="titulo"/></td>
                                        <td><xsl:value-of select="$autorNombre"/></td>
                                        <td><xsl:value-of select="$discNombre"/></td>
                                        <td><xsl:value-of select="$discNacionalidad"/></td>
                                    </tr>
                                </xsl:when>
                                <xsl:otherwise>
                                    <tr>
                                        <td><xsl:value-of select="titulo"/></td>
                                        <td><xsl:value-of select="$autorNombre"/></td>
                                        <td><xsl:value-of select="$discNombre"/></td>
                                        <td><xsl:value-of select="$discNacionalidad"/></td>
                                    </tr>
                                </xsl:otherwise>
                            </xsl:choose>
                        </xsl:if>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
