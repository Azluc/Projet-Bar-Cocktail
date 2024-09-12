package com.cytech.testsUnitaires;

import java.util.ArrayList;

import java.util.List;

import com.cytech.gestionFichiers.GestionBoissonNonAlcoolisee;
import com.cytech.gestionFichiers.GestionListeBoissonNonAlcoolisee;
import com.cytech.ingredients.BoissonNonAlcoolisee;


public class TestGestionBoissonNonAlcoolisee {
	private static List<GestionListeBoissonNonAlcoolisee> listeBoissonNonAlcoolisee = new ArrayList<>();//tableau  qui va contenir la liste totale des BoissonNonAlcoolisees
	private static String fichierBoissonNonAlcoolisee = "resource/boissonNonAlcoolisee.json"; //chemin menant vers le fichier BoissonNonAlcoolisee

	public static void main(String[] args) {
		//testStockBoissonNonAlcoolisee();
		lectureStock();

	}
	public static void testStockBoissonNonAlcoolisee() {
		BoissonNonAlcoolisee boissonNonAlcoolisee = new BoissonNonAlcoolisee("Coca", 330.0,20.0,0.0,0.30,200.0);
		listeBoissonNonAlcoolisee = GestionBoissonNonAlcoolisee.lireJSON(fichierBoissonNonAlcoolisee);
    	

		ArrayList<BoissonNonAlcoolisee> infoBoissonNonAlcoolisee = new ArrayList<>(); //Variable qui va contenir les infos du BoissonNonAlcoolisee
		infoBoissonNonAlcoolisee.add(boissonNonAlcoolisee);
		GestionListeBoissonNonAlcoolisee donneesBoissonNonAlcoolisee = new GestionListeBoissonNonAlcoolisee(boissonNonAlcoolisee.getNom(),infoBoissonNonAlcoolisee);
		listeBoissonNonAlcoolisee.add(donneesBoissonNonAlcoolisee);  
        if(GestionBoissonNonAlcoolisee.EcrireJsonDirecte(fichierBoissonNonAlcoolisee, listeBoissonNonAlcoolisee, GestionListeBoissonNonAlcoolisee.class)) {
        	System.out.println("Sauvegarde de la boisson non alcoolisee dans le fichier boissonNonAlcoolisee.json réussi !");
        }
        else {
        	System.out.println("Sauvegarde de la boisson non alcoolisee dans le fichier boissonNonAlcoolisee.json échoué !");
        }
	}
	
	public static void lectureStock() {
		//exemple de parcours du json (pour une initialisation de l'interface. Ici, l'élément est a chercher dans une liste qui contient uniquement une boisson (d'ou le get first)
		listeBoissonNonAlcoolisee = GestionBoissonNonAlcoolisee.lireJSON(fichierBoissonNonAlcoolisee);
		for (GestionListeBoissonNonAlcoolisee el : listeBoissonNonAlcoolisee) {
			System.out.println(el.getlisteBoissonNonAlcoolisee().getFirst().getNom());
		}
	}
	
	
}
