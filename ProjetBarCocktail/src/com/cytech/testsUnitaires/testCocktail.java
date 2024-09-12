package com.cytech.testsUnitaires;

import com.cytech.ingredients.BoissonAlcoolisee;
import com.cytech.ingredients.BoissonNonAlcoolisee;
import com.cytech.ingredients.BoissonSimple;
import com.cytech.ingredients.Cocktail;
import com.cytech.ingredients.Supplement;

import java.util.HashMap;
import java.util.Map;

public class testCocktail {
    public static void main(String[] args) {
        testConstructeurCocktail();
        testSetMapBoisson();
        testGetMapBoisson();
        testGetMapSupplement();
        testSetMapSupplement();
        testCalculerPrix();
        testCalculerContenance();
        testCalculerDegreAlcool();
        testCalculerSucre();
        testAjouterBoissonAlcoolisee();
        testAjouterBoissonNonAlcoolisee();
        testAjouterSupplement();
        testSupprimerBoissonNonAlcoolisee();
        testSupprimerBoissonAlcoolisee();
        testSupprimerSupplement();
    }
    
    public static double epsilon = 0.00001;

    public static void testConstructeurCocktail() {
        Map<BoissonSimple, Double> mapBoisson = new HashMap<>();
        BoissonAlcoolisee boisson1 = new BoissonAlcoolisee("Rhum", 0.05, 25.0, 40.0, 0.0, 10.0);
        BoissonNonAlcoolisee boisson2 = new BoissonNonAlcoolisee("Eau gazeuse", 0.33, 1.0, 0.0, 0.0, 20.0);
        BoissonNonAlcoolisee boisson3 = new BoissonNonAlcoolisee("Citron vert", 0.1, 0.5, 0.0, 5.0, 5.0);

        mapBoisson.put(boisson1, 0.05); // 0.05 litre de rhum
        mapBoisson.put(boisson2, 0.15); // 0.15 litre d'eau gazeuse
        mapBoisson.put(boisson3, 0.1);  // 0.1 litre de citron vert

        Map<Supplement, Double> mapSupplement = new HashMap<>();
        Supplement feuilleMenthe = new Supplement("Feuille de menthe", 0.5, 20.0); // Prix et quantité de feuilles de menthe
        mapSupplement.put(feuilleMenthe, 6.0); // 6 feuilles de menthe

        Cocktail cocktail = new Cocktail("Mojito", mapBoisson, mapSupplement);

        if (cocktail.getNom().equals("Mojito") && cocktail.getMapBoisson().equals(mapBoisson)
                && cocktail.getMapSupplement().equals(mapSupplement) && cocktail.getPrix() == cocktail.calculerPrix()
                && cocktail.getContenance() == cocktail.calculerContenance()
                && cocktail.getDegreAlcool() == cocktail.calculerDegreAlcool()
                && cocktail.getDegreSucre() == cocktail.calculerSucre()) {
            System.out.println("       : Test Constructeur de la classe Cocktail réussi.");
        } else {
            System.out.println("ERREUR : Test Constructeur de la classe Cocktail echoué.");
        }
    }
    
    public static void testSetMapBoisson() {
        Cocktail cocktail = new Cocktail("Test Cocktail", new HashMap<>(), new HashMap<>());

        Map<BoissonSimple, Double> newMapBoisson = new HashMap<>();
        BoissonAlcoolisee newBoisson = new BoissonAlcoolisee("Martini", 0.05, 15.0, 30.0, 0.0, 5.0);
        newMapBoisson.put(newBoisson, 0.25);

        cocktail.setMapBoisson(newMapBoisson);

        if (cocktail.getMapBoisson().equals(newMapBoisson)) {
            System.out.println("       : Test SetMapBoisson de la classe Cocktail réussi.");
        } else {
            System.out.println("ERREUR : Test SetMapBoisson de la classe Cocktail échoué.");
        }
    }
    
