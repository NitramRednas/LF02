package bussinesObjects;

public class Games {

    public int Nummer;
    public String Titel;
    public String Genre;
    public double Preis;

    public Games(int Nummer, String Titel, String Genre, double Preis){
        this.Nummer = Nummer;
        this.Titel = Titel;
        this.Genre = Genre;
        this.Preis = Preis;
    }

    public int getNummer() {
        return Nummer;
    }

    public double getPreis() {
        return Preis;
    }

    public String getGenre() {
        return Genre;
    }

    public String getTitel() {
        return Titel;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public void setNummer(int nummer) {
        Nummer = nummer;
    }

    public void setPreis(double preis) {
        Preis = preis;
    }

    public void setTitel(String titel) {
        Titel = titel;
    }

    @Override
    public String toString() {
        return "Games{" +
                "Nummer=" + Nummer +
                ", Titel='" + Titel + '\'' +
                ", Genre='" + Genre + '\'' +
                ", Preis=" + Preis +
                '}';
    }
}
