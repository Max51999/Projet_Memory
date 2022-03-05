package fr.ensma.a3.ia.dao_memory.dao.entity;

/**
 * Entity Joueur
 * @author vitrym
 *
 */
public class JoueurEntity {

	private int idJoueur;
	private String nomJoueur;
	private String prenomJoueur;
	private String mailJoueur;
	private String pseudo;
	
	public final int getIdJoueur() {
		return idJoueur;
	}

	public final void setIdJoueur(final int id) {
		idJoueur = id;
	}
	
	public final String getNomJoueur() {
		return nomJoueur;
	}

	public final void setNomJoueur(final String nomJ) {
		nomJoueur = nomJ;
	}
	
	public final String getPrenomJoueur() {
		return prenomJoueur;
	}

	public final void setPrenomJoueur(final String prenomJ) {
		prenomJoueur = prenomJ;
	}
	
	public final String getMailJoueur() {
		return mailJoueur;
	}

	public final void setMailJoueur(final String mail) {
		mailJoueur = mail;
	}
	
	public final String getPseudo() {
		return pseudo;
	}

	public final void setPseudo(final String p) {
		pseudo = p;
	}
	
	
	
	@Override
	public String toString() {
		return idJoueur + " : " + nomJoueur + " " + prenomJoueur + pseudo;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof JoueurEntity)) {
			return false;
		} else {
			JoueurEntity joueur = (JoueurEntity) obj;
			if ((joueur.getNomJoueur().compareTo(nomJoueur) == 0) && (joueur.getPrenomJoueur().compareTo(prenomJoueur) == 0) 
					&& (joueur.getMailJoueur().compareTo(mailJoueur) == 0) && (joueur.getPseudo().compareTo(pseudo) == 0)) {
				return true;
			} else {
				return false;
			}
		}
	}
}
