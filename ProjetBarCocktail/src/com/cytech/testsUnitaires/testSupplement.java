package com.cytech.testsUnitaires;

import com.cytech.ingredients.Supplement;

public class testSupplement {

    public static void main(String[] args) {
        testGetNom();
        testGetPrix();
        testSetPrix();
        testConstructeurSupplement();
    }

    public static void testGetNom() {
        Supplement glacons = new Supplement("Glaçons", 0.0, 500.0);
        
        if ("Glaçons".equals(glacons.getNom())) {
            System.out.println("       : Test GetNom de la classe Supplement réussi.");
        } else {
            System.out.println("ERREUR : Test GetNom de la classe Supplement échoué.");
        }
    }
    
    public static void testGetPrix() {
        Supplement gateauxAperitif = new Supplement("Herbes fraiches", 2.5, 30.0);
        
        if (gateauxAperitif.getPrix() == 2.5) {
            System.out.println("       : Test GetPrix de la classe Supplement réussi.");
        } else {
            System.out.println("ERREUR : Test GetPrix de la classe Supplement échoué.");
        }
    }
    
    public static void testSetPrix() {
        Supplement zesteDeLime = new Supplement("Zeste de Lime", 1.0, 100.0);
        
        zesteDeLime.setPrix(0.75);
        
        if (zesteDeLime.getPrix() == 0.75) {
            System.out.println("       : Test SetPrix de la classe Supplement réussi.");
        } else {
            System.out.println("ERREUR : Test SetPrix de la classe Supplement échoué.");
        }
    }

    
    public static void testConstructeurSupplement() {
        Supplement tranchesDeFraises = new Supplement("Tranches de Fraises", 0.75, 50.0);
        
        if ("Tranches de Fraises".equals(tranchesDeFraises.getNom()) && tranchesDeFraises.getPrix() == 0.75) {
            System.out.println("       : Test Constructeur de la classe Supplement réussi.");
        } else {
            System.out.println("ERREUR : Test Constructeur de la classe Supplement échoué.");
        }
    }

}