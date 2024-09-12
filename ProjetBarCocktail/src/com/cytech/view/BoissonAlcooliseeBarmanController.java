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

public class BoissonAlcooliseeBarmanController {
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
    @FXML
    private Label quantiteStockLabel;

    // Reference to the main application.
    private MainApp mainApp;

    public BoissonAlcooliseeBarmanController() {
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
    		quantiteStockLabel.setText(String.valueOf(boisson.getQuantiteStock()));
    	}
    	else {
    		nomLabel.setText("");
    		contenanceLabel.setText("");
    		prixLabel.setText("");
    		degreAlcoolLabel.setText("");
    		degreSucreLabel.setText("");
    		quantiteStockLabel.setText("");
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
		this.mainApp.showInterfaceBarman();
	}
	
	
	

	@FXML
	private void handleNewBoissonAlcoolisee() {
	    BoissonAlcoolisee tempBoisson = new BoissonAlcoolisee("Nouvelle Boisson", 0., 0., 0., 0., 0.);
	    boolean okClicked = mainApp.showBoissonAlcooliseeEdit(tempBoisson);
	    if (okClicked) {
	        mainApp.getBoissonAlcoolisee().add(tempBoisson);
	    }
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit
	 * details for the selected person.
	 */
	@FXML
	private void handleEditBoissonAlcoolisee() {
	    BoissonAlcoolisee selectedBoisson = boissonATable.getSelectionModel().getSelectedItem();
	    if (selectedBoisson != null) {
	        boolean okClicked = mainApp.showBoissonAlcooliseeEdit(selectedBoisson);
	        if (okClicked) {
	            showBoissonAlcooliseeDetails(selectedBoisson);
	        }

	    } else {
	        // Nothing selected.
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(mainApp.getPrimaryStage());
	        alert.setTitle("Pas de selection");
	        alert.setHeaderText("Aucune boisson sélectionnée");
	        alert.setContentText("Choisissez une boisson du tableau");

	        alert.showAndWait();
	    }
	}

}