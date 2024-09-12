package com.cytech.gestionFichiers;
import com.cytech.gestionFichiers.*;

import com.cytech.collections.Commande;
import com.cytech.ingredients.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.io.Reader;


public class GestionCommande {
	public static final String BOISSON_ALCOOLISEE_JSON_PATH = "resource\\boissonAlcoolisee.json";
	public static final String BOISSON_NON_ALCOOLISEE_JSON_PATH = "resource\\boissonNonAlcoolisee.json";
	public static final String SUPPLEMENT_JSON_PATH = "resource\\supplement.json";
	public static final String COCKTAIL_JSON_PATH = "resource\\cocktail.json";
	public static final String COMMANDE_JSON_PATH = "resource\\commande.json";

    
            

	 public static StockManager stockManager;
	 
    public static void traiterCommande(Commande commande) {
        for (Map.Entry<Boisson, Double> entry : commande.getMapBoissonCommande().entrySet()) {
            Boisson boisson = entry.getKey();
            double quantiteCommandee = entry.getValue(); // Quantité commandée
            if (boisson instanceof Cocktail) {
                Cocktail cocktail = (Cocktail) boisson;
                Map<BoissonSimple, Double> mapBoissonCocktail = cocktail.getMapBoisson();
                Map<Supplement, Double> mapSupplementCocktail = cocktail.getMapSupplement();
                
                // Déduire la quantité de chaque boisson simple du stock
                for (Map.Entry<BoissonSimple, Double> boissonEntry : mapBoissonCocktail.entrySet()) {
                    BoissonSimple boissonSimple = boissonEntry.getKey();
                    double quantiteUtilisee = boissonEntry.getValue() * quantiteCommandee; // Quantité utilisée dans tous les cocktails
                    if (boissonSimple instanceof BoissonAlcoolisee) {
                        stockManager.deductFromStockBoissonsAlcoolisees(boissonSimple.getNom(), quantiteUtilisee);
                    } else if (boissonSimple instanceof BoissonNonAlcoolisee) {
                        stockManager.deductFromStockBoissonsNonAlcoolisees(boissonSimple.getNom(), quantiteUtilisee);
                    }
                }
                
                // Déduire la quantité de chaque supplément du stock
                for (Map.Entry<Supplement, Double> supplementEntry : mapSupplementCocktail.entrySet()) {
                    Supplement supplement = supplementEntry.getKey();
                    double quantiteUtilisee = supplementEntry.getValue() * quantiteCommandee; // Quantité utilisée dans tous les cocktails
                    stockManager.deductFromStockSupplements(supplement.getNom(), quantiteUtilisee);
                }
            } else {
                // Traitement des boissons simples
                BoissonSimple boissonSimple = (BoissonSimple) boisson;
                if (boissonSimple instanceof BoissonAlcoolisee) {
                    stockManager.deductFromStockBoissonsAlcoolisees(boissonSimple.getNom(), quantiteCommandee);
                } else if (boissonSimple instanceof BoissonNonAlcoolisee) {
                    stockManager.deductFromStockBoissonsNonAlcoolisees(boissonSimple.getNom(), quantiteCommandee);
                }
            }
        }

    }


    // Méthodes pour lire les données de stock actuelles à partir des fichiers JSON
    public static List<BoissonAlcoolisee> lireBoissonsAlcoolisees(String fichierAlcool) throws IOException {
        try (FileReader reader = new FileReader(fichierAlcool)) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<BoissonAlcoolisee>>() {}.getType();
            return gson.fromJson(reader, type);
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<BoissonNonAlcoolisee> lireBoissonsNonAlcoolisees(String fichierNonAlcool) throws IOException {
        try (FileReader reader = new FileReader(fichierNonAlcool)) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<BoissonNonAlcoolisee>>() {}.getType();
            return gson.fromJson(reader, type);
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Supplement> lireSupplements(String fichierSupplement) throws IOException {
        try (FileReader reader = new FileReader(fichierSupplement)) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<Supplement>>() {}.getType();
            return gson.fromJson(reader, type);
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Méthode pour sauvegarder les données de stock mises à jour dans les fichiers JSON
    public static void sauvegarderBoissonsAlcoolisees(List<BoissonAlcoolisee> boissons) throws IOException {
        try (FileWriter writer = new FileWriter(BOISSON_ALCOOLISEE_JSON_PATH)) {
            Gson gson = new Gson();
            gson.toJson(boissons, writer);
        }
    }

    public static void sauvegarderBoissonsNonAlcoolisees(List<BoissonNonAlcoolisee> boissons) throws IOException {
        try (FileWriter writer = new FileWriter(BOISSON_NON_ALCOOLISEE_JSON_PATH)) {
            Gson gson = new Gson();
            gson.toJson(boissons, writer);
        }
    }

    public static void sauvegarderSupplements(List<Supplement> supplements) throws IOException {
        try (FileWriter writer = new FileWriter(SUPPLEMENT_JSON_PATH)) {
            Gson gson = new Gson();
            gson.toJson(supplements, writer);
        }
    }
    public static List<Cocktail> lireCocktails(String cocktail) {
        try (FileReader reader = new FileReader(COCKTAIL_JSON_PATH)) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<Cocktail>>() {}.getType();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Méthode pour enregistrer une commande dans un fichier JSON
    public static void enregistrerCommande(Commande commande, String cheminFichier, List<BoissonAlcoolisee> stockBA, List<BoissonNonAlcoolisee> stockBNA, List<Cocktail> stockC) throws IOException {
    	 //Pour enregistrer une commande, on fait comme avec les cocktails mais on sépare les types de boissons
    	List<Commande> commandes = lireCommandesDuJSON(cheminFichier, stockBA, stockBNA, stockC);
        commandes.add(commande);
        // On init la liste de GestionListeCommande qui sera sauvegardée

        List<GestionListeCommande> listeCommandeASav =  new ArrayList<GestionListeCommande>();
        
        for (Commande com : commandes) {
        	listeCommandeASav.add(new GestionListeCommande(com)); //pour chaque commande , on la converti en GestionListeCommande pour l'enregistrer
        }
        
        try (FileWriter writer = new FileWriter(cheminFichier)) {
            Gson gson = new Gson();
            gson.toJson(listeCommandeASav, writer); // On ecrit la liste dans le fichier
        }
    }

    // Méthode pour lire les commandes à partir d'un fichier JSON
    public static List<Commande> lireCommandesDuJSON(String jsonPath, List<BoissonAlcoolisee> stockBA, List<BoissonNonAlcoolisee> stockBNA, List<Cocktail> stockC) throws IOException {
        Gson gson = new Gson();
    	
        try (Reader reader = new FileReader(jsonPath)) {
            // Utilisation de TypeToken pour désérialiser une liste de commandes
            Type listType = new TypeToken<List<GestionListeCommande>>(){}.getType();
          //On récupere la liste enregistrée
            List<GestionListeCommande> commandesAdeenregistrer = gson.fromJson(reader, listType);
            List<Commande> commandes = new ArrayList<Commande>();
            if (commandesAdeenregistrer != null ) {
            	
            	for (GestionListeCommande com : commandesAdeenregistrer) {
            		commandes.add(com.toCommande(stockBA, stockBNA, stockC));
            	}
            }
           
            return commandes;
        }
    }





        
    }


