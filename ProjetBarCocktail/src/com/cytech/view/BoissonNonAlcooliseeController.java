package com.cytech.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import com.cytech.MainApp;
import com.cytech.ingredients.BoissonNonAlcoolisee;

public class BoissonNonAlcooliseeController {
    @FXML
    private TableView<BoissonNonAlcoolisee> boissonNATable;
    @FXML
    private TableColumn<BoissonNonAlcoolisee, String> nomBoissonNonAlcoolisee;

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
    

    // Reference to the main application.
    private MainApp mainApp;

    public BoissonNonAlcooliseeController() {
    }

    @FXML
    private void initialize() {
    	nomBoissonNonAlcoolisee.setCellValueFactory(
    			cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
    	
    	boissonNATable.getSelectionModel().selectedItemProperty().addListener(
    				(observable, oldValue, newValue) -> showBoissonNonAlcooliseeDetails(newValue)
    			);
    }

    private void showBoissonNonAlcooliseeDetails(BoissonNonAlcoolisee boisson) {
    	if (boisson != null)
    	{
    		nomLabel.setText(boisson.getNom());
    		contenanceLabel.setText(String.format("%.3f", boisson.getContenance()));
    		prixLabel.setText(String.format("%.3f", boisson.getPrix()));
    		degreAlcoolLabel.setText(String.format("%.3f", boisson.getDegreAlcool()));
    		degreSucreLabel.setText(String.format("%.3f", boisson.getDegreSucre()));     		
    		
    	}
    	else {
    		nomLabel.setText("");
    		contenanceLabel.setText("");
    		prixLabel.setText("");
    		degreAlcoolLabel.setText("");
    		degreSucreLabel.setText("");
    		
    	}
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        boissonNATable.setItems(mainApp.getBoissonNonAlcoolisee());
    	showBoissonNonAlcooliseeDetails(mainApp.getBoissonNonAlcoolisee().getFirst());

    }
    
	@FXML
	private void handleRetour()
	{
		this.mainApp.showCommande();
	}
	
	@FXML
	private void handleAjouter()
	{
		BoissonNonAlcoolisee boissonSelec = boissonNATable.getSelectionModel().getSelectedItem();
		if (boissonSelec == null)
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Pas de sélection");
			alert.setHeaderText("Erreur de sélection");
			alert.setContentText("Veuillez sélectionner une boisson pour la commander");
			
			alert.showAndWait();	
		}
		
		else if (boissonSelec.getQuantiteStock() > boissonSelec.getContenance()) {
			//TODO: petit bug car le stock ne bouge pas et donc on peut commander a l'infini seulement à l'encaissement on aura une erreur
			this.mainApp.panier.add(boissonSelec);
			System.out.println("Boisson ajoutée dans le panier");
		}
		
		else 
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Stock insuffisant");
			alert.setHeaderText("Le stock est insuffisant");
			alert.setContentText("Malheureusement, la boisson séléectionnée n'est plus commandable pour le moment");
			
			alert.showAndWait();
		}
	}
}