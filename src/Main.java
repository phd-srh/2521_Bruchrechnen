public class Main {
    public static void main(String[] args) {
        Bruch b1 = new Bruch(1, 2);
        Bruch b2 = new Bruch(1, 3);
        Bruch b1_plus_b2 = b1.add(b2);

        System.out.println("b1 + b2 = " + b1_plus_b2);
    }
}
