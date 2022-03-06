package fr.ensma.a3.ia.maquettegraphique.connexionserveur.vbox;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VueConnexionServeur extends VBox implements IVueConnexionServeur {

	private PresentationConnexionServeur pres;
	
	private Label label;
	
	public VueConnexionServeur(PresentationConnexionServeur p) {
		super(20);
		pres = p;
		label = new Label("Connexion au jeu Memory");
		getChildren().addAll(label, (HBox) pres.getNom().getVue(), (HBox) pres.getPrenom().getVue(), 
				(HBox) pres.getPseudo().getVue(), (HBox) pres.getMail().getVue(), (Button) pres.getConnexion().getVue());
		setAlignment(Pos.CENTER);
	}
}
