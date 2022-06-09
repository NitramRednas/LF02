import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO {

    /**
     * Liest einen Text ein
     *
     * @throws IOException
     * @returns den eingegebenen Text
     */

    public static String readString() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String eingabe;
        eingabe = br.readLine();
        return eingabe;
    }

    /**
     * Leist eine Eingabe ein
     *
     * @throws IOException
     * @returns eine Int Variable
     */

    public static Integer readInteger() throws IOException {

        while (true) {

            try {
                String eingabe = IO.readString();
                int zahl = Integer.parseInt(eingabe.trim().replace(',', '.'));
                return zahl;
            } catch (NumberFormatException e) {
                System.out.println("Es ist ein Fehler aufgetreten. Bitte Ganzzahl eingeben");
            }
        }
    }

    /**
     * Liest eine eingabe ein
     *
     * @throws IOException
     * @returns eine double Variable
     */

    public static Double readDouble() throws IOException {

        while (true) {

            try {
                String eingabe = IO.readString();
                double zahl = Double.parseDouble(eingabe.trim().replace(',', '.'));
                return zahl;
            } catch (NumberFormatException e) {
                System.out.println("Es ist ein Fehler aufgetreten. Bitte Kommazahl eingeben");
            }
        }
    }

    /**
     * Liest eine Eingabe ein
     *
     * @return Wahr oder Falsch
     * @throws IOException
     */
    public static boolean readBoolean() throws IOException {

        while (true) {
            String eingabe = IO.readString();
            if (eingabe != null) {
                if ((eingabe.equalsIgnoreCase("Ja"))
                        || (eingabe.equalsIgnoreCase("j"))
                        || (eingabe.equalsIgnoreCase("y"))
                        || (eingabe.equalsIgnoreCase("yes"))) {
                    return true;
                }
            } else if ((eingabe.equalsIgnoreCase("No"))
                    || (eingabe.equalsIgnoreCase("N"))
                    || (eingabe.equalsIgnoreCase("Nein"))) {
                return false;
            }

        }
    }

    /**
     * Tut ein INT Array
     * @return
     * @throws IOException
     */
    public static int[] arrayint() throws IOException {

        System.out.println("wie groß soll das Array sein?");
        int a = IO.readInteger();
        int[] werteliste = new int[a];

        for (int i = 0; i < werteliste.length; i++) {
            System.out.println("Geben sie ihren Wert ein");
            werteliste[i] = IO.readInteger();

        }
        return werteliste;
    }

    /**
     * Tut ein double Array
     * @return
     * @throws IOException
     */
    public static double[] arraydouble() throws IOException {

        System.out.println("wie groß soll das Array sein?");
        int a = IO.readInteger();
        double[] werteliste = new double[a];

        for (int i = 0; i < werteliste.length; i++) {
            System.out.println("Geben sie ihren Wert ein");
            werteliste[i] = IO.readInteger();

        }
        return werteliste;

    }

}




