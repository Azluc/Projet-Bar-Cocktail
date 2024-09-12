package com.cytech.testsUnitaires;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.cytech.ingredients.Boisson;
import com.cytech.collections.Commande;


public class testCommande {

    public static void testGetDateCommande() {
    	
    	// Création d'une commande
        Date dateCommande = new Date();
        Commande commande = new Commande(dateCommande, 1, new HashMap<>());
        
        // Teste de la méthode GetDateCommande
        if (commande.getDateCommande().equals(dateCommande)) {
            System.out.println("	: Test getDateCommande réussi.");
        } else {
            System.out.println("ERREUR : Test getDateCommande !");
        }
    }

    public static void testGetNumeroCommande() {
    	
    	// Création d'une commande
        Date dateCommande = new Date();
        Commande commande = new Commande(dateCommande, 1, new HashMap<>());
        if (commande.getNumeroCommande() == 1) {
            System.out.println("	: Test getNumeroCommande réussi.");
        } else {
            System.out.println("ERREUR : Test getNumeroCommande !");
        }
    }

    public static void testGetMapBoissonCommande() {

    	// Création d'une commande et d'une map commande de boisson 
        Map<Boisson, Double> mapBoissonCommande = new HashMap<>();
        Commande commande = new Commande(new Date(), 1, mapBoissonCommande);
        
        // Teste de la méthode GetMapBoissonCommande
        if (commande.getMapBoissonCommande() == mapBoissonCommande) {
            System.out.println("	: Test getMapBoissonCommande réussi.");
        } else {
            System.out.println("ERREUR : Test getMapBoissonCommande !");
        }
    }

    public static void testSetMapBoissonCommande() {
    	
    	// Création d'une commande et d'une map commande de boisson 
        Map<Boisson, Double> mapBoissonCommande = new HashMap<>();
        Commande commande = new Commande(new Date(), 1, new HashMap<>());
        
        // Modification de la commande
        commande.setMapBoissonCommande(mapBoissonCommande);
        
        // Teste de la méthode SetMapBoissonCommande
        if (commande.getMapBoissonCommande() == mapBoissonCommande) {
            System.out.println("	: Test setMapBoissonCommande réussi.");
        } else {
            System.out.println("ERREUR : Test setMapBoissonCommande !");
        }
    }

    
}