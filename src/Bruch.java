public class Bruch {
    private final long zähler;  // <- alle Attribute sind finale => immutable Klasse
    private final long nenner;

    public Bruch(long zähler, long nenner) {
        this.zähler = zähler;
        this.nenner = nenner;
    }

    public Bruch add(Bruch b) {
        long neuNenner = this.nenner * b.nenner;
        long neuZähler = this.zähler * b.nenner + b.zähler * this.nenner;
        return new Bruch(neuZähler, neuNenner).kürze();
    }

    public Bruch kürze() {
        long teiler = ggT(this.zähler, this.nenner);
        return new Bruch( this.zähler / teiler, this.nenner / teiler );
    }

    private long ggT(long a, long b) {
        while (a != b) {
            if (a > b) a -= b;
            else       b -= a;
        }
        return a;
    }

    @Override
    public String toString() {
        return zähler + "/" + nenner;
    }
}
