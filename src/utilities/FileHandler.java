package utilities;

import Klassen.*;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.io.StringWriter;
import java.io.FileWriter;
import java.util.concurrent.ExecutionException;

// Class to handle read
//
public class FileHandler <T>
{
    // Loading data from a Yaml file
    //
    public ArrayList<T> readFile(String filename, Class c)
    {
        Yaml yaml = new Yaml(new Constructor(c));
        InputStream inputStream = null;
        ArrayList<T> list = new ArrayList<>();
        try
        {
            inputStream = this.getClass()
                              .getClassLoader()
                              .getResourceAsStream(filename);
            int count = 0;
            for(Object object : yaml.loadAll(inputStream))
            {
                list.add((T)object);
                count++;
            }
            System.out.printf("Count: %d%n", count);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        finally
        {
            try
            {
                inputStream.close();
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
        return list;
    }

    // Write data into a Yaml file
    //
    public void writeFile(String filename, ArrayList list)
    {
        Yaml yaml = new Yaml();
        StringWriter writer = new StringWriter();
        FileWriter fileWriter = null;
        try
        {
            yaml.dumpAll(list.iterator(),writer);
            fileWriter = new FileWriter(filename);
            fileWriter.write(writer.toString());
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        finally
        {
            try
            {
                fileWriter.close();
            } catch (Exception e)
            {
                System.out.println(e);
            }
        }
    }
}
