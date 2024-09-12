package com.cytech.ingredients;



public class Supplement {

	private String nom;
	private Double prix;
	@Override
	public String toString() {
		return nom;
	}

	private Double quantiteStock;

	public Supplement(String nom, Double prix, Double quantiteStock) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.quantiteStock = quantiteStock;
		
	}
	public Supplement() {
	    // Constructeur sans argument
	}
	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public String getNom() {
		return nom;
	}

	public Double getQuantiteStock() {
		return quantiteStock;
	}

	public void setQuantiteStock(Double quantiteStock) {
		this.quantiteStock = quantiteStock;
	}


	
	
	
}
