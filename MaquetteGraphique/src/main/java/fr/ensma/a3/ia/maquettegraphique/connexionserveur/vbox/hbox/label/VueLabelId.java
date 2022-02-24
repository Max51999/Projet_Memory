package fr.ensma.a3.ia.maquettegraphique.connexionserveur.vbox.hbox.label;

import javafx.scene.control.Label;

public class VueLabelId extends Label implements IVueLabelId {

	private PresentationLabelId idPres;
	
	public VueLabelId(PresentationLabelId pres) {
		super();
		idPres = pres;
		setText(pres.getName());
	}
}

