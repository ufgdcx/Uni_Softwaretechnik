package Database;

import Klassen.*;
import jdk.jfr.Description;

import java.sql.*;
import java.util.ArrayList;

/**
 * Verwaltet Datenbankanfragen.
 * @author Christoph
 * @author Sven
 */

public class DBrequest {
    private Connection con;
    private LogWriter logwriter = LogWriter.getIntstance();
    private final static DBrequest instance = new DBrequest();

    public DBrequest(){
        con = DataSourceConn.buildConnection();
    }


    // creater(primitiv)
    //
    /**
    * @param    email       email of the user
     * @param   titel     title of the user
     * @param   vorname   title of the user
     * @param   vorname   firstname of the user
     * @param   nachname  lastname of the user
     * @param   passwort  password of the user
     * @return            void
     * @exception DatabaseException with errormessage = "Connection failed" if the connection to the Databaseserver fails or "User already exists" if the user is already in the system
     */
    public void createNutzer(String email, String titel, String vorname, String nachname, String passwort)throws DatabaseException {
        logwriter.writetoLog("function: createNutzer(primitive)","TRACE");

        try {
            Statement stmt = con.createStatement();
            try {
                stmt.executeUpdate("INSERT INTO Nutzer (EMailadresse, Titel, Vorname, Nachname, Passwort) VALUES ('" + email + "', '" + titel + "', '" + vorname + "', '" + nachname + "', '" + passwort + "')");
                logwriter.writetoLog("successful","TRACE");
            }catch (SQLException e){
                logwriter.writetoLog("User already exists","ERROR");
                throw new DatabaseException("User already exists");
            }

        }catch (SQLException ex){
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void createStudent(String email, int matrikelnummer, String studiengang)throws DatabaseException {
        logwriter.writetoLog("function: createStudent(primitive)","TRACE");
        try {
            Statement stmt = con.createStatement();
            try {
                stmt.executeUpdate("INSERT INTO Student (EMailadresse, Matrikelnummer, Studiengang) VALUES ('" + email + "', '" + matrikelnummer + "', '" + studiengang + "')");
                logwriter.writetoLog("successful","TRACE");
            }catch(SQLException e) {
                ResultSet rs = stmt.executeQuery("SELECT Emailadresse FROM Student WHERE Emailadresse = '" + email + "'");
                if (resultSize(rs) != 0) {
                    logwriter.writetoLog("Student already exists","ERROR");
                    throw new DatabaseException("Student already exists");
                } else {
                    logwriter.writetoLog("Parent doesn't exist","ERROR");
                    throw new DatabaseException("Parent doesn't exist");
                }
            }
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void createDozent(String email, String fakultaet)throws DatabaseException {
        logwriter.writetoLog("function: createDozent(primitive)","TRACE");
        try {
            Statement stmt = con.createStatement();
            try{
                stmt.executeUpdate("INSERT INTO Dozent (EMailadresse, Fakultaet) VALUES ('" + email + "', '" + fakultaet +"')");
                logwriter.writetoLog("successful","TRACE");
            }catch(SQLException e){
                ResultSet rs = stmt.executeQuery("SELECT Emailadresse FROM Dozent WHERE Emailadresse = '" + email + "'");
                if (resultSize(rs) != 0) {
                    logwriter.writetoLog("Dozent already exists","ERROR");
                    throw new DatabaseException("Dozent already exists");
                }else {
                    logwriter.writetoLog("Parent doesn't exist","ERROR");
                    throw new DatabaseException("Parent doesn't exist");
                }

            }
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void createLeistungsblock(int matrikelnummer, String leistungsblockname, String veranstaltungsname)throws DatabaseException {
        logwriter.writetoLog("function: createLeistungsblock(primitive)","TRACE");
        try {
            Statement stmt = con.createStatement();
            try {
                stmt.executeUpdate("INSERT INTO Leistungsblock (Matrikelnummer, Leistungsblock_name, Veranstaltungsname) VALUES ('" + matrikelnummer + "', '" + leistungsblockname + "', '" + veranstaltungsname + "')");
                logwriter.writetoLog("successful","TRACE");
            }catch (SQLException e){
                ResultSet rs = stmt.executeQuery("SELECT Matrikelnummer, Leistungsblock_name, Veranstaltungsname FROM Leistungsblock WHERE Matrikelnummer = '" + matrikelnummer + "' AND Leistungsblock_name = '" + leistungsblockname + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
                if(resultSize(rs)!=0){
                    logwriter.writetoLog("Leistungsblock already exists","ERROR");
                    throw new DatabaseException("Leistungsblock already exists");
                }else{
                    logwriter.writetoLog("Parent doesn't exist","ERROR");
                    throw new DatabaseException("Parent doesn't exist");
                }
            }
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void createGehoertZu(int matrikelnummer, int teamid, int gruppenid, String veranstaltungsname)throws DatabaseException {
        logwriter.writetoLog("function: createGehoertZu(primitive)","TRACE");
        try {
            Statement stmt = con.createStatement();
            try {
                stmt.executeUpdate("INSERT INTO Gehoert_zu (Matrikelnummer, TeamID, GruppenID, Veranstaltungsname) VALUES ('" + matrikelnummer + "', '" + teamid + "', '" + gruppenid + "', '" + veranstaltungsname + "')");
                logwriter.writetoLog("successful","TRACE");
            }catch (SQLException e){
                ResultSet rs = stmt.executeQuery("SELECT Matrikelnummer, TeamID, GruppenID, Veranstaltungsname  FROM Gehoert_zu WHERE Matrikelnummer = '" + matrikelnummer + "' AND TeamID = '" + teamid + "' AND GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
                if(resultSize(rs)!=0){
                    logwriter.writetoLog("Gehoert_zu already exists","ERROR");
                    throw new DatabaseException("Gehoert_zu already exists");
                }else{
                    logwriter.writetoLog("Parent doesn't exist","ERROR");
                    throw new DatabaseException("Parent doesn't exist");
                }
            }
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void createGruppe(int gruppenid, String email, String veranstaltung, Date einschreibungsfrist, Time uhrzeit, String wochentag, String wochenrhytmus)throws DatabaseException {
        logwriter.writetoLog("function: createGruppe(primitive)","TRACE");
        try {
            Statement stmt = con.createStatement();
            try {
                stmt.executeUpdate("INSERT INTO Gruppe (GruppenID, Emailadresse, Veranstaltungsname, Einschreibungsfrist, Uhrzeit, Wochentag, Wochenrhytmus) VALUES ('" + gruppenid + "', '" + email + "', '" + veranstaltung + "', '" + einschreibungsfrist + "', '" + uhrzeit + "', '" + wochentag + "', '" + wochenrhytmus + "')");
                logwriter.writetoLog("successful","TRACE");
            }catch (SQLException e){
                ResultSet rs = stmt.executeQuery("SELECT GruppenID, Veranstaltungsname FROM Gruppe WHERE GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltung + "'");
                if(resultSize(rs)!=0){
                    logwriter.writetoLog("Gruppe already exists","ERROR");
                    throw new DatabaseException("Gruppe already exists");
                }else{
                    logwriter.writetoLog("Parent doesn't exist","ERROR");
                    throw new DatabaseException("Parent doesn't exist");
                }
            }
        }catch (SQLException ex){
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void createLeitet(String name, String email)throws DatabaseException {
        logwriter.writetoLog("function: createLeitet(primitive)","TRACE");
        try {
            Statement stmt = con.createStatement();
            try {
                stmt.executeUpdate("INSERT INTO Leitet (Name, EMailadresse) VALUES ('" + name + "', '" + email + "')");
                logwriter.writetoLog("successful","TRACE");
            }catch (SQLException e){
                ResultSet rs = stmt.executeQuery("SELECT Name, Emailadresse FROM Leitet WHERE Name = '" + name + "' AND Emailadresse = '" + email + "'");
                if(resultSize(rs)!=0){
                    logwriter.writetoLog("Leitet already exists","ERROR");
                    throw new DatabaseException("Leitet already exists");
                }else{
                    logwriter.writetoLog("Parent doesn't exist","ERROR");
                    throw new DatabaseException("Parent doesn't exist");
                }
            }
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    private void createMaxPunktzahl(String leistungsblockname, String unterblockname, String veranstaltungsname, String leistungsname, int punkte)throws DatabaseException {
        logwriter.writetoLog("function: createMaxPunktzahl(primitive)","TRACE");
        try {
            Statement stmt = con.createStatement();
            try {
                stmt.executeUpdate("INSERT INTO MaxPunktzahl (Leistungsblock_name, Unterblock_name, Veranstaltungsname, Leistung_name,Punkte) VALUES ('" + leistungsblockname + "', '" + unterblockname + "', '" + veranstaltungsname + "', '" + leistungsname + "', '" + punkte + "')");
                logwriter.writetoLog("successful","TRACE");
            }catch (SQLException e){
                ResultSet rs = stmt.executeQuery("SELECT Matrikelnummer, Einzelleistung_name, Leistungsblock_name, Unterblock_name, Veranstaltungsname FROM MaxPunktzahl WHERE  Leistung_name = '" + leistungsname + "' AND Leistungsblock_name = '" + leistungsblockname + "' AND Unterblock_name = '" + unterblockname + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
                if(resultSize(rs)!=0){
                    logwriter.writetoLog("MaxPunktzahl already exists","ERROR");
                    throw new DatabaseException("MaxPunktzahl already exists");
                }else{
                    logwriter.writetoLog("Parent doesn't exist","ERROR");
                    throw new DatabaseException("Parent doesn't exist");
                }
            }
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void createStudienganganteil(String studiengang, int teamid, int gruppenid, String veranstaltungsname, int anteil)throws DatabaseException {
        logwriter.writetoLog("function: createStudienganganteil(primitive)","TRACE");
        try {
            Statement stmt = con.createStatement();
            try {
                stmt.executeUpdate("INSERT INTO Studienganganteil (Studiengang, TeamID, GruppenID, Veranstaltungsname, Anteil) VALUES ('" + studiengang + "', '" + teamid + "', '" + gruppenid + "', '" + veranstaltungsname + "', '" + anteil + "')");
                logwriter.writetoLog("successful","TRACE");
            }catch (SQLException e) {
                ResultSet rs = stmt.executeQuery("SELECT Studiengang, TeamID, GruppenID, Veranstaltungsname  FROM Studienganganteil WHERE Studiengang = '" + studiengang + "' AND TeamID = '" + teamid + "' AND GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
                if(resultSize(rs)!=0){
                    logwriter.writetoLog("Studienganganteil already exists","ERROR");
                    throw new DatabaseException("Studienganganteil already exists");
                }else{
                    logwriter.writetoLog("Parent doesn't exist","ERROR");
                    throw new DatabaseException("Parent doesn't exist");
                }
            }
        } catch (SQLException ex){
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void createTeam(int teamid, int gruppenid, String veranstaltungsname, String thema)throws DatabaseException {
        logwriter.writetoLog("function: createTeam(primitive)","TRACE");
        try {
            Statement stmt = con.createStatement();
            try {
                stmt.executeUpdate("INSERT INTO Team (TeamID, GruppenID, Veranstaltungsname, Thema) VALUES ('" + teamid + "', '" + gruppenid + "' , '" + veranstaltungsname + "', '" + thema + "')");
                logwriter.writetoLog("successful","TRACE");
            }catch (SQLException e){
                ResultSet rs = stmt.executeQuery("SELECT TeamID, GruppenID, Veranstaltungsname  FROM Team WHERE TeamID = '" + teamid + "' AND GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
                if(resultSize(rs)!=0){
                    logwriter.writetoLog("Team already exists","ERROR");
                    throw new DatabaseException("Team already exists");
                }else {
                    logwriter.writetoLog("Parent doesn't exist","ERROR");
                    throw new DatabaseException("Parent doesn't exist");
                }
            }
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void createTeamleistung(String teamleistungsblockname, String teamleistungsunterblockname,String teamleistungsname, int teamid, int gruppenid, String veranstaltungsname, int punkte)throws DatabaseException {
        logwriter.writetoLog("function: createTeamleistung(primitive)","TRACE");
        try {
            Statement stmt = con.createStatement();
            try{
                stmt.executeUpdate("INSERT INTO Teamleistung (Teamleistungsblockname, Teamleistungsunterblockname, Teamleistungsname, TeamID, GruppenID, Veranstaltungsname, Punkte) VALUES ('" + teamleistungsblockname + "', '" + teamleistungsunterblockname + "', '" + teamleistungsname + "', '" + teamid +"', '" + gruppenid +"', '" + veranstaltungsname +"', '" + punkte +"')");
                logwriter.writetoLog("successful","TRACE");
            }catch (SQLException e) {
                ResultSet rs = stmt.executeQuery("SELECT Teamleistungsblockname, Teamleistungsunterblockname, Teamleistungsname, TeamID, GruppenID, Veranstaltungsname  FROM Teamleistung WHERE Teamleistungsblockname = '" + teamleistungsblockname + "' AND Teamleistungsunterblockname = '" + teamleistungsunterblockname + "' AND Teamleistungsname = '" + teamleistungsname + "' AND TeamID = '" + teamid + "' AND GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
                if(resultSize(rs)!=0){
                    logwriter.writetoLog("Teamleistung already exists","ERROR");
                    throw new DatabaseException("Teamleistung already exists");
                }else{
                    logwriter.writetoLog("Parent doesn't exist","ERROR");
                    throw new DatabaseException("Parent doesn't exist");
                }
            }
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void createTeamLeistungsUnterblock(String teamleistungsblockname, String teamleistungsunterblockname, int teamid, int gruppenid, String veranstaltungsname)throws DatabaseException {
        logwriter.writetoLog("function: createTeamleistungsUnterblock(primitive)","TRACE");
        try {
            Statement stmt = con.createStatement();
            try{
                stmt.executeUpdate("INSERT INTO Teamleistungsunterblock (Teamleistungsblockname, Teamleistungsunterblockname, TeamID, GruppenID, Veranstaltungsname) VALUES ('" + teamleistungsblockname + "', '" + teamleistungsunterblockname + "', '" + teamid +"', '" + gruppenid +"', '" + veranstaltungsname + "')");
                logwriter.writetoLog("successful","TRACE");
            }catch (SQLException e) {
                ResultSet rs = stmt.executeQuery("SELECT Teamleistungsblockname, Teamleistungsunterblockname, TeamID, GruppenID, Veranstaltungsname  FROM Teamleistungsunterblock WHERE Teamleistungsblockname = '" + teamleistungsblockname + "' AND Teamleistungsunterblockname = '" + teamleistungsunterblockname + "' AND TeamID = '" + teamid + "' AND GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
                if(resultSize(rs)!=0){
                    logwriter.writetoLog("TeamleistungsUnterblock already exists","ERROR");
                    throw new DatabaseException("TeamleistungsUnterblock already exists");
                }else{
                    logwriter.writetoLog("Parent doesn't exist","ERROR");
                    throw new DatabaseException("Parent doesn't exist");
                }
            }
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void createTeamLeistungsblock(String teamleistungsblockname, int teamid, int gruppenid, String veranstaltungsname)throws DatabaseException {
        logwriter.writetoLog("function: createTeamleistungsblock(primitive)","TRACE");
        try {
            Statement stmt = con.createStatement();
            try{
                stmt.executeUpdate("INSERT INTO Teamleistungsblock (Teamleistungsblockname, TeamID, GruppenID, Veranstaltungsname) VALUES ('" + teamleistungsblockname + "', '" + teamid +"', '" + gruppenid +"', '" + veranstaltungsname + "')");
                logwriter.writetoLog("successful","TRACE");
            }catch (SQLException e) {
                ResultSet rs = stmt.executeQuery("SELECT Teamleistungsblockname, TeamID, GruppenID, Veranstaltungsname  FROM Teamleistungsblock WHERE Teamleistungsblockname = '" + teamleistungsblockname + "' AND TeamID = '" + teamid + "' AND GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
                if(resultSize(rs)!=0){
                    logwriter.writetoLog("Teamleistungsblock already exists","ERROR");
                    throw new DatabaseException("Teamleistungsblock already exists");
                }else{
                    logwriter.writetoLog("Parent doesn't exist","ERROR");
                    throw new DatabaseException("Parent doesn't exist");
                }
            }
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void createUnterblock(int matrikelnummer, String leistungsblockname, String unterblockname, String veranstaltungsname)throws DatabaseException {
        logwriter.writetoLog("function: createUnterblock(primitive)","TRACE");
        try {
            Statement stmt = con.createStatement();
            try {
                stmt.executeUpdate("INSERT INTO Unterblock (Matrikelnummer, Leistungsblock_name, Unterblock_name, Veranstaltungsname) VALUES ('" + matrikelnummer + "', '" + leistungsblockname + "', '" + unterblockname + "', '" + veranstaltungsname + "')");
                logwriter.writetoLog("successful","TRACE");
            }catch (SQLException e){
                ResultSet rs = stmt.executeQuery("SELECT Matrikelnummer, Leistungsblock_name, Unterblock_name, Veranstaltungsname FROM Unterblock WHERE Matrikelnummer = '" + matrikelnummer + "' AND Leistungsblock_name = '" + leistungsblockname + "' AND Unterblock_name = '" + unterblockname + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
                if(resultSize(rs)!=0){
                    logwriter.writetoLog("Unterblock already exists","ERROR");
                    throw new DatabaseException("Unterblock already exists");
                }else{
                    logwriter.writetoLog("Parent doesn't exist","ERROR");
                    throw new DatabaseException("Parent doesn't exist");
                }
            }
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void createEinzelleistung(int matrikelnummer, String leistungsblockname, String unterblockname, String veranstaltungsname, String einzelleistungsname, int punkte)throws DatabaseException {
        logwriter.writetoLog("function: createEinzelleistung(primitive)","TRACE");
        try {
            Statement stmt = con.createStatement();
            try {
                stmt.executeUpdate("INSERT INTO Einzelleistung (Matrikelnummer, Leistungsblock_name, Unterblock_name, Veranstaltungsname, Einzelleistung_name,Punkte) VALUES ('" + matrikelnummer + "', '" + leistungsblockname + "', '" + unterblockname + "', '" + veranstaltungsname + "', '" + einzelleistungsname + "', '" + punkte + "')");
                logwriter.writetoLog("successful","TRACE");
            }catch (SQLException e){
                ResultSet rs = stmt.executeQuery("SELECT Matrikelnummer, Einzelleistung_name, Leistungsblock_name, Unterblock_name, Veranstaltungsname FROM Einzelleistung WHERE Matrikelnummer = '" + matrikelnummer + "' AND Einzelleistung_name = '" + einzelleistungsname + "' AND Leistungsblock_name = '" + leistungsblockname + "' AND Unterblock_name = '" + unterblockname + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
                if(resultSize(rs)!=0){
                    logwriter.writetoLog("Einzelleistung already exists","ERROR");
                    throw new DatabaseException("Einzelleistung already exists");
                }else{
                    logwriter.writetoLog("Parent doesn't exist","ERROR");
                    throw new DatabaseException("Parent doesn't exist");
                }
            }
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }


    public void createVeranstaltung(String veranstaltungsname, String fakultaet, int teamanzahl, int max, String beschreibung  )throws DatabaseException {
        logwriter.writetoLog("function: createVeranstaltung(primitive)","TRACE");
        try {
            Statement stmt = con.createStatement();
            try {
                stmt.executeUpdate("INSERT INTO Veranstaltung (Veranstaltungsname, Fakultaet, Teamanzahl_je_Gruppe, maximale_Teilnehmeranzahl_je_Team, Beschreibung) VALUES ('" + veranstaltungsname + "', '" + fakultaet + "', '" + teamanzahl + "', '" + max + "', '" + beschreibung + "')");
                logwriter.writetoLog("successful","TRACE");
            }catch (SQLException e){
                logwriter.writetoLog("Veranstaltung already exists","ERROR");
                throw new DatabaseException("Veranstaltung already exists");
            }
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }


    // creater(objects)
    //
    public void  createStudent(Student stud)throws DatabaseException {
        createNutzer(stud.getEmail(),stud.getTitel(),stud.getVorname(),stud.getNachname(),stud.getPasswort());
        createStudent(stud.getEmail(),stud.getMatrikelnr(),stud.getStudiengang());
    }

    public void  createDozent(Dozent doz)throws DatabaseException {
        createNutzer(doz.getEmail(),doz.getTitel(),doz.getVorname(),doz.getNachname(),doz.getPasswort());
        createDozent(doz.getEmail(),doz.getFakultaet());
    }

    public void createVeranstaltung(Veranstaltung veranstaltung) throws DatabaseException
    {
        createVeranstaltung(veranstaltung.getName(),
                            veranstaltung.getFakultaet(),
                            veranstaltung.getTeamanzahl(),
                            veranstaltung.getMaxTeilnehmer(),
                            veranstaltung.getBeschreibung());
    }

    public void createLeitet(Dozent dozent, Veranstaltung veranstaltung) throws DatabaseException
    {
        createLeitet(veranstaltung.getName(), dozent.getEmail());
    }

    public void createGruppe(Gruppe gruppe) throws DatabaseException
    {
        createGruppe(gruppe.getGruppenID(),
                     gruppe.getDozent().getEmail(),
                     gruppe.getVeranstaltung().getName(),
                     gruppe.getFrist(),
                     gruppe.getZeit(),
                     gruppe.getWochentag(),
                     gruppe.getRhythmus());
    }

    public void createTeam(Team team) throws DatabaseException
    {
        createTeam(team.getTeamID(),
                    team.getGruppe().getGruppenID(),
                    team.getGruppe().getVeranstaltung().getName(),
                    team.getThema());
    }

    public void createGehoert_zu(Student student, Team team) throws DatabaseException
    {
        createGehoertZu(student.getMatrikelnr(),
                        team.getTeamID(),
                        team.getGruppe().getGruppenID(),
                        team.getGruppe().getVeranstaltung().getName());
    }

    public void createStudienganganteil(Studienganganteil studienganganteil) throws DatabaseException
    {
        createStudienganganteil(studienganganteil.getStudiengang(),
                                studienganganteil.getTeam().getTeamID(),
                                studienganganteil.getTeam().getGruppe().getGruppenID(),
                                studienganganteil.getTeam().getGruppe().getVeranstaltung().getName(),
                                studienganganteil.getAnteil());
    }

    public void createLeistungEinzel(Leistung leistungs) throws DatabaseException
    {
        createLeistungsblock(leistungs.getStudent().getMatrikelnr(),
                     leistungs.getLbName(),
                     leistungs.getVeranstaltung().getName());
    }

    public void createUnterblockEinzel(Unterblock unterblock) throws DatabaseException
    {
        createUnterblock(unterblock.getlBlock().getStudent().getMatrikelnr(),
                        unterblock.getlBlock().getLbName(),
                        unterblock.getUbName(),
                        unterblock.getlBlock().getVeranstaltung().getName());
    }

    public void createAufgabeEinzel(Aufgabe aufgabe) throws DatabaseException
    {
               createEinzelleistung(aufgabe.getUnterblock().getlBlock().getStudent().getMatrikelnr(),
                        aufgabe.getUnterblock().getlBlock().getLbName(),
                        aufgabe.getUnterblock().getUbName(),
                        aufgabe.getUnterblock().getlBlock().getVeranstaltung().getName(),
                        aufgabe.getElName(),
                        aufgabe.getUnterblock().getUbPunkte());
               createMaxPunktzahl(aufgabe);
    }

    public void createLeistungTeam(Leistung leistungs,Team team) throws DatabaseException
    {
        createTeamLeistungsblock(leistungs.getLbName(),
                team.getTeamID(),
                team.getGruppe().getGruppenID(),
                leistungs.getVeranstaltung().getName());
    }

    public void createUnterblockTeam(Unterblock unterblock, Team team) throws DatabaseException
    {
        createTeamLeistungsUnterblock(unterblock.getlBlock().getLbName(),
                unterblock.getUbName(),
                team.getTeamID(),
                team.getGruppe().getGruppenID(),
                unterblock.getlBlock().getVeranstaltung().getName());
    }

    public void createAufgabeTeam(Aufgabe aufgabe, Team team) throws DatabaseException
    {
        createTeamleistung(aufgabe.getUnterblock().getlBlock().getLbName(),
                aufgabe.getUnterblock().getUbName(),
                aufgabe.getElName(),
                team.getTeamID(),
                team.getGruppe().getGruppenID(),
                aufgabe.getUnterblock().getlBlock().getVeranstaltung().getName(),
                aufgabe.getElPunkte());
        createMaxPunktzahl(aufgabe);
    }

    public  void createMaxPunktzahl(Aufgabe aufgabe) throws DatabaseException{
        createMaxPunktzahl(aufgabe.getUnterblock().getlBlock().getLbName(),aufgabe.getUnterblock().getUbName(),aufgabe.getUnterblock().getlBlock().getVeranstaltung().getName(),aufgabe.getElName(),aufgabe.getMaxPunkte());
    }


    public void createLeistungEinzel(Veranstaltung veranstaltung, String leistungsname)throws DatabaseException{
        ArrayList<Student> studenten = getStudenten(veranstaltung);
        for (Student s:studenten) {
            createLeistungEinzel(new Leistung(leistungsname,veranstaltung,s));
        }
    }

    public void createUnterblockEinzel(Veranstaltung veranstaltung, String leistungsname, String unterblockname)throws DatabaseException{
        ArrayList<Student> studenten = getStudenten(veranstaltung);
        for (Student s:studenten) {
            createUnterblockEinzel(new Unterblock(unterblockname, new Leistung(leistungsname,veranstaltung,s)));
        }
    }

    public void createAufgabeEinzel(Veranstaltung veranstaltung, String leistungsname, String unterblockname, String aufgabename, int maxPunkte)throws DatabaseException{
        ArrayList<Student> studenten = getStudenten(veranstaltung);
        for (Student s:studenten) {
            createAufgabeEinzel(new Aufgabe(aufgabename,0,new Unterblock(unterblockname, new Leistung(leistungsname,veranstaltung,s))));
        }
        Aufgabe a = new Aufgabe(aufgabename,0,new Unterblock(unterblockname, new Leistung(leistungsname,veranstaltung)));
        a.setMaxPunkte(maxPunkte);
        createMaxPunktzahl(a);
    }

    public void createLeistungTeam(Veranstaltung veranstaltung, String leistungsname)throws DatabaseException{
        ArrayList<Team> teams = new ArrayList<>();
        for(Gruppe g: getGruppen(veranstaltung)) {
            teams.addAll(g.getTeams()) ;
        }
        for (Team t:teams) {
            createLeistungTeam(new Leistung(leistungsname,veranstaltung),t);
        }
    }
    public void createUnterblockTeam(Veranstaltung veranstaltung, String leistungsname, String unterblockname)throws DatabaseException{
        ArrayList<Team> teams = new ArrayList<>();
        for(Gruppe g: getGruppen(veranstaltung)) {
            teams.addAll(g.getTeams()) ;
        }
        for (Team t:teams) {
            createUnterblockTeam(new Unterblock(unterblockname, new Leistung(leistungsname,veranstaltung)),t);
        }
    }
    public void createAufgabeTeam(Veranstaltung veranstaltung, String leistungsname, String unterblockname, String aufgabename, int maxPunkte)throws DatabaseException{
        ArrayList<Team> teams = new ArrayList<>();
        for(Gruppe g: getGruppen(veranstaltung)) {
            teams.addAll(g.getTeams()) ;
        }
        for (Team t:teams) {
            createAufgabeTeam(new Aufgabe(aufgabename,0,new Unterblock(unterblockname, new Leistung(leistungsname,veranstaltung))),t);
        }
        Aufgabe a = new Aufgabe(aufgabename,0,new Unterblock(unterblockname, new Leistung(leistungsname,veranstaltung)));
        a.setMaxPunkte(maxPunkte);
        createMaxPunktzahl(a);
    }

    //deleter(primitiv)
    //
    public void deleteUnterblock(int matrikelnummer, String leistungsblockname, String unterblockname, String veranstaltungsname) throws DatabaseException
    {
        logwriter.writetoLog("function: deleteUnterblock(primitive)","TRACE");
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Einzelleistung WHERE Veranstaltungsname = '" + veranstaltungsname + "' AND Matrikelnummer = '" + matrikelnummer + "' AND Leistungsblock_name = '" + leistungsblockname + "' AND Unterblock_name = '" + unterblockname + "'");
            logwriter.writetoLog("  deleted from Einzelleistung","TRACE");
            stmt.executeUpdate("DELETE FROM Unterblock WHERE Veranstaltungsname = '" + veranstaltungsname + "' AND Matrikelnummer = '" + matrikelnummer + "' AND Leistungsblock_name = '" + leistungsblockname + "' AND Unterblock_name = '" + unterblockname + "'");
            logwriter.writetoLog("  deleted from Unterblock","TRACE");
        }catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void deleteEinzelleistung(int matrikelnummer, String leistungsblockname, String unterblockname, String einzelleistungsname,String veranstaltungsname) throws DatabaseException
    {
        logwriter.writetoLog("function: deleteEinzelleistung(primitive)","TRACE");
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Einzelleistung WHERE Matrikelnummer = '" + matrikelnummer + "' AND Leistungsblock_name = '" + leistungsblockname + "' AND Unterblock_name = '" + unterblockname + "' AND Einzelleistung_name = '" + einzelleistungsname + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
            logwriter.writetoLog("successful","TRACE");
        }catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void deleteDozent(String email) throws DatabaseException
    {
        logwriter.writetoLog("function: deleteDozent(primitive)","TRACE");
        try {
            Statement stmt = con.createStatement();
            try{
                stmt.executeUpdate("DELETE FROM Dozent WHERE Emailadresse = '" + email + "'");
                logwriter.writetoLog("successful","TRACE");
            }catch(SQLException e){
                ResultSet rs = stmt.executeQuery("SELECT Emailadresse, FROM Dozent WHERE Emailadresse = '" + email + "'");
                if (resultSize(rs) != 0) {
                    logwriter.writetoLog("delete Parent first","ERROR");
                    throw new DatabaseException("delete Parent first");
                }else {
                    logwriter.writetoLog("item doesn't exists","ERROR");
                    throw new DatabaseException("item doesn't exists");
                }
            }
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }

    }

    public void deleteDozent(Dozent dozent) throws DatabaseException
    {
        try
        {
            deleteDozent(dozent.getEmail());
            deleteNutzer(dozent.getEmail());
        }
        catch (DatabaseException e)
        {
            logwriter.writetoLog(e.getErrorMsg(), "Error");
            throw new DatabaseException("Cant delete item");
        }
    }

    public void deleteGehoertZu(int matrikelnummer,int teamid, int gruppenid, String veranstaltungsname) throws DatabaseException
    {
        logwriter.writetoLog("function: deleteGehoertZu(primitive)","TRACE");
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Gehoert_zu WHERE matrikelnummer = '" + matrikelnummer + "' AND TeamID = '" + teamid + "' AND GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
            logwriter.writetoLog("successful","TRACE");
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void deleteGruppe(int gruppenid, String veranstaltungsname) throws DatabaseException
    {
        logwriter.writetoLog("function: deleteGruppe(primitive)","TRACE");
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Teamleistung WHERE Veranstaltungsname = '" + veranstaltungsname + "' AND GruppenID = '" + gruppenid + "'");
            logwriter.writetoLog("  deleted from Teamleistung","TRACE");
            stmt.executeUpdate("DELETE FROM Teamleistungsunterblock WHERE Veranstaltungsname = '" + veranstaltungsname + "' AND GruppenID = '" + gruppenid + "'");
            logwriter.writetoLog("  deleted from Teamleistungsunterblock","TRACE");
            stmt.executeUpdate("DELETE FROM Teamleistungsblock WHERE Veranstaltungsname = '" + veranstaltungsname + "' AND GruppenID = '" + gruppenid + "'");
            logwriter.writetoLog("  deleted from Teamleistungsblock","TRACE");
            stmt.executeUpdate("DELETE FROM Studienganganteil WHERE Veranstaltungsname = '" + veranstaltungsname + "' AND GruppenID = '" + gruppenid + "'");
            logwriter.writetoLog("  deleted from Studienganganteil","TRACE");
            stmt.executeUpdate("DELETE FROM Gehoert_zu WHERE Veranstaltungsname = '" + veranstaltungsname + "' AND GruppenID = '" + gruppenid + "'");
            logwriter.writetoLog("  deleted from Gehoert_zu","TRACE");
            stmt.executeUpdate("DELETE FROM Team WHERE Veranstaltungsname = '" + veranstaltungsname + "' AND GruppenID = '" + gruppenid + "'");
            logwriter.writetoLog("  deleted from Team","TRACE");
            stmt.executeUpdate("DELETE FROM Gruppe WHERE Veranstaltungsname = '" + veranstaltungsname + "' AND GruppenID = '" + gruppenid + "'");
            logwriter.writetoLog("successful","TRACE");
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void deleteLeistungsblock(int matrikelnummer, String leistungsblockname, String veranstaltungsname) throws DatabaseException
    {
        logwriter.writetoLog("function: deleteLeistungsblock(primitive)","TRACE");
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Einzelleistung WHERE Veranstaltungsname = '" + veranstaltungsname + "' AND Matrikelnummer = '" + matrikelnummer + "' AND Leistungsblock_name = '" + leistungsblockname + "'");
            logwriter.writetoLog("  deleted from Einzelleistung","TRACE");
            stmt.executeUpdate("DELETE FROM Unterblock WHERE Veranstaltungsname = '" + veranstaltungsname + "' AND Matrikelnummer = '" + matrikelnummer + "' AND Leistungsblock_name = '" + leistungsblockname + "'");
            logwriter.writetoLog("  deleted from Unterblock","TRACE");
            stmt.executeUpdate("DELETE FROM Leistungsblock WHERE Matrikelnummer = '" + matrikelnummer + "' AND Leistungsblock_name = '" + leistungsblockname + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
            logwriter.writetoLog("successful","TRACE");
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void deleteLeitet(String name, String email) throws DatabaseException
    {
        logwriter.writetoLog("function: deleteLeitet(primitive)","TRACE");
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Leitet WHERE Name = '" + name + "' AND Emailadresse = '" + email + "'");
            logwriter.writetoLog("successful","TRACE");
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    // TODO parent to child because you need to delete the child first
    public void deleteLeitet(Veranstaltung veranstaltung) throws DatabaseException
    {
        logwriter.writetoLog("function: deleteLeitet(Veranstaltung)","TRACE");
        String veranstaltungsname = veranstaltung.getName();
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Leitet WHERE Name = '" + veranstaltungsname + "'");
            logwriter.writetoLog("successful","TRACE");
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void deleteNutzer(String email) throws DatabaseException
    {
        logwriter.writetoLog("function: deleteNutzer(primitive)","TRACE");
        try {
            Statement stmt = con.createStatement();
            try{
                stmt.executeUpdate("DELETE FROM Nutzer WHERE Emailadresse = '" + email + "'");
                logwriter.writetoLog("successful","TRACE");
            }catch (SQLException e){
                logwriter.writetoLog("item doesn't exists","ERROR");
                throw new DatabaseException("item doesn't exists");
            }
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void deleteStudent(String email) throws DatabaseException
    {
        logwriter.writetoLog("function: deleteStudent(primitive)","TRACE");
        try {
            Statement stmt = con.createStatement();
            try {
                stmt.executeUpdate("DELETE FROM Student WHERE Emailadresse = '" + email + "'");
                logwriter.writetoLog("successful","TRACE");
            }catch(SQLException e){
                ResultSet rs = stmt.executeQuery("SELECT Emailadresse, FROM Student WHERE Emailadresse = '" + email + "'");
                if (resultSize(rs) != 0) {
                    logwriter.writetoLog("delete Parent first","ERROR");
                    throw new DatabaseException("delete Parent first");
                }else {
                    logwriter.writetoLog("item doesn't exists","ERROR");
                    throw new DatabaseException("item doesn't exists");
                }
            }
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void deleteStudent(Student student) throws DatabaseException
    {
        try
        {
            deleteStudent(student.getEmail());
            deleteNutzer(student.getEmail());
        }
        catch (DatabaseException e)
        {
            logwriter.writetoLog(e.getErrorMsg(), "Error");
            throw new DatabaseException("Cant delete item");
        }
    }

    public void deleteStudienganganteil(String studiengang, int teamid, int gruppenid, String veranstaltungsname) throws DatabaseException
    {
        logwriter.writetoLog("function: deleteStudienganganteil(primitive)","TRACE");
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Studienganganteil WHERE Studiengang = '" + studiengang + "' AND TeamID = '" + teamid + "' AND GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
            logwriter.writetoLog("successful","TRACE");
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void deleteTeam(int teamid, int gruppenid, String veranstaltungsname) throws DatabaseException
    {
        logwriter.writetoLog("function: deleteTeam(primitive)","TRACE");
        try {
            Statement stmt = con.createStatement();
            try{
                stmt.executeUpdate("DELETE FROM Teamleistung WHERE TeamID = '" + teamid + "' AND Veranstaltungsname = '" + veranstaltungsname + "' AND GruppenID = '" + gruppenid + "'");
                logwriter.writetoLog("  deleted from Teamleistung","TRACE");
                stmt.executeUpdate("DELETE FROM Teamleistungsunterblock WHERE TeamID = '" + teamid + "' AND Veranstaltungsname = '" + veranstaltungsname + "' AND GruppenID = '" + gruppenid + "'");
                logwriter.writetoLog("  deleted from Teamleistungsunterblock","TRACE");
                stmt.executeUpdate("DELETE FROM Teamleistungsblock WHERE TeamID = '" + teamid + "' AND Veranstaltungsname = '" + veranstaltungsname + "' AND GruppenID = '" + gruppenid + "'");
                logwriter.writetoLog("  deleted from Teamleistungsblock","TRACE");
                stmt.executeUpdate("DELETE FROM Studienganganteil WHERE TeamID = '" + teamid + "' AND Veranstaltungsname = '" + veranstaltungsname + "' AND GruppenID = '" + gruppenid + "'");
                logwriter.writetoLog("  deleted from Studienganganteil","TRACE");
                stmt.executeUpdate("DELETE FROM Gehoert_zu WHERE TeamID = '" + teamid + "' AND Veranstaltungsname = '" + veranstaltungsname + "' AND GruppenID = '" + gruppenid + "'");
                logwriter.writetoLog("  deleted from Gehoert_zu","TRACE");
                stmt.executeUpdate("DELETE FROM Team WHERE TeamID = '" + teamid + "' AND GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
                logwriter.writetoLog("successful","TRACE");
            }catch (SQLException e){
                ResultSet rs = stmt.executeQuery("SELECT TeamID, GruppenID, Veranstaltungsname FROM Team WHERE TeamID = '" + teamid + "' AND GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
                if(resultSize(rs)!=0){
                    logwriter.writetoLog("delete Parent first","ERROR");
                    throw new DatabaseException("delete Parent first");
                }else {
                    logwriter.writetoLog("item doesn't exists","ERROR");
                    throw new DatabaseException("item doesn't exists");
                }
            }
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }

    }

    public void deleteTeamleistungsblock(String teamleistungsblockname, int teamid, int gruppenid, String veranstaltungsname) throws DatabaseException
    {
        logwriter.writetoLog("function: deleteTeamleistungsblock(primitive)","TRACE");
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Teamleistung WHERE Teamleistungsblockname = '" + teamleistungsblockname + "' AND TeamID = '" + teamid + "' AND Veranstaltungsname = '" + veranstaltungsname + "' AND GruppenID = '" + gruppenid + "'");
            logwriter.writetoLog("  deleted from Teamleistung","TRACE");
            stmt.executeUpdate("DELETE FROM Teamleistungsunterblock Teamleistungsblockname = '" + teamleistungsblockname + "' AND WHERE TeamID = '" + teamid + "' AND Veranstaltungsname = '" + veranstaltungsname + "' AND GruppenID = '" + gruppenid + "'");
            logwriter.writetoLog("  deleted from Teamleistungsunterblock","TRACE");
            stmt.executeUpdate("DELETE FROM Teamleistungsblock WHERE Teamleistungsblockname = '" + teamleistungsblockname + "' AND TeamID = '" + teamid + "' AND GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
            logwriter.writetoLog("successful","TRACE");
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }
    }

    public void deleteTeamleistungsUnterblock(String teamleistungsblockname, String teamleistungsunterblockname, int teamid, int gruppenid, String veranstaltungsname) throws DatabaseException
    {
        logwriter.writetoLog("function: deleteTeamleistungsUnterblock(primitive)","TRACE");
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Teamleistung WHERE Teamleistungsblockname = '" + teamleistungsblockname + "' AND Teamleistungsunterblockname = '" + teamleistungsunterblockname + "' AND TeamID = '" + teamid + "' AND Veranstaltungsname = '" + veranstaltungsname + "' AND GruppenID = '" + gruppenid + "'");
            logwriter.writetoLog("  deleted from Teamleistung","TRACE");
            stmt.executeUpdate("DELETE FROM Teamleistungsunterblock WHERE Teamleistungsblockname = '" + teamleistungsblockname + "' AND Teamleistungsunterblockname = '" + teamleistungsunterblockname + "' AND TeamID = '" + teamid + "' AND GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
            logwriter.writetoLog("successful","TRACE");
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void deleteTeamleistung(String teamleistungsblockname, String teamleistungsunterblockname, String teamleistungsname,int teamid, int gruppenid, String veranstaltungsname) throws DatabaseException
    {
        logwriter.writetoLog("function: deleteTeamleistung(primitive)","TRACE");
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Teamleistung WHERE Teamleistungsblockname = '" + teamleistungsblockname + "' AND Teamleistungsunterblockname = '" + teamleistungsunterblockname + "' AND Teamleistungsname = '" + teamleistungsname + "' AND TeamID = '" + teamid + "' AND GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
            logwriter.writetoLog("successful","TRACE");
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void deleteVeranstaltung(String veranstaltungsname) throws DatabaseException
    {
        logwriter.writetoLog("function: deleteVeranstaltung(primitive)","TRACE");
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Leitet WHERE Name = '" + veranstaltungsname + "'");
            logwriter.writetoLog("  deleted from Leitet","TRACE");
            stmt.executeUpdate("DELETE FROM Teamleistung WHERE Veranstaltungsname = '" + veranstaltungsname + "'");
            logwriter.writetoLog("  deleted from Teamleistung","TRACE");
            stmt.executeUpdate("DELETE FROM Teamleistungsunterblock WHERE Veranstaltungsname = '" + veranstaltungsname + "'");
            logwriter.writetoLog("  deleted from Teamleistungsunterblock","TRACE");
            stmt.executeUpdate("DELETE FROM Teamleistungsblock WHERE Veranstaltungsname = '" + veranstaltungsname + "'");
            logwriter.writetoLog("  deleted from Teamleistungsblock","TRACE");
            stmt.executeUpdate("DELETE FROM Studienganganteil WHERE Veranstaltungsname = '" + veranstaltungsname + "'");
            logwriter.writetoLog("  deleted from Studienganganteil","TRACE");
            stmt.executeUpdate("DELETE FROM Gehoert_zu WHERE Veranstaltungsname = '" + veranstaltungsname + "'");
            logwriter.writetoLog("  deleted from Gehoert_zu","TRACE");
            stmt.executeUpdate("DELETE FROM Team WHERE Veranstaltungsname = '" + veranstaltungsname + "'");
            logwriter.writetoLog("  deleted from Team","TRACE");
            stmt.executeUpdate("DELETE FROM Gruppe WHERE Veranstaltungsname = '" + veranstaltungsname + "'");
            logwriter.writetoLog("  deleted from Gruppe","TRACE");
            stmt.executeUpdate("DELETE FROM Einzelleistung WHERE Veranstaltungsname = '" + veranstaltungsname + "'");
            logwriter.writetoLog("  deleted from Einzelleistung","TRACE");
            stmt.executeUpdate("DELETE FROM Unterblock WHERE Veranstaltungsname = '" + veranstaltungsname + "'");
            logwriter.writetoLog("  deleted from Unterblock","TRACE");
            stmt.executeUpdate("DELETE FROM Leistungsblock WHERE Veranstaltungsname = '" + veranstaltungsname + "'");
            logwriter.writetoLog("  deleted from Leistungsblock","TRACE");
            stmt.executeUpdate("DELETE FROM MaxPunktzahl WHERE Veranstaltungsname = '" + veranstaltungsname + "'");
            logwriter.writetoLog("  deleted from MaxPunktzahl","TRACE");
            stmt.executeUpdate("DELETE FROM Veranstaltung WHERE Veranstaltungsname = '" + veranstaltungsname + "'");
            logwriter.writetoLog("successful","TRACE");
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void deleteLeistungEinzel(Veranstaltung veranstaltung, String leistungsblockname)throws  DatabaseException{
        logwriter.writetoLog("function: deleteLeistungEinzel(Veranstaltung, String)","TRACE");
        String veranstaltungsname = veranstaltung.getName();
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Einzelleistung WHERE Veranstaltungsname = '" + veranstaltungsname + "' AND Leistungsblock_name = '" + leistungsblockname + "'");
            logwriter.writetoLog("  deleted from Einzelleistung","TRACE");
            stmt.executeUpdate("DELETE FROM Unterblock WHERE Veranstaltungsname = '" + veranstaltungsname + "' AND Leistungsblock_name = '" + leistungsblockname + "'");
            logwriter.writetoLog("  deleted from Unterblock","TRACE");
            stmt.executeUpdate("DELETE FROM Leistungsblock WHERE Leistungsblock_name = '" + leistungsblockname + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
            logwriter.writetoLog("successful","TRACE");
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void deleteUnterblockEinzel(Veranstaltung veranstaltung,String leistungsblockname, String unterblockname)throws  DatabaseException{
        logwriter.writetoLog("function: deleteUnterblockEinzel(Veranstaltung, String, String)","TRACE");
        String veranstaltungsname = veranstaltung.getName();
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Einzelleistung WHERE Veranstaltungsname = '" + veranstaltungsname + "' AND Leistungsblock_name = '" + leistungsblockname + "' AND Unterblock_name = '" + unterblockname + "'");
            logwriter.writetoLog("  deleted from Einzelleistung","TRACE");
            stmt.executeUpdate("DELETE FROM Unterblock WHERE Veranstaltungsname = '" + veranstaltungsname + "' AND Leistungsblock_name = '" + leistungsblockname + "' AND Unterblock_name = '" + unterblockname + "'");
            logwriter.writetoLog("successful","TRACE");
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void deleteAufgabeEinzel(Veranstaltung veranstaltung,String leistungsblockname, String unterblockname, String aufgabenname)throws  DatabaseException{
        logwriter.writetoLog("function: deleteLeistungEinzel(Veranstaltung, String, Strin, String)","TRACE");
        String veranstaltungsname = veranstaltung.getName();
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Einzelleistung WHERE Veranstaltungsname = '" + veranstaltungsname + "' AND Leistungsblock_name = '" + leistungsblockname + "' AND Unterblock_name = '" + unterblockname + "' AND Einzelleistung_name = '" + aufgabenname + "'");
            logwriter.writetoLog("successful","TRACE");
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void deleteLeistungTeam(Veranstaltung veranstaltung, String teamleistungsblockname) throws DatabaseException
    {
        logwriter.writetoLog("function: deleteLeistungTeam(Veranstaltung, String)","TRACE");
        String veranstaltungsname = veranstaltung.getName();
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Teamleistung WHERE Teamleistungsblockname = '" + teamleistungsblockname + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
            logwriter.writetoLog("  deleted from Teamleistung","TRACE");
            stmt.executeUpdate("DELETE FROM Teamleistungsunterblock Teamleistungsblockname = '" + teamleistungsblockname + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
            logwriter.writetoLog("  deleted from Teamleistungsunterblock","TRACE");
            stmt.executeUpdate("DELETE FROM Teamleistungsblock WHERE Teamleistungsblockname = '" + teamleistungsblockname + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
            logwriter.writetoLog("successful","TRACE");
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }
    }

    public void deleteUnterblockTeam(Veranstaltung veranstaltung, String teamleistungsblockname, String unterblockname) throws DatabaseException
    {
        logwriter.writetoLog("function: deleteUnterblockTeam(Veranstaltung, String, String)","TRACE");
        String veranstaltungsname = veranstaltung.getName();
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Teamleistung WHERE Teamleistungsblockname = '" + teamleistungsblockname + "' AND Veranstaltungsname = '" + veranstaltungsname + "' AND Teamleistungsunterblockname = '" + unterblockname + "'");
            logwriter.writetoLog("  deleted from Teamleistung","TRACE");
            stmt.executeUpdate("DELETE FROM Teamleistungsunterblock Teamleistungsblockname = '" + teamleistungsblockname + "' AND Veranstaltungsname = '" + veranstaltungsname + "' AND Teamleistungsunterblockname = '" + unterblockname + "'");
           logwriter.writetoLog("successful","TRACE");
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }
    }

    public void deleteAufgabeTeam(Veranstaltung veranstaltung, String teamleistungsblockname, String unterblockname, String aufgabenname) throws DatabaseException
    {
        logwriter.writetoLog("function: deleteAufgabeTeam(Veranstaltung, String, String, String)","TRACE");
        String veranstaltungsname = veranstaltung.getName();
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Teamleistung WHERE Teamleistungsblockname = '" + teamleistungsblockname + "' AND Veranstaltungsname = '" + veranstaltungsname + "' AND Teamleistungsunterblockname = '" + unterblockname + "' AND Teamleistungsname = '" + aufgabenname + "'");
            logwriter.writetoLog("successful","TRACE");
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }
    }

    //getter(primitiv)
    public Nutzer getNutzer(String email, char[] passwd) throws DatabaseException {
        System.out.println(passwd);
        logwriter.writetoLog("function: getNutzer(String,char[])","TRACE");
        //converting char array for password to a string
        String pwString = new String(passwd);
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT EMailadresse,Passwort FROM Nutzer WHERE EMailadresse = '" + email + "' AND Passwort = '" + pwString +"'");
            if(resultSize(rs)!=0){
                rs = stmt.executeQuery("SELECT EMailadresse, Matrikelnummer FROM Student WHERE EMailadresse = '" + email + "'");
                if(resultSize(rs)!=0){
                    rs = stmt.executeQuery("SELECT Nutzer.*,Student.Matrikelnummer, Student.Studiengang FROM Nutzer INNER JOIN Student ON Student.EMailadresse = Nutzer.EMailadresse WHERE Nutzer.EMailadresse = '" + email + "'");
                    rs.next();
                    logwriter.writetoLog("successful(Student)","TRACE");
                    return new Student(rs.getString("EMailadresse"),rs.getString("Passwort"),rs.getString("Titel"),rs.getString("Vorname"),rs.getString("Nachname"),rs.getString("Studiengang"),rs.getInt("Matrikelnummer"));
                }else{
                    rs = stmt.executeQuery("SELECT EMailadresse FROM Dozent WHERE EMailadresse = '" + email + "'");
                    if(resultSize(rs)!=0){
                        rs = stmt.executeQuery("SELECT Nutzer.*,Dozent.Fakultaet FROM Nutzer INNER JOIN Dozent ON Dozent.EMailadresse = Nutzer.EMailadresse WHERE Nutzer.EMailadresse = '" + email + "'");
                        rs.next();
                        logwriter.writetoLog("successful(Dozent)","TRACE");
                        return new Dozent(rs.getString("EMailadresse"),rs.getString("Passwort"),rs.getString("Titel"),rs.getString("Vorname"),rs.getString("Nachname"),rs.getString("Fakultaet"));
                    }
                }
                logwriter.writetoLog("Loading failed: not a Student/Dozent","ERROR");
                throw new DatabaseException("not a Student/Dozent");
            }
        }catch (SQLException ex){
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
        logwriter.writetoLog("Loading failed: wrong username/password","ERROR");
        throw new DatabaseException("wrong username/password");
    }

    public Nutzer getNutzer(String email, String passwd) throws DatabaseException {
        logwriter.writetoLog("function: getNutzer(String,String)","TRACE");
        String pwString = new String(passwd);
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT EMailadresse,Passwort FROM Nutzer WHERE EMailadresse = '" + email + "' AND Passwort = '" + pwString +"'");
            if(resultSize(rs)!=0){
                rs = stmt.executeQuery("SELECT EMailadresse, Matrikelnummer FROM Student WHERE EMailadresse = '" + email + "'");
                if(resultSize(rs)!=0){
                    rs = stmt.executeQuery("SELECT Nutzer.*,Student.Matrikelnummer, Student.Studiengang FROM Nutzer INNER JOIN Student ON Student.EMailadresse = Nutzer.EMailadresse WHERE Nutzer.EMailadresse = '" + email + "'");
                    rs.next();
                    logwriter.writetoLog("successful(Student)","TRACE");
                    return new Student(rs.getString("EMailadresse"),rs.getString("Passwort"),rs.getString("Titel"),rs.getString("Vorname"),rs.getString("Nachname"),rs.getString("Studiengang"),rs.getInt("Matrikelnummer"));
                }else{
                    rs = stmt.executeQuery("SELECT EMailadresse FROM Dozent WHERE EMailadresse = '" + email + "'");
                    if(resultSize(rs)!=0){
                        rs = stmt.executeQuery("SELECT Nutzer.*,Dozent.Fakultaet FROM Nutzer INNER JOIN Dozent ON Dozent.EMailadresse = Nutzer.EMailadresse WHERE Nutzer.EMailadresse = '" + email + "'");
                        rs.next();
                        logwriter.writetoLog("successful(Dozent)","TRACE");
                        return new Dozent(rs.getString("EMailadresse"),rs.getString("Passwort"),rs.getString("Titel"),rs.getString("Vorname"),rs.getString("Nachname"),rs.getString("Fakultaet"));
                    }
                }
                logwriter.writetoLog("Loading failed: not a Student/Dozent","ERROR");
                throw new DatabaseException("not a Student/Dozent");
            }
        }catch (SQLException ex){
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
        logwriter.writetoLog("Loading failed: wrong username/password","ERROR");
        throw new DatabaseException("wrong username/password");
    }

    public ArrayList<Veranstaltung> getVeranstaltungen(Dozent dozent) throws DatabaseException {
        logwriter.writetoLog("function: getVeranstaltung(Dozent)","TRACE");
        String email = dozent.getEmail();
        ArrayList<Veranstaltung> results = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Leitet.EMailadresse, Veranstaltung.* FROM Veranstaltung INNER JOIN Leitet ON Leitet.Name = Veranstaltung.Veranstaltungsname WHERE EMailadresse = '" + email + "'");
            while (rs.next()){
                Veranstaltung veranstaltung = new Veranstaltung(rs.getString("Veranstaltungsname"),rs.getString("Fakultaet"),rs.getInt("Teamanzahl_je_Gruppe"),rs.getInt("maximale_Teilnehmeranzahl_je_Team"), rs.getString("Beschreibung"));
                veranstaltung.setDozenten(getDozenten(veranstaltung));
                veranstaltung.setGruppen(this.getGruppen(veranstaltung));
                results.add(veranstaltung);
            }
            logwriter.writetoLog("successfully loaded:" + resultSize(rs),"TRACE");
        }catch (SQLException ex){
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }

        return  results;
    }

    public ArrayList<Veranstaltung> getVeranstaltungen(Student stud) throws  DatabaseException
    {
        logwriter.writetoLog("function: getVeranstaltung(Student)","TRACE");
        int matrikelnr = stud.getMatrikelnr();
        ArrayList<Veranstaltung> results = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT Veranstaltung.* FROM Gehoert_zu INNER JOIN Veranstaltung ON Veranstaltung.Veranstaltungsname = Gehoert_zu.Veranstaltungsname WHERE Matrikelnummer = '" + matrikelnr + "'");
            while (rs.next()){
                Veranstaltung veranstaltung = new Veranstaltung(rs.getString("Veranstaltungsname"),rs.getString("Fakultaet"),rs.getInt("Teamanzahl_je_Gruppe"),rs.getInt("maximale_Teilnehmeranzahl_je_Team"), rs.getString("Beschreibung"));
                veranstaltung.setDozenten(getDozenten(veranstaltung));
                veranstaltung.setGruppen(this.getGruppen(veranstaltung));
                results.add(veranstaltung);
            }
            logwriter.writetoLog("successfully loaded:" + resultSize(rs),"TRACE");
        }catch (SQLException ex){
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
        return  results;
    }

    public ArrayList<Dozent> getDozenten(Veranstaltung veranstaltung) throws  DatabaseException{
        logwriter.writetoLog("  function: getDozenten(Veranstaltung)","TRACE");
        String veranstaltungsname = veranstaltung.getName();
        ArrayList<Dozent> results = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Nutzer.*, Dozent.Fakultaet FROM Leitet INNER JOIN (Nutzer INNER JOIN Dozent ON Nutzer.EMailadresse = Dozent.EMailadresse) ON Leitet.EMailadresse = Dozent.EMailadresse WHERE Leitet.Name = '" + veranstaltungsname + "'");
            while (rs.next()){
                results.add(new Dozent(rs.getString("EMailadresse"),rs.getString("Passwort"),rs.getString("Titel"),rs.getString("Vorname"),rs.getString("Nachname"),rs.getString("Fakultaet")));
            }
            logwriter.writetoLog("  successfully loaded:" + resultSize(rs),"TRACE");
        }catch (SQLException ex){
            logwriter.writetoLog("  Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
        return  results;
    }

    public ArrayList<Dozent> getAllDozenten() throws  DatabaseException{
        logwriter.writetoLog("  function: getAllDozenten()","TRACE");
        ArrayList<Dozent> results = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Nutzer.*, Dozent.Fakultaet FROM Nutzer INNER JOIN Dozent ON Nutzer.EMailadresse = Dozent.EMailadresse");
            while (rs.next()){
                results.add(new Dozent(rs.getString("EMailadresse"),rs.getString("Passwort"),rs.getString("Titel"),rs.getString("Vorname"),rs.getString("Nachname"),rs.getString("Fakultaet")));
            }
            logwriter.writetoLog("  successfully loaded:" + resultSize(rs),"TRACE");
        }catch (SQLException ex){
            logwriter.writetoLog("  Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
        return  results;
    }

    public ArrayList<Student> getAllStudenten() throws DatabaseException{
        logwriter.writetoLog("  function: getAllStudenten()","TRACE");
        ArrayList<Student> results = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Nutzer.*, Student.Studiengang, Student.Matrikelnummer FROM Nutzer INNER JOIN Student ON Nutzer.EMailadresse = Student.EMailadresse");
            while (rs.next()){
                results.add(new Student(rs.getString("EMailadresse"),rs.getString("Passwort"),rs.getString("Titel"),rs.getString("Vorname"),rs.getString("Nachname"),rs.getString("Studiengang"),rs.getInt("Matrikelnummer")));
            }
            logwriter.writetoLog("  successfully loaded:" + resultSize(rs),"TRACE");
        }catch (SQLException ex){
            logwriter.writetoLog("  Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
        return  results;
    }

    public ArrayList<Student> getStudenten(Team team) throws DatabaseException{
        logwriter.writetoLog("  function: getStudenten(Team)","TRACE");
        String veranstaltungsname = team.getGruppe().getVeranstaltung().getName();
        int gruppenID = team.getGruppe().getGruppenID();
        int teamID = team.getTeamID();
        ArrayList<Student> results = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Nutzer.*, Student.Studiengang, Student.Matrikelnummer FROM Gehoert_zu INNER JOIN (Nutzer INNER JOIN Student ON Nutzer.EMailadresse = Student.EMailadresse) ON Gehoert_zu.Matrikelnummer = Student.Matrikelnummer WHERE Gehoert_zu.Veranstaltungsname = '" + veranstaltungsname + "' AND Gehoert_zu.GruppenID = '" + gruppenID + "' AND Gehoert_zu.TeamID = '" + teamID + "'");
            while (rs.next()){
                results.add(new Student(rs.getString("EMailadresse"),rs.getString("Passwort"),rs.getString("Titel"),rs.getString("Vorname"),rs.getString("Nachname"),rs.getString("Studiengang"),rs.getInt("Matrikelnummer")));
            }
            logwriter.writetoLog("  successfully loaded:" + resultSize(rs),"TRACE");
        }catch (SQLException ex){
            logwriter.writetoLog("  Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
        return  results;
    }

    public ArrayList<Student> getStudenten(Veranstaltung veranstaltung) throws DatabaseException{
        logwriter.writetoLog("  function: getStudenten(Veranstaltung)","TRACE");
        String veranstaltungsname = veranstaltung.getName();
        ArrayList<Student> results = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Nutzer.*, Student.Studiengang, Student.Matrikelnummer FROM Gehoert_zu INNER JOIN (Nutzer INNER JOIN Student ON Nutzer.EMailadresse = Student.EMailadresse) ON Gehoert_zu.Matrikelnummer = Student.Matrikelnummer WHERE Gehoert_zu.Veranstaltungsname = '" + veranstaltungsname + "'");
            while (rs.next()){
                results.add(new Student(rs.getString("EMailadresse"),rs.getString("Passwort"),rs.getString("Titel"),rs.getString("Vorname"),rs.getString("Nachname"),rs.getString("Studiengang"),rs.getInt("Matrikelnummer")));
            }
            logwriter.writetoLog("  successfully loaded:" + resultSize(rs),"TRACE");
        }catch (SQLException ex){
            logwriter.writetoLog("  Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
        return  results;
    }

    public ArrayList<Gruppe> getGruppen(Veranstaltung veranstaltung) throws  DatabaseException
    {
        logwriter.writetoLog("function: getGruppen(Veranstaltung)","TRACE");
        String veranstaltungsname = veranstaltung.getName();
        ArrayList<Gruppe> results = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT `Gruppe`.* FROM `Veranstaltung` INNER JOIN `Gruppe` ON `Gruppe`.`Veranstaltungsname` = `Veranstaltung`.`Veranstaltungsname` WHERE Veranstaltung.Veranstaltungsname = '" + veranstaltungsname + "'");
            while (rs.next()){
                Gruppe gruppe =new Gruppe(rs.getInt("GruppenID"), rs.getString("Wochentag"),rs.getTime("Uhrzeit"),rs.getString("Wochenrhytmus"),rs.getDate("Einschreibungsfrist"),veranstaltung,getDozent(rs.getString("EMailadresse")));
                gruppe.setTeams(getTeams(gruppe));
                results.add(gruppe);
            }
            logwriter.writetoLog("successfully loaded:" + resultSize(rs),"TRACE");
        }catch (SQLException ex){
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
        return  results;
    }

    public Dozent getDozent(String emailadresse) throws DatabaseException{
        try {
            logwriter.writetoLog("function: getDozent(String)","TRACE");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Nutzer.*, Dozent.Fakultaet FROM Nutzer INNER JOIN Dozent ON Nutzer.EMailadresse = Dozent.EMailadresse WHERE Nutzer.EMailadresse = '" + emailadresse + "'");
            if(resultSize(rs)!=0) {
                Dozent result = new Dozent(rs.getString("EMailadresse"),rs.getString("Passwort"),rs.getString("Titel"),rs.getString("Vorname"),rs.getString("Nachname"),"Fakultaet");
                logwriter.writetoLog("successful","TRACE");
                return result;
            }
        }catch (SQLException ex){
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
        logwriter.writetoLog("returned none","TRACE");
        return  null;
    }

    public  ArrayList<Team> getTeams(Gruppe gruppe) throws  DatabaseException
    {
        logwriter.writetoLog("function: getTeams(Gruppe)","TRACE");
        String veranstaltungsname = gruppe.getVeranstaltung().getName();
        int gruppenid = gruppe.getGruppenID();
        ArrayList<Team> results = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT `Team`.* FROM `Gruppe` INNER JOIN `Team` ON `Team`.`GruppenID` = `Gruppe`.`GruppenID` AND `Team`.`Veranstaltungsname` = `Gruppe`.`Veranstaltungsname` WHERE Team.GruppenID = '" + gruppenid + "' AND Team.Veranstaltungsname = '" + veranstaltungsname + "'");
            while (rs.next()){
                results.add(new Team(rs.getInt("TeamID"),rs.getString("Thema"),gruppe));
            }
            logwriter.writetoLog("successfully loaded:" + resultSize(rs),"TRACE");
        }catch (SQLException ex){
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
        return  results;
    }

    public  Team getTeam(Student student, Gruppe gruppe) throws  DatabaseException
    {
        logwriter.writetoLog("function: getTeam(Student, Gruppe)","TRACE");
        String veranstaltungsname = gruppe.getVeranstaltung().getName();
        int gruppenid = gruppe.getGruppenID();
        int matrikelnummer = student.getMatrikelnr();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Team.* FROM Gehoert_zu INNER JOIN Team ON Team.TeamID = Gehoert_zu.TeamID AND Team.GruppenID = Gehoert_zu.GruppenID AND Team.Veranstaltungsname = Gehoert_zu.Veranstaltungsname WHERE Gehoert_zu.Matrikelnummer = '" + matrikelnummer + "' AND Team.Veranstaltungsname = '" + veranstaltungsname + "' AND Team.GruppenID = '" + gruppenid + "'");
            if(resultSize(rs)!=0) {
                Team result = new Team(rs.getInt("TeamID"),rs.getString("Thema"),gruppe);
                logwriter.writetoLog("successful","TRACE");
                return result;
            }
        }catch (SQLException ex){
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
        logwriter.writetoLog("returned none","TRACE");
        return  null;
    }

    public ArrayList <Leistung> getLeistungsblock(Student student, Veranstaltung veranstaltung) throws  DatabaseException
    {
        logwriter.writetoLog("function: getLeistungsblock(Student, Veranstaltung)","TRACE");
        String veranstaltungsname = veranstaltung.getName();
        int matrikelnummer = student.getMatrikelnr();
        ArrayList<Leistung> results = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Leistungsblock.* FROM Student INNER JOIN Leistungsblock ON Student.Matrikelnummer = Leistungsblock.Matrikelnummer WHERE Student.Matrikelnummer = '" + matrikelnummer + "' AND Leistungsblock.Veranstaltungsname = '" + veranstaltungsname + "'");
            while (rs.next()){
                Leistung leistung = new Leistung(rs.getString("Leistungsblock_name"),veranstaltung, student);
                leistung.setuBloecke(getUnterblock(student,leistung,veranstaltung));
                results.add(leistung);
            }
            logwriter.writetoLog("successfully loaded:" + resultSize(rs),"TRACE");
        }catch (SQLException ex){
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
        return  results;
    }

    public ArrayList<Unterblock> getUnterblock(Student student, Leistung leistungsblock, Veranstaltung veranstaltung) throws  DatabaseException
    {
        logwriter.writetoLog("function: getUnterblock(Student, Leistung, Veranstaltung)","TRACE");
        String veranstaltungsname = veranstaltung.getName();
        String leistungsblockname = leistungsblock.getLbName();
        int matrikelnummer = student.getMatrikelnr();
        ArrayList<Unterblock> results = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Unterblock.* FROM Leistungsblock INNER JOIN Unterblock ON Unterblock.Matrikelnummer = Leistungsblock.Matrikelnummer AND Unterblock.Leistungsblock_name = Leistungsblock.Leistungsblock_name WHERE Unterblock.Matrikelnummer = '" + matrikelnummer + "' AND Unterblock.Leistungsblock_name = '" + leistungsblockname + "' AND Unterblock.Veranstaltungsname = '" + veranstaltungsname + "'");
            while (rs.next()) {
                Unterblock ub = new Unterblock(rs.getString("Unterblock_name"),leistungsblock);
                ub.setAufgaben(getEinzelleistung(student, leistungsblock, ub, veranstaltung));
                results.add(ub);
            }
            logwriter.writetoLog("successfully loaded:" + resultSize(rs),"TRACE");
        }catch (SQLException ex){
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
        return  results;
    }

    public ArrayList<Aufgabe> getEinzelleistung(Student student, Leistung leistungsblock, Unterblock unterblock, Veranstaltung veranstaltung) throws  DatabaseException
    {
        logwriter.writetoLog("function: getEinzelleistung(Student, Leistung, Unterblock, Veranstaltung)","TRACE");
        String veranstaltungsname = veranstaltung.getName();
        String leistungsblockname = leistungsblock.getLbName();
        int matrikelnummer = student.getMatrikelnr();
        String unterblockname = unterblock.getUbName();
        ArrayList<Aufgabe> results = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Einzelleistung.* FROM Unterblock INNER JOIN Einzelleistung ON Unterblock.Matrikelnummer = Einzelleistung.Matrikelnummer AND Unterblock.Leistungsblock_name = Einzelleistung.Leistungsblock_name AND Unterblock.Unterblock_name = Einzelleistung.Unterblock_name WHERE Einzelleistung.Matrikelnummer = '" + matrikelnummer + "' AND Einzelleistung.Leistungsblock_name = '" + leistungsblockname + "' AND Einzelleistung.Veranstaltungsname = '" + veranstaltungsname + "' AND Einzelleistung.Unterblock_name = '" + unterblockname + "'");
            while (rs.next()){
                Aufgabe a = new Aufgabe(rs.getString("Einzelleistung_name"),rs.getInt("Punkte"),unterblock);
                a.setMaxPunkte(getMaxPunkte(a,veranstaltung));
                results.add(a);
            }
            logwriter.writetoLog("successfully loaded:" + resultSize(rs),"TRACE");
        }catch (SQLException ex){
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
        return  results;
    }

    public int getMaxPunkte(Aufgabe aufgabe, Veranstaltung veranstaltung) throws  DatabaseException
    {
        logwriter.writetoLog("  function: getMaxPunkte(Aufgabe)","TRACE");
        String veranstaltungsname = veranstaltung.getName();
        String leistungsblockname = aufgabe.getUnterblock().getlBlock().getLbName();
        String unterblockname = aufgabe.getUnterblock().getUbName();
        String leistungsname = aufgabe.getElName();
        ArrayList<Aufgabe> results = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MaxPunktzahl.* FROM MaxPunktzahl WHERE Leistungsblock_name = '" + leistungsblockname + "' AND Veranstaltungsname = '" + veranstaltungsname + "' AND Unterblock_name = '" + unterblockname + "' AND  Leistung_name = '" + leistungsname + "'");
            if(resultSize(rs)!=0){
                logwriter.writetoLog("  successful","TRACE");
                return rs.getInt("Punkte");
            }
        }catch (SQLException ex){
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
        throw new DatabaseException("Entry doesn't exist");
    }

    public ArrayList <Leistung> getLeistung(Team team) throws  DatabaseException
    {
        logwriter.writetoLog("function: getLeistung(Team)","TRACE");
        String veranstaltungsname = team.getGruppe().getVeranstaltung().getName();
        int gruppenID = team.getGruppe().getGruppenID();
        int teamID = team.getTeamID();
        ArrayList<Leistung> results = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select Teamleistungsblock.* FROM Team INNER JOIN Teamleistungsblock ON Teamleistungsblock.TeamID = Team.TeamID AND Teamleistungsblock.GruppenID = Team.GruppenID AND Teamleistungsblock.Veranstaltungsname = Team.Veranstaltungsname WHERE Teamleistungsblock.Veranstaltungsname = '" + veranstaltungsname + "' AND Teamleistungsblock.TeamID = '" + teamID + "' AND Teamleistungsblock.GruppenID = '" + gruppenID + "'");
            while (rs.next()){
                Leistung leistung = new Leistung(rs.getString("Leistungsblock_name"));
                leistung.setuBloecke(getUnterblock(team, leistung));
                results.add(leistung);
            }
            logwriter.writetoLog("successfully loaded:" + resultSize(rs),"TRACE");
        }catch (SQLException ex){
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
        return  results;
    }

    public ArrayList<Unterblock> getUnterblock( Team team, Leistung leistungsblock) throws  DatabaseException
    {
        logwriter.writetoLog("function: getLeistung(Team, Leistung)","TRACE");
        String veranstaltungsname = team.getGruppe().getVeranstaltung().getName();
        String teamleistungsblockname = leistungsblock.getLbName();
        int teamID = team.getTeamID();
        int gruppenID = team.getGruppe().getGruppenID();
        ArrayList<Unterblock> results = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select Teamleistungsunterblock.* FROM Teamleistungsunterblock INNER JOIN Teamleistungsblock ON Teamleistungsblock.TeamID = Teamleistungsunterblock.TeamID AND Teamleistungsblock.GruppenID = Teamleistungsunterblock.GruppenID AND Teamleistungsblock.Veranstaltungsname = Teamleistungsunterblock.Veranstaltungsname AND Teamleistungsblock.Teamleistungsblockname = Teamleistungsunterblock.Teamleistungsblockname WHERE Teamleistungsunterblock.Veranstaltungsname = '" + veranstaltungsname + "' AND Teamleistungsunterblock.TeamID = '" + teamID + "' AND Teamleistungsunterblock.GruppenID = '" + gruppenID + "' AND Teamleistungsunterblock.Teamleistungsblockname = '" + teamleistungsblockname + "'");
            while (rs.next()){
                Unterblock ub = new Unterblock(rs.getString("Unterblock_name"),leistungsblock);
                ub.setAufgaben(getTeamleistung(team, leistungsblock, ub));
                results.add(ub);
            }
            logwriter.writetoLog("successfully loaded:" + resultSize(rs),"TRACE");
        }catch (SQLException ex){
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
        return  results;
    }

    public ArrayList<Aufgabe> getTeamleistung(Team team, Leistung leistungsblock, Unterblock unterblock) throws  DatabaseException
    {
        logwriter.writetoLog("function: getTeamleistung(Team, Leistung, Unterblock)", "TRACE");
        String veranstaltungsname = team.getGruppe().getVeranstaltung().getName();
        String teamleistungsblockname = leistungsblock.getLbName();
        int teamID = team.getTeamID();
        int gruppenID = team.getGruppe().getGruppenID();
        String teamunterblockname = unterblock.getUbName();
        ArrayList<Aufgabe> results = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select Teamleistung.* FROM Teamleistungsunterblock INNER JOIN Teamleistung ON Teamleistung.TeamID = Teamleistungsunterblock.TeamID AND Teamleistung.GruppenID = Teamleistungsunterblock.GruppenID AND Teamleistung.Veranstaltungsname = Teamleistungsunterblock.Veranstaltungsname AND Teamleistung.Teamleistungsblockname = Teamleistungsunterblock.Teamleistungsblockname AND Teamleistung.Teamleistungsunterblockname = Teamleistungsunterblock.Teamleistungsunterblockname WHERE Teamleistung.Veranstaltungsname = '" + veranstaltungsname + "' AND Teamleistung.TeamID = '" + teamID + "' AND Teamleistung.GruppenID = '" + gruppenID + "' AND Teamleistung.Teamleistungsblockname = '" + teamleistungsblockname + "' AND Teamleistung.Teamleistungsunterblockname = '" + teamunterblockname + "'");
            while (rs.next()){
                Aufgabe a = new Aufgabe(rs.getString("Teamleistungsname"),rs.getInt("Punkte"),unterblock);
                a.setMaxPunkte(getMaxPunkte(a,team.getGruppe().getVeranstaltung()));
                results.add(a);
            }
            logwriter.writetoLog("successfully loaded:" + resultSize(rs),"TRACE");
        }catch (SQLException ex){
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
        return  results;
    }

    public ArrayList<Veranstaltung> getAllVeranstaltungen()throws DatabaseException{
        logwriter.writetoLog("function: getAllVeranstaltungen()","TRACE");
        ArrayList<Veranstaltung> results = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Veranstaltung");
            while (rs.next()){
                Veranstaltung veranstaltung = new Veranstaltung(rs.getString("Veranstaltungsname"),rs.getString("Fakultaet"),rs.getInt("Teamanzahl_je_Gruppe"),rs.getInt("maximale_Teilnehmeranzahl_je_Team"), rs.getString("Beschreibung"));
                veranstaltung.setDozenten(getDozenten(veranstaltung));
                veranstaltung.setGruppen(this.getGruppen(veranstaltung));
                results.add(veranstaltung);
            }
            logwriter.writetoLog("successfully loaded:" + resultSize(rs),"TRACE");
        }catch (SQLException ex){
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
        return  results;
    }

    // update Methods
    //
    public void updateNutzerPasswort(String email, String passwort) throws DatabaseException {
        logwriter.writetoLog("function: updateNutzerPasswort","TRACE");
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Nutzer SET Passwort = '" + passwort + "' WHERE EMailadresse = '" + email + "'");
            logwriter.writetoLog("successful","TRACE");
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void updateNutzerTitle(String email, String title) throws DatabaseException {
        logwriter.writetoLog("function: updateNutzerTitle","TRACE");
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Nutzer SET Titel = '" + title + "' WHERE EMailadresse = '" + email + "'");
            logwriter.writetoLog("successful","TRACE");
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }
    }

    public void updateNutzerVornamen(String email, String vorname) throws DatabaseException {
        logwriter.writetoLog("function: updateNutzerVornamen","TRACE");
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Nutzer SET Vorname = '" + vorname + "' WHERE EMailadresse = '" + email + "'");
            logwriter.writetoLog("successful","TRACE");
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void updateNutzerNachname(String email, String name) throws DatabaseException {
        logwriter.writetoLog("function: updateNutzerNachname","TRACE");
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Nutzer SET Nachname = '" + name + "' WHERE EMailadresse = '" + email + "'");
            logwriter.writetoLog("successful","TRACE");
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    //TODO kann man nur aufwenidg aendern da schluessel (nur sehr sehr aufwendig moeglich)
//    public Student updateStudentMatrikelnummer(String email, String matrikelnummer) throws DatabaseException {
//        return null;
//    }

    public void updateStudentStudiengang(String email, String studiengang) throws DatabaseException {
        logwriter.writetoLog("function: updateStudentStudiengang","TRACE");
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Student SET Studiengang = '" + studiengang + "' WHERE EMailadresse = '" + email + "'");
            logwriter.writetoLog("successful","TRACE");
        } catch (SQLException ex) {
            throw new DatabaseException("Connection Failed");
        }
    }

    public void updateDozentFakultaet(String email, String fakultaet) throws DatabaseException {
        logwriter.writetoLog("function: updateDozentFakultaet","TRACE");
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Dozent SET Fakultaet = '" + fakultaet + "' WHERE EMailadresse = '" + email + "'");
            logwriter.writetoLog("successful","TRACE");
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

      //TODO kann man nur aufwenidg aendern da schluessel (nur sehr sehr aufwendig moeglich)
//    public Gruppe updateGruppeVeranstaltungsname(int gruppenID, String veranstaltungsname) throws DatabaseException {
//        return null;
//    }

    public void updateGruppeEinschreibefrist(int gruppenid, String veranstaltungsname, Date einschreibefrist) throws DatabaseException {
        logwriter.writetoLog("function: updateGruppeEinschreibefrist","TRACE");
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Gruppe SET  Einschreibungsfrist = '" + einschreibefrist + "' WHERE GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
            logwriter.writetoLog("successful","TRACE");
        }catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void updateGruppeUhrzeit(int gruppenid, String veranstaltungsname, Time uhrzeit) throws DatabaseException {
        logwriter.writetoLog("function: updateGruppeUhrzeit","TRACE");
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Gruppe SET  Uhrzeit = '" + uhrzeit + "' WHERE GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
            logwriter.writetoLog("successful","TRACE");
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void updateGruppeWochentag(int gruppenid, String veranstaltungsname, String wochentag) throws DatabaseException {
        logwriter.writetoLog("function: updateGruppeWochentag","TRACE");
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Gruppe SET  Wochentag = '" + wochentag + "' WHERE GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
            logwriter.writetoLog("successful","TRACE");
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void updateGruppeWochenrhythmus(int gruppenid, String veranstaltungsname, String wochenrhythmus) throws DatabaseException {
        logwriter.writetoLog("function: updateGruppeWochenrhythmus","TRACE");
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Gruppe SET  Wochenrhytmus = '" + wochenrhythmus + "' WHERE GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
            logwriter.writetoLog("successful","TRACE");
        } catch (SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    //TODO kann man nur aufwenidg aendern da schluessel (nur sehr sehr aufwendig moeglich)
//    public Leistung updateLName(int matrikelnummer, String l_name) throws DatabaseException {
//        return null;
//    }

    public void updateEinzelleistungName(int matrikelnummer, String veranstaltungsname, String unterblockname, String oldname, String leistungsblockname, String newname) throws DatabaseException {
        logwriter.writetoLog("function: updateEinzelleistungName","TRACE");
        try
        {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Einzelleistung SET Einzelleistung_name = '" + newname + "' WHERE Matrikelnummer = '" + matrikelnummer + "' AND Leistungsblock_name = '" + leistungsblockname + "' AND Unterblock_name = '" + unterblockname + "' AND Einzelleistung_name = '" + oldname + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
            logwriter.writetoLog("successful","TRACE");
        }
        catch(SQLException ex)
        {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void updateEinzelleistungPunkte(int matrikelnummer, String veranstaltungsname, String unterblockname, String einzelleistungsname, String leistungsblockname, int punkte) throws DatabaseException {
        logwriter.writetoLog("function: updateEinzelleistungPunkte","TRACE");
        try
        {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Einzelleistung SET Punkte = '" + punkte + "' WHERE Matrikelnummer = '" + matrikelnummer + "' AND Leistungsblock_name = '" + leistungsblockname + "' AND Unterblock_name = '" + unterblockname + "' AND Einzelleistung_name = '" + einzelleistungsname + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
            logwriter.writetoLog("successful","TRACE");
        }
        catch(SQLException ex)
        {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void updateStudienganganteil(String studiengang, int anteil, int teamid, int gruppenid, String veranstaltungsname) throws DatabaseException {
        logwriter.writetoLog("function: updateStudienganganteil","TRACE");
        try
        {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Studienganganteil SET Anteil = '" + anteil + "' WHERE Studiengang = '" + studiengang + "' AND TeamID = '" + teamid + "' AND GruppenID = '" + gruppenid + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
            logwriter.writetoLog("successful","TRACE");
        }
        catch(SQLException ex)
        {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    //TODO kann man nur aufwenidg aendern da schluessel (nur sehr sehr aufwendig moeglich)
//
//    public Studienganganteil updateStudienganganteilGruppenID(int anteil, int gruppenID) throws DatabaseException {
//        return null;
//    }

//    public Studienganganteil updateStudienganganteilTeamID(int anteil, int teamID) throws DatabaseException {
//        return null;
//    }

//    public Studienganganteil updateStudienganganteilVName(int anteil, String vName) throws DatabaseException {
//        return null;
//    }

//    public Team updateTeamGruppenID(int teamID, int gruppenID) throws DatabaseException {
//        return null;
//    }

    public void updateTeamThema(int teamID, String thema, int gruppenID, String veranstaltungsname) throws DatabaseException {
        logwriter.writetoLog("function: updateTeamThema","TRACE");
        try
        {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Team SET Thema = '" + thema + "' WHERE TeamID = '" + teamID + "' AND GruppenID = '" + gruppenID + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
            logwriter.writetoLog("successful","TRACE");
        }
        catch(SQLException ex)
        {
            throw new DatabaseException("Connection Failed");
        }
    }

    public void updateTeamleistungPunkte(int teamID, int punkte, int gruppenID, String veranstaltungsname, String teamleistungsblockname, String teamleistungsunterblockname, String teamleistungsname) throws DatabaseException {
        logwriter.writetoLog("function: updateTeamleistungPunkte","TRACE");
        try
        {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Teamleistung SET Punkte = '" + punkte + "' WHERE TeamID = '" + teamID + "' AND Teamleistungsblockname = '" + teamleistungsblockname + "' AND Teamleistungsunterblockname = '" + teamleistungsunterblockname + "' AND Teamleistungsname = '" + teamleistungsname + "' AND GruppenID = '" + gruppenID + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
            logwriter.writetoLog("successful","TRACE");
        }
        catch(SQLException ex)
        {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void updateTeamleistungName(int teamID, String oldname, String newname, int gruppenID, String veranstaltungsname, String teamleistungsblockname, String teamleistungsunterblockname) throws DatabaseException {
        logwriter.writetoLog("function: updateTeamleistungName","TRACE");
        try
        {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Teamleistung SET Teamleistungsname = '" + newname + "' WHERE TeamID = '" + teamID + "' AND Teamleistungsblockname = '" + teamleistungsblockname + "' AND Teamleistungsunterblockname = '" + teamleistungsunterblockname + "' AND Teamleistungsname = '" + oldname + "' AND GruppenID = '" + gruppenID + "' AND Veranstaltungsname = '" + veranstaltungsname + "'");
            logwriter.writetoLog("successful","TRACE");
        }
        catch(SQLException ex)
        {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void updateVeranstaltungTeamanzahl_je_Gruppe(String veranstaltungsname, int teamanzahl) throws DatabaseException {
        logwriter.writetoLog("function: updateVeranstaltungTeamanzahl_je_Gruppe","TRACE");
        try
        {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Veranstaltung SET  Teamanzahl_je_Gruppe = '" + teamanzahl + "' WHERE Veranstaltungsname = '" +veranstaltungsname+"'");
            logwriter.writetoLog("successful","TRACE");
        }
        catch(SQLException ex)
        {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void updateVeranstaltungBeschreibung(String veranstaltungsname, String beschreibung) throws DatabaseException {
        logwriter.writetoLog("function: updateVeranstaltungBeschreibung","TRACE");
        try
        {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Veranstaltung SET Beschreibung = '" + beschreibung + "' WHERE Veranstaltungsname = '" +veranstaltungsname+"'");
            logwriter.writetoLog("successful","TRACE");
        }
        catch(SQLException ex)
        {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void updateVeranstaltungFakultaet(String veranstaltungsname, String fakultaet) throws DatabaseException
    {
        logwriter.writetoLog("function: updateVeranstaltungFakultaet","TRACE");
        try
        {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Veranstaltung SET Fakultaet = '" + fakultaet + "' WHERE Veranstaltungsname = '" +veranstaltungsname+"'");
            logwriter.writetoLog("successful","TRACE");
        }
        catch(SQLException ex)
        {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public void updateVeranstaltungMaximale_Teilnehmeranzahl_je_Team(String veranstaltungsname, int maximale_Teilnehmeranzahl_je_Team) throws DatabaseException {
        logwriter.writetoLog("function: updateVeranstaltungMaximale_Teilnehmeranzahl_je_Team","TRACE");
        try
        {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Veranstaltung SET maximale_Teilnehmeranzahl_je_Team = '" + maximale_Teilnehmeranzahl_je_Team + "' WHERE Veranstaltungsname = '" +veranstaltungsname+"'");
            logwriter.writetoLog("successful","TRACE");
        }
        catch(SQLException ex)
        {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    //Supportmethods
    public  void deleteAll()throws DatabaseException{
        logwriter.writetoLog("function: deleteAll()","TRACE");
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Einzelleistung");
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Unterblock");
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Leistungsblock");
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Teamleistung");
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Teamleistungsunterblock");
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Teamleistungsblock");
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Studienganganteil");
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Gehoert_zu");
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Team");
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Gruppe");
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Student");
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Leitet");
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Dozent");
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Veranstaltung");
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Nutzer");
            logwriter.writetoLog("successful","TRACE");
        } catch(SQLException ex) {
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
        }
    }

    public static DBrequest getIntstance() {
        return instance;
    }

    public void close()throws DatabaseException{
        logwriter.writetoLog("function: close()","TRACE");
        try {
            con.close();
        }catch(SQLException ex){
            logwriter.writetoLog("Connection Failed","ERROR");
            throw new DatabaseException("Connection Failed");
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
            logwriter.writetoLog("Something went wrong","ERROR");
        }
        return size;
    }

    // Coole Functionen (Functionsparamteter nur Klassen Modelle keine primitive datentypen!!!! afiujdsf)
    //
    public void updateStudent(Student student)throws DatabaseException
    {
        updateStudentStudiengang(student.getEmail(),student.getStudiengang());
    }

    public void updateDozent(Dozent dozent) throws DatabaseException
    {
        updateDozentFakultaet(dozent.getEmail(),dozent.getFakultaet());
    }

    public void updateVeranstaltung(Veranstaltung veranstaltung) throws DatabaseException
    {
        updateVeranstaltungBeschreibung(veranstaltung.getName(),veranstaltung.getBeschreibung());
        updateVeranstaltungMaximale_Teilnehmeranzahl_je_Team(veranstaltung.getName(),veranstaltung.getMaxTeilnehmer());
        updateVeranstaltungTeamanzahl_je_Gruppe(veranstaltung.getName(),veranstaltung.getTeamanzahl());
        updateVeranstaltungFakultaet(veranstaltung.getName(), veranstaltung.getFakultaet());
    }

    public void updateGruppe(Gruppe gruppe)throws DatabaseException
    {
        updateGruppeEinschreibefrist(gruppe.getGruppenID(),gruppe.getVeranstaltung().getName(),gruppe.getFrist());
        updateGruppeUhrzeit(gruppe.getGruppenID(),gruppe.getVeranstaltung().getName(),gruppe.getZeit());
        updateGruppeWochenrhythmus(gruppe.getGruppenID(),gruppe.getVeranstaltung().getName(),gruppe.getRhythmus());
        updateGruppeWochentag(gruppe.getGruppenID(),gruppe.getVeranstaltung().getName(),gruppe.getWochentag());
    }

    public void updateTeam(Team team)throws DatabaseException
    {
        updateTeamThema(team.getTeamID(),team.getThema(),team.getGruppe().getGruppenID(),team.getGruppe().getVeranstaltung().getName());
    }

    public void updateTeamleistung(Aufgabe teamleistung, Team team)throws DatabaseException
    {
        updateTeamleistungName(team.getTeamID(),"?",teamleistung.getElName(),team.getGruppe().getGruppenID(),team.getGruppe().getVeranstaltung().getName(),teamleistung.getUnterblock().getlBlock().getLbName(),teamleistung.getUnterblock().getUbName());
    }

    public void updateStudienganganteil(Studienganganteil studienganganteil)throws DatabaseException
    {
        updateStudienganganteil(studienganganteil.getStudiengang(),studienganganteil.getAnteil(),studienganganteil.getTeam().getTeamID(),studienganganteil.getTeam().getGruppe().getGruppenID(),studienganganteil.getTeam().getGruppe().getVeranstaltung().getName());
    }

    public void updateEinzelLeistung(Aufgabe einzelLeistung,Veranstaltung veranstaltung)throws DatabaseException
    {
        updateEinzelleistungPunkte(einzelLeistung.getUnterblock().getlBlock().getStudent().getMatrikelnr(),veranstaltung.getName(),einzelLeistung.getUnterblock().getUbName(),einzelLeistung.getElName(),einzelLeistung.getUnterblock().getlBlock().getLbName(),einzelLeistung.getElPunkte());
    }

}