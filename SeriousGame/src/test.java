import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		//creation JFrame
		JFrame f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1300, 700);
		f.setLocationRelativeTo(null);

		//On crée nos différents conteneurs de couleur différente
		JPanel cell1 = new JPanel();
		cell1.setPreferredSize(new Dimension(600, 600));
		JButton init = new JButton("Initialiser");
		JButton exec = new JButton("Executer");
		JLabel image2 = new JLabel(new ImageIcon("images/cafe_tache1_gimp4.png"));
		JLabel image3 = new JLabel(new ImageIcon("images/cafe_tache2_gimp4.png"));
		JLabel image4 = new JLabel(new ImageIcon("images/cafe_tache3_gimp4.png"));
		cell1.add(init);
		cell1.add(exec);
		cell1.add(image2);
		cell1.add(image3);
		cell1.add(image4);
				
		// Bouger l'image grace à la souris
		DragListener drag = new DragListener(image2, image3, image4);
		image2.addMouseListener( drag );
		image2.addMouseMotionListener( drag );
		image3.addMouseListener( drag );
		image3.addMouseMotionListener( drag );
		image4.addMouseListener( drag );
		image4.addMouseMotionListener( drag );
				

		JPanel cell2 = new JPanel();
		cell2.setBackground(Color.red);
		cell2.setPreferredSize(new Dimension(600, 200));
		JLabel text = new JLabel("Préparer un café");
		Font font = new Font("Arial",Font.ITALIC,20);
		text.setFont(font);
		cell2.add(text);
		
		JPanel cell3 = new JPanel();
		cell3.setBackground(Color.green);
		cell3.setPreferredSize(new Dimension(600, 400));
		JLabel image = new JLabel(new ImageIcon("images/cuisine.PNG"));
		cell3.add(image);        
		
		
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
		f.setVisible(true);

	}
	
	
	public boolean isBetween(float objMinX, float objMaxX, float objMinY, float objMaxY) {
		Point m = MouseInfo.getPointerInfo().getLocation();
	    if (m.getX() >= objMinX && m.getX() <= objMaxX && m.getY() >= objMinY && m.getY() <= objMaxY) return true;
	    return false;
	}

}
