package fr.ensma.a3.ia.maquettegraphique;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class TestGlobal extends Application {

	private Scene scene;
	private PresentationGlobal global;
	
    @Override
    public void start(Stage stage) {

    	stage.setTitle("Test Jeu");
    	stage.setMinWidth(500);
    	stage.setMinHeight(500);
    	
    	global = new PresentationGlobal();
    	global.setStage(stage);
    	
        scene = new Scene((FlowPane) global.getVue(), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
