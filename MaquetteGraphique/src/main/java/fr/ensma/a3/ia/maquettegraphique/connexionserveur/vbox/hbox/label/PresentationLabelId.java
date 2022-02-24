package fr.ensma.a3.ia.maquettegraphique.connexionserveur.vbox.hbox.label;

public class PresentationLabelId {

	private IVueLabelId vue;
	private ModeleLabelId modele;
	
	private String name;
	
	public PresentationLabelId(String n) {
		name = n;
		vue = new VueLabelId(this);
		modele = new ModeleLabelId(this);
		
	}
	
	public String getName() {
		return name;
	}
	
	public IVueLabelId getVue() {
		return vue;
	}


	public ModeleLabelId getModele() {
		return modele;
	}
	
}
