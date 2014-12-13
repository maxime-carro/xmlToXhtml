xmlToXhtml
________________________

Description : 

xmlToXhtml est un programme simple qui permet aux utilisateurs de transformer un fichier de conferences XML en XTHML


________________________

Environement : 

Pour pouvoir compiler les sources de la partie SAX, il est nécessaire de posséder à minima
java 1.7 (windows ou linux).


________________________

Licence : 

Merci d'aller voir dans le fichier LICENCE joint.


________________________

Sources : 

Les sources du projet sont disponible sur github à l'adresse suivante : 
https://github.com/maxime-carro/xmlToXhtml.git


________________________

Architecture : 

	- build.xml : Fichier ant permettant la compilation et exécution selon les différentes 
méthodes
	- src : Répertoire dans lequel se trouve toutes les sources du projet. Un sous répertoire
est crée pour chaque méthode utilisée (SAX et XSLT).
	- examples : Répertoire contenant des exemples de fichier xml à changer en xhtml, et la
version xhtml qui leur correspond.
	- ressources : Répertoires contenant toutes les ressources utilisées. Par exemple les fichiers
xschema, css, etc...


________________________

Auteurs : 
	Maxime CARRO <maxime.carro@etu.univ-nantes.fr>
	Célia STRZELECKI <celia.strzelecki@etu.univ-nantes.fr>
	
