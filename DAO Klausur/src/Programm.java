import businessObjekts.Lebensmittel;
import dao.LebensmittelDao;

import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Programm {

    private static String abfrage() {
        String line = "=========================================================";
        System.out.println(line);
        System.out.println("Was möchten sie tun?");
        System.out.println("1 für das hinzufügen von Lebensmitteln");
        System.out.println("2 für das ausgeben eines Lebensmittels nach seiner ID");
        System.out.println("3 für das Anzeigen aller Lebensmittel");
        System.out.println("4 für das Anzeigen aller Lebensmittel Ohne Allergene");
        System.out.println("5 für das Aktuallisieren eines Lebensmittels");
        System.out.println("6 für das Löschen eines Lebensmittels");
        System.out.println("7 fürs Beenden des Programmes");
        System.out.println(line);
        return null;
    }


    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String line = "=========================================================";
        LebensmittelDao lebensmittelDao = new LebensmittelDao();

        Scanner scanner = new Scanner(System.in);
        String test = scanner.nextLine();
        int ganzZahl = scanner.nextInt();
        double kommaZahl = scanner.nextDouble();

        String eingabe = abfrage();
        String auslesen;
        auslesen = scanner.nextLine();

        System.out.println(eingabe);
        while (true) {

            if (auslesen.equalsIgnoreCase("1")) {
                String name;
                double gewicht;
                double preis;
                String nuesse;
                String milch;
                System.out.println("Welches Lebensmittel wollen sie Hinzufügen?");
                name = scanner.next();
                System.out.println("Das Gewicht?");
                gewicht = scanner.nextDouble();
                System.out.println("Der Preis?");
                preis = scanner.nextDouble();
                System.out.println("Sind Nüsse enthalten? Ja oder Nein");
                nuesse = scanner.nextLine();
                System.out.println("Ist Milch enthalten? Ja oder Nein");
                milch = scanner.nextLine();
                System.out.println(line);

            } else if (auslesen.equalsIgnoreCase("2")) {

                System.out.println("Welches Lebensmittel möchten sie ausgeben?");
                int id = scanner.nextInt();
                System.out.println(lebensmittelDao.read(id));
                System.out.println(line);

            } else if (auslesen.equalsIgnoreCase("3")) {
                System.out.println("Hier alle Lebensmittel");
                System.out.println(lebensmittelDao.read());
                System.out.println(line);

            } else if (auslesen.equalsIgnoreCase("4")) {
                System.out.println("Alle Lebensmittel ohne Allergene");
                System.out.println(lebensmittelDao.readAllergyFree());
                System.out.println(line);

            } else if (auslesen.equalsIgnoreCase("5")) {
                System.out.println("Welches Lebensmittel möchten sie Aktualisieren?");
                System.out.println(lebensmittelDao.read());
                System.out.println("Neuer Name");
                scanner.next();
                System.out.println("Neues Gewicht");
                scanner.nextDouble();
                System.out.println("Neuer Preis");
                scanner.nextDouble();
                System.out.println("Hat es Nüsse? Ja oder Nein");
                scanner.next();
                System.out.println("Hat es Milch? Ja oder Nein");
                scanner.next();
                System.out.println(line);

            } else if (auslesen.equalsIgnoreCase("6")) {
                System.out.println("Welchen Eintrag wollen sie löschen?");
                lebensmittelDao.delete(scanner.nextInt());
                System.out.println("Eintrag gelöscht");
                System.out.println(line);

            } else if (auslesen.equalsIgnoreCase("7")) {
                System.out.println(line);
                System.out.println("Programm wird beendet");
                System.out.println(line);
                break;
            }

        }
    }

}
