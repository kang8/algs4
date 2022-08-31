package kang.section_11model;

/**
 * What is wrong with the following code fragment?
 * <pre>{@code
 * int[] a;
 * for (int i = 0; i < 10; i++)
 *     a[i] = i * i;
 * }</pre>
 *
 * @Solution: It does not allocate memory for a[] with new. This code results in a
 * `variable a might not have been initialized` compile-time error.
 */
public class Ex_1_1_10 {
    public static void main(String[] args) {
        /*
         * 没有初始化数组
         */
        int[] a;
        for (int i = 0; i < 10; i++)
            a[i] = i * i;
    }
}
