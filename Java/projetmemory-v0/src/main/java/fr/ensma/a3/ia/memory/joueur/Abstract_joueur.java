package fr.ensma.a3.ia.memory.joueur;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.a3.ia.memory.interaction.Attente;
import fr.ensma.a3.ia.memory.interaction.IEtatJoueur;
import fr.ensma.a3.ia.memory.interaction.Jeu;
import fr.ensma.a3.ia.memory.jeu.Plateau_jeu;
import fr.ensma.a3.ia.memory.jeu.carte.Abstract_carte;
import fr.ensma.a3.ia.memory.jeu.carte.Carte_classique;

/**
 * 
 * @author vitrym
 *
 */
public abstract class Abstract_joueur extends Thread implements IEtatJoueur {

	private String id;
	private String nom;
	private String prenom;
	private String mail;
	private String pseudo;
	private Integer nb_cartes;
	private Integer nb_tours;
	protected static Integer numero_joueur = 0;
	private List<Carte_classique> liste_carte;
	private Abstract_carte carte1;
	private Abstract_carte carte2;
	
	private IEtatJoueur etat_courant;
	private IEtatJoueur en_jeu = new Jeu(this);
	private IEtatJoueur en_attente = new Attente(this);
	
	private Plateau_jeu plateau;
	
	/**
	 * Constructeur d'un joueur
	 * @param name
	 * @param surname
	 * @param email
	 * @param nickname
	 */
	public Abstract_joueur(String name, String surname, String email, String nickname, Plateau_jeu p) {
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
		plateau = p;
		plateau.ajout_joueur(this);
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
	public void retourne_carte1(int i) {
		carte1 = plateau.getCarte(i);
	}
	
	/**
	 * Permet au joueur de retourner une carte
	 */
	public void retourne_carte2(int i) {
		carte1 = plateau.getCarte(i);
	}
	
	/**
	 * V�rifie si une paire a �t� trouv�e
	 * 
	 */
	public void paire_trouvee(Carte_classique c1, Carte_classique c2) {
		if (c1.getNumero() == c2.getNumero()) {
			ajout_carte(c1);
			ajout_carte(c2);
			nb_cartes += 2;
		}
	}
	
	/**
	 * Ajoute une paire dans la main du joueur
	 * @param carte
	 */
	public void ajout_carte(Carte_classique carte) {
		liste_carte.add(carte);
	}
	
	/**
	 * Remet � 0 le nombre de cartes du joueur (fonction activ�e lorsque le joueur tire la carte myst�re Dans_ta_face)
	 * 
	 */
	public void reset() {
		for (Carte_classique c:liste_carte) {
			plateau.ajout_carte(c);
			nb_cartes --;
		}
		plateau.melange();
	}
	
	/**
	 * Revele toutes les cartes du plateau pendant 5 secondes (fonction activ�e lorsque le joueur tire la carte myst�re Revele_tout)
	 * 
	 */
	public void revele() {
		plateau.revele(this);
	}
	
	
	public void attente() {
		// TODO Auto-generated method stub
		
	}

	
	/**
	 * Permet au joueur d'effectuer un tour de jeu
	 */
	@Override
	public void run() {
		while(nb_tours>0) {
			
			nb_tours --;
			
		}
		
	}
	
}
