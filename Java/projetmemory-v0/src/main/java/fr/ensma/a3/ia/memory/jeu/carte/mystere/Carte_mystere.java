package fr.ensma.a3.ia.memory.jeu.carte.mystere;

/**
 * 
 * @author vitrym
 *
 */
public class Carte_mystere {

	protected static Integer instance = 0;
	
	/**
	 * Constructeur Carte Mystère
	 */
	public Carte_mystere() {
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
