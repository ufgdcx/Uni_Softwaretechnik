package Database;

import Klassen.Dozent;
import Klassen.Nutzer;
import Klassen.Student;

import java.sql.Time;
import java.text.ParseException;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class DBtest
{
    public static void main(String[] args) {

        DBrequest b = new DBrequest();
        b.createVeranstaltung("Mobbing","Hogwarts",42,10,"9/10 Menschen finden Mobbing gut");
        b.createLeitet("Mobbing","email@adresse.de");
        b.createGruppe(42,"email@adresse.de", "Mobbing", new Date(System.currentTimeMillis()), new Time(System.currentTimeMillis()),"Mittwoch","ger");
        b.createTeam(3,42,"Mobbing","Cybermobbing");
        b.createGehoertZu(123456789,3,42,"Mobbing");
        b.createLeistungsblock(123456789,"Bob","Mobbing");
        b.createUnterblock(123456789,"Bob","A1","Mobbing",42);
        b.createTeamleistung("Bob2",3,42,"Mobbing",42);
        b.createStudienganganteil("Bilologie",3,42,"Mobbing",1);
    }
}