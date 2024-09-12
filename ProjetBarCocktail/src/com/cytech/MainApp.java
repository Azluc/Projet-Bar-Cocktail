package com.cytech;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cytech.collections.Barman;
import com.cytech.collections.Client;
import com.cytech.collections.Commande;
import com.cytech.gestionFichiers.GestionBoissonAlcoolisee;
import com.cytech.ingredients.Boisson;
import com.cytech.ingredients.BoissonSimple;
import com.cytech.ingredients.BoissonAlcoolisee;
import com.cytech.ingredients.BoissonNonAlcoolisee;
import com.cytech.ingredients.Cocktail;
import com.cytech.ingredients.Supplement;
import com.cytech.view.AccueilController;
import com.cytech.view.BoissonAlcooliseeBarmanController;
import com.cytech.view.BoissonAlcooliseeController;
import com.cytech.view.BoissonAlcooliseeEditController;
import com.cytech.view.BoissonNonAlcooliseeBarmanController;
import com.cytech.view.BoissonNonAlcooliseeController;
import com.cytech.view.BoissonNonAlcooliseeEditController;
import com.cytech.view.CocktailBarmanController;
import com.cytech.view.CocktailController;
import com.cytech.view.CocktailEditBarmanController;
import com.cytech.view.CocktailEditClientController;
import com.cytech.view.CommandeController;
import com.cytech.view.ConnexionBarmanController;
import com.cytech.view.ConnexionController;
import com.cytech.view.InscriptionController;
import com.cytech.view.InterfaceBarmanController;


