package com.cytech.collections;

import java.util.Date;
import java.util.Map;

import com.cytech.ingredients.Boisson;

public class Commande {

	private Date dateCommande;
	private int numeroCommande;
	private String clientCommande;
	
	public String getClientCommande() {
		return clientCommande;
	}
	
	public void setClientCommande(String c) {
		this.clientCommande = c;
	}
	
	public Map<Boisson, Double> mapBoissonCommande;

	public Commande(Date dateCommande, int numeroCommande, Map<Boisson, Double> mapBoissonCommande) {
		super();
		this.dateCommande = dateCommande;
		this.numeroCommande = numeroCommande;
		this.mapBoissonCommande = mapBoissonCommande;
		
	}

	public Map<Boisson, Double> getMapBoissonCommande() {
		return mapBoissonCommande;
	}

	public void setMapBoissonCommande(Map<Boisson, Double> mapBoissonCommande) {
		this.mapBoissonCommande = mapBoissonCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public int getNumeroCommande() {
		return numeroCommande;
	}

	public double getPrixCommande() 
	{
		double prix = 0.;
		if (mapBoissonCommande != null) {
			for (Map.Entry<Boisson, Double> entry : mapBoissonCommande.entrySet()) {
				prix += entry.getKey().getPrix()*entry.getValue()/entry.getKey().getContenance();
			}
		}
		return prix;
		
	}
	

}


