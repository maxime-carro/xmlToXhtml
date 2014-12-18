/*
 * Copyright (c) 2014, Maxime Carro, Célia Strzelecki
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * 
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 * 
 * * Neither the name of xmlToXhtml nor the names of its
 *   contributors may be used to endorse or promote products derived from
 *   this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 */
package SAX;

import java.io.File;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import SAX.Bean.Article;
import SAX.Bean.Conference;
import SAX.Bean.Edition;

/**
 * 
 * @author Maxime Carro, Célia Strzelecki
 * @version 1.0
 * 
 */
public class SaxXmlToXhtml extends DefaultHandler
{
	private static final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
	private static final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
	private static final String JAXP_SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";
	
	private ArrayList<Conference> conferences;
	private Deque<Object> elementStack;
	private String currentElement;
	
	private int affiliationId;
	private String affiliationIdName;
	
	public void startDocument() throws SAXException
	{
		conferences = new ArrayList<Conference>();
		elementStack = new LinkedList<Object>();
		affiliationIdName = "";
	}

	public void startElement(String namespaceURI, String localName,
			String qName, Attributes atts) throws SAXException
	{
		currentElement = qName;
		switch (qName) {
		case "conference" : 
			Conference conf = new Conference();
			conferences.add(conf);
			this.elementStack.push(conf);
			break;
		case "edition" :
			Edition edition = new Edition();
			((Conference)elementStack.element()).setEdition(edition);
			elementStack.push(edition);
			break;
		case "article" : 
			Article article = new Article(atts.getValue("id"), atts.getValue("session"));
			((Conference)elementStack.element()).getArticles().add(article);
			elementStack.push(article);
			break;
		case "type" : 
			if(elementStack.element() instanceof Edition)
			{
				ArrayList<String[]> typeArticle = ((Edition)elementStack.element()).getTypeArticles();
				typeArticle.add(new String[2]);
				String[] str = typeArticle.get(typeArticle.size()-1);
				str[0] = atts.getValue("id");
			}
			break;
		case "acceptations" : 
			ArrayList<String[]> statistiques = ((Edition)elementStack.element()).getStatistiques();
			statistiques.add(new String[3]);
			String[] str2 = statistiques.get(statistiques.size()-1);
			str2[0] = atts.getValue("id");
			str2[1] = atts.getValue("soumissions");
			break;
		case "affiliation" :
			try {
				affiliationId = Integer.parseInt(atts.getValue("affiliationId"));
			}
			catch(Exception e)
			{
				System.out.println("Erreur dans la lecture de l'attribut : affiliationid");
			}
			break;
		case "nom" : 
			if(elementStack.element() instanceof Edition)
			{
				((Edition)elementStack.element()).getPresidents().add("");
			}
			break;
		case "articleid" :
			((Edition)elementStack.element()).getMeilleurArticle().add("");
			break;
		case "auteur" : 
			((Article)elementStack.element()).getAuteurs().add(new String[3]);
			break;
		}
	}

