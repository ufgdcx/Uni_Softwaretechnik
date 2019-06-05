package Database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogWriter extends BufferedWriter {

    private final static LogWriter instance;
    private final SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");

    static {
        LogWriter tmp = null;
        new File("Logdata").mkdirs();
        try{
            String fileName = "";
            if(System.getProperty("os.name").startsWith("Windows")){
                fileName = "Logdata\\logdata.txt";
            }
            else {
                fileName = "Logdata.txt";
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
    public void writetoLog(String text, String type) {
        try {
            Date date = new Date(System.currentTimeMillis());
            String msg = "[" + type + "] " + formatter.format(date) + " - " + text+ "\n";
            write(msg);
            flush();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
