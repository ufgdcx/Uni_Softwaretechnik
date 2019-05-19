package Klassen;

public class Nutzer
{
    // Member variables
    private String email;
    private String passwort;
    private String titel;
    private String vorname;
    private String name;

    // Constructor
    public Nutzer(String email,String passwort, String titel, String vorname, String name)
    {
        this.email = email;
        this.passwort = passwort;
        this.titel = titel;
        this.vorname = vorname;
        this.name = name;
    }

    // set Methods
    public void setEmail(String email) { this.email = email; }
    public void setPasswort(String passwort) { this.passwort = passwort; }
    public void setTitel(String titel) { this.titel = titel; }
    public void setVorname(String vorname) { this.vorname = vorname; }
    public void setName(String name) { this.name = name; }

    // get Methods
    public String getEmail() { return email; }
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
