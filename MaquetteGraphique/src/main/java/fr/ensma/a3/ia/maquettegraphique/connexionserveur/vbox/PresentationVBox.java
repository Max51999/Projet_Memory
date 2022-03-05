package fr.ensma.a3.ia.maquettegraphique.connexionserveur.vbox;

import fr.ensma.a3.ia.maquettegraphique.connexionserveur.vbox.connexion.PresentationConnexion;
import fr.ensma.a3.ia.maquettegraphique.connexionserveur.vbox.hbox.PresentationHBox;

public class PresentationVBox {

	private PresentationHBox nom;
	private PresentationHBox prenom;
	private PresentationHBox pseudo;
	private PresentationHBox mail;
	private PresentationConnexion connexion;
	
	private IVueVBox vue;
	private ModeleVBox modele;
	
	
	public PresentationVBox() {
		
		
		
		nom = new PresentationHBox("Nom");
		prenom = new PresentationHBox("Prénom");
		pseudo = new PresentationHBox("Pseudo");
		mail = new PresentationHBox("Email");
		connexion = new PresentationConnexion();
		vue = new VueVBox(this);
		
		connexion.setVBox(this);
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
	
	public IVueVBox getVue() {
		return vue;
	}

	public void clique() {
		String n,p,m,ps;
		n = nom.getText().getVue().getText();
		p = prenom.getText().getVue().getText();
		m = mail.getText().getVue().getText();
		ps = pseudo.getText().getVue().getText();
		modele.ajoutJoueur(n, p, m, ps);
	}
	
	
	
}
