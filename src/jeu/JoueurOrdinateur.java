/**
* This class is used for players (NPC) to draw cards.
* @author CHEN Zhoujing
* @version 1.0
* @since 1.0
*/
package jeu;

public class JoueurOrdinateur extends Joueur {

	@Override
	public boolean prendCarte() {
		if (super.main.valeur() <= 16) {
			return true;
		} else
			return false;
	}

}
