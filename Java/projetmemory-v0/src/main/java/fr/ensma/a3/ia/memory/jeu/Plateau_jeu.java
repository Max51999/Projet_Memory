package fr.ensma.a3.ia.memory.jeu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.ensma.a3.ia.memory.jeu.carte.Abstract_carte;
import fr.ensma.a3.ia.memory.joueur.Abstract_joueur;

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
	private List<Abstract_joueur> liste_joueur;
	
	/**
	 * Constructeur d'un plateau de jeu
	 */
	public Plateau_jeu() {
		liste_carte = new ArrayList<Abstract_carte>();
		liste_joueur = new ArrayList<Abstract_joueur>();
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
	 * Renvoie le joueur numéro num
	 * @param num
	 * @return Abstract_Joueur
	 */
	public Abstract_joueur getJoueur(Integer num) {
		return liste_joueur.get(num);
	}
	
	/**
	 * Renvoie le carte à la place num
	 * @param num
	 * @return Abstract_Carte
	 */
	public Abstract_carte getCarte(Integer num) {
		return liste_carte.get(num);
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
	public void setPaire(Integer paire) {
		nb_paire = paire;
	}
	
	/**
	 * Permet de choisir la taille du plateau (possiblement entre plusieurs tailles prédéfinis)
	 * @param size
	 * @throws ExceptionTaille
	 */
	public void choix_taille_plateau(ETaille size) throws ExceptionTaille {
		/*System.out.println("Choisir une taille entre petit (30 cartes), moyen (50 cartes) et grand (100 cartes):");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();*/
		if (size == ETaille.petit) {
			setTaille(30);
		} else if (size == ETaille.moyen) {
			setTaille(50);
		} else if (size == ETaille.grand) {
			setTaille(100);
		} else {
			throw new ExceptionTaille("Erreur dans le choix de la taille");
		}
	}
	
	/**
	 * Choix du nombre de paire différentes sur le plateau
	 */
	public void choix_nb_paire() {
		// TODO
	}

	/**
	 * Choix du nombre de cartes mystères (entre 2, 4 et 6)
	 * @param size
	 * @throws ExceptionTaille
	 */
	public void choix_cartes_mystere(ETaille size) throws ExceptionTaille {
		if (size == ETaille.petit) {
			setMystere(2);
		} else if (size == ETaille.moyen) {
			setMystere(4);
		} else if (size == ETaille.grand) {
			setMystere(6);
		} else {
			throw new ExceptionTaille("Erreur dans le choix de la taille");
		}
	}
	
	/**
	 * Initialise une partie
	 */
	public void initialisation() {
		// TODO
	}
	
	/**
	 * Ajoute un joueur à une partie
	 */
	public void ajout_joueur(Abstract_joueur joueur) {
		liste_joueur.add(joueur);
	}
	
	/**
	 * Ajoute une carte sur le plateau
	 * @param carte
	 */
	public void ajout_carte(Abstract_carte carte) {
		liste_carte.add(carte);
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
