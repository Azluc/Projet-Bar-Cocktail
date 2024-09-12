package com.cytech.gestionFichiers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.cytech.ingredients.*;
import com.cytech.gestionFichiers.*;

public class StockManager {
	public static final String BOISSON_ALCOOLISEE_JSON_PATH = "H:\\Downloads\\16Avril\\16Avril\\16Avril\\resource\\boissonAlcoolisee.json";
	public static final String BOISSON_NON_ALCOOLISEE_JSON_PATH = "H:\\Downloads\\16Avril\\16Avril\\16Avril\\resource\\boissonNonAlcoolisee.json";
	public static final String SUPPLEMENT_JSON_PATH = "H:\\Downloads\\16Avril\\16Avril\\16Avril\\resource\\supplement.json";
    
	 private Map<String, Double> stockBoissonsAlcoolisees;
	    private Map<String, Double> stockBoissonsNonAlcoolisees;
	    private Map<String, Double> stockSupplements;

	    public StockManager(Map<String, Double> stockBoissonsAlcoolisees, Map<String, Double> stockBoissonsNonAlcoolisees, Map<String, Double> stockSupplements) {
	        this.stockBoissonsAlcoolisees = stockBoissonsAlcoolisees;
	        this.stockBoissonsNonAlcoolisees = stockBoissonsNonAlcoolisees;
	        this.stockSupplements = stockSupplements;
	    }
	    public StockManager(List<BoissonAlcoolisee> boissonsAlcoolisees, List<BoissonNonAlcoolisee> boissonsNonAlcoolisees, List<Supplement> supplements) {
	        this.stockBoissonsAlcoolisees = initStockBoissonsAlcoolisees(boissonsAlcoolisees);
	        this.stockBoissonsNonAlcoolisees = initStockBoissonsNonAlcoolisees(boissonsNonAlcoolisees);
	        this.stockSupplements = initStockSupplements(supplements);
	    }

	    private Map<String, Double> initStockBoissonsAlcoolisees(List<BoissonAlcoolisee> boissonsAlcoolisees) {
	        Map<String, Double> stock = new HashMap<>();
	        for (BoissonAlcoolisee boisson : boissonsAlcoolisees) {
	            stock.put(boisson.getNom(), boisson.getQuantiteStock());
	        }
	        return stock;
	    }

	    private Map<String, Double> initStockBoissonsNonAlcoolisees(List<BoissonNonAlcoolisee> boissonsNonAlcoolisees) {
	        Map<String, Double> stock = new HashMap<>();
	        for (BoissonNonAlcoolisee boisson : boissonsNonAlcoolisees) {
	            stock.put(boisson.getNom(), boisson.getQuantiteStock());
	        }
	        return stock;
	    }

	    private Map<String, Double> initStockSupplements(List<Supplement> supplements) {
	        Map<String, Double> stock = new HashMap<>();
	        for (Supplement supplement : supplements) {
	            stock.put(supplement.getNom(), supplement.getQuantiteStock());
	        }
	        return stock;
	    }

	    // Méthodes pour déduire une quantité du stock des boissons alcoolisées
	    public void deductFromStockBoissonsAlcoolisees(String boisson, double quantite) {
	        Double b = stockBoissonsAlcoolisees.get(boisson);
	        if (b != null && b >= quantite) {
	            stockBoissonsAlcoolisees.put(boisson, b - quantite);
	        } else {
	            throw new IllegalArgumentException("Stock insuffisant pour " + boisson);
	        }
	    }

	    // Méthodes pour déduire une quantité du stock des boissons non alcoolisées
	    public void deductFromStockBoissonsNonAlcoolisees(String boisson, double quantite) {
	        Double b = stockBoissonsNonAlcoolisees.get(boisson);
	        if (b != null && b >= quantite) {
	            stockBoissonsNonAlcoolisees.put(boisson, b - quantite);
	        } else {
	            throw new IllegalArgumentException("Stock insuffisant pour " + boisson);
	        }
	    }

	    // Méthodes pour déduire une quantité du stock des suppléments
	    public void deductFromStockSupplements(String supplement, double quantite) {
	        Double s = stockSupplements.get(supplement);
	        if (s != null && s >= quantite) {
	            stockSupplements.put(supplement, s - quantite);
	        } else {
	            throw new IllegalArgumentException("Stock insuffisant pour " + supplement);
	        }
	    }
	}