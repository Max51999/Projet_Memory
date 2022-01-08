package fr.ensma.a3.ia.agentcase;

public interface IPresentationCase {

	public VueCase getVue();
	public void setVue(IVueCase v);
	public void change();
	public void croix();
	public void rond();
	public void vide();
}
