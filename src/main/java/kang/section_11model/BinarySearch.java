/******************************************************************************
 * Compilation: mvn compile
 * Execution: `java kang.section_11model.BinarySearch base_file < search_file` in `target/classes` directory
 *
 * % java kang.section_11model.BinarySearch tinyW.txt < tinyT.txt
 * 50
 * 99
 * 13
 ******************************************************************************/

package kang.section_11model;

import algs4.In;
import algs4.StdIn;
import algs4.StdOut;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] whitelist = new In(args[0]).readAllInts();

        Arrays.sort(whitelist);

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (indexOf(whitelist, key) == -1) {
                StdOut.println(key);
            }
        }
    }

    private static int indexOf(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < arr[mid]) {
                hi = mid - 1;
            } else if (key > arr[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
