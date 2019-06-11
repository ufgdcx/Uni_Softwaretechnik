/*package Database;

import Klassen.*;
import org.junit.jupiter.api.Test;
import utilities.FileHandler;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class DBrequestTest
{
    private DBrequest dbrequest = DBrequest.getIntstance();
    private LogWriter log = LogWriter.getIntstance();
    private boolean eo; // does an exception occur?

    private FileHandler<Student> fh_student = new FileHandler<>();
    private ArrayList<Student> student = fh_student.readFile("Testdata/studenten.yml", Student.class);

    private FileHandler<Dozent> fh_dozent = new FileHandler<>();
    private ArrayList<Dozent> dozent = fh_dozent.readFile("Testdata/dozenten.yml", Dozent.class);

    // Test create methods
    //
    @Test
    void dbRequestTest()
    {
        // Create methods
        // ==================================
        // create Dozent
        eo = false;
        createDozent();
        assertFalse(eo);

        // create Student
        eo = false;
        createStudent();
        assertFalse(eo);

        // create Veranstaltung

        // create Leistungsblock


        // Update methods
        // ==================================
        // Update Dozent
        eo = false;
        student.get(0).setStudiengang("CBA"); // change Studiengang
        updateDozent(); // change Fakultaet from ABC to CBA
        assertFalse(eo);

        // Update Student
        eo = false;
        dozent.get(0).setFakultaet("BIO"); // change fakultaet
        updateStudent(); // change Studiengang from IN to BIO
        assertFalse(eo);

        // Get methods
        // ==================================
        eo = false;
        // TODO add get test methods
        assertFalse(eo);


        // Delete methods
        // ==================================
        // Delete Dozent
        eo = false;
        deleteDozent();
        assertFalse(eo);

        // Delete Student
        eo = false;
        deleteStudent();
        assertFalse(eo);
    }

    // All DBrequest methods
    //
    void createStudent()
    {
        for(Student v : student)
        {
            log.writetoLog("Email: " + v.getEmail(), "INFO");
            try{ dbrequest.createStudent(v); }
            catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        }
    }

    void createDozent()
    {
        for(Dozent v : dozent)
        {
            log.writetoLog("Email: " + v.getEmail(), "INFO");
            try{ dbrequest.createDozent(v); }
            catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        }
    }

    void createLeistungsblock()
    {
    }
    
    void createGehoertZu()
    {
    }
    
    void createGruppe()
    {
    }
    
    void createLeitet()
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
    
    void createVeranstaltung()
    {
    }
    
    void createVeranstaltung1()
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

    void deleteDozent()
    {
        for(Dozent v : dozent)
        {
            log.writetoLog("Email: " + v.getEmail(), "INFO");
            try{ dbrequest.deleteDozent(v.getEmail()); }
            catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        }
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

    void deleteStudent()
    {
        for(Student v : student)
        {
            log.writetoLog("Email: " + v.getEmail(), "INFO");
            try{ dbrequest.deleteStudent(v); }
            catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
        }
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

    void deleteVeranstaltung()
    {
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

    void deleteAll()
    {
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
    
    void updateStudent()
    {
        try{ dbrequest.updateStudent(student.get(0)); } // update the database
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
    }

    
    void updateDozent()
    {
        try{ dbrequest.updateDozent(dozent.get(0)); } // update the database
        catch (DatabaseException e) { System.out.println(e.getErrorMsg()); eo = true; }
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

}*/