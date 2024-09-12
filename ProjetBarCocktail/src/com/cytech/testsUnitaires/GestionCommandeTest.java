package com.cytech.testsUnitaires;

import com.cytech.collections.Commande;
import com.cytech.ingredients.Boisson;
import com.cytech.ingredients.BoissonAlcoolisee;
import com.cytech.ingredients.BoissonNonAlcoolisee;
import com.cytech.ingredients.Cocktail;
import com.cytech.ingredients.Supplement;
import com.cytech.gestionFichiers.GestionCommande;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestionCommandeTest {
    public static final String BOISSON_ALCOOLISEE_JSON_PATH = "H:\\Downloads\\16Avril\\16Avril\\16Avril\\resource\\boissonAlcoolisee.json";
    public static final String BOISSON_NON_ALCOOLISEE_JSON_PATH = "H:\\Downloads\\16Avril\\16Avril\\16Avril\\resource\\boissonNonAlcoolisee.json";
    public static final String SUPPLEMENT_JSON_PATH = "H:\\Downloads\\16Avril\\16Avril\\16Avril\\resource\\supplement.json";
    public static final String COCKTAIL_JSON_PATH = "H:\\Downloads\\16Avril\\16Avril\\16Avril\\resource\\cocktail.json";
    public static final String COMMANDE_JSON_PATH = "resource\\commande.json";

    public static void main(String[] args) {
    	

    	
        //testTraitementCommande();
    }
    /*
    public static void testTraitementCommande() {
        // Création d'une commande de test avec les noms des boissons et cocktails
        
        Map<Boisson, Double> mapBoissonCommande = new HashMap<>();
        mapBoissonCommande.put(getBoissonAlcooliseeFromName("Rhum"), 2.0); // 2 rhums
        mapBoissonCommande.put(getBoissonNonAlcooliseeFromName("Eau"), 1.0); // 1 coca
        mapBoissonCommande.put(getCocktailFromName("Gin Fizz", COCKTAIL_JSON_PATH), 1.0); // 1Gin Fizz
        Commande commande = new Commande(new Date(), 0, mapBoissonCommande);
        Map<Supplement, Double> mapSupplementCommande = new HashMap<>();
        mapSupplementCommande.put(getSupplementFromName("Citron"), 1.0); // 1 citron
        
        
        try {
            GestionCommande.enregistrerCommande(commande, COMMANDE_JSON_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Appel de la méthode à tester
        //GestionCommande.traiterCommande(commande);

        // Vérification des stocks après traitement de la commande
        // (À compléter avec les assertions appropriées en fonction de votre logique métier)
    }
*/
    // Méthode pour obtenir une boisson alcoolisée à partir de son nom
    private static BoissonAlcoolisee getBoissonAlcooliseeFromName(String nom) {
        List<BoissonAlcoolisee> boissonsAlcoolisees;
        try {
            boissonsAlcoolisees = GestionCommande.lireBoissonsAlcoolisees(BOISSON_ALCOOLISEE_JSON_PATH);
            for (BoissonAlcoolisee boisson : boissonsAlcoolisees) {
                String nomBoisson = boisson.getNom();
                if (nomBoisson != null && nomBoisson.equals(nom)) {
                    return boisson;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // Retourne null si aucune boisson alcoolisée trouvée avec le nom donné
    }


    // Méthode pour obtenir une boisson non alcoolisée à partir de son nom
    private static BoissonNonAlcoolisee getBoissonNonAlcooliseeFromName(String nom) {
        List<BoissonNonAlcoolisee> boissonsNonAlcoolisees;
        try {
            boissonsNonAlcoolisees = GestionCommande.lireBoissonsNonAlcoolisees(BOISSON_NON_ALCOOLISEE_JSON_PATH);
            for (BoissonNonAlcoolisee boisson : boissonsNonAlcoolisees) {
                String nomBoisson = boisson.getNom();
                if (nomBoisson != null && nomBoisson.equals(nom)) {
                    return boisson;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // Retourne null si aucune boisson non alcoolisée trouvée avec le nom donné
    }


    private static Cocktail getCocktailFromName(String nom, String cocktailJsonPath) {
        List<Cocktail> cocktails;
       
            cocktails = GestionCommande.lireCocktails(cocktailJsonPath);
            for (Cocktail cocktail : cocktails) {
                String nomCocktail = cocktail.getNom();
                if (nomCocktail != null && nomCocktail.equals(nom)) {
                    return cocktail;
                }
            }
       
        return null; // Retourne null si aucun cocktail trouvé avec le nom donné
    }


    // Méthode pour obtenir un supplément à partir de son nom
    private static Supplement getSupplementFromName(String nom) {
        List<Supplement> supplements;
        try {
            supplements = GestionCommande.lireSupplements(SUPPLEMENT_JSON_PATH);
            if (supplements != null) { // Vérifie si la liste de suppléments n'est pas null
                for (Supplement supplement : supplements) {
                    String nomSupplement = supplement.getNom();
                    if (nomSupplement != null && nomSupplement.equals(nom)) {
                        return supplement;
                    }
                }
            } else {
                System.out.println("La liste de suppléments est null !");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // Retourne null si aucun supplément trouvé avec le nom donné ou s'il y a une erreur lors de la lecture
    }


}
