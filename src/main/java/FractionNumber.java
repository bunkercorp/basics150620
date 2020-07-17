public class FractionNumber {

    public static void main(String[] args) {
        FractionNumber firstFraction = new FractionNumber(2, 4);
        FractionNumber secondFraction = new FractionNumber(4, 8);
        FractionNumber result = firstFraction.add(secondFraction);
        System.out.println(result.dividend + "/" + result.divider);


    }


    int dividend, divider;  // делимое , делитель

    FractionNumber(int dividend, int divider) {
        this.dividend = dividend;
        this.divider = divider;
    }


    public FractionNumber add(FractionNumber fractionToAdd) {
        int newDividend, newDivider;
        newDividend = (dividend * fractionToAdd.divider) + (fractionToAdd.dividend * divider);
        newDivider = fractionToAdd.divider * divider;
        FractionNumber resultFraction = new FractionNumber(newDividend, newDivider);
        resultFraction.reduce();
        return resultFraction;


    }

    public void reduce() {
        for (int i = 2; i < 1000; i++) {
            if (divider % i == 0 || dividend % i == 0) {
                divider = divider / i;
                dividend = dividend / i;
                i--;
            }
        }
    }


}
