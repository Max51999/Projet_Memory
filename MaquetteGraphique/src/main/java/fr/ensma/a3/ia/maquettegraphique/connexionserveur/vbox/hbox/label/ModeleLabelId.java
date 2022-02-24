package fr.ensma.a3.ia.maquettegraphique.connexionserveur.vbox.hbox.label;

public class ModeleLabelId {

	private PresentationLabelId idPres;
	
	private String name;
	
	
	public ModeleLabelId(PresentationLabelId pres) {
		idPres = pres;
		name = idPres.getName();
	}
	
	
	public String getVal() {
		return name;
	}

}
