package fr.ensma.a3.ia.carnetadressesdao;

import java.util.List;
import java.util.Optional;

import fr.ensma.a3.ia.carnetadressesdao.business.Adresse;
import fr.ensma.a3.ia.carnetadressesdao.business.Carnet_Adresses;
import fr.ensma.a3.ia.carnetadressesdao.business.Personne;
import fr.ensma.a3.ia.carnetadressesdao.dao.AdressePoiDAO;
import fr.ensma.a3.ia.carnetadressesdao.dao.IDao;
import fr.ensma.a3.ia.carnetadressesdao.dao.PersonnePoiDAO;
import fr.ensma.a3.ia.carnetadressesdao.dao.entity.AdresseEntity;
import fr.ensma.a3.ia.carnetadressesdao.dao.entity.PersonneEntity;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	/*System.out.println("Elements dans la base :");*/
    	/*IDao<AdresseEntity> adrdao = new AdressePoiDAO();/*
    	List<AdresseEntity> alladr = adrdao.getAll();
    	for(AdresseEntity ad : alladr) {
    		System.out.println(ad);
    	}*/
    	/*AdresseEntity adcherche = new AdresseEntity();
    	adcherche.setNumRue(12);
    	adcherche.setNomRue("rue toulent");
    	adcherche.setCodePostal(91000);
    	adcherche.setNomVille("JavaLand");/*
    	System.out.println("Recherche par valeur de l'élément : " + adcherche);
    	Optional<AdresseEntity> res = adrdao.getByValue(adcherche); 
    	if(res.isPresent()) {
    		System.out.println(res.get());
    	}
    	res = adrdao.getById(1);
    	System.out.println("Recherche par id de l'élément : id=1 ");
    	if(res.isPresent()) {
    		System.out.println(res.get());
    	}
    	AdresseEntity adrajout = new AdresseEntity();
    	adrajout.setNumRue(10);
    	adrajout.setNomRue("toumoche");
    	adrajout.setCodePostal(97000);
    	adrajout.setNomVille("PitonVille");
    	System.out.println("Création de l'element : " + adrajout);
    	adrdao.create(adrajout);
    	adrajout.setNomVille("PythonVille");
    	System.out.println("Update du nom de la ville");
    	adrdao.update(adrajout);
    	System.out.println("Elements dans la base :");
    	alladr = adrdao.getAll();
    	for(AdresseEntity ad : alladr) {
    		System.out.println(ad);
    	}
    	System.out.println("Suppression de l'éméent id = 3");
    	adrdao.delete(adrdao.getById(3).get());
    	System.out.println("Elements dans la base :");
    	alladr = adrdao.getAll();
    	for(AdresseEntity ad : alladr) {
    		System.out.println(ad);
    	}
    	
    	System.out.println("Elements dans la base :");*/
    	/*IDao<PersonneEntity> persdao = new PersonnePoiDAO();
    	persdao.delete(persdao.getById(3).get());
    	/*
    	List<PersonneEntity> allpers = persdao.getAll();
    	for(PersonneEntity pers : allpers) {
    		System.out.println(pers);
    	}
    	PersonneEntity perscherche = new PersonneEntity();
    	perscherche.setNomPers("RICHARD");
    	perscherche.setPrenomPers("Michael");
    	perscherche.setAdressePers_FK(1);
    	System.out.println("Recherche par valeur de l'élément : " + perscherche);
    	Optional<PersonneEntity> re = persdao.getByValue(perscherche); 
    	if(re.isPresent()) {
    		System.out.println(re.get());
    	}
    	re = persdao.getById(1);
    	System.out.println("Recherche par id de l'élément : id=1 ");
    	if(re.isPresent()) {
    		System.out.println(re.get());
    	}*/
    	/*persdao.delete(persdao.getById(3).get());
    	PersonneEntity persajout = new PersonneEntity();
    	persajout.setNomPers("NOM");
    	persajout.setPrenomPers("Prenom");
    	persajout.setAdressePers_FK(2);/*
    	System.out.println("Création de l'element : " + persajout);
    	persdao.create(persajout);
    	persajout.setPrenomPers("NewPrenom");
    	System.out.println("Update du prenom");
    	persdao.update(persajout);
    	System.out.println("Elements dans la base :");
    	allpers = persdao.getAll();
    	for(PersonneEntity pers : allpers) {
    		System.out.println(pers);
    	}
    	System.out.println("Suppression de l'éméent id = 3");
    	persdao.delete(persdao.getById(3).get());
    	System.out.println("Elements dans la base :");
    	allpers = persdao.getAll();
    	for(PersonneEntity pers : allpers) {
    		System.out.println(pers);
    	}*/
    	
    	
    	
    	Carnet_Adresses carnet = new Carnet_Adresses();
    	carnet.lister();
    	Adresse adresse = new Adresse(10, "rue", "ville", 86000);
    	Personne personne = new Personne("Nom","Prenom",adresse);
    	
    	carnet.ajouter(personne);
    	
    	
    	
    	
    	Adresse adresse2 = new Adresse(10, "newrue", "newville", 87000);
    	Personne personne2 = new Personne("Nom","Prenom",adresse2);
    	
    	carnet.modifier(personne, personne2);
    	
    	
    	carnet.supprimer(personne2);
    	carnet.lister();
    }
}
