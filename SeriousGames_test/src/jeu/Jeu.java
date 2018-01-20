package jeu;

import moteurJeu.moteur.CClavier;
import moteurJeu.moteur.CSouris;
import moteurJeu.moteur.JeuAbstract;

public class Jeu implements JeuAbstract {

	int x=100, y=200;
	boolean appui = true;
	
	@Override
	public String evoluer(CClavier clavier, CSouris souris) {
		// TODO Auto-generated method stub
		x=souris.getX();
		y=souris.getY();
		if(souris.isPressed()) {
			if(appui) appui = false;
			else appui = true;
		}
		return null;
	}

	@Override
	public boolean etreFini() {
		// TODO Auto-generated method stub
		return false;
	}

}
