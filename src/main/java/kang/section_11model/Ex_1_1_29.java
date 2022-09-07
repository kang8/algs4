package kang.section_11model;

import algs4.In;

import java.util.Arrays;

/**
 * Equal keys. Add to {@link BinarySearch} a static method {@link #rank(int[], int)}
 * that takes a key and a sorted array of int values (some of which may be equal) as arguments
 * and returns the number of elements that are smaller than the key and a similar method {@link #count(int[], int)} that
 * return the number of elements equal to the key. Note: If i and j are the values returned by
 * {@link #rank(int[], int)} and {@link #count(int[], int)} respectively, then a[i..i+j-1] are
 * the values in the array that are equal to key.
 */
public class Ex_1_1_29 {
    private static final String BASE_FILE = "tinyT.txt";

    public static void main(String[] args) {
        int[] bases = new In(BASE_FILE).readAllInts();
        int key = 77;

        Arrays.sort(bases);

        int indexOf = rank(bases, key);
        int count = count(bases, key);

        for (int i = 0; i <= count; i++) {
            System.out.println(bases[i + indexOf + 1]);
        }
    }

    private static int rank(int[] arr, int key) {
        int indexOfFirstKey = findFirstKey(arr, key);
        return indexOfFirstKey == 0 ? 0 : indexOfFirstKey - 1;
    }

    private static int count(int[] arr, int key) {
        return findLastKey(arr, key) - findFirstKey(arr, key);
    }

    private static int findFirstKey(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] > key) {
                hi = mid - 1;
            } else if (arr[mid] == key) {
                if ((mid == 0) || (arr[mid - 1] != key)) return mid;
                else hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return -1;
    }

    private static int findLastKey(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] < key) {
                lo = mid + 1;
            } else if (arr[mid] == key) {
                if (mid == arr.length - 1 || arr[mid + 1] != key) return mid;
                else lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return -1;
    }
}
