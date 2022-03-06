package fr.ensma.a3.ia.maquettegraphique.listeparties.vbox.partie;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VuePartie extends Button implements IVuePartie, EventHandler<ActionEvent>{
	
	PresentationPartie pres;
	
	public VuePartie(PresentationPartie p) {
		super("Nouvelle Partie !");
		pres = p;
		addEventHandler(ActionEvent.ACTION, this);
	}

	@Override
	public void handle(ActionEvent event) {
		pres.clique();
	}
}
