package test2;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class fenetre extends Canvas implements ActionListener {

	private static JPanel cell0, cell1, cell2, cell3, cell4, content;
	//private static JLabel image, image2, image3, image4;
	private static ArrayList al = new ArrayList();
	private static JLabel image, text, text2, text3;
	private static JButton init, exec, next;
	private static JFrame f;
	private static DragListener drag;
	private static int compt = 0, niveau;

	public fenetre(int niveau, int nbPieces) {

		this.niveau = niveau;
		//creation JFrame
		f=new JFrame("Alg'home");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// CONDITION
		if(niveau==1) {
			message("Vous venez d�acheter une maison et vous souhaitez qu�elle soit enti�rement connect�e. Pour cela, vous devez programmer vous-m�me tous \nles appareils de votre maison.\n" + 
					"Cette b�ta est compos�e de 4 niveaux. Le premier vous permet de vous familiariser avec les outils en vous demandant une action simple. \nEnsuite, nous vous demanderons de programmer les appareils de votre maison.\n",
					"Pitch");
		} 

		//On cr�e nos diff�rents conteneurs
		cell0 = new JPanel();
		cell0.setPreferredSize(new Dimension(750, 125));
//		cell0.setBackground(Color.BLUE);
		cell1 = new JPanel();
		cell1.setPreferredSize(new Dimension(750, 625));
//		cell1.setBackground(Color.YELLOW);
		cell2 = new JPanel();
		cell2.setPreferredSize(new Dimension(750, 125));
		cell2.setLayout(new GridLayout(2,1));
//		cell2.setBackground(Color.RED);
		cell3 = new JPanel();
		cell3.setPreferredSize(new Dimension(750, 375));
//		cell3.setBackground(Color.GREEN);
		cell4 = new JPanel();
		cell4.setPreferredSize(new Dimension(750, 250));
		
		// Placement des �l�ments Bas Droite
		image = new JLabel(new ImageIcon("images/cuisine.PNG"));
		cell3.add(image);

		// Placement des �l�ments Haut Gauche
		init = new JButton("Initialiser");
		init.addActionListener(this);
		exec = new JButton("Executer");
		exec.addActionListener(this);
		cell0.add(init); 
		cell0.add(exec);
		if(niveau!=4) {
			next = new JButton("Niveau "+(niveau+1));
			next.addActionListener(this);
			cell0.add(next);
		}

		// Placement des �l�ments Bas Gauche
		for(int i = 0; i < nbPieces; i++) {
			al.add(new JLabel(new ImageIcon("images/lvl"+niveau+"/lvl"+niveau+"_"+(i+1)+".png")));
			cell1.add((Component) al.get(i));
		}  

		// Bouger l'image grace � la souris
		drag = new DragListener(al, niveau);
		for(int i = 0; i < al.size(); i++) {
			((Component) al.get(i)).addMouseListener( drag );
			((Component) al.get(i)).addMouseMotionListener( drag );
		}			

		// Placement des �l�ments Milieu Droite
		String description = "";
		if(niveau==1) description = "Pr�parer un caf�";
		else if(niveau==2) description = "Connectez votre four et votre machine � caf� - �tape 1";
		else if(niveau==3) description = "Connectez votre four et votre machine � caf� - �tape 2";
		else if(niveau==4) description = "Aider la machine � faire votre caf�";
		text = new JLabel(description);
		text.setFont(new Font("Arial",Font.ITALIC,20));
		text.setHorizontalAlignment(JLabel.CENTER);
		text2 = new JLabel("");
		text2.setFont(new Font("Arial",Font.ITALIC,20));
		text2.setHorizontalAlignment(JLabel.CENTER);
		cell2.add(text);
		cell2.add(text2);
	
		// Placement des �l�ments Bas Droite
		String resume = "";
		if(niveau==1) resume = "<html><center><h2>Consignes</h2>Comme toutes les machines, vous appliquez une suite logique <br>d�actions pour vos t�ches quotidiennes. "
				+ "<br>Programmer l�action suivante : se pr�parer le caf�.</center></html>";
		else if(niveau==2) resume = "<html><center><h2>Consignes</h2>Tous les matins, vous faites chauffer votre pain au four apr�s avoir fait le caf�.<br> "
				+ "Vous aimeriez donc connecter votre four � la machine � caf�. <br>"
				+ "Fa�tes un programme qui connecte vos deux appareils.</center></html>";
		else if(niveau==3) resume = "<html><center><h2>Consignes</h2>A pr�sent vous souhaitez uniquement que votre four chauffe le temps que votre caf� <br>"
				+ "coule dans la thermos. Quand la machine � caf� a finit, le four s�arr�te.</center></html>";
		else if(niveau==4) resume = "<html><center><h2>Consignes</h2></center>"
				+ "Fonctionnement : <br>"
				+ "- Le bouton START s'allume.<br>"
				+ "- La machine chauffe l�eau � une temp�rature de 95�C si il y a de l�eau dans le compartiment.<br>"
				+ "- L�eau est ensuite vers�e dans le compartiment � caf� jusqu'� ce que la compartiment soit vide.<br>"
				+ "- S�il n�y a pas d�eau alors la machine fait clignoter son bouton avec un voyant rouge.<br>"
				+ "- La machine s'arr�te lorsque toutes les taches ont �t� effectu�es.</html>";
		text3 = new JLabel(resume);
		text3.setFont(new Font("Arial",Font.ITALIC,14));
		text3.setHorizontalAlignment(JLabel.CENTER);
		text3.setVerticalAlignment(JLabel.BOTTOM);
		cell4.add(text3);
		
		content = (JPanel) f.getContentPane();
		content.setLayout(null);
		content.add(this);
		setIgnoreRepaint(true);
		//Le conteneur principal
		content.setLayout(new GridBagLayout());
		//L'objet servant � positionner les composants
		GridBagConstraints gbc = new GridBagConstraints();

		//Partie Haut Gauche
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		gbc.gridwidth = 6;
		content.add(cell4, gbc);

		//Partie Haut droite
		gbc.gridx = 6;
		gbc.gridheight = 5;
		content.add(cell1, gbc);

		// Partie Milieu Gauche
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridheight = 3;
		content.add(cell3, gbc);

		//Partie Bas droite
		gbc.gridx = 6;
		gbc.gridy = 5;
		gbc.gridheight = 1;
		content.add(cell0, gbc);
		
		// Partie Bas droite
		gbc.gridx = 0;
		content.add(cell2, gbc);
		
		

		f.setContentPane(content);
		f.pack();
		f.setVisible(true);
		f.setLocationRelativeTo(null);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		if(arg0.getActionCommand().equalsIgnoreCase("Initialiser")) {
			init();
		}
		else if(arg0.getActionCommand().equalsIgnoreCase("Executer")) {
			new runGame(drag.getHt(), text2, image, niveau);
		}
		else if(arg0.getActionCommand().equalsIgnoreCase("Niveau 2")) {
			al.clear();
			new fenetre(2, 3);
		}
		else if(arg0.getActionCommand().equalsIgnoreCase("Niveau 3")) {
			al.clear();
			new fenetre(3, 3);
		}
		else if(arg0.getActionCommand().equalsIgnoreCase("Niveau 4")) {
			al.clear();
			new fenetre(4, 10);
		}

	}

	public static void init() {
		//		image4.setLocation(0, 370);
		//		image3.setLocation(190, 370);
		//		image2.setLocation(380, 370);
		drag.newGame();
		text2.setText("");
		image.setIcon(new ImageIcon("images/cuisine.PNG"));
	}

	public void message(String mess, String titre) {
		JOptionPane.showMessageDialog(f,mess, titre, JOptionPane.INFORMATION_MESSAGE);
	}




}
