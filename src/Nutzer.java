public class Nutzer {
   String email = new String();
   protected String passwort = new String();
   String titel = new String();
   String vorname = new String();
   String nachname = new String();

   //getter und setter für Email
   public String getEmail() {
       return email;
   }

   public void setEmail(String email) {
       this.email = email;
   }
}
