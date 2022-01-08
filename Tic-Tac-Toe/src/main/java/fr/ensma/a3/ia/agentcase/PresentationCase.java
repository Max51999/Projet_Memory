package fr.ensma.a3.ia.agentcase;

public class PresentationCase {
	
	IPresentationCase mediateur;
	private Integer etat;
	
	public PresentationCase() {
		mediateur = new MediateurCase(this);
		etat = 0;
	}

	public void changement() {
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

	
	
}
