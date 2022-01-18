package fr.ensma.a3.ia.dao_memory.dao.entity;

import java.util.List;

/**
 * Entity Partie.
 * @author vitrym
 *
 */
public class PartieEntity {

	private int idPartie;
	private List<Integer> liste_joueur;
	private List<Integer> liste_score;
	

	public final int getIdPartie() {
		return idPartie;
	}

	public final void setIdPartie(final int id) {
		idPartie = id;
	}

	public final List<Integer> getListe_joueur() {
		return liste_joueur;
	}

	public final void setListe_joueur(final List<Integer> liste) {
		liste_joueur = liste;
	}

	public final List<Integer> getListe_score() {
		return liste_score;
	}

	public final void setListe_score(final List<Integer> liste) {
		liste_score = liste;
	}
	
	
	@Override
	public String toString() {
		return idPartie + " : " + liste_joueur + " " + liste_score;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof PartieEntity)) {
			return false;
		} else {
			PartieEntity partie = (PartieEntity) obj;
			if (partie.getIdPartie() == idPartie) {
				return true;
			} else {
				return false;
			}
		}
	}

}
