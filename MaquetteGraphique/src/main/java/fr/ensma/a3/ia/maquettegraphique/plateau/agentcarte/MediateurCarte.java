package fr.ensma.a3.ia.maquettegraphique.plateau.agentcarte;

public class MediateurCarte implements IPresentationCarte {

	
	private PresentationCarte presentation;
	private IVueCarte vue;
	
	public MediateurCarte(PresentationCarte pr) {
		presentation = pr;
		vue = new VueCarte(this);
	}

	@Override
	public VueCarte getVue() {
		
		return (VueCarte)vue;
	}

	@Override
	public void setVue(IVueCarte v) {
		vue = v;
		
		
	}

	@Override
	public void change() {
		presentation.changement();
		
	}


	
}
