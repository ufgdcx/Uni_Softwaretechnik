package Database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogWriter extends BufferedWriter {

    private final static LogWriter instance;
    static {
        LogWriter tmp = null;
        new File("Logdata").mkdirs();
        try{
            String fileName = "";
            if(System.getProperty("os.name").startsWith("Windows")){
                fileName = "Logdata\\logdata.txt";
            }
            else {
                //TODO
            }
            tmp = new LogWriter(new FileWriter(fileName));
        }catch (IOException ioe){
            System.out.println("path doesn't exist");
        }
        instance = tmp;
    }

    private LogWriter(FileWriter writer) {
        super(writer);
    }

    public static LogWriter getIntstance() {
        return instance;
    }

}
