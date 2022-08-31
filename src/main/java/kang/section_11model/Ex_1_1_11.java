package kang.section_11model;

import algs4.StdOut;
import algs4.StdRandom;

/**
 * Write a code fragment that prints the contents of a two-dimensional boolean
 * array, using * to represent true and a space to represent false. Include row
 * and column numbers.
 *
 * @Tips: 可以使用 {@link StdOut#printf(String, Object...)} 中的 format 来减轻格式化负担
 */
public class Ex_1_1_11 {
    public static void main(String[] args) {
        boolean[][] arr = getRandomBooleanArray(10, 10);

        StdOut.printf("%6d", 1);
        for (int x = 1; x < arr.length; x++) {
            StdOut.printf("%3d", x + 1);
        }
        StdOut.println();

        for (int i = 0; i < arr.length; i++) {
            StdOut.printf("%3d", i + 1);
            for (int j = 0; j < arr[i].length; j++) {
                StdOut.printf("%3s", (arr[i][j] ? "*" : " "));
            }
            StdOut.println();
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
