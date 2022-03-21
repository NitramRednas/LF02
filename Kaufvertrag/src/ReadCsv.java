import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadCsv {

    public static void main(String[] args) throws IOException {

        String datei = "H:/LF02/Printwriter/Kaufvertrag.csv";
        BufferedReader br = new BufferedReader(new FileReader(datei));
        String zeile;
        String strasse = "";
        Vertragspartner kaeufer = null;
        Vertragspartner verkaeufer = null;

        while ((zeile = br.readLine()) != null) {

            String[] datensatz = zeile.split(";");

            String[] name = datensatz[1].split(" ");

            String[] strasseHausNr = datensatz[2].split(" ");

            String hausNr = strasseHausNr[strasseHausNr.length - 1];
            for (int i = 0; i < strasseHausNr.length-1; i++) {
                strasse += strasseHausNr[i] + " ";
            }
            strasse = strasse.trim();

            String[] plzOrt = datensatz[3].split(" ");

            String ort = "";
            String plz = plzOrt[1];
            for (int i = 1; i < plzOrt.length; i++) {
                ort = plzOrt[i] + " ";
            }
            ort = ort.trim();


            if (datensatz[0].equalsIgnoreCase("kaeufer")) {
                kaeufer = new Vertragspartner(name[0], name[1]);
                kaeufer.setAdresse(new Adresse(strasse, hausNr, plz, ort));
            }

            if (datensatz[0].equalsIgnoreCase("verkaeufer")) {
                verkaeufer = new Vertragspartner(name[0], name[1]);
                verkaeufer.setAdresse(new Adresse(strasse, hausNr, plz, ort));
            }


        }

    }
}
