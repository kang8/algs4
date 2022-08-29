package kang.section_11model;

import algs4.StdIn;
import algs4.StdOut;

public class Ex_1_1_9 {
    public static void main(String[] args) {
        int n = StdIn.readInt();

        String binary = toBinaryString(n);

        StdOut.println(binary);
    }

    private static String toBinaryString(int n) {
        String result = "";

        for (; n > 0; n /= 2) {
            int i = n % 2;
            result = i + result;
        }

        return result;
    }
}
