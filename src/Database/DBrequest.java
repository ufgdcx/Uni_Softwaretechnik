package Database;

import Klassen.*;

import java.sql.*;
import java.util.ArrayList;

public class DBrequest {
    private Connection con;

    public DBrequest(){
        con = DataSourceConn.buildConnection();
    }


    // creater(primitiv)
    //
    public void createNutzer(String email, String titel, String vorname, String nachname, String passwort)throws DatabaseException {
        try {
            Statement stmt = con.createStatement();
            try {
                stmt.executeUpdate("INSERT INTO Nutzer (EMailadresse, Titel, Vorname, Nachname, Passwort) VALUES ('" + email + "', '" + titel + "', '" + vorname + "', '" + nachname + "', '" + passwort + "')");
            }catch (SQLException e){
                throw new DatabaseException("User already exists");
            }

        }catch (SQLException ex){
           throw new DatabaseException("Connection Failed");
        }
     }

    public void createStudent(String email, int matrikelnummer, String studiengang)throws DatabaseException {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            try {
                stmt.executeUpdate("INSERT INTO Student (EMailadresse, Matrikelnummer, Studiengang) VALUES ('" + email + "', '" + matrikelnummer + "', '" + studiengang + "')");
            }catch(SQLException e){
                throw new DatabaseException("Student already exists");
            }
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }
    }

    public void createDozent(String email, String fakultaet)throws DatabaseException {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            try{
                stmt.executeUpdate("INSERT INTO Dozent (EMailadresse, Fakultaet) VALUES ('" + email + "', '" + fakultaet +"')");
            }catch(SQLException e){
                throw new DatabaseException("Dozent already exists");
            }
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }
    }

    public void createLeistungsblock(int matrikelnummer, String leistungsblockname, String veranstaltungsname)throws DatabaseException {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            try {
                stmt.executeUpdate("INSERT INTO Leistungsblock (Matrikelnummer, Leistungsblock_name, Veranstaltungsname) VALUES ('" + matrikelnummer + "', '" + leistungsblockname + "', '" + veranstaltungsname + "')");
            }catch (SQLException e){
                ResultSet rs = stmt.executeQuery("SELECT Matrikelnummer, Leistungsblock_name, Veranstaltungsname FROM Leistungsblock WHERE Matrikelnummer = '" + matrikelnummer + "' AND Leistungsblock_name = '" + leistungsblockname + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
                if(resultSize(rs)!=0){
                    throw new DatabaseException("Leistungsblock already exists");
                }else{
                    throw new DatabaseException("Parent doesn't exist");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }
    }

    public void createGehoertZu(int matrikelnummer, int teamid, int gruppenid, String veranstaltungsname)throws DatabaseException {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            try {
                stmt.executeUpdate("INSERT INTO Gehoert_zu (Matrikelnummer, TeamID, GruppenID, Veranstaltungsname) VALUES ('" + matrikelnummer + "', '" + teamid + "', '" + gruppenid + "', '" + veranstaltungsname + "')");
            }catch (SQLException e){
                ResultSet rs = stmt.executeQuery("SELECT Matrikelnummer, TeamID, GruppenID, Veranstaltungsname  FROM Gehoert_zu WHERE Matrikelnummer = '" + matrikelnummer + "' AND TeamID = '" + teamid + "' AND GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
                if(resultSize(rs)!=0){
                    throw new DatabaseException("Gehoert_zu already exists");
                }else{
                    throw new DatabaseException("Parent doesn't exist");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }
    }

    public void createGruppe(int gruppenid, String email, String veranstaltung, Date einschreibungsfrist, Time uhrzeit, String wochentag, String wochenrhytmus)throws DatabaseException {
        try {
            Statement stmt = con.createStatement();
            try {
                stmt.executeUpdate("INSERT INTO Gruppe (GruppenID, Emailadresse, Veranstaltungsname, Einschreibungsfrist, Uhrzeit, Wochentag, Wochenrhytmus) VALUES ('" + gruppenid + "', '" + email + "', '" + veranstaltung + "', '" + einschreibungsfrist + "', '" + uhrzeit + "', '" + wochentag + "', '" + wochenrhytmus + "')");
            }catch (SQLException e){
                ResultSet rs = stmt.executeQuery("SELECT GruppenID, Veranstaltungsname FROM Gruppe WHERE GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltung + "'");
                if(resultSize(rs)!=0){
                    throw new DatabaseException("Gruppe already exists");
                }else{
                    throw new DatabaseException("Parent doesn't exist");
                }
            }
        }catch (SQLException ex){
            throw new DatabaseException("Connection Failed");
        }
    }

    public void createLeitet(String name, String email)throws DatabaseException {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            try {
                stmt.executeUpdate("INSERT INTO Leitet (Name, EMailadresse) VALUES ('" + name + "', '" + email + "')");
            }catch (SQLException e){
                ResultSet rs = stmt.executeQuery("SELECT Name, Emailadresse FROM Leitet WHERE Name = '" + name + "' AND Emailadresse = '" + email + "'");
                if(resultSize(rs)!=0){
                    throw new DatabaseException("Leitet already exists");
                }else{
                    throw new DatabaseException("Parent doesn't exist");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }
    }

    public void createStudienganganteil(String studiengang, int teamid, int gruppenid, String veranstaltungsname, int anteil)throws DatabaseException {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            try {
                stmt.executeUpdate("INSERT INTO Studienganganteil (Studiengang, TeamID, GruppenID, Veranstaltungsname, Anteil) VALUES ('" + studiengang + "', '" + teamid + "', '" + gruppenid + "', '" + veranstaltungsname + "', '" + anteil + "')");
            }catch (SQLException e) {
                ResultSet rs = stmt.executeQuery("SELECT Studiengang, TeamID, GruppenID, Veranstaltungsname  FROM Studienganganteil WHERE Studiengang = '" + studiengang + "' AND TeamID = '" + teamid + "' AND GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
                if(resultSize(rs)!=0){
                    throw new DatabaseException("Studienganganteil already exists");
                }else{
                    throw new DatabaseException("Parent doesn't exist");
                }
            }
        } catch (SQLException ex){
            throw new DatabaseException("Connection Failed");
        }
    }

    public void createTeam(int teamid, int gruppenid, String veranstaltungsname, String thema)throws DatabaseException {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            try {
                stmt.executeUpdate("INSERT INTO Team (TeamID, GruppenID, Veranstaltungsname, Thema) VALUES ('" + teamid + "', '" + gruppenid + "' , '" + veranstaltungsname + "', '" + thema + "')");
            }catch (SQLException e){
                ResultSet rs = stmt.executeQuery("SELECT TeamID, GruppenID, Veranstaltungsname  FROM Team WHERE TeamID = '" + teamid + "' AND GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
                if(resultSize(rs)!=0){
                    throw new DatabaseException("Team already exists");
                }else {
                    throw new DatabaseException("Parent doesn't exist");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }
    }

    public void createTeamleistung(String teamleistungsname, int teamid, int gruppenid, String veranstaltungsname, int punkte)throws DatabaseException {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            try{
                stmt.executeUpdate("INSERT INTO Teamleistung (Teamleistungsname, TeamID, GruppenID, Veranstaltungsname, Punkte) VALUES ('" + teamleistungsname + "', '" + teamid +"', '" + gruppenid +"', '" + veranstaltungsname +"', '" + punkte +"')");
            }catch (SQLException e) {
                ResultSet rs = stmt.executeQuery("SELECT Teamleistungsname, TeamID, GruppenID, Veranstaltungsname  FROM Teamleistung WHERE Teamleistungsname = '" + teamleistungsname + "' AND TeamID = '" + teamid + "' AND GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
                if(resultSize(rs)!=0){
                    throw new DatabaseException("Teamleistung already exists");
                }else{
                    throw new DatabaseException("Parent doesn't exist");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }
    }

    public void createUnterblock(int matrikelnummer, String leistungsblockname, String unterblockname, String veranstaltungsname, int punkte)throws DatabaseException {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            try {
                stmt.executeUpdate("INSERT INTO Unterblock (Matrikelnummer, Leistungsblock_name, Unterblock_name, Veranstaltungsname, Punkte) VALUES ('" + matrikelnummer + "', '" + leistungsblockname + "', '" + unterblockname + "', '" + veranstaltungsname + "', '" + punkte + "')");
            }catch (SQLException e){
                ResultSet rs = stmt.executeQuery("SELECT Matrikelnummer, Leistungsblock_name, Unterblock_name, Veranstaltungsname FROM Unterblock WHERE Matrikelnummer = '" + matrikelnummer + "' AND Leistungsblock_name = '" + leistungsblockname + "' AND Unterblock_name = '" + unterblockname + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
                if(resultSize(rs)!=0){
                    throw new DatabaseException("Unterblock already exists");
                }else{
                    throw new DatabaseException("Parent doesn't exist");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }
    }


    public void createVeranstaltung(String veranstaltungsname, String fakultaet, int teamanzahl, int max, String beschreibung  )throws DatabaseException {
        // Veranstaltungsname	varchar(255)	Fakultaet	varchar(255)	Teamanzahl_je_Gruppe	int(11)	maximale_Teilnehmeranzahl_je_Team	int(11)	Beschreibung	varchar(255)
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            try {
                stmt.executeUpdate("INSERT INTO Veranstaltung (Veranstaltungsname, Fakultaet, Teamanzahl_je_Gruppe, maximale_Teilnehmeranzahl_je_Team, Beschreibung) VALUES ('" + veranstaltungsname + "', '" + fakultaet + "', '" + teamanzahl + "', '" + max + "', '" + beschreibung + "')");
            }catch (SQLException e){
                throw new DatabaseException("Veranstaltung already exists");
            }
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }

    }

    //creater(objects)
    public void  createStudent(Student stud)throws DatabaseException {
        createNutzer(stud.getEmail(),stud.getTitel(),stud.getVorname(),stud.getName(),stud.getPasswort());
        createStudent(stud.getEmail(),stud.getMatrikelnr(),stud.getStudiengang());
    }

    public void  createDozent(Dozent doz)throws DatabaseException {
        createNutzer(doz.getEmail(),doz.getTitel(),doz.getVorname(),doz.getName(),doz.getPasswort());
        createDozent(doz.getEmail(),doz.getFakultaet());
    }


    //deleter(primitiv)
    public void deleteUnterblock(int matrikelnummer, String leistungsblockname, String unterblockname, String veranstaltungsname) throws DatabaseException
    {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Unterblock WHERE Matrikelnummer = '" + matrikelnummer + "' AND Leistungsblock_name = '" + leistungsblockname + "' AND Unterblock_name = '" + unterblockname + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }
    }

    public void deleteDozent(String email) throws DatabaseException
    {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Dozent WHERE Emailadresse = '" + email + "'");
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }

    }

    public void deleteGehoertZu(int matrikelnummer,int teamid, int gruppenid, String veranstaltungsname) throws DatabaseException
    {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Gehoert_zu WHERE matrikelnummer = '" + matrikelnummer + "' AND TeamID = '" + teamid + "' AND GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }
    }

    public void deleteGruppe(int gruppenid, String veranstaltungsname) throws DatabaseException
    {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Gruppe WHERE GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }
    }

    public void deleteLeistungsblock(int matrikelnummer, String leistungsblockname, String veranstaltungsname) throws DatabaseException
    {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Leistungsblock WHERE Matrikelnummer = '" + matrikelnummer + "' AND Leistungsblock_name = '" + leistungsblockname + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }

    }

    public void deleteLeitet(String name, String email) throws DatabaseException
    {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Leitet WHERE Name = '" + name + "' AND Emailadresse = '" + email + "'");
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }
    }

    public void deleteNutzer(String email) throws DatabaseException
    {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Nutzer WHERE Emailadresse = '" + email + "'");
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }
    }

    public void deleteStudent(String email) throws DatabaseException
    {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Student WHERE Emailadresse = '" + email + "'");
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }
    }

    public void deleteStudienganganteil(String studiengang, int teamid, int gruppenid, String veranstaltungsname) throws DatabaseException
    {
        // Studienanteil: Studiengang, TeamID, GruppenID, Veranstaltungsname
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Studienganganteil WHERE Studiengang = '" + studiengang + "' AND TeamID = '" + teamid + "' AND GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }
    }

    public void deleteTeam(int teamid, int gruppenid, String veranstaltungsname) throws DatabaseException
    {
        // Team: TeamID, GruppenID, Veranstaltungsname
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Team WHERE TeamID = '" + teamid + "' AND GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }

    }

    public void deleteTeamleistung(String teamleistung, int teamid, int gruppenid, String veranstaltungsname) throws DatabaseException
    {
        // Teamleistung: Teamleistungsname, TeamID, GruppenID, Veranstaltungsname
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Teamleistung WHERE Teamleistungsname = '" + teamleistung + "' AND TeamID = '" + teamid + "' AND GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }

    }

    public void deleteVeranstaltung(String veranstaltungsname) throws DatabaseException
    {
        // Veranstaltung: Veranstaltungsname
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Veranstaltung WHERE Veranstaltungsname = '" + veranstaltungsname + "'");
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }

    }

    //getter(primitiv)
    public Nutzer getNutzer(String email, char[] passwd) throws DatabaseException {
    	//converting char array for password to a string
    	//TODO evaluate, if we need to overwrite the string and/or the char array for better security
    	String pwString = new String(passwd);
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT EMailadresse,Passwort FROM Nutzer WHERE EMailadresse = '" + email + "' AND Passwort = '" + pwString +"'");
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
                throw new DatabaseException("not a Student/Dozent");
            }
        }catch (SQLException ex){
            ex.printStackTrace();
            System.out.println(ex);
            return  null;
        }
        throw new DatabaseException("wrong username/password");
    }

    public Nutzer getNutzer(String email, String passwd) throws DatabaseException {
        //converting char array for password to a string
        //TODO evaluate, if we need to overwrite the string and/or the char array for better security
        String pwString = new String(passwd);
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT EMailadresse,Passwort FROM Nutzer WHERE EMailadresse = '" + email + "' AND Passwort = '" + pwString +"'");
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
                throw new DatabaseException("not a Student/Dozent");
            }
        }catch (SQLException ex){
            ex.printStackTrace();
            System.out.println(ex);
            return  null;
        }
        throw new DatabaseException("wrong username/password");
    }

    public ArrayList<Leistungsblock> getLeistungsblocks(int matrikelnummer, String veranstaltungsname){
        //TODO
        return null;
    }

    public ArrayList<String> getVeranstaltungsnamen(Dozent dozent) throws DatabaseException {
        String email = dozent.getEmail();
        ArrayList<String> results = new ArrayList<String>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Name FROM Leitet WHERE EMailadresse = '" + email + "'");
            while (rs.next()){
                results.add(rs.getString("Name"));
            }
        }catch (SQLException ex){
        throw new DatabaseException("Connection Failed");
        }
        return  results;
    }


    //TODO
    public void updateNutzerPasswort(String email, String passwort) throws DatabaseException {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Nutzer SET Passwort = '" + passwort + "' WHERE EMailadresse = '" + email + "'");
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }
    }

    //TODO
    public void updateNutzerTitle(String email, String title) throws DatabaseException {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Nutzer SET Titel = '" + title + "' WHERE EMailadresse = '" + email + "'");
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }
    }

    //TODO
    public void updateNutzerVornamen(String email, String vorname) throws DatabaseException {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Nutzer SET Vorname = '" + vorname + "' WHERE EMailadresse = '" + email + "'");
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }
    }

    public void updateNutzerNachname(String email, String name) throws DatabaseException {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Nutzer SET Nachmane = '" + name + "' WHERE EMailadresse = '" + email + "'");
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }
    }

