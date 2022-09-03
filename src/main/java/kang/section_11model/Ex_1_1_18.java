package kang.section_11model;

/**
 * Consider the following recursive function:
 * <pre>{@code
 * public static int mystery(int a, int b)
 * {
 *     if (b == 0)     return 0;
 *     if (b % 2 == 0) return mystery(a + a, b / 2);
 *     return mystery(a + a, b / 2) + a;
 * }
 * }</pre>
 * <p>
 * What are the values of mystery(2, 25) and mystery(3, 11)? Given positive integers
 * a and b, describe what value mystery(a, b) computes. Answer the same question,
 * but replace + with * and replace return 0 with return 1.
 *
 * @Tips: 一个正整数循环除以 2，并求该正整数为奇数时的 2 的指数的和，该和等于其本身
 * <pre>{@code
 * ✔                ✔    ✔
 * 25 -> 12 -> 6 -> 3 -> 1 -> 0
 * 0  -> 1  -> 2 -> 3 -> 4
 *
 * 2^0 + 2^3 + 2^4 = 1 + 8 + 16 = 25
 *
 * ✔     ✔         ✔
 * 11 -> 5 -> 2 -> 1 -> 0
 * 0  -> 1 -> 2 -> 3
 *
 * 2^0 + 2^1 + 2^3 = 1 + 2 + 8 = 11
 * }</pre>
 */
public class Ex_1_1_18 {
    public static void main(String[] args) {
        System.out.println(mystery(2, 25)); // 50
        System.out.println(mystery(3, 11)); // 33

        System.out.println("---------------------------------------");

        System.out.println(replaceMystery(2, 25)); // 33554432
        System.out.println(replaceMystery(3, 11)); // 177147
    }

    /**
     * @return a * b
     */
    public static int mystery(int a, int b) {
        if (b == 0) return 0;
        if (b % 2 == 0) return mystery(a + a, b / 2);
        return mystery(a + a, b / 2) + a;
    }

    /**
     * @return a ^ b
     */
    public static int replaceMystery(int a, int b) {
        if (b == 0) return 1;
        if (b % 2 == 0) return replaceMystery(a * a, b / 2);
        return replaceMystery(a * a, b / 2) * a;
    }
}
