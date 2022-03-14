public class Mitarbeiter extends Person {

    Mitarbeiter(String vorname, String nachname){
        super(vorname,nachname);
    }

    @Override
    public java.lang.String toString() {
        return "Mitarbeiter\n" +
                "Vorname:\t" + getVorname() +
                "\nNachname:\t" + getNachname();

    }
}
