package fr.ensma.a3.ia.maquettegraphique.plateau.agentplateau;



import fr.ensma.a3.ia.maquettegraphique.plateau.agentcarte.IObserverCarte;
import javafx.scene.layout.GridPane;

public class VuePlateau extends GridPane implements IVuePlateau {

	private IPresentationPlateau mediateur;
	private Integer i,j, taille, hauteur, largeur;
	
	public VuePlateau(IPresentationPlateau med) {
		super();
		setPrefHeight(200);
		setPrefWidth(500);
		mediateur = med;
		taille = mediateur.getPresentation().getGlobal().getJeu().getTaille();
		largeur = 8;
		hauteur = taille/largeur +1;
		setHgap(30);
		setVgap(30);
		for (i=0 ; i<taille;i++) {
			add(mediateur.getPresentation().getCarte(i).getMediateur().getVue(), 
					(mediateur.getPresentation().getCarte(i).getPosition()-1)%8,
					((mediateur.getPresentation().getCarte(i).getPosition()-1)/8));
		}
		
	}

	@Override
	public void remove(int position) {
		System.out.println("remove carte " + position);
		mediateur.getPresentation().getLaCarte(position).getMediateur().getVue().desactive();
		
		
	}
	
	
}
