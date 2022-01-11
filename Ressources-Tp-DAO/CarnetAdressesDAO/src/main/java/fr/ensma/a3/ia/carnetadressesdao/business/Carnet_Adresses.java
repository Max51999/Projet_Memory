package fr.ensma.a3.ia.carnetadressesdao.business;


import java.util.ArrayList;
import java.util.List;

import fr.ensma.a3.ia.carnetadressesdao.dao.IDao;
import fr.ensma.a3.ia.carnetadressesdao.dao.PersonnePoiDAO;
import fr.ensma.a3.ia.carnetadressesdao.dao.entity.AdresseEntity;
import fr.ensma.a3.ia.carnetadressesdao.dao.entity.PersonneEntity;

public class Carnet_Adresses {
	
	private List<Personne> contacts;
	
	private IDao<PersonneEntity> persdao = new PersonnePoiDAO();
	private List<PersonneEntity> allpers = persdao.getAll();
	
	public Carnet_Adresses() {
		contacts = new ArrayList<Personne>();
		for(PersonneEntity pers : allpers) {
			contacts.add(new Personne(pers));
		}
	}
	
	public void ajouter(Personne pers) {
		contacts.add(pers);
		PersonneEntity persajout = new PersonneEntity();
    	persajout.setNomPers(pers.getNomPers());
    	persajout.setPrenomPers(pers.getPrenomPers());
    	
    	
    	AdresseEntity adrajout = new AdresseEntity();
    	adrajout.setNumRue(pers.getAdresse().getNumRue());
    	adrajout.setNomRue(pers.getAdresse().getNomRue());
    	adrajout.setNomVille(pers.getAdresse().getNomVille());
    	adrajout.setCodePostal(pers.getAdresse().getCodePostal());
    	
    	
    	persajout.setAdressePers_FK(adrajout.getIdAdr());
    	
		persdao.create(persajout);
	}

	
	public String supprimer(Personne pers) {
		contacts.remove(pers);
		PersonneEntity persajout = new PersonneEntity();
    	persajout.setNomPers(pers.getNomPers());
    	persajout.setPrenomPers(pers.getPrenomPers());

    	AdresseEntity adrajout = new AdresseEntity();
    	adrajout.setNumRue(pers.getAdresse().getNumRue());
    	adrajout.setNomRue(pers.getAdresse().getNomRue());
    	adrajout.setNomVille(pers.getAdresse().getNomVille());
    	adrajout.setCodePostal(pers.getAdresse().getCodePostal());
    	persajout.setAdressePers_FK(adrajout.getIdAdr());
    	
		persdao.delete(persajout);
		return pers.toString();
	}

	public void lister() {
		System.out.println("Personne dans le carnet : ");
		for (Personne pers : contacts) {
			System.out.println(pers.toString());
		}
	}
	
	
	public String modifier(Personne perscible,Personne pers) {
		contacts.remove(perscible);
		contacts.add(pers);
		
		PersonneEntity persajout = new PersonneEntity();
		
		persajout.setNomPers(pers.getNomPers());
    	persajout.setPrenomPers(pers.getPrenomPers());
    	
    	AdresseEntity adrajout = new AdresseEntity();
    	adrajout.setNumRue(pers.getAdresse().getNumRue());
    	adrajout.setNomRue(pers.getAdresse().getNomRue());
    	adrajout.setNomVille(pers.getAdresse().getNomVille());
    	adrajout.setCodePostal(pers.getAdresse().getCodePostal());
    	persajout.setAdressePers_FK(adrajout.getIdAdr());
    	
		persdao.update(persajout);
		return pers.toString();
	}
}
