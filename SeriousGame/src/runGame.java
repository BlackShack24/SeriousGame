import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class runGame {
	
	boolean first = true, stop = false, fin = false;
	int val1, val2;
	String tache, urlImg;
	Timer timer;
	
	public runGame(Hashtable ht, JLabel txt, JLabel img) {

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
					txt.setText(tacheNum(val2));
					img.setIcon((Icon) new ImageIcon(urlImg));
					timer.stop();
					fin = true;
				}

				if(!fin) {
					txt.setText(tacheNum(val1));
					img.setIcon((Icon) new ImageIcon(urlImg));
				}
			}
		});
		timer.start();
	}
	
	public String tacheNum(int num) {
		String tache = "";
		if(num == 0) {
			tache = "Ajouter le café dans le filtre";
			urlImg = "images/cuisine_cafeCafe.PNG";
		}
		else if (num == 1) {
			tache = "Remplir d'eau";
			urlImg = "images/cuisine_cafeEau.PNG";
		}
		else if (num == 2) {
			tache = "Faire chauffer l'eau";
			urlImg = "images/cuisine_cafeFeu.PNG";
		}
		return tache;
	}
	
}
