package Database;

import Klassen.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBrequest {
    private Connection con;

    public DBrequest(){
        con = DataSourceConn.buildConnection();
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
    public Nutzer getNutzer(String email, String passwort){
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Student ");
            rs.next();
            System.out.println(rs.getInt("Matrikelnummer"));
        }catch (SQLException ex){
            ex.printStackTrace();
            System.out.println(ex);
            return  null;
        }
        return new Student("abc@uni-rostock.it","1234","Lord","Hanz","Mueller","Verteidigung gegen die Dunklen Kuenste",987654321);
    }

    public void close(){
        try {
            con.close();
        }catch(SQLException ex){

        }
    }
}
