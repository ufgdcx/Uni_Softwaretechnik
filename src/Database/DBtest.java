package Database;

import Klassen.Nutzer;

public class DBtest
{
    public static void main(String[] args) {
        DBrequest b = new DBrequest();
        try {
            Nutzer n = b.getNutzer("Max@Muster.Mann", "1234");
            if (n != null) {
                System.out.println(n.getVorname());
                System.out.println(n.getName());
                System.out.println(n.getEmail());
                System.out.println(n.getPasswort());
                System.out.println(n.getTitel());
            }
            b.close();
        }catch (DatabaseExeption dbex){
            System.out.println(dbex.getErrorMsg());
        }
    }
}
