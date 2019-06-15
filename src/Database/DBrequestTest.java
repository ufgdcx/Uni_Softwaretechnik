package Database;

import Klassen.*;
import org.junit.jupiter.api.*;
import utilities.FileHandler;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DBrequestTest
{
    private DBrequest dbrequest = DBrequest.getIntstance();
    private LogWriter log = LogWriter.getIntstance();
    private boolean eo; // does an exception occur?

    // Load test student data
    private FileHandler<Student> fh_student = new FileHandler<>();
    private ArrayList<Student> student = fh_student.readFile("Testdata/studenten.yml", Student.class);
    // Load test dozent data
    private FileHandler<Dozent> fh_dozent = new FileHandler<>();
    private ArrayList<Dozent> dozent = fh_dozent.readFile("Testdata/dozenten.yml", Dozent.class);
    // Load test Veranstaltung data
    private FileHandler<Veranstaltung> fh_veranstaltung = new FileHandler<>();
    private ArrayList<Veranstaltung> veranstaltung = fh_veranstaltung.readFile("Testdata/veranstaltungen.yml", Veranstaltung.class);

    // All DBrequest methods
    //
    // Create
    //
    @Test
    @Order(1)
    void createStudent()
    {
        eo = false;
        for(Student v : student)
        {
            log.writetoLog("Email: " + v.getEmail(), "INFO");
            try{ dbrequest.createStudent(v); }
            catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        }
        assertFalse(eo);
    }

    @Test
    @Order(2)
    void createDozent()
    {
        eo = false;
        for(Dozent v : dozent)
        {
            log.writetoLog("Email: " + v.getEmail(), "INFO");
            try{ dbrequest.createDozent(v); }
            catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        }
        assertFalse(eo);
    }

    @Test
    @Order(3)
    void createVeranstaltung()
    {
        eo = false;
        for(Veranstaltung v : veranstaltung)
        {
            log.writetoLog("Veranstaltung: " + v.getName(), "INFO");
            try{ dbrequest.createVeranstaltung(v); }
            catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        }
        assertFalse(eo);
    }

    @Test
    @Order(4)
    void createLeitet()
    {
        // braucht
        // dozenten und veranstaltung

        eo = false;
        log.writetoLog("Dozent: " + dozent.get(0).getVorname(), "INFO");
        try{ dbrequest.createLeitet(dozent.get(0), veranstaltung.get(0)); } // Erster Dozent Leitete Erste Veranstaltung
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);

    }

    @Test
    @Order(5)
    void createGruppe()
    {
        // braucht
        // veranstaltung und dozenten

        Gruppe g = new Gruppe(1, "Montag", new Time(System.currentTimeMillis()), "woche",
                new Date(System.currentTimeMillis()),
                veranstaltung.get(0), null, dozent.get(0) );

        eo = false;
        log.writetoLog("Dozent: " + dozent.get(0).getVorname(), "INFO");
        try{ dbrequest.createGruppe(g); } // Erste Veranstaltung und Erster Dozent
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(6)
    void createLeistungsblock()
    {

//        createLeistungsblock(
//        leistungs.getStudent().getMatrikelnr(),
//        leistungs.getLbName(),
//        leistungs.getVeranstaltung().getName());

        Leistung l = new Leistung("Leistungsblock 1", veranstaltung.get(0), student.get(0));

        eo = false;
        // log.writetoLog(": " + dozent.get(0).getVorname(), "INFO");
        try{ dbrequest.createLeistungEinzel(l); } // this also test createLeistungsBlock
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);

    }

    void createUnterblock()
    {
//        this.ubName = ubName;
//        this.ubPunkte = ubPunkte;
//        this.oberL = l;
//        this.aufgaben = a;
//        this.matrikel = matrikel;

        Leistung l = new Leistung("Leistungsblock 1", veranstaltung.get(0), student.get(0));
        Unterblock u = new Unterblock("Unterblock 1", 42, l, null, student.get(0).getMatrikelnr());

        eo = false;
        // log.writetoLog(": " + dozent.get(0).getVorname(), "INFO");
        try{ dbrequest.createUnterblockEinzel(u); } // this also test  createUnterblock
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);

    }

    void createEinzelleistung()
    {
        // aufrufen createAufgabeEinzel
//        this.elName = elName;
//        this.elPunkte = elPunkte;
//        this.unterblock = unterblock;
//        this.maxPunkte =maxPunkte;

        Leistung l = new Leistung("Leistungsblock 1", veranstaltung.get(0), student.get(0));
        Unterblock u = new Unterblock("Unterblock 1", 42, l, null, student.get(0).getMatrikelnr());
        Aufgabe a = new Aufgabe("Aufgabe 1", 42, u, 42);

        eo = false;
        // log.writetoLog(": " + dozent.get(0).getVorname(), "INFO");
        try{ dbrequest.createAufgabeEinzel(a); } // this also test  createAufgabeEinzel,createEinzelleistung
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);

    }

    void createTeam()
    {
//        public Team(int teamID, String thema, ArrayList<Studienganganteil> anteile, ArrayList<Leistung> teaml, Gruppe gruppe)
//        {
//            this.teamID = teamID;
//            this.thema = thema;
//            this.anteile = anteile;
//            this.leistungen = teaml;
//            this.gruppe = gruppe;
////        }
//        createTeam(team.getTeamID(),
//                team.getGruppe().getGruppenID(),
//                team.getGruppe().getVeranstaltung().getName(),
//                team.getThema());
//    }

        Gruppe g = new Gruppe(1, "Montag", new Time(System.currentTimeMillis()), "woche",
                new Date(System.currentTimeMillis()),
                veranstaltung.get(0), null, dozent.get(0) );

        Team t = new Team(1, "Theam 1", null, null, g);

        eo = false;
        // log.writetoLog(": " + dozent.get(0).getVorname(), "INFO");
        try{ dbrequest.createTeam(t); } // this also test  createAufgabeEinzel,createEinzelleistung
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    void createTeamLeistungsblock()
    {
//        public void createLeistungTeam(Leistung leistungs,Team team) throws DatabaseException
//        {
//            createTeamLeistungsblock(leistungs.getLbName(),
//                    team.getTeamID(),
//                    team.getGruppe().getGruppenID(),
//                    leistungs.getVeranstaltung().getName());
//        }

        Leistung l = new Leistung("Leistungsblock 1", veranstaltung.get(0), student.get(0));
        Team t = new Team(1, "Theam 1", null, null, g);

        eo = false;
        // log.writetoLog(": " + dozent.get(0).getVorname(), "INFO");
        try{ dbrequest.createLeistungTeam(l,t); } // this also test createTeamLeistungsblock
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);

    }

    void createTeamLeistungsUnterblock()
    {
    }

    void createTeamleistung()
    {
    }

    void createStudienganganteil()
    {
    }
    

    void createGehoert_zu()
    {
    }


    // Delete
    //
    void deleteUnterblock()
    {
    }

    void deleteEinzelleistung()
    {
    }

    @Test
    @Order(191)
    void deleteDozent()
    {
        eo = false;
        for(Dozent v : dozent)
        {
            log.writetoLog("Email: " + v.getEmail(), "INFO");
            try{ dbrequest.deleteDozent(v); }
            catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        }
        assertFalse(eo);
    }
    
    void deleteGehoertZu()
    {
    }
    
    void deleteGruppe()
    {
    }
    
    void deleteLeistungsblock()
    {
    }

    @Test
    @Order(100)
    void deleteLeitet()
    {
        eo = false;
        log.writetoLog("Dozent: " + dozent.get(0).getVorname(), "INFO");
        try{ dbrequest.createLeitet(dozent.get(0), veranstaltung.get(0)); } // Erster Dozent Leitete Erste Veranstaltung
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(192)
    void deleteStudent()
    {
        eo = false;
        for(Student v : student)
        {
            log.writetoLog("Email: " + v.getEmail(), "INFO");
            try{ dbrequest.deleteStudent(v); }
            catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        }
        assertFalse(eo);
    }

    void deleteStudienganganteil()
    {
    }
    
    void deleteTeam()
    {
    }

    void deleteTeamleistungsblock()
    {
    }
    
    void deleteTeamleistungsUnterblock()
    {
    }
    
    void deleteTeamleistung()
    {
    }

    @Test
    @Order(190)
    void deleteVeranstaltung()
    {
        eo = false;
        for(Veranstaltung v : veranstaltung)
        {
            log.writetoLog("Veranstaltung: " + v.getName(), "INFO");
            try{ dbrequest.deleteVeranstaltung(v.getName()); }
            catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        }
        assertFalse(eo);
    }


    void getNutzer()
    {
    }

    void getVeranstaltungen()
    {
    }
    
    void getGruppenanzahl()
    {
    }
    
    void getAllDozenten()
    {
    }

    void getAllStudenten()
    {
    }

    void getStudenten()
    {
    }

    void getGruppen()
    {
    }

    void getDozent()
    {
    }

    void getTeams()
    {
    }

    void getTeam()
    {
    }

    
    void getLeistungsblock()
    {
    }

    
    void getLeistung()
    {
    }

    
    void getAllVeranstaltungen()
    {
    }

    
    void updateNutzerPasswort()
    {
    }

    
    void updateNutzerTitle()
    {
    }

    
    void updateNutzerVornamen()
    {
    }

    
    void updateNutzerNachname()
    {
    }

    void updateDozentFakultaet()
    {
    }
    
    void updateGruppeEinschreibefrist()
    {
    }

    void updateGruppeUhrzeit()
    {
    }
    
    void updateGruppeWochentag()
    {
    }
    
    void updateGruppeWochenrhythmus()
    {
    }
    
    void updateEinzelleistungName()
    {
    }

    void updateEinzelleistungPunkte()
    {
    }
    
    void updateStudienganganteil()
    {
    }

    void updateTeamThema()
    {
    }
    
    void updateTeamleistungPunkte()
    {
    }

    void updateTeamleistungName()
    {
    }
    
    void updateVeranstaltungTeamanzahl_je_Gruppe()
    {
    }
    
    void updateVeranstaltungBeschreibung()
    {
    }
    
    void updateVeranstaltungGruppenanzahl()
    {
    }
    
    void updateVeranstaltungMaximale_Teilnehmeranzahl_je_Team()
    {
    }

    @Test
    @Order(999)
    void deleteAll()
    {
        eo = false;
        try{ dbrequest.deleteAll(); }
        catch (DatabaseException e){ System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    void getIntstance()
    {
    }
    
    void close()
    {
    }
    
    void resultSize()
    {
    }

    @Test
    @Order(50)
    void updateStudent()
    {
        eo = false;
        try{ dbrequest.updateStudent(student.get(0)); } // update the database
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(51)
    void updateDozent()
    {
        eo = false;
        try{ dbrequest.updateDozent(dozent.get(0)); } // update the database
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    
    void updateVeranstaltung()
    {
    }

    void updateGruppe()
    {
    }

    void updateTeam()
    {
    }
    
    void updateTeamleistung()
    {
    }
    
    void updateStudienganganteil1()
    {
    }
    
    void updateEinzelLeistung()
    {
    }

}