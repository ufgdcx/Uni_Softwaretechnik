package Klassen;

public class Nutzer {

    private String email;
    private String passwort;
    private String titel;
    private String vorname;
    private String name;

    public Nutzer(String email,String passwort, String titel, String vorname, String name){
        this.email = email;
        this.passwort = passwort;
        this.titel = titel;
        this.vorname = vorname;
        this.name = name;
    }

   //setter für Email und getter alles
   public String getEmail() {

      return email;
   }

   public void setEmail(String email) {

       this.email = email;
   }

   public String getPasswort() {
      return passwort;
   }

   public String getTitel() {
      return titel;
   }

   public String getVorname() {
      return vorname;
   }

   public String getName() {
      return name;
   }
}
