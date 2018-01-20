package moteurJeu.moteur;

/**
 * represente un jeu un jeu est caracterise par la methode evoluer a redefinir
 * 
 * @author Graou
 *
 */
public interface JeuAbstract {

	/**
	 * methode qui contient l'evolution du jeu en fonction de la commande
	 * 
	 * @param clavier
	 *            commande utilisateur
	 * @param souris
	 *            commande souris
	 * 
	 * @return nouveau mode
	 * 
	 */
	public String evoluer(CClavier clavier, CSouris souris);

	/**
	 * @return true si et seulement si le jeu est fini
	 */
	public boolean etreFini();
}
