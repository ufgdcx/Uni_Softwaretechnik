package Database;

import Klassen.*;

import java.sql.*;
import java.util.ArrayList;

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

    public void createLeistungsblock(int matrikelnummer, String leistungsblockname, String veranstaltungsname){
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO Leistungsblock (Matrikelnummer, Leistungsblock_name, Veranstaltungsname) VALUES ('" + matrikelnummer + "', '" + leistungsblockname +"', '" + veranstaltungsname +"')");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void createGehoertZu(int matrikelnummer, int teamid, int gruppenid, String veranstaltungsname){
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO Gehoert_zu (Matrikelnummer, TeamID, GruppenID, Veranstaltungsname) VALUES ('" + matrikelnummer + "', '" + teamid + "', '" + gruppenid + "', '" + veranstaltungsname +"')");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void createGruppe(int gruppenid, String email, String veranstaltung, Date einschreibungsfrist, Time uhrzeit, String wochentag, String wochenrhytmus){
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO Gruppe (GruppenID, Emailadresse, Veranstaltungsname, Einschreibungsfrist, Uhrzeit, Wochentag, Wochenrhytmus) VALUES ('" + gruppenid + "', '" + email + "', '" + veranstaltung + "', '" + einschreibungsfrist + "', '" + uhrzeit + "', '" + wochentag + "', '" + wochenrhytmus + "')");

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void createLeitet(String name, String email){
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO Leitet (Name, EMailadresse) VALUES ('" + name + "', '" + email +"')");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public void createStudienganganteil(String studiengang, int teamid, int gruppenid, String veranstaltungsname, int anteil){
        //	Studiengang (string) 	TeamID(int) 	GruppenID(int) 	Veranstaltungsname(string)	Anteil (int)
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO Studienganganteil (Studiengang, TeamID, GruppenID, Veranstaltungsname, Anteil) VALUES ('" + studiengang + "', '" + teamid + "', '" + gruppenid +"', '" + veranstaltungsname +"', '" + anteil +"')");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void createTeam(int teamid, int gruppenid, String veranstaltungsname, String thema){
        // 	TeamID(int) 	GruppenID(int) 	Veranstaltungsname(string) 	Thema(string)
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO Team (TeamID, GruppenID, Veranstaltungsname, Thema) VALUES ('" + teamid + "', '" + gruppenid +"' , '" + veranstaltungsname +"', '" + thema +"')");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void createTeamleistung(String teamleistungsname, int teamid, int gruppenid, String veranstaltungsname, int punkte){
        // Teamleistungsname	varchar(255)	TeamID	int(11)	GruppenID	int(11)	Veranstaltungsname	varchar(255)	Punkte	int(11)
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO Teamleistung (Teamleistungsname, TeamID, GruppenID, Veranstaltungsname, Punkte) VALUES ('" + teamleistungsname + "', '" + teamid +"', '" + gruppenid +"', '" + veranstaltungsname +"', '" + punkte +"')");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void createUnterblock(int matrikelnummer, String leistunsblockname, String unterblockname, String veranstaltungsname, int punkte){
        // Matrikelnummer	int(9)	Leistungsblock_name	varchar(255) Unterblock_name	varchar(255)	Punkte	int(3)
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO Unterblock (Matrikelnummer, Leistungsblock_name, Unterblock_name, Veranstaltungsname, Punkte) VALUES ('" + matrikelnummer + "', '" + leistunsblockname +"', '" + unterblockname + "', '" + veranstaltungsname + "', '" + punkte +"')");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public void createVeranstaltung(String veranstaltungsname, String fakultaet,
                                   int teamanzahl, int max, String beschreibung  ){
        // Veranstaltungsname	varchar(255)	Fakultaet	varchar(255)	Teamanzahl_je_Gruppe	int(11)	maximale_Teilnehmeranzahl_je_Team	int(11)	Beschreibung	varchar(255)
        Statement stmt = null;
        try
        {
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO Veranstaltung (Veranstaltungsname, Fakultaet, Teamanzahl_je_Gruppe, maximale_Teilnehmeranzahl_je_Team, Beschreibung) VALUES ('" + veranstaltungsname + "', '" + fakultaet +"', '" + teamanzahl +"', '" + max +"', '" + beschreibung +"')");
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }

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


    //deleter(primitiv)
    public void deleteUnterblock(int matrikelnummer, String leistungsblockname, String unterblockname, String veranstaltungsname){
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Unterblock WHERE Matrikelnummer = '" + matrikelnummer + "' AND Leistungsblock_name = '" + leistungsblockname + "' AND Unterblock_name = '" + unterblockname + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteDozent(){

    }

    public void deleteGehoertZu(){

    }

    public void deleteGruppe(){

    }

    public void deleteLeistungsblock(){

    }

    public void deleteLeitet(){

    }

    public void deleteNutzer(){

    }

    public void deleteStudent(){

    }

    public void deleteStudienganganteil(){

    }

    public void deleteTeam(){

    }

    public void deleteTeamleistung(){

    }

    public void deleteUnterblock(){

    }

    public void deleteVeranstaltung(){

    }

    //getter(primitiv)
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

    public ArrayList<Leistungsblock> getLeistungsblocks(int matrikelnummer, String veranstaltungsname){
        //TODO
        return null;
    }

    //Supportmethods
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
