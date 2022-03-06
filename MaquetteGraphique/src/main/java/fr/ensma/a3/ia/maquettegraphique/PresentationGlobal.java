package fr.ensma.a3.ia.maquettegraphique;

import fr.ensma.a3.ia.maquettegraphique.connexionserveur.vbox.PresentationConnexionServeur;
import fr.ensma.a3.ia.maquettegraphique.listeparties.vbox.PresentationListePartie;
import fr.ensma.a3.ia.maquettegraphique.plateau.agentplateau.PresentationPlateau;
import javafx.stage.Stage;
import javafx.stage.Window;

public class PresentationGlobal {

	private PresentationConnexionServeur connexion;
	private PresentationListePartie liste;
	private PresentationPlateau plateau;
	
	private IVueGlobal vue;
	private ModeleGlobal modele;
	
	private Stage stage;
	
	
	public PresentationGlobal() {
		connexion = new PresentationConnexionServeur();
		connexion.setGlobal(this);
		liste = new PresentationListePartie();
		liste.setGlobal(this);
		plateau = new PresentationPlateau();
		plateau.setGlobal(this);
		
		vue = new VueGlobal(this);
		
	}
	
	public IVueGlobal getVue() {
		return vue;
	}
	
	public PresentationConnexionServeur getConnexionServeur() {
		return connexion;
	}
	
	public PresentationListePartie getListePartie() {
		return liste;
	}
	
	public PresentationPlateau getPlateau() {
		return plateau;
	}

	public Stage getStage() {
		return stage;
	}
	
	public void setStage(Stage s) {
		stage = s;
	}

	public void connexiontoliste() {
		vue.connexiontoliste();
	}

	public void listetoplateau() {
		vue.listetoplateau();
	}
	
	
	
}
