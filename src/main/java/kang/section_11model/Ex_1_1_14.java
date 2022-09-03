package kang.section_11model;

/**
 * Write a static method lg() that takes an int value N as argument and returns
 * the largest int not larger than the base-2 logarithm of N. Do not use Math.
 */
public class Ex_1_1_14 {
    public static void main(String[] args) {
        System.out.println(lg(1));   // 0
        System.out.println(lg(7));   // 2
        System.out.println(lg(8));   // 3
        System.out.println(lg(9));   // 3
        System.out.println(lg(100)); // 7
    }

    public static int lg(int N) {
        if (N <= 1) return 0;

        int i = 1;
        int temp = 2;

        while (N >= temp) {
            temp *= 2;
            i++;
        }
        return i - 1;
    }
}
