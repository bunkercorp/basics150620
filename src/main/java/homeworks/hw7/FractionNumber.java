package homeworks.hw7;

import java.math.BigInteger;

public class FractionNumber {

        public FractionNumber(long devident, long divisor) {

            long gcd = this._gcd(divisor, devident);

            this.devident = gcd != 0 ? devident / gcd : 0;
            this.divisor  = gcd != 0 ? divisor  / gcd : 0;
        }

        public long devident, divisor;

        public FractionNumber add(FractionNumber fraction) {
            return _math(fraction, Operation.ADD);
        }

        public FractionNumber substract(FractionNumber fraction) {
            return _math(fraction, Operation.SUBSTRACT);
        }

        public FractionNumber multiply(FractionNumber fraction) {
            return _math(fraction, Operation.MULTIPLY);
        }

        public FractionNumber devide(FractionNumber fraction) {
            return _math(fraction, Operation.DEVIDE);
        }

        @Override
        public String toString() {
            if (this.divisor == 0) return "DIVISION BY ZERO";
            if (this.divisor == 1) return String.valueOf(devident);
            if (this.divisor > this.devident)
                return String.format("%d/%d", this.devident, this.divisor);
            else
                return String.format("%d %d/%d",
                        this.devident / this.divisor,
                        this.devident % this.divisor,
                        this.divisor
                );
        }

        private enum Operation {
            ADD,
            SUBSTRACT,
            MULTIPLY,
            DEVIDE
        }

        private FractionNumber _math(FractionNumber fraction, Operation op) {

            if (fraction == null)
                return new FractionNumber(this.devident, this.divisor);


            long newDivisor  = this.divisor,
                    newDevident = this.devident,
                    secDevident = fraction.devident;

            if (newDivisor != fraction.divisor && op != Operation.DEVIDE) {
                if (op != Operation.MULTIPLY) {
                    newDevident *= fraction.divisor;
                    secDevident *= this.divisor;
                }
                newDivisor *= fraction.divisor;
            }


            switch(op) {
                case ADD      : newDevident += secDevident; break;
                case SUBSTRACT: newDevident -= secDevident; break;
                case MULTIPLY : newDevident *= secDevident; break;
                case DEVIDE   : newDevident *= fraction.divisor;
                    newDivisor  *= secDevident; break;
            }

            return new FractionNumber(newDevident, newDivisor);
        }

        private long _gcd(long divisor, long devident) {
            return BigInteger
                    .valueOf(divisor)
                    .gcd(BigInteger.valueOf(devident))
                    .longValue();
        }
    }
