package fr.ensma.a3.ia.memory.jeu.carte.mystere;

import fr.ensma.a3.ia.memory.jeu.carte.Abstract_carte;

/**
 * 
 * @author vitrym
 *
 */
public class Carte_mystere extends Abstract_carte {

	protected static Integer instance = 0;
	
	/**
	 * Constructeur Carte Myst�re
	 */
	public Carte_mystere(Integer pos) {
		super(pos);
		instance ++;
	}
	
	/**
	 * Getter Instance
	 * @return instance
	 */
	public Integer getInstance() {
		return instance;
	}
	
}
