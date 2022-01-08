package fr.ensma.a3.ia.agentplateau;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.a3.ia.agentcase.PresentationCase;

public class PresentationPlateau {

	private IPresentationPlateau mediateur;
	
	private List<PresentationCase> liste;
	
	private Integer i;
	
	public PresentationPlateau() {
		
		liste = new ArrayList<PresentationCase>();
		for (i=0;i<9;i++) {
			PresentationCase case1 = new PresentationCase();
			liste.add(case1);
		}
		mediateur = new MediateurPlateau(this);
	}
	
	public PresentationCase getCase(Integer i) {
		return liste.get(i);
	}

	public MediateurPlateau getMediateur() {
		return (MediateurPlateau)mediateur;
	}
	
}
