package fr.ensma.a3.ia.memory.jeu;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.a3.ia.memory.jeu.carte.Abstract_carte;

/**
 * 
 * @author vitrym
 *
 */
public class Plateau_jeu {

	private Integer taille;
	private Integer nb_paire;
	private Integer nb_mystere;
	private List<Abstract_carte> liste_carte;
	
	/**
	 * Constructeur d'un plateau de jeu
	 * @param size
	 * @param paire
	 * @param mystere
	 */
	public Plateau_jeu() {
		liste_carte = new ArrayList<Abstract_carte>();
	}
	
	
	/**
	 * Getter Nombre de paire 
	 * @return nb_paire
	 */
	public Integer getPaire() {
		return nb_paire;
	}
	
	/**
	 * Getter Nombre de cartes mystère
	 * @return
	 */
	public Integer getMystere() {
		return nb_mystere;
	}
	
	/**
	 * Getter Taille du plateau
	 * @return taille;
	 */
	public Integer getTaille() {
		return taille;
	}
	
	/**
	 * Setter Taille du plateau
	 * @param size
	 */
	public void setTaille(Integer size) {
		taille = size;
	}
	
	/**
	 * Setter Nombre de carte mystere
	 * @param mystere
	 */
	public void setMystere(Integer mystere) {
		nb_mystere = mystere;
	}
	
	/**
	 * Setter Nombre de paires
	 * @param paire
	 */
	public void getPaire(Integer paire) {
		nb_paire = paire;
	}
	
	/**
	 * Permet de choisir la taille du plateau (possiblement entre plusieurs tailles prédéfinis)
	 */
	public void choix_taille_plateau() {
		// TODO
	}
	
	/**
	 * Choix du nombre de paire différentes sur le plateau
	 */
	public void choix_nb_paire() {
		// TODO
	}

	/**
	 * Choix du nombre de cartes mystères (entre 2, 4 et 6)
	 */
	public void choix_cartes_mystere() {
		// TODO
	}
	
	/**
	 * Permet d'initialiser une partie
	 */
	public void initialisation() {
		// TODO
	}
	
	/**
	 * Permet d'ajouter un joueur à une partie
	 */
	public void ajout_joueur() {
		// TODO
	}
	
	/**
	 * Permet d'ajouter une carte sur le plateau
	 */
	public void ajout_carte() {
		// TODO
	}
	
	/**
	 * Revele le plateau à un joueur
	 */
	public void revele() {
		// TODO
	}
	
	/**
	 * Melange les cartes sur le plateau
	 */
	public void melange() {
		// TODO
	}
	
	/**
	 * Met fin à la partie
	 */
	public void fin_partie() {
		// TODO
	}
	
	
	
}
