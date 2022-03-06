package fr.ensma.a3.ia.maquettegraphique;

import fr.ensma.a3.ia.maquettegraphique.connexionserveur.vbox.PresentationConnexionServeur;
import fr.ensma.a3.ia.maquettegraphique.listeparties.vbox.PresentationListePartie;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestListePartie extends Application {

	private Scene scene;
	private PresentationListePartie pres;
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Test Liste");
    	stage.setMinWidth(500);
    	stage.setMinHeight(500);
    	
    	pres = new PresentationListePartie();
    	
    	scene = new Scene((VBox) pres.getVue(), 640,480);
    	stage.setScene(scene);
        stage.show();
		
	}

    public static void main(String[] args) {
        launch();
    }

}
