package Database;

public class DBInsert
{
    public static void main(String[] args) {
        DBrequest b = new DBrequest();
        b.getNutzer("f","1234");
        b.close();
    }
}
