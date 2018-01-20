package moteurJeu.moteur;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * cree une interface graphique avec son controleur et son afficheur
 * @author Graou
 *
 */
public class InterfaceGraphique  {


	/**
	 * le Panel lie a la JFrame
	 */
	private PanelDessin panel;

	/**
	 * le controleur lie a la JFrame
	 */
	CClavier clavier;
	CSouris souris;
	Graphics g;//moi


	/**
	 * la construction de l'interface grpahique
	 * - construit la JFrame
	 * - construit les Attributs
	 * 
	 * @param afficheurUtil l'afficheur a utiliser dans le moteur
	 * 
	 */
	public InterfaceGraphique(DessinAbstract afficheurUtil,int x,int y)
	{
		//creation JFrame
		JFrame f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//		// creation panel
		this.panel=new PanelDessin(x, y,afficheurUtil);
		f.setContentPane(this.panel);
		//On crée nos différents conteneurs de couleur différente
		JPanel cell1 = new JPanel();
		//cell1.setBackground(Color.YELLOW);
		cell1.setPreferredSize(new Dimension(600, 600));
		JPanel cell2 = new JPanel();
		//cell2.setBackground(Color.red);
		cell2.setPreferredSize(new Dimension(600, 200));
		JPanel cell3 = new JPanel();
		//cell3.setBackground(Color.green);
		cell3.setPreferredSize(new Dimension(600, 400));
		//Le conteneur principal
		JPanel content = new JPanel();
		content.setPreferredSize(new Dimension(1200, 600));
		//On définit le layout manager
		content.setLayout(new GridBagLayout());
		//L'objet servant à positionner les composants
		GridBagConstraints gbc = new GridBagConstraints();
		//Partie Gauche
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 3;
		gbc.gridwidth = 2;
		content.add(cell1, gbc);
		//Partie Haut droite
		gbc.gridx = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		content.add(cell2, gbc);
		//Partie Bas droite
		gbc.gridy = 1;
		gbc.gridheight = 2;
		content.add(cell3, gbc);

		f.setContentPane(content);

		//ajoute la souris au panel
		this.souris=new CSouris();
		this.panel.addMouseMotionListener(souris);


		//ajout du controleur
		CClavier controlleurGraph=new CClavier();
		this.clavier=controlleurGraph;
		this.panel.addKeyListener(controlleurGraph);	

		//recuperation du focus
		f.pack();
		f.setVisible(true);
		f.getContentPane().setFocusable(true);
		f.getContentPane().requestFocus();
	}


	/**
	 * retourne le controleur de l'affichage construit
	 * @return
	 */
	public CClavier getControleur() {
		return clavier;
	}

	/**
	 * demande la mise a jour du dessin
	 */
	public void dessiner() {
		this.panel.dessinerJeu();
		this.panel.paint();
	}

}
