/**
* This class represents the undrawn card pile.
* @author CHEN Zhoujing
* @version 1.0
* @since 1.0
*/
package cartes;

import java.util.ArrayList;
import java.util.Random;

public class SimpleTalon extends CarteSet implements CarteInfo {

	private static Random rand = new Random();

	/**
	 * This function represents the American shuffle.
	 */
	public void meAmericain() {
		int a = 0, b = 0, nombre = super.getCardes().size();
		for (int i = 0; i < nombre; i++) {
			if (rand.nextFloat() < 0.5) {
				a++;
			} else {
				b++;
			}
		}
		float pb = (float) a / (float) (a + b);
		float pbO = rand.nextFloat(); // 0 jusqua 1
		ArrayList<Carte> newCardesA = new ArrayList<>();
		ArrayList<Carte> newCardesB = new ArrayList<>();

		for (int i = 0; i < nombre; i++) { // fen pei dao a he b
			if (i < a) {
				newCardesA.add(super.getCardes().get(i));
			} else {
				newCardesB.add(super.getCardes().get(i));
			}
		}

		ArrayList<Carte> newCardes = new ArrayList<>();
		for (int i = 0; i < nombre; i++) {
			if (pb < pbO) { // qu a zu
				if (newCardesA.size() != 0) {
					newCardes.add(newCardesA.get(0));
					newCardesA.remove(0);
				} else {
					newCardes.add(newCardesB.get(0));
					newCardesB.remove(0);
				}

			} else { // qu b zu
				if (newCardesB.size() != 0) {
					newCardes.add(newCardesB.get(0));
					newCardesB.remove(0);
				} else {
					newCardes.add(newCardesA.get(0));
					newCardesA.remove(0);
				}
			}
		}
		super.setCardes(newCardes);
	}

	/**
	 * This function use the function meAmericain() 7 times to shuffle.
	 * {@link meAmericain()}
	 */
	public void melanger() {
		for (int i = 0; i < 7; i++) {
			meAmericain();
		}
	}

	public SimpleTalon() {
		super.cartes = new ArrayList<Carte>();
		for (int i = 0; i < COULEUR.length; i++) {
			for (int j = 0; j < VALEUR.length; j++) {
				super.cartes.add(new Carte(COULEUR[i], VALEUR[j]));
			}
		}
		melanger();
		// if(!estValide()) {
		// throw new Exception("Carde ne valide pas.");
		// }
	}

	/**
	 * This function translate the card from SimpleTalon to SimpleMain.
	 * @return the card selected randomly.
	 */
	public Carte transCardes() {
		if (super.cartes.size() == 0) {
			for (int i = 0; i < COULEUR.length; i++) {
				for (int j = 0; j < VALEUR.length; j++) {
					super.cartes.add(new Carte(COULEUR[i], VALEUR[j]));
				}
			}
		}
		Carte c;
		int i = rand.nextInt(super.cartes.size());
		c = super.cartes.get(i);
		super.cartes.remove(i);
		return c;
	}

	/**
	 * This function test if there are 52 cards in the card pile.
	 * @return True or False
	 */
	public boolean estComplete() {
		return cartes.size() == 52 && estValide();
	}

	@Override
	public String toString() {
		return "SimpleTalon: " + cartes.size() + " cardes.";
	}

}
