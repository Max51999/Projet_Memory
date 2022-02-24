package fr.ensma.a3.ia.maquettegraphique.connexionserveur.vbox.hbox.textfield;

public class PresentationTextFieldId {

	private IVueTextFieldId vue;
	private ModeleTextFieldId modele;
	
	private String name;
	
	public PresentationTextFieldId(String n) {
		vue = new VueTextFieldId(this);
		modele = new ModeleTextFieldId();
		name = n;
	}
	
	
	public IVueTextFieldId getVue() {
		return vue;
	}


	public ModeleTextFieldId getModele() {
		return modele;
	}
	
}
