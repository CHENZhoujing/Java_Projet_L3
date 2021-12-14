/**
* This class is an abstract class, it represents card pile.
* @author CHEN Zhoujing
* @version 1.0
* @since 1.0
*/
package cartes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public abstract class CarteSet {


	protected ArrayList<Carte> cartes;

	public ArrayList<Carte> getCardes() {
		return cartes;
	}

	public void setCardes(ArrayList<Carte> cartes) {
		this.cartes = cartes;
	}

	/**
	 * This function test the card pile meets the requirements: color, value, number of cards is less than 52.
	 * @return True or False 
	 */
	public boolean estValide() {
		Set<Carte> check = new HashSet<Carte>();
		for (Carte c : cartes) {
			if (!c.estValide())
				return false; // dan ka guo guan
			for (Carte ck : check) { // mei zhang ka dou bu yi yang
				if (ck.equals(c))
					return false;
			}
			check.add(c);
		}
		return check.size() == cartes.size() & cartes.size() <= 52;
	}

	public abstract String toString();


	
}