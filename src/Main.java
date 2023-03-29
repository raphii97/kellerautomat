import java.util.Scanner;

public class Main {
    private static String wort = "";
    private static KellerAutomat kellerAutomat = new KellerAutomat();

    private static void gibWort() {
        System.out.println("Geben Sie ein Ausdruck in umgekehrter polnische Notation: ");
        Scanner scanner = new Scanner(System.in);
        wort = scanner.nextLine();
    }

    private static boolean wortValidieren() {
        //0-9 + * Space
        wort = wort.replaceAll("\\s", "");
        return wort.matches("[0-9+*]+");
    }

    private static void start(Modus modus) {
        gibWort();
        if (wortValidieren()) {
            while (!wort.isEmpty()){
                kellerAutomat.berechnungsSchritt(wort.charAt(0), modus.getModus());

                if (wort.length() > 1) wort = wort.substring(1);
                else wort = "";
            }
            System.out.println("Resultat: " + kellerAutomat.gibResultat());
        }
        else System.out.println("Error! Ausdruck nicht gültig.");
    }

    public static void main(String[] args) {
        start(Modus.STEP);
    }

    private enum Modus {
        STEP(true),
        LAUF(false);

        private boolean modus;

        Modus(boolean modus) {
            this.modus = modus;
        }

        public boolean getModus() {
            return modus;
        }
    }
}