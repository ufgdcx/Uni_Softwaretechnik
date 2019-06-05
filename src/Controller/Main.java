package Controller;

import GUI.*;

/**
 * Mainklasse zur Ausfuehrung des Programms.
 * @author Oleg Mayer
 * @author Christoph Häseker
 * @author Sven Hagemann
 * @author Diana Bürger
 * @author Sebastian Beleites
 * @author Kristi Bartelt
 */
public class Main {
	
	public static void main(String[] args) {
		//GUIMain renders the main window, which is then filled with content
		//new GUIMain(800,600);
		new MainController(new GUIMain(800,600));
		return;
	}
}
