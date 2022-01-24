public class Programm {

    public static void main(String[] args) {

        Trainer trainer = new Trainer("\tUwe", 50, 6);
        Spieler spieler = new Spieler("\tWerner", 25, 30, 14, 5, 2);

        System.out.println(trainer);
        System.out.println(spieler);

    }
}
