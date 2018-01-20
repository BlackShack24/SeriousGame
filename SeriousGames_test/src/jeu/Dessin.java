package jeu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import moteurJeu.moteur.DessinAbstract;

public class Dessin implements DessinAbstract {

	Jeu j;
	
	public Dessin(Jeu jeu) {
		this.j=jeu;
	}
	
	@Override
	public void dessiner(BufferedImage image) {
		// TODO Auto-generated method stub
		
		Graphics g=image.getGraphics();
		
		if(j.appui) g.setColor(Color.green);
		else g.setColor(Color.blue);
		g.fillRect(this.j.x, this.j.y, 20, 20);
		g.dispose();
		
		
	}

}
