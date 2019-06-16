package Database;

/**@author Christoph, Seb */

import Klassen.*;
import org.junit.jupiter.api.*;
import utilities.FileHandler;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

/*
    Testet die verwendeten Datenbank-Methoden auf exceptions.
*/

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DBrequestTest
{
    // Member Variables
    //
    // Test information
    private DBrequest dbrequest = DBrequest.getIntstance();
    private LogWriter log = LogWriter.getIntstance();
    private boolean eo; // does an exception occur?

    // Load test student data
    private FileHandler<Student> fh_student = new FileHandler<>();
    private ArrayList<Student> student = fh_student.readFile("Testdata/Studenten.yml", Student.class);
    // Load test dozent data
    private FileHandler<Dozent> fh_dozent = new FileHandler<>();
    private ArrayList<Dozent> dozent = fh_dozent.readFile("Testdata/Dozent.yml", Dozent.class);
    // Load test Veranstaltung data
    private FileHandler<Veranstaltung> fh_veranstaltung = new FileHandler<>();
    private ArrayList<Veranstaltung> veranstaltung = fh_veranstaltung.readFile("Testdata/Veranstaltung.yml", Veranstaltung.class);

    private Gruppe g = new Gruppe(1, "Montag", new Time(System.currentTimeMillis()), "woche",
                                    new Date(System.currentTimeMillis()), veranstaltung.get(0), null, dozent.get(0) );
    private Leistung l = new Leistung("Leistungsblock 1", veranstaltung.get(0), student.get(0));
    private Unterblock u = new Unterblock("Unterblock 1", 42, l, null, student.get(0).getMatrikelnr());
    private ArrayList<Leistung> l_AL = new ArrayList<>();
    private Team t = new Team(1, "Theam 1", null, null, g);
    private Aufgabe a = new Aufgabe("Aufgabe 1", 42, u, 42);
    private Studienganganteil sa = new Studienganganteil("SAnteil", 42, t);

    // Test all DBrequest-methods
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
            //log.writetoLog("Email: " + v.getEmail(), "INFO");
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
            //log.writetoLog("Email: " + v.getEmail(), "INFO");
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
            //log.writetoLog("Veranstaltung: " + v.getName(), "INFO");
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
        //log.writetoLog("Dozent: " + dozent.get(0).getVorname(), "INFO");
        try{ dbrequest.createLeitet(dozent.get(0), veranstaltung.get(0)); } // Erster Dozent Leitete Erste Veranstaltung
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);

    }

    @Test
    @Order(5)
    void createGruppe()
    {
        eo = false;
        //log.writetoLog("Dozent: " + dozent.get(0).getVorname(), "INFO");
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

    // never used function
    @Test
    @Order(12)
    void createTeamleistung()
    {
        eo = false;
        // log.writetoLog(": " + dozent.get(0).getVorname(), "INFO");
        try{ dbrequest.createTeamleistung(l.getLbName(), u.getUbName(), l.getLbName(), t.getTeamID(), g.getGruppenID(), veranstaltung.get(0).getName(), 42); } // this also test createTeamLeistungsblock
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

    // Update
    //
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

    @Test
    @Order(52)
    void updateNutzerPasswort()
    {
        eo = false;
        try{ dbrequest.updateNutzerPasswort(student.get(0).getEmail(), student.get(0).getPasswort()); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(53)
    void updateNutzerTitle()
    {
        eo = false;
        try{ dbrequest.updateNutzerTitle(dozent.get(0).getEmail(), dozent.get(0).getTitel()); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(54)
    void updateNutzerVornamen()
    {
        eo = false;
        try{ dbrequest.updateNutzerVornamen(dozent.get(0).getEmail(), dozent.get(0).getVorname()); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(55)
    void updateNutzerNachname()
    {
        eo = false;
        try{ dbrequest.updateNutzerNachname(dozent.get(0).getEmail(), dozent.get(0).getNachname()); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(56)
    void updateDozentFakultaet()
    {
        eo = false;
        try{ dbrequest.updateDozentFakultaet(dozent.get(0).getEmail(), dozent.get(0).getFakultaet()); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(57)
    void updateVeranstaltung()
    {
        eo = false;
        try{ dbrequest.updateVeranstaltung(veranstaltung.get(0)); } // also updtae updateVeranstaltungBeschreibung, updateVeranstaltungMaximale_Teilnehmeranzahl_je_Team,  updateVeranstaltungTeamanzahl_je_Gruppe, updateVeranstaltungFakultaet
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(58)
    void updateGruppe()
    {
        eo = false;
        try{ dbrequest.updateGruppe(g); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(59)
    void updateTeam()
    {
        eo = false;
        try{ dbrequest.updateTeam(t); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(60)
    void updateTeamleistung()
    {
        eo = false;
        try{ dbrequest.updateTeamleistung(a, t); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(61)
    void updateStudienganganteil1()
    {
        eo = false;
        try{ dbrequest.updateStudienganganteil(sa); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(62)
    void updateEinzelLeistung()
    {
        eo = false;
        try{ dbrequest.updateEinzelLeistung(a, veranstaltung.get(0)); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(63)
    void updateGruppeEinschreibefrist()
    {
        eo = false;
        try{ dbrequest.updateGruppeEinschreibefrist(g.getGruppenID(), veranstaltung.get(0).getName(), g.getFrist() ); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(64)
    void updateGruppeUhrzeit()
    {
        eo = false;
        try{ dbrequest.updateGruppeUhrzeit(g.getGruppenID(), veranstaltung.get(0).getName(), g.getZeit()); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(65)
    void updateGruppeWochentag()
    {
        eo = false;
        try{ dbrequest.updateGruppeWochentag(g.getGruppenID(), veranstaltung.get(0).getName(), g.getWochentag()); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(66)
    void updateGruppeWochenrhythmus()
    {
        eo = false;
        try{ dbrequest.updateGruppeWochentag(g.getGruppenID(), veranstaltung.get(0).getName(), g.getRhythmus()); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(67)
    void updateEinzelleistungName()
    {
        eo = false;
        try{ dbrequest.updateEinzelleistungName(student.get(0).getMatrikelnr(), veranstaltung.get(0).getName(), u.getUbName(), a.getElName(), l.getLbName(), a.getElName() ); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(68)
    void updateEinzelleistungPunkte()
    {
        eo = false;
        try{ dbrequest.updateEinzelLeistung(a, veranstaltung.get(0)); } // tets updateEinzelLeistung and updateEinzelleistungPunkte
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(69)
    void updateStudienganganteil()
    {
        eo = false;
        try{ dbrequest.updateStudienganganteil(sa); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(70)
    void updateTeamThema()
    {
        eo = false;
        try{ dbrequest.updateTeam(t); } // also update TeamThema
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(71)
    void updateTeamleistungPunkte()
    {
        // TODO wo ist der unterschied: teamleistungsblockname vs teamleistungsname in unserem Klassen Model?
        eo = false;
        try{ dbrequest.updateTeamleistungPunkte(t.getTeamID(), 42, g.getGruppenID(), veranstaltung.get(0).getName(), l.getLbName(), u.getUbName(), l.getLbName()); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(72)
    void updateTeamleistungName()
    {
        eo = false;
        try{ dbrequest.updateTeamleistung(a, t); } // also update updateTeamleistung,updateTeamleistungName
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    // tested in updateVeranstaltung
//    void updateVeranstaltungTeamanzahl_je_Gruppe()
//    {
//    }
//
//    void updateVeranstaltungBeschreibung()
//    {
//    }
//
//    void updateVeranstaltungGruppenanzahl()
//    {
//    }
//
//    void updateVeranstaltungMaximale_Teilnehmeranzahl_je_Team()
//    {
//    }

    // Get
    //
    @Test
    @Order(100)
    void getNutzer()
    {
        eo = false;
        try{ dbrequest.getNutzer(dozent.get(0).getEmail(), dozent.get(0).getPasswort()); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(101)
    void getAllDozenten()
    {
        eo = false;
        try{ dbrequest.getAllDozenten(); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(102)
    void getAllStudenten()
    {
        eo = false;
        try{ dbrequest.getAllStudenten(); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(103)
    void getAllVeranstaltungen()
    {
        eo = false;
        try{ dbrequest.getAllVeranstaltungen(); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(104)
    void getVeranstaltungen()
    {
        eo = false;
        try{ dbrequest.getVeranstaltungen(dozent.get(0)); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);

        eo = false;
        try{ dbrequest.getVeranstaltungen(student.get(0)); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(105)
    void getStudenten()
    {
        eo = false;
        try{ dbrequest.getStudenten(veranstaltung.get(0)); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);

        eo = false;
        try{ dbrequest.getStudenten(t); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(106)
    void getGruppen()
    {
        eo = false;
        try{ dbrequest.getGruppen(veranstaltung.get(0)); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(107)
    void getDozent()
    {
        eo = false;
        try{ dbrequest.getDozent(dozent.get(0).getEmail()); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);

        eo = false;
        try{ dbrequest.getDozenten(veranstaltung.get(0)); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(110)
    void getTeams()
    {
        eo = false;
        try{ dbrequest.getTeams(g); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(111)
    void getTeam()
    {
        eo = false;
        try{ dbrequest.getTeam(student.get(0), g); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(112)
    void getLeistungsblock()
    {
        eo = false;
        try{ dbrequest.getLeistungsblock(student.get(0), veranstaltung.get(0)); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    // isn't used, yet
    @Test
    @Order(113)
    void getLeistung()
    {
        eo = false;
        try{ dbrequest.getLeistung(t); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(114)
    void getUnterblock()
    {
        eo = false;
        try{ dbrequest.getUnterblock(student.get(0), l, veranstaltung.get(0)); }
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
    void deleteTeamleistungsUnterblock()
    {
        eo = false;
        // log.writetoLog(": " + dozent.get(0).getVorname(), "INFO");
        try{ dbrequest.deleteTeamleistungsUnterblock(l.getLbName(), u.getUbName(), t.getTeamID(), g.getGruppenID(), veranstaltung.get(0).getName()); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    // Deprecatet method
    @Test
    @Order(153)
    void deleteTeamleistungsblock()
    {
        // TODO deleteTeamleistungsblock cant be deleted
        // deleteTeamleistungsblock(String teamleistungsblockname, int teamid, int gruppenid, String veranstaltungsname)
        eo = false;
        log.writetoLog("deleteTeamleistungsblock: " + l.getLbName(), "INFO");
        try{ dbrequest.deleteTeamleistungsblock(l.getLbName(), t.getTeamID(), g.getGruppenID(), veranstaltung.get(0).getName()); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(154)
    void deleteTeamleistung()
    {
        eo = false;
        // log.writetoLog(": " + dozent.get(0).getVorname(), "INFO");
        try{ dbrequest.deleteTeamleistung(l.getLbName(), u.getUbName(), a.getElName() , t.getTeamID(), g.getGruppenID(), veranstaltung.get(0).getName()); }
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }

    @Test
    @Order(155)
    void deleteTeam()
    {
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

    @Test
    @Order(999)
    void deleteAll()
    {
        eo = false;
        try{ dbrequest.deleteAll(); }
        catch (DatabaseException e){ System.out.println(e.getErrorMsg()); eo = true; }
        assertFalse(eo);
    }
}