//    //TODO kann man nur aufwenidg aendern da schluessel (nur sehr sehr aufwendig moeglich)
//    public Student updateStudentMatrikelnummer(String email, String matrikelnummer) throws DatabaseException {
//        return null;
//    }

    //TODO
    public void updateStudentStudiengang(String email, String studiengang) throws DatabaseException {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Student SET Studiengang = '" + studiengang + "' WHERE EMailadresse = '" + email + "'");
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }
    }

    //TODO
    public void updateDozentFakultaet(String email, String fakultaet) throws DatabaseException {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Dozent SET Fakultaet = '" + fakultaet + "' WHERE EMailadresse = '" + email + "'");
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }
    }

//    //TODO kann man nur aufwenidg aendern da schluessel (nur sehr sehr aufwendig moeglich)
//    public Gruppe updateGruppeVeranstaltungsname(int gruppenID, String veranstaltungsname) throws DatabaseException {
//        return null;
//    }

    //TODO
    public void updateGruppeEinschreibefrist(int gruppenid, String veranstaltungsname, Date einschreibefrist) throws DatabaseException {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Gruppe SET  Einschreibungsfrist = '" + einschreibefrist + "' WHERE WHERE GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }
    }

    //TODO
    public void updateGruppeUhrzeit(int gruppenid, String veranstaltungsname, Time uhrzeit) throws DatabaseException {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Gruppe SET  Uhrzeit = '" + uhrzeit + "' WHERE GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }
    }

    //TODO
    public void updateGruppeWochentag(int gruppenid, String veranstaltungsname, String wochentag) throws DatabaseException {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Gruppe SET  Wochentag = '" + wochentag + "' WHERE GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }
    }

    //TODO
    public void updateGruppeWochenrhythmus(int gruppenid, String veranstaltungsname, String wochenrhythmus) throws DatabaseException {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Gruppe SET  Wochenrhytmus = '" + wochenrhythmus + "' WHERE GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }
    }

