package kang.section_11model;

import algs4.StdRandom;

import java.util.Arrays;

/**
 * Empirical shuffle check. Run computational experiments to check that our
 * shuffling code on page 32 works as advertised. Write a program ShuffleTest
 * that takes command-line arguments M and N, does N shuffles of an array of
 * size M that is initialized with a[i] = i before each shuffle, and prints an
 * M-by-M table such that row i gives the number of times i wound up in position
 * j for all j. All entries in the array should be close to N/M.
 */
public class Ex_1_1_36 {
    public static void main(String[] args) {
        int M = 10;
        int N = 10000;

        int[] m_arr = new int[M];
        int[][] check = new int[M][M];

        for (int i = 0; i < N; i++) {
            init(m_arr);

            shuffle(m_arr);

            for (int o = 0; o < m_arr.length; o++) {
                check[m_arr[o]][o]++;
            }
        }

        for (int[] c : check) {
            System.out.println(Arrays.toString(c));
        }
    }

    private static void shuffle(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            // NOTE: [i, N - 1]
            int r = i + StdRandom.uniformInt(len - i);
            int temp = arr[i];
            arr[i] = arr[r];
            arr[r] = temp;
        }
    }

    private static void init(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }
}
