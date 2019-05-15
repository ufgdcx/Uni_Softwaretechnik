package Database;

import Klassen.Leistung;
import Klassen.Leistungsblock;
import Klassen.Student;

import java.sql.Connection;

public class DBrequest {
    private Connection conn;

    DBrequest(){
        conn = DBconn.buildConnection();
    }

    //creater(primitiv)
    public void createNutzer(String email, String titel, String Vorname, String Nachname, String passwort){

    }
    public void createStudent(String email, int matrikelnummer){

    }

    public void createDozent(String email, String fakultaet){

    }

    public void createLeistungsblock(int matrikelnummer, String leistungsblockname){

    }

    //creater(objects)
    public void  createStudent(Student stud){
        createNutzer(stud.getEmail(),stud.getTitel(),stud.getVorname(),stud.getName(),stud.getPasswort());
        createStudent(stud.getEmail(),stud.getMatrikelnr());
    }

    //getter
    public void getName(int matrikelnummer){

    }
}
