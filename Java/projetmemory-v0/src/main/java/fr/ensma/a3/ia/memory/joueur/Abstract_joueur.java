package fr.ensma.a3.ia.memory.joueur;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.a3.ia.memory.interaction.Attente;
import fr.ensma.a3.ia.memory.interaction.IEtatJoueur;
import fr.ensma.a3.ia.memory.interaction.Jeu;
import fr.ensma.a3.ia.memory.jeu.carte.Carte_classique;

/**
 * 
 * @author vitrym
 *
 */
public abstract class Abstract_joueur implements IEtatJoueur {

	private String id;
	private String nom;
	private String prenom;
	private String mail;
	private String pseudo;
	private Integer nb_cartes;
	private Integer nb_tours;
	protected static Integer numero_joueur = 0;
	private List<Carte_classique> liste_carte;
	
	private IEtatJoueur etat_courant;
	private IEtatJoueur en_jeu = new Jeu(this);
	private IEtatJoueur en_attente = new Attente(this);
	
	/**
	 * Constructeur d'un joueur
	 * @param name
	 * @param surname
	 * @param email
	 * @param nickname
	 */
	public Abstract_joueur(String name, String surname, String email, String nickname) {
		numero_joueur += 1;
		nom = surname;
		prenom = name;
		mail = email;
		pseudo = nickname;
		id = "joueur" + numero_joueur;
		nb_cartes = 0;
		nb_tours = 1;
		liste_carte = new ArrayList<Carte_classique>();
		etat_courant = en_attente;
	}
	
	/**
	 * Getter Nom
	 * @return nom
	 */
	public final String getNom() {
		return nom;
	}
	
	/**
	 * Getter Prenom
	 * @return prenom
	 */
	public final String getPrenom() {
		return prenom;
	}
	
	/**
	 * Getter Mail
	 * @return mail
	 */
	public final String getMail() {
		return mail;
	}
	
	/**
	 * Getter Pseudo
	 * @return pseudo
	 */
	public final String getPseudo() {
		return pseudo;
	}
	
	/**
	 * Getter Id
	 * @return id
	 */
	public final String getId() {
		return id;
	}
	
	/**
	 * Getter Nombre de cartes
	 * @return nb_cartes
	 */
	public final Integer getNbCartes() {
		return nb_cartes;
	}
	
	/**
	 * Getter Nombre de tours
	 * @return nb_tours
	 */
	public final Integer getNbTours() {
		return nb_tours;
	}
	
	/**
	 * Getter Numero du joueur
	 * @return numero_joueur
	 */
	public final Integer getNumJoueur() {
		return numero_joueur;
	}
	 
	/**
	 * Setter Nombre de cartes
	 * @param cartes
	 */
	public final void setNbCartes(Integer cartes) {
		nb_cartes = cartes;
	}
	
	/**
	 * Setter Nombre de tours
	 * @param tours
	 */
	public final void setNbTours(Integer tours) {
		nb_tours = tours;
	}
	
	/**
	 * Permet au joueur de retourner une carte
	 */
	public void retourne_carte() {
		// TODO
	}
	
	/**
	 * Vérifie si une paire a été trouvée
	 * 
	 */
	public void paire_trouvee() {
		// TODO
	}
	
	/**
	 * Remet à 0 le nombre de cartes du joueur (fonction activée lorsque le joueur tire la carte mystère Dans_ta_face)
	 * 
	 */
	public void reset() {
		// TODO
	}
	
	/**
	 * Revele toutes les cartes du plateau pendant 5 secondes (fonction activée lorsque le joueur tire la carte mystère Revele_tout)
	 * 
	 */
	public void revele() {
		// TODO
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
