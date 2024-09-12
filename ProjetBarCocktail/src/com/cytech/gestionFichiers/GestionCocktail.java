package com.cytech.gestionFichiers;

import java.io.BufferedWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cytech.ingredients.BoissonSimple;
import com.cytech.ingredients.Cocktail;
import com.cytech.ingredients.Supplement;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class GestionCocktail {
	public static List<GestionListeCocktail> lireJSON(String fichierJSON) {
	    try {
	        JsonReader reader = new JsonReader(new FileReader(fichierJSON));
	        // On peut lire un seul objet ou un tableau avec []
	        GestionListeCocktail[] tabCat = new Gson().fromJson(reader, GestionListeCocktail[].class);
	        return new ArrayList<>(Arrays.asList(tabCat));
	    } catch (FileNotFoundException e) {
	        System.out.println("File Not Found: " + e.getMessage());
	    } catch (JsonParseException e) {
	        System.out.println("JsonParseException: " + e.getMessage());
	    }
	    return null;
	}

		/* Recuperation d'un objet unique de classe T (classe passee en parametre)
		 * Entree : nom du fichier et Classe de l'objet a recuperer
		 * Sortie : objet recupere
		 * Remarque : ne peut recuperer qu'un objet de la classe, pas une collection, qui doit etre geree a l'appel
		 */
		public static <T> T lireObjetJSON(String fichierJSON, Class<T> classe) {
	        try (FileReader reader = new FileReader(fichierJSON)) {
	            Gson gson = new Gson();
	            return gson.fromJson(reader, classe);
	        } catch (IOException | JsonParseException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

		/* Sauvegarde d'une collection (liste) d'objets de classe parametree
		 * Entree : Collection liste, de type classe et nom de fichier
		 * Sortie : Vrai si reussi et faux sinon
		 * Sauvegarde directe des attributs des objets grace a la methode toJson
		 * Attention, il y a des restrictions a voir sur le site de jmdoudou
		 */
		public static <T> boolean EcrireJsonDirecte(String fichierJSON, List<T> liste, Class<T> classe) {
			try {
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				String jsonStr = gson.toJson(liste);
				BufferedWriter bw = new BufferedWriter(new FileWriter(fichierJSON));
				bw.write(jsonStr);
				bw.close();
			} catch (IOException e) {
				System.out.println(e.getStackTrace() + " : Probleme de fichier");
				return false;
			} catch (JsonParseException e) {
				System.out.println(e.getStackTrace() + " : JsonParseException");
				return false;
			}
			return true;
		}
		
		/* Meme fonction mais par creation manuelle du fichier JSON avec JsonWriter
		 * Entree : collection des GestionListeCocktail et nom du fichier
		 * Sortie : Vrai si reussi et Faux sinon
		 * Remarque : la classe ne peut etre parametree car il faut gerer chaque attribu de la classe
		 */
		public static void ecrireJsonManuelle(String fichierJSON, List<GestionListeCocktail> lstCat) {
	        try {
	            JsonWriter writer = new JsonWriter(new FileWriter(fichierJSON));
	            writer.beginArray(); // une liste devient un tableau en JSON
	            for (GestionListeCocktail cat : lstCat) {
	                writer.beginObject();
	                writer.name("name").value(cat.getName()); // champs unique
	                writer.name("mapBoissons");
	                writer.beginObject();  
	                for (Map.Entry<String, Double> entry : cat.getMapBoissons().entrySet()) {
	                    String boisson = entry.getKey();
	                    Double quantite = entry.getValue();
	                    writer.name(boisson).value(quantite);
	                }
	                writer.endObject();  

	                writer.name("mapSupplements");
	                writer.beginObject();  
	                for (Map.Entry<String, Double> entry : cat.getMapSupplements().entrySet()) {
	                    String supplement = entry.getKey();
	                    Double quantite = entry.getValue();
	                    writer.name(supplement).value(quantite);
	                }
	                writer.endObject();  

	                writer.endObject();  
	            }
	            writer.endArray();  
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
		
		public static ArrayList<Cocktail> lectureListeCocktail(ArrayList<BoissonSimple> stockBoisson, ArrayList<Supplement> stockSupplement) {
			/*Permet de sortir la liste d'objet cocktails enregistré dans le json.
			 * La fonction a besoin des listes de boissons et de supplement du bar pour pouvoir créer les objets cocktails avec les bonnes
			 * Instance des objets
			 * 
			 */
			
			ArrayList<Cocktail> listeExtraite= new ArrayList<Cocktail>();
			
			List<GestionListeCocktail> listeRaw = lireJSON("resource/cocktail.json");
			
			for (GestionListeCocktail el: listeRaw) {
				Map<BoissonSimple, Double> mapBoisson = new HashMap<BoissonSimple, Double>();
				Map<Supplement, Double> mapSupplement = new HashMap<Supplement, Double>();
				
				//on remplit les maps avec les noms de boissons enregistrés
				for(Map.Entry<String, Double> entry : el.getMapBoissons().entrySet()) {
					for (BoissonSimple boisson: stockBoisson) {
						if (boisson.getNom().equals(entry.getKey())) {
							mapBoisson.put(boisson, entry.getValue());
						}
					}
				}
				
				for(Map.Entry<String, Double> entry : el.getMapSupplements().entrySet()) {
					for (Supplement supp : stockSupplement) {
						if(supp.getNom().equals(entry.getKey())) {
							mapSupplement.put(supp, entry.getValue());
						}
					}
				}
				
				listeExtraite.add(new Cocktail(el.getName(), mapBoisson, mapSupplement));
				
			}
			
			return listeExtraite;
			
		}
		public static boolean ecritureCocktail(Cocktail cocktail) {
			List<GestionListeCocktail> listeRaw = lireJSON("resource/cocktail.json");
			
			Map<String, Double> mapBoissonPourSav = new HashMap<String, Double>();
			Map<String, Double> mapSupplementPourSav = new HashMap<String, Double>();
			
			for (Map.Entry<BoissonSimple, Double> entry : cocktail.getMapBoisson().entrySet()) {
				mapBoissonPourSav.put(entry.getKey().getNom(), entry.getValue());
			}
			
			for (Map.Entry<Supplement, Double> entry : cocktail.getMapSupplement().entrySet()) {
				mapSupplementPourSav.put(entry.getKey().getNom(), entry.getValue());
			}
			
			GestionListeCocktail cocktailSav = new GestionListeCocktail(cocktail.getNom(), mapBoissonPourSav, mapSupplementPourSav);
			listeRaw.add(cocktailSav);
			
			return EcrireJsonDirecte("resource/cocktail.json", listeRaw, GestionListeCocktail.class);
		}
}

