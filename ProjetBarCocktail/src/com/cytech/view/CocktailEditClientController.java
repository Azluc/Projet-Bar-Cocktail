package com.cytech.view;
import java.util.HashMap;
import java.util.Map;

import com.cytech.MainApp;

import com.cytech.ingredients.Cocktail;
import com.cytech.ingredients.Supplement;
import com.cytech.ingredients.BoissonAlcoolisee;
import com.cytech.ingredients.BoissonNonAlcoolisee;
import com.cytech.ingredients.BoissonSimple;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CocktailEditClientController {
	
	@FXML
    private TableView<BoissonAlcoolisee> boissonATable;
    @FXML
    private TableColumn<BoissonAlcoolisee, String> nomBoissonAlcoolisee;
    
    @FXML
    private TableView<BoissonNonAlcoolisee> boissonNATable;
    @FXML
    private TableColumn<BoissonNonAlcoolisee, String> nomBoissonNonAlcoolisee;
    
    @FXML
    private TableView<Supplement> supplementTable;
    @FXML
    private TableColumn<Supplement, String> nomSupplement;

	@FXML
	private TextField contenanceBA;
	@FXML
	private TextField contenanceBNA;
	@FXML
	private TextField quantiteS;
	
	private Stage dialogStage;
	
	private MainApp mainApp;
	
	private Cocktail cocktail ;
	private Cocktail creation;
	
	private boolean terminerClicked = false;
	
	
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	nomBoissonAlcoolisee.setCellValueFactory(
    			cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
    	nomBoissonNonAlcoolisee.setCellValueFactory(
    			cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
    	nomSupplement.setCellValueFactory(
    			cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
    	
    	
    }
    
    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    Map<BoissonSimple,Double> mapBoisson = new HashMap<>();
    Map<Supplement,Double> mapSupplement = new HashMap<>();
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        boissonATable.setItems(mainApp.getBoissonAlcoolisee());
        boissonNATable.setItems(mainApp.getBoissonNonAlcoolisee());
        supplementTable.setItems(mainApp.getSupplement());
        
        cocktail =  mainApp.getConnectedClient().creerCocktailClient(mapBoisson, mapSupplement); 
        creation = new Cocktail("Création", cocktail.getMapBoisson(), cocktail.getMapSupplement());
    }
    
    
    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isTerminerClicked() {
        return terminerClicked;
    }
    
    @FXML
    private void handleAjouterBA() {
    	BoissonAlcoolisee boissonSelec = boissonATable.getSelectionModel().getSelectedItem();
    	String contenanceSelecString = contenanceBA.getText();
    	double contenanceSelec = Double.parseDouble(contenanceBA.getText());
    	
		if (boissonSelec == null || contenanceSelecString == null)
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Pas de sélection");
			alert.setHeaderText("Erreur de sélection");
			alert.setContentText("Veuillez sélectionner une boisson et une contenance pour la commander");
			
			alert.showAndWait();	
		}
	
		
		else if (boissonSelec.getQuantiteStock() >= contenanceSelec) {
			creation.ajouterBoissonAlcoolisee(boissonSelec, contenanceSelec);
			contenanceBA.setText(null);


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
    
    @FXML
    private void handleAjouterBNA() {
    	BoissonNonAlcoolisee boissonSelec = boissonNATable.getSelectionModel().getSelectedItem();
    	String contenanceSelecString = contenanceBNA.getText();
    	double contenanceSelec = Double.parseDouble(contenanceBNA.getText());
    	
		if (boissonSelec == null || contenanceSelecString == null)
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Pas de sélection");
			alert.setHeaderText("Erreur de sélection");
			alert.setContentText("Veuillez sélectionner une boisson et une contenance pour la commander");
			
			alert.showAndWait();	
		}
	
		
		else if (boissonSelec.getQuantiteStock() >= contenanceSelec) {
			creation.ajouterBoissonNonAlcoolisee(boissonSelec, contenanceSelec);
			contenanceBNA.setText(null);
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
    
    @FXML
    private void handleAjouterS() {
    	Supplement supplementSelec = supplementTable.getSelectionModel().getSelectedItem();
    	String quantiteSelecString = quantiteS.getText();
    	double quantiteSelec = Double.parseDouble(quantiteS.getText());
    	
		if (supplementSelec == null || quantiteSelecString == null)
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Pas de sélection");
			alert.setHeaderText("Erreur de sélection");
			alert.setContentText("Veuillez sélectionner une boisson et une contenance pour la commander");
			
			alert.showAndWait();	
		}
	
		
		else if (supplementSelec.getQuantiteStock() >= quantiteSelec) {
			creation.ajouterSupplement(supplementSelec, quantiteSelec);
			quantiteS.setText(null);
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
    
    @FXML 
    private void handleTerminer() {
    	
		creation.setPrix(creation.calculerPrix());

    	System.out.println(creation.getPrix());
    	this.mainApp.panier.add(creation);
    	dialogStage.close();
    	this.mainApp.showCommande();
    }
    
    @FXML 
    private void handleAnnuler() {
    	dialogStage.close();
    	
    }
    
    
}
    
    
    

  
    
    

