package fr.ensma.a3.ia.maquettegraphique.connexionserveur.vbox.hbox;

import fr.ensma.a3.ia.maquettegraphique.connexionserveur.vbox.hbox.label.PresentationLabelId;
import fr.ensma.a3.ia.maquettegraphique.connexionserveur.vbox.hbox.textfield.PresentationTextFieldId;

public class PresentationHBox {

	private PresentationLabelId label;
	private PresentationTextFieldId text;
	
	private IVueHBox vue;
	private ModeleHBox modele;
	
	private String name;
	
	public PresentationHBox(String n) {
		name = n;
		
		label = new PresentationLabelId(name);
		text = new PresentationTextFieldId(name);
		vue = new VueHBox(this);
		modele = new ModeleHBox();
	}
	
	public PresentationLabelId getLabel() {
		return label;
	}

	public PresentationTextFieldId getText() {
		return text;
	}
	
	public IVueHBox getVue() {
		return vue;
	}
}
