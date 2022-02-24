package fr.ensma.a3.ia.maquettegraphique.connexionserveur.vbox.hbox;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class VueHBox extends HBox implements IVueHBox {

	private PresentationHBox pres;
	
	public VueHBox(PresentationHBox p) {
		super(10);
		pres = p;
		getChildren().addAll((Label) pres.getLabel().getVue(), (TextField) pres.getText().getVue());
		setAlignment(Pos.CENTER);
	}
}
