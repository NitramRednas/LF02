import com.itextpdf.kernel.pdf.PdfWriter;

import java.io.IOException;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.TextAlignment;

import java.util.ArrayList;

public class ProgrammWritePdf {


    public static void main(String[] args) throws IOException {

        Kaufvertrag kaufvertrag = erstellenKaufvertrag();
        SchreibenPDF(kaufvertrag);

    }


    public static void SchreibenPDF(Kaufvertrag vertrag) throws IOException {
        String datei = "H:/LF02/Printwriter/Kaufvertrag.pdf";
        PdfWriter writer = new PdfWriter(datei);
        PdfDocument pdfDocument = new PdfDocument(writer);
        Document document = new Document(pdfDocument);
        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        document.setFont(font);
        Style style = new Style();
        style.setFont(PdfFontFactory.createFont(StandardFonts.COURIER_BOLDOBLIQUE));
        style.setFontSize(12);
        Style styleSpecial = new Style();
        PdfFont pdfFontspecial = PdfFontFactory.createFont(StandardFonts.COURIER);
        styleSpecial.setFont(pdfFontspecial).setFontSize(12);

        //Überschrift
        Cell Ueberschrift = new Cell();
        Ueberschrift.setTextAlignment(TextAlignment.CENTER);
        Ueberschrift.add(new Paragraph("Kaufvertrag").setBackgroundColor(new DeviceRgb(150, 150, 150)).setFontColor(ColorConstants.WHITE).setFontSize(30));
        Ueberschrift.add(new Paragraph("\n\n"));
        document.add(Ueberschrift);

        //Käufer
        Paragraph pKaeufer = new Paragraph();


        pKaeufer.add(new Text("Käufer:\n").setUnderline().setFontColor(new DeviceRgb(50, 150, 250)).setFontSize(16));
        document.add(pKaeufer);


        List listKaeufer = new List();
        listKaeufer.setListSymbol("- ");
        listKaeufer.add(vertrag.getKaeufer().getVorname() + " " + vertrag.getKaeufer().getNachname() + "\n");
        listKaeufer.add(vertrag.getKaeufer().getAdresse().getStrasse() + " " + vertrag.getKaeufer().getAdresse().getHausNr() + " "
                + vertrag.getKaeufer().getAdresse().getPlz() + " " + vertrag.getKaeufer().getAdresse().getOrt() + "\n");
        listKaeufer.add(vertrag.getKaeufer().getAusweisNr());

        document.add(listKaeufer);

        //Verkäufer
        Paragraph pVerkaeufer = new Paragraph();

        pVerkaeufer.add(new Text("\nVerkäufer:\n").setFontColor(ColorConstants.BLUE).setUnderline().setFontSize(15));
        document.add(pVerkaeufer);

        List listVerkaeufer = new List();

        listVerkaeufer.setListSymbol("- ");
        listVerkaeufer.add(vertrag.getVerkaeufer().getVorname() + " " + vertrag.getVerkaeufer().getNachname());
        listVerkaeufer.add(vertrag.getVerkaeufer().getAdresse().getStrasse() + " " + vertrag.getVerkaeufer().getAdresse().getHausNr() + " "
                + vertrag.getVerkaeufer().getAdresse().getPlz() + " " + vertrag.getVerkaeufer().getAdresse().getOrt());
        listVerkaeufer.add(vertrag.getVerkaeufer().getAusweisNr());
        pVerkaeufer.add(new Paragraph("\n\n"));
        document.add(listVerkaeufer);


        //Ware
        Paragraph pWare = new Paragraph();

        pWare.add(new Text("\nVerkaufte Ware:\n").setUnderline().setFontColor(ColorConstants.BLACK));
        pWare.setFontSize(13);

        Table tableWare = new Table(2);
        tableWare.useAllAvailableWidth();

        Cell headerl = new Cell();
        headerl.add(new Paragraph("Text"));
        headerl.setTextAlignment(TextAlignment.LEFT);
        tableWare.addHeaderCell(headerl);
        Cell header2 = new Cell();
        header2.add(new Paragraph("Wert"));
        header2.setTextAlignment(TextAlignment.LEFT);
        tableWare.addHeaderCell(header2);


        tableWare.addCell("Bezeichnung");
        tableWare.addCell(vertrag.getWare().getBezeichnung());
        tableWare.addCell("Beschreibung");
        tableWare.addCell(vertrag.getWare().getBeschreibung());
        tableWare.addCell("Preis");
        tableWare.addCell("" + vertrag.getWare().getPreis());
        tableWare.addCell("Besonderheiten");
        ArrayList<String> besonderheiten = vertrag.getWare().getBesonderheiten();
        tableWare.addCell(String.valueOf(besonderheiten));
        tableWare.addCell("Mängel");
        ArrayList<String> maengel = vertrag.getWare().getMaengel();
        tableWare.addCell(String.valueOf(maengel));

        document.add(pWare);
        document.add(tableWare);

        Paragraph pZahlung = new Paragraph();
        pZahlung.add(new Text("\nZahlungsmodalitäten:\n").setFontSize(16).setUnderline().setFontColor(ColorConstants.DARK_GRAY));
        pZahlung.add(vertrag.getZahlungsModalitaeten());
        document.add(pZahlung);

        Paragraph p6 = new Paragraph(" ").setBackgroundColor(new DeviceRgb(150, 150, 150)).setFontSize(30).add("\n");
        document.add(p6);

        document.close();
    }

    public static Kaufvertrag erstellenKaufvertrag() {
        Ware ware = new Ware("Laptop", 250.0);
        ware.setBeschreibung("Super krasses Gaming-Laptop");
        ware.getBesonderheiten().add("Tasche");
        ware.getBesonderheiten().add("Gaming-Maus");
        ware.getMaengel().add("Ladekabel fehlt");
        ware.getMaengel().add("Touchpad defekt");

        Vertragspartner kaeufer = new Vertragspartner("Hans", "Kanns");
        kaeufer.setAusweisNr("0123456789");
        kaeufer.setAdresse(new Adresse("Wurstallee", "33a", "28199", "Unterbach"));

        Vertragspartner verkaeufer = new Vertragspartner("Jens", "Jensensen");
        verkaeufer.setAusweisNr("9876543210");
        verkaeufer.setAdresse(new Adresse("Hinter der Ecke", "0", "28195", "Nebenbach"));

        Kaufvertrag vertrag = new Kaufvertrag(verkaeufer, kaeufer, ware);
        vertrag.setZahlungsModalitaeten("Privater Barverkauf");

        System.out.println(vertrag);

        return vertrag;
    }
}



