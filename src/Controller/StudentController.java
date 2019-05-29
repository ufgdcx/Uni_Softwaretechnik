package Controller;
import java.util.ArrayList;

import Database.DBrequest;
import GUI.*;
import Klassen.*;

public class StudentController extends MainController{
	//private GUIMain mainFrame;
	private Student me;
	private ArrayList<Veranstaltung> veranstaltungen;
	private ArrayList<Gruppe> gruppen;
	private ArrayList<Team> teams;
	
	public StudentController(GUIMain m,Student s) {
		super(m);
		me = s;
		//changing the content of the main window to the "frontpage" for students
		mainFrame.setContent(new SVeranstaltungsuebersicht());
	}
}
