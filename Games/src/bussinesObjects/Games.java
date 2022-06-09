package bussinesObjects;

public class Games {

    public String Nummer;
    public String Titel;
    public String Genre;
    public String Preis;

    public Games(String Nummer, String Titel, String Genre, String Preis){
        this.Nummer = Nummer;
        this.Titel = Titel;
        this.Genre = Genre;
        this.Preis = Preis;
    }

    public String getNummer() {
        return Nummer;
    }

    public String getPreis() {
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

    public void setNummer(String nummer) {
        Nummer = nummer;
    }

    public void setPreis(String preis) {
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
