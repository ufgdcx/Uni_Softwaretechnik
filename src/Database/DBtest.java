package Database;

import Klassen.Dozent;
import Klassen.Nutzer;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class DBtest
{
    public static void main(String[] args) {

        DBrequest b = new DBrequest();
        try {
            // Test create methods
            //
            b.createNutzer("test@email.com","Herr","bob","boob","123");
            b.createNutzer("bob@baumeister.com","lord","bill","Clinton","polen");
            b.createDozent("test@email.com", "Ameise");
            b.createStudent("bob@baumeister.com",79,"Imker");
            b.createVeranstaltung("Mobbing", "Hogwarts", 42, 10, "9/10 Menschen finden Mobbing gut");
            b.createLeitet("Mobbing", "test@email.com");
            b.createGruppe(42, "test@email.com", "Mobbing", new Date(System.currentTimeMillis()), new Time(System.currentTimeMillis()), "Mittwoch", "ger");
            b.createTeam(3, 42, "Mobbing", "Cybermobbing");
            b.createGehoertZu(79, 3, 42, "Mobbing");
            b.createLeistungsblock(79, "Bob", "Mobbing");
            b.createUnterblock(79, "Bob", "A1", "Mobbing", 42);
            b.createTeamleistung("Bob2", 3, 42, "Mobbing", 42);
            b.createStudienganganteil("Bilologie", 3, 42, "Mobbing", 1);

            // Test get methods
            //
            ArrayList<String> a = b.getVeranstaltungsnamen(new Dozent("test@email.com","123","Herr","bob","boob","Ameise"));
            for(int i=0; i<a.size();i++)
                System.out.println(a.get(i));

            Nutzer student = b.getNutzer("bob@baumeister.com", "polen");
            Nutzer dozent = b.getNutzer("test@email.com", "123");

            System.out.println(student.getVorname());
            System.out.println(dozent.getVorname());

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
            a = b.getVeranstaltungsnamen(new Dozent("test@email.com","123","Herr","bob","boob","Ameise"));
            for(int i=0; i<a.size();i++)
                System.out.println(a.get(i));
            student = b.getNutzer("bob@baumeister.com", "polen");

        }catch (DatabaseExeption dbe){
            System.out.println(dbe.getErrorMsg());
        }
    }
}