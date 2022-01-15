package fr.ensma.a3.ia.maquettegraphique.plateau.agentcarte;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VueCarte extends Button implements IVueCarte, EventHandler<ActionEvent> {
	
	
	private IPresentationCarte mediateur;
	
	public VueCarte(IPresentationCarte media) {
		super();
		setMinWidth(50);
		setMinHeight(100);
		mediateur = media;
		addEventHandler(ActionEvent.ACTION, this);
	}

	@Override
	public void handle(ActionEvent event) {
		mediateur.change();
	}

	
	

	
	
	

}
