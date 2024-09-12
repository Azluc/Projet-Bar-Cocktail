package com.cytech.testsUnitaires;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.cytech.ingredients.Boisson;
import com.cytech.ingredients.BoissonAlcoolisee;
import com.cytech.ingredients.BoissonNonAlcoolisee;
import com.cytech.ingredients.BoissonSimple;
import com.cytech.ingredients.Cocktail;
import com.cytech.ingredients.Supplement;
import com.cytech.collections.Client;
import com.cytech.collections.Barman;

public class testClient {

	public static void testGetBarman() {
		// Crée un client
		Client client = new Client("nomClient", "prenomClient", "nomPrenomClient@example.com", "mdpClient", new Date(),
				"Cergy", "motdepasse");

		// Crée un barman
		Barman barman = new Barman("Barman", "mdpBarman");

		// Configure le barman du client
		client.setBarman(barman);

		// Teste la méthode getBarman
		Barman barmanDuClient = client.getBarman();
		if (barmanDuClient.getId().equals("Barman")) {
			System.out.println("	: Test GetBarman.");
		} else {
			System.out.println("ERREUR: Test GetBarman !");
		}
	}

	public static void testSetBarman() {
		// Crée un cient et un barman
		Client client = new Client("nomClient", "prenomClient", "nomPrenomClient@example.com", "mdpClient", new Date(),
				"Cergy", "motdepasse");
		// Barman barman = new Barman("Barman", "mdpBarman");

		// Modification du Barman
		Barman nouveauBarman = new Barman("BarmanBis", "mdpBarmanBis");
		client.setBarman(nouveauBarman);
		if (client.getBarman() == nouveauBarman) {
			System.out.println("	: Test SetBarman réussi.");
		} else {
			System.out.println("ERREUR : Test SetBarman !");
		}
	}
	
	public static void testConstructeurClient() {

		// Création d'un Client
		String nom = "nomBarman";
		String prenom = "prenomBarman";
		String email = "nomPrenomBarman@example.com";
		String motDePasse = "mdpBarman";
		Date dateNaissance = new Date();
		String adresse = "Cergy";
		String phraseSecrete = "phraseSecreteBarman";

		Client client = new Client(nom, prenom, email, motDePasse, dateNaissance, adresse, phraseSecrete);

		// Vérification des attributs
		if (client.getNom().equals(nom) && client.getPrenom().equals(prenom) && client.getEmail().equals(email)
				&& client.getMotDePasse().equals(motDePasse) && client.getDateNaissance().equals(dateNaissance)
				&& client.getAdresse().equals(adresse) && client.getPhraseSecrete().equals(phraseSecrete)) {
			System.out.println("	: Test Constructeur Client réussi.");
		} else {
			System.out.println("ERREUR : Test Constructeur Client !");
		}
	}

	public static void testGetEmail() {
		// Création d'une instance de Client
		Client client = new Client("nomClient", "prenomClient", "nomPrenomClient@example.com", "mdpClient", new Date(),
				"Cergy", "motdepasse");

		// Test de la méthode getEmail
		String email = client.getEmail();
		if (email.equals("nomPrenomClient@example.com")) {
			System.out.println("	: Test getEmail réussi.");
		} else {
			System.out.println("ERREUR : Test getEmail !");
		}
	}
	
	public static void testSetEmail() {
		// Création d'une instance de Client
		Client client = new Client("nomClient", "prenomClient", "nomPrenomClient@example.com", "mdpClient", new Date(),
				"Cergy", "motdepasse");

		// Modification de l'email
		client.setEmail("prenomNomClient@example.com");

		// Vérification du nouvel email
		String newEmail = client.getEmail();
		if (newEmail.equals("prenomNomClient@example.com")) {
			System.out.println("	: Test setEmail réussi.");
		} else {
			System.out.println("ERREUR : Test setEmail !");
		}
	}
	
	public static void testGetMotDePasse() {
		// Création d'un Client
		Client client = new Client("nomClient", "prenomClient", "nomPrenomClient@example.com", "mdpClient", new Date(),
				"Cergy", "motdepasse");

		// Vérification du mot de passe
		String motDePasse = client.getMotDePasse();
		if (motDePasse.equals("mdpClient")) {
			System.out.println("	: Test getMotDePasse réussi.");
		} else {
			System.out.println("ERREUR : Test getMotDePasse !");
		}
	}

	public static void testSetMotDePasse() {
		// Création d'un Client
		Client client = new Client("nomClient", "prenomClient", "nomPrenomClient@example.com", "mdpClient", new Date(),
				"Cergy", "motdepasse");

		// Changement du mot de passe
		client.setMotDePasse("nouveauMpdClient");

		// Vérification du nouveau mot de passe
		String nouveauMotDePasse = client.getMotDePasse();
		if (nouveauMotDePasse.equals("nouveauMpdClient")) {
			System.out.println("	: Test setMotDePasse réussi.");
		} else {
			System.out.println("ERREUR : Test setMotDePasse !");
		}
	}

