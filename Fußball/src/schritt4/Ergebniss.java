package schritt4;

public class Ergebniss {

    private int toreHeim;
    private int toreGast;

    Ergebniss ergebniss(int toreHeim, int toreGast){
        this.toreHeim = toreHeim;
        this.toreGast = toreGast;
        return ergebniss(toreHeim, toreGast);
    }

    public void addtoreHeim(){
        toreHeim++;
    }
    public void addtoreGast(){
        toreGast++;
    }


    public int getToreHeim() {
        return toreHeim;
    }

    public int getToreGast() {
        return toreGast;
    }


}
