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
				<div id="indexConferences">
					<xsl:apply-templates select="//conference">
						<xsl:sort select="edition/titre" />
					</xsl:apply-templates>
				</div>
				<div id="detailConferences">
				</div>
			</body>
		</html>	
	</xsl:template>
	<!-- Les templates à appliquer -->
	<xsl:template match="conference">
		<xsl:value-of select="titre" />
		<!--<xsl:if test=""> -->
			<xsl:value-of select="edition/titre/text()"/>
		<!-- </xsl:if>-->
	</xsl:template>
</xsl:stylesheet>