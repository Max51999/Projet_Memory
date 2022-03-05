package fr.ensma.a3.ia.maquettegraphique.connexionserveur.vbox.connexion;

import fr.ensma.a3.ia.maquettegraphique.connexionserveur.vbox.PresentationVBox;

public class PresentationConnexion {

	
	private IVueConnexion vue;
	private ModeleConnexion modele;
	
	private PresentationVBox pres;
	
	public PresentationConnexion() {
		vue = new VueConnexion(this);
		
	}
	
	public void setVBox(PresentationVBox p) {
		pres = p;
	}
	
	public PresentationVBox getVBox() {
		return pres;
	}
	
	public void clique() {
		System.out.println("Connexion en cours");
		pres.clique();
	}

	public IVueConnexion getVue() {
		return vue;
	}
}
