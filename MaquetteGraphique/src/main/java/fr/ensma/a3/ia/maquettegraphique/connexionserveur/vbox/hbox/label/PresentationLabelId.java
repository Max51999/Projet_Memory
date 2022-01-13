package fr.ensma.a3.ia.maquettegraphique.connexionserveur.vbox.hbox.label;

public class PresentationLabelId implements IPresentationLabelId {

	private IVueLabelId vue;
	private ModeleLabelId modele;
	
	public PresentationLabelId() {
		vue = new VueLabelId(this);
		modele = new ModeleLabelId();
	}
	
	
	public IVueLabelId getVue() {
		return vue;
	}
	
}
