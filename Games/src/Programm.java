import bussinesObjects.Games;
import dao.GameDao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Programm {

    private static String ausgabe() throws IOException {
        System.out.println("Was möchten sie im Verzeichnis Games Tun?");
        System.out.println("1 für Das anzeigen der Liste");
        System.out.println("2 für das löschen eines Eintrags");
        System.out.println("3 für das Hinzufügen eines Spieles");
        System.out.println("4 für das Aktualisieren eines Eintrags");
        System.out.println("5 für beenden");
        String eingabe = IO.readString();
        return eingabe;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

        GameDao gameDao = new GameDao();
        ArrayList<Games> gamesArrayList = new ArrayList<>();
        String line = "========================================================";
        gameDao = null;
        gamesArrayList = null;

        String eingabe = ausgabe();
        boolean normal = true;
        while (normal) {
            if (eingabe == "1") {
                System.out.println("Hier ist die ganze Liste");
                gameDao.readArray();
                System.out.println(line);
                System.out.println("Treffen sie eine andere eingabe");
                System.out.println(eingabe);
                System.out.println(line);

            } else if (eingabe == "2") {
                System.out.println("Welchen eintag möchten sie löschen?");
                System.out.println(gameDao.readArray());
                System.out.println(line);
                gameDao.delete(eingabe);
                System.out.println("Eintrag gelöscht");
                System.out.println(line);
                System.out.println("Treffen sie eine andere eingabe");
                System.out.println(eingabe);
                System.out.println(line);

            } else if (eingabe == "3") {
                String nummer;
                String titel;
                String genre;
                String preis;
                System.out.println("Welche Nummer hat das Spiel?");
                nummer = eingabe;
                System.out.println("Wie heißt das Spiel?");
                titel = eingabe;
                System.out.println("Welches Genre hat das Spiel?");
                genre = eingabe;
                System.out.println("Wieviel € kostet das Spiel?");
                preis = eingabe;
                Games games = new Games(nummer, titel, genre, preis);
                gameDao.insert(games);
                System.out.println(line);
                System.out.println("Treffen sie eine andere eingabe");
                System.out.println(eingabe);
                System.out.println(line);

            } else if (eingabe == "4") {
                String nummer;
                String titel;
                String genre;
                String preis;
                System.out.println("Welchen Eintrag möchten sie Aktualisieren?");
                System.out.println(gameDao.readArray());
                System.out.println("Welche Nummer hat das neue Spiel?");
                nummer = eingabe;
                System.out.println("Wie heißt das neue Spiel?");
                titel = eingabe;
                System.out.println("Welches Genre hat das neue Spiel?");
                genre = eingabe;
                System.out.println("Wieviel € kostet das neue Spiel?");
                preis = eingabe;
                Games games = new Games(nummer, titel, genre, preis);
                gameDao.update(games);
                System.out.println(line);
                System.out.println("Treffen sie eine andere eingabe");
                System.out.println(eingabe);
                System.out.println(line);
            } else if (eingabe == "5") ;
                break;

        }

    }
}
