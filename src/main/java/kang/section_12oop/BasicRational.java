package kang.section_12oop;

final public class BasicRational {
    private final long numerator;
    private final long denominator;

    public BasicRational(long numerator, long denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Denominator is 0.");
        }

        if (denominator < 0) {
            denominator = -denominator;
            numerator   = -numerator;
        }

        long gcd = gcd(numerator, denominator);
        if (gcd > 1) {
            numerator /= gcd;
            denominator /= gcd;
        }

        this.numerator   = numerator;
        this.denominator = denominator;
    }

    public BasicRational plus(BasicRational b) {
        long lcm = lcm(this.denominator, b.denominator);

        long numerator = (this.numerator * (lcm / this.denominator)) + (b.numerator * (lcm / b.denominator));

        return new BasicRational(numerator, lcm);
    }

    public BasicRational minus(BasicRational b) {
        return this.plus(new BasicRational(-b.numerator, b.denominator));
    }

    public BasicRational times(BasicRational b) {
        long numerator   = this.numerator * b.numerator;
        long denominator = this.denominator * b.denominator;

        return new BasicRational(numerator, denominator);
    }

    public BasicRational divides(BasicRational b) {
        return this.times(new BasicRational(b.denominator, b.numerator));
    }

    private long gcd(long numerator, long denominator) {
        if (numerator < 0) numerator = -numerator;
        if (denominator < 0) denominator = -denominator;

        if (denominator == 0) return numerator;

        return gcd(denominator, numerator % denominator);
    }

    private long lcm(long numerator, long denominator) {
        return numerator * denominator / gcd(numerator, denominator);
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (this.getClass() != other.getClass()) return false;

        BasicRational that = (BasicRational) other;

        if (this.numerator != that.numerator) return false;
        if (this.denominator != that.denominator) return false;

        return true;
    }

    public String toString() {
        if (denominator == 1) {
            return numerator + "";
        }
        return numerator + "/" + denominator;
    }
}
