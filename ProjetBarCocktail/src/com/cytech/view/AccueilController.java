package com.cytech.view;



import com.cytech.MainApp;

import javafx.fxml.FXML;

public class AccueilController {
	
	private MainApp mainApp;
	
	public AccueilController() {
		
	}
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void handleClientConnexionButton()
	{
		mainApp.showClientConnexion();
	}
	
	
	@FXML
	private void handleBarmanConnexionButton()
	{
		mainApp.showBarmanConnexion();
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	
	
	
 }