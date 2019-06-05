package Klassen;

/**
 * Klasse für die Rolle des Nutzers (Oberklasse von Student und Dozent).
 * @author Sebastian
 */
public class Nutzer
{
    // Member variables
    private String email;
    private String passwort;
    private String titel;
    private String vorname;
    private String nachname;

    // Constructor
    public Nutzer(String email,String passwort, String titel, String vorname, String nachname)
    {
        this.email = email;
        this.passwort = passwort;
        this.titel = titel;
        this.vorname = vorname;
        this.nachname = nachname;
    }

    // set Methods
    public void setEmail(String email) { this.email = email; }
    public void setPasswort(String passwort) { this.passwort = passwort; }
    public void setTitel(String titel) { this.titel = titel; }
    public void setVorname(String vorname) { this.vorname = vorname; }
    public void setNachname(String name) { this.nachname = nachname; }

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
    public String getNachname() {
      return nachname;
   }
}
