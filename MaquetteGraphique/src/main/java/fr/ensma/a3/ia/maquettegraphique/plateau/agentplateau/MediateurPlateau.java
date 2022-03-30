package fr.ensma.a3.ia.maquettegraphique.plateau.agentplateau;

import fr.ensma.a3.ia.maquettegraphique.plateau.agentcarte.IObserverCarte;

public class MediateurPlateau implements IPresentationPlateau {

	private PresentationPlateau presentation;
	private IVuePlateau vue;
	
	public MediateurPlateau(PresentationPlateau pr) {
		presentation = pr;
		vue = new VuePlateau(this);
	}

	@Override
	public PresentationPlateau getPresentation() {
		return presentation;
	}

	public VuePlateau getVue() {
		return (VuePlateau)vue;
	}

	@Override
	public void remove(IObserverCarte Carte) {
		vue.remove(Carte.getPosition());
	}
	
}
