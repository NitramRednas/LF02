public class Vertragspartner {

    private String vorname;
    private String nachname;
    private String ausweisNr;
    Adresse adresse;

    public Vertragspartner(String vorname, String nachname){
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setAusweisNr(String ausweisNr) {
        this.ausweisNr = ausweisNr;
    }

    public String getAusweisNr() {
        return ausweisNr;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    @Override
    public String toString() {
        return "\t" + vorname + "\t" + nachname + "\n";
    }
}
