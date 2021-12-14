/**
* This class represents the card pile in the player's hand.
* @author CHEN Zhoujing
* @version 1.0
* @since 1.0
*/
package cartes;

import java.util.ArrayList;

public class SimpleMain extends CarteSet {

	public SimpleMain() {
		cartes = new ArrayList<>();
	}

	public void add(Carte carde) {
		if (super.getCardes().size() == 0) {
			cartes.add(carde);
		} else {
			boolean dejaAdd = false;
			ArrayList<Carte> newCardes = new ArrayList<>();
			for (int i = 0; i < super.getCardes().size(); i++) {
				if (super.getCardes().get(i).getOrder() > carde.getOrder()) {
					newCardes.add(carde);
					dejaAdd = true;
				}
				newCardes.add(super.getCardes().get(i));
			}
			if (!dejaAdd) {
				newCardes.add(carde);
			}
			setCardes(newCardes);
		}
	}

	/**
	 * This function got the valuer of this card file.
	 * @return Integer
	 */
	public int valeur() {
		int somme = 0, aAs = 0;
		for (Carte c : cartes) {
			somme += c.getCount();
			if (c.getValeur().equals("as")) {
				aAs++;
			}
		}
		while (aAs > 0) {
			if (somme > 21) {
				somme -= 10;
				aAs--;
			} else {
				break;
			}
		}
		return somme;
	}

	@Override
	public String toString() {
		return "Maintenant, vous avez :" + cartes.size() + " cardes." + " \nIls sont " + cartes.toString();
	}

}
