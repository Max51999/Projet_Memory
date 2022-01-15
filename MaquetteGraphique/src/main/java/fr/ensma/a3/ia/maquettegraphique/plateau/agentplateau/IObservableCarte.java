package fr.ensma.a3.ia.maquettegraphique.plateau.agentplateau;

import fr.ensma.a3.ia.maquettegraphique.plateau.agentcarte.IObserverCarte;

public interface IObservableCarte {

	

	void notifier(IObserverCarte cas);
	
}
