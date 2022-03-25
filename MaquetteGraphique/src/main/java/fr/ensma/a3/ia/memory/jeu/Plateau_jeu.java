package fr.ensma.a3.ia.memory.jeu;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.a3.ia.maquettegraphique.PresentationGlobal;
import fr.ensma.a3.ia.memory.jeu.carte.Abstract_carte;
import fr.ensma.a3.ia.memory.jeu.carte.Carte_classique;
import fr.ensma.a3.ia.memory.jeu.carte.mystere.Carte_mystere;
import fr.ensma.a3.ia.memory.jeu.carte.mystere.Dans_ta_face;
import fr.ensma.a3.ia.memory.jeu.carte.mystere.Melange_tout;
import fr.ensma.a3.ia.memory.jeu.carte.mystere.Revele_tout;
import fr.ensma.a3.ia.memory.joueur.Abstract_joueur;

/**
 * 
 * @author vitrym
 *
 */
public class Plateau_jeu extends Thread {

	private Integer taille;
	private Integer nb_paire;
	private Integer nb_mystere;
	private List<Abstract_carte> liste_carte;
	private List<Abstract_joueur> liste_joueur;
	private List<Integer> liste_position;
	
	private PresentationGlobal global;
	
	/**
	 * Constructeur d'un plateau de jeu
	 */
	public Plateau_jeu() {
		liste_carte = new ArrayList<Abstract_carte>();
		liste_joueur = new ArrayList<Abstract_joueur>();
		liste_position = new ArrayList<Integer>();
	}
	
	public void setGlobal(PresentationGlobal p) {
		global = p;
	}
	
	/**
	 * Getter Nombre de paire 
	 * @return nb_paire
	 */
	public Integer getPaire() {
		return nb_paire;
	}
	
	
	/**
	 * Getter Nombre de cartes myst�re
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
	 * Renvoie le joueur num�ro num
	 * @param num
	 * @return Abstract_Joueur
	 */
	public Abstract_joueur getJoueur(Integer num) {
		return liste_joueur.get(num);
	}
	
	
	/**
	 * Renvoie le carte � la place num
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
	 * Permet de choisir la taille du plateau (possiblement entre plusieurs tailles pr�d�finis)
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
		int i;
		for (i=1;i<=taille;i++) {
			liste_position.add(i);
		}
	}
	
	
	/**
	 * Choix du nombre de paire diff�rentes sur le plateau
	 * @throws ExceptionTaille 
	 */
	public void choix_nb_paire(ETaille size) throws ExceptionTaille {
		if (size == ETaille.petit) {
			setPaire(14);
		} else if (size == ETaille.moyen) {
			setPaire(20);
		} else if (size == ETaille.grand) {
			setPaire(30);
		} else {
			throw new ExceptionTaille("Erreur dans le choix de la taille");
		}
	}

	
	/**
	 * Choix du nombre de cartes myst�res (entre 2, 4 et 6)
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
	public void initialisation(ETaille size) {
		try {
			choix_taille_plateau(size);
			choix_cartes_mystere(size);
			choix_nb_paire(size);
		} catch (ExceptionTaille e) {
			e.printStackTrace();
		}
		
		int i;
		int c_paire = 1;
		int c_carte = 1;
		int c_mystere = 1;
		for (i=0;i<taille;i++) {
			Abstract_carte c;
			int random = (int)(Math.random()*(taille-i));
			if (i<nb_mystere) {
				if (c_mystere == 1) {
					c = new Dans_ta_face(liste_position.get(random));
					c_mystere ++;
				} else if (c_mystere == 2) {
					c= new Revele_tout(liste_position.get(random));
					c_mystere ++;
				} else {
					c = new Melange_tout(liste_position.get(random));
					c_mystere = 1;
				}
			} else {
				c = new Carte_classique(liste_position.get(random),c_paire);
				if (c_carte == 1) {
					c_carte ++;
				} else {
					c_carte --;
					if (c_paire == nb_paire) {
						c_paire = 1;
					} else {
						c_paire ++;
					}
				}
			}
			ajout_carte(c);
			liste_position.remove(random);
		}
	}
	
	
	
	
	/**
	 * Ajoute un joueur � une partie
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
	 * Revele le plateau � un joueur
	 * @param abstract_joueur 
	 */
	public void revele(Abstract_joueur abstract_joueur) {
		for (Abstract_carte c : liste_carte) {
			c.retourne();
		}
	}
	
	/**
	 * Melange les cartes sur le plateau
	 */
	public void melange() {
		liste_position = new ArrayList<Integer>();
		for (Abstract_carte i : liste_carte) {
			liste_position.add(i.getPosition());
		}
		int taille = liste_position.size();
		int i;
		for (i=1;i<=taille;i++) {
			int random = 1 + (int)(Math.random()*(taille-i)+1);
			liste_carte.get(i).setPosition(liste_position.get(random));
			liste_position.remove(random);
		}
	}
	
	/**
	 * Met fin � la partie
	 */
	public boolean fin_partie() {
		if (liste_carte.size() == 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public void run() {
		while (!fin_partie()) {
			
		}
	}


	public List<Abstract_carte> getListeCarte() {
		return liste_carte;
	}


	public void remove(Abstract_carte carte) {
		liste_carte.remove(carte);
		
	}


	public void cache(int i) {
		global.getPlateau().getCarte(i).cache();
	}

	public void choix_carte(Integer numCarte) {
		liste_joueur.get(0).retourne_carte(numCarte);
	}
	
	
}
