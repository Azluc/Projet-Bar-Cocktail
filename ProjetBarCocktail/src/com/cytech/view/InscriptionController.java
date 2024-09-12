package com.cytech.view;

import java.time.ZoneId;
import java.util.Date;

import com.cytech.MainApp;
import com.cytech.collections.Client;
import com.cytech.gestionFichiers.GestionClient;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class InscriptionController {
		
	
	private MainApp mainApp;
	
		@FXML
		private TextField champNom;
		@FXML
		private TextField champPrenom;
		@FXML
		private TextField champAdresse;
		@FXML
		private TextField champMotDePasse;
		@FXML
		private TextField champEmail;
		@FXML
		private DatePicker champDateNaissance;
		@FXML
		private TextField champPSecrete;
	
		public InscriptionController() {
			
		}
		
		@FXML 
		private void initialize()
		{
			
		}
		
		@FXML
		private void handleInscriptionButton() 
		{
			if(isInputValid()) {
				mainApp.addClient(champNom.getText(), champPrenom.getText(), champEmail.getText(), champAdresse.getText(), champMotDePasse.getText(), Date.from(champDateNaissance.getValue().atStartOfDay(ZoneId.of("Europe/Paris")).toInstant()), champPSecrete.getText());
				GestionClient.ecritureClient(mainApp.getClientData().getLast());
				mainApp.showAccueil();
			}
			else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.initOwner(mainApp.getPrimaryStage());
				alert.setTitle("Inscription impossible");
				alert.setHeaderText("L'inscription n'a pu aboutir");
				alert.setContentText("Veuillez remplir tout les champs et/ou adresse mail déja utilisée");
				alert.showAndWait();
			}
		}
		
		private boolean isInputValid() {
			
			if (champNom.getText() == null || champNom.getText().length() == 0 ||
				champPrenom.getText()  == null || champPrenom.getText().length() == 0 ||
				champAdresse.getText()  == null || champAdresse.getText().length() == 0 ||
				champMotDePasse.getText()  == null || champMotDePasse.getText().length() == 0 ||
				champEmail.getText()  == null || champEmail.getText().length() == 0 ||
				champDateNaissance.getValue()  == null|| 
				champPSecrete.getText()  == null|| champPSecrete.getText().length() == 0) {
				return false;
			}
			else {
				for (Client client : mainApp.getClientData()) {
					if (client.getEmail().equals(champEmail.getText())) {
						return false;
					}
				}
			}
			return true;
		}
		
		public void setMainApp(MainApp mainApp) {
			this.mainApp = mainApp;
		}
		
		
}
