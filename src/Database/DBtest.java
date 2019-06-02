package Database;

import Klassen.Dozent;
import Klassen.Nutzer;
import Klassen.Veranstaltung;

import java.io.BufferedWriter;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class DBtest
{
    public static void main(String[] args) throws Exception{

        DBrequest b = new DBrequest();

        LogWriter buffer = LogWriter.getIntstance();
        buffer.writetoLog("Start Logdata\n", "INFO");

        // Test create methods

        try {
            b.createNutzer("test@email.com", "Herr", "bob", "boob", "123");

        }catch(DatabaseException ex){
        }
        try {
            b.createNutzer("test@email.com","Herr","bob","boob","123");
        } catch (DatabaseException ex) {
        }
        try {
            b.createNutzer("bob@baumeister.com","lord","bill","Clinton","polen");
        } catch (DatabaseException ex) {
        }
        try {
            b.createDozent("test@email.com", "Ameise");
        } catch (DatabaseException ex) {
        }
        try {
            b.createStudent("bob@baumeister.com",79,"Imker");
        } catch (DatabaseException ex) {
        }
        try {
            b.createVeranstaltung("Mobbing", "Hogwarts", 42, 10, "9/10 Menschen finden Mobbing gut");
        } catch (DatabaseException ex) {
        }
        try {
            b.createLeitet("Mobbing", "test@email.com");
        } catch (DatabaseException ex) {
        }
        /*try {
            b.createGruppe(42, "test@email.com", "Mobbing", new Date(System.currentTimeMillis()), new Time(System.currentTimeMillis()), "Mittwoch", "ger");
        } catch (DatabaseException ex) {
        }*/
        try {
            b.createTeam(3, 42, "Mobbing", "Cybermobbing");
        } catch (DatabaseException ex) {
        }
        try {
            b.createGehoertZu(79, 3, 42, "Mobbing");
        } catch (DatabaseException ex) {
        }
        try {
            b.createLeistungsblock(79, "Bob", "Mobbing");
        } catch (DatabaseException ex) {
        }
        /*try {
            b.createUnterblock(79, "Bob", "A1", "Mobbing");
        } catch (DatabaseException ex) {
        }*/
//        try {
//            b.createTeamleistung("Bob2", 3, 42, "Mobbing", 42);
//        } catch (DatabaseException ex) {
//        }
        try {
            b.createStudienganganteil("Bilologie", 3, 42, "Mobbing", 1);
        } catch (DatabaseException ex) {
        }

        // Test get methods
        //
        ArrayList<String> a = null;
//        try {
//            buffer.write("Teste Funktion: b.getVeranstaltungsnamen(new Dozent(\"test@email.com\",\"123\",\"Herr\",\"bob\",\"boob\",\"Ameise\"));\n");
//            //a = b.getVeranstaltungsnamen(new Dozent("test@email.com","123","Herr","bob","boob","Ameise"));
//
//            for(int i=0; i<a.size();i++)
//                System.out.println(a.get(i));
//        } catch (DatabaseException ex) {
//            buffer.write(ex.getErrorMsg());
//        }
        try {
            Nutzer student = b.getNutzer("bob@baumeister.com", "polen");
            System.out.println(student.getVorname());
        } catch (DatabaseException ex) {
        }
        try {
            Nutzer dozent = b.getNutzer("test@email.com", "123");
            System.out.println(dozent.getVorname());
        } catch (DatabaseException ex) {
        }


        // Test update methods
        //
//        b.updateNutzerPasswort("test@email.com", "123456");
//        b.updateNutzerTitle("test@email.com", "Overlord");
//        b.updateNutzerVornamen("test@email.com", "bab");
//        b.updateNutzerNachname("test@email.com", "baab");
//        b.updateStudentStudiengang("bob@baumeister.com", "Ingenieur");
//        b.updateDozentFakultaet("test@email.com", "Meeresbiologie");
//        b.updateGruppeEinschreibefrist(42, "Mobbing", new Date(System.currentTimeMillis()) );
//        b.updateGruppeUhrzeit(42, "Mobbing", new Time(System.currentTimeMillis()));
//        b.updateGruppeWochentag(42,"Mobbing", "Tag");
//        b.updateGruppeWochenrhythmus(42,"Mobbing", "ungerW");
//        b.updateUBName(79,"Mobbing", "Mobbing for mature Students", "Bob", "A1");
//        b.updateUBPunkte(79, 43, "Bob", "A1", "Mobbing");
//        b.updateStudienganganteil("Biologie", 42, 3, 42, "Mobbing");
//        b.updateTeamThema(3, "Cybermobbing 2", 42, "Mobbing");
//        b.updateTeamleistungPunkte(3, 43, 42, "Mobbing");
//        b.updateTeamleistungName(3, "Leistung1", 42, "Mobbing");
//        b.updateVeranstaltungTeamanzahl_je_Gruppe("Mobbing", 42);
//        b.updateVeranstaltungBeschreibung("Mobbing", "Hier lernt man Leute zu demotivieren");
//        b.updateVeranstaltungMaximale_Teilnehmeranzahl_je_Team("Mobbing", 42);


        // Test delet methods
        //
        /*b.deleteUnterblock(79, "Bob", "A1", "Mobbing");
        b.deleteLeistungsblock(79, "Bob", "Mobbing");
        b.deleteStudienganganteil("Bilologie", 3, 42, "Mobbing");
        //b.deleteTeamleistung("Bob2", 3, 42, "Mobbing");
        b.deleteGehoertZu(79, 3, 42, "Mobbing");
        b.deleteTeam(3, 42, "Mobbing");
        b.deleteGruppe(42, "Mobbing");
        b.deleteLeitet("Mobbing", "test@email.com");
        b.deleteVeranstaltung("Mobbing");
        b.deleteDozent("test@email.com");
        b.deleteStudent("bob@baumeister.com");
        b.deleteNutzer("test@email.com");
        b.deleteNutzer("bob@baumeister.com");
//        try {
//            buffer.write("Teste Funktion: b.createNutzer(\"test@email.com\", \"Herr\", \"bob\", \"boob\", \"123\");(Nutzer existiert noch nicht)\n");
//            a = b.getVeranstaltungsnamen(new Dozent("test@email.com","123","Herr","bob","boob","Ameise"));
//            for(int i=0; i<a.size();i++)
//                System.out.println(a.get(i));
//        } catch (DatabaseException ex) {
//            buffer.write(ex.getErrorMsg());
//        }

        try {
            buffer.write("Teste Funktion: b.createNutzer(\"test@email.com\", \"Herr\", \"bob\", \"boob\", \"123\");(Nutzer existiert noch nicht)\n");
            Nutzer student = b.getNutzer("bob@baumeister.com", "polen");
        } catch (DatabaseException ex) {
            buffer.write(ex.getErrorMsg());
        }
        buffer.write("\nEND\n");*/
        buffer.close();
    }
}