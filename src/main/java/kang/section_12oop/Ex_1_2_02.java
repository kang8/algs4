package kang.section_12oop;

import algs4.StdRandom;

/**
 * Write an {@link Interval1D} client that takes an int value N as command-line
 * argument, reads N intervals(each defined by a pair of double values)
 * from standard input, and prints all pairs that intersect.
 */
public class Ex_1_2_02 {
    private static final int MAX_INTERVAL = 1000;

    public static void main(String[] args) {
        int N = 20;

        Interval1D[] intervals = new Interval1D[N];

        for (int i = 0; i < N; i++) {
            double first = StdRandom.uniformInt(0, MAX_INTERVAL);
            double second = StdRandom.uniformInt(0, MAX_INTERVAL);
            intervals[i] = new Interval1D(Math.min(first, second), Math.max(first, second));
        }

        for (int from = 0; from < N; from++) {
            for (int to = from + 1; to < N; to++) {
                if (intervals[from].intersects(intervals[to])) {
                    System.out.println(intervals[from] + " intersect with: " + intervals[to]);
                }
            }
            System.out.println();
        }
    }
}
