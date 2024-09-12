package com.cytech.testsUnitaires;

import com.cytech.ingredients.BoissonAlcoolisee;
import com.cytech.ingredients.BoissonNonAlcoolisee;

public class testBoisson {

    public static void main(String[] args) {
        testGetNom();
        testGetContenance();
        testGetPrix();
        testGetDegreAlcool();
        testGetDegreSucre();
        testSetContenance();
        testSetPrix();
        testEstAlcoolisee();
    }
    
    public static void testGetNom() {
    	BoissonNonAlcoolisee boisson = new BoissonNonAlcoolisee("Pepsi", 1.5, 1.09, 0.0,10.0, 150.0);
        if (boisson.getNom().equals("Pepsi")) {
            System.out.println("       : Test GetNom de la classe Boisson réussi.");
        } else {
            System.out.println("ERREUR : Test GetNom de la classe Boisson échoué.");
        }
    }
   
    public static void testGetContenance() {
    	BoissonNonAlcoolisee boisson = new BoissonNonAlcoolisee("Fanta", 1.5, 1.95,0.0, 8.0, 167.0);
        if (boisson.getContenance() == 1.5) {
            System.out.println("       : Test GetContenance de la classe Boisson réussi.");
        } else {
            System.out.println("ERREUR : Test GetContenance de la classe Boisson échoué.");
        }
    }
    public static void testGetPrix() {
    	BoissonNonAlcoolisee boisson = new BoissonNonAlcoolisee("Sprite", 1.5, 2.13, 0.0,10.0, 60.0);
        if (boisson.getPrix() == 2.13) {
            System.out.println("       : Test GetPrix de la classe Boisson réussi.");
        } else {
            System.out.println("ERREUR : Test GetPrix de la classe Boisson échoué.");
        }
    }  
    
    public static void testGetDegreAlcool() {
    	BoissonAlcoolisee boissonAlcoolisee = new BoissonAlcoolisee("Whisky", 0.75, 55.0, 40.0, 0.0, 12.0);
    	BoissonNonAlcoolisee boissonNonAlcoolisee = new BoissonNonAlcoolisee("Limonade", 0.33, 1.0, 0.0, 12.0,55.0);

        double degreAlcoolAlcoolisee = boissonAlcoolisee.getDegreAlcool();
        double degreAlcoolNonAlcoolisee = boissonNonAlcoolisee.getDegreAlcool();

        if (degreAlcoolAlcoolisee == 40.0 && degreAlcoolNonAlcoolisee == 0.0) {
            System.out.println("       : Test GetDegreAlcool de la classe Boisson réussi.");
        } else {
            System.out.println("ERREUR : Test GetDegreAlcool de la classe Boisson échoué.");
        }
    }
    
    public static void testGetDegreSucre() {
    	BoissonNonAlcoolisee boisson = new BoissonNonAlcoolisee("Orangina", 1.5, 1.7, 0.0, 15.0,150.0);

        if (boisson.getDegreSucre() == 15.0) {
            System.out.println("       : Test GetDegreSucre de la classe Boisson réussi.");
        } else {
            System.out.println("ERREUR : Test GetDegreSucre de la classe Boisson échoué.");
        }
    }
    
    public static void testSetContenance() {
    	BoissonNonAlcoolisee boisson = new BoissonNonAlcoolisee("Fanta", 1.5, 1.95,0.0, 8.0, 167.0);
        boisson.setContenance(0.75);
        if (boisson.getContenance() == 0.75) {
            System.out.println("       : Test SetContenance de la classe Boisson réussi.");
        } else {
            System.out.println("ERREUR : Test SetContenance de la classe Boisson échoué.");
        }
    } 
    
    public static void testSetPrix() {
    	BoissonNonAlcoolisee boisson = new BoissonNonAlcoolisee("Sprite", 1.5, 2.13, 0.0,10.0, 60.0);
        boisson.setPrix(1.0);
        if (boisson.getPrix() == 1.0) {
            System.out.println("       : Test SetPrix de la classe Boisson réussi.");
        } else {
            System.out.println("ERREUR : Test SetPrix de la classe Boisson échoué.");
        }
    }
    

    public static boolean testEstAlcoolisee() {
    	BoissonAlcoolisee boissonAlcoolisee = new BoissonAlcoolisee("Whisky", 0.75, 55.0, 40.0, 0.0, 12.0);
    	BoissonNonAlcoolisee boissonNonAlcoolisee = new BoissonNonAlcoolisee("Limonade", 0.33, 1.0, 0.0, 12.0,55.0);

        boolean resultatBAlcoolisee = boissonAlcoolisee.estAlcoolisee();
        boolean resultatBNonAlcoolisee = boissonNonAlcoolisee.estAlcoolisee();

        if (resultatBAlcoolisee && !resultatBNonAlcoolisee) {
            System.out.println("       : Test EstAlcolisee de la classe Boisson réussi.");
            return true; 
        } else {
            System.out.println("ERREUR : Test EstAlcolisee de la classe Boisson échoué.");
            return false;
        }
    }
      
}
