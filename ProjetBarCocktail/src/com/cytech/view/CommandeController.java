package com.cytech.view;
import com.cytech.ingredients.Boisson;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cytech.MainApp;
import com.cytech.collections.Commande;
import com.cytech.gestionFichiers.GestionCommande;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CommandeController {

	private MainApp mainApp;
	@FXML
	private TableView<Boisson> panierTable;
	@FXML
	private TableColumn<Boisson, String> nomBoissonColumn;
	@FXML
	private TableColumn<Boisson, String> typeBoissonColumn;
	@FXML
	private TableColumn<Boisson, String> prixBoissonColumn;	
	
	
	public CommandeController() {
		super();
	}
	
	@FXML
	private void initialize() {
		nomBoissonColumn.setCellValueFactory(
				cellData -> new SimpleStringProperty( cellData.getValue().getNom()));
		typeBoissonColumn.setCellValueFactory(
				cellData -> new SimpleStringProperty(cellData.getValue().getClass().getSimpleName()));
		prixBoissonColumn.setCellValueFactory(
				cellData -> new SimpleStringProperty(String.valueOf( cellData.getValue().getPrix()))
				);
	}
	
	public void setMainApp(MainApp mainApp) 
	{
		this.mainApp = mainApp;
		panierTable.setItems(mainApp.panier);
	}
	
	@FXML
	private void handleBoissonAButton()
	{
		mainApp.showBoissonAlcoolisee();
	}
	
	@FXML
	private void handleBoissonNAButton()
	{
		mainApp.showBoissonNonAlcoolisee();
	}
	
	@FXML
	private void handleCocktailsButton()
	{
		mainApp.showCocktail();
	}
	
	@FXML
	private void handleSupprimerButton() {
		int selectedIndex = panierTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >=0 ) {
			panierTable.getItems().remove(selectedIndex);
		} else {
			Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Pas de sélection");
            alert.setHeaderText("Aucun article sélectionné");
            

            alert.showAndWait();			
		}
		

	}
	
	@FXML
	private void handleCommandeButton() {
		
		if (mainApp.getConnectedClient().commander(createMapCommande())) {
			Commande commande = mainApp.getConnectedClient().getBarman().getListeCommande().getLast();
			try {
				GestionCommande.enregistrerCommande(commande, "resource/commande.json",mainApp.getBoissonAlcoolisee(), mainApp.getBoissonNonAlcoolisee(), mainApp.getCocktail());
				mainApp.panier.removeAll(mainApp.panier);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} else {
			
			System.out.println("erreur lors de la commande");
		}
		
		
	}
	
	private Map<Boisson, Double> createMapCommande()
	{
		//On créer la map des boissons
		Map<Boisson, Double> mapBoisson = new HashMap<Boisson, Double>();
		for (Boisson boisson : panierTable.getItems()) {
			if (mapBoisson.get(boisson) == null ) {
				mapBoisson.put(boisson, boisson.getContenance());
			}
			else {
				mapBoisson.put(boisson, mapBoisson.get(boisson) + boisson.getContenance());
			}
		}
		return mapBoisson;
	}
	
}
