package fr.ensma.a3.ia.maquettegraphique;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class VueGlobal extends FlowPane implements IVueGlobal {

	private PresentationGlobal pres;
	
	public VueGlobal(PresentationGlobal p) {
		pres = p;
		getChildren().add((VBox) pres.getConnexionServeur().getVue());
	}
	
	public void connexiontoliste() {
		getChildren().remove((VBox) pres.getConnexionServeur().getVue());
		getChildren().add((VBox) pres.getListePartie().getVue());
		pres.getStage().sizeToScene();
	}
	
	public void listetoplateau() {
		getChildren().remove((VBox) pres.getListePartie().getVue());
		getChildren().add((GridPane) pres.getPlateau().getMediateur().getVue());
		pres.getStage().sizeToScene();
	}
}
