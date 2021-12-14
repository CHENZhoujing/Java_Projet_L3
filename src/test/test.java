package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;


import cartes.Carte;
import cartes.SimpleMain;


public class test {


	SimpleMain SM = new SimpleMain();
	Carte c2 = new Carte("pique", "2");
	Carte c5 = new Carte("pique", "5");
	Carte cJ = new Carte("cœur", "valet");
	Carte cA = new Carte("carreau", "as");
	
	@Before
	public void preparation() {
		
		SM.add(c2);
		SM.add(c5);
		SM.add(cJ);
		SM.add(cA);
	}
	
	@Test
	public void testEstValide() {
		assertTrue(c2.estValide());
	}
	
	@Test
	public void testValeur() {
	
		assertEquals(18,SM.valeur());
	}
	
	
}
