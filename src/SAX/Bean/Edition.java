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

/**
 * 
 * @author Maxime Carro, Célia Strzelecki
 * @version 1.0
 * 
 * Classe représentant un objet Edition
 */
public class Edition {
	
	private String acronyme;
	private String titre;
	private String ville;
	private String pays;
	private String dateDebut;
	private String dateFin;
	private ArrayList<String> presidents;
	private ArrayList<String[]> typeArticles;
	private ArrayList<String[]> statistiques;
	private String siteWeb;
	private ArrayList<String> meilleurArticle;
	
	/**
	 * Constructeur de l'objet Edition qui initialise ses attributs
	 */
	public Edition() {
		acronyme = "";
		titre = "";
		ville = "";
		pays = "";
		dateDebut = "";
		dateFin = "";
		presidents = new ArrayList<String>();
		typeArticles = new ArrayList<String[]>();
		statistiques = new ArrayList<String[]>();
		siteWeb = "";
		meilleurArticle = new ArrayList<String>();
	}

	/**
	 * @return l'acronyme
	 */
	public String getAcronyme()
	{
		return acronyme;
	}

	/**
	 * @param acronyme l'acronyme à modifier
	 */
	public void setAcronyme(String acronyme)
	{
		this.acronyme = acronyme;
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
	 * @return la ville
	 */
	public String getVille()
	{
		return ville;
	}

	/**
	 * @param ville la ville à modifier
	 */
	public void setVille(String ville)
	{
		this.ville = ville;
	}

	/**
	 * @return le pays
	 */
	public String getPays()
	{
		return pays;
	}

	/**
	 * @param pays le pays à modifier
	 */
	public void setPays(String pays)
	{
		this.pays = pays;
	}

	/**
	 * @return la date de début
	 */
	public String getDateDebut()
	{
		return dateDebut;
	}

	/**
	 * @param dateDebut la date de debut à modifier
	 */
	public void setDateDebut(String dateDebut)
	{
		this.dateDebut = dateDebut;
	}

	/**
	 * @return la date de fin
	 */
	public String getDateFin()
	{
		return dateFin;
	}

	/**
	 * @param dateFin la date de fin à modifier
	 */
	public void setDateFin(String dateFin)
	{
		this.dateFin = dateFin;
	}

	/**
	 * @return la liste des présidents
	 */
	public ArrayList<String> getPresidents()
	{
		return presidents;
	}

	/**
	 * @param presidents la liste des présidents à modifier
	 */
	public void setPresidents(ArrayList<String> presidents)
	{
		this.presidents = presidents;
	}

	/**
	 * @return les types d'articles
	 */
	public ArrayList<String[]> getTypeArticles()
	{
		return typeArticles;
	}

	/**
	 * @param typeArticles les types d'articles à modifier
	 */
	public void setTypeArticles(ArrayList<String[]> typeArticles)
	{
		this.typeArticles = typeArticles;
	}

	/**
	 * @return la liste des statistiques
	 */
	public ArrayList<String[]> getStatistiques()
	{
		return statistiques;
	}

	/**
	 * @param statistiques la liste des statistiques à modifier
	 */
	public void setStatistiques(ArrayList<String[]> statistiques)
	{
		this.statistiques = statistiques;
	}

	/**
	 * @return le site web
	 */
	public String getSiteWeb()
	{
		return siteWeb;
	}

	/**
	 * @param siteWeb le site web à modifier
	 */
	public void setSiteWeb(String siteWeb)
	{
		this.siteWeb = siteWeb;
	}

	/**
	 * @return le meilleur article
	 */
	public ArrayList<String> getMeilleurArticle()
	{
		return meilleurArticle;
	}

	/**
	 * @param meilleurArticle la meilleur article à modifier
	 */
	public void setMeilleurArticle(ArrayList<String> meilleurArticle)
	{
		this.meilleurArticle = meilleurArticle;
	}

}



