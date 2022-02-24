package fr.ensma.a3.ia.maquettegraphique;

import fr.ensma.a3.ia.maquettegraphique.plateau.agentplateau.PresentationPlateau;
import fr.ensma.a3.ia.maquettegraphique.plateau.agentscore.PresentationScore;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class TestPlateau extends Application {

	private Scene scene;
	private HBox root;
	private PresentationScore scorePres;
	private PresentationPlateau plateauPres;
	
	
    @Override
    public void start(Stage stage) {

    	stage.setTitle("Test Jeu");
    	stage.setMinWidth(500);
    	stage.setMinHeight(500);
    	root = new HBox();
    	plateauPres = new PresentationPlateau();
    	scorePres = new PresentationScore();
    	
    	root.getChildren().addAll(plateauPres.getMediateur().getVue(), (TextArea)scorePres.getVue());
        scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