    public static void testGetMapBoisson() {
        Map<BoissonSimple, Double> mapBoisson = new HashMap<>();
        BoissonNonAlcoolisee boisson = new BoissonNonAlcoolisee("Jus d'orange", 0.2, 20.0, 40.0, 5.0, 20.0);
        mapBoisson.put(boisson, 0.5);
        Cocktail cocktail = new Cocktail("Test Cocktail", mapBoisson, new HashMap<>());

        if (cocktail.getMapBoisson().equals(mapBoisson)) {
            System.out.println("       : Test GetMapBoisson de la classe Cocktail réussi.");
        } else {
            System.out.println("ERREUR : Test GetMapBoisson de la classe Cocktail échoué.");
        }
    }

    public static void testSetMapSupplement() {
        Cocktail cocktail = new Cocktail("Test Cocktail", new HashMap<>(), new HashMap<>());

        Map<Supplement, Double> newMapSupplement = new HashMap<>();
        Supplement newSupplement = new Supplement("Tranche de concombre", 0.1, 5.0);
        newMapSupplement.put(newSupplement, 10.0);

        cocktail.setMapSupplement(newMapSupplement);

        if (cocktail.getMapSupplement().equals(newMapSupplement)) {
            System.out.println("       : Test SetMapSupplement de la classe Cocktail réussi.");
        } else {
            System.out.println("ERREUR : Test SetMapSupplement de la classe Cocktail échoué.");
        }
    }
    public static void testGetMapSupplement() {
        Map<Supplement, Double> mapSupplement = new HashMap<>();
        Supplement supplement = new Supplement("Glaçons", 0.4, 5.0);
        mapSupplement.put(supplement, 20.0);
        Cocktail cocktail = new Cocktail("Test Cocktail", new HashMap<>(), mapSupplement);

        if (cocktail.getMapSupplement().equals(mapSupplement)) {
            System.out.println("       : Test GetMapSupplement de la classe Cocktail réussi.");
        } else {
            System.out.println("ERREUR : Test GetMapSupplement de la classe Cocktail échoué.");
        }
    }
    
    public static void testCalculerPrix() {

    	BoissonAlcoolisee boisson1 = new BoissonAlcoolisee("Rhum", 0.05, 25.0, 40.0, 0.0, 10.0);
    	BoissonNonAlcoolisee boisson2 = new BoissonNonAlcoolisee("Eau gazeuse", 0.33, 1.0, 0.0, 0.0, 20.0);
    	BoissonNonAlcoolisee boisson3 = new BoissonNonAlcoolisee("Citron vert", 0.1, 0.5, 0.0, 5.0, 5.0);

    Map<BoissonSimple, Double> mapBoisson = new HashMap<>();
    mapBoisson.put(boisson1, 0.05); // 0.05 litre de rhum
    mapBoisson.put(boisson2, 0.15); // 0.15 litre d'eau gazeuse
    mapBoisson.put(boisson3, 0.1);  // 0.1 litre de citron vert
    
    
    Supplement feuilleDeMenthe = new Supplement("Feuille de menthe",0.75, 10.0);
    Map<Supplement, Double> mapSupplement = new HashMap<>();
    mapSupplement.put(feuilleDeMenthe, 5.0);

    Cocktail cocktail = new Cocktail("Test Cocktail", mapBoisson, mapSupplement);

    double prixTotal = cocktail.calculerPrix();

    double prixAttendu = (((25.0 * 0.05 / 0.05) + 
                          (1.0 * 0.15 / 0.33) +
                          (0.5 * 0.1 / 0.1) +
                          (0.75 * 5.0)) * 1.1);

    if (prixTotal - prixAttendu < epsilon) {
        System.out.println("        : Test CalculerPrix de la classe Cocktail réussi.");
    } else {
        System.out.println("ERREUR : Test CalculerPrix de la classe Cockail échoué.");
    }
}
    public static void testCalculerContenance() {
        Map<BoissonSimple, Double> mapBoisson = new HashMap<>();
        BoissonAlcoolisee boisson1 = new BoissonAlcoolisee("Rhum", 0.05, 25.0, 40.0, 0.0, 10.0);
        BoissonNonAlcoolisee boisson2 = new BoissonNonAlcoolisee("Eau gazeuse", 0.33, 1.0, 0.0, 0.0, 20.0);
        BoissonNonAlcoolisee boisson3 = new BoissonNonAlcoolisee("Citron vert", 0.1, 0.5, 0.0, 5.0, 5.0);

        mapBoisson.put(boisson1, 0.05); // 0.05 litre de rhum
        mapBoisson.put(boisson2, 0.15); // 0.15 litre d'eau gazeuse
        mapBoisson.put(boisson3, 0.1);  // 0.1 litre de citron vert

        Cocktail cocktail = new Cocktail("Test Cocktail", mapBoisson, new HashMap<>());

        double contenanceAttendue = 0.05 + 0.15 + 0.1; // Somme des quantités de chaque boisson

        if (cocktail.calculerContenance() - contenanceAttendue < epsilon) {
            System.out.println("       : Test CalculerContenance de la classe Cocktail réussi.");
        } else {
            System.out.println("ERREUR : Test CalculerContenance de la classe Cocktail échoué.");
        }
    }

