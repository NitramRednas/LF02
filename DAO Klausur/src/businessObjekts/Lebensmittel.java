package businessObjekts;

public class Lebensmittel {

    private int id;
    private String name;
    private double gewicht;
    private double preis;
    private String nuesse;
    private String milch;

    public Lebensmittel lebensmittel(int id,String name, double gewicht, double preis, String nuesse, String milch){

        Lebensmittel lebensmittel = new Lebensmittel();
        this.id = id;
        this.name = name;
        this.gewicht = gewicht;
        this.preis = preis;
        this.nuesse = nuesse;
        this.milch = milch;

        return lebensmittel;
    }

    public double getGewicht() {
        return gewicht;
    }

    public double getPreis() {
        return preis;
    }

    public int getId() {
        return id;
    }

    public String getMilch() {
        return milch;
    }

    public String getName() {
        return name;
    }

    public String getNuesse() {
        return nuesse;
    }

    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMilch(String milch) {
        this.milch = milch;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNuesse(String nuesse) {
        this.nuesse = nuesse;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    @Override
    public String toString() {
        return "Lebensmittel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gewicht=" + gewicht +
                ", preis=" + preis +
                ", nuesse='" + nuesse + '\'' +
                ", milch='" + milch + '\'' +
                '}';
    }
}
