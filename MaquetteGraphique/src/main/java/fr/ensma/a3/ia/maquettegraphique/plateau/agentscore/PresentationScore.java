package fr.ensma.a3.ia.maquettegraphique.plateau.agentscore;

public class PresentationScore {

	private IVueScore vueScore;
	
	public PresentationScore() {
		vueScore = new VueScore(this);
	}
	
	public IVueScore getVue() {
		return vueScore;
	}
}
