package com.cytech.gestionFichiers;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import com.cytech.collections.Client;
import com.cytech.ingredients.BoissonAlcoolisee;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

 
public class GestionClient{
	
	 
	 
	 
	 public static List<GestionListeClient> lireJSON(String fichierJSON) {
			try {
				JsonReader reader = new JsonReader(new FileReader(fichierJSON));
				// On peut lire un seul objet ou un tableau avec []
				GestionListeClient[] tabCat = new Gson().fromJson(reader, GestionListeClient[].class);
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
		 * Entree : collection des GestionListeClient et nom du fichier
		 * Sortie : Vrai si reussi et Faux sinon
		 * Remarque : la classe ne peut etre parametree car il faut gerer chaque attribu de la classe
		 */
		public static boolean EcrireJsonManuelle(String fichierJSON, List<GestionListeClient> lstCat) {
			try {
				JsonWriter writer = new JsonWriter(new FileWriter(fichierJSON));
				writer.beginArray(); // une liste devient un tableau en JSON
				for (GestionListeClient cat : lstCat) {
					writer.beginObject();
					writer.name("name").value(cat.getName()); // champs unique
					writer.name("lstpdt");
					writer.beginArray(); // tableau des Clients
					for (Client pdt : cat.getlisteClient()) {
						writer.beginObject();
						writer.name("Nom").value(pdt.getNom());
						writer.name("Prenom").value(pdt.getPrenom());
						writer.name("Email").value(pdt.getEmail());
						writer.name("mot de passe").value(pdt.getMotDePasse());
						writer.name("date de naissance").value(new SimpleDateFormat("dd/MM/yyyy").format(pdt.getDateNaissance()));
						writer.name("Adresse").value(pdt.getAdresse());
						writer.name("Phrase Secrète").value(pdt.getPhraseSecrete());
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
		
		public static ArrayList<Client> lectureListeClient() {
			List<GestionListeClient> listeClient = lireJSON("resource/client.json");
			ArrayList<Client> listeExtraite= new ArrayList<Client>();
			for (GestionListeClient el : listeClient) {
				listeExtraite.add(el.getlisteClient().getFirst());
			}
			
			return listeExtraite;
		}
		
		public static boolean ecritureClient(Client c) {
			// permet d'ajouter un nouveau client
			List<GestionListeClient> listeRaw = lireJSON("resource/client.json");
			ArrayList<Client> arrayClient = new ArrayList<Client>();
			arrayClient.add(c);
			GestionListeClient clientSav = new GestionListeClient(c.getNom(), arrayClient);
			
			listeRaw.add(clientSav);
			return EcrireJsonDirecte("resource/client.json", listeRaw, GestionListeClient.class);
		
		}
}