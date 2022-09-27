package kang.section_12oop;

import algs4.In;

import java.util.Arrays;

/**
 * Instrument {@link kang.section_11model.BinarySearch} to use {@link Counter} to count the
 * total number of keys examined during all searches and then print the total after all searches
 * are complete. Hint: Create a {@link Counter} in main() and pass it as an argument to indexOf()
 */
public class Ex_1_2_09 {
    private static final String BASE_FILE = "tinyW.txt";

    public static void main(String[] args) {
        int[] bases = new In(BASE_FILE).readAllInts();
        Arrays.sort(bases);

        Counter count = new Counter("count by BinarySearch");

        if (indexOf(bases, 12, count) != -1) {
            System.out.println("find it");
        } else {
            System.out.println("not find it");
        }

        System.out.println(count);
    }

    private static int indexOf(int[] bases, int search, Counter count) {
        int lo = 0;
        int hi = bases.length - 1;

        while (hi >= lo) {
            count.increment();

            int mid = lo + (hi - lo) / 2;

            if (bases[mid] > search) hi = mid - 1;
            else if (bases[mid] < search) lo = mid + 1;
            else return mid;
        }

        return -1;
    }
}
