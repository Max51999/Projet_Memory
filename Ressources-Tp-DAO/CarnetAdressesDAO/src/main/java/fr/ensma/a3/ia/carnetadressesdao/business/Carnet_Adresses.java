package fr.ensma.a3.ia.carnetadressesdao.business;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.ensma.a3.ia.carnetadressesdao.dao.AdressePoiDAO;
import fr.ensma.a3.ia.carnetadressesdao.dao.IDao;
import fr.ensma.a3.ia.carnetadressesdao.dao.PersonnePoiDAO;
import fr.ensma.a3.ia.carnetadressesdao.dao.entity.AdresseEntity;
import fr.ensma.a3.ia.carnetadressesdao.dao.entity.PersonneEntity;

public class Carnet_Adresses {
	
	private List<Personne> contacts;
	
	private IDao<PersonneEntity> persdao = new PersonnePoiDAO();
	private List<PersonneEntity> allpers = persdao.getAll();
	
	private IDao<AdresseEntity> adrdao = new AdressePoiDAO();
	private List<AdresseEntity> alladr = adrdao.getAll();
	
	
	
	public Carnet_Adresses() {
		contacts = new ArrayList<Personne>();
		for(PersonneEntity pers : allpers) {
			AdresseEntity adr = adrdao.getById(pers.getAdressePers_FK()).get();
			
			contacts.add(new Personne(pers.getNomPers(),pers.getPrenomPers(),new Adresse(adr.getNumRue(), adr.getNomRue(), adr.getNomVille(), adr.getCodePostal())));
		}
	}
	
	public void ajouter(Personne pers) {
		boolean nouveau = true;
		
		// Personne to PersonnEntity
		PersonneEntity persajout = new PersonneEntity();
    	persajout.setNomPers(pers.getNomPers());
    	persajout.setPrenomPers(pers.getPrenomPers());
    	
    	//Adresse to AdresseEntity
    	AdresseEntity adrajout = new AdresseEntity();
    	adrajout.setNumRue(pers.getAdresse().getNumRue());
    	adrajout.setNomRue(pers.getAdresse().getNomRue());
    	adrajout.setNomVille(pers.getAdresse().getNomVille());
    	adrajout.setCodePostal(pers.getAdresse().getCodePostal());
    	adrajout.setIdAdr(-1);
    	
    	// Verification existence de l'adresse
    	for (AdresseEntity ad : alladr) {
    		if (adrajout.equals(ad)) {
    			adrajout = ad;
    			persajout.setAdressePers_FK(adrajout.getIdAdr());
    		} 
    	}
    	
    	// Ajout d'une nouvelle adresse si inexistante
    	if (persajout.getAdressePers_FK() != adrajout.getIdAdr()) {
    		adrdao.create(adrajout);
    		alladr.add(adrajout);
    		persajout.setAdressePers_FK(adrajout.getIdAdr());
    	}
    	
    	// Verification existence personne
    	for (PersonneEntity per : allpers) {
    		
    		if (persajout.equals(per)) {
    			System.out.println("je suis la");
    			nouveau = false;
    		}
    	}
    	
    	// Ajout nouvelle personne si inexistant
    	if (nouveau) {
    		contacts.add(pers);
    		persdao.create(persajout);
    		allpers.add(persajout);
    	}
    	
    	System.out.println("Ajout de " + pers.toString());
	}

	// Je considere que la personne supprime existe deja
	public void supprimer(Personne pers) {
		
		// Personne to PersonnEntity
		PersonneEntity perssuppr = new PersonneEntity();
		perssuppr.setNomPers(pers.getNomPers());
		perssuppr.setPrenomPers(pers.getPrenomPers());
    	
    	//Adresse to AdresseEntity
    	AdresseEntity adr = new AdresseEntity();
    	adr.setNumRue(pers.getAdresse().getNumRue());
    	adr.setNomRue(pers.getAdresse().getNomRue());
    	adr.setNomVille(pers.getAdresse().getNomVille());
    	adr.setCodePostal(pers.getAdresse().getCodePostal());
    	
    	for (AdresseEntity ad : alladr) {
    		if (adr.equals(ad)) {
    			adr = ad;
    			perssuppr.setAdressePers_FK(adr.getIdAdr());
    		} 
    	}

		contacts.remove(pers);
		
    	
    	Optional<PersonneEntity> res = persdao.getByValue(perssuppr);
    	perssuppr.setIdPers(res.get().getIdPers());
    	persdao.delete(perssuppr);
    	
		System.out.println("Suppression de " + pers.toString());
	}

	public void lister() {
		System.out.println("Personne dans le carnet : ");
		for (Personne pers : contacts) {
			System.out.println(pers.toString());
		}
	}
	
	
	public void modifier(Personne perscible,Personne pers) {
		
	
		// Personne to PersonnEntity
		PersonneEntity persmod = new PersonneEntity();
		persmod.setNomPers(pers.getNomPers());
		persmod.setPrenomPers(pers.getPrenomPers());
    	
		//Adresse to AdresseEntity
    	AdresseEntity adrbase = new AdresseEntity();
    	adrbase.setNumRue(perscible.getAdresse().getNumRue());
    	adrbase.setNomRue(perscible.getAdresse().getNomRue());
    	adrbase.setNomVille(perscible.getAdresse().getNomVille());
    	adrbase.setCodePostal(perscible.getAdresse().getCodePostal());
    	
    	for (AdresseEntity ad : alladr) {
    		if (adrbase.equals(ad)) {
    			adrbase = ad;
    			persmod.setAdressePers_FK(adrbase.getIdAdr());
    		} 
    	}
    	
    	for (PersonneEntity p : allpers) {
    		// Je considere qu'on ne modifie que l'adresse, le nom et le prenom d'une personne etant en theorie invariable
    		if (persmod.equals(p)) {
    			persmod = p;
    		}
    	}
    	
				
    	//Adresse to AdresseEntity
    	AdresseEntity adr = new AdresseEntity();
    	adr.setNumRue(pers.getAdresse().getNumRue());
    	adr.setNomRue(pers.getAdresse().getNomRue());
    	adr.setNomVille(pers.getAdresse().getNomVille());
    	adr.setCodePostal(pers.getAdresse().getCodePostal());
    	
    	for (AdresseEntity ad : alladr) {
    		if (adr.equals(ad)) {
    			adr = ad;
    			persmod.setAdressePers_FK(adr.getIdAdr());
    		} 
    	}
    	
    	if (persmod.getAdressePers_FK() != adr.getIdAdr()) {
    		adrdao.create(adr);
    		alladr.add(adr);
    		persmod.setAdressePers_FK(adr.getIdAdr());
    	}
    	
		contacts.remove(perscible);
		contacts.add(pers);

		persdao.update(persmod);
		allpers = persdao.getAll();
		System.out.println("Modification de " + perscible.toString() + " pour " + pers.toString());
	}
}
