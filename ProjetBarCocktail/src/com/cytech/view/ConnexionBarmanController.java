package com.cytech.view;

import com.cytech.MainApp;
import com.cytech.collections.Barman;
import com.cytech.collections.Client;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;;

public class ConnexionBarmanController {
	
	private MainApp mainApp;
	
	@FXML
	private TextField identifiant;
	@FXML
	private TextField password;
	
	public ConnexionBarmanController() {
	}
	
	@FXML
	private void initialize()
	{
		
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	@FXML
	private void handleBarmanConnexionButton()
	{
		if (identifiant.getText().equals("azerty") && password.getText().equals("123")) {
			
			mainApp.showInterfaceBarman();
		}
		else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Login invalid");
			alert.setHeaderText("Veuillez vérifier votre mode de connexion");
			alert.setContentText("Mauvais mot de passe ou identifiant incorrecte");
			alert.showAndWait();
			
		}
		
	}
	
	
	

}

