package com.cytech.view;

import com.cytech.ingredients.BoissonAlcoolisee;
import com.cytech.ingredients.BoissonNonAlcoolisee;
import com.cytech.MainApp;
import com.cytech.gestionFichiers.GestionBoissonAlcoolisee;
import com.cytech.gestionFichiers.GestionBoissonNonAlcoolisee;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BoissonNonAlcooliseeEditController {
	
	@FXML
	private TextField nom;
	@FXML
	private TextField contenance;
	@FXML
	private TextField prix;
	@FXML
	private TextField degreAlcool;
	@FXML
	private TextField degreSucre;
	@FXML
	private TextField quantiteStock;
	
	
	private MainApp mainApp;
	private Stage dialogStage;
	private BoissonNonAlcoolisee boisson;
	private boolean okClicked = false;
	
	@FXML
    private void initialize() {
    }
	
	public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
	
	public void setBoissonNonAlcoolisee(BoissonNonAlcoolisee boisson) {
		this.boisson = boisson;
		
		nom.setText(boisson.getNom());
		contenance.setText(Double.toString(boisson.getContenance()));
		prix.setText(Double.toString(boisson.getPrix()));
		degreAlcool.setText(Double.toString(boisson.getDegreAlcool()));
		degreSucre.setText(Double.toString(boisson.getDegreSucre()));
		quantiteStock.setText(Double.toString(boisson.getQuantiteStock()));
	}
	
	public boolean isOkClicked() {
        return okClicked;
    }
	
	@FXML
    private void handleOk() {
        if (isInputValid()) {
            boisson.setNom(nom.getText());
            boisson.setContenance(Double.parseDouble(contenance.getText()));
            boisson.setPrix(Double.parseDouble(prix.getText()));
            boisson.setDegreAlcool(Double.parseDouble(degreAlcool.getText()));
            boisson.setDegreSucre(Double.parseDouble(degreSucre.getText()));
            boisson.setQuantiteStock(Double.parseDouble(quantiteStock.getText()));

            okClicked = true;
            boolean modifie = false;
            for (BoissonNonAlcoolisee b: mainApp.getBoissonNonAlcoolisee()) {
            	if (b.getNom().equals(nom.getText())) {
            		mainApp.getBoissonNonAlcoolisee().set(mainApp.getBoissonNonAlcoolisee().indexOf(b), boisson);
            		modifie = true;
            		GestionBoissonNonAlcoolisee.ecritureToutStock(mainApp.getBoissonNonAlcoolisee());
            		break;
            	}
            }
            if (!modifie) {
            	GestionBoissonNonAlcoolisee.ecritureBoissonNonAlcoolisee(boisson);
            }
            
            
            dialogStage.close();
        }
    }
	
	 @FXML
	    private void handleCancel() {
	        dialogStage.close();
	    }
	
	private boolean isInputValid() {
        String errorMessage = "";

        if (nom.getText() == null || nom.getText().length() == 0) {
            errorMessage += "Nom invalide!\n";
        }
        if (contenance.getText() == null || contenance.getText().length() == 0) {
            errorMessage += "Contenance invalide!\n";}
            else {
                // try to parse the postal code into an int.
                try {
                    Double.parseDouble(contenance.getText());
                } catch (NumberFormatException e) {
                    errorMessage += " Contenance invalide (il faut un double)!\n";
                }
        }
        if (prix.getText() == null || prix.getText().length() == 0) {
            errorMessage += "Prix invalide!\n";}
            else {
                // try to parse the postal code into an int.
                try {
                    Double.parseDouble(prix.getText());
                } catch (NumberFormatException e) {
                    errorMessage += " Prix invalide (il faut un double)!\n";
                }
        }

        if (degreAlcool.getText() == null || degreAlcool.getText().length() == 0) {
            errorMessage += "Degre Alcool invalide!\n";
        } else {
            // try to parse the postal code into an int.
            try {
                Double.parseDouble(degreAlcool.getText());
            } catch (NumberFormatException e) {
                errorMessage += " Degre Alcool invalide (il faut un double)!\n";
            }
        }

        if (degreSucre.getText() == null || degreSucre.getText().length() == 0) {
            errorMessage += "Degre Sucre invalide!\n";
        } else {
            // try to parse the postal code into an int.
            try {
                Double.parseDouble(degreSucre.getText());
            } catch (NumberFormatException e) {
                errorMessage += " Degre Sucre invalide (il faut un double)!\n";
            }
        }
        if (quantiteStock.getText() == null || quantiteStock.getText().length() == 0) {
            errorMessage += "Quantite invalide !\n";
        } else {
            // try to parse the postal code into an int.
            try {
                Double.parseDouble(quantiteStock.getText());
            } catch (NumberFormatException e) {
                errorMessage += " Quantite invalide (il faut un double)!\n";
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
}

	public void setMainApp(MainApp mainApp) {
		// TODO Auto-generated method stub
		this.mainApp=mainApp;
	}
	
}