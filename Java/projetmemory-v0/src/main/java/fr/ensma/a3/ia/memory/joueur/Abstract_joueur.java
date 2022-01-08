package fr.ensma.a3.ia.memory.joueur;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.a3.ia.memory.jeu.carte.Carte_classique;

public abstract class Abstract_joueur {

	private String id;
	private Integer nb_cartes;
	private Integer nb_tours;
	private static Integer numero_joueur = 1;
	private List<Carte_classique> liste_carte;
	
	/**
	 * Constructeur d'un joueur
	 * 
	 */
	public Abstract_joueur() {
		id = "joueur" + numero_joueur;
		nb_cartes = 0;
		nb_tours = 1;
		numero_joueur += 1;
		liste_carte = new ArrayList<Carte_classique>();
	}
	
	public void choix_carte() {}
	
	public void paire_trouvee() {}
	
	public void reset() {}
	
}
