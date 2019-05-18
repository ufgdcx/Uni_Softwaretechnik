package Database;

import Klassen.Dozent;
import Klassen.Nutzer;
import Klassen.Student;

public class DBtest
{
    public static void main(String[] args) {
        DBrequest b = new DBrequest();
        b.createDozent(new Dozent("Patrick@Star.org","Majonaise","Seestern","Patrick","Star","Meeresbiologie"));
        try {
            Nutzer n = b.getNutzer("Max@Muster.Mann", "1234");
            if (n != null) {
                System.out.println(n.getVorname());
                System.out.println(n.getName());
                System.out.println(n.getEmail());
                System.out.println(n.getPasswort());
            }
            b.close();
                System.out.println(n.getTitel());
        }catch (DatabaseExeption dbex){
            System.out.println(dbex.getErrorMsg());
        }
    }
}
