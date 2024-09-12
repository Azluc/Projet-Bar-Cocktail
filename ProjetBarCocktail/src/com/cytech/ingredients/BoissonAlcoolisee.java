package com.cytech.ingredients;

public class BoissonAlcoolisee extends BoissonSimple {

	public BoissonAlcoolisee(String nom, double contenance, double prix, double degreAlcool, double degreSucre,
			double quantiteStock) {
		super(nom, contenance, prix, degreAlcool, degreSucre, quantiteStock);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return nom;
	}
	
		
}
