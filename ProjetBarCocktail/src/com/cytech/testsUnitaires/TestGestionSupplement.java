package com.cytech.testsUnitaires;

import java.util.ArrayList;

import java.util.List;

import com.cytech.ingredients.Supplement;
import com.cytech.gestionFichiers.GestionSupplement;
import com.cytech.gestionFichiers.GestionListeSupplement;


public class TestGestionSupplement {
	private static List<GestionListeSupplement> listeSupplement = new ArrayList<>(); //tableau  qui va contenir la liste totale des Supplements
	private static String fichierSupplement = "resource/supplement.json"; //chemin menant vers le fichier Supplement
	
	public static void main(String[] args) {
		testStockSupplement();
	}
	public static void testStockSupplement() {
		Supplement supplement = new Supplement("Basilic", 36.0,20.0);
		listeSupplement = GestionSupplement.lireJSON(fichierSupplement);
    
		ArrayList<Supplement> infosupplement = new ArrayList<>(); //Variable qui va contenir les infos du Supplement
		infosupplement.add(supplement);
		GestionListeSupplement donneessupplement = new GestionListeSupplement(supplement.getNom(),infosupplement);
		listeSupplement.add(donneessupplement);  
        if(GestionSupplement.EcrireJsonDirecte(fichierSupplement, listeSupplement, GestionListeSupplement.class)) {
        	System.out.println("Sauvegarde du supplément dans le fichier supplement.json réussi !");
        }
        else {
        	System.out.println("Sauvegarde du supplément dans le fichier supplement.json échoué !");
        }
	}
}
