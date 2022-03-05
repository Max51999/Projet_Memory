package fr.ensma.a3.ia.maquettegraphique.connexionserveur.vbox;

import java.util.List;

import fr.ensma.a3.ia.dao_memory.dao.IDao;
import fr.ensma.a3.ia.dao_memory.dao.JoueurPoiDAO;
import fr.ensma.a3.ia.dao_memory.dao.entity.JoueurEntity;

public class ModeleVBox {

	private PresentationVBox pres;
	
	private IDao<JoueurEntity> joueurdao = new JoueurPoiDAO();
	
	private List<JoueurEntity> alljoueur = joueurdao.getAll();
	
	public ModeleVBox(PresentationVBox p) {
		pres = p;
	}
	
	public void ajoutJoueur(String nom, String prenom, String mail, String pseudo) {
		JoueurEntity joueurajout = new JoueurEntity();
    	joueurajout.setNomJoueur(nom);
    	joueurajout.setPrenomJoueur(prenom);
    	joueurajout.setMailJoueur(mail);
    	joueurajout.setPseudo(pseudo);
    	
    	joueurdao.create(joueurajout);
    	
    	alljoueur = joueurdao.getAll();
	}
}
