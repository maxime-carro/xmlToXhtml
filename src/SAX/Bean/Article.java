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
package SAX.Bean;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author Maxime Carro, Célia Strzelecki
 * @version 1.0
 * 
 * Classe représentant un objet Article
 */
public class Article {
	
	private String id;
	private String session;
	
	private ArrayList<String[]> auteurs;
	private HashMap<Integer, String> affiliations;
	private String titre;
	private String type;
	private String pages;
	private String resume;
	private String motCles;
	private String title;
	private String abstractt;
	private String keywords;
	
	/**
	 * Constructeur de la classe Article qui initialise ses attributs
	 */
	public Article(String id, String session)
	{
		this.id = id;
		this.session = session;
		
		this.auteurs = new ArrayList<String[]>();
		this.affiliations = new HashMap<Integer, String>();
		this.titre = "";
		this.type = "";
		this.pages = "";
		this.resume = "";
		this.motCles = "";
		this.title = "";
		this.abstractt = "";
		this.keywords = "";
	}
	
	/**
	 * @return l'identifiant
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * @return la session
	 */
	public String getSession()
	{
		return session;
	}

	/**
	 * @return les auteurs
	 */
	public ArrayList<String[]> getAuteurs()
	{
		return auteurs;
	}

	/**
	 * @param auteurs les auteurs à modifier
	 */
	public void setAuteurs(ArrayList<String[]> auteurs)
	{
		this.auteurs = auteurs;
	}

	/**
	 * @return les affiliations
	 */
	public HashMap<Integer, String> getAffiliations()
	{
		return affiliations;
	}

	/**
	 * @param affiliations les affiliations à modifier
	 */
	public void setAffiliations(HashMap<Integer, String> affiliations)
	{
		this.affiliations = affiliations;
	}

	/**
	 * @return le titre
	 */
	public String getTitre()
	{
		return titre;
	}

	/**
	 * @param titre le titre à modifier
	 */
	public void setTitre(String titre)
	{
		this.titre = titre;
	}

	/**
	 * @return le type
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * @param type le type à modifier
	 */
	public void setType(String type)
	{
		this.type = type;
	}

	/**
	 * @return les numéros de pages
	 */
	public String getPages()
	{
		return pages;
	}

	/**
	 * @param pages les numéros de pages à modifier
	 */
	public void setPages(String pages)
	{
		this.pages = pages;
	}

	/**
	 * @return le resumé
	 */
	public String getResume()
	{
		return resume;
	}

	/**
	 * @param resume le resumé à modifier
	 */
	public void setResume(String resume)
	{
		this.resume = resume;
	}

	/**
	 * @return les mot clés
	 */
	public String getMotCles()
	{
		return motCles;
	}

	/**
	 * @param motCles les mot clés à modifier
	 */
	public void setMotCles(String motCles)
	{
		this.motCles = motCles;
	}

	/**
	 * @return the title
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}

	/**
	 * @return the abstract
	 */
	public String getAbstractt()
	{
		return abstractt;
	}

	/**
	 * @param abstractt the abstract to set
	 */
	public void setAbstractt(String abstractt)
	{
		this.abstractt = abstractt;
	}

	/**
	 * @return the keywords
	 */
	public String getKeywords()
	{
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(String keywords)
	{
		this.keywords = keywords;
	}
	
	
	
}