package Controller;
import java.util.ArrayList;

import GUI.*;
import Klassen.*;

public class StudentController {
	private GUIMain mainFrame;
	private Student me;
	private ArrayList<Veranstaltung> veranstaltungen;
	private ArrayList<Gruppe> gruppen;
	private ArrayList<Team> teams;
	
	public StudentController(GUIMain m,Student s) {
		mainFrame = m;
		me = s;
		//changing the content of the main window to the "frontpage" for Students
		mainFrame.setContent(new SVeranstaltungsübersicht());
	}
}
