package fr.ensma.a3.ia.maquettegraphique.connexionserveur.vbox.connexion;

import fr.ensma.a3.ia.maquettegraphique.connexionserveur.vbox.PresentationConnexionServeur;

public class PresentationConnexion {

	
	private IVueConnexion vue;
	private ModeleConnexion modele;
	
	private PresentationConnexionServeur pres;
	
	public PresentationConnexion() {
		vue = new VueConnexion(this);
		
	}
	
	public void setVBox(PresentationConnexionServeur p) {
		pres = p;
	}
	
	public PresentationConnexionServeur getVBox() {
		return pres;
	}
	
	public void clique() {
		System.out.println("Connexion en cours");
		pres.clique();
		pres.clique();
	}

	public IVueConnexion getVue() {
		return vue;
	}
}
