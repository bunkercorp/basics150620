package homework.hw7;

public class Main {
    public static  void main(String[] args) {
        FractionNumber fr = new FractionNumber(6,4);
        FractionNumber fr2 = new FractionNumber(1,3);

        FractionNumber result1 = fr.add(fr2);
        String s1 = result1.toString();
        System.out.println("result to string add " + s1);

        FractionNumber result2 = fr.subtract(fr2);
        String s2 = result2.toString();
        System.out.println("result to string subtract " + s2);

        FractionNumber result3 = fr.multiply(fr2);
        String s3 = result3.toString();
        System.out.println("result to string multiply " + s3);

        FractionNumber result4 = fr.divide(fr2);
        String s4 = result4.toString();
        System.out.println("result to string divide " + s4);

    }
}


