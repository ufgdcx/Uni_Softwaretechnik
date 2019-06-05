package Controller;

import Database.*;
import GUI.*;
import Klassen.*;

import java.util.ArrayList;
import java.util.Random;

public class MainController {
	protected GUIMain mainFrame;
	private Nutzer n;
	protected DBrequest dbr = new DBrequest();
	
	public MainController(GUIMain m) {
		mainFrame = m;
		mainFrame.setController(this);
	}
	
	public void login(String email, char[] passwd) {
		//handle authentification
		try {
			n = dbr.getNutzer(email,passwd);
		} catch (DatabaseException e) {

			System.out.println(e.getErrorMsg());
            return;
		}
		
		//switch to StudentController or DozentController
		if(n instanceof Dozent){
			//creating Dozent object d to pass the info to DozentController
			//and transforming Nutzer object n to Dozent object d
			Dozent d = (Dozent) n;
			new DozentController(mainFrame,d);

		}
		else{
			//creating Student object s to pass the info to StudentController
			//and transforming Nutzer object n to Student object s
			Student s = (Student) n;
			
			//Student s = new Student("abc@uni-rostock.it","1234","Lord","Hanz","Mueller","Verteidigung gegen die Dunklen Kuenste",987654321);
			new StudentController(mainFrame,s);
		}
	}
	
	public ArrayList<Veranstaltung> getVeranstaltungen(Student me){
		try {
			return dbr.getVeranstaltungen(me);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getErrorMsg());
		}
		return null;
	}
	
	public ArrayList<Veranstaltung> getVeranstaltungen(Dozent me){
		try {
			return dbr.getVeranstaltungen(me);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getErrorMsg());
		}
		return null;
	}
	
	public void setVBeschreibung(Veranstaltung veranstaltung){
		try {
			dbr.updateVeranstaltungBeschreibung(veranstaltung.getName(), veranstaltung.getBeschreibung());
		}
		catch (DatabaseException e){
			System.out.println(e.getErrorMsg());
			return;
		}
	}

    public ArrayList<Leistung> getLeistung(Team team){
        try {
            return dbr.getLeistung(team);
        } catch (DatabaseException e){
            System.out.println(e.getErrorMsg());
        }
        return null;
    }

    //TODO: Update-Methoden in DB anlegen
    /*
    public void setGruppen(Veranstaltung veranstaltung) {

        try{
            dbr.updateGruppe(veranstaltung);

        } catch (DatabaseException e) {
            System.out.println(e.getErrorMsg());
            return;
        }
    }

    public void setTeams(Gruppe gruppe) {

        try{
            dbr.updateTeams(gruppe);
        } catch (DatabaseException e) {
            System.out.println(e.getErrorMsg());
            return;
        }
    }

    public void setTeam(Student student, Gruppe gruppe) {

        try{
            dbr.updateTeam(student, gruppe);
        } catch (DatabaseException e) {
            System.out.println(e.getErrorMsg());
            return;
        }
    }

    public void setLeistung(Gruppe gruppe, Team team, Veranstaltung veranstaltung){

        try {
            dbr.updateLeistung(gruppe, team, veranstaltung);
        } catch (DatabaseException e){
            System.out.println(e.getErrorMsg());
            return;
        }
    }
     */

    //erzeugt Verifizierungscode für die Email Bestätigung
    public String generateVerifyingCode() {

        String charvalue = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        char[] chars = charvalue.toCharArray();

        String verifyingCode = "";
        Random random = new Random();

        for (int i=0; i<= 16; i++) {
            verifyingCode += chars[random.nextInt(chars.length-1)];
        }

        System.out.println(verifyingCode);

        return verifyingCode;
    }
}