	public static void testGetAdresse() {
		// Création d'un Client
		Client client = new Client("nomClient", "prenomClient", "nomPrenomClient@example.com", "mdpClient", new Date(),
				"Cergy", "motdepasse");

		// Récupération de l'adresse
		String adresse = client.getAdresse();

		// Vérification de l'adresse
		if (adresse.equals("Cergy")) {
			System.out.println("	: Test getAdresse réussi.");
		} else {
			System.out.println("ERREUR : Test getAdresse !");
		}
	}

	public static void testSetAdresse() {
		// Création d'un Client
		Client client = new Client("nomClient", "prenomClient", "nomPrenomClient@example.com", "mdpClient", new Date(),
				"Cergy", "motdepasse");

		// Changement de l'adresse du client
		client.setAdresse("Pontoise");

		// Vérification de la nouvelle adresse
		String nouvelleAdresse = client.getAdresse();
		if (nouvelleAdresse.equals("Pontoise")) {
			System.out.println("	: Test setAdresse réussi.");
		} else {
			System.out.println("ERREUR : Test setAdresse !");
		}
	}

	public static void testGetPhraseSecrete() {
		// Création d'un Client
		Client client = new Client("nomClient", "prenomClient", "nomPrenomClient@example.com", "mdpClient", new Date(),
				"Cergy", "phraseSecrete");

		// Récupération de la phrase secrète
		String phraseSecrete = client.getPhraseSecrete();

		// Vérification de l'adresse
		if (phraseSecrete.equals("phraseSecrete")) {
			System.out.println("	: Test getPhraseSecrete réussi.");
		} else {
			System.out.println("ERREUR : Test getPhraseSecrete !");
		}
	}

	public static void testSetPhraseSecrete() {
		// Création d'un Client
		Client client = new Client("nomClient", "prenomClient", "nomPrenomClient@example.com", "mdpClient", new Date(),
				"Cergy", "phraseSecrete");

		// Changement de la phrase secrète du client
		client.setPhraseSecrete("nouvellePhraseSecrete");

		// Vérification de la nouvelle adresse
		String nouvellePhraseSecrete = client.getPhraseSecrete();
		if (nouvellePhraseSecrete.equals("nouvellePhraseSecrete")) {
			System.out.println("	: Test setPhraseSecrete réussi.");
		} else {
			System.out.println("ERREUR : Test setPhraseSecrete !");
		}
	}

	public static void testGetNom() {
		// Création d'un Client
		Client client = new Client("nomClient", "prenomClient", "nomPrenomClient@example.com", "mdpClient", new Date(),
				"Cergy", "phraseSecrete");

		// Récupération du nom du Client
		String nomClient = client.getNom();

		// Vérification du nom du client
		if (nomClient.equals("nomClient")) {
			System.out.println("	: Test getNom réussi.");
		} else {
			System.out.println("ERREUR : Test getNom!");
		}
	}

	public static void testGetPrenom() {
		// Création d'un Client
		Client client = new Client("nomClient", "prenomClient", "nomPrenomClient@example.com", "mdpClient", new Date(),
				"Cergy", "phraseSecrete");

		// Récupération du prénom du Client
		String prenomClient = client.getPrenom();

		// Vérification du nom du client
		if (prenomClient.equals("prenomClient")) {
			System.out.println("	: Test getPrénom réussi.");
		} else {
			System.out.println("ERREUR : Test getPrénom!");
		}
	}

	public static void testGetDateNaissance() {

		// Création d'un Client avec un date de naissance le 1 janvier 2000
		Date dateNaissance = new Date(2000 - 1 - 1);
		Client client = new Client("nomClient", "prenomClient", "nomPrenomClient@example.com", "mdpClient",
				dateNaissance, "Cergy", "phraseSecrete");

		// Récupération de la date de naissance du Client
		Date dateNaissanceGet = client.getDateNaissance();

		// Vérification de la date de naissance du client
		if (dateNaissanceGet.equals(dateNaissance)) {
			System.out.println("	: Test getDateNaissance réussi.");
		} else {
			System.out.println("ERREUR : Test getDateNaissance!");
		}
	}


