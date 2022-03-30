package fr.ensma.a3.ia.maquettegraphique.plateau.agentcarte;


import fr.ensma.a3.ia.maquettegraphique.plateau.agentplateau.IObservableCarte;

public class PresentationCarte implements IObserverCarte {
	
	IPresentationCarte mediateur;
	private Integer etat;
	private static Integer nombre_carte = 0; 
	private Integer numero_carte;
	private IObservableCarte plateauPres;
	private int position;
	
	public PresentationCarte(String nom, Integer pos) {
		mediateur = new MediateurCarte(this, nom);
		etat = 0;
		nombre_carte ++;
		numero_carte = nombre_carte;
		position = pos;
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
	
	public Integer getPosition() {
		return position;
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

	@Override
	public void cache() {
		mediateur.cache();
		System.out.println("La carte "+ position);
	}

	

	

	
	
}
