package fr.ensma.a3.ia.maquettegraphique.plateau.agentplateau;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.a3.ia.maquettegraphique.PresentationGlobal;
import fr.ensma.a3.ia.maquettegraphique.plateau.agentcarte.IObserverCarte;
import fr.ensma.a3.ia.maquettegraphique.plateau.agentcarte.PresentationCarte;



public class PresentationPlateau implements IObservableCarte {

	
	private PresentationGlobal global;
	private IPresentationPlateau mediateur;
	
	private List<IObserverCarte> liste;
	
	private Integer i;
	
	public PresentationPlateau() {
		
		liste = new ArrayList<IObserverCarte>();
		for (i=0;i<40;i++) {
			IObserverCarte case1 = new PresentationCarte();
			case1.setPlateau(this);
			liste.add(case1);
		}
		mediateur = new MediateurPlateau(this);
	}
	
	public void setGlobal(PresentationGlobal g) {
		global = g;
	}
	
	public PresentationGlobal getGlobal() {
		return global;
	}
	
	public IObserverCarte getCarte(Integer i) {
		return liste.get(i);
	}

	public MediateurPlateau getMediateur() {
		return (MediateurPlateau)mediateur;
	}

	@Override
	public void notifier(IObserverCarte cas) {
		for (IObserverCarte ca : liste) {
			ca.cliqueCarte(cas);
		}
	}
	
	
}