    public static void testCalculerDegreAlcool() {
        Map<BoissonSimple, Double> mapBoisson = new HashMap<>();
        BoissonAlcoolisee boisson1 = new BoissonAlcoolisee("Rhum", 0.05, 25.0, 40.0, 0.0, 10.0);
        BoissonNonAlcoolisee boisson2 = new BoissonNonAlcoolisee("Eau gazeuse", 0.33, 1.0, 0.0, 0.0, 20.0);
        BoissonNonAlcoolisee boisson3 = new BoissonNonAlcoolisee("Citron vert", 0.1, 0.5, 0.0, 5.0, 5.0);

        mapBoisson.put(boisson1, 0.05); // 0.05 litre de rhum
        mapBoisson.put(boisson2, 0.15); // 0.15 litre d'eau gazeuse
        mapBoisson.put(boisson3, 0.1);  // 0.1 litre de citron vert

        Cocktail cocktail = new Cocktail("Test Cocktail", mapBoisson, null);
        
        double sommeDegreAlcool = 40.0 * 0.05 + 0.0 * 0.15 + 0.0 * 0.1;
        double volume = 0.05 + 0.15 + 0.1;

        double degreAlcoolAttendu = sommeDegreAlcool/volume; // Somme pondérée des degrés d'alcool
  
        if (cocktail.calculerDegreAlcool() - degreAlcoolAttendu < epsilon) {
            System.out.println("       : Test CalculerDegreAlcool de la classe Cocktail réussi.");
        } else {
        	
            System.out.println("ERREUR : Test CalculerDegreAlcool de la classe Cocktail échoué.");
        }
    }
    
    public static void testCalculerSucre() {
    	Map<BoissonSimple, Double> mapBoisson = new HashMap<>();
    	BoissonAlcoolisee boisson1 = new BoissonAlcoolisee("Rhum", 0.05, 25.0, 40.0, 0.0, 10.0);
        BoissonNonAlcoolisee boisson2 = new BoissonNonAlcoolisee("Eau gazeuse", 0.33, 1.0, 0.0, 0.0, 20.0);
        BoissonNonAlcoolisee boisson3 = new BoissonNonAlcoolisee("Citron vert", 0.1, 0.5, 0.0, 5.0, 5.0);

        mapBoisson.put(boisson1, 0.05); // 0.05 litre de rhum
        mapBoisson.put(boisson2, 0.15); // 0.15 litre d'eau gazeuse
        mapBoisson.put(boisson3, 0.1);  // 0.1 litre de citron vert

        Cocktail cocktail = new Cocktail("Test Cocktail", mapBoisson, new HashMap<>());

        double sucreAttendu = ((0.0 * 0.05) + (0.0 * 0.15) + (5.0 * 0.1)) / (0.05 + 0.15 + 0.1); // Somme pondérée des taux de sucre

        if (cocktail.calculerSucre() - sucreAttendu < epsilon) {
            System.out.println("       : Test CalculerSucre de la classe Cocktail réussi.");
        } else {
            System.out.println("ERREUR : Test CalculerSucre de la classe Cocktail échoué.");
        }
    }
    
