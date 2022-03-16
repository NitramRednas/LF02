import java.io.*;

public class Programm {

    public static void printWriter(Kaufvertrag vertrag) throws FileNotFoundException {
        String datei = "H:/LF02/Printwriter/Kaufvertrag.txt";
        PrintWriter writer = new PrintWriter(datei);
        writer.println(vertrag);
        writer.close();
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
        kaeufer.setAdresse(new Adresse("Zu Hause", "3a", "28199", "Bremen"));

        Vertragspartner verkaeufer = new Vertragspartner("Joachim", "Bredull");
        verkaeufer.setAusweisNr("9876543210");
        verkaeufer.setAdresse(new Adresse("Auch zu Hause", "7", "28195", "Bremen"));

        Kaufvertrag vertrag = new Kaufvertrag(verkaeufer, kaeufer, ware);
        vertrag.setZahlungsModalitaeten("Privater Barverkauf");

        printWriter(vertrag);


    }

}

