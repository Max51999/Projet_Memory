package fr.ensma.a3.ia.maquettegraphique.connexionserveur.vbox;

import fr.ensma.a3.ia.maquettegraphique.PresentationGlobal;
import fr.ensma.a3.ia.maquettegraphique.connexionserveur.vbox.connexion.PresentationConnexion;
import fr.ensma.a3.ia.maquettegraphique.connexionserveur.vbox.hbox.PresentationHBox;
import fr.ensma.a3.ia.maquettegraphique.listeparties.vbox.PresentationListePartie;

public class PresentationConnexionServeur {

	
	private PresentationGlobal global;
	
	private PresentationHBox nom;
	private PresentationHBox prenom;
	private PresentationHBox pseudo;
	private PresentationHBox mail;
	private PresentationConnexion connexion;
	
	private IVueConnexionServeur vue;
	private ModeleConnexionServeur modele;
	
	
	public PresentationConnexionServeur() {
		
		
		
		nom = new PresentationHBox("Nom");
		prenom = new PresentationHBox("Prénom");
		pseudo = new PresentationHBox("Pseudo");
		mail = new PresentationHBox("Email");
		connexion = new PresentationConnexion();
		vue = new VueConnexionServeur(this);
		modele = new ModeleConnexionServeur(this);
		connexion.setVBox(this);
	}
	
	public void setGlobal(PresentationGlobal g) {
		global = g;
	}
	
	public PresentationGlobal getGlobal() {
		return global;
	}
	
	public PresentationHBox getNom() {
		return nom;
	}
	
	public PresentationHBox getPrenom() {
		return prenom;
	}
	
	public PresentationHBox getPseudo() {
		return pseudo;
	}
	
	public PresentationHBox getMail() {
		return mail;
	}

	public PresentationConnexion getConnexion() {
		return connexion;
	}
	
	public IVueConnexionServeur getVue() {
		return vue;
	}

	public void clique() {
		String n,p,m,ps;
		n = nom.getText().getVue().getText();
		p = prenom.getText().getVue().getText();
		m = mail.getText().getVue().getText();
		ps = pseudo.getText().getVue().getText();
		modele.ajoutJoueur(n, p, m, ps);
		global.connexiontoliste();
	}
	
	
	
}
