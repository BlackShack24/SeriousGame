import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class fenetre extends Canvas implements ActionListener {

	private static JPanel cell0, cell1, cell2, cell3, content;
	private static JLabel image, image2, image3, image4, text, text2;
	private static JButton init, exec;
	private static JFrame f;
	private static DragListener drag;
	private static int compt = 0;

	public fenetre() {
		//creation JFrame
		f=new JFrame("Serious Game");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		message("Vous venez d’acheter une maison et vous souhaitez qu’elle soit entièrement connectée. Pour cela, vous devez programmer vous-même tous \nles appareils de votre maison.\n" + 
				"Cette béta est composée de 3 niveaux. Le premier vous permet de vous familiariser avec les outils en vous demandant une action simple. \nEnsuite, nous vous demanderons de programmer les appareils de votre maison.\n",
				"Pitch");
		message("Comme toutes les machines, vous appliquez une suite logique d’actions\n pour vos tâches quotidiennes.  Programmer l’action suivante : se préparer le café.", "Niveau 1");
		
		
		//On crée nos différents conteneurs

		cell0 = new JPanel();
		cell0.setPreferredSize(new Dimension(600, 100));
		init = new JButton("Initialiser");
		init.addActionListener(this);
		exec = new JButton("Executer");
		exec.addActionListener(this);
		cell0.add(init); 
		cell0.add(exec);


		cell1 = new JPanel();
		cell1.setPreferredSize(new Dimension(600, 500));
		image2 = new JLabel(new ImageIcon("images/cafe_tache1_gimp4.png"));
		image3 = new JLabel(new ImageIcon("images/cafe_tache2_gimp4.png"));
		image4 = new JLabel(new ImageIcon("images/cafe_tache3_gimp4.png"));

		cell1.add(image2);
		cell1.add(image3);
		cell1.add(image4);
		// Bouger l'image grace à la souris
		drag = new DragListener(image2, image3, image4);
		image2.addMouseListener( drag );
		image2.addMouseMotionListener( drag );
		image3.addMouseListener( drag );
		image3.addMouseMotionListener( drag );
		image4.addMouseListener( drag );
		image4.addMouseMotionListener( drag );			

		cell2 = new JPanel();
		cell2.setPreferredSize(new Dimension(600, 100));
		cell2.setLayout(new GridLayout(2,1));
		text = new JLabel("Préparer un café");
		text.setFont(new Font("Arial",Font.ITALIC,20));
		text.setHorizontalAlignment(JLabel.CENTER);
		text2 = new JLabel("");
		text2.setFont(new Font("Arial",Font.ITALIC,20));
		text2.setHorizontalAlignment(JLabel.CENTER);
		
//		text3 = new JLabel("");
//		text3.setFont(new Font("Arial",Font.ITALIC,20));
		cell2.add(text);
		cell2.add(text2);
		
		//cell2.add(text);


		cell3 = new JPanel();
		cell3.setPreferredSize(new Dimension(600, 500));
		image = new JLabel(new ImageIcon("images/cuisine.PNG"));
		cell3.add(image);


		content = (JPanel) f.getContentPane();
		content.setLayout(null);
		content.add(this);
		setIgnoreRepaint(true);
		//Le conteneur principal
		//On définit le layout manager
		content.setLayout(new GridBagLayout());
		//L'objet servant à positionner les composants
		GridBagConstraints gbc = new GridBagConstraints();

		//Partie Gauche Haut
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 6;
		content.add(cell0, gbc);

		//Partie Haut droite
		gbc.gridx = 6;
		content.add(cell2, gbc);

		// Partie Gauche Bas
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 5;
		content.add(cell1, gbc);

		//Partie Bas droite
		gbc.gridx = 6;
		content.add(cell3, gbc);

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
			new runGame(drag.getHt(), text2, image);
		}

	}

	public static void init() {
		image4.setLocation(0, 370);
		image3.setLocation(190, 370);
		image2.setLocation(380, 370);
		drag.newGame();
		text2.setText("");
		image.setIcon(new ImageIcon("images/cuisine.PNG"));
	}
	
	public void message(String mess, String titre) {
		JOptionPane.showMessageDialog(f,mess, titre, JOptionPane.INFORMATION_MESSAGE);
	}




}
