<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xsmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<head>
				<title>
					Examen Ivan Bascones
				</title>
					<!-- En el caso de que no funcione el comando link de html te aplico aqui el CSS -->
				<style>
					.Ejer1 p{
						background-color: green;
						color: white;
					}
					.Ejer1 table{
						border-collapse: collapse;
					}
					.Ejer1 th{
						background-color: yellow;
					}
					.Ejer2 table{
						border-collapse: collapse;
					}
					.Ejer2 th{
						background-color: blue;
						color: white;
					}
					.Ejer4 table{
						border-collapse: collapse;
					}
					.Ejer4 th{
						background-color: orange;
					}
					.Ejer5 p{
						font-weight: 800;
					}
				</style>
				<link rel="stylesheet" type="text/css" href="examen.css">
			</head>
			<body>
				<!-- Ejercicio 1 -->
				<div class="Ejer1">
					<h2>Ejercicio 1</h2>
					<xsl:apply-templates select="//facturas/factura"/>

				</div>
				<!-- Ejercicio 2 -->
				<div class="Ejer2">
					<h2>Ejercicio 2</h2>
					<h4>Tabla de Clientes</h4>
					<table border="1">
						<tr>
							<th>Nombre</th>
							<th>CIF</th>
							<th>Dirección</th>
							<th>Email</th>
							<th>Web</th>
						</tr>
						<xsl:for-each select="//clientes/cliente">
							<xsl:sort select="nombre"/>
							<tr>
								<td><xsl:value-of select="nombre"/></td>
								<td><xsl:value-of select="cif_nif"/></td>
								<td><xsl:value-of select="direccion"/></td>
								<td><xsl:value-of select="email"/></td>
								<td>
									<a href="{web}">
										<xsl:value-of select="web"/>
									</a>
								</td>
							</tr>
						</xsl:for-each>
					</table>
				</div>
				
				<!-- Ejercicio 3 -->
				<div class="Ejer3">
					<h2>Ejercicio 3</h2>
					<h4>Facturas con al menos 3 articulos distintos</h4>
					<ol>
						<xsl:for-each select="//facturas/factura[articulos/count(articulo)>=3]">
							<li>Factura: <xsl:value-of select="@idfactura"/> Fecha: <xsl:value-of select="fecha"/></li>
						</xsl:for-each>
					</ol>
				</div>
				<!-- Ejercicio 4 -->

				<div class="Ejer4">
					<h2> Ejercicio 4 </h2>
					<h4>Tabla de articulos</h4>
					<table boder="1">
						<tr>
							<th>Nombre</th>
							<th>Descripción</th>
							<th>Precio</th>
							<th>Oferta</th>
						</tr>
						<tr>
							<xsl:for-each select="//articulos/articulo">
								<td><xsl:value-of select="nombre"/></td>
								<td><xsl:value-of select="descripcion"/></td>
								<td><xsl:value-of select="precio"/></td>
								<td>
									<xsl:if test="(descuento >= 1) and (descuento &lt; 20)">
										<label>OFERTA</label>
									</xsl:if>
									<xsl:if test ="descuento >= 20">
										<label>SUPER OFERTA</label>
									</xsl:if>
								</td>
							</xsl:for-each>
						</tr>
					</table>
				</div>

				<!-- Ejercicio 5 -->
				<div class="Ejer5">
					<h2> Ejercicio 5</h2>
					<h4> Listado de Facturas por Cliente</h4>
					<xsl:for-each select="//clientes/cliente">
						<p><xsl:value-of select="nombre"/> - CIF: <xsl:value-of select="cif_nif"/></p>
						<xsl:variable name="idcli" select="@id"/>
						<ul>
							<xsl:for-each select="//facturas/factura">
								<xsl:if test="@idcliente = $idcli">
									<li><xsl:value-of select="@idfactura"/></li>
								</xsl:if>
							</xsl:for-each>
						</ul>
					</xsl:for-each>
				</div>
			</body>
		</html>
	</xsl:template>

	<xsl:template match="//facturas/factura">
		<p>Factura <xsl:value-of select="@idfactura"/> - <xsl:value-of select="fecha"/></p>
		<table border="1">
			<tr>
				<th>Articulo</th>
				<th>Cantidad</th>
				<th>Precio</th>
				<th>Total</th>
			</tr>
			<xsl:apply-templates select="//facturas/factura/articulos"/>
		</table>
	</xsl:template>

	<xsl:template match="//facturas/factura/articulos">
		<tr>
			<td><xsl:value-of select="articulo/@id"/></td>
			<td><xsl:value-of select="articulo/cantidad"/></td>
			<td><xsl:value-of select="articulo/precio"/></td>
			<td><xsl:value-of select="articulo/cantidad * articulo/precio"/></td>
		</tr>
	</xsl:template>
</xsl:stylesheet>