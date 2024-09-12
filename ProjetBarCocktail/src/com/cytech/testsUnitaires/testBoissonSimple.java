package com.cytech.testsUnitaires;

import com.cytech.ingredients.BoissonNonAlcoolisee;

public class testBoissonSimple {

    public static void main(String[] args) {
        testSetQuantiteStock();
        testGetQuantiteStock();
    }

    public static void testSetQuantiteStock() {
    	BoissonNonAlcoolisee boisson1 = new BoissonNonAlcoolisee("Coca-Cola", 1.5, 1.5, 0.0, 180.0, 30.0);
    	BoissonNonAlcoolisee boisson2 = new BoissonNonAlcoolisee("Pepsi", 1.5, 1.09, 0.0, 150.0, 25.0);

        boisson1.setQuantiteStock(50.0);
        boisson2.setQuantiteStock(40.0);

        if (boisson1.getQuantiteStock() == 50.0 && boisson2.getQuantiteStock() == 40.0) {
            System.out.println("       : Test SetQuantiteStock de la classe BoissonSimple réussi.");
        } else {
            System.out.println("ERREUR : Test SetQuantiteStock de la classe BoissonSimple échoué.");
        }
    }

    public static void testGetQuantiteStock() {
    	BoissonNonAlcoolisee boisson1 = new BoissonNonAlcoolisee("Fanta", 1.5, 1.95, 0.0, 167.0, 30.0);
    	BoissonNonAlcoolisee boisson2 = new BoissonNonAlcoolisee("Sprite", 1.5, 2.13, 0.0, 60.0, 25.0);

        if (boisson1.getQuantiteStock() == 30.0 && boisson2.getQuantiteStock() == 25.0) {
            System.out.println("       : Test GetQuantiteStock de la classe BoissonSimple réussi.");
        } else {
            System.out.println("ERREUR : Test GetQuantiteStock de la classe BoissonSimple échoué.");
        }
    }
}
