package com.cytech.testsUnitaires;

public class Main {
public static void main(String[] args) {
		
		
		/* Collections*/
		System.out.println("---- Collections ----");

		// testBarman
		System.out.println("-- testBarman --");
		testBarman.testConstructeurBarman();
		testBarman.testGetMotDePasse();
		testBarman.testSetMotDePasse();
		testBarman.testGetId();

		testBarman.testGetListeCocktail();
		testBarman.testSetListeCocktail();
		testBarman.testGetListeBoissonSimple();
		testBarman.testSetListeBoissonSimple();
		testBarman.testGetListeSupplement();
		testBarman.testSetListeSupplement();
		testBarman.testGetListeCommande();
		testBarman.testSetListeCommande();
        
		testBarman.testEncaisserCommande();
		testBarman.testCreerCocktailBarman();
		testBarman.testReapprovisionnerStockBoissonSimple();
		testBarman.testReapprovisionnerStockSupplement();
		testBarman.testVerifierStockBoissonSimple();
		testBarman.testVerifierStockSupplement();
		
		// testClient
		System.out.println("-- testClient --");
		testClient.testGetBarman();	
		testClient.testSetBarman();
		testClient.testConstructeurClient();
		testClient.testGetEmail();
		testClient.testSetEmail();
		testClient.testGetMotDePasse();
		testClient.testSetMotDePasse();
		testClient.testGetAdresse();
		testClient.testSetAdresse();
		testClient.testGetPhraseSecrete();
		testClient.testSetPhraseSecrete();
		testClient.testGetNom();
		testClient.testGetPrenom();
		testClient.testGetDateNaissance();		
		testClient.testCommanderBoissons();
		testClient.testCommanderCocktailEtBoissons();
		testClient.testCommanderCocktailSupplementsEtBoissons();
		testClient.testCreerCocktailClient();
		testClient.testCreerCocktailClientSansSupplement();
		
		// testCommande
		System.out.println("-- testCommande --");
		testCommande.testGetDateCommande();
		testCommande.testGetNumeroCommande();
		testCommande.testGetMapBoissonCommande();
		testCommande.testSetMapBoissonCommande();
		
		
		
		/* Ingredients */
		System.out.println("\n\n---- Ingredients ----");

		// testBoisson
		System.out.println("-- testBoisson --");
		testBoisson.testGetNom();
		testBoisson.testGetContenance();
		testBoisson.testGetPrix();
		testBoisson.testGetDegreAlcool();
		testBoisson.testGetDegreSucre();
		testBoisson.testSetContenance();
		testBoisson.testSetPrix();
		testBoisson.testEstAlcoolisee();
		
		// testBoissonAlcoolisee
		System.out.println("-- testBoissonAlcoolisee --");
		testBoissonAlcoolisee.testGetDegreAlcool();
		//manque un test constructeur

		// testBoissonNonAlcoolisee
		System.out.println("-- testBoissonNonAlcoolisee --");
		testBoissonNonAlcoolisee.testGetDegreAlcool();
		//manque un test constructeur
		
		
		
		// testBoissonSimple
		System.out.println("-- testBoissonSimple --");
		testBoissonSimple.testSetQuantiteStock();
		testBoissonSimple.testGetQuantiteStock();
		
		// testCocktail
		System.out.println("-- testCocktail --");
		testCocktail.testConstructeurCocktail();
		testCocktail.testSetMapBoisson();
		testCocktail.testGetMapBoisson();
		testCocktail.testGetMapSupplement();
		testCocktail.testSetMapSupplement();
		testCocktail.testCalculerPrix();
		testCocktail.testCalculerContenance();
		testCocktail.testCalculerDegreAlcool();
		testCocktail.testCalculerSucre();
		testCocktail.testAjouterBoissonAlcoolisee();
		testCocktail.testAjouterBoissonNonAlcoolisee();
		testCocktail.testAjouterSupplement();
		testCocktail.testSupprimerBoissonNonAlcoolisee();
		testCocktail.testSupprimerBoissonAlcoolisee();
		testCocktail.testSupprimerSupplement();
		
		// testSupplement
		System.out.println("-- testSupplement --");
		testSupplement.testGetNom();
		testSupplement.testGetPrix();
		testSupplement.testSetPrix();
		testSupplement.testConstructeurSupplement();
		
		//testSauvergardeFichier
		System.out.println("-- testSauvergardeFichier --");
		TestGestionBoissonAlcoolisee.testStockBoissonAlcoolisee();
		TestGestionBoissonNonAlcoolisee.testStockBoissonNonAlcoolisee();
		TestGestionCocktail.testStockCocktail();
		TestGestionSupplement.testStockSupplement();
		TestGestionClient.testStockClient();
        testCommande.testGetDateCommande();
        testCommande.testGetMapBoissonCommande();
        
        testCommande.testSetMapBoissonCommande();
	}

}
