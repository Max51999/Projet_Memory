package fr.ensma.a3.ia.maquettegraphique.listeparties.vbox.textarea;

import fr.ensma.a3.ia.maquettegraphique.listeparties.vbox.textarea.colonne.PresentationColonne;

public class PresentationTextArea {

	private IVueTextArea vue;
	private ModeleTextArea modele;
	
	private PresentationColonne partie;
	private PresentationColonne diff;
	private PresentationColonne nbjoueur;
	
	public PresentationTextArea() {
		partie = new PresentationColonne();
		partie.setText("Nom de la partie\n--------------\n");
		diff = new PresentationColonne();
		diff.setText("Difficulté\n--------------\n");
		nbjoueur = new PresentationColonne();
		nbjoueur.setText("Nombre de joueur\n--------------\n");
		
		vue = new VueTextArea(this);
		
	}
	
	public IVueTextArea getVue() {
		return vue;
	}

	public PresentationColonne getPartie() {
		return partie;
	}
	
	public PresentationColonne getDiff() {
		return diff;
	}
	
	public PresentationColonne getNbJoueur() {
		return nbjoueur;
	}
	
	
}
