package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cartes.Carte;
import cartes.SimpleTalon;

class SimpleTalonTest {
	private static SimpleTalon ST;
	private static Carte c = new Carte();

	@BeforeEach
	void setUp() throws Exception {
		ST = new SimpleTalon();
	}

	@AfterEach
	void tearDown() throws Exception {
		ST = null;
	}

	@Test
	void testEstComplete() {
		assertEquals(true, ST.estComplete());
	}

	@Test
	void testTransCardes() {
		assertEquals(true, (ST.transCardes()).getClass().equals(c.getClass()));
	}

}
