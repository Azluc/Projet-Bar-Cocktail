package com.cytech.ingredients;

import java.util.Map;



public class Cocktail extends Boisson{
    
    private Map<BoissonSimple, Double> mapBoisson;
    private Map<Supplement, Double> mapSupplement;
    
    public Cocktail(String nom, Map<BoissonSimple, Double> mapBoisson, Map<Supplement, Double> mapSupplement ){
        super(nom, 0, 0, 0, 0);
        this.mapBoisson = mapBoisson;
        this.mapSupplement = mapSupplement;
        this.prix = calculerPrix();
        this.contenance = calculerContenance();
        this.degreAlcool = calculerDegreAlcool();
        this.degreSucre = calculerSucre();
        
    }
   


	@Override
	public String toString() {
		return "Cocktail [mapBoisson=" + mapBoisson + ", mapSupplement=" + mapSupplement + ", nom=" + nom
				+ ", contenance=" + contenance + ", prix=" + prix + ", degreAlcool=" + degreAlcool + ", degreSucre="
				+ degreSucre + ", getMapSupplement()=" + getMapSupplement() + ", getMapBoisson()=" + getMapBoisson()
				+ ", calculerPrix()=" + calculerPrix() + ", calculerContenance()=" + calculerContenance()
				+ ", calculerDegreAlcool()=" + calculerDegreAlcool() + ", calculerSucre()=" + calculerSucre()
				+ ", getContenance()=" + getContenance() + ", getPrix()=" + getPrix() + ", getNom()=" + getNom()
				+ ", getDegreAlcool()=" + getDegreAlcool() + ", getDegreSucre()=" + getDegreSucre()
				+ ", estAlcoolisee()=" + estAlcoolisee() + ", toString()=" + super.toString() + "]";
	}





	public Map<Supplement, Double> getMapSupplement() {
        return mapSupplement;
    }

    public void setMapSupplement(Map<Supplement, Double> mapSupplement) {
        this.mapSupplement = mapSupplement;
    }

    public Map<BoissonSimple, Double> getMapBoisson() {
        return mapBoisson;
    }


    public void setMapBoisson(Map<BoissonSimple, Double> mapBoisson) {
        this.mapBoisson = mapBoisson;
    }


    public double calculerPrix()
    {
        double prixCalcB = 0;
        double prixCalcS =0;
        double prixCalc = 0;
        
        for(Map.Entry<BoissonSimple, Double> entry : mapBoisson.entrySet()) {
            // le prix varie en fonction de la quantité de chaque boisson
            prixCalcB += ((entry.getKey().getPrix())*entry.getValue())/entry.getKey().getContenance();
        }
        if(mapSupplement==null) {
			prixCalcS = 0;
		}
		else {
			for(Map.Entry<Supplement, Double> entry : mapSupplement.entrySet()) {
				prixCalcS += ((entry.getKey().getPrix())*entry.getValue());
			}
		}
		
		prixCalc = (prixCalcB+prixCalcS)*1.1;
		return prixCalc;
	}
    
public double calculerContenance()
    {
        double contenanceCalc = 0;
        for(Map.Entry<BoissonSimple, Double> entry : mapBoisson.entrySet()) {
            // somme des contenances
            contenanceCalc += entry.getValue();
        }        
        return contenanceCalc;
    }
    
    public double calculerDegreAlcool()
    {
        double degreAlcoolCalc = 0;
        double sommeDegreAlcool = 0;
        
        for(Map.Entry<BoissonSimple, Double> entry : mapBoisson.entrySet()) {
            // calcul de degré, on commence par la somme pondérée des degrés
            sommeDegreAlcool += entry.getKey().getDegreAlcool()*entry.getValue();
        }
        degreAlcoolCalc = sommeDegreAlcool/contenance;
        return degreAlcoolCalc;
    }
    
    public double calculerSucre()
    {
        double sucreCalc = 0;
        double sommeSucre = 0;
        
        for(Map.Entry<BoissonSimple, Double> entry : mapBoisson.entrySet()) {
            // calcul de degré, on commence par la somme pondérée des degrés
            sommeSucre += entry.getKey().getDegreSucre()*entry.getValue();
        }
        sucreCalc = sommeSucre/contenance;
        return sucreCalc;
    }
    
