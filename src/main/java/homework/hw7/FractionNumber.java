package homework.hw7;

public class FractionNumber {
    private int a;
    private int b;

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public FractionNumber add(FractionNumber number) {
        int numerator = this.a * number.getB() + this.b * number.getA();
        int denominator = this.b * number.getB();
        FractionNumber result = new FractionNumber(numerator, denominator);
        return result;
    }

    public FractionNumber subtract(FractionNumber number) {
        int numerator = this.a * number.getB() - this.b * number.getA();
        int denominator = this.b * number.getB();
        FractionNumber result = new FractionNumber(numerator, denominator);
        return result;
    }

    public FractionNumber multiply(FractionNumber number) {
        int numerator = this.a *  number.getA();
        int denominator = this.b * number.getB();
        FractionNumber result = new FractionNumber(numerator, denominator);
        return result;
    }

    public FractionNumber divide(FractionNumber number) {
        int numerator = this.a *  number.getB();
        int denominator = this.b * number.getA();
        FractionNumber result = new FractionNumber(numerator, denominator);
        return result;
    }

    public String toString() {
        String s ="";
        if (this.getA() < this.getB()) {
            s = String.format("%d/%d", this.getA(), this.getB());
        }
        else if (this.getA() > this.getB()){
            int x = this.getA()/this.getB();
            int y = this.getA()%this.getB();
            System.out.println("X = " + x + " Y = " +y);
            s = String.format("%d %d/%d", x, y, this.getB());
        }
        if(this.getB() == 1){
            s = String.format("%d", this.getA());
        }
        if(this.getB() == 0){
            s ="DIVISION BY ZERO";
        }
        return s;
    }

    public FractionNumber(int a, int b) {
        this.a = a;
        this.b = b;

        int min = 0;
        if(a > b)
            min = b;
        else
            min = a;
        for(int i = 1; i<= min; i++){
            if(( a%i == 0)&&( b%i == 0)){
                this.a =  a/i;
                this.b = b/i;
            }
        }
        System.out.println(this.a);
        System.out.println(this.b);
    }
}

