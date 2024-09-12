package com.cytech.view;

import com.cytech.MainApp;
import com.cytech.collections.Client;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;;

public class ConnexionController {

	private MainApp mainApp;
	
	@FXML
	private TextField email;
	@FXML
	private TextField password;
	
	public ConnexionController() {
	}
	
	@FXML
	private void initialize()
	{
		
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	@FXML
	private void handleConnexionButton()
	{
		if (isIdValid(email.getText(), password.getText())) {
			
			mainApp.showCommande();
		}
		else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Login invalid");
			alert.setHeaderText("Veuillez vérifier votre mode de connexion");
			alert.setContentText("Mauvais mot de passe ou email incorrecte");
			alert.showAndWait();
			
		}
		
	}
	
	@FXML
	private void handleInscriptionButton()
	{
		mainApp.showInscription();
	}
	
	private boolean isIdValid(String email, String password) {
		for (Client client : mainApp.getClientData()) {
			if (client.getMotDePasse().equals(password) && client.getEmail().equals(email)) {
				mainApp.setConnectedClient(client);
				return true;
			}
			
		}
		return false;
	}
	
}
