package com.cytech.testsUnitaires;

import com.cytech.ingredients.BoissonAlcoolisee;

public class testBoissonAlcoolisee {
	    public static void main(String[] args) {
	        testGetDegreAlcool();
	    }

	    public static void testGetDegreAlcool() {
	        BoissonAlcoolisee boisson1 = new BoissonAlcoolisee("Curacao bleu", 0.7, 17.5, 20.0, 60.0, 15.0);
	        BoissonAlcoolisee boisson2 = new BoissonAlcoolisee("Calvados", 0.7, 34.0, 40.0, 0.0, 15.0);

	        if (boisson1.getDegreAlcool() > 0 && boisson2.getDegreAlcool() > 0) {
	            System.out.println("       : Test GetDegreAlcool de la classe BoissonAlcoolisee réussi.");
	        } else {
	            System.out.println("ERREUR : Test GetDegreAlcool de la classe BoissonAlcoolisee échoué.");
	        }
	    }
	}