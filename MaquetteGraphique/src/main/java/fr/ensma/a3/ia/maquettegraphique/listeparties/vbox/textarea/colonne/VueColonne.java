package fr.ensma.a3.ia.maquettegraphique.listeparties.vbox.textarea.colonne;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;

public class VueColonne extends TextArea implements IVueColonne {
	
	PresentationColonne pres;
	
	public VueColonne(PresentationColonne p) {
		pres = p;
	}

	
}
