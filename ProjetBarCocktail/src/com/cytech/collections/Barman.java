package com.cytech.collections;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import com.cytech.ingredients.Boisson;
import com.cytech.ingredients.BoissonAlcoolisee;
import com.cytech.ingredients.BoissonNonAlcoolisee;
import com.cytech.ingredients.BoissonSimple;
import com.cytech.ingredients.Cocktail;
import com.cytech.ingredients.Supplement;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Barman {

	private String id;
	private String motDePasse;
	
	public ArrayList<Commande> listeCommande;
	public ArrayList<Cocktail> listeCocktail;
	public ArrayList<BoissonSimple> listeBoissonSimple;
	public ArrayList<Supplement> listeSupplement;
	
	
	public Barman(String id, String motDePasse) {
		super();
		this.id = id;
		this.motDePasse = motDePasse;
		
		listeCommande = new ArrayList<Commande>();
		listeCocktail = new ArrayList<Cocktail>() ;
		listeBoissonSimple = new ArrayList<BoissonSimple>();
		listeSupplement = new ArrayList<Supplement>();
	}
	
	public Barman() {
	    // Constructeur sans argument
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public String getId() {
		return id;
	}
	
	public ArrayList<Commande> getListeCommande() {
		return listeCommande;
	}


	public void setListeCommande(ArrayList<Commande> listeCommande) {
		this.listeCommande = listeCommande;
	}


	public ArrayList<Cocktail> getListeCocktail() {
		return listeCocktail;
	}


	public void setListeCocktail(ArrayList<Cocktail> listeCocktail) {
		this.listeCocktail = listeCocktail;
	}


	public ArrayList<BoissonSimple> getListeBoissonSimple() {
		return listeBoissonSimple;
	}


	public void setListeBoissonSimple(ArrayList<BoissonSimple> listeBoissonSimple) {
		this.listeBoissonSimple = listeBoissonSimple;
	}

	
	public ArrayList<Supplement> getListeSupplement() {
		return listeSupplement;
	}


	public void setListeSupplement(ArrayList<Supplement> listeSupplement) {
		this.listeSupplement = listeSupplement;
	}

	
	

	public boolean encaisserCommande(Commande commande) {
		double prixCommande = 0;
		
		for(Map.Entry<Boisson, Double> entry : commande.getMapBoissonCommande().entrySet() ){
			
			prixCommande += entry.getKey().getPrix()*entry.getValue();
			
			if(entry.getKey().getClass()== BoissonAlcoolisee.class) {
			BoissonAlcoolisee boissonSimple = (BoissonAlcoolisee) entry.getKey();
			boissonSimple.setQuantiteStock(boissonSimple.getQuantiteStock()-boissonSimple.getContenance());
			}
			
			else if(entry.getKey().getClass()== BoissonNonAlcoolisee.class) {
				BoissonNonAlcoolisee boissonSimple = (BoissonNonAlcoolisee) entry.getKey();
				boissonSimple.setQuantiteStock(boissonSimple.getQuantiteStock()-boissonSimple.getContenance());
				}
			
			else {
				Cocktail cocktail = (Cocktail) entry.getKey();
				for(Map.Entry<BoissonSimple, Double> entry1 : cocktail.getMapBoisson().entrySet()) {
					entry1.getKey().setQuantiteStock(entry1.getKey().getQuantiteStock() - entry1.getValue());
				}
				if(cocktail.getMapSupplement()!=null) {
					for(Map.Entry<Supplement, Double> entry1 : cocktail.getMapSupplement().entrySet()) {
						entry1.getKey().setQuantiteStock(entry1.getKey().getQuantiteStock() - entry1.getValue());
					}
				}
			}
		}
		
		
		System.out.println(" Prix de la commande"+ prixCommande);
		return true;	
	}
	
	
	
	public Cocktail creerCocktailBarman(String nom, Map<BoissonSimple, Double> mapBoisson, Map<Supplement, Double> mapSupplement) {
 
		Cocktail cocktailCree = new Cocktail(nom,mapBoisson, mapSupplement);
		listeCocktail.add(cocktailCree);
		return cocktailCree;
		
	}
	
	
	public boolean reapprovisionnerStock(BoissonSimple nom, double quantite) {
		if(listeBoissonSimple.contains(nom)) {
			nom.setQuantiteStock(nom.getQuantiteStock()+quantite);
			return true;
		}
			
		else {
			nom.setQuantiteStock(quantite);
			listeBoissonSimple.add(nom);
			return true;
		}
	}
	
	public boolean reapprovisionnerStock(Supplement nom, double quantite) {
		if(listeSupplement.contains(nom)) {
			nom.setQuantiteStock(nom.getQuantiteStock()+quantite);
			return true;
		}
			
		else {
			nom.setQuantiteStock(quantite);
			listeSupplement.add(nom);
			return true;
		}
	}
	
	
	
	public boolean verifierStock(BoissonSimple nom, double quantite) {
		if(listeBoissonSimple.contains(nom) && nom.getQuantiteStock()>= quantite) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verifierStock(Supplement nom, double quantite) {
		if(listeSupplement.contains(nom) && nom.getQuantiteStock()>= quantite) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verifierIdentifiants(String id, String motDePasse) {
	    try {
	        // Lecture du fichier JSON contenant les informations des barmans
	        FileReader reader = new FileReader("barman.json");

	        // Initialisation de Gson pour la conversion JSON vers objets Java
	        Gson gson = new Gson();

	        // Conversion du JSON en une liste d'objets Barman
	        ArrayList<Barman> barmans = gson.fromJson(reader, new TypeToken<ArrayList<Barman>>() {}.getType());

	        // Comparaison des identifiants
	        for (Barman barman : barmans) {
	            if (barman.getId().equals(id) && barman.getMotDePasse().equals(motDePasse)) {
	                return true; // Les identifiants correspondent
	            }
	        }
	        
	        // Si aucun barman avec ces identifiants n'est trouvé dans le fichier JSON
	        System.out.println("Le barman n'existe pas.");
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	
	
	
	
}

