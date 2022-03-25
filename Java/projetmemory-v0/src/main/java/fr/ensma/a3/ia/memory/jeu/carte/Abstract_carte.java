package fr.ensma.a3.ia.memory.jeu.carte;

import fr.ensma.a3.ia.memory.interaction.ICarte;
import fr.ensma.a3.ia.memory.interaction.IEtatCarte;

/**
 * 
 * @author vitrym
 *
 */
public abstract class Abstract_carte implements ICarte, IEtatCarte {

	protected Integer position;
	
	/**
	 * Constructeur carte abstraite
	 */
	public Abstract_carte(Integer pos) {
		position = pos;
	}
	
	/**
	 * Getter Position
	 * @return position
	 */
	public Integer getPosition() {
		return position;
	}
	
	/**
	 * Setter Position
	 * @param pos
	 */
	public void setPosition(Integer pos) {
		position = pos;
	}
	
	/**
	 * 
	 * @param carte
	 */
	
	public void amulette(ICarte carte) {
		// TODO
	}
	

	
	public void visible() {
		// TODO Auto-generated method stub
		
	}

	
	public void retourne() {
		// TODO Auto-generated method stub
		
	}
	
}
