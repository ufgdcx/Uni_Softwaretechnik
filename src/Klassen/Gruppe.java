package Klassen;

public class Gruppe {

    Integer gruppenID;
    String tag = new String();
    String zeit = new String();
    String einschreibungsfrist = new String();

    //getter und setter für Tag
    public String getTag() {

        return tag;
    }

    public void setTag(String tag) {

        this.tag = tag;
    }

    //getter und setter für Zeit
    public String getZeit() {

        return zeit;
    }

    public void setZeit(String zeit) {

        this.zeit = zeit;
    }

    //getter und setter für Einschreibungsfrist
    public String getEinschreibungsfrist() {

        return einschreibungsfrist;
    }

    public void setEinschreibungsfrist(String einschreibungsfrist) {

        this.einschreibungsfrist = einschreibungsfrist;
    }
}
