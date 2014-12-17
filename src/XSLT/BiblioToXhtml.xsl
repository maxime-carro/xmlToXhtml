<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:output method="html" encoding="utf-8" indent="yes" />

	<!-- Le template principal -->
	<xsl:template match="conferences">
		<html>
			<head>
				<meta charset="utf-8"></meta>
			</head>
			<body>

				<h1>Index des conférences</h1>
				<div id="indexConferences">
					<xsl:apply-templates select="//conference">
						<xsl:with-param name="num_traitement" select="0" />
						<xsl:sort select="edition/titre/text()" />
						<xsl:sort select="substring-before(edition/dateDebut, '-')" />
					</xsl:apply-templates>
				</div>

				<h1>Détails des conférences</h1>
				<div id="detailConferences">
					<xsl:apply-templates select="//conference">
							<xsl:with-param name="num_traitement" select="1" />
							<xsl:sort select="edition/acronyme/text()" />
							<xsl:sort select="substring-before(edition/dateDebut, '-')" />
					</xsl:apply-templates>
				</div>
			</body>
		</html>	
	</xsl:template>


	<!-- Les templates à appliquer -->

	<!-- Traitement principal, faisant appel à tous les autres templates -->
	<xsl:template match="conference">
		<!-- Il y a 2 traitements réalisés sur les conférences-->
		<xsl:param name="num_traitement" />

		<!-- variable contenant l'année extraite de la date de début de la conférence -->
		<xsl:variable name="annee" select="substring-before(edition/dateDebut, '-')" />

		<!-- Traitement pour l'index des conférences -->
		<xsl:if test="$num_traitement = 0">
			<li>
				<xsl:value-of select="edition/titre/text()"/> - 

						<xsl:if test="contains(articles/article/@id, $annee)" >
							<a href="#{edition/acronyme/text()}" ><xsl:value-of select="$annee" /></a>
						</xsl:if>
			</li>
		</xsl:if>

		<!-- Traitement pour les détails des conférences -->
		<xsl:if test="$num_traitement = 1">
			<div id="conference">
				<h2 id="{edition/acronyme/text()}">
					<xsl:value-of select="$annee" /> - 
					<xsl:value-of select="edition/acronyme/text()" /> - 
					<xsl:apply-templates select="edition/presidents/nom" />
					<xsl:value-of select="edition/ville/text()" />
				</h2>

				Il y a <xsl:value-of select="count(articles/article)" /> articles référencés. 

				<xsl:apply-templates select="edition/statistiques" />

				<xsl:apply-templates select="edition/meilleurArticle" />

				<h3>Les articles</h3>
				<div id="articles">
					<xsl:apply-templates select="articles" />
				</div>
			</div>
		</xsl:if>
		
	</xsl:template>



	<!-- Mise en forme des noms des présidents de la conférence -->
	<xsl:template match="presidents/nom">
		<xsl:value-of select="text()" /> - 
	</xsl:template>

	<!-- Traitement de chaque statistique selon les catégories d'articles -->
	<xsl:template match="acceptations">
		<li><xsl:value-of select="@soumissions" /> articles <xsl:value-of select="@id" /> soumis dont <xsl:value-of select="text()" /> acceptés. </li>
	</xsl:template>

	<!-- Traitement global des statistiques -->
	<xsl:template match="statistiques">
		<xsl:if test="not(acceptations)">
					Il n'y a aucune information sur les articles soumis/acceptés.
		</xsl:if>

		<xsl:if test="acceptations">
			<br/>
			Statistiques :
			<ul>
				<xsl:apply-templates select="acceptations" />
			</ul>
		</xsl:if>
	</xsl:template>

	<!-- Traitement sur les meilleurs articles -->
	<xsl:template match="meilleurArticle">

		<xsl:if test="not(articleId) or string-length(articleId/text()) = 0">
			<br/>
			Il n'y a aucun meilleur article. 
		</xsl:if>
		
		<xsl:if test="articleId and string-length(articleId/text()) != 0">
			<br/>
			Meilleur(s) article(s) : 
			<ul><xsl:apply-templates select="articleId" /></ul>
		</xsl:if>

	</xsl:template>

	<!-- Mise en forme de chaque id d'article référencé en meilleur article -->
	<xsl:template match="articleId">
		<li><xsl:value-of select="text()" /></li>
	</xsl:template>

	<!-- Tri sur les articles pour l'affichage -->
	<xsl:template match="articles">
		<xsl:apply-templates select="article" >
			<xsl:sort select="article/auteurs/auteur/nom[position() = 0]" />
		</xsl:apply-templates>
	</xsl:template>

	<!-- Traitement sur chaque article d'une conférence -->
	<xsl:template match="article">
		<xsl:apply-templates select="auteurs" />

		<h4><xsl:value-of select="titre/text()" /></h4>
		<p><xsl:value-of select="resume/text()" /></p>

		<hr />

		<h4><xsl:value-of select="title/text()" /></h4>
		<p><xsl:value-of select="abstract/text()" /></p>

	</xsl:template>

	<!-- Traitement pour tous les auteurs -->
	<xsl:template match="auteurs">
		<xsl:apply-templates select="auteur" />
	</xsl:template>

	<!-- Mise en forme des coordonnées d'un auteur -->
	<xsl:template match="auteur">
		<xsl:if test="email and string-length(email/text()) != 0">
			Auteur : <xsl:value-of select="nom/text()" /> -
			Contact : <xsl:value-of select="email/text()" />
		</xsl:if>

		<xsl:if test="not(email) or string-length(email/text()) = 0">
			Auteur : <xsl:value-of select="nom/text()" />
		</xsl:if>
		<br />
	</xsl:template>

</xsl:stylesheet>