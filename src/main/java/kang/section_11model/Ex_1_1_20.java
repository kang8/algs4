package kang.section_11model;

/**
 * Write a recursive static method that computes the value of ln(N!)
 */
public class Ex_1_1_20 {
    public static void main(String[] args) {
        int N = 10;
        System.out.println(ln(N));
    }

    private static double ln(int n) {
        if (n == 1) return 0;
        return Math.log(n) + ln(n - 1);
    }
}
