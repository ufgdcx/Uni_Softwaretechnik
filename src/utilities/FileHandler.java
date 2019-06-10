package utilities;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import java.io.*;
import java.util.ArrayList;

/*
// How to use the FileHandler Class:
// Example:
// reading yaml file:
FileHandler<Student> fileHandler = new FileHandler<>();
ArrayList<Student> studenten1 = fileHandler.readFile("Testdata/studenten.yml", Student.class);
// writing into yaml file:
FileHandler<Student> studenten2  = new FileHandler<>();
String filename = ("src/utilities/My_Studenten.yml");
b.writeFile(filename, studenten1); // studenten1 is a ArrayList!
 */

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
        File file = new File(filename);
        ArrayList<T> list = new ArrayList<>();
        try
        {
            inputStream = new FileInputStream(file.getAbsolutePath());
            for(Object object : yaml.loadAll(inputStream))
            {
                list.add((T)object);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        finally
        {
            if(inputStream != null)
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
            else
            {
                System.out.println("\nNo such file found\n");
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
