package fr.ensma.a3.ia.maquettegraphique.listeparties.vbox;

import fr.ensma.a3.ia.maquettegraphique.PresentationGlobal;
import fr.ensma.a3.ia.maquettegraphique.listeparties.vbox.partie.PresentationPartie;
import fr.ensma.a3.ia.maquettegraphique.listeparties.vbox.textarea.PresentationTextArea;

public class PresentationListePartie {

	
	private PresentationGlobal global;
	
	private IVueListePartie vue;
	private ModeleListePartie modele;
	
	private PresentationTextArea area;
	private PresentationPartie partie;
	

	
	public PresentationListePartie() {
		area = new PresentationTextArea();
		partie = new PresentationPartie(); 
		partie.setListePartie(this);
		vue = new VueListePartie(this);
	}
	
	public void setGlobal(PresentationGlobal g) {
		global = g;
	}
	
	public PresentationGlobal getGlobal() {
		return global;
	}
	
	public IVueListePartie getVue() {
		return vue;
	}

	public PresentationTextArea getTextArea() {
		return area;
	}
	
	public PresentationPartie getPartie() {
		return partie;
	}

	public void listetoplateau() {
		global.listetoplateau();
	}
	

	
}