//    //TODO kann man nur aufwenidg aendern da schluessel (nur sehr sehr aufwendig moeglich)
//    public Leistungsblock updateLBName(int matrikelnummer, String lb_name) throws DatabaseException {
//        return null;
//    }

    //TODO
    public void updateUBName(int matrikelnummer, String veranstaltungsname, String ub_name, String leistungsblockname, String unterblockname) throws DatabaseException {
        Statement stmt = null;
        try
        {
            stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Unterblock SET Unterblock_name = '" + ub_name + "' WHERE Matrikelnummer = '" + matrikelnummer + "' AND Leistungsblock_name = '" + leistungsblockname + "' AND Unterblock_name = '" + unterblockname + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
        }
        catch(SQLException ex)
        {
            throw new DatabaseException("Connection Failed");
        }
    }

    //TODO
    public void updateUBPunkte(int matrikelnummer, int ub_punkte, String leistungsblockname, String unterblockname, String veranstaltungsname) throws DatabaseException {
        Statement stmt = null;
        try
        {
            stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Unterblock SET Punkte = '" + ub_punkte + "' WHERE Matrikelnummer = '" + matrikelnummer + "' AND Leistungsblock_name = '" + leistungsblockname + "' AND Unterblock_name = '" + unterblockname + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
        }
        catch(SQLException ex)
        {
            throw new DatabaseException("Connection Failed");
        }
    }

    //TODO
    public void updateStudienganganteil(String studiengang, int anteil, int teamid, int gruppenid, String veranstaltungsname) throws DatabaseException {
        Statement stmt = null;
        try
        {
            stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Studienganganteil SET Anteil = '" + anteil + "' WHERE Studiengang = '" + studiengang + "' AND TeamID = '" + teamid + "' AND GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
        }
        catch(SQLException ex)
        {
            throw new DatabaseException("Connection Failed");
        }
    }

