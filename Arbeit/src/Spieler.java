public class Spieler {

    private String name;
    private int alter;
    private int staerke;
    private int torschuss;
    private int motivation;
    private int tore;

    public Spieler(String name, int alter, int staerke, int torschuss, int motivation, int tore) {
        this.name = name;
        this.alter = alter;
        this.staerke = staerke;
        this.torschuss = torschuss;
        this.tore = tore;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public int getAlter() {
        return alter;
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
}
