package fr.ensma.a3.ia.maquettegraphique.connexionserveur.vbox.hbox.textfield;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class VueTextFieldId extends TextField implements IVueTextFieldId {

	private PresentationTextFieldId idPres;
	
	public VueTextFieldId(PresentationTextFieldId pres) {
		super();
		idPres = pres;
		
	}
}

