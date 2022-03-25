package fr.ensma.a3.ia.maquettegraphique;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.a3.ia.maquettegraphique.connexionserveur.vbox.PresentationConnexionServeur;
import fr.ensma.a3.ia.maquettegraphique.listeparties.vbox.PresentationListePartie;
import fr.ensma.a3.ia.maquettegraphique.plateau.agentplateau.PresentationPlateau;
import fr.ensma.a3.ia.memory.jeu.ETaille;
import fr.ensma.a3.ia.memory.jeu.Plateau_jeu;
import fr.ensma.a3.ia.memory.joueur.Abstract_joueur;
import fr.ensma.a3.ia.memory.joueur.Joueur_reel;
import javafx.stage.Stage;

public class PresentationGlobal {

	private PresentationConnexionServeur connexion;
	private PresentationListePartie liste;
	private PresentationPlateau plateau;
	
	private Plateau_jeu jeu;
	private List<Abstract_joueur> liste_joueur;
	
	private IVueGlobal vue;
	private ModeleGlobal modele;
	
	private Stage stage;
	
	
	public PresentationGlobal() {
		connexion = new PresentationConnexionServeur();
		connexion.setGlobal(this);
		liste = new PresentationListePartie();
		liste.setGlobal(this);
		
		jeu = new Plateau_jeu();
		jeu.initialisation(ETaille.moyen);
		plateau = new PresentationPlateau(this);
		
		
		vue = new VueGlobal(this);
		
		jeu.start();
		liste_joueur = new ArrayList<Abstract_joueur>();
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
	
	public Plateau_jeu getJeu() {
		return jeu;
	}

	public Stage getStage() {
		return stage;
	}
	
	public void setStage(Stage s) {
		stage = s;
	}

	public void ajout_joueur(Abstract_joueur joueur) {
		liste_joueur.add(joueur);
	}
	
	public void connexiontoliste() {
		vue.connexiontoliste();
		Abstract_joueur joueur;
		joueur = new Joueur_reel(connexion.getModele().getNom(), connexion.getModele().getPrenom(), 
				connexion.getModele().getMail(),connexion.getModele().getPseudo(), jeu);
		ajout_joueur(joueur);
		jeu.ajout_joueur(joueur);
	}

	public void listetoplateau() {
		vue.listetoplateau();
	}

	public void notifier(Integer numCarte) {
		jeu.choix_carte(numCarte);
	}
	
	
	
}
