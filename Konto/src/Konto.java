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

    public boolean einzahlen(double betrag) {
        System.out.println("Es wurden  " + betrag + "  Auf ihr Konto eingezahlt");
        this.kontoStand = betrag + this.kontoStand;
        System.out.println("Aktueller Kontostand:\t" + this.kontoStand);
        return true;
    }

    public boolean auszahlen(double betrag) {
        this.kontoStand = this.kontoStand - betrag;
        boolean gedeckt = true;
        if (this.kontoStand < 0) {
            gedeckt = false;
            System.out.println("Das Konto ist nicht gedeckt. Momentan haben Sie  " + kontoStand + "  Auf ihrem Konto" );
        } else {
            System.out.println("Es wurden  " + betrag  + "  ausgezahlt. " +
                               " Sie haben noch  " + kontoStand + "  auf dem Konto");
            return true;
        }return gedeckt;
    }

    @Override
    public String toString() {
        return "Konto\n" +
                "Inhaber:\t" +"\n" +
                "KontoStand:\t" + this.kontoStand +
                "\nKreditLimit:\t" + kreditLimit +
                "\nZinsGuthaben:\t" + zinsGuthaben;
    }
}

