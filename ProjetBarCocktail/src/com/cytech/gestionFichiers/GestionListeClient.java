package com.cytech.gestionFichiers;
import java.util.ArrayList;
import com.cytech.collections.Client;

public class GestionListeClient {
	private String name;
	private ArrayList<Client> listeClient;

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public ArrayList<Client> getlisteClient() { return listeClient; }
	@Override
	public String toString() {
		return "GestionListeClient [name=" + name + ", listeClient=" + listeClient + "]";
	}
	public void setlisteClient(ArrayList<Client> listeClient) { this.listeClient = listeClient; }

	public GestionListeClient(String name, ArrayList<Client> listeClient) {
		this.name = name;
		this.listeClient = listeClient;
	}
}
