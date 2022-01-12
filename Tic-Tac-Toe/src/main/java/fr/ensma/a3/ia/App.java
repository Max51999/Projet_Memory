package fr.ensma.a3.ia;

import fr.ensma.a3.ia.agentcase.IObserverCase;
import fr.ensma.a3.ia.agentcase.PresentationCase;
import fr.ensma.a3.ia.agentcase.VueCase;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

	private Scene scene;
	private FlowPane root;
	private PresentationCase casePres;
	
	
	
    @Override
    public void start(Stage stage) {

    	stage.setTitle("Test Case");
    	root = new FlowPane(Orientation.HORIZONTAL);
        root.setAlignment(Pos.TOP_CENTER);
    	
        casePres = new PresentationCase();
        root.getChildren().add(casePres.getMediateur().getVue());
        
        scene = new Scene(root, 250, 100);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

	

}