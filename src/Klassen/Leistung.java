package Klassen;

public class Leistung 
{
    // member variables
    private String aufgabe;
    private Float punkte;

    // constructor
    public Leistung(String aufgabe, Float punkte)
    {
        this.aufgabe = aufgabe;
        this.punkte = punkte;
    }

    // get methods
    public String getAufgabe()   {     return aufgabe;   }
    public Float getPunkte()   {     return punkte;   }

  // set methods
    public void setAufgabe(String aufgabe)   {     this.aufgabe = aufgabe;   }
    public void setPunkte(Float punkte)   {     this.punkte = punkte;   }

}
