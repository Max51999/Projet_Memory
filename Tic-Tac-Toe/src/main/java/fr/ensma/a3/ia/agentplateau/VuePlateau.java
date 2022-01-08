package fr.ensma.a3.ia.agentplateau;



import javafx.scene.layout.GridPane;

public class VuePlateau extends GridPane implements IVuePlateau {

	private IPresentationPlateau mediateur;
	private Integer i,j,k;
	
	public VuePlateau(IPresentationPlateau med) {
		super();
		
		mediateur = med;
		setHgap(3);
		setVgap(3);
		k = 0;
		for (i=0;i<3;i++) {
			for (j=0;j<3;j++) {
				add(mediateur.getPresentation().getCase(k).getMediateur().getVue(),i,j);
				k++;
			}
		}
	}
}
