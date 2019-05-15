package Database;

import Klassen.*;

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
    public Student getStudent(String email, String passwort){

        return new Student("abc@uni-rostock.it","1234","Lord","Hanz","Mueller","Verteidigung gegen die Dunklen Kuenste",987654321);
    }
}
