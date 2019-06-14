package Controller;

import java.util.ArrayList;

import javax.swing.*;

import Database.DatabaseException;
import GUI.*;
import Klassen.*;

/**@author Oleg, Diana
 * Klasse erstellt von Oleg und erweitert von Diana
 *
 * Steuert die Studentenansicht.
 */

public class StudentController extends MainController{
	private Student me;
	private ArrayList<Veranstaltung> alleV;
	private ArrayList<Veranstaltung> eingetrageneV;
	
	public StudentController(GUIMain m,Student s) {
		super(m);
		me = s;
		buildModel();
		mainFrame.setController(this);
		//changing the content of the main window to the "frontpage" for students
		//mainFrame.setContent(new SVeranstaltungsuebersicht(me, this.getAlleV(), this.getVeranstaltungen(me), 0, 1));
		m.setContent(new SVeranstaltungsuebersicht(m));
	}
	
	private void buildModel() {
		alleV = super.getAlleV();
		eingetrageneV = super.getVeranstaltungen(me);
	}
	
	public JTree createLeistungsTree(Veranstaltung v, JScrollPane tsp) {
		return super.createLeistungsTree(v, me, tsp);
	}
	
	public Student getSubject() {
		return me;
	}
	
	public ArrayList<Veranstaltung> getAlleV(){
		return alleV;
	}
	
	public ArrayList<Veranstaltung> getVeranstaltungen(){
		return eingetrageneV;
	}
}
