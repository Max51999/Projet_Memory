package fr.ensma.a3.ia.memory.interaction;

import fr.ensma.a3.ia.memory.jeu.carte.Abstract_carte;

/**
 * 
 * @author vitrym
 *
 */
public class Etat_carte implements IEtatCarte {

	protected Abstract_carte carte;
	
	/**
	 * Constructeur Etat_carte
	 * @param car
	 */
	public Etat_carte(Abstract_carte car) {
		carte = car;
	}
	
	@Override
	public void visible() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void retourne() {
		// TODO Auto-generated method stub
		
	}

}
