public class Girokonto extends Konto {

    private double zinsKredit;

    public Girokonto(Kunde inhaber, double kreditlimit, double zinsGuthaben, double zinsKredit) {
        super(inhaber, kreditlimit, zinsGuthaben);
        this.zinsKredit = zinsKredit;
    }

    public double getZinsKredit() {
        return zinsKredit;
    }

    public void setZinsKredit(double zinsKredit) {
        this.zinsKredit = zinsKredit;
    }

    public boolean ueberweisen(double betrag, Girokonto girokonto) {

        if (betrag > girokonto.getKontoStand()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "\nGirokonto\t" +
                "\nZinsKredit=" + zinsKredit;
    }
}
