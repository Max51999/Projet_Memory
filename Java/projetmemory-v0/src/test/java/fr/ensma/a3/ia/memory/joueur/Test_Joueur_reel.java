package fr.ensma.a3.ia.memory.joueur;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@DisplayName("Tests de la classe Joueur_reel")
@TestMethodOrder(OrderAnnotation.class)
public class Test_Joueur_reel {

	private static Joueur_reel joueurtest;
	private static final String NOM = "nom";
	private static final String PRENOM = "prenom";
	private static final String MAIL = "mail@mail.com";
	private static final String SURNOM = "surnom";
	
	@BeforeAll
	public static void initJoueur() {
		joueurtest = new Joueur_reel(PRENOM,NOM,MAIL,SURNOM);
	}
	
	@Test
	@Order(1)
	public void testInit() {
		assertAll("Etat instance non conforme",
				() -> assertEquals(joueurtest.getNom(), NOM),
				() -> assertEquals(PRENOM, joueurtest.getPrenom()),
				() -> assertEquals(MAIL, joueurtest.getMail()),
				() -> assertEquals(SURNOM, joueurtest.getPseudo()),
				() -> assertEquals("joueur2", joueurtest.getId()),
				() -> assertEquals(0, joueurtest.getNbCartes()),
				() -> assertEquals(1, joueurtest.getNbTours()),
				() -> assertEquals(2, joueurtest.getNumJoueur())
					);
	}
	
	
	@Test
	@Order(2)
	public void testSetter() {
		joueurtest.setNbCartes(2);
		joueurtest.setNbTours(0);
		assertTrue(joueurtest.getNbCartes() == 2);
		assertEquals(0, joueurtest.getNbTours());
	}
	
	
	@Test
	@Order(3)
	public void testRetourneCarte() {
		joueurtest.retourne_carte();
	}
	
	
	@Test
	@Order(4)
	public void testPaireTrouvee() {
		joueurtest.paire_trouvee();
	}
	
	@Test
	@Order(5)
	public void testReset() {
		joueurtest.reset();
	}
	
	@Test
	@Order(6)
	public void testRevele() {
		joueurtest.revele();
	}
	
}
