package fr.ensma.a3.ia.agentcase;

import fr.ensma.a3.ia.agentplateau.IObservableCase;
import fr.ensma.a3.ia.agentplateau.PresentationPlateau;

public class PresentationCase implements IObserverCase {
	
	IPresentationCase mediateur;
	private Integer etat;
	private static Integer nombre_case = 0; 
	private Integer numero_case;
	private IObservableCase plateauPres;
	
	public PresentationCase() {
		mediateur = new MediateurCase(this);
		etat = 0;
		nombre_case ++;
		numero_case = nombre_case;
		
	}
	
	public void setPlateau(IObservableCase obs) {
		plateauPres = obs;
	}
	
	public IObservableCase getPlateau() {
		return plateauPres;
	}
	
	public Integer getNumCase() {
		return numero_case;
	}

	public void changement() {
		plateauPres.notifier(this);
		try {
			if (etat == 0) {
				mediateur.croix();
				etat = 1;
			} else if (etat == 1) {
				mediateur.rond();
				etat = 2;
			} else {
				mediateur.vide();
				etat = 0;
			}
			
		} catch (Exception ex) {
			
		}
		
	}

	public MediateurCase getMediateur() {
		return (MediateurCase)mediateur;
	}

	@Override
	public void cliqueCase(IObserverCase ca) {
		System.out.println("Case "+ numero_case + " clique effectué sur la Case" + ca.getNumCase());
	}

	

	
	
}
