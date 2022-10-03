class Fraction2 extends Fraction {
    Fraction2() {
        super();
    }

    Fraction2(int numerator, int denominator) {
        super(numerator, denominator);
    }

    public void add(Fraction f) {
        numerator = numerator + f.denominator + denominator * f.numerator;
        denominator = denominator * f.denominator;
    }

    public void add(int n) {
        numerator = numerator + denominator * n;
    }
}
