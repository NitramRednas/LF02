public class Programm {

    public static void main(String[] args) {

        Kunde kunde = new Kunde("Heinz","Günther");

        Mitarbeiter mitarbeiter = new Mitarbeiter("Ranz","Kanns");

        Adresse adresse = new Adresse("Apfelbaumallee","584b","26895", "Buchstehude");

        Sparkonto sparkonto = new Sparkonto(kunde,500);


        System.out.println(kunde);
        System.out.println(adresse);
        System.out.println(sparkonto);
        System.out.println(mitarbeiter);
    }

}
