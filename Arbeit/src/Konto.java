public abstract class Konto {

    private Kunde inhaber;
    private double kontoStand;
    private double kreditLimit;
    private double zinsGuthaben;

    Konto(Kunde inhaber, double kreditLimit, double zinsGuthaben) {
        this.inhaber = inhaber;
        this.kontoStand = 0;
        this.kreditLimit = kreditLimit;
        this.zinsGuthaben = zinsGuthaben;
    }

    public double getKontoStand() {
        return kontoStand;
    }

    public void setKontoStand(double kontoStand) {
        this.kontoStand = kontoStand;
    }

    public double getKreditLimit() {
        return kreditLimit;
    }

    public void setKreditLimit(double kreditLimit) {
        this.kreditLimit = kreditLimit;
    }

    public double getZinsGuthaben() {
        return zinsGuthaben;
    }

    public void setZinsGuthaben(double zinsGuthaben) {
        this.zinsGuthaben = zinsGuthaben;
    }

    public Kunde getInhaber() {
        return inhaber;
    }

    public void setInhaber(Kunde inhaber) {
        this.inhaber = inhaber;
    }


    //Einzahlen Auszahlen

    public void einzahlen() {
        double betrag = 0;
        this.kontoStand = betrag + this.kontoStand;
    }

    public boolean auszahlen() {
        double betrag = 0;
        this.kontoStand = this.kontoStand - betrag;
        boolean gedeckt = true;
        if (this.kontoStand < 0) {
            gedeckt = false;
        } else {
            return true;
        }return gedeckt;
    }

    @Override
    public String toString() {
        return "Konto\n" +
                "Inhaber:\t" + inhaber + "\n" +
                "KontoStand:\t" + kontoStand +
                "\nKreditLimit:\t" + kreditLimit +
                "\nZinsGuthaben:\t" + zinsGuthaben;
    }
}

