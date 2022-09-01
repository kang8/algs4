package kang.section_11model;

import algs4.StdOut;

/**
 * Write a static method histogram() that takes an array a[] of int values and
 * an integer M as arguments and returns an array of length M whose ith entry is
 * the number of times the integer i appeared in the argument array. If the values
 * in a[] are all between 0 and M-1, the sum of the values in the returned array
 * should be equal to a.length
 */
public class Ex_1_1_15 {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 3, 2, 1, 7, 5, 3, 0};
        int M = 10;

        int[] histogram = histogram(arr, M);

        for (int n : histogram) {
            StdOut.printf("%2d", n);
        }
    }

    public static int[] histogram(int[] a, int M) {
        int[] res = new int[M];

        for (int n : a) {
            res[n]++;
        }

        return res;
    }
}
