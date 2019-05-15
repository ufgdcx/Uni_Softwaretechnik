package Klassen;

public class Nutzer {

    private String email = new String();
    private String passwort = new String();
    private String titel = new String();
    private String vorname = new String();
    private String name = new String();
   
   //getter für Email und setter alles
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
