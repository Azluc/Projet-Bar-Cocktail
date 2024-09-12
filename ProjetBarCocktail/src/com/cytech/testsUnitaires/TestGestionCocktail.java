package com.cytech.testsUnitaires;

 
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.cytech.gestionFichiers.GestionBoissonNonAlcoolisee;
import com.cytech.gestionFichiers.GestionCocktail;
import com.cytech.gestionFichiers.GestionListeCocktail;
import com.cytech.ingredients.BoissonAlcoolisee;
import com.cytech.ingredients.BoissonNonAlcoolisee;


public class TestGestionCocktail {
	private static List<GestionListeCocktail> listeCocktail = new ArrayList<>();//tableau  qui va contenir la liste totale des BoissonNonAlcoolisees
	private static String fichierCocktail = "resource/cocktail.json"; //chemin menant vers le fichier BoissonNonAlcoolisee

	
    public static void main(String[] args) {
    	testStockCocktail();
    }
    public static void testStockCocktail() {
    	listeCocktail = GestionCocktail.lireJSON(fichierCocktail);
    	
        Map<String, Double> mapBoisson = new HashMap<>();
        BoissonAlcoolisee boisson1 = new BoissonAlcoolisee("Rhum", 0.05, 25.0, 40.0, 0.0, 10.0);
        BoissonNonAlcoolisee boisson2 = new BoissonNonAlcoolisee("Eau gazeuse", 0.33, 1.0, 0.0, 0.0, 20.0);
        BoissonNonAlcoolisee boisson3 = new BoissonNonAlcoolisee("orange", 0.1, 0.5, 0.0, 5.0, 5.0);
        
       
        
        mapBoisson.put(boisson1.getNom(), 0.05); // 0.05 litre de rhum
        mapBoisson.put(boisson2.getNom(), 0.15); // 0.15 litre d'eau gazeuse
        mapBoisson.put(boisson3.getNom(), 0.1);  // 0.1 litre de citron vert
		
        Map<String, Double> mapSupplement = new HashMap<>();
        mapSupplement.put("Feuille de menthe", 6.0); // 6 feuilles de menthe
        GestionListeCocktail donneesCocktail = new GestionListeCocktail("Mojito", mapBoisson, mapSupplement);
        
		listeCocktail.add(donneesCocktail); 
        if(GestionBoissonNonAlcoolisee.EcrireJsonDirecte(fichierCocktail, listeCocktail, GestionListeCocktail.class)) {
        	System.out.println("Sauvegarde du cocktail dans le fichier cocktail.json réussi !");
        }
        else {
        	System.out.println("Sauvegarde du cocktail dans le fichier cocktail.json échoué !");
        }
    }
}
