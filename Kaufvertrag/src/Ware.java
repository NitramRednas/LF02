import java.util.ArrayList;

public class Ware {

    private String bezeichnung;
    private String beschreibung;
    private double preis;
    private ArrayList<String> besonderheiten;
    private ArrayList<String> maengel;

    public Ware(String bezeichnung, double preis) {
        this.bezeichnung = bezeichnung;
        this.preis = preis;
        besonderheiten = new ArrayList<String>();
        maengel = new ArrayList<String>();
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public ArrayList<String> getBesonderheitenListe() {
        return besonderheiten;
    }

    public void setBesonderheitenListe(ArrayList<String> besonderheiten) {
        this.besonderheiten = besonderheiten;
    }

    public ArrayList<String> getMaengelListe() {
        return maengel;
    }

    public void setMaengelListe(ArrayList<String> maengel) {
        this.maengel = maengel;
    }

    @Override
    public String toString() {
        return "Ware\n" +
                "Bezeichnung:\t" + bezeichnung + "\n" +
                "Beschreibung:\t" + beschreibung + "\n" +
                "Preis:\t\t" + preis + "\n\n" +
                "Besonderheiten\n" + besonderheiten + "\n\n" +
                "Mängel\n" + maengel+"\n\n";
    }
}
