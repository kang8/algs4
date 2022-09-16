package kang.section_11model;

import algs4.StdRandom;

import java.util.Arrays;

/**
 * Bad shuffling. Suppose that you choose a random integer between 0 and N - 1
 * in our shuffling code instead of one between i and N - 1. Show that the resulting
 * order is not equally likely to be one of the N! possibilities. Run the test of the
 * previous exercise for this version.
 */
public class Ex_1_1_37 {
    public static void main(String[] args) {
        int M = 10;
        int N = 10000;

        int[] m_arr = new int[M];
        int[][] badCheck = new int[M][M];

        for (int i = 0; i < N; i++) {
            init(m_arr);

            badShuffle(m_arr);

            for (int o = 0; o < m_arr.length; o++) {
                badCheck[m_arr[o]][o]++;
            }
        }

        for (int[] c : badCheck) {
            System.out.println(Arrays.toString(c));
        }
    }

    private static void badShuffle(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            // NOTE: [0, N - 1]
            int r = StdRandom.uniformInt(len);
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
