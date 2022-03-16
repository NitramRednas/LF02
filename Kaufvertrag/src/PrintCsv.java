import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintCsv {

    public static String printCsv(Kaufvertrag vertrag) throws FileNotFoundException {

        String datei1 = "H:/LF02/Printwriter/Kaufvertrag.csv";
        PrintWriter writer = new PrintWriter(datei1);
        writer.println(Kaufvertrag);
        writer.close();
        return Kaufvertrag;
    }
}
