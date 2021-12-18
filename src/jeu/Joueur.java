/**
* This class represents the players.
* @author CHEN Zhoujing
* @version 1.0
* @since 1.0
*/
package jeu;

import cartes.Carte;
import cartes.SimpleMain;

public abstract class Joueur {

	protected SimpleMain main;

	public Joueur() {
		main = new SimpleMain();
	}

	public void add(Carte c) {
		main.add(c);
	}

	public SimpleMain getMain() {
		return main;
	}
	
	/**
	 * This function used to determine whether to draw a card.
	 * @return True or False
	 */
	public abstract boolean prendCarte();

}
