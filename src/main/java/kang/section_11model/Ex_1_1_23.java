/******************************************************************************
 * Compilation: mvn compile
 * Execution: `java kang.section_11model.Ex_1_1_23 base_file <+/-> < search_file` in `target/classes` directory
 *
 * % java kang.section_11model.Ex_1_1_23 tinyW.txt + < tinyT.txt
 * 50
 * 99
 * 13
 *
 * % java kang.section_11model.Ex_1_1_23 tinyW.txt - < tinyT.txt
 * 23
 * 10
 * 18
 * 23
 * 98
 * 84
 * 11
 * 10
 * 48
 * 77
 * 54
 * 98
 * 77
 * 77
 * 68
 ******************************************************************************/

package kang.section_11model;

import algs4.In;
import algs4.StdIn;

import java.util.Arrays;

/**
 * Add to the {@link BinarySearch} test client the ability to respond to a
 * second argument: `+` to numbers from standard input that are not int the
 * whitelist, `-` to print numbers that are in the whitelist.
 */
public class Ex_1_1_23 {
    public static void main(String[] args) {
        int[] bases = new In(args[0]).readAllInts();
        Arrays.sort(bases);

        boolean isInWhitelist = args[1].charAt(0) == '-';

        while (!StdIn.isEmpty()) {
            int search = StdIn.readInt();

            int hasFind = indexOf(bases, search);

            if (isInWhitelist) {
                if (hasFind != -1) {
                    System.out.println(search);
                }
            } else {
                if (hasFind == -1) {
                    System.out.println(search);
                }
            }
        }
    }

    private static int indexOf(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] > key) hi = mid - 1;
            else if (arr[mid] < key) lo = mid + 1;
            else return mid;
        }

        return -1;
    }
}
