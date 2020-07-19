package homeworks.hw7;

public class FractionNumber {
    int numerator;
    int denominator;

    FractionNumber (int numer, int denom) {
        this.numerator = numer;
        this.denominator = denom;
        int signN=(numer<0) ? -1:1;
        int signD=(denom<0) ? -1:1;
        numer=numer*signN;
        denom=denom*signD;
        if (denom != 0 && numer!=0){ //if zero - in toString
            while (numer != denom) {
                if (numer > denom) {
                    numer = numer - denom;
                } else {
                    denom = denom - numer;
                }
            }
            numerator = numerator / numer;
            denominator = denominator / numer;
        }
        if (signN!=-1 && signD==-1){
            numerator=-numerator;
            denominator=-denominator;
        }
        if (signN==-1 && signD==-1){
            numerator=-numerator;
            denominator=-denominator;
        }
    }

    FractionNumber add(FractionNumber a){
        int numer=this.numerator*a.denominator + a.numerator*this.denominator;
        int denom=this.denominator*a.denominator;
        FractionNumber b=new FractionNumber(numer,denom);
        return b;
    }

    FractionNumber subtract(FractionNumber a){
        int numer=this.numerator*a.denominator - a.numerator*this.denominator;
        int denom=this.denominator*a.denominator;
        FractionNumber b=new FractionNumber(numer,denom);
        return b;
    }

    FractionNumber multiply(FractionNumber a){
        int numer=this.numerator*a.numerator;
        int denom=this.denominator*a.denominator;
        FractionNumber b=new FractionNumber(numer,denom);
        return b;
    }

    FractionNumber divide(FractionNumber a){
        //zero in toString
        int numer = this.numerator * a.denominator;
        int denom = this.denominator * a.numerator;
        FractionNumber b=new FractionNumber(numer,denom);
        return b;
    }

    @Override
    // change to switch
    public String toString(){
        int signN=(numerator<0) ? -1:1; //if have minus
        if (denominator==0) return ("DIVISION BY ZERO");
        if (denominator==1 || numerator==0) return String.format("%d",numerator);
        if (denominator>numerator*signN) return String.format("%d/%d",numerator,denominator);
        if ((numerator*signN)>denominator) {
            int a=numerator/denominator*signN;
            int b=numerator%denominator;
            return String.format("%d %d/%d", a*signN, b, denominator);
        }
        return "";
    }
}
