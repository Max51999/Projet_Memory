package fr.ensma.a3.ia.maquettegraphique.plateau.agentplateau;

import fr.ensma.a3.ia.maquettegraphique.plateau.agentcarte.IObserverCarte;

public interface IPresentationPlateau {

	public PresentationPlateau getPresentation();

	public void remove(IObserverCarte carte);

}
