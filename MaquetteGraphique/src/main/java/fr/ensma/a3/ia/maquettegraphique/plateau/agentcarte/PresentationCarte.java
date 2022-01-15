package fr.ensma.a3.ia.maquettegraphique.plateau.agentcarte;


import fr.ensma.a3.ia.maquettegraphique.plateau.agentplateau.IObservableCarte;

public class PresentationCarte implements IObserverCarte {
	
	IPresentationCarte mediateur;
	private Integer etat;
	private static Integer nombre_carte = 0; 
	private Integer numero_carte;
	private IObservableCarte plateauPres;
	
	public PresentationCarte() {
		mediateur = new MediateurCarte(this);
		etat = 0;
		nombre_carte ++;
		numero_carte = nombre_carte;
		
	}
	
	public void setPlateau(IObservableCarte obs) {
		plateauPres = obs;
	}
	
	public IObservableCarte getPlateau() {
		return plateauPres;
	}
	
	public Integer getNumCarte() {
		return numero_carte;
	}

	public void changement() {
		plateauPres.notifier(this);		
	}

	public MediateurCarte getMediateur() {
		return (MediateurCarte)mediateur;
	}

	@Override
	public void cliqueCarte(IObserverCarte ca) {
		System.out.println("Carte "+ numero_carte + " clique effectué sur la Carte" + ca.getNumCarte());
	}

	

	

	
	
}
