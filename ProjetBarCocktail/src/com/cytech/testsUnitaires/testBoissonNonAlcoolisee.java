package com.cytech.testsUnitaires;

import com.cytech.ingredients.BoissonNonAlcoolisee;

public class testBoissonNonAlcoolisee {
    public static void main(String[] args) {
        testGetDegreAlcool();
    }

    public static void testGetDegreAlcool() {
        BoissonNonAlcoolisee boisson1 = new BoissonNonAlcoolisee("Jus de cranberry", 1.0, 4.9, 0.0, 100.0, 15.0);
        BoissonNonAlcoolisee boisson2 = new BoissonNonAlcoolisee("Sirop de framboise", 0.5, 6.5, 0.0, 250.0, 10.0);

        if (boisson1.getDegreAlcool() == 0 && boisson2.getDegreAlcool() == 0) {
            System.out.println("       : Test GetDegreAlcool de la classe BoissonNonAlcoolisee réussi.");
        } else {
            System.out.println("ERREUR : Test GetDegreAlcool de la classe BoissonAlcoolisee échoué.");
        }
    }
}