package schritt1;

import schritt3.Person;

public class Spieler extends Person {

    private int staerke;
    private int torschuss;
    private int motivation;
    private int tore;

    public Spieler(String name, int alter, int staerke, int torschuss, int motivation, int tore) {
        super(name, alter);
        this.staerke = staerke;
        this.torschuss = torschuss;
        this.tore = tore;
    }

    public void setStaerke(int staerke) {
        this.staerke = staerke;
    }

    public int getStaerke() {
        return staerke;
    }

    public void setMotivation(int motivation) {
        this.motivation = motivation;
    }

    public int getMotivation() {
        return motivation;
    }

    public void setTorschuss(int torschuss) {
        this.torschuss = torschuss;
    }

    public int getTorschuss() {
        return torschuss;
    }

    public void setTore(int tore) {
        this.tore = tore;
    }

    public int getTore() {
        return tore;
    }

    @Override
    public String toString() {
        return "Spieler"
         + "\n\t" + "Stärke: " + staerke
         + "\n\t" + "Torschuss: " + torschuss
         + "\n\t" + "Tore: " + tore;

    }
}
