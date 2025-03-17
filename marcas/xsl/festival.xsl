<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <!-- Salida en HTML con indentación -->
    <xsl:output method="html" encoding="UTF-8" indent="yes" />

    <!-- Parámetro para mensaje de bienvenida -->
    <xsl:param name="mensajeInicio" select="'Bienvenido al Festival de Cine'" />

    <!-- Definir clave para acceder a una película por su atributo id -->
    <xsl:key name="peliculaPorID" match="pelicula" use="@id" />

    <!-- Plantilla para el nodo raíz -->
    <xsl:template match="/festivalCine">
        <html>
            <head>
                <title>Festival de Cine</title>
                <style>
                    body { font-family: Arial, sans-serif; margin: 20px; }
                    .pelicula { border: 1px solid #ccc; padding: 10px; margin-bottom: 10px; }
        .premios { color: green; }
                    .larga { background-color: #f9f9f9; }
                </style>
            </head>
            <body>
                <h1>
                    <xsl:value-of select="$mensajeInicio" />
                </h1>

                <!-- Llamada a la plantilla para mostrar una película destacada -->
                <h2>Película Destacada:</h2>
                <xsl:call-template name="mostrarPeliculaPorID">
                    <xsl:with-param name="idPelicula" select="'2'" />
                </xsl:call-template>


                <hr />
                <h2>Listado de Todas las Películas:</h2>

                <xsl:apply-templates select="pelicula" />
            </body>
        </html>
    </xsl:template>

    <!-- Plantilla para cada película -->
    <xsl:template match="pelicula">
        <div>
            <xsl:attribute name="class">
                <xsl:choose>
                    <xsl:when test="number(duracion) &gt; 120">pelicula larga</xsl:when>
                    <xsl:otherwise>pelicula</xsl:otherwise>
                </xsl:choose>
            </xsl:attribute>
            <h2>
                <xsl:value-of select="titulo" />
            </h2>
            <p>
                <strong>Director:</strong>
                <xsl:value-of select="director" />
            </p>
            <p>
                <strong>Género:</strong>
                <xsl:value-of select="genero" />
                <!-- Comentario según el género (Aquí usamos el choose)-->
                <xsl:choose>
                    <xsl:when test="genero = 'Acción'">(Las más taquilleras)</xsl:when>
                    <xsl:when test="genero = 'Drama'">(Emotiva y profunda)</xsl:when>
                    <xsl:otherwise>(Variedad de estilos)</xsl:otherwise>
                </xsl:choose>
            </p>
            <p>
                <strong>Duración:</strong>
                <xsl:value-of select="duracion" /> minutos </p>
            <h3>Actores:</h3>
            <ul>
                <xsl:for-each select="actores/actor">
                    <li>
                        <xsl:value-of select="." />
                    </li>
                </xsl:for-each>
            </ul>
            <!-- Mostrar premios si existen -->
            <xsl:if test="premios">
                <div class="premios">
                    <h3>Premios:</h3>
                    <ul>
                        <xsl:for-each select="premios/premio">
                            <li>
                                <xsl:value-of select="." />
                            </li>
                        </xsl:for-each>
                    </ul>
                </div>
            </xsl:if>
        </div>
    </xsl:template>

    <!-- Plantilla nombrada: muestra una película específica usando la clave -->
    <xsl:template name="mostrarPeliculaPorID">
        <xsl:param name="idPelicula" />
        <xsl:variable name="peliculaSeleccionada"
            select="key('peliculaPorID', $idPelicula)" />
        <div class="pelicula">
            <h2>
                <xsl:value-of select="$peliculaSeleccionada/titulo" />
            </h2>
            <p>
                <strong>Director:</strong>
                <xsl:value-of select="$peliculaSeleccionada/director" />
            </p>
            <p>
                <strong>Género:</strong>
                <xsl:value-of select="$peliculaSeleccionada/genero" />
            </p>
            <p><strong>Duración:</strong> <xsl:value-of select="$peliculaSeleccionada/duracion" />
        minutos</p>
        </div>
    </xsl:template>

</xsl:stylesheet>