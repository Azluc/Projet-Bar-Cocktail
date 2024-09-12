package com.cytech.gestionFichiers;

import java.util.ArrayList;

import com.cytech.ingredients.Supplement;

public class GestionListeSupplement {
	private String name;
	private ArrayList<Supplement> listeSupplement;

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public ArrayList<Supplement> getlisteSupplement() { return listeSupplement; }
	@Override
	public String toString() {
		return "GestionListeSupplement [name=" + name + ", listeSupplement=" + listeSupplement + "]";
	}
	public void setlisteSupplement(ArrayList<Supplement> listeSupplement) { this.listeSupplement = listeSupplement; }

	public GestionListeSupplement(String name, ArrayList<Supplement> listeSupplement) {
		this.name = name;
		this.listeSupplement = listeSupplement;
	}
}
