package homeworks.hw7;

public class Main {
    public static void main(String[] args) {

        FractionNumber a = new FractionNumber(12, 6);
        FractionNumber b = new FractionNumber(4, 6);
        FractionNumber c = new FractionNumber(4, 0);

        System.out.println(a.multiply(b));
        System.out.println(a.devide(b));
        System.out.println(a.add(c));
        System.out.println(a.substract(a));
        System.out.println(a.substract(null));

    }
}
