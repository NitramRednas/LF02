package schritt4;

public class Spiel {

    private Mannschaft heim;
    private Mannschaft gast;
    private Ergebniss ergebniss;
    private StringBuilder spielergebniss;

    public Spiel(Mannschaft heim, Mannschaft gast, Ergebniss ergebniss) {
        this.gast = gast;
        this.heim = heim;
        this.ergebniss = ergebniss;
        spielergebniss = new StringBuilder();
    }

    public Mannschaft getHeim() {
        return heim;
    }

    public Mannschaft getGast() {
        return gast;
    }

    public Ergebniss getErgebnis() {
        return ergebniss;
    }

    public StringBuilder getSpielbericht() {
        return spielergebniss;
    }

    @Override
    public String toString() {
        return "Spiel{" +
                "heim=" + heim +
                ", gast=" + gast +
                ", ergebniss=" + ergebniss +
                ", spielergebniss=" + spielergebniss +
                '}';
    }
}

