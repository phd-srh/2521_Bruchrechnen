public class Main {
    public static void main(String[] args) {
        Bruch b1 = new Bruch(1, 2);
        Bruch b2 = new Bruch(1, 3);
        Bruch b3 = new Bruch(2, 3);

        System.out.println("b1 = " + b1);
        System.out.println("b2 = " + b2);

        Bruch b1_plus_b2 = b1.add(b2); // muss man so schreiben, gemeint ist: b1 + b2
        System.out.println("b1 + b2 = " + b1_plus_b2);

        Bruch b2_plus_b3 = b2.add(b3);
        System.out.println("b2 + b3 = " + b2_plus_b3);
    }
}
