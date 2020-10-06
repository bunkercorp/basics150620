package Homeworks.HW7;

public class MainFrNmbr {
    public static void main(String[] args) {
        FractionNumber frnmbr1 = new FractionNumber(8, 4);
        FractionNumber frnmbr2 = new FractionNumber(29, 3);

        FractionNumber result1 = frnmbr1.add(frnmbr2);
        String s1 = result1.toString();
        System.out.println("result to string add " + s1);

        FractionNumber result2 = frnmbr1.subtract(frnmbr2);
        String s2 = result2.toString();
        System.out.println("result to string subtract " + s2);

        FractionNumber result3 = frnmbr1.multiply(frnmbr2);
        String s3 = result3.toString();
        System.out.println("result to string multiply " + s3);

        FractionNumber result4 = frnmbr1.divide(frnmbr2);
        String s4 = result4.toString();
        System.out.println("result to string divide " + s4);

    }
}
