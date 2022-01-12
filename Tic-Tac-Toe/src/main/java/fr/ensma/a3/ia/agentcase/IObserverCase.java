package fr.ensma.a3.ia.agentcase;

import fr.ensma.a3.ia.agentplateau.IObservableCase;

public interface IObserverCase {

	public void setPlateau(IObservableCase obs);

	public MediateurCase getMediateur();

	void cliqueCase(IObserverCase ca);

	public Integer getNumCase();
}
