package com.cytech.gestionFichiers;

import java.util.ArrayList;

import com.cytech.ingredients.BoissonNonAlcoolisee;

public class GestionListeBoissonNonAlcoolisee {
	private String name;
	private ArrayList<BoissonNonAlcoolisee> listeBoissonNonAlcoolisee;

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public ArrayList<BoissonNonAlcoolisee> getlisteBoissonNonAlcoolisee() { return listeBoissonNonAlcoolisee; }
	@Override
	public String toString() {
		return "GestionListeBoissonNonAlcoolisee [name=" + name + ", listeBoissonNonAlcoolisee="
				+ listeBoissonNonAlcoolisee + ", getName()=" + getName() + ", getlisteBoissonNonAlcoolisee()="
				+ getlisteBoissonNonAlcoolisee() + ", toString()=" + super.toString() + "]";
	}
	public void setlisteBoissonNonAlcoolisee(ArrayList<BoissonNonAlcoolisee> listeBoissonNonAlcoolisee) { this.listeBoissonNonAlcoolisee = listeBoissonNonAlcoolisee; }

	public GestionListeBoissonNonAlcoolisee(String name, ArrayList<BoissonNonAlcoolisee> listeBoissonNonAlcoolisee) {
		this.name = name;
		this.listeBoissonNonAlcoolisee = listeBoissonNonAlcoolisee;
	}
}
