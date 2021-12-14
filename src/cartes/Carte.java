/**
* This class describe the cards, it contains the color, type and corresponding value information of the card.
* @author CHEN Zhoujing
* @version 1.0
* @since 1.0
*/
package cartes;

public class Carte implements CarteInfo{
	
	private String couleur;
	private String valeur;
	private int count;

	public Carte(String couleur, String valeur) {
		super();
		this.couleur = couleur;
		this.valeur = valeur;

		if (valeur == "valet" || valeur == "dame" || valeur == "roi") {
			this.count = 10;
		} else if (valeur == "as") {
			this.count = 11; // 1 or 11 
		} else {
			this.count = Integer.parseInt(valeur);
		}
	}

	public String getCouleur() {
		return couleur;
	}

	public String getValeur() {
		return valeur;
	}

	public int getCount() {
		return count;
	}
	
	/**
	 * This function is used to get the order of the cards.
	 * @return Integer.
	 */
	public int getOrder() {
		int cptC = 0, cptV = 0;
		for (String s : COULEUR) {
			if (this.getCouleur().equals(s)) {
				break;
			}
			cptC++;
		}
		for (String s : VALEUR) {
			if (this.getValeur().equals(s)) {
				break;
			}
			cptV++;
		}
		return (cptC * 12 + cptV + 2);
	}
	
	/**
	 * This function is used to find whether s belongs to stringEnsemble.
	 * @param stringEnsemble is a collection of string.
	 * @param s is a string.
	 * @return True or False, if s belongs to stringEnsemble return True, else return False.
	 */
	public static boolean contains(String[] stringEnsemble, String s) {
		boolean contains = false;
		for (String temp : stringEnsemble) {
			if (s.equals(temp)) {
				contains = true;
				break;
			}
		}
		return contains;
	}

	/**
	 * This function tests whether the card meets the requirements.
	 * @return True or False.
	 */
	public boolean estValide() {
		return contains(COULEUR, this.couleur) && contains(VALEUR, this.valeur) && this.count > 1 && this.count < 12;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((couleur == null) ? 0 : couleur.hashCode());
		result = prime * result + count;
		result = prime * result + ((valeur == null) ? 0 : valeur.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carte other = (Carte) obj;
		if (couleur == null) {
			if (other.couleur != null)
				return false;
		} else if (!couleur.equals(other.couleur))
			return false;
		if (count != other.count)
			return false;
		if (valeur == null) {
			if (other.valeur != null)
				return false;
		} else if (!valeur.equals(other.valeur))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Carde [couleur=" + couleur + ", valeur=" + valeur + "]";
	}
	

}