    public static void testAjouterBoissonNonAlcoolisee() {
    	Map<BoissonSimple, Double> mapBoisson = new HashMap<>();
        BoissonAlcoolisee boisson1 = new BoissonAlcoolisee("Rhum", 0.05, 25.0, 40.0, 0.0, 10.0);
        BoissonNonAlcoolisee boisson2 = new BoissonNonAlcoolisee("Eau gazeuse", 0.33, 1.0, 0.0, 0.0, 20.0);
        

        mapBoisson.put(boisson1, 0.05); // 0.05 litre de rhum
        mapBoisson.put(boisson2, 0.15); // 0.15 litre d'eau gazeuse
        

        Cocktail cocktail = new Cocktail("Test Cocktail", mapBoisson, new HashMap<>());
        BoissonNonAlcoolisee boisson3 = new BoissonNonAlcoolisee("Citron vert", 0.1, 0.5, 0.0, 5.0, 5.0);
        
        
        
        if (cocktail.ajouterBoissonNonAlcoolisee(boisson3, 0.1)) {
            System.out.println("       : Test AjouterBoissonNonAlcoolisee de la classe Cocktail réussi.");
        } else {
            System.out.println("ERREUR : Test AjouterBoissonNonAlcoolisee de la classe Cocktail échoué.");
        }
    }
    
    public static void testAjouterBoissonAlcoolisee() {
    	Map<BoissonSimple, Double> mapBoisson = new HashMap<>();
    	
        BoissonAlcoolisee boisson1 = new BoissonAlcoolisee("Rhum", 0.05, 25.0, 40.0, 0.0, 10.0);
        BoissonNonAlcoolisee boisson2 = new BoissonNonAlcoolisee("Eau gazeuse", 0.33, 1.0, 0.0, 0.0, 20.0);
        BoissonNonAlcoolisee boisson3 = new BoissonNonAlcoolisee("Citron vert", 0.1, 0.5, 0.0, 5.0, 5.0);

        mapBoisson.put(boisson3, 0.1); // 0.05 litre de rhum
        mapBoisson.put(boisson2, 0.15); // 0.15 litre d'eau gazeuse
        
        Cocktail cocktail = new Cocktail("Test Cocktail", mapBoisson, new HashMap<>());
        
        if (cocktail.ajouterBoissonAlcoolisee(boisson1, 0.05)) {
            System.out.println("       : Test AjouterBoissonAlcoolisee de la classe Cocktail réussi.");
        } else {
            System.out.println("ERREUR : Test AjouterBoissonAlcoolisee de la classe Cocktail échoué.");
        }
    }
    
    public static void testSupprimerBoissonNonAlcoolisee() {
    	Map<BoissonSimple, Double> mapBoisson = new HashMap<>();
    	
        BoissonAlcoolisee boisson1 = new BoissonAlcoolisee("Rhum", 0.05, 25.0, 40.0, 0.0, 10.0);
        BoissonNonAlcoolisee boisson2 = new BoissonNonAlcoolisee("Eau gazeuse", 0.33, 1.0, 0.0, 0.0, 20.0);
        BoissonNonAlcoolisee boisson3 = new BoissonNonAlcoolisee("Citron vert", 0.1, 0.5, 0.0, 5.0, 5.0);
        
        mapBoisson.put(boisson1, 0.05); // 0.05 litre de rhum
        mapBoisson.put(boisson2, 0.15); // 0.15 litre d'eau gazeuse
        mapBoisson.put(boisson3, 0.1); // 0.1 litre de citron vert
        
        Cocktail cocktail = new Cocktail("Test Cocktail", mapBoisson, new HashMap<>());

        if (cocktail.supprimerBoissonNonAlcoolisee(boisson3, 0.1)) {
            System.out.println("       : Test SupprimerBoissonNonAlcoolisee de la classe Cocktail réussi.");
        } else {
            System.out.println("ERREUR : Test SupprimerBoissonNonAlcoolisee de la classe Cocktail échoué.");
        }
    }
    
