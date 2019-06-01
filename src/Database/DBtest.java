package Database;

import Klassen.Dozent;
import Klassen.Nutzer;

import java.io.BufferedWriter;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class DBtest
{
    public static void main(String[] args) throws Exception{

        DBrequest b = new DBrequest();

        BufferedWriter buffer = LogWriter.getIntstance();
        buffer.write("Start Logdata:\n");


        // Test create methods
        //
        try {
            buffer.write("Teste Funktion: b.createNutzer(\"test@email.com\", \"Herr\", \"bob\", \"boob\", \"123\");(Nutzer existiert noch nicht)\n");
            b.createNutzer("test@email.com", "Herr", "bob", "boob", "123");

            buffer.write("Nutzer erfolgreich erstellt");
        }catch(DatabaseException ex){
            buffer.write(ex.getErrorMsg());
        }
        try {
            buffer.write("Teste Funktion: b.createNutzer(\"test@email.com\",\"Herr\",\"bob\",\"boob\",\"123\");\n");
            b.createNutzer("test@email.com","Herr","bob","boob","123");
        } catch (DatabaseException ex) {
            buffer.write(ex.getErrorMsg()+ "\n");
        }
        try {
            buffer.write("Teste Funktion: b.createNutzer(\"bob@baumeister.com\",\"lord\",\"bill\",\"Clinton\",\"polen\");\n");
            b.createNutzer("bob@baumeister.com","lord","bill","Clinton","polen");
        } catch (DatabaseException ex) {
            buffer.write(ex.getErrorMsg());
        }
        try {
            buffer.write("Teste Funktion: b.createDozent(\"test@email.com\", \"Ameise\");\n");
            b.createDozent("test@email.com", "Ameise");
        } catch (DatabaseException ex) {
            buffer.write(ex.getErrorMsg());
        }
        try {
            buffer.write("Teste Funktion: b.createStudent(\"bob@baumeister.com\",79,\"Imker\");\n");
            b.createStudent("bob@baumeister.com",79,"Imker");
        } catch (DatabaseException ex) {
            buffer.write(ex.getErrorMsg());
        }
        try {
            buffer.write("Teste Funktion: b.createVeranstaltung(\"Mobbing\", \"Hogwarts\", 42, 10, \"9/10 Menschen finden Mobbing gut\");\n");
            b.createVeranstaltung("Mobbing", "Hogwarts", 42, 10, "9/10 Menschen finden Mobbing gut");
        } catch (DatabaseException ex) {
            buffer.write(ex.getErrorMsg());
        }
        try {
            buffer.write("Teste Funktion: b.createLeitet(\"Mobbing\", \"test@email.com\");\n");
            b.createLeitet("Mobbing", "test@email.com");
        } catch (DatabaseException ex) {
            buffer.write(ex.getErrorMsg());
        }
        try {
            buffer.write("Teste Funktion: b.createGruppe(42, \"test@email.com\", \"Mobbing\", new Date(System.currentTimeMillis()), new Time(System.currentTimeMillis()), \"Mittwoch\", \"ger\");\n");
            b.createGruppe(42, "test@email.com", "Mobbing", new Date(System.currentTimeMillis()), new Time(System.currentTimeMillis()), "Mittwoch", "ger");
        } catch (DatabaseException ex) {
            buffer.write(ex.getErrorMsg());
        }
        try {
            buffer.write("Teste Funktion: b.createTeam(3, 42, \"Mobbing\", \"Cybermobbing\");\n");
            b.createTeam(3, 42, "Mobbing", "Cybermobbing");
        } catch (DatabaseException ex) {
            buffer.write(ex.getErrorMsg());
        }
        try {
            buffer.write("Teste Funktion: b.createGehoertZu(79, 3, 42, \"Mobbing\");\n");
            b.createGehoertZu(79, 3, 42, "Mobbing");
        } catch (DatabaseException ex) {
            buffer.write(ex.getErrorMsg());
        }
        try {
            buffer.write("Teste Funktion: b.createLeistungsblock(79, \"Bob\", \"Mobbing\");\n");
            b.createLeistungsblock(79, "Bob", "Mobbing");
        } catch (DatabaseException ex) {
            buffer.write(ex.getErrorMsg());
        }
        try {
            buffer.write("Teste Funktion: b.createUnterblock(79, \"Bob\", \"A1\", \"Mobbing\", 42);\n");
            b.createUnterblock(79, "Bob", "A1", "Mobbing");
        } catch (DatabaseException ex) {
            buffer.write(ex.getErrorMsg());
        }
//        try {
//            buffer.write("Teste Funktion: b.createTeamleistung(\"Bob2\", 3, 42, \"Mobbing\", 42);\n");
//            b.createTeamleistung("Bob2", 3, 42, "Mobbing", 42);
//        } catch (DatabaseException ex) {
//            buffer.write(ex.getErrorMsg());
//        }
        try {
            buffer.write("Teste Funktion: b.createStudienganganteil(\"Bilologie\", 3, 42, \"Mobbing\", 1);\n");
            b.createStudienganganteil("Bilologie", 3, 42, "Mobbing", 1);
        } catch (DatabaseException ex) {
            buffer.write(ex.getErrorMsg());
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
            buffer.write("Teste Funktion: b.getNutzer(\"bob@baumeister.com\", \"polen\");\n");
            Nutzer student = b.getNutzer("bob@baumeister.com", "polen");
            System.out.println(student.getVorname());
        } catch (DatabaseException ex) {
            buffer.write(ex.getErrorMsg());
        }
        try {
            buffer.write("Teste Funktion: b.getNutzer(\"test@email.com\", \"123\");\n");
            Nutzer dozent = b.getNutzer("test@email.com", "123");
            System.out.println(dozent.getVorname());
        } catch (DatabaseException ex) {
            buffer.write(ex.getErrorMsg());
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
        b.deleteUnterblock(79, "Bob", "A1", "Mobbing");
        b.deleteLeistungsblock(79, "Bob", "Mobbing");
        b.deleteStudienganganteil("Bilologie", 3, 42, "Mobbing");
        b.deleteTeamleistung("Bob2", 3, 42, "Mobbing");
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
        buffer.write("\nEND\n");
        buffer.close();
    }
}