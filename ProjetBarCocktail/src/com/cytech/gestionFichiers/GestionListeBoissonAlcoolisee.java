package com.cytech.gestionFichiers;

import java.util.ArrayList;

import com.cytech.ingredients.BoissonAlcoolisee;

public class GestionListeBoissonAlcoolisee {
	private String name;
	private ArrayList<BoissonAlcoolisee> listeBoissonAlcoolisee;

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public ArrayList<BoissonAlcoolisee> getlisteBoissonAlcoolisee() { return listeBoissonAlcoolisee; }
	@Override
	public String toString() {
		return "GestionListeBoissonAlcoolisee [name=" + name + ", listeBoissonAlcoolisee=" + listeBoissonAlcoolisee
				+ ", getName()=" + getName() + ", getlisteBoissonAlcoolisee()=" + getlisteBoissonAlcoolisee() + "]";
	}
	public void setlisteBoissonAlcoolisee(ArrayList<BoissonAlcoolisee> listeBoissonAlcoolisee) { this.listeBoissonAlcoolisee = listeBoissonAlcoolisee; }

	public GestionListeBoissonAlcoolisee(String name, ArrayList<BoissonAlcoolisee> listeBoissonAlcoolisee) {
		this.name = name;
		this.listeBoissonAlcoolisee = listeBoissonAlcoolisee;
	}
}
