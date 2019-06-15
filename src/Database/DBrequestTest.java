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

    private Gruppe g = new Gruppe(1, "Montag", new Time(System.currentTimeMillis()), "woche",
                                    new Date(System.currentTimeMillis()), veranstaltung.get(0), null, dozent.get(0) );
    private Leistung l = new Leistung("Leistungsblock 1", veranstaltung.get(0), student.get(0));
    private Unterblock u = new Unterblock("Unterblock 1", 42, l, null, student.get(0).getMatrikelnr());
    private Team t = new Team(1, "Theam 1", null, null, g);
    private Aufgabe a = new Aufgabe("Aufgabe 1", 42, u, 42);
    private Studienganganteil sa = new Studienganganteil("SAnteil", 42, t);


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
        eo = false;
        // log.writetoLog(": " + dozent.get(0).getVorname(), "INFO");
        try{ dbrequest.createLeistungEinzel(l); } // this also test createLeistungsBlock
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);

    }

    @Test
    @Order(7)
    void createUnterblock()
    {
        eo = false;
        // log.writetoLog(": " + dozent.get(0).getVorname(), "INFO");
        try{ dbrequest.createUnterblockEinzel(u); } // this also test  createUnterblock
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);

    }

    @Test
    @Order(8)
    void createEinzelleistung()
    {
        eo = false;
        // log.writetoLog(": " + dozent.get(0).getVorname(), "INFO");
        try{ dbrequest.createAufgabeEinzel(a); } // this also test  createAufgabeEinzel,createEinzelleistung
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);

    }

    @Test
    @Order(9)
    void createTeam()
    {
        eo = false;
        // log.writetoLog(": " + dozent.get(0).getVorname(), "INFO");
        try{ dbrequest.createTeam(t); } // this also test  createAufgabeEinzel,createEinzelleistung
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(10)
    void createTeamLeistungsblock()
    {
        eo = false;
        // log.writetoLog(": " + dozent.get(0).getVorname(), "INFO");
        try{ dbrequest.createLeistungTeam(l,t); } // this also test createTeamLeistungsblock
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);

    }

    @Test
    @Order(11)
    void createTeamLeistungsUnterblock() // createUnterblockTeam
    {
        eo = false;
        // log.writetoLog(": " + dozent.get(0).getVorname(), "INFO");
        try{ dbrequest.createUnterblockTeam(u, t); } // this also test createTeamLeistungsblock
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(12)
    void createTeamleistung()
    {
        eo = false;
        // log.writetoLog(": " + dozent.get(0).getVorname(), "INFO");
        try{ dbrequest.createAufgabeTeam(a, t); } // this also test createTeamLeistungsblock
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(13)
    void createStudienganganteil() // createLeistungTeam
    {
        eo = false;
        // log.writetoLog(": " + dozent.get(0).getVorname(), "INFO");
        try{ dbrequest.createStudienganganteil(sa); } // this also test createLeistungTeam
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(14)
    void createGehoert_zu()
    {
        eo = false;
        // log.writetoLog(": " + dozent.get(0).getVorname(), "INFO");
        try{ dbrequest.createGehoert_zu(student.get(0), t); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }



    // Delete
    //

    @Test
    @Order(150)
    void deleteGehoertZu()
    {
        eo = false;
        // log.writetoLog(": " + dozent.get(0).getVorname(), "INFO");
        try{ dbrequest.deleteGehoertZu(student.get(0).getMatrikelnr(), t.getTeamID(), t.getGruppe().getGruppenID(),
                                       t.getGruppe().getVeranstaltung().getName()); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(151)
    void deleteStudienganganteil()
    {
        eo = false;
        // log.writetoLog(": " + dozent.get(0).getVorname(), "INFO");
        try{ dbrequest.deleteStudienganganteil(sa.getStudiengang(), sa.getTeam().getTeamID(),
                                               sa.getTeam().getGruppe().getGruppenID(),
                                               sa.getTeam().getGruppe().getVeranstaltung().getName()); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
    }

    @Test
    @Order(152)
    void deleteTeamleistung()
    {
        //deleteTeamleistung(String teamleistungsblockname, String teamleistungsunterblockname, String teamleistungsname,int teamid, int gruppenid, String veranstaltungsname)
        eo = false;
        // log.writetoLog(": " + dozent.get(0).getVorname(), "INFO");
        try{ dbrequest.deleteTeamleistung(l.getLbName(), u.getUbName(), a.getElName() , t.getTeamID(), g.getGruppenID(), veranstaltung.get(0).getName()); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(153)
    void deleteTeamleistungsUnterblock()
    {
        // deleteTeamleistungsUnterblock(String teamleistungsblockname, String teamleistungsunterblockname, int teamid, int gruppenid, String veranstaltungsname)
        eo = false;
        // log.writetoLog(": " + dozent.get(0).getVorname(), "INFO");
        try{ dbrequest.deleteTeamleistungsUnterblock(l.getLbName(), u.getUbName(), t.getTeamID(), g.getGruppenID(), veranstaltung.get(0).getName()); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(154)
    void deleteTeamleistungsblock()
    {
        // deleteTeamleistungsblock(String teamleistungsblockname, int teamid, int gruppenid, String veranstaltungsname)
        eo = false;
        log.writetoLog("deleteTeamleistungsblock: " + l.getLbName(), "INFO");
        try{ dbrequest.deleteTeamleistungsblock(l.getLbName(), t.getTeamID(), t.getGruppe().getGruppenID(), veranstaltung.get(0).getName()); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(155)
    void deleteTeam()
    {
        // deleteTeam(int teamid, int gruppenid, String veranstaltungsname)
        eo = false;
        // log.writetoLog(": " + dozent.get(0).getVorname(), "INFO");
        try{ dbrequest.deleteTeam(t.getTeamID(), g.getGruppenID(), veranstaltung.get(0).getName()); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(156)
    void deleteEinzelleistung()
    {
        // deleteEinzelleistung(int matrikelnummer, String leistungsblockname, String unterblockname, String einzelleistungsname,String veranstaltungsname)
        eo = false;
        // log.writetoLog(": " + dozent.get(0).getVorname(), "INFO");
        try{ dbrequest.deleteEinzelleistung(l.getStudent().getMatrikelnr(), l.getLbName(), u.getUbName(),
                                            a.getElName(), l.getVeranstaltung().getName()); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
    }

    @Test
    @Order(157)
    void deleteUnterblock()
    {
        // deleteUnterblock(int matrikelnummer, String leistungsblockname, String unterblockname, String veranstaltungsname)
        eo = false;
        // log.writetoLog(": " + dozent.get(0).getVorname(), "INFO");
        try{ dbrequest.deleteUnterblock(l.getStudent().getMatrikelnr(),
                                        l.getLbName(), u.getUbName(), l.getVeranstaltung().getName()); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
    }

    @Test
    @Order(158)
    void deleteLeistungsblock()
    {
        // deleteLeistungsblock(int matrikelnummer, String leistungsblockname, String veranstaltungsname)
        eo = false;
        // log.writetoLog(": " + dozent.get(0).getVorname(), "INFO");
        try{ dbrequest.deleteLeistungsblock(l.getStudent().getMatrikelnr(),
                                            l.getLbName(), l.getVeranstaltung().getName()); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
    }

    @Test
    @Order(159)
    void deleteGruppe()
    {
        // deleteGruppe(int gruppenid, String veranstaltungsname)
        eo = false;
        // log.writetoLog(": " + dozent.get(0).getVorname(), "INFO");
        try{ dbrequest.deleteGruppe(g.getGruppenID(), g.getVeranstaltung().getName()); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
    }

    @Test
    @Order(160)
    void deleteLeitet()
    {
        eo = false;
        // log.writetoLog(": " + dozent.get(0).getVorname(), "INFO");
        try{ dbrequest.deleteLeitet(veranstaltung.get(0)); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
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