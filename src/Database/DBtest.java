package Database;

import java.sql.Date;
import java.sql.Time;

public class DBtest
{
    public static void main(String[] args) {

        DBrequest b = new DBrequest();
        try {
            b.createVeranstaltung("Mobbing", "Hogwarts", 42, 10, "9/10 Menschen finden Mobbing gut");
            b.createLeitet("Mobbing", "email@adresse.de");
            b.createGruppe(42, "email@adresse.de", "Mobbing", new Date(System.currentTimeMillis()), new Time(System.currentTimeMillis()), "Mittwoch", "ger");
            b.createTeam(3, 42, "Mobbing", "Cybermobbing");
            b.createGehoertZu(123456789, 3, 42, "Mobbing");
            b.createLeistungsblock(123456789, "Bob", "Mobbing");
            b.createUnterblock(123456789, "Bob", "A1", "Mobbing", 42);
            b.createTeamleistung("Bob2", 3, 42, "Mobbing", 42);
            b.createStudienganganteil("Bilologie", 3, 42, "Mobbing", 1);
            b.deleteUnterblock(123456789, "Bob", "A1", "Mobbing");
            b.deleteLeistungsblock(123456789, "Bob", "Mobbing");
            b.deleteStudienganganteil("Bilologie", 3, 42, "Mobbing");
            b.deleteTeamleistung("Bob2", 3, 42, "Mobbing");
            b.deleteGehoertZu(123456789, 3, 42, "Mobbing");
            b.deleteTeam(3, 42, "Mobbing");
            b.deleteGruppe(42, "Mobbing");
            b.deleteLeitet("Mobbing", "email@adresse.de");
            b.deleteVeranstaltung("Mobbing");
//        b.deleteDozent("email@adresse.de");
//        b.deleteStudent("");
        }catch (DatabaseExeption dbe){
            System.out.println(dbe.getErrorMsg());
        }
    }
}