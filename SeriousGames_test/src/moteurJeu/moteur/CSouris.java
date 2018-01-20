package moteurJeu.moteur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * permet de gerer une souris
 * 
 * @author vthomas
 *
 */
public class CSouris extends MouseAdapter {

	boolean appuye = false;
	int x = 0, y = 0;
	boolean clicked = false;

	/**
	 * detecte pression
	 */
	public void mousePressed(MouseEvent arg0) {
		this.appuye = true;
		// on met click a true (declic à chaque iteration)
		this.clicked = true;
	}

	/**
	 * permet de remettre click a faux
	 */
	void declick() {
		this.clicked = false;
	}

	/**
	 * permet de remettre click a faux
	 */
	public boolean getClicked() {
		return (this.clicked);
	}

	/**
	 * detecte lacher pression
	 */
	public void mouseReleased(MouseEvent arg0) {
		this.appuye = false;
	}

	/**
	 * bouge coordonnees
	 */
	public void mouseDragged(MouseEvent e) {
		this.x = e.getX();
		this.y = e.getY();

	}

	/**
	 * gere les coordonnees
	 */
	public void mouseMoved(MouseEvent e) {
		this.x = e.getX();
		this.y = e.getY();
	}

	/**
	 * @return abscisse souris
	 */
	public int getX() {
		return (this.x);
	}

	/**
	 * @return ordonnee souris
	 */
	public int getY() {
		return (this.y);
	}

	/**
	 * @return appuye
	 */
	public boolean isPressed() {
		return (this.appuye);
	}

}
