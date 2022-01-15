package fr.ensma.a3.ia.maquettegraphique.plateau.agentscore;

import javafx.scene.control.TextArea;

public class VueScore extends TextArea implements IVueScore {

	private PresentationScore scorePres;
	
	public VueScore(PresentationScore sco) {
		super();
		scorePres = sco;
		
		setPrefHeight(300);
		setPrefWidth(150);
	}
	
	@Override
	public void miseAjour() {
		setText("");
	}
	
	
}
