import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCsv {

    public static void readCsv() throws IOException {
        String datei = "H:/LF02/Printwriter/Kaufvertrag.csv";
        BufferedReader br = new BufferedReader(new FileReader(datei));

        String zeile;
        while ((zeile = br.readLine()) != null) {

        }

    }
}
