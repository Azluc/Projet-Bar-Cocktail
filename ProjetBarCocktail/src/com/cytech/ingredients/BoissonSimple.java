
package com.cytech.ingredients;

public abstract class BoissonSimple extends Boisson {

	public double quantiteStock;

	public BoissonSimple(String nom, double contenance, double prix, double degreAlcool, double degreSucre,
			double quantiteStock) {
		super(nom, contenance, prix, degreAlcool, degreSucre);
		this.quantiteStock = quantiteStock;
	}

	@Override
	public String toString() {
		return "BoissonSimple [quantiteStock=" + quantiteStock + ", nom=" + nom + ", contenance=" + contenance
				+ ", prix=" + prix + ", degreAlcool=" + degreAlcool + ", degreSucre=" + degreSucre
				+ ", getQuantiteStock()=" + getQuantiteStock() + ", getContenance()=" + getContenance() + ", getPrix()="
				+ getPrix() + ", getNom()=" + getNom() + ", getDegreAlcool()=" + getDegreAlcool() + ", getDegreSucre()="
				+ getDegreSucre() + ", estAlcoolisee()=" + estAlcoolisee() + ", toString()=" + super.toString() + "]";
	}

	public double getQuantiteStock() {
		return quantiteStock;
	}

	public void setQuantiteStock(double quantiteStock) {
		this.quantiteStock = quantiteStock;
	}
	
	
	
}