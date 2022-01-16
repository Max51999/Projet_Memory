package fr.ensma.a3.ia.carnetadressesdao.dao.entity;

public class PersonneEntity {

	private int idPers;
	private String nomPers;
	private String prenomPers;
	private int adressePers_FK;
	
	public final int getIdPers() {
		return idPers;
	}

	public final void setIdPers(final int id) {
		idPers = id;
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
	
	public final int getAdressePers_FK() {
		return adressePers_FK;
	}

	public final void setAdressePers_FK(final int adrFK) {
		adressePers_FK = adrFK;
	}
	
	
	@Override
	public String toString() {
		return idPers + " : " + nomPers + " " + prenomPers;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof PersonneEntity)) {
			return false;
		} else {
			PersonneEntity pers = (PersonneEntity) obj;
			if ((pers.getNomPers().compareTo(nomPers) == 0) && (pers.getPrenomPers().compareTo(prenomPers) == 0) 
					&& (pers.getAdressePers_FK() == adressePers_FK)) {
				return true;
			} else {
				return false;
			}
		}
	}
}
