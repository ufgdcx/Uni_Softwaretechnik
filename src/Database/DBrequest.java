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
    public void createNutzer(String email, String titel, String vorname, String nachname, String passwort){
        try {
            Statement stmt = con.createStatement();
            System.out.println("INSERT INTO Nutzer (EMailadresse, Titel, Vorname, Nachname, Passwort) VALUES ('" + email + "', '" + titel + "', '" + vorname + "', '" + nachname + "', '" + passwort + "'");
            stmt.executeUpdate("INSERT INTO Nutzer (EMailadresse, Titel, Vorname, Nachname, Passwort) VALUES ('" + email + "', '" + titel + "', '" + vorname + "', '" + nachname + "', '" + passwort + "')");

        }catch (SQLException ex){
            ex.printStackTrace();
        }
     }
    public void createStudent(String email, int matrikelnummer, String studiengang){
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO Student (EMailadresse, Matrikelnummer, Studiengang) VALUES ('" + email + "', '" + matrikelnummer + "', '" + studiengang +"')");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void createDozent(String email, String fakultaet){
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO Dozent (EMailadresse, Fakultaet) VALUES ('" + email + "', '" + fakultaet +"')");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void createLeistungsblock(int matrikelnummer, String leistungsblockname){

    }

    public void crateGehoertZu(){
        // Values: Matrikelnummer(int) 	TeamID(int) 	GruppenID(int) 	Veranstaltungsname(string)
    }

    public void createGruppe(){
        // Values: GruppenID(int) 	EMailadresse(string) 	Veranstaltungsname(string) 	Einschreibungsfrist(date) 	Uhrzeit(time) 	Wochentag(string) 	Wochenrhytmus(string)

    }

    public void crateLeistungsblock(){
        //  Values: 	Matrikelnummer(int) 	Leistungsblock_name(string)
    }

    public void crateLeitet(){
        // values:	Name(string) 	EMailadresse(string)
    }

    public void crateStudienganganteil(){
        //	Studiengang 	TeamID 	GruppenID 	Veranstaltungsname 	Anteil

    }

    public void crateTeam(){

    }

    public void crateTeamleistung(){

    }

    public void crateUnterblock(){

    }

    public void crateVeranstaltung(){

    }

    //creater(objects)
    public void  createStudent(Student stud){
        createNutzer(stud.getEmail(),stud.getTitel(),stud.getVorname(),stud.getName(),stud.getPasswort());
        createStudent(stud.getEmail(),stud.getMatrikelnr(),stud.getStudiengang());
    }

    public void  createDozent(Dozent doz){
        createNutzer(doz.getEmail(),doz.getTitel(),doz.getVorname(),doz.getName(),doz.getPasswort());
        createDozent(doz.getEmail(),doz.getFakultaet());
    }

    //getter
    public Nutzer getNutzer(String email, String passwort) throws DatabaseExeption{
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT EMailadresse,Passwort FROM Nutzer WHERE EMailadresse = '" + email + "' AND Passwort = '" + passwort +"'");
            if(resultSize(rs)!=0){
                rs = stmt.executeQuery("SELECT EMailadresse, Matrikelnummer FROM Student WHERE EMailadresse = '" + email + "'");
                if(resultSize(rs)!=0){
                    rs = stmt.executeQuery("SELECT Nutzer.*,Student.Matrikelnummer, Student.Studiengang FROM Nutzer INNER JOIN Student ON Student.EMailadresse = Nutzer.EMailadresse WHERE Nutzer.EMailadresse = '" + email + "'");
                    rs.next();
                    return new Student(rs.getString("EMailadresse"),rs.getString("Passwort"),rs.getString("Titel"),rs.getString("Vorname"),rs.getString("Nachname"),rs.getString("Studiengang"),rs.getInt("Matrikelnummer"));
                }else{
                    rs = stmt.executeQuery("SELECT EMailadresse FROM Dozent WHERE EMailadresse = '" + email + "'");
                    if(resultSize(rs)!=0){
                        rs = stmt.executeQuery("SELECT Nutzer.*,Dozent.Fakultaet FROM Nutzer INNER JOIN Dozent ON Dozent.EMailadresse = Nutzer.EMailadresse WHERE Nutzer.EMailadresse = '" + email + "'");
                        rs.next();
                        return new Dozent(rs.getString("EMailadresse"),rs.getString("Passwort"),rs.getString("Titel"),rs.getString("Vorname"),rs.getString("Nachname"),rs.getString("Fakultaet"));
                    }
                }
                throw new DatabaseExeption("not a Student/Dozent");
            }
        }catch (SQLException ex){
            ex.printStackTrace();
            System.out.println(ex);
            return  null;
        }
        throw new DatabaseExeption("wrong username/password");
    }

    public void close(){
        try {
            con.close();
        }catch(SQLException ex){

        }
    }

    public int resultSize(ResultSet rs){
        int size =0;
        try {
            if (rs != null) {
                rs.last();    // moves cursor to the last row
                size = rs.getRow(); // get row id
                rs.first();
            }
        }catch (SQLException ex){

        }
        return size;
    };
}
