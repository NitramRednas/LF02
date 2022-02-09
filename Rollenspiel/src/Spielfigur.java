public abstract class Spielfigur {

    private int staerkepunkte;
    private String name;

    public Spielfigur(String name, int staerkepunkte) {
        this.name = name;
        this.staerkepunkte = staerkepunkte;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getStaerkepunkte() {
        return staerkepunkte;
    }

    //Aktionen

    public void kaempfen() throws KeineKraftException {
        staerkepunkte -= 3;
        if (fehler(staerkepunkte)) {
            throw new KeineKraftException("Kämpfen", name);
        }
    }

    public void klettern() throws KeineKraftException {
        staerkepunkte -= 2;
        if (fehler(staerkepunkte)) {
            throw new KeineKraftException("Klettern", name);
        }
    }

    public void laufen() throws KeineKraftException {
        staerkepunkte -= 1;
        if (fehler(staerkepunkte)) {
            throw new KeineKraftException("Laufen", name);
        }
    }

    public void essen() {
        staerkepunkte += 10;
    }

    //Setstaerkepunkte

    protected void setStaerkepunkte(int staerkepunkte) {
        this.staerkepunkte = staerkepunkte;
    }

    public boolean fehler(int staerkepunkte) {
        boolean fehler = false;
        if (staerkepunkte < 1) {
            fehler = true;
        }
        return fehler;
    }

    @Override
    public String toString() {
        return "Name:\t" + name +
                "\nStärkepunkte\t" + staerkepunkte + "\n";

    }
}


