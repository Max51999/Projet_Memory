package fr.ensma.a3.ia.maquettegraphique.listeparties.vbox;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VueListePartie extends VBox implements IVueListePartie {
	
	private PresentationListePartie pres;
	
	private Label nom; 
	private Label liste; 
	
	public VueListePartie(PresentationListePartie p) {
		super(20);
		pres = p;
		nom = new Label("Bonjour ");
		liste = new Label("Liste des parties : ");
		getChildren().addAll(nom, liste, (HBox) pres.getTextArea().getVue(), (Button) pres.getPartie().getVue());
		
	}

	
}
