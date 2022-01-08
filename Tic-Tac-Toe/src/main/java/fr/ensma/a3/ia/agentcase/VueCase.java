package fr.ensma.a3.ia.agentcase;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VueCase extends Button implements IVueCase, EventHandler<ActionEvent> {
	
	
	private IPresentationCase mediateur;
	Image croix = new Image(getClass().getResource("/croix.png").toString());
	ImageView imgcroix = new ImageView(croix);
	
	Image vide = new Image(getClass().getResource("/vide.png").toString());
	ImageView imgvide = new ImageView(vide);
	
	Image rond = new Image(getClass().getResource("/rond.png").toString());
	ImageView imgrond = new ImageView(rond);
	
	public VueCase(IPresentationCase media) {
		super();
		mediateur = media;
		setGraphic(imgvide);
		addEventHandler(ActionEvent.ACTION, this);
	}

	@Override
	public void handle(ActionEvent event) {
		mediateur.change();
		
	}

	@Override
	public void setCroix() {
		setGraphic(imgcroix);
	}

	@Override
	public void setVide() {
		setGraphic(imgvide);
	}

	@Override
	public void setRond() {
		setGraphic(imgrond);
	}
	
	

	
	
	

}
