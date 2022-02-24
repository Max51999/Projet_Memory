package fr.ensma.a3.ia.maquettegraphique.connexionserveur.vbox.connexion;

public class PresentationConnexion {

	
	private IVueConnexion vue;
	private ModeleConnexion modele;
	
	public PresentationConnexion() {
		vue = new VueConnexion(this);
		
	}

	public void clique() {
		System.out.println("Connexion en cours");
	}

	public IVueConnexion getVue() {
		return vue;
	}
}
