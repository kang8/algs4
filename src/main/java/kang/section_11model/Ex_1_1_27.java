package kang.section_11model;

import java.util.Arrays;

/**
 * Binomial distribution. Estimate the number of recursive calls that
 * would be use by the code
 * <pre>{@code
 * public static double binomial(int N, int k, double p)
 * {
 *     if (N == 0 && k == 0) return 1.0;
 *     if (N < 0 || k < 0) return 0.0;
 *     return (1.0 - p) * binomial(N-1, k, p) + p * binomial(N-1, k-1, p);
 * }
 * }</pre>
 * to compute binomial(100, 50, 0.25). Develop a better implementation that is based
 * on saving computed values in an array.
 *
 * @Answer binomial(100, 50, 0.25) 的总调用次数大概为 2^100
 */
public class Ex_1_1_27 {


    public static void main(String[] args) {
        int N = 10, k = 5;
        double p = 0.25;

        double slowBinomial = slowBinomial(N, k, p);
        double fastBinomial = fastBinomial(N, k, p);

        double[][] arr = new double[N + 1][k + 1];

        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(arr[i], -1);
        }

        double memoryBinomial = memoryBinomial(N, k, p, arr);

        System.out.println("Result: " + slowBinomial);
        System.out.println("Result: " + fastBinomial);
        System.out.println("Result: " + memoryBinomial);
    }

    public static double slowBinomial(int N, int k, double p) {
        if (N == 0 && k == 0) return 1.0;
        if (N < 0 || k < 0) return 0.0;
        return (1.0 - p) * slowBinomial(N - 1, k, p) + p * slowBinomial(N - 1, k - 1, p);
    }

    public static double fastBinomial(int N, int k, double p) {
        double[][] b = new double[N + 1][k + 1];

        for (int i = 0; i <= N; i++) {
            b[i][0] = Math.pow(1.0 - p, i);
        }
        b[0][0] = 1.0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= k; j++) {
                b[i][j] = p * b[i - 1][j - 1] + (1.0 - p) * b[i - 1][j];
            }
        }

        return b[N][k];
    }

    public static double memoryBinomial(int N, int k, double p, double[][] arr) {
        if (N == 0 && k == 0) return 1.0;
        if (N < 0 || k < 0) return 0.0;

        if (arr[N][k] == -1) {
            arr[N][k] = (1.0 - p) * memoryBinomial(N - 1, k, p, arr) + p * memoryBinomial(N - 1, k - 1, p, arr);
        }

        return arr[N][k];
    }
}
