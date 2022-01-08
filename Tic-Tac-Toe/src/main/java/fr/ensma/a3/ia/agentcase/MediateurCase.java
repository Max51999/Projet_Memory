package fr.ensma.a3.ia.agentcase;

public class MediateurCase implements IPresentationCase {

	
	private PresentationCase presentation;
	private IVueCase vue;
	
	public MediateurCase(PresentationCase pr) {
		presentation = pr;
		vue = new VueCase(this);
	}

	@Override
	public VueCase getVue() {
		
		return (VueCase)vue;
	}

	@Override
	public void setVue(IVueCase v) {
		vue = v;
		
		
	}

	@Override
	public void change() {
		presentation.changement();
		
	}


	@Override
	public void croix() {
		vue.setCroix();
	}

	@Override
	public void rond() {
		vue.setRond();
	}

	@Override
	public void vide() {
		vue.setVide();
	}
}
