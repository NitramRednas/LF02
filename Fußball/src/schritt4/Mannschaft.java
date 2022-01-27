package schritt4;

import schritt1.Spieler;
import schritt1.Trainer;
import schritt2.Torwart;

import java.util.ArrayList;

public class Mannschaft {

    private String name;
    private Trainer trainer;
    private Torwart torwart;
    private ArrayList<Spieler> spielerliste;


    public Mannschaft(String name, Trainer trainer, Torwart torwart, ArrayList<Spieler> spielerliste) {
        this.name = name;
        this.trainer = trainer;
        this.torwart = torwart;
        this.spielerliste = spielerliste;
    }

    //Heimmanschaft

    Trainer heimtrainer = new Trainer("Jürgen Windhose", 49, 6);
    Torwart heimtorwart = new Torwart("Jürgen Wanne", 24, 6, 4, 6);


    Spieler sp1 = new Spieler("Olaf", 21, 8, 2, 6, 0);
    Spieler sp2 = new Spieler("Dieter", 27, 3, 8, 3, 4);
    Spieler sp3 = new Spieler("Gustav", 25, 4, 4, 4, 1);
    Spieler sp4 = new Spieler("Korn", 20, 3, 5, 9, 3);

    ArrayList<Spieler> heimspielerliste = new ArrayList<>();
    heimspielerliste.add(sp1);
    heimspielerliste.add(sp2);
    heimspielerliste.add(sp3);
    heimspielerliste.add(sp4);

    Mannschaft heim = new Mannschaft("Heim", heimtrainer, heimtorwart, heimspielerliste);

    //Gastmanschaft

    Trainer gasttrainer = new Trainer("Uwe Schelle", 60, 10);
    Torwart gasttorwart = new Torwart("Ulf Tatort", 12, 10, 0, 2);


    Spieler spA = new Spieler("Paul", 21, 2, 8, 0, 6);
    Spieler spB = new Spieler("Karl", 27, 5, 1, 5, 4);
    Spieler spC = new Spieler("Flensburg", 25, 3, 6, 6, 1);
    Spieler spD = new Spieler("Schnaps", 20, 3, 5, 7, 3);

    ArrayList<Spieler> gastspielerliste = new ArrayList<>();
    gastspielerliste.add(spA);
    gastspielerliste.add(spB);
    gastspielerliste.add(spC);
    gastspielerliste.add(spD);

    Mannschaft gast = new Mannschaft("Gast", gasttrainer, gasttorwart, gastspielerliste);

    //Getter/Setter


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public Torwart getTorwart() {
        return torwart;
    }

    public void setTorwart(Torwart torwart) {
        this.torwart = torwart;
    }

    public ArrayList<Spieler> getHeimspielerliste() {
        return heimspielerliste;
    }

    public ArrayList<Spieler> getGastspielerliste() {
        return gastspielerliste;
    }

    public ArrayList<Spieler> getSpielerliste() {
        return spielerliste;
    }

    public void setGastspielerliste(ArrayList<Spieler> gastspielerliste) {
        this.gastspielerliste = gastspielerliste;
    }
    public void setHeimspielerliste(ArrayList<Spieler> heimspielerliste){
        this.heimspielerliste = heimspielerliste;
    }

    public void setSpielerliste(ArrayList<Spieler> spielerliste) {
        this.spielerliste = spielerliste;
    }
    //Motivation


    //Stärke


}
