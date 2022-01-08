package fr.ensma.a3.ia;

import fr.ensma.a3.ia.agentcase.IObserverCase;
import fr.ensma.a3.ia.agentplateau.PresentationPlateau;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class AppPlateau extends Application implements IObserverCase {

		private Scene scene;
		private FlowPane root;
		private PresentationPlateau platPres;
		
		
		
	    @Override
	    public void start(Stage stage) {

	    	stage.setTitle("Test Case");
	    	root = new FlowPane(Orientation.HORIZONTAL);
	        root.setAlignment(Pos.TOP_CENTER);
	    	
	        platPres = new PresentationPlateau();
	        root.getChildren().add(platPres.getMediateur().getVue());
	        
	        scene = new Scene(root, 250, 100);
	        stage.setScene(scene);
	        stage.show();
	    }

	    public static void main(String[] args) {
	        launch();
	    }

		@Override
		public void clique() {
			System.out.println("Changement de symbole");
			
		}

	}

