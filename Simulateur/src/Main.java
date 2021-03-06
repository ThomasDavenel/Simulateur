
public class Main {

	public static void main(String[] args) {
		// reglage de la taille de la fenetre de jeu, en pixels (nb: un écran fullHD =
		// 1980x1050 pixels)
		StdDraw.setCanvasSize(1000, 600);

		GameWorld world = new GameWorld();
		

		// permet le double buffering, pour type filter textpermettre l'animation
		StdDraw.enableDoubleBuffering();

		boolean val = false;
		// la boucle principale de notre jeu
		while (val) {
			// Efface la fenetre graphique
			StdDraw.clear();

			// Capture et traite les eventuelles interactions clavier du joueur
			if (StdDraw.hasNextKeyTyped()) {
				char key = StdDraw.nextKeyTyped();
				world.processUserInput(key);
			}

			if (StdDraw.isMousePressed()) {
				world.processMouseClick(StdDraw.mouseX(), StdDraw.mouseY());
			}

			
			world.step();

			// dessine la carte
			world.dessine();

			// Montre la fenetre graphique mise a jour et attends 20 millisecondes
			StdDraw.show();
			StdDraw.pause(20);

		}
	}

}
