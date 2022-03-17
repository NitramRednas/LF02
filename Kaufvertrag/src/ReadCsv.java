import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadCsv {

    public static void main(String[] args) throws IOException {

        String datei = "H:/LF02/Printwriter/Kaufvertrag.csv";
        BufferedReader br = new BufferedReader(new FileReader(datei));

        String zeile;
        while ((zeile = br.readLine()) != null) {

            String[] datensatz = zeile.split(";");

            if (datensatz[0].equalsIgnoreCase("kaeufer")) {
                String[] name = datensatz[1].split(" ");
                Vertragspartner kaeufer = new Vertragspartner(name[0], name[1]);
                String[] adresse = datensatz[2].split(" ");
                String[] adresse1 = datensatz[3].split(" ");

                String strasse = adresse[0];
                String hausNr = adresse[adresse.length - 1];
                String plz = adresse1[0];
                String ort = adresse1[1];
                Adresse adressekaeufer = new Adresse(strasse, hausNr, plz, ort);

            }
            if (datensatz[0].equalsIgnoreCase("verkaeufer")) {
                String[] name = datensatz[1].split(" ");
                Vertragspartner verkaeufer = new Vertragspartner(name[0], name[1]);
                String[] adresse = datensatz[2].split(" ");
                String[] adresse1 = datensatz[3].split(" ");

                String strasse = adresse[0];
                String hausNr = adresse[adresse.length - 1];
                String plz = adresse1[0];
                String ort = adresse1[1];
                Adresse adresseverkaeufer = new Adresse(strasse, hausNr, plz, ort);


            }


        }
    }