	public static void testCommanderBoissons() {
        // Création d'un barman
        Barman barman = new Barman("Barman", "mdpBarman");
        
        // Création d'une instance de Client
        Client client = new Client("nomClient", "prenomClient", "nomPrenomClient@example.com", "mdpClient", new Date(), "Cergy", "motdepasse");
        
        // Configuration du barman du client
        client.setBarman(barman);
        
        // Création de boissons pour la commande
        BoissonNonAlcoolisee coca = new BoissonNonAlcoolisee("Coca", 33, 3, 0, 40, 80);
        BoissonAlcoolisee whisky = new BoissonAlcoolisee("Whiskhy", 12, 10, 35, 5, 50);
		
		barman.listeBoissonSimple.add(whisky);
		barman.listeBoissonSimple.add(coca);
        
		Map<Boisson, Double> boissonsCommandees = new HashMap<>();
        boissonsCommandees.put(coca, 2.0); // 2 coca
        boissonsCommandees.put(whisky, 1.0); // 1 whisky
        
        // Test de la méthode commander
        if (client.commander(boissonsCommandees)) {
            System.out.println("	: Test CommanderBoisson réussi.");
        } else {
            System.out.println("ERREUR : Test CommanderBoisson !");
        }
    }
	
	// Création Commande d'un cocktail (sans supplément) et de boissons
			public static void testCommanderCocktailEtBoissons() {
		        // Création d'un barman
		        Barman barman = new Barman("Barman", "mdpBarman");
		        
		        // Création d'une instance de Client
		        Client client = new Client("nomClient", "prenomClient", "nomPrenomClient@example.com", "mdpClient", new Date(), "Cergy", "motdepasse");
		        
		        // Configuration du barman du client
		        client.setBarman(barman);
		        
		        // Création d'un cocktail pour la commande
		        BoissonNonAlcoolisee sucreDeCanne = new BoissonNonAlcoolisee("Sucre de Canne", 2, 3, 0, 80, 80);
		        BoissonNonAlcoolisee eauGazeuse = new BoissonNonAlcoolisee("Eau Gazeuse", 20, 3, 0, 80, 80);
		        BoissonAlcoolisee rhum = new BoissonAlcoolisee("Rhum", 4, 10, 40, 5, 50);
				
				barman.listeBoissonSimple.add(sucreDeCanne);
				barman.listeBoissonSimple.add(eauGazeuse);
				barman.listeBoissonSimple.add(rhum);

		        // Création de la map du cocktail
		        Map<BoissonSimple, Double> mapMojito = new HashMap<>();
		        mapMojito.put(sucreDeCanne, 1.0);
		        mapMojito.put(eauGazeuse, 1.0);
		        mapMojito.put(rhum, 1.0);

		        Cocktail mojito = new Cocktail("Mojito", mapMojito, null);
		        
		        barman.listeCocktail.add(mojito);

		        // Création de boissons pour la commande
		        BoissonNonAlcoolisee coca = new BoissonNonAlcoolisee("Coca", 33, 3, 0, 40, 80);
		        BoissonAlcoolisee whisky = new BoissonAlcoolisee("Whiskhy", 12, 10, 35, 5, 50);
				
				barman.listeBoissonSimple.add(whisky);
				barman.listeBoissonSimple.add(coca);
		        
				// Création de la map de la commande
				Map<Boisson, Double> boissonsCommandees = new HashMap<>();
				boissonsCommandees.put(mojito, 1.0);
		        boissonsCommandees.put(coca, 2.0);
		        boissonsCommandees.put(whisky, 1.0); 
		      
		        // Test de la méthode commander
		        if (client.commander(boissonsCommandees)) {
		            System.out.println("	: Test testCommanderCocktailEtBoissons réussi.");
		        } else {
		            System.out.println("ERREUR : Test testCommanderCocktailEtBoissons !");
		        }
		    }
		
	
	// Création Commande d'un cocktail avec des suppléments et de boissons
	public static void testCommanderCocktailSupplementsEtBoissons() {
        // Création d'un barman
        Barman barman = new Barman("Barman", "mdpBarman");
        
        // Création d'une instance de Client
        Client client = new Client("nomClient", "prenomClient", "nomPrenomClient@example.com", "mdpClient", new Date(), "Cergy", "motdepasse");
        
        // Configuration du barman du client
        client.setBarman(barman);
        
        // Création d'un cocktail pour la commande
        BoissonNonAlcoolisee sucreDeCanne = new BoissonNonAlcoolisee("Sucre de Canne", 2, 3, 0, 80, 80);
        BoissonNonAlcoolisee eauGazeuse = new BoissonNonAlcoolisee("Eau Gazeuse", 20, 3, 0, 80, 80);
        BoissonAlcoolisee rhum = new BoissonAlcoolisee("Rhum", 4, 10, 40, 5, 50);
		
		barman.listeBoissonSimple.add(sucreDeCanne);
		barman.listeBoissonSimple.add(eauGazeuse);
		barman.listeBoissonSimple.add(rhum);

        // Création de la map du cocktail
        Map<BoissonSimple, Double> mapMojito = new HashMap<>();
        mapMojito.put(sucreDeCanne, 1.0);
        mapMojito.put(eauGazeuse, 1.0);
        mapMojito.put(rhum, 1.0);
		
        // Création d'un supplément
        Supplement citron = new Supplement("Tranche de citrons", 0.5, 100.0);
        Supplement glacePilee = new Supplement("Glace Pilée", 4.0, 100.0);

		barman.listeSupplement.add(citron);
		barman.listeSupplement.add(glacePilee);

        // Création de la map de suppléments
        Map<Supplement, Double> mapSupplement = new HashMap<>();
        mapSupplement.put(citron, 1.0);
        mapSupplement.put(glacePilee, 1.0);

        Cocktail mojito = new Cocktail("Mojito", mapMojito, mapSupplement);
        
        barman.listeCocktail.add(mojito);

        // Création de boissons pour la commande
        BoissonNonAlcoolisee coca = new BoissonNonAlcoolisee("Coca", 33, 3, 0, 40, 80);
        BoissonAlcoolisee whisky = new BoissonAlcoolisee("Whiskhy", 12, 10, 35, 5, 50);
		
		barman.listeBoissonSimple.add(whisky);
		barman.listeBoissonSimple.add(coca);
        
		// Création de la map de la commande
		Map<Boisson, Double> boissonsCommandees = new HashMap<>();
		boissonsCommandees.put(mojito, 1.0);
        boissonsCommandees.put(coca, 2.0);
        boissonsCommandees.put(whisky, 1.0); 
        
        // Test de la méthode commander
        if (client.commander(boissonsCommandees)) {
            System.out.println("	: Test testCommanderCocktailSupplementsEtBoissons réussi.");
        } else {
            System.out.println("ERREUR : Test testCommanderCocktailSupplementsEtBoissons !");
        }
    }

	
	public static void testCreerCocktailClient() {
        // Création d'une instance de Client et Barman
        Client client = new Client("nomClient", "prenomClient", "nomPrenomClient@example.com", "mdpClient", new Date(), "Cergy", "motdepasse");
        Barman barman = new Barman("Barman", "mdpBarman");
        client.setBarman(barman);
        
        // Création de boissons pour le cocktail
        BoissonNonAlcoolisee coca = new BoissonNonAlcoolisee("Coca", 33, 3, 0, 40, 80);
        BoissonAlcoolisee whisky = new BoissonAlcoolisee("Whiskhy", 12, 10, 35, 5, 50);
		
		barman.listeBoissonSimple.add(whisky);
		barman.listeBoissonSimple.add(coca);
		
        Map<BoissonSimple, Double> mapBoisson = new HashMap<>();
        mapBoisson.put(coca, 2.0);
        mapBoisson.put(whisky, 1.0);
        
        // Création d'un supplément
        Supplement orange = new Supplement("Tranche d'Orange", 0.5, 100.0); // Par exemple, une quantité de 100
        barman.listeSupplement.add(orange);
        // Création de la map de suppléments
        Map<Supplement, Double> mapSupplement = new HashMap<>();
        mapSupplement.put(orange, 1.0); // Ajoute une tranche d'orange au cocktail

        // Test de la méthode creerCocktailClient
        Cocktail cocktailCree = client.creerCocktailClient(mapBoisson, mapSupplement);
        if (cocktailCree != null) {
            System.out.println("	: Test CreerCocktailClient réussi.");
        } else {
            System.out.println("ERREUR : Test CreerCocktailClient !");
        }
    }
	
