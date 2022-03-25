package fr.ensma.a3.ia.memory.jeu.carte;

/**
 * 
 * @author vitrym
 *
 */
public class Carte_classique extends Abstract_carte {

	private Integer numero;
	
	/**
	 * Constructeur d'une carte classique
	 * @param num
	 */
	public Carte_classique(Integer pos, Integer num) {
		super(pos);
		numero = num;
	}
	
	/**
	 * Getter Numero
	 * @return numero
	 */
	public Integer getNumero() {
		return numero;
	}
}
