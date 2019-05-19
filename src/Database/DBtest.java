package Database;

import Klassen.Dozent;
import Klassen.Nutzer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

public class DBtest
{
    public static void main(String[] args) throws Exception{

        DBrequest b = new DBrequest();

        FileWriter writer = new FileWriter("Logdata\\logdata.txt");
        BufferedWriter buffer = new BufferedWriter(writer);
        buffer.write("Start Logdata:\n");
        // Test create methods
        //
        buffer.write("Teste Funktion:b.createNutzer(\"test@email.com\", \"Herr\", \"bob\", \"boob\", \"123\");(Nutzer existiert noch nicht)\n");
        try {
            b.createNutzer("test@email.com", "Herr", "bob", "boob", "123");

            buffer.write("Nutzer erfolgreich erstellt");
        }catch(DatabaseExeption ex){
            buffer.write(ex.getErrorMsg());
        }
        try {
            b.createNutzer("test@email.com","Herr","bob","boob","123");
        } catch (DatabaseExeption ex) {
            buffer.write(ex.getErrorMsg()+ "\n");
        }
        try {
            b.createNutzer("bob@baumeister.com","lord","bill","Clinton","polen");
        } catch (DatabaseExeption ex) {
            buffer.write(ex.getErrorMsg());
        }
        try {
            b.createDozent("test@email.com", "Ameise");
        } catch (DatabaseExeption ex) {
            buffer.write(ex.getErrorMsg());
        }
        try {
            b.createStudent("bob@baumeister.com",79,"Imker");
        } catch (DatabaseExeption ex) {
            buffer.write(ex.getErrorMsg());;
        }
        try {
            b.createVeranstaltung("Mobbing", "Hogwarts", 42, 10, "9/10 Menschen finden Mobbing gut");
        } catch (DatabaseExeption ex) {
            buffer.write(ex.getErrorMsg());;
        }
        try {
            b.createLeitet("Mobbing", "test@email.com");
        } catch (DatabaseExeption ex) {
            buffer.write(ex.getErrorMsg());;
        }
        try {
            b.createGruppe(42, "test@email.com", "Mobbing", new Date(System.currentTimeMillis()), new Time(System.currentTimeMillis()), "Mittwoch", "ger");
        } catch (DatabaseExeption ex) {
            buffer.write(ex.getErrorMsg());;
        }
        try {
            b.createTeam(3, 42, "Mobbing", "Cybermobbing");
        } catch (DatabaseExeption ex) {
            buffer.write(ex.getErrorMsg());;
        }
        try {
            b.createGehoertZu(79, 3, 42, "Mobbing");
        } catch (DatabaseExeption ex) {
            buffer.write(ex.getErrorMsg());;
        }
        try {
            b.createLeistungsblock(79, "Bob", "Mobbing");
        } catch (DatabaseExeption ex) {
            buffer.write(ex.getErrorMsg());;
        }
        try {
            b.createUnterblock(79, "Bob", "A1", "Mobbing", 42);
        } catch (DatabaseExeption ex) {
            buffer.write(ex.getErrorMsg());;
        }
        try {
            b.createTeamleistung("Bob2", 3, 42, "Mobbing", 42);
        } catch (DatabaseExeption ex) {
            buffer.write(ex.getErrorMsg());;
        }
        try {
            b.createStudienganganteil("Bilologie", 3, 42, "Mobbing", 1);
        } catch (DatabaseExeption ex) {
            buffer.write(ex.getErrorMsg());;
        }

        // Test get methods
        //
        ArrayList<String> a = null;
        try {
            a = b.getVeranstaltungsnamen(new Dozent("test@email.com","123","Herr","bob","boob","Ameise"));

            for(int i=0; i<a.size();i++)
                System.out.println(a.get(i));
        } catch (DatabaseExeption ex) {
            buffer.write(ex.getErrorMsg());
        }
        try {
            Nutzer student = b.getNutzer("bob@baumeister.com", "polen");
            System.out.println(student.getVorname());
        } catch (DatabaseExeption ex) {
            buffer.write(ex.getErrorMsg());
        }
        try {
            Nutzer dozent = b.getNutzer("test@email.com", "123");
            System.out.println(dozent.getVorname());
        } catch (DatabaseExeption ex) {
            buffer.write(ex.getErrorMsg());
        }




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
        try {
            a = b.getVeranstaltungsnamen(new Dozent("test@email.com","123","Herr","bob","boob","Ameise"));
            for(int i=0; i<a.size();i++)
                System.out.println(a.get(i));
        } catch (DatabaseExeption ex) {
            buffer.write(ex.getErrorMsg());
        }

        try {
            Nutzer student = b.getNutzer("bob@baumeister.com", "polen");
        } catch (DatabaseExeption ex) {
            buffer.write(ex.getErrorMsg());
        }

        buffer.close();
    }
}