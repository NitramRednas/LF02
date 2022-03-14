public class Sparkonto extends Konto {

    public Sparkonto(Kunde inhaber, double zinsGuthaben) {
        super(inhaber, 0, zinsGuthaben);
    }

    @Override
    public String toString() {
        return "\nInhaber\t" + getInhaber() +
                "\nKreditlimit\t" + getKreditLimit() +
                "\nZinsguthaben:\t" + getZinsGuthaben();
    }
}