    public boolean ajouterBoissonAlcoolisee(BoissonAlcoolisee boisson, double quantite) {
    	if(boisson.getQuantiteStock()>=quantite) {
        	if(mapBoisson.containsKey(boisson)) {
        		double quantiteInitiale = mapBoisson.remove(boisson);
        		mapBoisson.put(boisson, quantiteInitiale+quantite);
        		boisson.setQuantiteStock(boisson.getQuantiteStock()-quantite);
        		return true;
        	}
        	
        	else {
        		mapBoisson.put(boisson,quantite);
        		boisson.setQuantiteStock(boisson.getQuantiteStock()-quantite);
        		return true;
        	}
        	}
        	else {
        		System.out.println("Cette boisson n'est plus en stock");
        		return false;
        	}
        	
        }
    
    public boolean ajouterBoissonNonAlcoolisee(BoissonNonAlcoolisee boisson, double quantite) {
    	if(boisson.getQuantiteStock()>=quantite) {
    	if(mapBoisson.containsKey(boisson)) {
    		double quantiteInitiale = mapBoisson.remove(boisson);
    		mapBoisson.put(boisson, quantiteInitiale+quantite);
    		return true;
    	}
    	
    	else {
    		mapBoisson.put(boisson,quantite);
    		return true;
    	}
    	}
    	else {
    		System.out.println("Cette boisson n'est plus en stock");
    		return false;
    	}
    	
    }
    
    public boolean ajouterSupplement(Supplement supplement, double quantite) {
    	if(supplement.getQuantiteStock()>=quantite) {
    		if(mapSupplement.containsKey(supplement)) {
        		double quantiteInitiale = mapSupplement.remove(supplement);
        		mapSupplement.put(supplement, quantiteInitiale+quantite);
        		return true;
        	}
        	
        	else {
        		mapSupplement.put(supplement,quantite);
        		return true;
        	}
    	}
    	else {
    		System.out.println("Ce supplement n'est plus en stock");
    		return false;
    	}
    	
    }
    
    public boolean supprimerBoissonAlcoolisee(BoissonAlcoolisee boisson, double quantite) {
    	
    	if(mapBoisson.containsKey(boisson)) {
    		double quantiteInitiale = mapBoisson.remove(boisson);
    		if((quantiteInitiale-quantite)>=0 && mapBoisson.put(boisson, quantiteInitiale-quantite)==null) {
        		return true;
        	}
    		else {
    			return false;
    		}
    	
    	}
    	else {
    		System.out.println("La boisson alcoolisée selectionnée n'est pas présente dans le cocktail, elle ne peut pas être supprimée") ;  		
    	}
    	return false;
    }
    
    
    public boolean supprimerBoissonNonAlcoolisee(BoissonNonAlcoolisee boisson, double quantite) {
    	if(mapBoisson.containsKey(boisson)) {
    		double quantiteInitiale = mapBoisson.remove(boisson);
    		if((quantiteInitiale-quantite)>=0 && mapBoisson.put(boisson, quantiteInitiale-quantite)==null) {
        		return true;
        	}
    		else {
    			return false;
    		}
    	
    	}
    	else {
    		System.out.println("La boisson non alcoolisée selectionnée n'est pas présente dans le cocktail, elle ne peut pas être supprimée") ;  		
    	}
    	return false;
    }
    	
    public boolean supprimerSupplement(Supplement supplement, double quantite) {
    	
    	if(mapSupplement.containsKey(supplement)) {
    		double quantiteInitiale = mapSupplement.remove(supplement);
    		if((quantiteInitiale-quantite)>=0 && mapSupplement.put(supplement, quantiteInitiale-quantite)==null) {
        		return true;
        	}
    		else {
    			return false;
    		}
    	
    	}
    	else {
    		System.out.println("Ce supplement selectionnée n'est pas présent dans le cocktail ou la quantité selectionnée est trop importante , elle ne peut pas être supprimée") ;  		
    	}
    	return false;
    }
    
    
}