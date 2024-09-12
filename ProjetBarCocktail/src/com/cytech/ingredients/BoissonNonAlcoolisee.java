package com.cytech.ingredients;

public class BoissonNonAlcoolisee extends BoissonSimple{

 

	public BoissonNonAlcoolisee(String nom, double contenance, double prix, double degreAlcool,double degreSucre,
			double quantiteStock) {
		super(nom, contenance, prix, 0, degreSucre, quantiteStock);
		// TODO Auto-generated constructor stub
		/*On enlève le degre d'alcool du constructeur et on initialise a 0*/
	}

	@Override
	public String toString() {
		return nom;
	}

 

}
