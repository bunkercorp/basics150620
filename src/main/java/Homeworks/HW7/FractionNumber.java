package Homeworks.HW7;

public final class FractionNumber {
    private int a;
    private int b;

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public FractionNumber add(FractionNumber number) {
        int numerator = this.a * number.b + this.b * number.a;
        int denominator = this.b * number.b;
        return new FractionNumber(numerator, denominator);
    }

    public FractionNumber subtract(FractionNumber number) {
        int numerator = this.a * number.b - this.b * number.a;
        int denominator = this.b * number.b;
        return new FractionNumber(numerator, denominator);
    }

    public FractionNumber multiply(FractionNumber number) {
        int numerator = this.a * number.a;
        int denominator = this.b * number.b;
        return new FractionNumber(numerator, denominator);
    }

    public FractionNumber divide(FractionNumber number) {
        int numerator = this.a * number.b;
        int denominator = this.b * number.a;
        return new FractionNumber(numerator, denominator);
    }

    public String toString() {
        String s = "";
        if (this.getB() == 0) {
            s = "DIVISION BY ZERO";
        }
        if (this.getB() == 1) {
            s = String.format("%d", this.getA());
        }
        if (this.getA() < this.getB()) {
            s = String.format("%d/%d", this.getA(), this.getB());
        } else if (this.getA() > this.getB()) {
            int x = this.getA() / this.getB();
            int y = this.getA() % this.getB();
            System.out.println("X = " + x + " Y = " + y);
            s = String.format("%d %d/%d", x, y, this.getB());
        }
        return s;
    }

    public FractionNumber(int a, int b) {
        this.a = a;
        this.b = b;

        int min = 0;
        if (a > b)
            min = b;
        else
            min = a;
        for (int i = 1; i <= min; i++) {
            if ((a % i == 0) && (b % i == 0)) {
                this.a = a / i;
                this.b = b / i;
            }
        }
        System.out.println(this.a);
        System.out.println(this.b);
    }
}