	public static void testCreerCocktailClientSansSupplement() {
        // Création d'une instance de Client et Barman
        Client client = new Client("nomClient", "prenomClient", "nomPrenomClient@example.com", "mdpClient", new Date(), "Cergy", "motdepasse");
        Barman barman = new Barman("Barman", "mdpBarman");
        client.setBarman(barman);
        
        // Création de boissons pour le cocktail
        BoissonNonAlcoolisee coca = new BoissonNonAlcoolisee("Coca", 33, 3, 0, 40, 80);
        BoissonAlcoolisee whisky = new BoissonAlcoolisee("Whiskhy", 12, 10, 35, 5, 50);
		
		barman.listeBoissonSimple.add(whisky);
		barman.listeBoissonSimple.add(coca);
		
		// Création de la map boisson
        Map<BoissonSimple, Double> mapBoisson = new HashMap<>();
        mapBoisson.put(coca, 2.0);
        mapBoisson.put(whisky, 1.0);
        

        // Test de la méthode creerCocktailClient
        Cocktail cocktailCree = client.creerCocktailClient(mapBoisson, null);
        if (cocktailCree != null) {
            System.out.println("	: Test testCreerCocktailClientSansSupplement réussi.");
        } else {
            System.out.println("ERREUR : Test testCreerCocktailClientSansSupplement !");
        }
    }


}