package moteurJeu.moteur;

import java.awt.image.BufferedImage;

/**
 * une interface representant la maniere de dessiner sur un JPanel
 * 
 * @author vthomas
 */
public interface DessinAbstract {

	/**
	 * methode dessiner a completer. Elle construit une image correspondant au
	 * jeu. Jeu est un attribut de l'afficheur
	 * 
	 * @param image
	 *            image sur laquelle dessiner
	 */
	public abstract void dessiner(BufferedImage image);

}
