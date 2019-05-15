package Database;

import java.sql.Connection;

public class DBrequest {
    private Connection conn;

    DBrequest(){
        conn = DBconn.buildConnection();
    }

    public void getName(int matrikelnummer){

    }
}
