package fr.ensma.a3.ia.maquettegraphique.connexionserveur.vbox;

import java.util.List;
/*
import fr.ensma.a3.ia.dao_memory.dao.IDao;
import fr.ensma.a3.ia.dao_memory.dao.JoueurPoiDAO;
import fr.ensma.a3.ia.dao_memory.dao.entity.JoueurEntity;*/

public class ModeleConnexionServeur {

	private PresentationConnexionServeur pres;
	
	/*private IDao<JoueurEntity> joueurdao = new JoueurPoiDAO();
	
	private List<JoueurEntity> alljoueur = joueurdao.getAll();*/
	
	private String nom;
	private String prenom;
	private String mail;
	private String pseudo;
	
	public ModeleConnexionServeur(PresentationConnexionServeur p) {
		pres = p;
	}

	public void ajoutJoueur(String n, String p, String m, String ps) {
		nom = n;
		prenom = p;
		mail = m;
		pseudo = ps;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public String getMail() {
		return mail;
	}
	
	public String getPseudo() {
		return pseudo;
	}
	/*public void ajoutJoueur(String nom, String prenom, String mail, String pseudo) {
		JoueurEntity joueurajout = new JoueurEntity();
    	joueurajout.setNomJoueur(nom);
    	joueurajout.setPrenomJoueur(prenom);
    	joueurajout.setMailJoueur(mail);
    	joueurajout.setPseudo(pseudo);
    	
    	joueurdao.create(joueurajout);
    	
    	alljoueur = joueurdao.getAll();
	}*/
	
}
