package com.cytech.collections;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import com.cytech.gestionFichiers.GestionCommande;
import com.cytech.ingredients.Boisson;
import com.cytech.ingredients.BoissonSimple;
import com.cytech.ingredients.Cocktail;
import com.cytech.ingredients.Supplement;

public class Client {

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", motDePasse=" + motDePasse
				+ ", dateNaissance=" + dateNaissance + ", adresse=" + adresse + ", phraseSecrete=" + phraseSecrete
				+ ", barman=" + barman + "]";
	}
	private String nom;
	private String prenom;
	private String email;
	private String motDePasse;
	private Date dateNaissance;
	private String adresse;
	private String phraseSecrete;
	
	private Barman barman;
	
	public Client() {
	    // Constructeur sans argument
	}
	public Barman getBarman() {
		return barman;
	}

	public void setBarman(Barman barman) {
		this.barman = barman;
	}

	public Client(String nom, String prenom, String email, String motDePasse, Date dateNaissance, String adresse,
			String phraseSecrete) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = motDePasse;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.phraseSecrete = phraseSecrete;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPhraseSecrete() {
		return phraseSecrete;
	}

	public void setPhraseSecrete(String phraseSecrete) {
		this.phraseSecrete = phraseSecrete;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}
	

	
	public boolean commander(Map<Boisson, Double> mapBoissonCommande) {
		//Parcours de la map de la commande
		for(Map.Entry<Boisson, Double> entry : mapBoissonCommande.entrySet() ){
			
			//Si boisson simple
			if(entry.getKey().getClass() == BoissonSimple.class) {
				BoissonSimple boissonSimple = (BoissonSimple) entry.getKey();
				//Verifie si boisson simple dispo
				if(!barman.verifierStock(boissonSimple,entry.getValue())) {
					System.out.println(boissonSimple.getNom()+ " n'est plus disponible.");
					return false;
				}
				
			}
			
			//Sinon : coktail
			else if (entry.getKey().getClass() == Cocktail.class) {
				Cocktail cocktail = (Cocktail) entry.getKey();
				//Parcours des boissons simples que le cocktail contient
				for(Map.Entry<BoissonSimple, Double> entry1 : cocktail.getMapBoisson().entrySet()) {
					//Verifie si boisson simple dispo
					if(!barman.verifierStock(entry1.getKey(), entry1.getValue())) {
						System.out.println(entry1.getKey().getNom() + " n'est plus disponible.");
						return false;
					}
					
				}
				if(cocktail.getMapSupplement()!=null) {
				//Parcours des supplements que le cocktail contient
					for(Map.Entry<Supplement, Double> entry1 : cocktail.getMapSupplement().entrySet()) {
					//Verifie si supplement dispo
						if(!barman.verifierStock(entry1.getKey(), entry1.getValue())) {
							System.out.println(entry1.getKey().getNom() + " n'est plus disponible.");
							return false;
						}
					
					}
				}
				
			}
		}
		
		Commande commande = new Commande(new Date(), 1, mapBoissonCommande);
		commande.setClientCommande(nom);

		return barman.listeCommande.add(commande);
	}
	

	//Le barman vérifie si les boissons sont disponibles (ici on ne gère pas le stock de supplement)
	public Cocktail creerCocktailClient(Map<BoissonSimple, Double> mapBoisson, Map<Supplement, Double> mapSupplement) {
		
		for(Map.Entry<BoissonSimple, Double> entry : mapBoisson.entrySet()) {
			if(barman.verifierStock(entry.getKey(),entry.getValue())) {
			}
			
			else {
				System.out.println(entry.getKey().getNom()+ " n'est plus disponible.");
				return null;
			}
		}
		if(mapSupplement!=null) {
		for(Map.Entry<Supplement, Double> entry : mapSupplement.entrySet()) {
			if(barman.verifierStock(entry.getKey(),entry.getValue())) {
				}
				
			else {
				System.out.println(entry.getKey().getNom()+ " n'est plus disponible.");
				return null;
				}
			
		}	
		}
		Cocktail cocktailCree = new Cocktail(null,mapBoisson, mapSupplement);
		return cocktailCree;
		
	}
	public Date getDate() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setDate(String formatDateToISO8601) {
		// TODO Auto-generated method stub
		
	}
	
	
}