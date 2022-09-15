package kang.section_11model;

import algs4.In;

/**
 * Binary search versus brute-force search. Write a program BruteForceSearch that
 * use the brute-force search method given on page 48 and compare its running time
 * on your computer with that of BinarySearch for LargeW.txt and LargeT.txt
 *
 * @Conclusion: 在 MacBook M1 Pro 32G 上，brute-force 需要跑 782s 左右。
 */
public class Ex_1_1_38 {
    private static final String BASE_FILE = "largeW.txt";
    private static final String SEARCH_FILE = "largeT.txt";

    public static void main(String[] args) {
        int[] bases = new In(BASE_FILE).readAllInts();
        int[] searches = new In(SEARCH_FILE).readAllInts();

        int sum = 0;
        long before = System.currentTimeMillis();

        for (int search : searches) {
            if (indexOf(bases, search) == -1) {
                sum++;
            }
        }

        long after = System.currentTimeMillis();

        long interval = (after - before) / 1000;

        System.out.println("Interval: " + interval + "s");
    }

    private static int indexOf(int[] bases, int search) {
        for (int i = 0; i < bases.length; i++) {
            if (bases[i] == search) return i;
        }

        return -1;
    }
}
