public class DBconn
{
    public void test_connect()
    {
        // DB connection information
        final String hostname = "localhost";
        final String port = "3306";
        final String dbname = "test";
        final String user = "swt";
        final String password = "123456swtistdoof";

        Connection conn = null;

        // Load Driver
        try
        {
            System.out.println("load driver");
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        }
        catch (Exception e)
        {
            System.err.println("Unable to load driver.");
            e.printStackTrace();
        }

        // start connection
        // insert something to the DB
        // read something from the DB
        // close connection
        try
        {
            System.out.println("Start Connection");
            String url = "jdbc:mysql://"+hostname+":"+port+"/"+dbname;
            conn = DriverManager.getConnection(url, user, password);

            // ===================================
            // Insert something into the DB ======
            // ===================================
            System.out.println("begin Statement beginnen");
            Statement stmt = conn.createStatement();

            System.out.println("insert");
            String sqlCommand =
                    "INSERT INTO student " +
                            "VALUES('2', 'Bob',666);";
            stmt.executeUpdate(sqlCommand);

            System.out.println(" End Statement");
            stmt.close();


            // ==================================
            // Select something from the DB  ====
            // ==================================
            System.out.println("Beginn Statement");
            Statement st = conn.createStatement();

            System.out.println("beginn query");
            Shorttring sqlCommand =
                    "SELECT * FROM student";
            // get result
            ResultSet rs = st.executeQuery(sqlCommand);

            System.out.println("* Ergebnisse anzeigen");
            while (rs.next()) {
                String name = rs.getString(1);
                System.out.println(name);
            }

            System.out.println("end statement");
            st.close();
            System.out.println("end db connection");
            conn.close();
        }
        catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            System.out.println("SQLState: " + sqle.getSQLState());
            System.out.println("VendorError: " + sqle.getErrorCode());
            sqle.printStackTrace();
        }

    }
}