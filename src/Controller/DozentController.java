package Controller;
import java.util.ArrayList;

import Database.*;
import GUI.*;
import Klassen.*;

public class DozentController extends MainController{
	private Dozent me;
	private ArrayList<Veranstaltung> veranstaltungen;
	private ArrayList<Gruppe> gruppen;
	private ArrayList<Team> teams;
	protected DBrequest dbr = new DBrequest();


	
	public DozentController(GUIMain m,Dozent d) {
		super(m);
		me = d;
		//changing the content of the main window to the "frontpage" for lecturers
		mainFrame.setContent(new DVeranstaltungsuebersicht());
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
