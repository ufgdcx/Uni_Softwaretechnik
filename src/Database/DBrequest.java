package Database;

import Klassen.*;
import com.mysql.cj.xdevapi.SqlDataResult;

import java.sql.*;
import java.util.ArrayList;

public class DBrequest {
    private Connection con;

    public DBrequest(){
        con = DataSourceConn.buildConnection();
    }

    //creater(primitiv)

    public void createNutzer(String email, String titel, String vorname, String nachname, String passwort)throws DatabaseExeption{
        try {
            Statement stmt = con.createStatement();
            try {
                stmt.executeUpdate("INSERT INTO Nutzer (EMailadresse, Titel, Vorname, Nachname, Passwort) VALUES ('" + email + "', '" + titel + "', '" + vorname + "', '" + nachname + "', '" + passwort + "')");
            }catch (SQLException e){
                throw new DatabaseExeption("User already exists");
            }

        }catch (SQLException ex){
           throw new DatabaseExeption("Connection Failed");
        }
     }

    public void createStudent(String email, int matrikelnummer, String studiengang)throws DatabaseExeption{
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            try {
                stmt.executeUpdate("INSERT INTO Student (EMailadresse, Matrikelnummer, Studiengang) VALUES ('" + email + "', '" + matrikelnummer + "', '" + studiengang + "')");
            }catch(SQLException e){
                throw new DatabaseExeption("Student already exists");
            }
        } catch (SQLException ex) {
            throw new DatabaseExeption("Connection Failed");
        }
    }

    public void createDozent(String email, String fakultaet)throws DatabaseExeption{
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            try{
                stmt.executeUpdate("INSERT INTO Dozent (EMailadresse, Fakultaet) VALUES ('" + email + "', '" + fakultaet +"')");
            }catch(SQLException e){
                throw new DatabaseExeption("Dozent already exists");
            }
        } catch (SQLException ex) {
            throw new DatabaseExeption("Connection Failed");
        }
    }

    public void createLeistungsblock(int matrikelnummer, String leistungsblockname, String veranstaltungsname)throws DatabaseExeption{
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            try {
                stmt.executeUpdate("INSERT INTO Leistungsblock (Matrikelnummer, Leistungsblock_name, Veranstaltungsname) VALUES ('" + matrikelnummer + "', '" + leistungsblockname + "', '" + veranstaltungsname + "')");
            }catch (SQLException e){
                ResultSet rs = stmt.executeQuery("SELECT Matrikelnummer, Leistungsblock_name, Veranstaltungsname FROM Leistungsblock WHERE Matrikelnummer = '" + matrikelnummer + "' AND Leistungsblock_name = '" + leistungsblockname + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
                if(resultSize(rs)!=0){
                    throw new DatabaseExeption("Leistungsblock already exists");
                }else{
                    throw new DatabaseExeption("Parent doesn't exist");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseExeption("Connection Failed");
        }
    }

    public void createGehoertZu(int matrikelnummer, int teamid, int gruppenid, String veranstaltungsname)throws DatabaseExeption{
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            try {
                stmt.executeUpdate("INSERT INTO Gehoert_zu (Matrikelnummer, TeamID, GruppenID, Veranstaltungsname) VALUES ('" + matrikelnummer + "', '" + teamid + "', '" + gruppenid + "', '" + veranstaltungsname + "')");
            }catch (SQLException e){
                ResultSet rs = stmt.executeQuery("SELECT Matrikelnummer, TeamID, GruppenID, Veranstaltungsname  FROM Gehoert_zu WHERE Matrikelnummer = '" + matrikelnummer + "' AND TeamID = '" + teamid + "' AND GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
                if(resultSize(rs)!=0){
                    throw new DatabaseExeption("Gehoert_zu already exists");
                }else{
                    throw new DatabaseExeption("Parent doesn't exist");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseExeption("Connection Failed");
        }
    }

    public void createGruppe(int gruppenid, String email, String veranstaltung, Date einschreibungsfrist, Time uhrzeit, String wochentag, String wochenrhytmus)throws DatabaseExeption{
        try {
            Statement stmt = con.createStatement();
            try {
                stmt.executeUpdate("INSERT INTO Gruppe (GruppenID, Emailadresse, Veranstaltungsname, Einschreibungsfrist, Uhrzeit, Wochentag, Wochenrhytmus) VALUES ('" + gruppenid + "', '" + email + "', '" + veranstaltung + "', '" + einschreibungsfrist + "', '" + uhrzeit + "', '" + wochentag + "', '" + wochenrhytmus + "')");
            }catch (SQLException e){
                ResultSet rs = stmt.executeQuery("SELECT GruppenID, Veranstaltungsname FROM Gruppe WHERE GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltung + "'");
                if(resultSize(rs)!=0){
                    throw new DatabaseExeption("Gruppe already exists");
                }else{
                    throw new DatabaseExeption("Parent doesn't exist");
                }
            }
        }catch (SQLException ex){
            throw new DatabaseExeption("Connection Failed");
        }
    }

    public void createLeitet(String name, String email)throws DatabaseExeption{
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            try {
                stmt.executeUpdate("INSERT INTO Leitet (Name, EMailadresse) VALUES ('" + name + "', '" + email + "')");
            }catch (SQLException e){
                ResultSet rs = stmt.executeQuery("SELECT Name, Emailadresse FROM Leitet WHERE Name = '" + name + "' AND Emailadresse = '" + email + "'");
                if(resultSize(rs)!=0){
                    throw new DatabaseExeption("Leitet already exists");
                }else{
                    throw new DatabaseExeption("Parent doesn't exist");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseExeption("Connection Failed");
        }
    }

    public void createStudienganganteil(String studiengang, int teamid, int gruppenid, String veranstaltungsname, int anteil)throws DatabaseExeption{
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            try {
                stmt.executeUpdate("INSERT INTO Studienganganteil (Studiengang, TeamID, GruppenID, Veranstaltungsname, Anteil) VALUES ('" + studiengang + "', '" + teamid + "', '" + gruppenid + "', '" + veranstaltungsname + "', '" + anteil + "')");
            }catch (SQLException e) {
                ResultSet rs = stmt.executeQuery("SELECT Studiengang, TeamID, GruppenID, Veranstaltungsname  FROM Studienganganteil WHERE Studiengang = '" + studiengang + "' AND TeamID = '" + teamid + "' AND GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
                if(resultSize(rs)!=0){
                    throw new DatabaseExeption("Studienganganteil already exists");
                }else{
                    throw new DatabaseExeption("Parent doesn't exist");
                }
            }
        } catch (SQLException ex){
            throw new DatabaseExeption("Connection Failed");
        }
    }

    public void createTeam(int teamid, int gruppenid, String veranstaltungsname, String thema)throws DatabaseExeption{
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            try {
                stmt.executeUpdate("INSERT INTO Team (TeamID, GruppenID, Veranstaltungsname, Thema) VALUES ('" + teamid + "', '" + gruppenid + "' , '" + veranstaltungsname + "', '" + thema + "')");
            }catch (SQLException e){
                ResultSet rs = stmt.executeQuery("SELECT TeamID, GruppenID, Veranstaltungsname  FROM Team WHERE TeamID = '" + teamid + "' AND GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
                if(resultSize(rs)!=0){
                    throw new DatabaseExeption("Team already exists");
                }else {
                    throw new DatabaseExeption("Parent doesn't exist");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseExeption("Connection Failed");
        }
    }

    public void createTeamleistung(String teamleistungsname, int teamid, int gruppenid, String veranstaltungsname, int punkte)throws DatabaseExeption{
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            try{
                stmt.executeUpdate("INSERT INTO Teamleistung (Teamleistungsname, TeamID, GruppenID, Veranstaltungsname, Punkte) VALUES ('" + teamleistungsname + "', '" + teamid +"', '" + gruppenid +"', '" + veranstaltungsname +"', '" + punkte +"')");
            }catch (SQLException e) {
                ResultSet rs = stmt.executeQuery("SELECT Teamleistungsname, TeamID, GruppenID, Veranstaltungsname  FROM Teamleistung WHERE Teamleistungsname = '" + teamleistungsname + "' AND TeamID = '" + teamid + "' AND GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
                if(resultSize(rs)!=0){
                    throw new DatabaseExeption("Teamleistung already exists");
                }else{
                    throw new DatabaseExeption("Parent doesn't exist");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseExeption("Connection Failed");
        }
    }

    public void createUnterblock(int matrikelnummer, String leistungsblockname, String unterblockname, String veranstaltungsname, int punkte)throws DatabaseExeption{
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            try {
                stmt.executeUpdate("INSERT INTO Unterblock (Matrikelnummer, Leistungsblock_name, Unterblock_name, Veranstaltungsname, Punkte) VALUES ('" + matrikelnummer + "', '" + leistungsblockname + "', '" + unterblockname + "', '" + veranstaltungsname + "', '" + punkte + "')");
            }catch (SQLException e){
                ResultSet rs = stmt.executeQuery("SELECT Matrikelnummer, Leistungsblock_name, Unterblock_name, Veranstaltungsname FROM Unterblock WHERE Matrikelnummer = '" + matrikelnummer + "' AND Leistungsblock_name = '" + leistungsblockname + "' AND Unterblock_name = '" + unterblockname + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
                if(resultSize(rs)!=0){
                    throw new DatabaseExeption("Unterblock already exists");
                }else{
                    throw new DatabaseExeption("Parent doesn't exist");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseExeption("Connection Failed");
        }
    }


    public void createVeranstaltung(String veranstaltungsname, String fakultaet, int teamanzahl, int max, String beschreibung  )throws DatabaseExeption{
        // Veranstaltungsname	varchar(255)	Fakultaet	varchar(255)	Teamanzahl_je_Gruppe	int(11)	maximale_Teilnehmeranzahl_je_Team	int(11)	Beschreibung	varchar(255)
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            try {
                stmt.executeUpdate("INSERT INTO Veranstaltung (Veranstaltungsname, Fakultaet, Teamanzahl_je_Gruppe, maximale_Teilnehmeranzahl_je_Team, Beschreibung) VALUES ('" + veranstaltungsname + "', '" + fakultaet + "', '" + teamanzahl + "', '" + max + "', '" + beschreibung + "')");
            }catch (SQLException e){
                throw new DatabaseExeption("Veranstaltung already exists");
            }
        } catch (SQLException ex) {
            throw new DatabaseExeption("Connection Failed");
        }

    }

    //creater(objects)
    public void  createStudent(Student stud)throws DatabaseExeption{
        createNutzer(stud.getEmail(),stud.getTitel(),stud.getVorname(),stud.getName(),stud.getPasswort());
        createStudent(stud.getEmail(),stud.getMatrikelnr(),stud.getStudiengang());
    }

    public void  createDozent(Dozent doz)throws DatabaseExeption{
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

    public void deleteDozent(String email){
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Dozent WHERE Emailadresse = '" + email + "'");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void deleteGehoertZu(int matrikelnummer,int teamid, int gruppenid, String veranstaltungsname){
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Gehoert_zu WHERE matrikelnummer = '" + matrikelnummer + "' AND TeamID = '" + teamid + "' AND GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteGruppe(int gruppenid, String veranstaltungsname){
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Gruppe WHERE GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteLeistungsblock(int matrikelnummer, String leistungsblockname, String veranstaltungsname){
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Leistungsblock WHERE Matrikelnummer = '" + matrikelnummer + "' AND Leistungsblock_name = '" + leistungsblockname + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void deleteLeitet(String name, String email){
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Leitet WHERE Name = '" + name + "' AND Emailadresse = '" + email + "'");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteNutzer(String email){
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Nutzer WHERE Emailadresse = '" + email + "'");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteStudent(String email){
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Student WHERE Emailadresse = '" + email + "'");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteStudienganganteil(String studiengang, int teamid, int gruppenid, String veranstaltungsname){
        // Studienanteil: Studiengang, TeamID, GruppenID, Veranstaltungsname
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Studienganganteil WHERE Studiengang = '" + studiengang + "' AND TeamID = '" + teamid + "' AND GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteTeam(int teamid, int gruppenid, String veranstaltungsname){
        // Team: TeamID, GruppenID, Veranstaltungsname
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Team WHERE TeamID = '" + teamid + "' AND GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void deleteTeamleistung(String teamleistung, int teamid, int gruppenid, String veranstaltungsname){
        // Teamleistung: Teamleistungsname, TeamID, GruppenID, Veranstaltungsname
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Teamleistung WHERE Teamleistungsname = '" + teamleistung + "' AND TeamID = '" + teamid + "' AND GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void deleteVeranstaltung(String veranstaltungsname){
        // Veranstaltung: Veranstaltungsname
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Veranstaltung WHERE Veranstaltungsname = '" + veranstaltungsname + "'");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

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

    public ArrayList<String> getVeranstaltungsnamen(Dozent dozent) throws  DatabaseExeption{
        String email = dozent.getEmail();
        ArrayList<String> results = new ArrayList<String>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Name FROM Leitet WHERE EMailadresse = '" + email + "'");
            while (rs.next()){
                results.add(rs.getString("Name"));
            }
        }catch (SQLException ex){
        throw new DatabaseExeption("Connection Failed");
        }
        return  results;
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
