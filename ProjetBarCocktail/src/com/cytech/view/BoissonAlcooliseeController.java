package com.cytech.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import com.cytech.MainApp;
import com.cytech.ingredients.BoissonAlcoolisee;

public class BoissonAlcooliseeController {
    @FXML
    private TableView<BoissonAlcoolisee> boissonATable;
    @FXML
    private TableColumn<BoissonAlcoolisee, String> nomBoissonAlcoolisee;

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

    public BoissonAlcooliseeController() {
    }

    @FXML
    private void initialize() {
    	nomBoissonAlcoolisee.setCellValueFactory(
    			cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
    	
    	boissonATable.getSelectionModel().selectedItemProperty().addListener(
    				(observable, oldValue, newValue) -> showBoissonAlcooliseeDetails(newValue)
    			);
    }

    private void showBoissonAlcooliseeDetails(BoissonAlcoolisee boisson) {
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
        boissonATable.setItems(mainApp.getBoissonAlcoolisee());
    	showBoissonAlcooliseeDetails(mainApp.getBoissonAlcoolisee().getFirst());

    }
    
	@FXML
	private void handleRetour()
	{
		this.mainApp.showCommande();
	}
	
	@FXML
	private void handleAjouter()
	{
		BoissonAlcoolisee boissonSelec = boissonATable.getSelectionModel().getSelectedItem();
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