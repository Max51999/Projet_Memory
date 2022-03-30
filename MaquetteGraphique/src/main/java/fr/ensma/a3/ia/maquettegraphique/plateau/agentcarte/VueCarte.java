package fr.ensma.a3.ia.maquettegraphique.plateau.agentcarte;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VueCarte extends Button implements IVueCarte, EventHandler<ActionEvent> {
	
	
	private IPresentationCarte mediateur;
	
	
	Image verso;
	ImageView imgverso;
	
	Image recto;
	ImageView imgrecto;
	
	ImageView imgact;
	
	
	public VueCarte(IPresentationCarte media, String nom) {
		super();
		setMinWidth(50);
		setMinHeight(100);
		mediateur = media;
		addEventHandler(ActionEvent.ACTION, this);
		
		verso = new Image(getClass().getResource("/images/dos_carte.png").toString());
		imgverso = new ImageView(verso);
		recto = new Image(getClass().getResource(nom).toString());
		imgrecto = new ImageView(recto);
		setGraphic(imgverso);
		imgact = imgverso;
		imgverso.setFitWidth(90);
        imgverso.setPreserveRatio(true);
        imgrecto.setFitWidth(90);
        imgrecto.setPreserveRatio(true);
	}

	@Override
	public void handle(ActionEvent event) {
		if (imgact == imgverso) {
			retourne();
			
			mediateur.change();
			
		} else {
			mediateur.cache();
		}
		event.consume();
	}
	
	public void retourne() {
		
		if (imgact == imgverso) {
			imgact = imgrecto;
			setGraphic(imgrecto);
		} else {
			imgact = imgverso;
			setGraphic(imgverso);
		}
	}

	public void desactive() {
		System.out.println("Case "+ mediateur.getPresentation().getPosition() + " desactive");
		setDisable(true);
	}

	
	

	
	
	

}
