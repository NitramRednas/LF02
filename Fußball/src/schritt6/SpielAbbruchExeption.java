package schritt6;

import schritt4.Spiel;
import schritt5.Gameplay;

import java.util.Random;

public class SpielAbbruchExeption extends  Exception {

    private int spielMinute;

    public SpielAbbruchExeption(int spielMinute){
        this.spielMinute = spielMinute;
    }

    public String getMessage(){
        return "Das Spiel ist abgebrochen bei Minute" + getSpielMinute();
    }

    public int getSpielMinute() {
        return spielMinute;
    }
}
