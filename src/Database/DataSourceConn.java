package Database;

import java.sql.Connection;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.SQLException;
import javax.sql.DataSource;

public  class DataSourceConn {
    final static String server = "swtistdoof.ignorelist.com";
    final static int port = 3306;
    final static String databaseName = "swt_datenbank?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    final static String username = "swt";
    final static String password = "123456swtistdoof";


    public static Connection buildConnection(){
        try {
            MysqlDataSource dataSource = new MysqlDataSource();
            if (dataSource instanceof DataSource)
                System.out.println("MysqlDataSource implements the javax.sql.DataSource interface");

            System.out.println("datasource created");
            dataSource.setServerName(server);
            dataSource.setPort(port);
            dataSource.setDatabaseName(databaseName);
            dataSource.setUser(username);
            dataSource.setPassword(password);
            Connection con = dataSource.getConnection();
            return con;
        }catch (SQLException ex){
            ex.printStackTrace();
            System.out.println(ex);
            return  null;
        }
    }
}
