package Controller;

import java.util.ArrayList;

import GUI.*;
import Klassen.*;

public class DozentController {
	private GUIMain mainFrame;
	private Dozent me = new Dozent();
	private ArrayList<Veranstaltung> veranstaltungen;
	private ArrayList<Gruppe> gruppen;
	private ArrayList<Team> teams;
	
	public DozentController(GUIMain m,Dozent d) {
		mainFrame = m;
		me = d;
		//changing the content of the main window to the "frontpage" for Students
		mainFrame.setContent(new DVeranstaltungsuebersicht());
	}
}
