package fr.ensma.a3.ia.maquettegraphique.plateau.agentplateau;



import javafx.scene.layout.GridPane;

public class VuePlateau extends GridPane implements IVuePlateau {

	private IPresentationPlateau mediateur;
	private Integer i,j,k;
	
	public VuePlateau(IPresentationPlateau med) {
		super();
		setPrefHeight(100);
		setPrefWidth(400);
		mediateur = med;
		setHgap(3);
		setVgap(3);
		
		k = 0;
		for (i=0;i<5;i++) {
			for (j=0;j<8;j++) {
				add(mediateur.getPresentation().getCarte(k).getMediateur().getVue(),j,i);
				k++;
			}
		}
	}
}