//    //TODO kann man nur aufwenidg aendern da schluessel (nur sehr sehr aufwendig moeglich)
//    public Studienganganteil updateStudienganganteilGruppenID(int anteil, int gruppenID) throws DatabaseException {
//        return null;
//    }

//    //TODO kann man nur aufwenidg aendern da schluessel (nur sehr sehr aufwendig moeglich)
//    public Studienganganteil updateStudienganganteilTeamID(int anteil, int teamID) throws DatabaseException {
//        return null;
//    }

//    //TODO kann man nur aufwenidg aendern da schluessel (nur sehr sehr aufwendig moeglich)
//    public Studienganganteil updateStudienganganteilVName(int anteil, String vName) throws DatabaseException {
//        return null;
//    }

//    //TODO kann man nur aufwenidg aendern da schluessel (nur sehr sehr aufwendig moeglich)
//    public Team updateTeamGruppenID(int teamID, int gruppenID) throws DatabaseException {
//        return null;
//    }

    //TODO
    public void updateTeamThema(int teamID, String thema, int gruppenID, String veranstaltungsname) throws DatabaseException {
        Statement stmt = null;
        try
        {
            stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Team SET Thema = '" + thema + "' WHERE TeamID = '" + teamID + "' AND GruppenID = '" + gruppenID + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
        }
        catch(SQLException ex)
        {
            throw new DatabaseException("Connection Failed");
        }
    }

    //TODO
    public void updateTeamleistungPunkte(int teamID, int punkte, int gruppenID, String veranstaltungsname) throws DatabaseException {
        Statement stmt = null;
        try
        {
            stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Teamleistung SET Punkte = '" + punkte + "' WHERE TeamID = '" + teamID + "' AND GruppenID = '" + gruppenID + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
        }
        catch(SQLException ex)
        {
            throw new DatabaseException("Connection Failed");
        }
    }

    //TODO
    public void updateTeamleistungName(int teamID, String tl_Name, int gruppenID, String veranstaltungsname) throws DatabaseException {
        Statement stmt = null;
        try
        {
            stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Teamleistung SET Teamleistungsname = '" + tl_Name + "' WHERE TeamID = '" + teamID + "' AND GruppenID = '" + gruppenID + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
        }
        catch(SQLException ex)
        {
            throw new DatabaseException("Connection Failed");
        }
    }

    //TODO
    public void updateVeranstaltungTeamanzahl_je_Gruppe(String veranstaltungsname, int teamanzahl) throws DatabaseException {
        Statement stmt = null;
        try
        {
            stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Veranstaltung SET Teamzahl_je_Gruppe = '" + teamanzahl + "' WHERE Veranstaltungsname = '" +veranstaltungsname+"'");
        }
        catch(SQLException ex)
        {
            throw new DatabaseException("Connection Failed");
        }
    }

    //TODO
    public void updateVeranstaltungBeschreibung(String veranstaltungsname, String beschreibung) throws DatabaseException {
        Statement stmt = null;
        try
        {
            stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Veranstaltung SET Beschreibung = '" + beschreibung + "' WHERE Veranstaltungsname = '" +veranstaltungsname+"'");
        }
        catch(SQLException ex)
        {
            throw new DatabaseException("Connection Failed");
        }
    }

    //TODO
    public void updateVeranstaltungMaximale_Teilnehmeranzahl_je_Team(String veranstaltungsname, int maximale_Teilnehmeranzahl_je_Team) throws DatabaseException {
        Statement stmt = null;
        try
        {
            stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Veranstaltung SET maximale_Teilnehmeranzahl_je_Team = '" + maximale_Teilnehmeranzahl_je_Team + "' WHERE Veranstaltungsname = '" +veranstaltungsname+"'");
        }
        catch(SQLException ex)
        {
            throw new DatabaseException("Connection Failed");
        }
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
    }
}
