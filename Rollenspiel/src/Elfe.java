public class Elfe extends Spielfigur {



    public Elfe(String name, int staerkepunkte){
        super(name, staerkepunkte);
    }

    public void rennen() throws KeineKraftException{
        setStaerkepunkte(getStaerkepunkte() -2);
        if (fehler(getStaerkepunkte())){
            throw new KeineKraftException("Rennen", getName());
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
