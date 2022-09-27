package kang.section_12oop;

import algs4.In;

import java.util.Arrays;

/**
 * File input. Develop a possible implementation of the static {@code readInts()} method from
 * {@link algs4.In}(which we use for various test clients, such as binary search on page 47) that
 * is based on the {@link String#split(String)} method in {@link String}
 */
public class Ex_1_2_15 {
    public static void main(String[] args) {
        String fileName = "tinyT.txt";

        int[] values = readInts(fileName);

        System.out.println(Arrays.toString(values));
    }

    private static int[] readInts(String fileName) {
        In in = new In(fileName);
        String wholeFile = in.readAll();
        String[] words = wholeFile.split("\\s+");

        int[] res = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            res[i] = Integer.parseInt(words[i]);
        }

        return res;
    }
}
