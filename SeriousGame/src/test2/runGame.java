package test2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class runGame {

	boolean first = true, stop = false, fin = false, sol = true;
	int val1, val2, comptFin=0, niveau;
	String tache, urlImg;
	Timer timer;
	LinkedList l = new LinkedList();

	public runGame(Hashtable ht, JLabel txt, JLabel img, int niveau) {

		this.niveau = niveau;
		Enumeration ke = ht.keys();

		timer = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(first) {
					while(ke.hasMoreElements() && !stop) {
						val1 = (int) ke.nextElement();
						if(!ht.containsValue(val1)) {
							val2 = (int) ht.get(val1);
							stop = true;
						}
					}
					first=false;
				}
				else if(ht.containsKey(val2)) {
					val1 = val2;
					val2 = (int) ht.get(val1);
				}
				else {
					if(comptFin==0) {
						l.add(val2);
						txt.setText(tacheNum(val2));
						img.setIcon((Icon) new ImageIcon(urlImg));
						fin = true;
					}
					comptFin++;
				}
				
				if(!fin) {
					l.add(val1);
					txt.setText(tacheNum(val1));
					img.setIcon((Icon) new ImageIcon(urlImg));
				}
				if(comptFin==2) {
					for(int i = 0 ; i < l.size() ; i++) {
						if((int)l.get(i) != i) sol = false;
					}
					if(sol) txt.setText("SUCCES !");
					else txt.setText("ERREUR !");
					timer.stop();
				}
			}
		});
		timer.start();

	}

	public String tacheNum(int num) {
		String tache = "";
		if(niveau==1) {
			switch(num) {
			case 0 :
				tache = "Ajouter le café dans le filtre";
				urlImg = "images/cuisine_cafeCafe.PNG";
				break;
			case 1 :
				tache = "Remplir d'eau";
				urlImg = "images/cuisine_cafeEau.PNG";
				break;
			case 2 :
				tache = "Faire chauffer l'eau";
				urlImg = "images/cuisine_cafeFeu.PNG";
				break;
			}
		}
		else if (niveau==2) {
			urlImg = "images/cuisine.PNG";
			switch(num) {
			case 0 :
				tache = "Bouton Start activé";
				break;
			case 1 :
				tache = "Si";
				break;
			case 2 :
				tache = "Contient de l'eau dans le bac";
				break;
			case 3 :
				tache = "Chauffer l'eau à 95°";
				break;
			case 4 :
				tache = "Tant que";
				break;
			case 5 :
				tache = "Contient de l'eau dans le bac";
				break;
			case 6 :
				tache = "Verser l'eau dans le compartiment à café";
				break;
			case 7 :
				tache = "Arrêter machine";
				break;
			case 8 :
				tache = "Sinon";
				break;
			case 9 :
				tache = "Faire clignoter le voyant rouge";
				break;
			}
		}

		return tache;
	}

}
