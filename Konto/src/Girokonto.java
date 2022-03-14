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

        if (girokonto.getKontoStand() > betrag) {
            System.out.println("Sie sind zu arm für diese Überweisung");
            return false;
        } else {
            System.out.println("Es wurden " + betrag + "  überwiesen");
            return true;
        }
    }

    @Override
    public String toString() {
        return "\nGirokonto\t" +
                "\nZinsKredit=" + zinsKredit;
    }
}
