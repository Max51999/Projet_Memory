package fr.ensma.a3.ia.maquettegraphique.listeparties.vbox.textarea.colonne;


public class PresentationColonne {

	private IVueColonne vue;
	private ModeleColonne modele;
	
	private String name;
	
	public PresentationColonne() {
		vue = new VueColonne(this);
	}
	
	public IVueColonne getVue() {
		return vue;
	}

	public void setText(String nom) {
		vue.setText(nom);
	}
	
	
	
}
