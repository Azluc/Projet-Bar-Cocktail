package com.cytech.gestionFichiers;

 
import java.util.Map;
public class GestionListeCocktail {
    private String name;
    private Map<String, Double> mapBoissons;
    private Map<String, Double> mapSupplements;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, Double> getMapBoissons() {
		return mapBoissons;
	}
	public void setMapBoissons(Map<String, Double> mapBoissons) {
		this.mapBoissons = mapBoissons;
	}
	public Map<String, Double> getMapSupplements() {
		return mapSupplements;
	}
	public void setMapSupplements(Map<String, Double> mapSupplements) {
		this.mapSupplements = mapSupplements;
	}
	@Override
	public String toString() {
		return "GestionListeCocktail [name=" + name + ", mapBoissons=" + mapBoissons + ", mapSupplements="
				+ mapSupplements + ", getName()=" + getName() + ", getMapBoissons()=" + getMapBoissons()
				+ ", getMapSupplements()=" + getMapSupplements() + ", toString()=" + super.toString() + "]";
	}
	public GestionListeCocktail(String name, Map<String, Double> mapBoissons, Map<String, Double> mapSupplements) {
		super();
		this.name = name;
		this.mapBoissons = mapBoissons;
		this.mapSupplements = mapSupplements;
	}
	 
	 
	
}
