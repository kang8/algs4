package kang.section_11model;

import algs4.StdRandom;

import java.util.Arrays;

/**
 * Random matches. Write a BinarySearch client that takes an int value T as
 * command-line argument and runs T trials of the following experiment for
 * N = 10<sup>3</sup>, 10<sup>4</sup>, 10<sup>5</sup>, and 10<sup>6</sup>:
 * generate two arrays of N randomly generated positive six-digit int values,
 * and find the number of values that appear in both arrays. Print a table
 * giving the average value of this quantity over the T trials for each value
 * of N.
 */
public class Ex_1_1_39 {
    public static void main(String[] args) {
        int T = 100;
        int[] N = {(int) 1e3, (int) 1e4, (int) 1e5, (int) 1e6};

        double[] averageValueByN = new double[N.length];

        for (int nTrial = 0; nTrial < N.length; nTrial++) {
            int[] findTSums = new int[T];
            for (int tTrial = 0; tTrial < T; tTrial++) {

                int[] bases = generateRandomlyArray(N[nTrial]);
                int[] searches = generateRandomlyArray(N[nTrial]);

                Arrays.sort(bases);
                Arrays.sort(searches);


                for (int search : searches) {
                    if (indexOf(bases, search) != -1) {
                        findTSums[tTrial]++;
                    }
                }
            }

            double sumOfTTrial = 0;

            for (int tSun : findTSums) {
                sumOfTTrial += tSun;
            }

            averageValueByN[nTrial] = sumOfTTrial / T;
        }

        System.out.println(Arrays.toString(averageValueByN));
        // will output: [0.52, 65.89, 7073.73, 496878.12]
    }

    private static int indexOf(int[] bases, int search) {
        int lo = 0;
        int hi = bases.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (bases[mid] > search) hi = mid - 1;
            else if (bases[mid] < search) lo = mid + 1;
            else return mid;
        }

        return -1;
    }

    private static int[] generateRandomlyArray(int len) {
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            res[i] = StdRandom.uniformInt(100000, 1000000);
        }

        return res;
    }
}
