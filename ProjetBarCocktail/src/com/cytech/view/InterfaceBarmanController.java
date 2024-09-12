package com.cytech.view;
import com.cytech.ingredients.Boisson;

import java.util.HashMap;
import java.util.Map;

import com.cytech.MainApp;
import com.cytech.collections.Commande;
import com.cytech.gestionFichiers.GestionCommande;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class InterfaceBarmanController {

	private MainApp mainApp;
	@FXML
	private TableView<Commande> listeCommande;
	@FXML
	private TableColumn<Commande, String> clientCommandeColumn;
	@FXML
	private TableColumn<Commande, String> contenuCommandeColumn;
	@FXML
	private TableColumn<Commande, String> prixCommandeColumn;
	
	
	public InterfaceBarmanController() {
		super();
	}
	
	@FXML
	private void initialize() {
		clientCommandeColumn.setCellValueFactory(
					cellData -> new SimpleStringProperty( cellData.getValue().getClientCommande())
				);
		contenuCommandeColumn.setCellValueFactory(
					cellData -> new SimpleStringProperty( cellData.getValue().getMapBoissonCommande().toString())
				);
		prixCommandeColumn.setCellValueFactory(
					cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPrixCommande()))
					
						
				);
	}
	
	public void setMainApp(MainApp mainApp) 
	{
		this.mainApp = mainApp;
		listeCommande.setItems(FXCollections.observableArrayList(this.mainApp.getConnectedBarman().listeCommande));
	}
	
	@FXML
	private void handleBoissonAButton()
	{
		mainApp.showBoissonAlcooliseeBarman();
	}
	
	@FXML
	private void handleBoissonNAButton()
	{
		mainApp.showBoissonNonAlcooliseeBarman();
	}
	
	@FXML
	private void handleCocktailsButton()
	{
		mainApp.showCocktailBarman();
	}
	
	@FXML
	private void handleSupprimerButton() {
		int selectedIndex = listeCommande.getSelectionModel().getSelectedIndex();
		if (selectedIndex >=0 ) {
			listeCommande.getItems().remove(selectedIndex);
			
		} else {
			Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Pas de sélection");
            alert.setHeaderText("Aucun article sélectionné");
            

            alert.showAndWait();			
		}
		

	}
	
	@FXML
	private void handleEncaisserButton() {
		int selectedIndex = listeCommande.getSelectionModel().getSelectedIndex();
		if (selectedIndex >=0 ) {
			if (mainApp.getConnectedBarman().encaisserCommande(listeCommande.getItems().get(selectedIndex))) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Caisse");
				alert.setHeaderText("Commande encaissée !");
				alert.showAndWait();
				listeCommande.getItems().remove(selectedIndex);
			}
			
		} else {
			Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Pas de sélection");
            alert.setHeaderText("Aucun article sélectionné");
            

            alert.showAndWait();			
		}	
	}
	
	
}