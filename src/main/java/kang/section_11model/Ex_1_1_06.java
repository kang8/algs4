package kang.section_11model;

import algs4.StdOut;

/**
 * What does the following program print?
 * <pre>{@code
 * int f = 0;
 * int g = 0;
 * for (int i = 0; i<= 15; i++)
 * {
 *     StdOut.println(f);
 *     f = f + g;
 *     g = f - g;
 * }
 * }</pre>
 */
public class Ex_1_1_06 {
    public static void main(String[] args) {
        int f = 0;
        int g = 1;
        /**
         * It is Fibonacci https://en.wikipedia.org/wiki/Fibonacci_number
         */
        for (int i = 0; i <= 15; i++) {
            StdOut.println(f); // 0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610
            f = f + g;
            g = f - g;
        }
    }
}
