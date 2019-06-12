package Controller;

import GUI.*;
import Klassen.*;

/**@author Oleg
 *
 * Steuert die Studentenansicht.
 */

public class StudentController extends MainController{
	private Student me;

	
	public StudentController(GUIMain m,Student s) {
		super(m);
		me = s;
		//changing the content of the main window to the "frontpage" for students
		mainFrame.setContent(new SVeranstaltungsuebersicht(me, this.getAlleV(), this.getVeranstaltungen(me), 0, 1));
	}
}
