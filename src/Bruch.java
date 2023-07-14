public class Bruch {
    private final long zähler;  // <- alle Attribute sind finale => immutable Klasse
    private final long nenner;

    public Bruch(long zähler, long nenner) {
        this.zähler = zähler;
        this.nenner = nenner;
    }

    // bruch_a .add( bruch_b ) => weil wir a + b, oder addiere(a, b)
    public Bruch add(Bruch b) {
        long neuNenner = this.nenner * b.nenner;
        long neuZähler = this.zähler * b.nenner + b.zähler * this.nenner;
        return new Bruch(neuZähler, neuNenner).kürze();
    }

    public Bruch sub(Bruch b) {
        return add( b.negiere() );
    }

    public Bruch mult(Bruch b) {
        return new Bruch(this.zähler * b.zähler, this.nenner * b.nenner).kürze();
    }

    public Bruch div(Bruch b) {
        return this.mult( b.kehrWert() );
    }

    public Bruch kehrWert() {
        return new Bruch(this.nenner, this.zähler);
    }

    public Bruch negiere() {
        if (this.nenner < 0)
            return new Bruch( this.zähler, -this.nenner );
        else
            return new Bruch( -this.zähler, this.nenner );
    }

    public Bruch kürze() {
        long teiler = ggT(this.zähler, this.nenner);
        return new Bruch( this.zähler / teiler, this.nenner / teiler );
    }

    public boolean isEqual(Bruch b) {
        // Möglichkeit 1 - programmtechnische Lösung
        Bruch this_gekürzt = this.kürze();
        Bruch b_gekürzt = b.kürze();
        return this_gekürzt.zähler == b_gekürzt.zähler && this_gekürzt.nenner == b_gekürzt.nenner;
        // Möglichkeit 2 - mathematische Lösung
//        Bruch quotient = this.div(b);
//        return quotient.zähler == quotient.nenner;
    }

    private long ggT(long a, long b) {
        if (a == 0) return b;
        if (b == 0) return a;
        if (a < 0) a = -a;
        if (b < 0) b = -b;
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
