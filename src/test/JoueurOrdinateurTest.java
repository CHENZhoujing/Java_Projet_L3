package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import cartes.Carte;
import jeu.JoueurOrdinateur;

public class JoueurOrdinateurTest {
	
	private static JoueurOrdinateur JO;
	Carte c2 = new Carte("pique", "2");
	Carte c5 = new Carte("pique", "5");
	Carte cJ = new Carte("coeur", "valet");
	Carte cA = new Carte("carreau", "as");
	
	@Before
	public void setUpTest() {
		JO = new JoueurOrdinateur();
		JO.add(c2);
		JO.add(c5);
		JO.add(cJ);
		JO.add(cA);
	}
	
	@Test
	public void testPrendCarte() {
		assertEquals(false, JO.prendCarte());
	}
}
