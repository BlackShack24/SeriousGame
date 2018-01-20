package moteurJeu.moteur;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;

/**
 * classe qui represente un controleur en lien avec un KeyListener
 * 
 * @author vthomas
 * 
 */
public class CClavier implements KeyListener {

	/**
	 * les touches appuyees a un instant donne
	 */
	private HashSet<Integer> touches;
	private HashSet<Integer> touchesPressed;

	/**
	 * construction du controleur par defaut le controleur n'a pas de commande
	 */
	public CClavier() {
		this.touches = new HashSet<Integer>();
		this.touchesPressed = new HashSet<Integer>();
	}

	/**
	 * permet de savoir si une touche est appuyee
	 * 
	 * @param charCode
	 *            le code de la touche
	 * @return vrai si la touche est appuyee
	 */
	public boolean isPressed(int charCode) {
		return (touches.contains(charCode));
	}

	/**
	 * permet de savoir si une touche est tapee
	 * 
	 * @param charCode
	 *            le code de la touche
	 * @return vrai si la touche est tapee
	 */
	public boolean getTyped(int charCode) {
		return (touchesPressed.contains(charCode));
	}

	/**
	 * permet de supprimer les touches tapees
	 */
	void clearTouches() {
		touchesPressed.clear();
	}

	@Override
	/**
	 * met a jour les commandes en fonctions des touches appuyees
	 */
	public void keyPressed(KeyEvent e) {
		int chark = e.getKeyCode();
		this.touches.add(chark);
		this.touchesPressed.add(chark);
	}

	@Override
	/**
	 * met a jour les commandes quand le joueur relache une touche
	 */
	public void keyReleased(KeyEvent e) {
		int chark = e.getKeyCode();
		this.touches.remove(chark);
	}

	@Override
	/**
	 * ne fait rien
	 */
	public void keyTyped(KeyEvent e) {

	}

}
