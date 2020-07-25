public class Main {
    public static void main(String[] arg){
        FractionNumber test = new FractionNumber(3,4);
        FractionNumber test1 = new FractionNumber(5,6);
        FractionNumber testWith1 = new FractionNumber(1,1);
        FractionNumber testWith0 = new FractionNumber(1,0);
        System.out.println(testWith1.toString());
        System.out.println(testWith0.toString());
        FractionNumber result = test.add(test1);
        System.out.println(result.toString());
        result = test.subtract(test1);
        System.out.println(result.toString());
        result = test.multiply(test1);
        System.out.println(result.toString());
        result = test.divide(test1);
        System.out.println(result.toString());
    }
}
