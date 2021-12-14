/**
* This class is the main body of the game.
* @author CHEN Zhoujing
* @version 1.0
* @since 1.0
*/
package jeu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import cartes.SimpleTalon;

public class Jeu {

	private static Scanner scan = new Scanner(System.in);
	private ArrayList<Joueur> joueurs;
	private SimpleTalon talon;

	public Jeu() {

		joueurs = new ArrayList<Joueur>();
		talon = new SimpleTalon();
	}

	public ArrayList<Joueur> getJoueurs() {
		return joueurs;
	}

	public void transferCards(int nombre, Joueur j) {
		for (int i = 0; i < nombre; i++) {
			j.add(this.talon.transCardes());
		}
	}

	public void addJoueur(Joueur j) {
		joueurs.add(j);
	}

	/**
	 * This function used to create NPC.
	 */
	public void prepareNpc() {
		int i = 0;
		System.out.println("Combien de joueursOrdinateurs avons-nous?");
		if (scan.hasNextInt()) {
			i = scan.nextInt();
		}
		for (int j = 0; j < i; j++) {
			this.addJoueur(new JoueurOrdinateur());
		}
	}

	public void prepareJoueur() {
		int i = 0;
		System.out.println("Combien de joueurs avons-nous?");
		if (scan.hasNextInt()) {
			i = scan.nextInt();
		}
		for (int j = 0; j < i; j++) {
			this.addJoueur(new JoueurHumain());
		}
	}

	/**
	 * This function used to print the result.
	 */
	public void productionResultat() {
		System.out.println("*COMPUTER*  ");
		int maxValeur = 0, maxPlace = 0, cptNpc = 0, cptJoueurH = 0;
		boolean aWinner = false;

		for (int i = 0; i < getJoueurs().size(); i++) {
			if (getJoueurs().get(i).getMain().valeur() <= 21) {
				aWinner = aWinner || true;
			}

			if (getJoueurs().get(i).getMain().valeur() >= maxValeur && getJoueurs().get(i).getMain().valeur() <= 21) {
				maxValeur = getJoueurs().get(i).getMain().valeur();
				maxPlace = i;
			}
			if (getJoueurs().get(i) instanceof JoueurOrdinateur) {
				cptNpc++;
				System.out.println(
						"JoueurOrdinateur numero " + cptNpc + ", valeur = " + getJoueurs().get(i).getMain().valeur());

			} else {
				cptJoueurH++;
				System.out.println(
						"JoueurHumain numero " + cptJoueurH + ", valeur = " + getJoueurs().get(i).getMain().valeur());
			}
		}

		if (!aWinner) {
			System.out.println("Pas de winner!");
		} else if (getJoueurs().get(maxPlace) instanceof JoueurHumain) {
			System.out.println("Winer est JoueurHumain numero " + (maxPlace - cptNpc + 1));
		} else
			System.out.println("Winer est JoueurOrdinateur numero " + (maxPlace + 1));

		System.out.print("-------------\n");
		System.out.println("Tapez 1 pour recommencer le jeu.");
		System.out.println("Tapez 2 pour quitter le jeu.");
	}

	/**
	 * This function start the game.
	 */
	public void start() {
		String entre = null;
		int cpt = 1;
		for (Joueur j : joueurs) {
			transferCards(2, j); // fa ka
			if (j instanceof JoueurHumain) { // tu guo ren lei wan jian , yao pai
				System.out.println("Joueur numero " + cpt);
				cpt++;
				while (((JoueurHumain) j).prendCarte()) {
					if (j.getMain().valeur() > 21) {
						break;
					}
					System.out.println(j.getMain().toString() + "\nVotre valeur est " + j.getMain().valeur() + ".");
					System.out.println(
							"Souhaitez-vous choisir une autre carte? Entrez n'importe quoi pour frapper, entrez \\ \"N \\\" ou \\ \"n \\\" pour tenir la carte.");
					if (scan.hasNext()) {
						entre = scan.next();
					}
					if (entre.equals("N") || entre.equals("n")) {
						((JoueurHumain) j).setPrendre(false);
					} else {
						transferCards(1, j);
					}
				}
			} else { // npc
				while (j.prendCarte()) {
					transferCards(1, j);
				}
			}

		}
		productionResultat();

	}

	public static void printMenu() {
		System.out.println("-------------\nVoici le Menu\n--------------");
		System.out.println("Tapez 0 pour voir la description.");
		System.out.println("Tapez 1 pour commencer le jeu.");
		System.out.println("Tapez 2 pour quitter le jeu.");

	}

	/**
	 * This function used to read file from disk.
	 */
	public static void lireFichier(String s) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(s)));
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("Echec de la lecture du fichier description");
		}
	}

	public static void launchMenu() {
		boolean quit = false;
		printMenu();
		do {

			int choice = scan.nextInt();
			scan.nextLine();
			switch (choice) {
			case (0):
				String s = "description";
				lireFichier(s);
				break;
			case (1):
				Jeu jeu = new Jeu();
				jeu.prepareNpc();
				jeu.prepareJoueur();
				jeu.start();
				break;
			case (2):
				quit = true;
				scan.close();
				break;
			default:
				System.out.println("Cette valeur ne fait pas partie des possibilit¨¦s.");
			}

		} while (!quit);
	}

	public static void main(String[] args) {
		launchMenu();
	}
}
