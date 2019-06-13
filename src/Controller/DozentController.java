package Controller;

import GUI.*;
import Klassen.*;

/**@author Oleg, Diana
 * Klasse erstellt von Oleg und erweitert von Diana
 *
 * Steuert die Dozentenansicht.
 */

public class DozentController extends MainController{
	private Dozent me;
	
	public DozentController(GUIMain m,Dozent d) {
		super(m);
		me = d;
		//changing the content of the main window to the "frontpage" for lecturers
		mainFrame.setContent(new DVeranstaltungsuebersicht(this.getVeranstaltungen(me), 0));
	}

	
}
