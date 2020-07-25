public class FractionNumber {
    int numerator = 0;
    int denominator = 0;

    public FractionNumber(int numerator, int denominator) {
        if (denominator == 0) {
            this.denominator = 0;
            this.numerator = 0;
        } else {
            int[] result = fractionReduction(numerator, denominator);
            this.numerator = result[0];
            this.denominator = result[1];
        }
    }

    public FractionNumber add(FractionNumber b) {
        if (zeroCheck(this.denominator, b.denominator)) {
            return new FractionNumber(0, 0);
        }
        ;
        int noz = noz(this.denominator, b.denominator);
        if (this.denominator < noz) {
            this.numerator = this.numerator * noz / this.denominator;
            this.denominator = this.denominator * noz / this.denominator;
        }
        if (b.denominator < noz) {
            b.numerator = b.numerator * noz / b.denominator;
            b.denominator = b.denominator * noz / b.denominator;
        }
        int[] resultArr = new int[2];
        resultArr[0] = this.numerator + b.numerator;
        resultArr[1] = this.denominator;
        return new FractionNumber(resultArr[0], resultArr[1]);
    }

    ;

    public FractionNumber subtract(FractionNumber b) {
        if (zeroCheck(this.denominator, b.denominator)) {
            return new FractionNumber(0, 0);
        }
        ;
        int noz = noz(this.denominator, b.denominator);
        if (this.denominator < noz) {
            this.numerator = this.numerator * noz / this.denominator;
            this.denominator = this.denominator * noz / this.denominator;
        }
        if (b.denominator < noz) {
            b.numerator = b.numerator * noz / b.denominator;
            b.denominator = b.denominator * noz / b.denominator;
        }
        int[] resultArr = new int[2];
        resultArr[0] = this.numerator - b.numerator;
        resultArr[1] = this.denominator;
        return new FractionNumber(resultArr[0], resultArr[1]);
    }

    ;

    public FractionNumber multiply(FractionNumber b) {
        if (zeroCheck(this.denominator, b.denominator)) {
            return new FractionNumber(0, 0);
        }
        ;
        int[] arrRes = new int[2];
        arrRes[0] = this.numerator * b.numerator;
        arrRes[1] = this.denominator * b.denominator;
        return new FractionNumber(arrRes[0], arrRes[1]);
    }

    ;

    FractionNumber divide(FractionNumber b) {
        if (zeroCheck(this.denominator, b.denominator)) {
            return new FractionNumber(0, 0);
        }
        ;
        int[] arrRes = new int[2];
        arrRes[0] = this.numerator * b.denominator;
        arrRes[1] = this.denominator * b.numerator;
        return new FractionNumber(arrRes[0], arrRes[1]);
    }

    ;

    private static int[] fractionReduction(int numerator, int denominator) {
        int divideOn = 1;
        int[] toSave = new int[2];
        for (int i = 1; i < maxOf(Math.abs(numerator), Math.abs(denominator)); i++) {
            if (numerator % i == 0 && denominator % i == 0) {
                divideOn = i;
            }
        }
        toSave[0] = numerator / divideOn;
        toSave[1] = denominator / divideOn;
        return toSave;
    }

    ;

    private static int noz(int den1, int den2) {
        int i = maxOf(den1, den2);
        while (true) {
            if (i % den1 == 0 && i % den2 == 0) {
                break;
            }
            i++;
        }
        return i;
    }

    private static int maxOf(int a, int b) {
        if (a > b) {
            return a;
        } else if (b > a) {
            return b;
        } else {
            return a;
        }
    }

    private static boolean zeroCheck(int a, int b) {
        if (a == 0 || b == 0) {
            return true;
        } else {
            return false;
        }
    }

    ;

    @Override
    public String toString() {
        if (this.denominator == 1) {
            return this.numerator + "";
        } else if (this.numerator > this.denominator) {
            return  (int)(this.numerator / this.denominator) + " " + this.numerator % this.denominator + "/" + this.denominator;
        } else if (this.denominator == 0) {
            return "DIVISION BY ZERO";
        } else {
            return this.numerator + "/" + this.denominator;
        }
    }
}