    public static void testSupprimerBoissonAlcoolisee() {
    	Map<BoissonSimple, Double> mapBoisson = new HashMap<>();
    	
        BoissonAlcoolisee boisson1 = new BoissonAlcoolisee("Rhum", 0.05, 25.0, 40.0, 0.0, 10.0);
        BoissonNonAlcoolisee boisson2 = new BoissonNonAlcoolisee("Eau gazeuse", 0.33, 1.0, 0.0, 0.0, 20.0);
        BoissonNonAlcoolisee boisson3 = new BoissonNonAlcoolisee("Citron vert", 0.1, 0.5, 0.0, 5.0, 5.0);
        
        mapBoisson.put(boisson1, 0.05); // 0.05 litre de rhum
        mapBoisson.put(boisson2, 0.15); // 0.15 litre d'eau gazeuse
        mapBoisson.put(boisson3, 0.1); // 0.1 litre de citron vert

        Cocktail cocktail = new Cocktail("Test Cocktail", mapBoisson, new HashMap<>());
        
        if (cocktail.supprimerBoissonAlcoolisee(boisson1, 0.05)) {
            System.out.println("       : Test SupprimerBoissonAlcoolisee de la classe Cocktail réussi.");
        } else {
            System.out.println("ERREUR : Test SupprimerBoissonAlcoolisee de la classe Cocktail échoué.");
        }
    }
    
    
    public static void testAjouterSupplement() {
    	BoissonAlcoolisee boisson1 = new BoissonAlcoolisee("Rhum", 0.05, 25.0, 40.0, 0.0, 10.0);
    	BoissonNonAlcoolisee boisson2 = new BoissonNonAlcoolisee("Eau gazeuse", 0.33, 1.0, 0.0, 0.0, 20.0);
    	BoissonNonAlcoolisee boisson3 = new BoissonNonAlcoolisee("Citron vert", 0.1, 0.5, 0.0, 5.0, 5.0);

    	Map<BoissonSimple, Double> mapBoisson = new HashMap<>();
    	mapBoisson.put(boisson1, 0.05); // 0.05 litre de rhum
    	mapBoisson.put(boisson2, 0.15); // 0.15 litre d'eau gazeuse
    	mapBoisson.put(boisson3, 0.1);  // 0.1 litre de citron vert
    	
    	Cocktail cocktail = new Cocktail("Test Cocktail", mapBoisson, new HashMap<>());

    	Supplement feuilleDeMenthe = new Supplement("Feuille de menthe",0.75, 10.0);
    	
    	if (cocktail.ajouterSupplement(feuilleDeMenthe, 2)) {
            System.out.println("       : Test AjouterSupplement de la classe Cocktail réussi.");
        } else {
            System.out.println("ERREUR : Test AjouterSupplement de la classe Cocktail échoué.");
        }
    }
    
    public static void testSupprimerSupplement() {
    	BoissonAlcoolisee boisson1 = new BoissonAlcoolisee("Rhum", 0.05, 25.0, 40.0, 0.0, 10.0);
    	BoissonNonAlcoolisee boisson2 = new BoissonNonAlcoolisee("Eau gazeuse", 0.33, 1.0, 0.0, 0.0, 20.0);
    	BoissonNonAlcoolisee boisson3 = new BoissonNonAlcoolisee("Citron vert", 0.1, 0.5, 0.0, 5.0, 5.0);

    	Map<BoissonSimple, Double> mapBoisson = new HashMap<>();
    	mapBoisson.put(boisson1, 0.05); // 0.05 litre de rhum
    	mapBoisson.put(boisson2, 0.15); // 0.15 litre d'eau gazeuse
    	mapBoisson.put(boisson3, 0.1);  // 0.1 litre de citron vert
    	
    	Map<Supplement, Double> mapSupplement = new HashMap<>();
    	Supplement feuilleDeMenthe = new Supplement("Feuille de menthe",0.75, 10.0);
    	mapSupplement.put(feuilleDeMenthe, 2.0);
 
    	Cocktail cocktail = new Cocktail("Test Cocktail", mapBoisson,mapSupplement);

    	
    	if (cocktail.supprimerSupplement(feuilleDeMenthe, 1.0)) {
            System.out.println("       : Test SupprimerSupplement de la classe Cocktail réussi.");
        } else {
            System.out.println("ERREUR : Test SupprimerSupplement de la classe Cocktail échoué.");
        }
    }
}
    