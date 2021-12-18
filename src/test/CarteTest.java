package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cartes.Carte;

public class CarteTest {
	
	Carte c = new Carte("pique", "9");
	Carte cf = new Carte("d","2");
	
	@Test
	public void testGetOrder() {
		assertEquals(9, c.getOrder());
	}
	
	@Test
	public void testEstValide() {
		assertEquals(false, cf.estValide());
	}

	
}
