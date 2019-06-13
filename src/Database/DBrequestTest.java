package Database;

import Klassen.*;
import org.junit.jupiter.api.*;
import utilities.FileHandler;
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
    }

    @Test
    @Order(5)
    void createGruppe()
    {
        // braucht
        // veranstaltung und dozenten
    }

    @Test
    @Order(6)
    void createLeistungsblock()
    {
    }


    void createGehoertZu()
    {
    }
    



    void createStudienganganteil()
    {
    }

    void createTeam()
    {
    }

    void createTeamleistung()
    {
    }

    void createTeamLeistungsUnterblock()
    {
    }

    void createTeamLeistungsblock()
    {
    }

    void createUnterblock()
    {
    }
    
    void createEinzelleistung()
    {
    }

    void createGehoert_zu()
    {
    }

    void deleteUnterblock()
    {
    }

    void deleteEinzelleistung()
    {
    }

    @Test
    @Order(100)
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

    void deleteLeitet()
    {
    }

    @Test
    @Order(101)
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
    @Order(99)
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