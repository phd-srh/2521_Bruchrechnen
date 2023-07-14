public class Main {
    public static void main(String[] args) {
        Bruch b1 = new Bruch(1, 2);
        Bruch b2 = new Bruch(1, 3);
        Bruch b3 = new Bruch(2, 3);
        Bruch b4 = new Bruch(7, 14);

        System.out.println("b1 = " + b1);
        System.out.println("b2 = " + b2);
        System.out.println("b3 = " + b3);

        Bruch b1_plus_b2 = b1.add(b2); // muss man so schreiben, gemeint ist: b1 + b2
        Bruch b1_minus_b2 = b1.sub(b2);
        Bruch b1_mal_b2 = b1.mult(b2);
        Bruch b1_div_b2 = b1.div(b2);
        System.out.println("b1 + b2 = " + b1_plus_b2);
        System.out.println("b1 - b2 = " + b1_minus_b2);
        System.out.println("b1 * b2 = " + b1_mal_b2);
        System.out.println("b1 / b2 = " + b1_div_b2);

        Bruch b2_plus_b3 = b2.add(b3);
        Bruch b2_minus_b3 = b2.sub(b3);
        System.out.println("b2 + b3 = " + b2_plus_b3);
        System.out.println("b2 - b3 = " + b2_minus_b3);

        System.out.println( b1.isEqual(b4) ); // soll eigentlich b1 == b4 Äquivalenz
    }
}
