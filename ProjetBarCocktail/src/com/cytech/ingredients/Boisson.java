package com.cytech.ingredients;

public abstract class Boisson {
	protected String nom;
	protected double contenance;
	protected double prix;
	protected double degreAlcool;
	protected double degreSucre;
	
	public Boisson(String nom, double contenance, double prix, double degreAlcool, double degreSucre) {
		super();
		this.nom = nom;
		this.contenance = contenance;
		this.prix = prix;
		this.degreAlcool = degreAlcool;
		this.degreSucre = degreSucre;
	}
	public Boisson() {
	    // Constructeur sans argument
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setDegreAlcool(double degreAlcool) {
		this.degreAlcool = degreAlcool;
	}
	public void setDegreSucre(double degreSucre) {
		this.degreSucre = degreSucre;
	}
	public double getContenance() {
		return contenance;
	}

	public void setContenance(double contenance) {
		this.contenance = contenance;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getNom() {
		return nom;
	}

	public double getDegreAlcool() {
		return degreAlcool;
	}

	public double getDegreSucre() {
		return degreSucre;
	}
	
	public boolean estAlcoolisee() {
		return degreAlcool>0;
	}
	@Override
	public String toString() {
		return "Boisson [nom=" + nom + ", contenance=" + contenance + ", prix=" + prix + ", degreAlcool=" + degreAlcool
				+ ", degreSucre=" + degreSucre + "]";
	}
}
