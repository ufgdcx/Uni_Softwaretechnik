package Database;

package dbcon;
// import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DatabaseCon {
    public static void main(String[] args) //throws SQLException
    {
        System.out.println("# Starting MySQL connection");

        final String hostname = "swtistdoof.ignorelist.com";
        final String port = "3306";
        final String dbname = "swt_test";
        final String user = "swt";
        final String password = "123456swtistdoof";

        try
        {
            // The newInstance() call is a work around for some
            // broken Java implementations
            //  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            System.out.println("# Load driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (Exception ex)
        {
            System.err.println("Unable to load driver.");
            ex.printStackTrace();
        }

        try
        {
            Connection conn = null;

            // Creating url
            String url = "jdbc:mysql://" + hostname + ":" + port + "/" + dbname + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//            conn = DriverManager.getConnection(
//                    "jdbc:mysql://"+"swtistdoof.ignorelist.com"+"/"+"swt_test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
//                    "swt",
//                    "123456swtistdoof");
            //conn = DriverManager.getConnection("jdbc:mysql://localhost/swt?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            conn = DriverManager.getConnection(url, user, password);

            /*
            Die Objektmethode executeQuery() greift lesend auf die Datenbank zu und liefert eine Referenz auf ein ResultSet zurück.
            Ein ResultSet ermöglicht den Zugriff auf eine (dynamische) Tabelle, die durch eine SELECT-Anweisung generiert wurde.
            Ein sog. Cursor zeigt auf den aktuellen Datensatz (Zeile).
            Mit der Methode next() wird der Cursor auf den folgenden Datensatz verschoben.
            Der boolean-Rückgabewert wird false, wenn kein weiterer Datensatz existiert.
            Auf die einzelnen Attribute (Spalten) kann in beliebiger Reihenfolge zugegriffen werden.
            Dazu verwenden wir die getXXX()-Methoden (siehe API-Referenz).
            Mit der Anweisung stmt.close() wird sowohl das Statement als auch alle erzeugten ResultSets geschlossen.
             */

            // ################## Insert ##########################
            System.out.println("# begin statement");
            Statement stmt1 = conn.createStatement();

            System.out.println("# Insert");
            String sqlCommand1 =
                    "INSERT INTO student " +
                            "VALUES('4', 'blub', '45');";
            stmt1.executeUpdate(sqlCommand1);

            System.out.println("# close statement");
            stmt1.close();

            System.out.println("# begin statement");
            Statement stmt = conn.createStatement();


            // ################# Select ###########################
            System.out.println("# begin request");
            String sqlCommand =
//                  "SELECT * FROM test_table"; // "SELECT * FROM test_table";
                    "SELECT * FROM student";

            ResultSet rs = stmt.executeQuery(sqlCommand);

            System.out.println("# show results");
            while (rs.next())
            {
                System.out.println(rs.getInt(1)+" "+ rs.getString("name") +" "+ rs.getInt(3) );
            }

            System.out.println("# close statement");
            stmt.close();


        }
        catch (SQLException ex)
        {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }





//        // Diese Eintraege werden zum
//        // Verbindungsaufbau benoetigt.
//        final String hostname = "localhost";
//        final String port = "3306";
//        final String dbname = "swt";
//        final String user = "swt";
//        final String password = "123";
//
//        Connection conn = null;
//
//        try {
//            System.out.println("* Treiber laden");
//            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//        }
//        catch (Exception e) {
//            System.err.println("Unable to load driver.");
//            e.printStackTrace();
//        }
//
//        try {
//            System.out.println("* Verbindung aufbauen");
//            String url = "jdbc:mysql://"+hostname+":"+port+"/"+dbname;
//            conn = DriverManager.getConnection(url, user, password);
//
//            System.out.println("* Datenbank-Verbindung beenden");
//            conn.close();
//        }
//        catch (SQLException sqle) {
//            System.out.println("SQLException: " + sqle.getMessage());
//            System.out.println("SQLState: " + sqle.getSQLState());
//            System.out.println("VendorError: " + sqle.getErrorCode());
//            sqle.printStackTrace();
//        }


    }
}

