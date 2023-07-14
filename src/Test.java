import org.junit.Assert;
import org.junit.Before;

public class Test {
    private static final int ANZAHL_TESTDURCHLÄUFE = 20_000;
    private Bruch[] a, b;

    @Before
    public void testSetup() {
        System.out.println("Erzeuge neue Brüche für die Berechnung");
        a = new Bruch[ ANZAHL_TESTDURCHLÄUFE ];
        b = new Bruch[ ANZAHL_TESTDURCHLÄUFE ];
        for (int i=0; i<ANZAHL_TESTDURCHLÄUFE; i++) {
            int[] werte = new int[4];
            for (int j = 0; j < werte.length; j++)
                werte[j] = (int) (Integer.MAX_VALUE * Math.random());

            a[i] = new Bruch(werte[0], werte[1]);
            b[i] = new Bruch(werte[2], werte[3]);
        }
    }

    @org.junit.Test
    public void testAddition() {
        System.out.println("Test Addition");
        for (int i=0; i<ANZAHL_TESTDURCHLÄUFE; i++) {
            Assert.assertEquals(a[i].toDouble() + b[i].toDouble(),
                    a[i].add(b[i]).toDouble(), 0.00001);
        }
    }

    @org.junit.Test
    public void testSubtraktion() {
        System.out.println("Test Subtraktion");
        for (int i=0; i<ANZAHL_TESTDURCHLÄUFE; i++) {
            Assert.assertEquals(a[i].toDouble() - b[i].toDouble(),
                    a[i].sub(b[i]).toDouble(), 0.00001);
        }
    }

    @org.junit.Test
    public void testMultiplikation() {
        System.out.println("Test Multiplikation");
        for (int i=0; i<ANZAHL_TESTDURCHLÄUFE; i++) {
            Assert.assertEquals(a[i].toDouble() * b[i].toDouble(),
                    a[i].mult(b[i]).toDouble(), 0.00001);
        }
    }

    @org.junit.Test
    public void testDivision() {
        System.out.println("Test Division");
        for (int i=0; i<ANZAHL_TESTDURCHLÄUFE; i++) {
            Assert.assertEquals(a[i].toDouble() / b[i].toDouble(),
                    a[i].div(b[i]).toDouble(), 0.00001);
        }
    }

    @org.junit.Test
    public void testVergleich() {
        System.out.println("Test Vergleich");
        for (int i=0; i<ANZAHL_TESTDURCHLÄUFE; i++) {
            if (Math.random() > 0.5)
                Assert.assertEquals(
                        a[i].kürze().toString().equals(b[i].kürze().toString()),
                        a[i].isEqual(b[i])
                );
            else if (Math.random() > 0.5)
                Assert.assertTrue(
                        a[i].isEqual(a[i])
                );
            else
                Assert.assertTrue(
                        b[i].isEqual(b[i])
                );
        }
    }
}
