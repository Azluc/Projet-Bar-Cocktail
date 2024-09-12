package com.cytech.testsUnitaires;
 
import com.cytech.collections.Barman;
 
public class TestBarmang {
	
	public static void main(String[] args) {
        testVerifIdentifiants();
    }
 
    public static void testVerifIdentifiants() {
        // Création d'un objet Barman à tester
        Barman barman = new Barman("eliot", "123");
 
        // Vérification des identifiants
        if (barman.verifierIdentifiants("eliot", "123")) {
            System.out.println("Identifiants valides, le barman existe.");
        } else {
            System.out.println("Identifiants invalides.");
        }
    }
}