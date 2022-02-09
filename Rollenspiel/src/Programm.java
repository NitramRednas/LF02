public class Programm {

    public static void main(String[] args) throws KeineKraftException {

        Elfe elfe = new Elfe("Loria Spitzohr", 5);

        Zauberer zauberer = new Zauberer("Ulf Hasenfus",3);

        System.out.println(elfe);
        System.out.println(zauberer);
        elfe.setStaerkepunkte(0);
        try{
            elfe.rennen();
        }catch (KeineKraftException e){
            System.out.println(e.getMessage());
        }


    }
}
