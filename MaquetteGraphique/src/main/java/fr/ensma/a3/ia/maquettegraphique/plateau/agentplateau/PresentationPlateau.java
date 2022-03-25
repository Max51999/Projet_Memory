package fr.ensma.a3.ia.maquettegraphique.plateau.agentplateau;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.ensma.a3.ia.maquettegraphique.PresentationGlobal;
import fr.ensma.a3.ia.maquettegraphique.plateau.agentcarte.IObserverCarte;
import fr.ensma.a3.ia.maquettegraphique.plateau.agentcarte.PresentationCarte;
import fr.ensma.a3.ia.memory.jeu.carte.Abstract_carte;
import fr.ensma.a3.ia.memory.jeu.carte.mystere.Dans_ta_face;
import fr.ensma.a3.ia.memory.jeu.carte.mystere.Melange_tout;
import fr.ensma.a3.ia.memory.jeu.carte.mystere.Revele_tout;



public class PresentationPlateau implements IObservableCarte {

	
	private PresentationGlobal global;
	private IPresentationPlateau mediateur;
	
	private List<IObserverCarte> liste;
	
	private List<Abstract_carte> liste_carte;
	private List<String> liste_deco;
	
	private Integer i;
	
	public PresentationPlateau(PresentationGlobal g) {
		global = g;

		liste_deco = Arrays.asList("2c.gif","3c.gif","4c.gif","5c.gif","6c.gif",
		              "7c.gif","8c.gif","9c.gif","10c.gif","Jc.gif",
		              "Qc.gif","Kc.gif","Ac.gif","2h.gif","3h.gif","4h.gif","5h.gif","6h.gif",
		              "7h.gif","8h.gif","9h.gif","10h.gif","Jh.gif",
		              "Qh.gif","Kh.gif","Ah.gif","2s.gif","3s.gif","4s.gif","5s.gif");
		liste = new ArrayList<IObserverCarte>();
		for (Abstract_carte ca : global.getJeu().getListeCarte()) {
			String nom = "";
			if (ca.getNumero() == 0) {
				if (ca instanceof Dans_ta_face) {
					nom = "/images/DansTaFace.gif";
				} else if (ca instanceof Melange_tout) {
					nom = "/images/MelangeTout.gif";
				} else if (ca instanceof Revele_tout) {
					nom = "/images/ReveleTout.gif";
				}
			} else {
				nom = "/images/" + liste_deco.get(ca.getNumero()-1);
			}
			
			IObserverCarte case1 = new PresentationCarte(nom, ca.getPosition());
			case1.setPlateau(this);
			liste.add(case1);
		}
		mediateur = new MediateurPlateau(this);
	}
	
	public void setGlobal(PresentationGlobal g) {
		global = g;
	}
	
	public PresentationGlobal getGlobal() {
		return global;
	}
	
	public IObserverCarte getCarte(Integer i) {
		return liste.get(i);
	}

	public MediateurPlateau getMediateur() {
		return (MediateurPlateau)mediateur;
	}

	@Override
	public void notifier(IObserverCarte cas) {
		global.notifier(cas.getNumCarte());
	}
	
	
}
