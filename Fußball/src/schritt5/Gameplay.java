package schritt5;

import schritt1.Spieler;
import schritt2.Torwart;
import schritt4.Mannschaft;
import schritt4.Spiel;

import java.util.Random;

public class Gameplay {

    private static final int SPIELZEIT = 90;
    private static final int MAX_NACHSPIELZEIT = 5;
    private static final int MAX_DAUER_BIS_AKTION = 10;

    /**
     * Simuliert ein Spiel.
     * @param spiel Das zu spielende Spiel.
     */
    public static void spielen(Spiel spiel) {
        Random random = new Random();
        Mannschaft offensiv;
        Mannschaft defensiv;
        // Zufällige Spieldauer festlegen
        int spielDauer = SPIELZEIT + random.nextInt(MAX_NACHSPIELZEIT + 1);
        // Zufällige Spielminute für erste Aktion festlegen
        int spielMinute = 1 + random.nextInt(MAX_DAUER_BIS_AKTION + 1);
        do {
            // Ermittlung der offensiven bzw. defensiven Mannschaft
            int heimWert = ermittelMannschaftsWert(spiel.getHeim());
            int gastWert = ermittelMannschaftsWert(spiel.getGast());
            int summe = heimWert + gastWert;
            int zufall = random.nextInt(summe + 1);
            if (zufall <= heimWert) {
                offensiv = spiel.getHeim();
                defensiv = spiel.getGast();
            }
            else {
                offensiv = spiel.getGast();
                defensiv = spiel.getHeim();
            }
            // Schütze bestimmen
            int schuetzeNr = random.nextInt(offensiv.getSpielerListe().size());
            Spieler schuetze = offensiv.getSpielerListe().get(schuetzeNr);
            // Ermitteln ob Torschuss erfolgreich oder nicht
            boolean getroffen = erzieltTor(schuetze, defensiv.getTorwart());
            if (getroffen) {
                schuetze.AddTor();
                if (offensiv == spiel.getHeim()) {
                    spiel.getErgebnis().addToreHeim();
                }
                else {
                    spiel.getErgebnis().addToreGast();
                }
                spiel.getSpielbericht().append(spielMinute + ": Tor von " + schuetze.getName() + "!\n");
            }
            else {
                spiel.getSpielbericht().append(spielMinute + ": Schuss von " + schuetze.getName() + " gehalten.\n");
            }
            // Zufällige Spielminute für nächste Aktion festlegen
            spielMinute = spielMinute + random.nextInt(MAX_DAUER_BIS_AKTION + 1);
        } while(spielMinute <= spielDauer);
        spiel.getSpielbericht().append(spiel.getErgebnis());
    }

    /**
     * Errechnet den aktuellen Stärkewert eine Mannschaft.
     * Errechnet sich aus der Spielstärke und Motivation der Mannschaft und der Erfahrung des Trainers.
     * @return Der Stärkewert.
     */
    private static int ermittelMannschaftsWert(Mannschaft mannschaft) {
        int wert = mannschaft.getStaerke() * mannschaft.getMotivation() * mannschaft.getTrainer().getErfahrung();
        wert = Math.max(1, wert);
        return wert;
    }

    /**
     * Ermittelt, ob ein Torschuss erfolgreich ist oder nicht.
     * @param schuetze Der Torschütze.
     * @param torwart Der Torwart.
     * @return Ja, wenn der Torschuss erfolgreich ist. Sonst nein.
     */
    private static boolean erzieltTor(Spieler schuetze, Torwart torwart) {
        boolean getroffen;
        Random random = new Random();
        // Stärke des Schusses ermitteln
        int schuss = schuetze.getTorschuss() + random.nextInt(5) - 2;
        schuss = Math.max(1, schuss);
        // Stärke der Abwehr ermitteln
        int abwehr = torwart.getReaktion() + random.nextInt(5) - 2;
        abwehr = Math.max(1, abwehr);
        // Ermitteln, ob Schütze trifft
        if (schuss > abwehr) {
            getroffen = true;
        }
        else {
            getroffen = false;
        }
        return getroffen;
    }

}

