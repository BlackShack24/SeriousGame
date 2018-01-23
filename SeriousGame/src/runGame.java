import java.util.Hashtable;

import javax.swing.JLabel;

public class runGame {
	public runGame(Hashtable ht, JLabel txt) {
		txt.setText("LOL");
		System.out.println("Debut execution tache");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//txt.setText("ENORME");
		System.out.println("Fin execution tache ");
	}
}
