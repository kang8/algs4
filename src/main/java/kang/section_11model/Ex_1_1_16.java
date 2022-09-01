package kang.section_11model;

import algs4.StdOut;

/**
 * Give the value of exR1(6):
 * <pre>{@code
 * public static String exR1(int n)
 * {
 *     if (n <= 0) return "";
 *     return exR1(n - 3) + n + exR1(n - 2) + n;
 * }
 * }</pre>
 * exR1(6) will output: 311361142246
 */
public class Ex_1_1_16 {
    public static void main(String[] args) {
        StdOut.println(exR1(6));
    }

    public static String exR1(int n) {
        if (n <= 0) return "";
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }
}
