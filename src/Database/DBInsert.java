package Database;

import Klassen.Nutzer;

public class DBInsert
{
    public static void main(String[] args) {
        DBrequest b = new DBrequest();
        Nutzer n = b.getNutzer("Max@Muster.Mann","1234");
        if(n!=null){
            System.out.println(n.getVorname());
        }
        b.close();
    }
}
