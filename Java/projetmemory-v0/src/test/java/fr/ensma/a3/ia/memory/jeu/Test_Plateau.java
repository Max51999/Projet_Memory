package fr.ensma.a3.ia.memory.jeu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.ensma.a3.ia.memory.jeu.carte.Abstract_carte;
import fr.ensma.a3.ia.memory.joueur.Abstract_joueur;


@DisplayName("Tests de la classe Joueur_reel")
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(OrderAnnotation.class)
public class Test_Plateau {

	private static Plateau_jeu plateautest;
	
	@Mock Abstract_joueur joueur1;	
	@Mock Abstract_carte carte;
	
	@BeforeAll
	public static void initJoueur() {
		plateautest = new Plateau_jeu();
	}
	
	@Test
	@Order(1)
	public void testSetter() {
		plateautest.setMystere(2);
		plateautest.setPaire(12);
		plateautest.setTaille(64);
		assertEquals(plateautest.getMystere(), 2);
		assertEquals(plateautest.getPaire(), 12);
		assertEquals(plateautest.getTaille(), 64);
	}
	
	
	@Test
	@Order(2)
	public void testChoixTaillePlateau() {
		try {
			plateautest.choix_taille_plateau(ETaille.petit);
			assertEquals(plateautest.getTaille(), 30);
			plateautest.choix_taille_plateau(ETaille.moyen);
			assertEquals(plateautest.getTaille(), 50);
			plateautest.choix_taille_plateau(ETaille.grand);
			assertEquals(plateautest.getTaille(), 100);
		} catch (ExceptionTaille e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	@Order(3)
	public void testChoixNombrePaires() {
		plateautest.choix_nb_paire();
	}
	
	
	@Test
	@Order(4)
	public void testChoixCartesMystere() {
		try {
			plateautest.choix_cartes_mystere(ETaille.petit);
			assertEquals(plateautest.getMystere(), 2);
			plateautest.choix_cartes_mystere(ETaille.moyen);
			assertEquals(plateautest.getMystere(), 4);
			plateautest.choix_cartes_mystere(ETaille.grand);
			assertEquals(plateautest.getMystere(), 6);
		} catch (ExceptionTaille e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	@Order(5)
	public void testInitialisation() {
		plateautest.initialisation();
	}
	
	@Test
	@Order(5)
	public void testAjoutCarte() {
		plateautest.ajout_carte(carte);
		assertEquals(carte, plateautest.getCarte(0));
	}
		
	
	@Test
	@Order(5)
	public void testAjoutJoueur() {
		plateautest.ajout_joueur(joueur1);
		assertEquals(joueur1, plateautest.getJoueur(0));
	}
	
	@Test
	@Order(6)
	public void testMelange() {
		plateautest.melange();
	}
	
	@Test
	@Order(7)
	public void testRevele() {
		plateautest.revele();
	}
	
	@Test
	@Order(8)
	public void testFinPartie() {
		plateautest.fin_partie();
	}
	
	
} 
