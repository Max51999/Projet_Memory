package fr.ensma.a3.ia.maquettegraphique.listeparties.vbox.partie;

import fr.ensma.a3.ia.maquettegraphique.connexionserveur.vbox.connexion.PresentationConnexion;
import fr.ensma.a3.ia.maquettegraphique.connexionserveur.vbox.hbox.PresentationHBox;
import fr.ensma.a3.ia.maquettegraphique.listeparties.vbox.PresentationListePartie;

public class PresentationPartie {

	private IVuePartie vue;
	private ModelePartie modele;
	
	private PresentationListePartie liste;
	
	public PresentationPartie() {
		vue = new VuePartie(this);
	}
	
	
	public void setListePartie(PresentationListePartie l) {
		liste = l;
	}
	
	public IVuePartie getVue() {
		return vue;
	}

	public void clique() {
		liste.listetoplateau();
	}
	
	
	
}
