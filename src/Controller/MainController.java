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

			e.printStackTrace();
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

	public void setVBeschreibung (Veranstaltung veranstaltung){

		try {
			dbr.updateVeranstaltungBeschreibung(veranstaltung.getName(), veranstaltung.getBeschreibung());
		}
		catch (DatabaseException e){

			e.printStackTrace();
			return;
		}
	}

    public ArrayList<Gruppe> getGruppen(Veranstaltung veranstaltung) {

        try{
            return dbr.getGruppen(veranstaltung);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Team> getTeams(Gruppe gruppe) {

        try{
            return dbr.getTeams(gruppe);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Team getTeam(Student student, Gruppe gruppe) {

        try{
            return dbr.getTeam(student, gruppe);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Leistung> getLeistung(Gruppe gruppe, Team team, Veranstaltung veranstaltung){

        try {
            return dbr.getLeistung(gruppe, team, veranstaltung);
        } catch (DatabaseException e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Leistung> getLeistungsblock(Student student, Veranstaltung veranstaltung){

        try {
            return dbr.getLeistungsblock(student, veranstaltung);
        } catch (DatabaseException e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Aufgabe> getEinzelleistung(Student student, Leistung leistung, Unterblock unterblock, Veranstaltung veranstaltung){

        try {
            return dbr.getEinzelleistung(student, leistung, unterblock, veranstaltung);
        } catch (DatabaseException e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Aufgabe> getTeamleistung(Gruppe gruppe, Team team, Leistung leistung, Unterblock unterblock, Veranstaltung veranstaltung){

        try {
            return dbr.getTeamleistung(gruppe, team, leistung, unterblock, veranstaltung);
        } catch (DatabaseException e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Unterblock> getUB(Gruppe gruppe, Team team, Leistung leistung, Veranstaltung veranstaltung){

        try {
            return dbr.getUnterblock(gruppe, team, leistung, veranstaltung);
        } catch (DatabaseException e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Unterblock> getUB(Student student, Leistung leistung, Veranstaltung veranstaltung){

        try {
            return dbr.getUnterblock(student, leistung, veranstaltung);
        } catch (DatabaseException e){
            e.printStackTrace();
        }
        return null;
    }

    //TODO: Update-Methoden in DB anlegen
    /*public void setGruppen(Veranstaltung veranstaltung) {

        try{
            dbr.updateGruppe(veranstaltung);

        } catch (DatabaseException e) {
            e.printStackTrace();
            return;
        }
    }

    public void setTeams(Gruppe gruppe) {

        try{
            dbr.updateTeams(gruppe);
        } catch (DatabaseException e) {
            e.printStackTrace();
            return;
        }
    }

    public void setTeam(Student student, Gruppe gruppe) {

        try{
            dbr.updateTeam(student, gruppe);
        } catch (DatabaseException e) {
            e.printStackTrace();
            return;
        }
    }

    public void setLeistung(Gruppe gruppe, Team team, Veranstaltung veranstaltung){

        try {
            dbr.updateLeistung(gruppe, team, veranstaltung);
        } catch (DatabaseException e){
            e.printStackTrace();
            return;
        }
    }

    public void setLeistungsblock(Student student, Veranstaltung veranstaltung){

        try {
            dbr.updateLeistung(student, veranstaltung);
        } catch (DatabaseException e){
            e.printStackTrace();
            return;
        }
    }

    public void setEinzelleistung(Student student, Leistung leistung, Unterblock unterblock, Veranstaltung veranstaltung){

        try {
            dbr.updateEinzelleistung(student, leistung, unterblock, veranstaltung);
        } catch (DatabaseException e){
            e.printStackTrace();
            return;
        }
    }

    public void setTeamleistung(Gruppe gruppe, Team team, Leistung leistung, Unterblock unterblock, Veranstaltung veranstaltung){

        try {
            dbr.updateTeamleistung(gruppe, team, leistung, unterblock, veranstaltung);
        } catch (DatabaseException e){
            e.printStackTrace();
            return;
        }
    }

    public void setUB(Gruppe gruppe, Team team, Leistung leistung, Veranstaltung veranstaltung){

        try {
            dbr.updateUnterblock(gruppe, team, leistung, veranstaltung);
        } catch (DatabaseException e){
            e.printStackTrace();
            return;
        }
    }

    public void setUB(Student student, Leistung leistung, Veranstaltung veranstaltung){

        try {
            dbr.updateUnterblock(student, leistung, veranstaltung);
        } catch (DatabaseException e){
            e.printStackTrace();
            return;
        }
    }*/

    //erzeugt Verifizierungscode für die Email Bestätigung
    public String generateVerifyingCode() {

        String charvalue = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!§$%&/()=?ßäöü{[]}";
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
