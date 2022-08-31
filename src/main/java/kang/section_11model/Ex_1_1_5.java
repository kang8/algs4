/******************************************************************************
 * Compilation: mvn compile
 * Execution: `java kang.section_11model.Ex_1_1_5` in `target/classes` directory
 *
 * % echo 0.4 0.7 | java kang.section_11model.Ex_1_1_5
 * true
 *
 * % echo 0.4 1.6 | java kang.section_11model.Ex_1_1_5
 * false
 ******************************************************************************/

package kang.section_11model;

import algs4.StdIn;
import algs4.StdOut;

/**
 * Write a code fragment that prints true if the double variables x and y are both strictly
 * between 0 and 1 and false otherwise.
 */
public class Ex_1_1_5 {
    public static void main(String[] args) {
        double x = StdIn.readDouble();
        double y = StdIn.readDouble();

        StdOut.println(isBetween0And1(x) && isBetween0And1(y));
    }

    private static boolean isBetween0And1(double value) {
        return value >= 0.0 && value <= 1.0;
    }
}
