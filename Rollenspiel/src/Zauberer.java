public class Zauberer extends Spielfigur {

    private static int zauberpunkte = 3;

    public Zauberer(String name, int staerkepunkte){
        super(name, staerkepunkte);
    }

    public int getZauberpunkte() {
        return zauberpunkte;
    }

    public void trinkenZaubertrank(){
        zauberpunkte += 3;
    }

    public void zaubern() throws KeineKraftException{
        zauberpunkte -= 1;
        if (fehler(zauberpunkte)){
            throw new KeineKraftException("Zaubern", getName());
        }
    }

    public boolean fehler(int staerkepunkte){
        boolean fehler = false;
        if (zauberpunkte < 1){
            fehler = true;
        }
        else fehler = false;
        return fehler;
    }


    @Override
    public String toString() {
        return
                    "Zauberer\t" + getName() + "\n" +
                    "Stärkepunkte\t" + getStaerkepunkte() + "\n" +
                    "zauberpunkte\t" + zauberpunkte + "\n";
    }
}
