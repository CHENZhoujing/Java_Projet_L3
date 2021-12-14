/**
* This class is used for players(human) to draw cards.
* @author CHEN Zhoujing
* @version 1.0
* @since 1.0
*/
package jeu;

public class JoueurHumain extends Joueur {

	private boolean prendre = true;

	@Override
	public boolean prendCarte() {
		// TODO Auto-generated method stub
		return prendre;
	}

	public void setPrendre(boolean prendre) {
		this.prendre = prendre;
	}

}
