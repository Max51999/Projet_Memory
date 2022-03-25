package fr.ensma.a3.ia.maquettegraphique.connexionserveur.vbox.connexion;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class VueConnexion extends Button implements IVueConnexion, EventHandler<MouseEvent> {

	
	private PresentationConnexion pres; 
	
	public VueConnexion(PresentationConnexion p) {
		super("Connexion");
		pres = p;
		addEventHandler(MouseEvent.MOUSE_CLICKED, this);
	}

	@Override
	public void handle(MouseEvent event) {
		pres.clique();
	}
}