	public void characters(char[] ch, int start, int length) throws SAXException
	{
		String str = "";
		int j = length;
		for(int i = start; j>0; i++, j--)
		{
			str += ch[i];
		}
		str = str.trim();
		
		
		switch (this.currentElement) {
		case "acronyme" : 
			((Edition)elementStack.element()).setAcronyme(((Edition)elementStack.element()).getAcronyme() + str);
			break;
		case "titre" : 
			if( elementStack.element() instanceof Edition)
			{
				((Edition)elementStack.element()).setTitre(((Edition)elementStack.element()).getTitre() + str);
			}
			else
			{
				((Article)elementStack.element()).setTitre(((Article)elementStack.element()).getTitre() + str);
			}
			break;
		case "ville" : 
			((Edition)elementStack.element()).setVille(((Edition)elementStack.element()).getVille() + str);
			break;
		case "pays" : 
			((Edition)elementStack.element()).setPays(((Edition)elementStack.element()).getPays() + str);
			break;
		case "datedebut" : 
			((Edition)elementStack.element()).setDateDebut(((Edition)elementStack.element()).getDateDebut() + str);
			break;
		case "datefin" :
			((Edition)elementStack.element()).setDateFin(((Edition)elementStack.element()).getDateFin() + str);
			break;
		case "nom" : 
			if( elementStack.element() instanceof Edition)
			{
				ArrayList<String> presidents = ((Edition)elementStack.element()).getPresidents();
				String str2 = presidents.get(presidents.size()-1);
				str2 += str;
			}
			else
			{
				ArrayList<String[]> auteurs = ((Article)elementStack.element()).getAuteurs();
				String[] auteur = auteurs.get(auteurs.size()-1);
				if(auteur[0] == null)
				{
					auteur[0] = str;
				}
				else
				{
					auteur[0] += str;
				}
			}
			break;
		case "type" : 
			if( elementStack.element() instanceof Edition)
			{
				ArrayList<String[]> typearticles = ((Edition)elementStack.element()).getTypeArticles();
				String[] type = typearticles.get(typearticles.size()-1);
				if(type[1] == null)
				{
					type[1] = str;
				}
				else
				{
					type[1] += str;
				}
			}
			else
			{
				((Article)elementStack.element()).setType(((Article)elementStack.element()).getType() + str);
			}
			break;
		case "acceptations" : 
			ArrayList<String[]> satistiques = ((Edition)elementStack.element()).getStatistiques();
			String[] acceptations = satistiques.get(satistiques.size()-1);
			if(acceptations[2] == null)
			{
				acceptations[2] = str;
			}
			else
			{
				acceptations[2] += str;
			}
			break;
		case "siteweb" :
			((Edition)elementStack.element()).setSiteWeb(((Edition)elementStack.element()).getSiteWeb() + str);
			break;
		case "articleid" : 
			ArrayList<String> meilleur = ((Edition)elementStack.element()).getMeilleurArticle();
			String str2 = meilleur.get(meilleur.size()-1);
			str2 += str;
			break;
		case "email" : 
			ArrayList<String[]> auteurs = ((Article)elementStack.element()).getAuteurs();
			String[] auteur = auteurs.get(auteurs.size()-1);
			if(auteur[1] == null)
			{
				auteur[1] = str;
			}
			else
			{
				auteur[1] += str;
			}
			break;
		case "affiliationid" : 
			ArrayList<String[]> auteurs2 = ((Article)elementStack.element()).getAuteurs();
			String[] auteur2 = auteurs2.get(auteurs2.size()-1);
			if(auteur2[2] == null)
			{
				auteur2[2] = str;
			}
			else
			{
				auteur2[2] += str;
			}
			break;
		case "affiliation" : 
			affiliationIdName += str;
			break;
		case "pages" : 
			((Article)elementStack.element()).setPages(((Article)elementStack.element()).getPages() + str);
			break;
		case "resume" : 
			((Article)elementStack.element()).setResume(((Article)elementStack.element()).getResume() + str);
			break;
		case "mots_cles" : 
			((Article)elementStack.element()).setMotCles(((Article)elementStack.element()).getMotCles() + str);
			break;
		case "title" : 
			((Article)elementStack.element()).setTitle(((Article)elementStack.element()).getTitle() + str);
			break;
		case "abstract" : 
			((Article)elementStack.element()).setAbstractt(((Article)elementStack.element()).getAbstractt() + str);
			break;
		}
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException
	{
		if(qName == "conference" || qName == "edition" || qName == "article")
		{
			this.elementStack.pop();
		}
		if(qName == "affiliation")
		{
			((Article)elementStack.element()).getAffiliations().put(affiliationId, affiliationIdName);
			affiliationIdName = "";
		}
	}
	
	public void endDocument() throws SAXException
	{
		
	}

	/**
	 * Convert from a filename to a file URL.
	 */
	private static String convertToFileURL(String filename)
	{
		String path = new File(filename).getAbsolutePath();
		if (File.separatorChar != '/')
		{
			path = path.replace(File.separatorChar, '/');
		}
		if (!path.startsWith("/"))
		{
			path = "/" + path;
		}
		return "file:" + path;
	}

	static public void main(String[] args) throws Exception
	{
		String filename = null;

		for (int i = 0; i < args.length; i++)
		{
			if (args[i].equals("-help"))
			{
				System.err.println("Usage: SaxXmlToXhtml <file.xml>");
			} else
			{
				filename = args[i];
				if (i != args.length - 1)
				{
					System.err.println("Usage: SaxXmlToXhtml <file.xml>");
				}
			}
		}
		if (filename == null)
		{
			System.err.println("Usage: SaxXmlToXhtml <file.xml>");
		}


		SAXParserFactory saxFactory = SAXParserFactory.newInstance();

		saxFactory.setNamespaceAware(true);

		SAXParser saxParser = saxFactory.newSAXParser();
		
		XMLReader xmlReader = saxParser.getXMLReader();
		
		xmlReader.setContentHandler(new SaxXmlToXhtml());
		
		xmlReader.setErrorHandler(new MyErrorHandler(System.err));
		
		xmlReader.parse(convertToFileURL(filename));
	}
}
