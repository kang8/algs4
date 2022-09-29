package kang.section_12oop;

import algs4.StdOut;

/**
 * Rational numbers(有理数). Implement an immutable data type {@link BasicRational} for rational numbers
 * that supports addition, subtraction, multiplication, and division.
 * <pre>{@code
 * public interface Rational {
 *     Rational(int numerator, int denominator)
 *     Rational plus(Rational b) // sum of this number and b
 *     Rational minus(Rational b) // difference of this number and b
 *     Rational times(Rational b) // product of this number and b
 *     Rational divides(Rational b) // quotient of this number and b
 *     boolean equals(Rational that) // is this number equal to that?
 *     String toString() // string representation
 * }
 * }</pre>
 * You do not have to worry about testing for overflow (see {@link Ex_1_2_17}), but use as instance
 * variables two long values that represent the numerator and denominator to limit the
 * possibility of overflow. Use Euclid's algorithm (see page 4) to ensure that the numerator and
 * denominator never have any common factors, Include a test client that exercises all of your
 * methods.
 */
public class Ex_1_2_16 {
    public static void main(String[] args) {
        BasicRational x, y, z;

        // 1/2 + 1/3 = 5/6
        x = new BasicRational(1, 2);
        y = new BasicRational(1, 3);
        z = x.plus(y);
        StdOut.println(z);

        // 8/9 + 1/9 = 1
        x = new BasicRational(8, 9);
        y = new BasicRational(1, 9);
        z = x.plus(y);
        StdOut.println(z);

        // 1/200000000 + 1/300000000 = 1/120000000
        x = new BasicRational(1, 200000000);
        y = new BasicRational(1, 300000000);
        z = x.plus(y);
        StdOut.println(z);

        // 1073741789/20 + 1073741789/30 = 1073741789/12
        x = new BasicRational(1073741789, 20);
        y = new BasicRational(1073741789, 30);
        z = x.plus(y);
        StdOut.println(z);

        //  4/17 * 17/4 = 1
        x = new BasicRational(4, 17);
        y = new BasicRational(17, 4);
        z = x.times(y);
        StdOut.println(z);

        // 3037141/3247033 * 3037547/3246599 = 841/961
        x = new BasicRational(3037141, 3247033);
        y = new BasicRational(3037547, 3246599);
        z = x.times(y);
        StdOut.println(z);

        // 1/6 - -4/-8 = -1/3
        x = new BasicRational(1, 6);
        y = new BasicRational(-4, -8);
        z = x.minus(y);
        StdOut.println(z);
    }
}
