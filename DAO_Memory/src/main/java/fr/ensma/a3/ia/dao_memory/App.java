package fr.ensma.a3.ia.dao_memory;

import java.util.List;
import java.util.Optional;

import fr.ensma.a3.ia.dao_memory.dao.IDao;
import fr.ensma.a3.ia.dao_memory.dao.JoueurPoiDAO;
import fr.ensma.a3.ia.dao_memory.dao.entity.JoueurEntity;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	IDao<JoueurEntity> joueurdao = new JoueurPoiDAO();
    	
    	List<JoueurEntity> alljoueur = joueurdao.getAll();
    	
    	System.out.println("Elements dans la base :");
    	for(JoueurEntity joueur : alljoueur) {
    		System.out.println(joueur);
    	}    	
    	
    	JoueurEntity joueurajout2 = new JoueurEntity();
    	joueurajout2.setNomJoueur("NOM");
    	joueurajout2.setPrenomJoueur("Prenom");
    	joueurajout2.setMailJoueur("joueur2@gmail.com");
    	System.out.println("Création de l'element : " + joueurajout2);
    	joueurdao.create(joueurajout2);
    	
    	alljoueur = joueurdao.getAll();
    	System.out.println("Elements dans la base :");
    	for(JoueurEntity joueur : alljoueur) {
    		System.out.println(joueur);
    	}
    	
    	JoueurEntity joueurcherche = new JoueurEntity();
    	joueurcherche.setNomJoueur("Vitry");
    	joueurcherche.setPrenomJoueur("Max");
    	joueurcherche.setMailJoueur("maximilien.vitry@etu.ensma.fr");
    	System.out.println("Recherche par valeur de l'élément : " + joueurcherche);
    	Optional<JoueurEntity> re = joueurdao.getByValue(joueurcherche); 
    	if(re.isPresent()) {
    		System.out.println(re.get());
    	}
    	
    	re = joueurdao.getById(1);
    	System.out.println("Recherche par id de l'élément : id=1 ");
    	if(re.isPresent()) {
    		System.out.println(re.get());
    	}
    	
    	JoueurEntity joueurajout3 = new JoueurEntity();
    	joueurajout3.setNomJoueur("NOM");
    	joueurajout3.setPrenomJoueur("Joueur");
    	joueurajout3.setMailJoueur("joueur3@gmail.com");
    	System.out.println("Création de l'element : " + joueurajout3);
    	joueurdao.create(joueurajout3);
    	joueurajout3.setPrenomJoueur("NewPrenom");
    	System.out.println("Update du prenom");
    	joueurdao.update(joueurajout3);
    	System.out.println("Elements dans la base :");
    	alljoueur = joueurdao.getAll();
    	for(JoueurEntity joueur : alljoueur) {
    		System.out.println(joueur);
    	}
    	System.out.println("Suppression de l'élément id = 3");
    	joueurdao.delete(joueurdao.getById(3).get());
    	System.out.println("Elements dans la base :");
    	alljoueur = joueurdao.getAll();
    	for(JoueurEntity joueur : alljoueur) {
    		System.out.println(joueur);
    	}

    }
}
