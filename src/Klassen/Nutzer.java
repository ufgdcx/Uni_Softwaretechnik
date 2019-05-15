package Klassen;

public class Nutzer {

   String email = new String();
   protected String passwort = new String();
   String titel = new String();
   String vorname = new String();
   String name = new String();
   
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
