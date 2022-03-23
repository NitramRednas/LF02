import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

import java.io.IOException;


public class KaufvertragPdf {

    public static void main(String[] args) throws IOException {

        Kaufvertrag kaufvertrag = schreibenKaufvertrag();
        pdfWriter(kaufvertrag);

    }

    public static void pdfWriter(Kaufvertrag kaufvertrag) throws IOException {

        String datei = "H:/LF02/Printwriter/Kaufvertrag.pdf";
        PdfWriter writer = new PdfWriter(datei);
        PdfDocument pdfDocument = new PdfDocument(writer);
        Document document = new Document(pdfDocument);

        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        document.setFont(font);
        document.setFontSize(5);
        document.setBold();
        document.setItalic();
        document.setTextAlignment(TextAlignment.LEFT);
        document.setFontColor(new DeviceRgb(0, 0, 0));

        // Überschrift
        Paragraph p1 = new Paragraph("Kaufvertrag");
        p1.setFontSize(19);
        p1.add("\n");
        p1.add("\n");
        document.add(p1);

        //Käufer
        Paragraph p2 = new Paragraph("Käufer");
        p2.setFontColor(new DeviceRgb(75, 25, 100));
        p2.setFontSize(15);
        p2.setUnderline();
        p2.add("\n");
        document.add(p2);

        //Käuferdaten
        Paragraph p3 = new Paragraph("Klaus Brandt");
        p3.setFontColor(new DeviceRgb(75, 25, 100));
        p3.setFontSize(12);
        p3.add("\nWurstallee 23a" + "\t" + "\t" + "28199 Bremen");
        p3.add("\n");
        p3.add("\n");
        document.add(p3);

        //Verkäufer
        Paragraph p4 = new Paragraph("Verkäufer");
        p4.setFontColor(new DeviceRgb(50, 75, 75));
        p4.setFontSize(15);
        p4.setUnderline();
        p4.add("\n");
        document.add(p4);

        //Verkäuferdaten
        Paragraph p5 = new Paragraph("Joachim Bredull");
        p5.setFontColor(new DeviceRgb(50, 75, 75));
        p5.setFontSize(12);
        p5.add("\nEntenhausen 756" + "\t" + "\t" + "28195 Bremen");
        p5.add("\n");
        p5.add("\n");
        document.add(p5);


        //Produkttabelle
        Table table = new Table(2);
        table.setFontSize(12);
        table.setFontColor(new DeviceRgb(20, 20, 100));
        table.useAllAvailableWidth();

        Cell header1 = new Cell();
        header1.add(new Paragraph("Produkt"));
        table.addHeaderCell(header1);

        Cell header2 = new Cell();
        header2.add(new Paragraph("Super krasses Gaming Laptop"));
        table.addHeaderCell(header2);

        Cell header7 = new Cell();
        header7.add(new Paragraph("Preis"));
        table.addHeaderCell(header7);

        Cell header8 = new Cell();
        header8.add(new Paragraph("250 Euro"));
        table.addHeaderCell(header8);

        Cell header3 = new Cell();
        header3.add(new Paragraph("Besonderheiten"));
        table.addHeaderCell(header3);

        Cell header4 = new Cell();
        header4.add(new Paragraph("Tasche ; Gaming-Maus"));
        table.addHeaderCell(header4);

        Cell header5 = new Cell();
        header5.add(new Paragraph("Mängel"));
        table.addHeaderCell(header5);

        Cell header6 = new Cell();
        header6.add(new Paragraph("Ladekabel fehlt ; Touchpad defekt"));
        table.addHeaderCell(header6);

        // for (int i = 0; i <= 4; i++) {
        //     table.addCell("");
        // }


        document.add(table);

        document.close();

    }

    public static Kaufvertrag schreibenKaufvertrag() {

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

        Kaufvertrag kaufvertrag = new Kaufvertrag(verkaeufer, kaeufer, ware);
        kaufvertrag.setZahlungsModalitaeten("Privater Barverkauf");

        return kaufvertrag;

    }


}
