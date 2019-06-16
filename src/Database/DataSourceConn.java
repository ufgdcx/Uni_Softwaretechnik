package Database;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Baut die Verbindung zur Datenbank auf.
 * @author Christoph
 * @author Sven
 */

public  class DataSourceConn
{
    // Member Variables
    //
    // Database Connection Information
    final static String server = "swt.ignorelist.com";
    final static int port = 3306;
    final static String databaseName = "swt_datenbank?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    final static String username = "swt";
    final static String password = "123456swtistdoof";


    // Create and return a database connection
    //
    public static Connection buildConnection(){
        try {
            MysqlDataSource dataSource = new MysqlDataSource();

            System.out.println("datasource created");
            dataSource.setServerName(server);
            dataSource.setPort(port);
            dataSource.setDatabaseName(databaseName);
            dataSource.setUser(username);
            dataSource.setPassword(password);
            return dataSource.getConnection();
        }catch (SQLException ex){
            ex.printStackTrace();
            return  null;
        }
    }
}
