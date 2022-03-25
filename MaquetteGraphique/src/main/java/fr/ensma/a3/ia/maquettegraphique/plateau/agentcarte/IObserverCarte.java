package fr.ensma.a3.ia.maquettegraphique.plateau.agentcarte;

import fr.ensma.a3.ia.maquettegraphique.plateau.agentplateau.IObservableCarte;

public interface IObserverCarte {

	public void setPlateau(IObservableCarte obs);

	public MediateurCarte getMediateur();

	void cliqueCarte(IObserverCarte ca);

	public Integer getNumCarte();
	public Integer getPosition();

	public void cache();
}
