package kang.section_11model;

import algs4.StdOut;

/**
 * Run the following program on you computer:
 * <pre>{@code
 * public class Fibonacci
 * {
 *     public static long F(int N)
 *     {
 *         if (N == 0) return 0;
 *         if (N == 1) return 1;
 *         return F(N - 1) + F(N - 2);
 *     }
 *
 *     public static void main(String[] args)
 *     {
 *         for (int N = 0; N < 100; N++)
 *             StdOut.println(N + " " + F(N));
 *     }
 * }
 * }</pre>
 * <p>
 * What is the largest value of N for which this program takes less 1 hour to compute the
 * value of F(N)? Develop a better implementation of F(N) that saves computed values in
 * an array.
 *
 * @Answer 我的电脑在 java 环境中一秒钟可以跑 4e8 次，一个小时可以跑 60 * 60 * 4e8 ~= 1e12 次
 * F(59) 执行的次数为 956722026041  ~= 9e11 次;
 * F(60) 执行的次数为 1548008755920 ~= 1e12 次;
 * 所以，在我电脑上， F(60) 是最小一个至少需要跑一个小时的数字。
 */
public class Ex_1_1_19 {
    public static void main(String[] args) {
        for (int N = 0; N < 70; N++) {

            long before = System.currentTimeMillis();
            StdOut.print(N + " " + F(N));
            long after = System.currentTimeMillis();

            long interval = (after - before) / 1000;
            StdOut.println(" " + interval + "s");
        }
    }

    public static long F(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N - 1) + F(N - 2);
    }

    public static long fastF(int N) {
        int a = 0;
        int b = 1;

        for (int i = 0; i < N; i++) {
            a = a + b;
            b = a - b;
        }

        return a;
    }


}
