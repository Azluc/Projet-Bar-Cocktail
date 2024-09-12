package com.cytech.gestionFichiers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cytech.collections.Client;
import com.cytech.collections.Commande;
import com.cytech.ingredients.Boisson;
import com.cytech.ingredients.BoissonAlcoolisee;
import com.cytech.ingredients.BoissonNonAlcoolisee;
import com.cytech.ingredients.Cocktail;

public class GestionListeCommande {
	private Map<String, Double> mapBoissonNA;//on va enregistrer la commande en séparant ses boissons et en les enregistrant avec leur nom, comme c'est fait pour les cocktails
	private Map<String, Double> mapBoissonA;
	private Map<String, Double> mapCocktail;
	
	private int id;
	private String clientQuiCommande;

	
	private Date date;

	public GestionListeCommande(Map<String, Double> mapBoissonA,
			Map<String, Double> mapBoissonNA, Map<String, Double> mapCocktail, int id,
			String clientQuiCommande, Date date) {
		super();
		this.mapBoissonA = mapBoissonA;
		this.mapBoissonNA = mapBoissonNA;
		this.mapCocktail = mapCocktail;
		this.id = id;
		this.clientQuiCommande = clientQuiCommande;
		this.date = date;

	}
	
	public GestionListeCommande(Commande commande) {
		//Contructeur qui permet de transformer directement la boisson en GestionListeCommande
		
		//on init les Maps
		mapBoissonA = new HashMap<String, Double>();
		mapBoissonNA = new HashMap<String, Double>();

		mapCocktail = new HashMap<String, Double>();
		
		this.clientQuiCommande = commande.getClientCommande();
		this.id = commande.getNumeroCommande();
		this.date = commande.getDateCommande();
		if (commande.getMapBoissonCommande() != null) {
			//On parcourt la liste de boisson qui ont ete commandée, en fonction de leur type, on enregistre leur nom dans les maps (et leur quantité)
			for (Map.Entry<Boisson, Double> entry : commande.getMapBoissonCommande().entrySet()) {
				if (entry.getKey().getClass() == BoissonNonAlcoolisee.class) {
					mapBoissonNA.put(entry.getKey().getNom() , entry.getValue());
				}
				else if (entry.getKey().getClass() == BoissonAlcoolisee.class) {
					mapBoissonA.put(entry.getKey().getNom(), entry.getValue());
				}
				
				else {
					mapCocktail.put(entry.getKey().getNom(), entry.getValue());
				}
			}
		}
		
	}
	
	public Commande toCommande(List<BoissonAlcoolisee> listeBoissonA, List<BoissonNonAlcoolisee> listeBoissonNA, List<Cocktail> listeCocktail) {
		/**
		  Permet de transformer la GestionListeCommande en commande
		Pour se faire, il faut parcourir les maps des boissons enregistrée avec leur nom (sous la forme <String, Double>)
		 Puis parcourir chaque stock pour récuperer la bonne instance de boisson
		 */
		Map<Boisson, Double> mapBoisson = new HashMap<Boisson, Double>();
		if (mapBoissonA != null) {
			
			if (listeBoissonA != null)
			{
				//On parcourt la map de string Double qui contient les noms de boissons

				for (Map.Entry<String, Double> entry : mapBoissonA.entrySet()) {
					//On parcourt le stock pour trouver la boisson correspondante

					for (BoissonAlcoolisee b : listeBoissonA) {
						if (b.getNom().equals(entry.getKey())) {
							mapBoisson.put(b, entry.getValue());
						}
					}
				}
			}
		}
		
		if (mapBoissonNA != null) {
			
			if (listeBoissonNA != null)
			{
				for (Map.Entry<String, Double> entry : mapBoissonNA.entrySet()) {
					for (BoissonNonAlcoolisee b : listeBoissonNA) {
						if (b.getNom().equals(entry.getKey())) {
							mapBoisson.put(b, entry.getValue());
						}
					}
				}
			}
		}
		
		if (mapCocktail != null) {
			
			if (listeCocktail != null)
			{
				for (Map.Entry<String, Double> entry : mapCocktail.entrySet()) {
					for (Cocktail b : listeCocktail) {
						if (b.getNom().equals(entry.getKey())) {
							mapBoisson.put(b, entry.getValue());
						}
					}
				}
			}
		}
		//On instancie la commande et on la renvoie

		Commande commande = new Commande(this.date,this.id, mapBoisson);
		commande.setClientCommande(clientQuiCommande);
		return commande;
	}
	
	@Override
	public String toString() {
		return this.mapBoissonA.toString();
	}
	
	
}
