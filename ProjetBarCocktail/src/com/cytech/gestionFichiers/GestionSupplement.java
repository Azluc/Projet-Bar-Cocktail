package com.cytech.gestionFichiers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import com.cytech.ingredients.BoissonAlcoolisee;
import com.cytech.ingredients.BoissonNonAlcoolisee;
import com.cytech.ingredients.Supplement;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

 
public class GestionSupplement {
	
	 
	 
	 
	 public static List<GestionListeSupplement> lireJSON(String fichierJSON) {
			try {
				JsonReader reader = new JsonReader(new FileReader(fichierJSON));
				// On peut lire un seul objet ou un tableau avec []
				GestionListeSupplement[] tabCat = new Gson().fromJson(reader, GestionListeSupplement[].class);
				return new ArrayList<>(Arrays.asList(tabCat));
			} catch (FileNotFoundException e) {
				System.out.println(e.getStackTrace() + " : File Not Found");
			} catch (JsonParseException e) {
				System.out.println(e.getStackTrace() + " : JsonParseException");
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
		 * Entree : collection des GestionListeSupplement et nom du fichier
		 * Sortie : Vrai si reussi et Faux sinon
		 * Remarque : la classe ne peut etre parametree car il faut gerer chaque attribu de la classe
		 */
		public static boolean EcrireJsonManuelle(String fichierJSON, List<GestionListeSupplement> lstCat) {
			try {
				JsonWriter writer = new JsonWriter(new FileWriter(fichierJSON));
				writer.beginArray(); // une liste devient un tableau en JSON
				for (GestionListeSupplement cat : lstCat) {
					writer.beginObject();
					writer.name("name").value(cat.getName()); // champs unique
					writer.name("Infos Supplement");
					writer.beginArray(); // tableau des Supplements
					for (Supplement pdt : cat.getlisteSupplement()) {
						writer.beginObject();
						writer.name("Nom").value(pdt.getNom());
						writer.name("Prix").value(pdt.getPrix());
						writer.name("Quantité Stock").value(pdt.getQuantiteStock());
						writer.endObject();
					}
					writer.endArray();
					writer.endObject();
				}
				writer.endArray();
				writer.close();
			} catch (IOException e) {
				System.out.println(e.getStackTrace() + " : Probleme de fichier");
				return false;
			}
			return true;
		}
		
		public static ArrayList<Supplement> lectureListeSupplement() {
			List<GestionListeSupplement> listeSupplement = lireJSON("resource/supplement.json");
			ArrayList<Supplement> listeExtraite= new ArrayList<Supplement>();
			for (GestionListeSupplement el : listeSupplement) {
				listeExtraite.add(el.getlisteSupplement().getFirst());
			}
			
			return listeExtraite;
			
		}
		public static boolean ecritureSupplement(Supplement s) {
			List<GestionListeSupplement> listeRaw = lireJSON("resource/supplement.json");
			ArrayList<Supplement> arraySupplement = new ArrayList<Supplement>();
			arraySupplement.add(s);
			GestionListeSupplement suppSav = new GestionListeSupplement(s.getNom(), arraySupplement);
			
			listeRaw.add(suppSav);
			return EcrireJsonDirecte("resource/supplement.json", listeRaw, GestionListeSupplement.class);
		
		}
		
		public static boolean ecritureToutStock(ArrayList<Supplement> lb) {
			// pour sauvegarder tout le stock
			List<GestionListeSupplement> listeRaw = new ArrayList<GestionListeSupplement>();
			
			for (Supplement el : lb) {
				ArrayList<Supplement> tmp = new ArrayList<Supplement>();
				tmp.add(el);
				listeRaw.add(new GestionListeSupplement(el.getNom(), tmp));
			}
			
			return EcrireJsonDirecte("resource/supplement.json", listeRaw, GestionListeSupplement.class);
			
		}
}