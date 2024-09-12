package com.cytech.testsUnitaires;

import java.util.ArrayList;

import java.util.List;

import com.cytech.gestionFichiers.GestionBoissonAlcoolisee;
import com.cytech.gestionFichiers.GestionListeBoissonAlcoolisee;
 
import com.cytech.ingredients.BoissonAlcoolisee;


public class TestGestionBoissonAlcoolisee {
	private static List<GestionListeBoissonAlcoolisee> listeBoissonAlcoolisee = new ArrayList<>();//tableau  qui va contenir la liste totale des BoissonAlcoolisees
	private static String fichierBoissonAlcoolisee = "resource/boissonAlcoolisee.json"; //chemin menant vers le fichier BoissonAlcoolisee

	public static void main(String[] args) {
		testStockBoissonAlcoolisee();
	}
	public static void testStockBoissonAlcoolisee() {
		BoissonAlcoolisee boissonAlcoolisee = new BoissonAlcoolisee("Merde en boite", 550.0,10.0,0.75,0.30,200.0);
 
        if(GestionBoissonAlcoolisee.ecritureBoissonAlcoolisee(boissonAlcoolisee)) {
        	System.out.println("Sauvergarde de la boisson alcoolisee dans le fichier boissonAlcoolisee.json réussi !");
        }
        else {
        	System.out.println("Sauvergarde de la boisson alcoolisee dans le fichier boissonAlcoolisee.json échoué !");
        }
	}
}
