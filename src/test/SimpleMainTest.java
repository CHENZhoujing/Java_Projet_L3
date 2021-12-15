package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;


import cartes.Carte;
import cartes.SimpleMain;

public class SimpleMainTest {

	private static SimpleMain SMUnderTest;
	Carte c2 = new Carte("pique", "2");
	Carte c5 = new Carte("pique", "5");
	Carte cJ = new Carte("coeur", "valet");
	Carte cA = new Carte("carreau", "as");
	
	@Before
	public void setUpTest() {
		SMUnderTest = new SimpleMain();
		SMUnderTest.add(c2);
		SMUnderTest.add(c5);
		SMUnderTest.add(cJ);
		SMUnderTest.add(cA);
	}
	
	
	@Test 
	public void testValeur() {
		assertEquals(18,SMUnderTest.valeur());
	}
	
	@Test
	public void testEstValide() {
		assertEquals(true, SMUnderTest.estValide());
	}
	
}
