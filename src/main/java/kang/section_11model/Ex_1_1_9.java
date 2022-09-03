package kang.section_11model;

import algs4.StdIn;
import algs4.StdOut;

/**
 * Write a code fragment that puts the binary representation of a positive integer N
 * into a String s.
 * <p></p>
 *
 * @Solution: java has a built-in method {@link Integer#toBinaryString(int)} for the job, but
 * the point for the exercise is to see how such a method might be implemented. Here is a
 * particularly concise solution:
 *
 * <pre>{@code
 * String s = "";
 * for (int n = N; n > 0; n /= 2)
 *     s = (n % 2) + s;
 * }</pre>
 */
public class Ex_1_1_9 {
    public static void main(String[] args) {
        int n = StdIn.readInt();

        String binary = toBinaryString(n);

        StdOut.println(binary);
    }

    private static String toBinaryString(int n) {
        String result = "";

        for (; n > 0; n >>>= 1) {
            result = (n & 1) + result;
        }

        return result;
    }
}
