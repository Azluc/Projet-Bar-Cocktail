package com.cytech.testsUnitaires;

import com.cytech.collections.*;
import com.cytech.ingredients.*;
import java.util.Date;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class testBarman {
    public static void main(String[] args) {  
        testConstructeurBarman();
        testGetMotDePasse();
        testSetMotDePasse();
        testGetId();

        testGetListeCocktail();
        testSetListeCocktail();
        testGetListeBoissonSimple();
        testSetListeBoissonSimple();
        testGetListeSupplement();
        testSetListeSupplement();
        testGetListeCommande();
        testSetListeCommande();
        
        testEncaisserCommande();
        testCreerCocktailBarman();
        testReapprovisionnerStockBoissonSimple();
        testReapprovisionnerStockSupplement();
        testVerifierStockBoissonSimple();
        testVerifierStockSupplement();
    }

    public static void testConstructeurBarman() {
       Barman barman = new Barman("589-156", "HbfsTY27!");
    
       if (barman.getId().equals("589-156") && barman.getMotDePasse().equals("HbfsTY27!")) {
            System.out.println("       : Test ConstructeurBarman de la classe Barman réussi.");
       } else {
            System.out.println("ERREUR : Test Constructeur de la classe Barman échoué.");
       }
    }

    public static void testGetMotDePasse() {
        Barman barman = new Barman("589-156", "HbfsTY27!");
        if (barman.getMotDePasse().equals("HbfsTY27!")) {
            System.out.println("       : Test GetMotDePasse de la classe Barman réussi.");
        } else {
            System.out.println("ERREUR : Test GetMotDePasse de la classe Barman échoué.");
        }
    }

    public static void testSetMotDePasse() {
        Barman barman = new Barman("589-156", "HbfsTY27!");
        barman.setMotDePasse("Llartu12?");
        if (barman.getMotDePasse().equals("Llartu12?")) {
            System.out.println("       : Test SetMotDePasse de la classe Barman réussi.");
        } else {
            System.out.println("ERREUR : Test SetMotDePasse de la classe Barman échoué.");
        }
    }

    public static void testGetId() {
        Barman barman = new Barman("589-156", "HbfsTY27!");
        if (barman.getId().equals("589-156")) {
            System.out.println("       : TestGetId de la classe Barman réussi.");
        } else {
            System.out.println("ERREUR : Test GetId de la classe Barman échoué.");
        }
    }

 
    
    
    
    



    public static void testGetListeCocktail() {
        Barman barman = new Barman("589-156", "HbfsTY27!");
        
        BoissonAlcoolisee rhum = new BoissonAlcoolisee("Rhum", 0.05, 25.0, 40.0, 0.0, 10.0);
        BoissonNonAlcoolisee jusOrange = new  BoissonNonAlcoolisee("Jus d'orange", 0.33, 1.0, 0.0, 0.0, 20.0);
        Supplement sucreCanne = new Supplement("Sucre de canne", 0.75, 2.0);

        Map<BoissonSimple, Double> mapBoisson = new HashMap<>();
        mapBoisson.put(rhum, 100.0);
        mapBoisson.put(jusOrange, 200.0);

        Map<Supplement, Double> mapSupplement = new HashMap<>();
        mapSupplement.put(sucreCanne, 20.0);

        Cocktail testCocktail = new Cocktail("Test Cocktail", mapBoisson, mapSupplement);

        ArrayList<Cocktail> listeCocktail = new ArrayList<>();
        listeCocktail.add(testCocktail);
        barman.setListeCocktail(listeCocktail);


        if (barman.getListeCocktail().equals(listeCocktail)) {
            System.out.println("       : Test GetListeCocktail de la classe Barman réussi.");
        } else {
            System.out.println("ERREUR : Test GetListeCocktail de la classe Barman échoué.");
        }
    }


    public static void testSetListeCocktail() {
        Barman barman = new Barman("589-156", "HbfsTY27!");
        ArrayList<Cocktail> listeCocktail = new ArrayList<>();

        BoissonAlcoolisee rhum = new  BoissonAlcoolisee("Rhum", 0.05, 25.0, 40.0, 0.0, 10.0);
        BoissonNonAlcoolisee jusOrange = new  BoissonNonAlcoolisee("Eau gazeuse", 0.33, 1.0, 0.0, 0.0, 20.0);
        Supplement sucreCanne = new Supplement("Sucre de canne",0.75, 2.0);

        Map<BoissonSimple, Double> mapBoisson = new HashMap<>();
        mapBoisson.put(rhum, 100.0);
        mapBoisson.put(jusOrange, 200.0);

        Map<Supplement, Double> mapSupplement = new HashMap<>();
        mapSupplement.put(sucreCanne, 20.0);

        Cocktail testCocktail = new Cocktail("Test Cocktail", mapBoisson, mapSupplement);

        listeCocktail.add(testCocktail);

        barman.setListeCocktail(listeCocktail);

        if (barman.getListeCocktail().equals(listeCocktail)) {
            System.out.println("       : Test SetListeCocktail de la classe Barman réussi.");
        } else {
            System.out.println("ERREUR : Test SetListeCocktail de la classe Barman échoué.");
        }
    }

    public static void testGetListeBoissonSimple() {
        Barman barman = new Barman("159-586", "HbfsTY27!");
        ArrayList<BoissonSimple> listeBoissonSimple = new ArrayList<>();
        BoissonNonAlcoolisee boissonsimple1 = new BoissonNonAlcoolisee("Coca-Cola", 1.5, 1.5, 0.0, 180.0, 30.0);
        BoissonNonAlcoolisee boissonsimple2 = new BoissonNonAlcoolisee("Jus de cranberry", 1.0, 4.9, 0.0, 100.0, 15.0);
        listeBoissonSimple.add(boissonsimple1);
        listeBoissonSimple.add(boissonsimple2);
        barman.setListeBoissonSimple(listeBoissonSimple);
        if (barman.getListeBoissonSimple().equals(listeBoissonSimple)) {
            System.out.println("       : Test GetListeBoissonSimple de la classe Barman réussi.");
        } else {
            System.out.println("ERREUR : Test GetListeBoissonSimple de la classe Barman réussi.");
        }
    }
    
    public static void testSetListeBoissonSimple() {
        Barman barman = new Barman("159-586", "HbfsTY27!");
        ArrayList<BoissonSimple> listeBoissonSimple = new ArrayList<>();
        BoissonNonAlcoolisee boissonsimple1 = new BoissonNonAlcoolisee("Coca-Cola", 1.5, 1.5, 0.0, 180.0, 30.0);
        BoissonNonAlcoolisee boissonsimple2 = new BoissonNonAlcoolisee("Jus de cranberry", 1.0, 4.9, 0.0, 100.0, 15.0);
        listeBoissonSimple.add(boissonsimple1);
        listeBoissonSimple.add(boissonsimple2);
        barman.setListeBoissonSimple(listeBoissonSimple);
        if (barman.getListeBoissonSimple().equals(listeBoissonSimple)) {
            System.out.println("       : Test SetListeBoissonSimple de la classe Barman réussi.");
        } else {
            System.out.println("ERREUR : Test SetListeBoissonSimple de la classe Barman échoué.");
        }
    }
    
    public static void testGetListeSupplement() {
        Barman barman = new Barman("589-156", "HbfsTY27!");
        ArrayList<Supplement> listeSupplement = new ArrayList<>();
        listeSupplement.add(new Supplement("Feuille de menthe", 0.5, 20.0));
        barman.setListeSupplement(listeSupplement);
        if (barman.getListeSupplement() == listeSupplement) {
            System.out.println("       : Test GetListeSupplement de la classe Barman réussi");
        } else {
            System.out.println("ERREUR : Test GetListeSupplement de la classe Barman échoué.");
        }
    }
    

    public static void testSetListeSupplement() {
        Barman barman = new Barman("589-156", "HbfsTY27!");
        ArrayList<Supplement> listeSupplement = new ArrayList<>();
        listeSupplement.add(new Supplement("Feuille de menthe", 0.5, 20.0));
        barman.setListeSupplement(listeSupplement);
        if (barman.getListeSupplement().equals(listeSupplement)) {
            System.out.println("       : Test SetListeSupplement de la classe Barman réussi.");
        } else {
            System.out.println("ERREUR : Test SetListeSupplement de la classe Barman échoué.");
        }
    }

    public static void testEncaisserCommande() {
    	BoissonAlcoolisee boisson1 = new BoissonAlcoolisee("Rhum", 0.05, 25.0, 40.0, 0.0, 10.0);
    	BoissonNonAlcoolisee boisson2 = new BoissonNonAlcoolisee("Eau gazeuse", 0.33, 1.0, 0.0, 0.0, 20.0);
        
        Map<Boisson, Double> mapBoisson = new HashMap<>();
        mapBoisson.put(boisson1, 1.0); // 1 litre de rhum
        mapBoisson.put(boisson2, 2.0); // 2 litre d'eau gazeuse

        Commande commande = new Commande(new Date(), 789-154, mapBoisson);
        
        Barman barman = new Barman("859-156", "HbfsTY27!");
        
        barman.getListeCommande().add(commande);
       
        if (barman.encaisserCommande(commande)) {
            System.out.println("       : Test EncaisserCommande de la classe Barman réussi.");
        } else {
            System.out.println("ERREUR : Test EncaisserCommande de la classe Barman échoué.");
        }
    }
    
    public static void testGetListeCommande() {
        Barman barman = new Barman("589-156", "HbfsTY27!");
        
     // Création de deux instances de BoissonSimple à inclure dans les commandes
        BoissonNonAlcoolisee boisson1 = new BoissonNonAlcoolisee("Fanta", 1.5, 1.95, 0.0, 167.0, 30.0);
        BoissonNonAlcoolisee boisson2 = new BoissonNonAlcoolisee("Sprite", 1.5, 2.13, 0.0, 60.0, 25.0);
        
        Map<Boisson, Double> mapBoissonCommande1 = new HashMap<>();
        mapBoissonCommande1.put(boisson1, 2.0);
        mapBoissonCommande1.put(boisson2, 4.0);
        
        Map<Boisson, Double> mapBoissonCommande2 = new HashMap<>();
        mapBoissonCommande2.put(boisson1, 1.0);
        mapBoissonCommande2.put(boisson2, 8.0);
        
        Commande commande1 = new Commande(new Date(), 123221,mapBoissonCommande1);
        Commande commande2 = new Commande(new Date(), 455454,mapBoissonCommande2);

        ArrayList<Commande> listeCommandes = new ArrayList<>();
        listeCommandes.add(commande1);
        listeCommandes.add(commande2);
        barman.setListeCommande(listeCommandes);

        if (barman.getListeCommande().equals(listeCommandes)) {
            System.out.println("       : Test GetListeCommande de la classe Barman réussi.");
        } else {
            System.out.println("ERREUR : Test GetListeCommande de la classe Barman échoué.");
        }
    }

    public static void testSetListeCommande() {
        Barman barman = new Barman("589-156", "HbfsTY27!");
        ArrayList<Commande> listeCommandes = new ArrayList<>();
        
        // Création de deux instances de BoissonSimple à inclure dans les commandes
        BoissonNonAlcoolisee boisson1 = new BoissonNonAlcoolisee("Fanta", 1.5, 1.95, 0.0, 167.0, 30.0);
        BoissonNonAlcoolisee boisson2 = new BoissonNonAlcoolisee("Sprite", 1.5, 2.13, 0.0, 60.0, 25.0);

        Map<Boisson, Double> mapBoissonCommande1 = new HashMap<>();
        mapBoissonCommande1.put(boisson1, 2.0);
        mapBoissonCommande1.put(boisson2, 4.0);
        
        Map<Boisson, Double> mapBoissonCommande2 = new HashMap<>();
        mapBoissonCommande2.put(boisson1, 1.0);
        mapBoissonCommande2.put(boisson2, 8.0);
        
        // Création de deux commandes contenant les boissons
        Commande commande1 = new Commande(new Date(), 123221,mapBoissonCommande1);
        listeCommandes.add(commande1);

        Commande commande2 = new Commande(new Date(), 455454,mapBoissonCommande2);
        listeCommandes.add(commande2);
        
        barman.setListeCommande(listeCommandes);

        if (barman.getListeCommande().equals(listeCommandes)) {
            System.out.println("       : Test SetListeCommande de la classe Barman réussi.");
        } else {
            System.out.println("ERREUR : Test SetListeCommande de la classe Barman échoué.");
        }
    }
    
   
    
    public static void testCreerCocktailBarman() {
        Barman barman = new Barman("589-156", "HbfsTY27!");

        // Création des boissons simples nécessaires au cocktail
        BoissonAlcoolisee vodka = new BoissonAlcoolisee("Vodka", 50, 3.0, 40.0, 0.0, 100);
        BoissonNonAlcoolisee jusOrange = new BoissonNonAlcoolisee("Jus d'orange", 100, 1.0, 0.0, 10.0, 200);

        // Création des suppléments nécessaires au cocktail
        Supplement zesteOrange = new Supplement("Zeste d'orange", 0.5, 50.0);
        Supplement grenadine = new Supplement("Grenadine", 0.3, 70.0);

        // Ajout des boissons simples et des suppléments à la liste correspondante du barman
        barman.getListeBoissonSimple().add(vodka);
        barman.getListeBoissonSimple().add(jusOrange);
        barman.getListeSupplement().add(zesteOrange);
        barman.getListeSupplement().add(grenadine);

        // Création du cocktail
        Map<BoissonSimple, Double> mapBoissons = new HashMap<>();
        mapBoissons.put(vodka, 0.5);
        mapBoissons.put(jusOrange, 1.0);

        Map<Supplement, Double> mapSupplements = new HashMap<>();
        mapSupplements.put(zesteOrange, 2.0);
        mapSupplements.put(grenadine, 1.0);

        // Appel de la méthode pour créer le cocktail
        Cocktail creationCocktail = barman.creerCocktailBarman("Sex on the Beach", mapBoissons, mapSupplements);
        
        // Vérification du résultat
        if (barman.getListeCocktail().size() == 1 ) {
            System.out.println("       : Test creerCocktailBarman de la classe Barman réussi (ajout de nouveau cocktail)");
        } else {
            System.out.println("ERREUR : Test creerCocktailBarman de la classe Barman échoué.");
        }
    }

    public static void testReapprovisionnerStockBoissonSimple() {
        Barman barman = new Barman("589-156", "HbfsTY27!");
        BoissonNonAlcoolisee boissonSimple = new BoissonNonAlcoolisee("Pepsi", 1.5, 1.09, 0.0, 150.0, 25.0);
        
        // Ajout explicite de la boisson à la liste
        barman.getListeBoissonSimple().add(boissonSimple);

        // Test du réapprovisionnement lorsque la boisson est déjà dans la liste
        barman.reapprovisionnerStock(boissonSimple, 20);
        if (boissonSimple.getQuantiteStock() == 45) { // 25 (quantité initiale) + 20 (réapprovisionnement)
            System.out.println("       : Test ReapprovisionnerStockBoissonSimple, quand la boisson est déjà dans la liste, réussi (mise à jour du stock existant) : Réussi");
        } else {
            System.out.println("ERREUR : Test ReapprovisionnerStockBoissonSimple (mise à jour du stock existant) : Échoué.");
        }

        // Test du réapprovisionnement lorsque la boisson n'est pas déjà dans la liste
        BoissonNonAlcoolisee nouvelleBoisson = new BoissonNonAlcoolisee("Coca-Cola", 1.5, 1.09, 0.0, 150.0, 25.0);
        barman.reapprovisionnerStock(nouvelleBoisson, 5);
        if (nouvelleBoisson.getQuantiteStock() == 5 && barman.getListeBoissonSimple().contains(nouvelleBoisson)) {
            System.out.println("       : Test ReapprovisionnerStockBoissonSimple, quand la boisson n'est pas déjà dans la liste, réussi (ajout de nouvelle boisson)");
        } else {
            System.out.println("ERREUR : Test ReapprovisionnerStockBoissonSimple échoué (ajout de nouvelle boisson).");
        }
    }


    public static void testReapprovisionnerStockSupplement() {
        Barman barman = new Barman("589-156", "HbfsTY27!");
        Supplement supplement = new Supplement("Zeste d'orange", 0.3, 20.0);

        barman.getListeSupplement().add(supplement);

        // Test du réapprovisionnement lorsque le supplément n'est pas déjà dans la liste
        barman.reapprovisionnerStock(supplement, 10);
        if (supplement.getQuantiteStock() == 30 && barman.getListeSupplement().contains(supplement)) {
            System.out.println("       : Test ReapprovisionnerStockSupplement de la classe Barman, quand le supplement n'est pas déjà dans la liste, réussi (ajout de nouveau supplément)");
        } else {
            System.out.println("ERREUR : Test ReapprovisionnerStockSupplement de la classe Barman échoué.");
        }

        // Test du réapprovisionnement lorsque le supplément est déjà dans la liste
        barman.reapprovisionnerStock(supplement, 10); // Réapprovisionnement supplémentaire de 10 unités
        if (supplement.getQuantiteStock() == 40) {
            System.out.println("       : Test ReapprovisionnerStockSupplement de la classe Barman, quand le supplement est déjà dans la liste, réussi (mise à jour du stock existant)");
        } else {
            System.out.println("ERREUR : Test ReapprovisionnerStockSupplement de la classe Barman échoué.");
        }
    }


    public static void testVerifierStockBoissonSimple() {
        Barman barman = new Barman("589-156", "HbfsTY27!");
        BoissonNonAlcoolisee boissonsimple = new BoissonNonAlcoolisee("Sprite", 1.5, 2.13, 0.0, 60.0, 25.0);
        barman.getListeBoissonSimple().add(boissonsimple);
        if (barman.verifierStock(boissonsimple, 7)) {
            System.out.println("       : Test VerifierStockBoissonSimple de la classe Barman réussi.");
        } else {
            System.out.println("ERREUR : Test VerifierStockBoissonSimple de la classe Barman échoué.");
        }
    }

    public static void testVerifierStockSupplement() {
        Barman barman = new Barman("589-156", "HbfsTY27!");
        Supplement supplement = new Supplement("Tranches de gingembre", 0.2, 30.0);
        barman.getListeSupplement().add(supplement);
        if (barman.verifierStock(supplement, 15)) {
            System.out.println("       : Test VerifierStockSupplement de la classe Barman réussi.");
        } else {
            System.out.println("ERREUR : Test VerifierStockSupplement de la classe Barman échoué.");
        }
    }
   
}