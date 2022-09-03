package kang.section_11model;

import algs4.In;

import java.util.Arrays;

/**
 * Write a version of {@link BinarySearch} that uses the recursive
 * {@link BinarySearch#indexOf(int[], int)} given on page 25 and traces
 * the method calls. Each time the recursive method is called, print the
 * argument values lo and hi, indented by the depth of the recursion.
 * Hint: Add an argument to the recursive method that keeps track of the depth.
 */
public class Ex_1_1_22 {

    private static final String BASE_FILE = "tinyW.txt";
    private static final String SEARCH_FILE = "tinyT.txt";

    public static void main(String[] args) {
        int[] bases = new In(BASE_FILE).readAllInts();
        int[] searches = new In(SEARCH_FILE).readAllInts();

        Arrays.sort(bases);

        for (int search : searches) {
            if (indexOf(bases, search, 0, bases.length - 1, 1) == -1) {
                System.out.printf("Can't find %d.\n", search);
            } else {
                System.out.println("Find it.");
            }
        }
    }

    private static int indexOf(int[] arr, int key, int lo, int hi, int depth) {
        System.out.printf("%" + depth + "s%d %d\n", "", lo, hi, depth);

        if (lo > hi) return -1;

        int mid = lo + (hi - lo) / 2;

        if (arr[mid] < key) return indexOf(arr, key, mid + 1, hi, depth + 1);
        else if (arr[mid] > key) return indexOf(arr, key, lo, mid - 1, depth + 1);
        else return mid;
    }
}
