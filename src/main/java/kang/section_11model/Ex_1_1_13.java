package kang.section_11model;

import algs4.StdOut;

/**
 * Write a code fragment to print the transposition(rows and columns changed)
 * of a two-dimensional array with M rows and N columns.
 */
public class Ex_1_1_13 {
    public static void main(String[] args) {
        /*
        [
            [1, 2, 3],
            [4, 5, 6],
            [7, 8, 9]
        ]
         */
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (j >= i) continue;

                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }

        /*
        [
            [1, 4, 7],
            [2, 5, 8],
            [3, 6, 9]
        ]
         */
        for (int[] arr : a) {
            for (int x : arr) {
                StdOut.printf("%2d", x);
            }
            StdOut.println();
        }
    }
}
