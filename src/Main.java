public class Main {
    private static final int ANZAHL_TESTDURCHLÄUFE = 20_000;

    public static boolean sindDieBeidenDoubleNahezuGleich(double a, double b) {
        return Math.abs(a - b) < 0.0000001;
    }

    public static void main(String[] args) {
        int anzahlPositiverTests = 0;
        for (int i=0; i<ANZAHL_TESTDURCHLÄUFE; i++) {
            int[] werte = new int[4];
            for (int j=0; j< werte.length; j++)
                werte[j] = (int)(Integer.MAX_VALUE*Math.random());
            anzahlPositiverTests += testBruchKalkulation(werte);
        }
        System.out.println(anzahlPositiverTests + "/" +
                (ANZAHL_TESTDURCHLÄUFE*5) + " waren erfolgreich");
    }

    private static int testBruchKalkulation(int[] werte) {
        int anzahlPositiverTests = 0;
        Bruch a = new Bruch(werte[0], werte[1]);
        Bruch b = new Bruch(werte[2], werte[3]);

        if ( sindDieBeidenDoubleNahezuGleich( a.add(b).toDouble(),
                a.toDouble() + b.toDouble() )) anzahlPositiverTests++;
        if ( sindDieBeidenDoubleNahezuGleich( a.sub(b).toDouble(),
                a.toDouble() - b.toDouble() )) anzahlPositiverTests++;
        if ( sindDieBeidenDoubleNahezuGleich( a.mult(b).toDouble(),
                a.toDouble() * b.toDouble() )) anzahlPositiverTests++;
        if ( sindDieBeidenDoubleNahezuGleich( a.div(b).toDouble(),
                a.toDouble() / b.toDouble() )) anzahlPositiverTests++;

        if (a.isEqual(b)) System.out.println("Juheeyy, die sind mal gleich!!");
        if ( sindDieBeidenDoubleNahezuGleich(a.toDouble(), b.toDouble())
            == a.isEqual(b) ) anzahlPositiverTests++;

        return anzahlPositiverTests;
    }
}
