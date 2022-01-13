public class Programm {

    public static void main(String[] args) {

        Apfel apfel = new Apfel();
        apfel.setFarbe("Grün");
        apfel.setGewicht(250);
        apfel.setReif(true);

        System.out.println(apfel.getName());
        System.out.println(apfel.getFarbe());
        System.out.println(apfel.getGewicht());
        System.out.println(apfel.isReif());

        System.out.println();
        System.out.println();

        Banane banane = new Banane();
        banane.setKruemmung(3);
        banane.setGewicht(300);

        System.out.println(banane.getName());
        System.out.println(banane.getKruemmung());
        System.out.println(banane.getGewicht());


    }
}
