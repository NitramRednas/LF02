import java.io.FileNotFoundException;

public class KaufvertragPdf {

    public static void PdfWriter(Kaufvertrag kaufvertrag) throws FileNotFoundException {

        String datei = "H:/LF02/Printwriter/Kaufvertrag.pdf";
        PdfWriter writer = new PdfWriter(datei);
        PdfDocument pdfDocument = new PdfDocument(writer);
        Document document = new Document(pdfDocument);


        document.close();

    }
}
