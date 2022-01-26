package schritt2;

import schritt1.Spieler;

public class Torwart extends Spieler {

    public Torwart(String name, int alter, int staerke, int motivation, int reaktion) {

        super(name, alter, staerke, 0, motivation, 0);
        this.reaktion = reaktion;
    }

    private int reaktion;

    public int getReaktion() {
        return reaktion;
    }

    public void setReaktion(int reaktion) {
        this.reaktion = reaktion;
    }

    @Override
    public String toString() {
        return "Torwart" +
                "\n\tReaktion: " + "\t" + reaktion;

    }
}