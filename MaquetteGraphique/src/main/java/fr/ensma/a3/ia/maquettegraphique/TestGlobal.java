package fr.ensma.a3.ia.maquettegraphique;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class TestGlobal extends Application {

	private Scene scene;
	private PresentationGlobal global;
	
    @Override
    public void start(Stage stage) {

    	final int initWidth = 900;      //initial width
        final int initHeight = 1800;    //initial height
        

    	
    	stage.setTitle("Test Jeu");
    	
    	
    	global = new PresentationGlobal();
    	global.setStage(stage);
    	
        
    	
        scene = new Scene((FlowPane) global.getVue(),initHeight,initWidth);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}


