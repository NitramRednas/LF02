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

    public ArrayList<Spieler> getSpielerListe() {
        return spielerliste;
    }

    public void setSpielerliste(ArrayList<Spieler> spielerliste) {
        this.spielerliste = spielerliste;
    }


    //Motivation

    public int getMotivation() {
        int motivation = 0;
        for (Spieler s : spielerliste) {
            motivation = motivation + s.getMotivation();
        }
        motivation = motivation + torwart.getMotivation();
        motivation = motivation / spielerliste.size();

        return motivation;
    }

    //Stärke

    public int getStaerke() {
        int staerke = 0;
        for (Spieler s : spielerliste) {
            staerke = staerke + s.getStaerke();
        }
        staerke = staerke + torwart.getStaerke();
        staerke = staerke / spielerliste.size();

        return staerke;

    }
}
