/******************************************************************************
 * Compilation: mvn compile
 * Execution: `java kang.section_11model.Ex_1_1_3` in `target/classes` directory
 *
 * % echo 1 1 1| java kang.section_11model.Ex_1_1_3
 * equal
 *
 * % echo 1 2 3 | java kang.section_11model.Ex_1_1_3
 * not equal
 ******************************************************************************/

package kang.section_11model;

import algs4.StdIn;
import algs4.StdOut;

/**
 * Write a program that takes three integer command-line arguments
 * and prints equal if three are equal, and not equal otherwise.
 */
public class Ex_1_1_3 {
    public static void main(String[] args) {
        int one = StdIn.readInt();
        int two = StdIn.readInt();
        int three = StdIn.readInt();

        if (one == two && two == three) {
            StdOut.println("equal");
        } else {
            StdOut.println("not equal");
        }
    }
}
