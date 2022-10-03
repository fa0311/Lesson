class Fraction {
    int numerator;
    int denominator;

    Fraction() {
        numerator = 0;
        denominator = 1;
    }

    Fraction(int n, int d) {
        numerator = n;
        denominator = d;
    }

    public void add(Fraction f) {
        numerator = numerator * f.denominator + denominator * f.numerator;
        denominator = denominator * f.denominator;
    }

    public void add(int n) {
        numerator = numerator + denominator * n;
    }

    public void add(int numerator, int denominator) {
        this.numerator = this.numerator * denominator + this.denominator * numerator;
        this.denominator = this.denominator * denominator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }
}