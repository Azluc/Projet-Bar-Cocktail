package com.cytech.testsUnitaires;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cytech.collections.Client;
import com.cytech.gestionFichiers.GestionListeClient;

import com.cytech.gestionFichiers.GestionClient;
 

public class TestGestionClient {
	
	private static List<GestionListeClient> listeClient = new ArrayList<>(); //tableau  qui va contenir la liste totale des clients
	private static String fichierClient = "resource/client.json"; //chemin menant vers le fichier Client
	
	public static void main(String[] args) {
		//testStockClient();
		lectureClient();
	}
	public static void testStockClient() {
		Date date = new Date();
	    Client client = new Client("Doe", "John", "aaa@gmail.com", "abcd", date, "11 rue Cergy", "test phrase secrete");
	   
	    File file = new File(fichierClient);
        if(!file.exists()) {
            try {
            	//Si le fichier client n'existe pas, on crée un nouveau fichier et on définie une nouvelle liste qui va porter l'ensemble des clients
        		ArrayList<Client> infoClient = new ArrayList<>(); //Variable qui va contenir les infos du client
        		infoClient.add(client);
        		GestionListeClient donneesClient = new GestionListeClient(client.getNom(),infoClient);
        		listeClient.add(donneesClient);
                if(GestionClient.EcrireJsonDirecte(fichierClient, listeClient, GestionListeClient.class)) {
                	System.out.println("Creation du fichier Client et Sauvegarde du client dans le fichier Client réussi !");
                }
                else {
                	System.out.println("Creation du fichier Client et Sauvegarde du client dans le fichier Client échoué !");
                }
                	
                file.createNewFile();
            }catch(IOException e) {
                e.printStackTrace();
            }
        }
        
        	//si le fichier existe on lit le fichier et on ajoute a la fin le client
        	Client client1 = new Client("Lucas", "Lucas", "bbb@gmail.com", "motdepasse", date, "12 rue Cergy", "test phrase secrete");
        	listeClient = GestionClient.lireJSON(fichierClient);
    		ArrayList<Client> infoClient1 = new ArrayList<>(); //Variable qui va contenir les infos du client
    		infoClient1.add(client1);
    		GestionListeClient donneesClient1 = new GestionListeClient(client1.getNom(),infoClient1);
    		listeClient.add(donneesClient1);  
        	if((GestionClient.EcrireJsonDirecte(fichierClient, listeClient, GestionListeClient.class))){
        		System.out.println("Sauvergarde d'un client dans le fichier Client réussi !");
        	}
        	else {
        		System.out.println("Sauvergarde d'un client dans la fichier Client échoué !");
        	}
    }
	
	public static void lectureClient() {
		ArrayList<Client> listelue = GestionClient.lectureListeClient();
		System.out.println(listelue);
	}
}
