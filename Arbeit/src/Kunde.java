public class Kunde extends Person {

    private Mitarbeiter betreuer;

    public Kunde(String vorname, String nachname){
       super(vorname, nachname);
    }

    public Mitarbeiter getBetreuer() {
        return betreuer;
    }

    public void setBetreuer(Mitarbeiter betreuer) {
        this.betreuer = betreuer;
    }

    @Override
    public String toString() {
        return "Kunde\n" +
                "Vorname:\t" + getVorname() +
                "\nNachname:\t" + getNachname() +
                "\nAdresse:\t" + getAdresse() +
                "\nBeteuer:\t" + getBetreuer();
    }
}
