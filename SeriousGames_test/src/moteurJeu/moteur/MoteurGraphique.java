package moteurJeu.moteur;

/**
 * classe MoteurGraphique represente un moteur de jeu generique.
 * 
 * On lui passe un jeu et un afficheur et il permet d'executer un jeu.
 */
public class MoteurGraphique {

	/**
	 * le jeu a executer
	 */
	private JeuAbstract jeu;

	/**
	 * l'interface graphique
	 */
	private InterfaceGraphique gui;

	/**
	 * l'afficheur a utiliser pour le rendu
	 */
	private DessinAbstract dessin;

	/**
	 * construit un moteur
	 * 
	 * @param pJeu
	 *            jeu a lancer
	 * @param pAffiche
	 *            afficheur a utiliser
	 */
	public MoteurGraphique(JeuAbstract pJeu, DessinAbstract pAffiche) {
		// creation du jeu
		this.jeu = pJeu;
		this.dessin = pAffiche;
	}

	/**
	 * permet de lancer le jeu
	 */
	public void lancerJeuBase(int width, int height, int fps) throws InterruptedException {

		// temps attente
		int tempsAttente = 1000 / fps;

		// creer interface graphique
		creerInterface(width, height);

		// boucle de jeu
		while (!this.jeu.etreFini()) {
			// fait evoluer le jeu
			this.jeu.evoluer(this.gui.clavier, this.gui.souris);
			// affiche le jeu
			this.gui.dessiner();
			// met en attente
			Thread.sleep(tempsAttente);
		}
	}

	public void lancerJeu(int width, int height, int fps) {

		// creer interface graphique
		creerInterface(width, height);

		// duree d'une boucle
		long dureeBoucle = 1000 / fps;
		System.out.println("duree d'une boucle " + dureeBoucle + "ms");
		int nbIteration = 0;

		// on recupere en nanos
		long l = System.currentTimeMillis();
		long beforeTime = System.nanoTime();

		// boucle de jeu
		while (!this.jeu.etreFini()) {
			// fait evoluer le jeu
			this.jeu.evoluer(this.gui.clavier, this.gui.souris);
			
			//on declicke au cas ou
			this.gui.souris.declick();
			this.gui.clavier.clearTouches();
			
			// affiche le jeu
			this.gui.dessiner();

			// apres le render en nanos
			long timafter = System.nanoTime();
			// duree en nanos
			long duree = dureeBoucle * 1000000L - (timafter - beforeTime);
			// System.out.println("doit attendre" + duree / 1000L);
			duree = duree / 1000000L;

			// attente dans vide
			if (duree < 0)
				System.out.println("trop de temps");
			else {
				while (System.nanoTime() - beforeTime - dureeBoucle * 1000000L < 0) {
				}
			}

			beforeTime = System.nanoTime();
			nbIteration++;
		}

		long l2 = System.currentTimeMillis();

		// statistiques
		System.out.println("\n\n\n************************\n");
		System.out.println("FPS = " + (nbIteration * 1000.0 / (l2 - l)));
		System.out.println("\n************************");
	}

	/**
	 * methode de creation interface graphique
	 * 
	 * @param width
	 *            taille interface
	 * @param height
	 *            taille interface
	 * @return controleur clavier
	 */
	private void creerInterface(int width, int height) {
		// creation de l'interface graphique
		this.gui = new InterfaceGraphique(this.dessin, width, height);
	}

}
