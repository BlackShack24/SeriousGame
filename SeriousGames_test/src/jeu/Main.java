package jeu;

import moteurJeu.moteur.DessinAbstract;
import moteurJeu.moteur.JeuAbstract;
import moteurJeu.moteur.MoteurGraphique;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jeu pJeu = new Jeu();
		DessinAbstract pDessin = new Dessin(pJeu);
		MoteurGraphique moteur = new MoteurGraphique(pJeu, pDessin);
		moteur.lancerJeu(800, 600, 60);
	}

}
