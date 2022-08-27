package kang.section_11model;

import algs4.StdOut;

public class Ex_1_1_7 {
    public static void main(String[] args) {
        {
            double t = 9.0;
            while (Math.abs(t - 9.0 / t) > .001) {
                t = (9.0 / t + t) / 2.0;
            }
            StdOut.printf("%.5f\n", t); // 3.0009

        }

        StdOut.println("-------------------------------------");

        {
            int sum = 0;
            /*
              Arithmetic progression: https://en.wikipedia.org/wiki/Arithmetic_progression
              ((0 + 999) * 1000) / 2
             */
            for (int i = 0; i < 1000; i++) {
                for (int j = 0; j < i; j++) {
                    sum++;
                }
            }
            StdOut.println(sum); // 49500

        }

        StdOut.println("-------------------------------------");

        {
            int sum = 0;
            /*
              sum = (1 + (int)log2(1000)) * 1000

              log base 2 of 1000 calculate in java:
              Math.log(1000) / Math.log(2) // 9.965784284662087
             */
            for (int i = 1; i < 1000; i *= 2) {
                for (int j = 0; j < 1000; j++) {
                    sum++;
                }
            }
            StdOut.println(sum); // 10000
        }
    }
}
