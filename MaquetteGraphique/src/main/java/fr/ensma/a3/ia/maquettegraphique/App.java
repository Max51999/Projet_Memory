package fr.ensma.a3.ia.maquettegraphique;

import fr.ensma.a3.ia.maquettegraphique.connexionserveur.vbox.hbox.label.PresentationLabelId;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

	private Scene scene;
	private PresentationLabelId presLab;
	
	
    @Override
    public void start(Stage stage) {

    	presLab = new PresentationLabelId();
    	
    	
        scene = new Scene((Label)presLab.getVue(), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}