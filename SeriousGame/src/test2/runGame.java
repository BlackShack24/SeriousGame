package test2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class runGame {

	boolean first = true, stop = false, fin = false, sol = true;
	int val1, val2, comptFin=0, niveau;
	String tache, urlImg;
	Timer timer;
	LinkedList l = new LinkedList();
	int sol11[] = {0,1,2};
	int sol12[] = {1,0,2};
	int sol41[] = {0,1,2,3,4,5,6,8,9,7};
	int sol42[] = {0,1,5,3,4,2,6,8,9,7};
	int sol21[] = {2,1,0};
	int sol31[] = {0,2,1};

	
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
					if(solution()) {
						txt.setText("SUCCES !");
						urlImg = "images/cuisine_cafeOui.PNG";
						img.setIcon((Icon) new ImageIcon(urlImg));
						son ("correct");
					}
					else {
						txt.setText("ERREUR !");
						urlImg = "images/cuisine_cafeNon.PNG";
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
		if(niveau==1) {
			switch(num) {
			case 0 :
				tache = "Ajouter le café dans le filtre";
				urlImg = "images/cuisine_cafeCafe.PNG";
				son ("coffee");
				break;
			case 1 :
				tache = "Remplir d'eau";
				urlImg = "images/cuisine_cafeEau.PNG";
				son ("water");
				break;
			case 2 :
				tache = "Faire chauffer l'eau";
				urlImg = "images/cuisine_cafeFeu.PNG";
				son ("fire");
				break;
			}
		}
		else if(niveau==2) {
			switch(num) {
			case 0 :
				tache = "Alors allumer la cafetière";
				urlImg = "images/cuisine_cafeOn.png";
				son ("turnOn");
				break;
			case 1 :
				tache = "le four est allumé";
				urlImg = "images/cuisine_fourOn.png";
				son ("turnOn");
				break;
			case 2 :
				tache = "Si";
				urlImg = "images/cuisine.PNG";
				break;
			}
		}
		else if(niveau==3) {
			switch(num) {
			case 0 :
				tache = "Tant que";
				urlImg = "images/cuisine.PNG";
				break;
			case 1 :
				tache = "Alors chauffer le four";
				urlImg = "images/cuisine_fourFeu.PNG";
				son ("fire");
				break;
			case 2 :
				tache = "La café n'est pas fini";
				urlImg = "images/cuisine_cafeCafeCours.png";
				son("coffee");
				break;
			}
		}
		else if (niveau==4) {
			urlImg = "images/cuisine.PNG";
			switch(num) {
			case 0 :
				tache = "Bouton Start activé";
				urlImg = "images/cuisine_cafeOn.png";
				son ("turnOn");
				break;
			case 1 :
				tache = "Si";
				break;
			case 2 :
				tache = "Il y a de l'eau dans le bac";
				urlImg = "images/cuisine_cafeEauBac.png";
				break;
			case 3 :
				tache = "Alors chauffer l'eau à 95°";
				urlImg = "images/cuisine_cafeFeu95.png";
				son ("fire");
				break;
			case 4 :
				tache = "Tant que";
				break;
			case 5 :
				tache = "Il y a de l'eau dans le bac";
				urlImg = "images/cuisine_cafeEauBac.png";
				break;
			case 6 :
				tache = "Verser l'eau dans le compartiment à café";
				urlImg = "images/cuisine_cafeEau.PNG";
				son ("water");
				break;
			case 7 :
				tache = "Arrêter machine";
				urlImg = "images/cuisine_cafeOff.png";
				son ("turnOff");
				break;
			case 8 :
				tache = "Sinon";
				break;
			case 9 :
				tache = "Faire clignoter le voyant rouge";
				urlImg = "images/cuisine_cafeVoyant.png";
				//son ("alarm");
				break;
			}
		}

		return tache;
	}

	public boolean solution() {
		int tab[] = new int[l.size()];
		for(int i = 0 ; i < l.size() ; i++) tab[i] = (int) l.get(i);
		if(niveau==1) return (tabEgaux(tab, sol11) || tabEgaux(tab, sol12));
		if(niveau==2) return (tabEgaux(tab, sol21));
		if(niveau==3) return (tabEgaux(tab, sol31));
		if(niveau == 4) return (tabEgaux(tab, sol41) || tabEgaux(tab, sol42));
		return false;
	}
	
	public boolean tabEgaux(int tab[], int tab2[]) {
		for(int i = 0 ; i < tab.length ; i++) if(tab[i]!=tab2[i]) return false;
		return true;
	}
	
	//methode permettant de jouer un son, le string "son" définit quel son est joué
	public void son (String son) {
		
	    // open the sound file as a Java input stream
	    String gongFile = "sounds/"+son+".wav";
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
