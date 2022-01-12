package fr.ensma.a3.ia.agentplateau;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.a3.ia.agentcase.IObserverCase;
import fr.ensma.a3.ia.agentcase.PresentationCase;

public class PresentationPlateau implements IObservableCase {

	private IPresentationPlateau mediateur;
	
	private List<IObserverCase> liste;
	
	private Integer i;
	
	public PresentationPlateau() {
		
		liste = new ArrayList<IObserverCase>();
		for (i=0;i<9;i++) {
			IObserverCase case1 = new PresentationCase();
			case1.setPlateau(this);
			liste.add(case1);
		}
		mediateur = new MediateurPlateau(this);
	}
	
	public IObserverCase getCase(Integer i) {
		return liste.get(i);
	}

	public MediateurPlateau getMediateur() {
		return (MediateurPlateau)mediateur;
	}

	@Override
	public void notifier(IObserverCase cas) {
		for (IObserverCase ca : liste) {
			ca.cliqueCase(cas);
		}
	}
	
	
}
