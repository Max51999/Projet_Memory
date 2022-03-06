package fr.ensma.a3.ia.maquettegraphique.listeparties.vbox.textarea;

import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;

public class VueTextArea extends HBox implements IVueTextArea {
	
	PresentationTextArea pres;
	
	public VueTextArea(PresentationTextArea p) {
		super(0);
		pres = p;
		getChildren().addAll((TextArea) pres.getPartie().getVue(),(TextArea) pres.getDiff().getVue(), (TextArea) pres.getNbJoueur().getVue()); 
	}
	
}
