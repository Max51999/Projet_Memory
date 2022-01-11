package fr.ensma.a3.ia.memory.interaction;

import fr.ensma.a3.ia.memory.joueur.Abstract_joueur;

/**
 * 
 * @author vitrym
 *
 */
public class Etat_joueur implements IEtatJoueur {

	protected Abstract_joueur joueur;
	
	/**
	 * Constructeur Etat_joueur
	 * @param jou
	 */
	public Etat_joueur(Abstract_joueur jou) {
		joueur = jou;
	}
	
	
	@Override
	public void attente() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void jeu() {
		// TODO Auto-generated method stub
		
	}

	
	
}
