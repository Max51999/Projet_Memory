package fr.ensma.a3.ia.carnetadressesdao.business;

import java.util.Optional;

import fr.ensma.a3.ia.carnetadressesdao.dao.AdressePoiDAO;
import fr.ensma.a3.ia.carnetadressesdao.dao.IDao;
import fr.ensma.a3.ia.carnetadressesdao.dao.entity.AdresseEntity;
import fr.ensma.a3.ia.carnetadressesdao.dao.entity.PersonneEntity;

public class Personne {

	private String nomPers;
	private String prenomPers;
	private Adresse adresse;
	
	
	public Personne(String nom, String prenom, Adresse adr) {
		nomPers = nom;
		prenomPers = prenom;
		adresse = adr;
	}
	
	public final String getNomPers() {
		return nomPers;
	}

	public final void setNomPers(final String nomP) {
		nomPers = nomP;
	}
	
	public final String getPrenomPers() {
		return prenomPers;
	}

	public final void setPrenomPers(final String prenomP) {
		prenomPers = prenomP;
	}
	
	public final Adresse getAdresse() {
		return adresse;
	}
	
	public final void setAdresse(final Adresse ad) {
		adresse = ad;
	}
	
		
	
	
	@Override
	public String toString() {
		return nomPers + " " + prenomPers + " " + adresse.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Personne)) {
			return false;
		} else {
			Personne pers = (Personne) obj;
			if ((pers.getNomPers() == nomPers) && (pers.getPrenomPers().compareTo(prenomPers) == 0)
					&& (adresse.equals(pers.getAdresse()))) {
				return true;
			} else {
				return false;
			}
		}
	}

	

	

	
}
