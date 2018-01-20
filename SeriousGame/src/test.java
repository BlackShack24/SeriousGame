import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//creation JFrame
				JFrame f=new JFrame();
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    f.setSize(1500, 700);
			    f.setLocationRelativeTo(null);
				
				//On crée nos différents conteneurs de couleur différente
				JPanel cell1 = new JPanel();
				//cell1.setBackground(Color.YELLOW);
				cell1.setPreferredSize(new Dimension(600, 600));
				JLabel image = new JLabel( new ImageIcon("images/cuisine.PNG"));
				//cell1.setLayout(new BorderLayout, CENTER);
				cell1.add(image);
				
				JPanel cell2 = new JPanel();
				cell2.setBackground(Color.red);
				cell2.setPreferredSize(new Dimension(600, 200));
				JPanel cell3 = new JPanel();
				cell3.setBackground(Color.green);
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
				f.setVisible(true);

	}

}
