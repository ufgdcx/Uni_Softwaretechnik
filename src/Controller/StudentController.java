package Controller;
import java.util.ArrayList;

import Database.DBrequest;
import Database.DatabaseException;
import GUI.*;
import Klassen.*;

public class StudentController extends MainController{
	private Student me;
	private ArrayList<Veranstaltung> veranstaltungen;
	private ArrayList<Gruppe> gruppen;
	private ArrayList<Team> teams;
	
	public StudentController(GUIMain m,Student s) {
		super(m);
		me = s;
		buildModel();
		//changing the content of the main window to the "frontpage" for students
		mainFrame.setContent(new SVeranstaltungsuebersicht());
	}
	
	void buildModel(){
		try {
			veranstaltungen = dbr.getVeranstaltungen(me);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getVeranstaltungsnamen(){
		ArrayList<String> namen = null;
		for(Veranstaltung v : veranstaltungen){
			namen.add(v.getName());
		}
		return namen;
	}
}
