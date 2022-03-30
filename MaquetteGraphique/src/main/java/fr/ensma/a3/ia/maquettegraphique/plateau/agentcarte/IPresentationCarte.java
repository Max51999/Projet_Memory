package fr.ensma.a3.ia.maquettegraphique.plateau.agentcarte;

public interface IPresentationCarte {

	public VueCarte getVue();
	public void setVue(IVueCarte v);
	public void change();
	public void cache();
	public PresentationCarte getPresentation();
}
