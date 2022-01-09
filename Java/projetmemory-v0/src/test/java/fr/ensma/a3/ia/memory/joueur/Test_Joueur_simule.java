package fr.ensma.a3.ia.memory.joueur;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@DisplayName("Test de la classe Joueur_simule")
@TestMethodOrder(OrderAnnotation.class)
public class Test_Joueur_simule {


	private static Joueur_simule orditest;
	
	@BeforeAll
	public static void initJoueur() {
		orditest = new Joueur_simule();
	}
	
	@Test
	@Order(1)
	public void testInit() {
		assertAll("Etat instance non conforme",
				() -> assertEquals(orditest.getNom(), "bot"),
				() -> assertEquals("bot", orditest.getPrenom()),
				() -> assertEquals("none", orditest.getMail()),
				() -> assertEquals("bot1", orditest.getPseudo()),
				() -> assertEquals("joueur1", orditest.getId()),
				() -> assertEquals(0, orditest.getNbCartes()),
				() -> assertEquals(1, orditest.getNbTours()),
				() -> assertEquals(1, orditest.getNumJoueur())
					);
	}
	
	
	@Test
	@Order(2)
	public void testSetter() {
		orditest.setNbCartes(2);
		orditest.setNbTours(0);
		assertTrue(orditest.getNbCartes() == 2);
		assertEquals(0, orditest.getNbTours());
	}
	
	
	@Test
	@Order(3)
	public void testRetourneCarte() {
		orditest.retourne_carte();
	}
	
	
	@Test
	@Order(4)
	public void testPaireTrouvee() {
		orditest.paire_trouvee();
	}
	
	@Test
	@Order(5)
	public void testReset() {
		orditest.reset();
	}
	
	@Test
	@Order(6)
	public void testRevele() {
		orditest.revele();
	}
	
}
