import java.io.*;

public class Programm {

    public static void printWriter(Kaufvertrag vertrag) throws FileNotFoundException {
        String datei = "H:/LF02/Printwriter/Kaufvertrag.txt";
        PrintWriter writer = new PrintWriter(datei);
        writer.println(vertrag);
        writer.close();
    }

    public static void printCsv(Kaufvertrag vertrag) throws FileNotFoundException {

        String datei = "H:/LF02/Printwriter/Kaufvertrag.csv";
        PrintWriter printWriter = new PrintWriter(datei);

        printWriter.println("Vertragspartner ;" + "Vorname" + " " + "Nachname ; " + "Strasse" + " " + "Hausnummer"
                + ";" + "Postleitzahl" + " " + "Ort");

        printWriter.print("Kaeufer ; ");
        printWriter.print(vertrag.getKaeufer().getVorname() + " " + vertrag.getKaeufer().getNachname() + ";");
        printWriter.println(vertrag.getKaeufer().getAdresse().getStrasse() + " "
                + vertrag.getKaeufer().getAdresse().getHausNr() + ";" + vertrag.getKaeufer().getAdresse().getPlz()
                + " " + vertrag.getKaeufer().getAdresse().getOrt());

        printWriter.print("Verkaeufer ;");
        printWriter.print(vertrag.getVerkaeufer().getVorname() + " " + vertrag.getVerkaeufer().getNachname() + ";");
        printWriter.println(vertrag.getVerkaeufer().getAdresse().getStrasse() + " "
                + vertrag.getVerkaeufer().getAdresse().getHausNr() + ";" + vertrag.getVerkaeufer().getAdresse().getPlz()
                + " " + vertrag.getVerkaeufer().getAdresse().getOrt());

        printWriter.close();
    }


    public static void main(String[] args) throws IOException {
        Ware ware = new Ware("Laptop", 250.0);
        ware.setBeschreibung("Super krasses Gaming-Laptop");
        ware.getBesonderheitenListe().add("Tasche");
        ware.getBesonderheitenListe().add("Gaming-Maus");
        ware.getMaengelListe().add("Ladekabel fehlt");
        ware.getMaengelListe().add("Touchpad defekt");

        Vertragspartner kaeufer = new Vertragspartner("Klaus", "Brandt");
        kaeufer.setAusweisNr("0123456789");
        kaeufer.setAdresse(new Adresse("Wurstallee", "23a", "28199", "Bremen"));

        Vertragspartner verkaeufer = new Vertragspartner("Joachim", "Bredull");
        verkaeufer.setAusweisNr("9876543210");
        verkaeufer.setAdresse(new Adresse("Entemhausen", "756", "28195", "Bremen"));

        Kaufvertrag vertrag = new Kaufvertrag(verkaeufer, kaeufer, ware);
        vertrag.setZahlungsModalitaeten("Privater Barverkauf");

        printWriter(vertrag);
        printCsv(vertrag);

        System.out.println(vertrag);
        System.out.println(verkaeufer.getAdresse());
        System.out.println(kaeufer.getAdresse());

    }

}

