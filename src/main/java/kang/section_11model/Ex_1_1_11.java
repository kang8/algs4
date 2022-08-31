package kang.section_11model;

import algs4.StdOut;
import algs4.StdRandom;

/**
 * Write a code fragment that prints the contents of a two-dimensional boolean
 * array, using * to represent true and a space to represent false. Include row
 * and column numbers.
 */
public class Ex_1_1_11 {
    public static void main(String[] args) {
        boolean[][] arr = getRandomBooleanArray(10, 10);

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                StdOut.print("  ");
                for (int x = 0; x < arr[i].length; x++) {
                    StdOut.print((x + 1) + " ");
                }
                StdOut.println();
            }
            for (int j = 0; j < arr[i].length; j++) {
                if (j == 0) {
                    StdOut.print(i + 1 + " ");
                }

                StdOut.print((arr[i][j] ? "* " : "  "));
                if (j == arr[i].length - 1) {
                    if (i == arr.length - 1) {
                        continue;
                    }
                    StdOut.println();
                }
            }
        }
    }

    private static boolean[][] getRandomBooleanArray(int N, int M) {
        boolean[][] randomBoolean = new boolean[N][M];

        for (int i = 0; i < randomBoolean.length; i++) {
            for (int j = 0; j < randomBoolean[i].length; j++) {
                randomBoolean[i][j] = StdRandom.bernoulli();
            }
        }

        return randomBoolean;
    }
}
