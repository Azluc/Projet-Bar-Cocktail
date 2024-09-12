package com.cytech.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import com.cytech.MainApp;
import com.cytech.ingredients.Cocktail;

public class CocktailController {
    @FXML
    private TableView<Cocktail> cocktailTable;
    @FXML
    private TableColumn<Cocktail, String> nomCocktail;

    @FXML
    private Label nomLabel;
    @FXML
    private Label contenanceLabel;
    @FXML
    private Label prixLabel;
    @FXML
    private Label degreAlcoolLabel;
    @FXML
    private Label degreSucreLabel;
    @FXML 
    private Label mapBoisson;
    @FXML 
    private Label mapSupplement;
    

    // Reference to the main application.
    private MainApp mainApp;

    public CocktailController() {
    }

    @FXML
    private void initialize() {
    	nomCocktail.setCellValueFactory(
    			cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
    	
    	cocktailTable.getSelectionModel().selectedItemProperty().addListener(
    				(observable, oldValue, newValue) -> showCocktailDetails(newValue)
    			);
    }

    private void showCocktailDetails(Cocktail boisson) {
    	if (boisson != null)
    	{
    		nomLabel.setText(boisson.getNom());
    		contenanceLabel.setText(String.valueOf(((boisson.getContenance())*1000)/1000));
    		prixLabel.setText(String.valueOf(((boisson.getPrix())*1000)/1000));
    		degreAlcoolLabel.setText(String.valueOf(((boisson.getDegreAlcool())*1000)/1000));
    		degreSucreLabel.setText(String.valueOf(((boisson.getDegreSucre())*1000)/1000));
    		mapBoisson.setText(String.valueOf(boisson.getMapBoisson()));
    		mapSupplement.setText(String.valueOf(boisson.getMapSupplement()));
    		
    	}
    	else {
    		nomLabel.setText("");
    		contenanceLabel.setText("");
    		prixLabel.setText("");
    		degreAlcoolLabel.setText("");
    		degreSucreLabel.setText("");
    		mapBoisson.setText("");
    		mapSupplement.setText("");
    		
    	}
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        cocktailTable.setItems(mainApp.getCocktail());
    	showCocktailDetails(mainApp.getCocktail().getFirst());

    }
    
	@FXML
	private void handleRetour()
	{
		this.mainApp.showCommande();
	}
	
	@FXML
	private void handleCommander()
	{
		Cocktail boissonSelec = cocktailTable.getSelectionModel().getSelectedItem();
		if (boissonSelec == null)
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Pas de sélection");
			alert.setHeaderText("Erreur de sélection");
			alert.setContentText("Veuillez sélectionner une boisson pour la commander");
			
			alert.showAndWait();	
		}
		else {
			mainApp.panier.add(boissonSelec);
		}
	}
	
	@FXML
	private void handleCreerCocktail()
	{
		
		this.mainApp.showCocktailEditClient();
	}

}