import com.cytech.gestionFichiers.GestionBoissonNonAlcoolisee;
import com.cytech.gestionFichiers.GestionClient;
import com.cytech.gestionFichiers.GestionSupplement;
import com.cytech.gestionFichiers.GestionCocktail;
import com.cytech.gestionFichiers.GestionCommande;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    
    private Client connectedClient; //le client connecté
    
    private Barman connectedBarman;
    private Barman uniqBarman = new Barman("azerty","123");
    
    /**
	 * The data as an observable list of Persons.
	 */
	private ObservableList<BoissonAlcoolisee> boissonAdata = FXCollections.observableArrayList();
	private ObservableList<BoissonNonAlcoolisee> boissonNAdata = FXCollections.observableArrayList();
	private ObservableList<Supplement> supplementData = FXCollections.observableArrayList();
	
	private ObservableList<Cocktail> cocktaildata = FXCollections.observableArrayList();
	
	
	
	private ObservableList<Client> clientData = FXCollections.observableArrayList();
	private ObservableList<Barman> barmanData = FXCollections.observableArrayList();
	
	public ObservableList<Boisson> panier = FXCollections.observableArrayList();
	private Barman barman;

	/**
	 * Constructor
	 */
	public MainApp() {

		clientData.addAll(GestionClient.lectureListeClient());
		
		for (Client client : clientData) {
			client.setBarman(uniqBarman);
		}
		
		barmanData.add(uniqBarman);
		this.initCollections(); // fonction qui permet d'initialiser toute les collections grace aux classes de gestion de fichier

	}
  
	/**
	 * Returns the data as an observable list of Persons. 
	 * @return
	 */
	public ObservableList<BoissonAlcoolisee> getBoissonAlcoolisee() {
		return boissonAdata;
	}
	
	public ObservableList<BoissonNonAlcoolisee> getBoissonNonAlcoolisee() {
		return boissonNAdata;
	}
	
	public ObservableList<Supplement> getSupplement() {
		return supplementData;
	}
	
	public ObservableList<Cocktail> getCocktail() {
		return cocktaildata;
	}
	
	public ObservableList<Client> getClientData() {
		return clientData;
	}
	
	public ObservableList<Barman> getBarmanData() {
		return barmanData;
	}
	

    public Client getConnectedClient() {
		return connectedClient;
	}

    public Barman getConnectedBarman() {
		return connectedBarman;
	}

	public void setConnectedClient(Client connectedClient) {
		this.connectedClient = connectedClient;
	}
	
	public void setConnectedBarman(Barman connectedBarman) {
		this.connectedBarman = connectedBarman;
	}
	

	@Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Accueil");

        initRootLayout();

        showAccueil();
    }
    
    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Shows the person overview inside the root layout.
     */
    public void showAccueil() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Accueil.fxml"));
            AnchorPane accueil = (AnchorPane) loader.load();
            
            AccueilController accueilController = loader.getController();
            accueilController.setMainApp(this);
            // Set person overview into the center of root layout.
            rootLayout.setCenter(accueil);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showClientConnexion() {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(MainApp.class.getResource("view/Connexion.fxml"));
    	try {
			AnchorPane connexion = (AnchorPane) loader.load();
			
			ConnexionController controller = loader.getController();
			controller.setMainApp(this);
			
			rootLayout.setCenter(connexion);
			this.primaryStage.setTitle("Connexion Client");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void showBarmanConnexion() {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(MainApp.class.getResource("view/ConnexionBarman.fxml"));
    	try {
			AnchorPane connexion = (AnchorPane) loader.load();
			
			ConnexionBarmanController controller = loader.getController();
			controller.setMainApp(this);
			
			rootLayout.setCenter(connexion);
			this.primaryStage.setTitle("Connexion Barman");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void showInscription() {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(MainApp.class.getResource("view/Inscription.fxml"));
    	try {
    		AnchorPane inscription = (AnchorPane) loader.load();
    		InscriptionController controller = loader.getController();
    		controller.setMainApp(this);
    		rootLayout.setCenter(inscription);
    		this.primaryStage.setTitle("Inscription Client");
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    public void showCommande() {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(MainApp.class.getResource("view/Commande.fxml"));
    	try {
    		AnchorPane commande = (AnchorPane) loader.load();
    		CommandeController controller = loader.getController();
    		controller.setMainApp(this);
    		rootLayout.setCenter(commande);
    		this.primaryStage.setTitle("Commande Client");
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    public void showInterfaceBarman() {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(MainApp.class.getResource("view/InterfaceBarman.fxml"));
    	try {
    		AnchorPane commande = (AnchorPane) loader.load();
    		InterfaceBarmanController controller = loader.getController();
    		setConnectedBarman(uniqBarman);
    		controller.setMainApp(this);
    		rootLayout.setCenter(commande);
    		this.primaryStage.setTitle("Commandes Barman");
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    
    public void showBoissonAlcoolisee() {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(MainApp.class.getResource("view/BoissonAlcoolisee.fxml"));
    	try {
    		AnchorPane boissonalc = (AnchorPane) loader.load();
    		BoissonAlcooliseeController controller = loader.getController();
    		controller.setMainApp(this);
    		rootLayout.setCenter(boissonalc);
    		this.primaryStage.setTitle("Boissons Alcoolisées - Client");
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    public void showBoissonAlcooliseeBarman() {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(MainApp.class.getResource("view/BoissonAlcooliseeBarman.fxml"));
    	try {
    		AnchorPane boissonalc = (AnchorPane) loader.load();
    		BoissonAlcooliseeBarmanController controller = loader.getController();
    		controller.setMainApp(this);
    		rootLayout.setCenter(boissonalc);
    		this.primaryStage.setTitle("Boissons Alcoolisées - Barman");
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    public void showBoissonNonAlcoolisee() {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(MainApp.class.getResource("view/BoissonNonAlcoolisee.fxml"));
    	try {
    		AnchorPane boissonNonalc = (AnchorPane) loader.load();
    		BoissonNonAlcooliseeController controller = loader.getController();
    		controller.setMainApp(this);
    		rootLayout.setCenter(boissonNonalc);
    		this.primaryStage.setTitle("Boissons Non Alcoolisées - Client");
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    public void showBoissonNonAlcooliseeBarman() {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(MainApp.class.getResource("view/BoissonNonAlcooliseeBarman.fxml"));
    	try {
    		AnchorPane boissonNonalc = (AnchorPane) loader.load();
    		BoissonNonAlcooliseeBarmanController controller = loader.getController();
    		controller.setMainApp(this);
    		rootLayout.setCenter(boissonNonalc);
    		this.primaryStage.setTitle("Boissons Non Alcoolisées - Barman");
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    public void showCocktail() {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(MainApp.class.getResource("view/Cocktails.fxml"));
    	try {
    		AnchorPane cocktail = (AnchorPane) loader.load();
    		CocktailController controller = loader.getController();
    		controller.setMainApp(this);
    		rootLayout.setCenter(cocktail);
    		this.primaryStage.setTitle("Cocktails - Client");
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    public void showCocktailBarman() {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(MainApp.class.getResource("view/CocktailBarman.fxml"));
    	try {
    		AnchorPane cocktail = (AnchorPane) loader.load();
    		CocktailBarmanController controller = loader.getController();
    		controller.setMainApp(this);
    		rootLayout.setCenter(cocktail);
    		this.primaryStage.setTitle("Cocktails - Barman");
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
	}
    
    public boolean showCocktailEditClient(){
    	try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/CocktailEditClient.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            
            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Créer un cocktail - Client");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            

            
            CocktailEditClientController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMainApp(this);
            

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isTerminerClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean showCocktailEditBarman(){
    	try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/CocktailEditBarman.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            
            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Créer un cocktail - Barman");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            

           
            CocktailEditBarmanController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMainApp(this);
            

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isTerminerClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean showBoissonAlcooliseeEdit(BoissonAlcoolisee boisson) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/BoissonAlcooliseeEdit.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Boisson Alcoolisée ");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

           
            BoissonAlcooliseeEditController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setBoissonAlcoolisee(boisson);
            controller.setMainApp(this);
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean showBoissonNonAlcooliseeEdit(BoissonNonAlcoolisee boisson) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/BoissonNonAlcooliseeEdit.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Boisson Non Alcoolisée ");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            BoissonNonAlcooliseeEditController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setBoissonNonAlcoolisee(boisson);
            controller.setMainApp(this);
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public void addClient(String nom, String prenom, String email, String adresse, String mdp, Date date, String phraseSecrete) {
    	//Ajoute un client a la liste des clients
    	clientData.add(new Client(nom, prenom, email, mdp, date, adresse, phraseSecrete));
    	clientData.getLast().setBarman(barman);
    	
    }
    
    public void initCollections() {
    	//On init des array qu'on remplit avec les fichiers
    	ArrayList<BoissonNonAlcoolisee> stockBoissonNonA = GestionBoissonNonAlcoolisee.lectureListeBoissonNonAlcoolisee();
    	ArrayList<BoissonAlcoolisee> stockBoissonA = GestionBoissonAlcoolisee.lectureListeBoissonAlcoolisee();
    	ArrayList<Supplement> stockSupplement = GestionSupplement.lectureListeSupplement();
    	ArrayList<Commande> listeCommande = new ArrayList<Commande>();


    	
    	//on les transforme en observable list pour que l'application fonctionne
    	this.boissonAdata =  FXCollections.observableArrayList(stockBoissonA);
    	this.boissonNAdata = FXCollections.observableArrayList(stockBoissonNonA);
    	this.supplementData = FXCollections.observableArrayList(stockSupplement);
    	
    	//Pour lire les cocktails et les commandes, on a besoin de connaitre toute les boissons
    	ArrayList<BoissonSimple> allBoissons = new ArrayList<BoissonSimple>();
    	// on construit la liste
    	allBoissons.addAll(stockBoissonA);
    	allBoissons.addAll(stockBoissonNonA);
    	
    	//On peut lire les cocktails

    	ArrayList<Cocktail> stockCocktail = GestionCocktail.lectureListeCocktail(allBoissons, stockSupplement);
    	//et les commandes grace au stock des différents ingrédients
    	try {
			listeCommande.addAll(GestionCommande.lireCommandesDuJSON(GestionCommande.COMMANDE_JSON_PATH, stockBoissonA, stockBoissonNonA, stockCocktail));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//on finit de relier les collections au barman pour que ce dernier puisse gérer le stock
    	this.uniqBarman.listeCommande = listeCommande;
    	this.cocktaildata = FXCollections.observableArrayList(stockCocktail);//on transforme la liste de commande
    	this.uniqBarman.listeBoissonSimple = allBoissons;
    	this.uniqBarman.listeCocktail = stockCocktail;
    	this.uniqBarman.listeSupplement = stockSupplement;
    }
    
    
	/**
	 * Returns the main stage.
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

    public static void main(String[] args) {
        launch(args);
    }

	
}