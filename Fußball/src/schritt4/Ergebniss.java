package schritt4;

public class Ergebniss {

    private int toreHeim;
    private int toreGast;



    public void addToreHeim() {
        toreHeim++;
    }

    public void addToreGast() {
        toreGast++;
    }


    public int getToreHeim() {
        return toreHeim;
    }

    public int getToreGast() {
        return toreGast;
    }

    @Override
    public String toString() {
        return "Ergebniss{" +
                "toreHeim=" + toreHeim +
                ", toreGast=" + toreGast +
                '}';
    }
}
