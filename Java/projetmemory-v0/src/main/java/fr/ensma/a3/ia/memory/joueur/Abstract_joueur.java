package fr.ensma.a3.ia.memory.joueur;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.a3.ia.memory.jeu.carte.Carte_classique;

/**
 * 
 * @author vitrym
 *
 */
public abstract class Abstract_joueur {

	private String id;
	private String nom;
	private String prenom;
	private String mail;
	private String pseudo;
	private Integer nb_cartes;
	private Integer nb_tours;
	protected static Integer numero_joueur = 1;
	private List<Carte_classique> liste_carte;
	
	/**
	 * Constructeur d'un joueur
	 * @param name
	 * @param surname
	 * @param email
	 * @param nickname
	 */
	public Abstract_joueur(String name, String surname, String email, String nickname) {
		nom = surname;
		prenom = name;
		mail = email;
		pseudo = nickname;
		id = "joueur" + numero_joueur;
		nb_cartes = 0;
		nb_tours = 1;
		numero_joueur += 1;
		liste_carte = new ArrayList<Carte_classique>();
	}
	
	/**
	 * Getter Nom
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Getter Prenom
	 * @return prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 * Getter Mail
	 * @return mail
	 */
	public String getMail() {
		return mail;
	}
	
	/**
	 * Getter Id
	 * @return id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Getter Nombre de cartes
	 * @return nb_cartes
	 */
	public Integer getNbCartes() {
		return nb_cartes;
	}
	
	/**
	 * Getter Nombre de tours
	 * @return nb_tours
	 */
	public Integer getNbTours() {
		return nb_tours;
	}
	
	/**
	 * Getter Numero du joueur
	 * @return numero_joueur
	 */
	public Integer getNumJoueur() {
		return numero_joueur;
	}
	 
	/**
	 * Setter Nombre de cartes
	 * @param cartes
	 */
	public void setNbCartes(Integer cartes) {
		nb_cartes = cartes;
	}
	
	/**
	 * Setter Nombre de tours
	 * @param tours
	 */
	public void setNbTours(Integer tours) {
		nb_tours = tours;
	}
	
	/**
	 * Permet au joueur de retourner une carte
	 */
	public void retourne_carte() {
		// TODO
	}
	
	/**
	 * V�rifie si une paire a �t� trouv�e
	 * 
	 */
	public void paire_trouvee() {
		// TODO
	}
	
	/**
	 * Remet � 0 le nombre de cartes du joueur (fonction activ�e lorsque le joueur tire la carte myst�re Dans_ta_face)
	 * 
	 */
	public void reset() {
		// TODO
	}
	
	/**
	 * Revele toutes les cartes du plateau pendant 5 secondes (fonction activ�e lorsque le joueur tire la carte myst�re Revele_tout)
	 * 
	 */
	public void revele() {
		// TODO
	}
	
}
