package fr.ensma.a3.ia.maquettegraphique.listeparties.vbox.partie;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BoutonPartie extends Button implements EventHandler<ActionEvent>{
	
	public BoutonPartie() {
		super("Nouvelle Partie !");
		addEventHandler(ActionEvent.ACTION, this);
	}

	@Override
	public void handle(ActionEvent event) {
		
	}

}
