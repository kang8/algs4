package kang.section_11model;

import algs4.In;

import java.util.Arrays;

/**
 * Remove duplicates. Modify the test client in {@link BinarySearch} to remove
 * and duplicate keys in the whitelist after the sort.
 */
public class Ex_1_1_28 {
    private static final String BASE_FILE = "tinyT.txt";

    public static void main(String[] args) {
        int[] bases = new In(BASE_FILE).readAllInts();

        Arrays.sort(bases);

        int[] removeDuplicate = removeDuplicate(bases);

        System.out.println(Arrays.toString(removeDuplicate));
    }

    private static int[] removeDuplicate(int[] arr) {
        int[] whitelist = new int[arr.length];
        int whitelistLen = 0;

        whitelist[whitelistLen++] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int previous = arr[i - 1];
            int current = arr[i];

            if (previous == current) {
                continue;
            }

            whitelist[whitelistLen++] = current;
        }

        return whitelist;
    }
}
