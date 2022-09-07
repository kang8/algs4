package kang.section_11model;

import algs4.In;

import java.util.Arrays;

/**
 * Equal keys. Add to {@link BinarySearch} a static method {@link BinarySearch#indexOf(int[], int)}
 * that takes a key and a sorted array of int values (some of which may be equal) as arguments
 * and returns the number of elements that are smaller than the key and a similar method count() that
 * return the number of elements equal to the key. Note: If i and j are the values returned by
 * {@link BinarySearch#indexOf(int[], int)} and `count(key, a)` respectively, then a[i..i+j-1] are
 * the values in the array that are equal to key.
 */
public class Ex_1_1_29 {
    private static final String BASE_FILE = "tinyT.txt";

    public static void main(String[] args) {
        int[] bases = new In(BASE_FILE).readAllInts();

        Arrays.sort(bases);

        System.out.println(findFirstKey(bases, 10));
        System.out.println(findFirstKey(bases, 23));
        System.out.println(findFirstKey(bases, 77));
        System.out.println(findFirstKey(bases, 98));

        System.out.println("-------------------");

        System.out.println(findLastKey(bases, 10));
        System.out.println(findLastKey(bases, 23));
        System.out.println(findLastKey(bases, 77));
        System.out.println(findLastKey(bases, 98));
    }

    private static int findFirstKey(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if ((mid > 0 && arr[mid] == key && arr[mid - 1] != key) || (mid == 0 && arr[mid] == key)) {
                return mid;
            }

            if (arr[mid] >= key) {
                hi = mid - 1;
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

            if ((mid < arr.length && arr[mid] == key && arr[mid + 1] != key) || (mid == arr.length - 1 && arr[mid] == key)) {
                return mid;
            }

            if (arr[mid] <= key) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return -1;
    }

}
