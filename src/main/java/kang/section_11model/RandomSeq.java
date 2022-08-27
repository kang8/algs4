package kang.section_11model;

import algs4.StdOut;
import algs4.StdRandom;

public class RandomSeq {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        if (args.length == 1) {
            for (int i = 0; i < N; i++) {
                double random = StdRandom.uniformDouble(0.0, 1.0);
                StdOut.println(random);
            }
        } else if (args.length == 3) {
            double lo = Double.parseDouble(args[1]);
            double hi = Double.parseDouble(args[2]);

            for (int i = 0; i < N; i++) {
                double random = StdRandom.uniformDouble(lo, hi);
                StdOut.printf("%.2f\n", random);
            }
        } else {
            throw new IllegalArgumentException("Invalid number of arguments");
        }
    }
}
