public class MainClass {
    public static void main(String[] args) {
        FractionNumber firstFraction = new FractionNumber(2, 4);
        FractionNumber secondFraction = new FractionNumber(2, 4);
        FractionNumber result = firstFraction.add(secondFraction);
        System.out.println(result.dividend + "/" + result.divider);



    }
}
