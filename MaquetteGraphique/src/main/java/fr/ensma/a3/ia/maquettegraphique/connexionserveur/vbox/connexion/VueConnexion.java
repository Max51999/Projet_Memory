package fr.ensma.a3.ia.maquettegraphique.connexionserveur.vbox.connexion;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class VueConnexion extends Button implements IVueConnexion, EventHandler<ActionEvent> {

	
	private PresentationConnexion pres; 
	
	public VueConnexion(PresentationConnexion p) {
		super("Connexion");
		pres = p;
		addEventHandler(ActionEvent.ACTION, this);
		
	}

	@Override
	public void handle(ActionEvent event) {
		pres.clique();
	}
}
