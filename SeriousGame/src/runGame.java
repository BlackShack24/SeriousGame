import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import java.io.*;
import sun.audio.*;

public class runGame {

	boolean first = true, stop = false, fin = false, sol = true;
	int val1, val2, comptFin=0;
	String tache, urlImg;
	Timer timer;
	LinkedList l = new LinkedList();

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
					if(sol) {
						txt.setText("SUCCES !");
						urlImg = "SeriousGame/images/cuisine_cafeOui.PNG";
						img.setIcon((Icon) new ImageIcon(urlImg));
						son ("correct");
					}
					else {
						txt.setText("ERREUR !");
						urlImg = "SeriousGame/images/cuisine_cafeNon.PNG";
						img.setIcon((Icon) new ImageIcon(urlImg));
						son ("wrong");
					}
					timer.stop();
					
				}
			}
		});
		timer.start();

	}

	public String tacheNum(int num) {
		String tache = "";
		if(num == 0) {
			tache = "Ajouter le café dans le filtre";
			urlImg = "SeriousGame/images/cuisine_cafeCafe.PNG";
			son ("coffee");
		}
		else if (num == 1) {
			tache = "Remplir d'eau";
			urlImg = "SeriousGame/images/cuisine_cafeEau.PNG";
			son ("water");
		}
		else if (num == 2) {
			tache = "Faire chauffer l'eau";
			urlImg = "SeriousGame/images/cuisine_cafeFeu.PNG";
			son ("fire");
		}
		return (""+tache);
	}
	
	
	//methode permettant de jouer un son, le string "son" définit quel son est joué
	public void son (String son) {
		
	    // open the sound file as a Java input stream
	    String gongFile = "SeriousGame/sounds/"+son+".wav";
	    InputStream in = null;
		try {
			in = new FileInputStream(gongFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    // create an audiostream from the inputstream
	    AudioStream audioStream = null;
		try {
			audioStream = new AudioStream(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    // play the audio clip with the audioplayer class
	    AudioPlayer.player.start(audioStream);
	  
}

}
