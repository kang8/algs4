package kang.section_11model;

import algs4.StdRandom;

/**
 * Dice simulation. The following code computes the exact probability distribution
 * for the sum of two dice:
 * <pre>{@code
 * int SIDES = 6;
 * double[] dist = new double[2 * SIDES + 1];
 * for (int i = 1; i <= SIDES; i++)
 *     for(int j = 1; j <= SIDES; j++)
 *         dist[i + j] += 1.0;
 *
 * for(int k = 2; k <= 2 * SIDES; k++)
 *     dist[k] /= 36.0;
 * }</pre>
 * <p>
 * The value dist[i] is the probability that the dice sum to k. Run experiments to validate
 * this calculation simulating N dice throws, keeping track of the frequencies of occurrence
 * of each value when you compute the sum of two random integers between 1 and 6. How large
 * dose N have to be before your empirical results match the exact results to three decimal
 * places?
 *
 * @Answer: 需要 1e8(100_000_000) 次才能完全相等。1e7 部分情况会出现问题。但在 1e8 的此处下，明显感觉会有卡顿。
 */
public class Ex_1_1_35 {
    private static final int SIDES = 6;

    public static void main(String[] args) {
        double[] exactDist = diceProbabilityDistributionByTwo();
        for (int i = 2; i < exactDist.length; i++) {
            System.out.printf("%.3f ", exactDist[i]);
        }
        System.out.println();

        int N = 100_000_000; // 1e8 没有问题
        double[] randomThrowDist = new double[2 * SIDES + 1];
        for (int i = 0; i < N; i++) {
            int first = StdRandom.uniformInt(1, 7);
            int second = StdRandom.uniformInt(1, 7);

            randomThrowDist[first + second]++;
        }

        for (int i = 2; i <= SIDES * 2; i++) {
            randomThrowDist[i] /= N;
        }
        for (int i = 2; i < randomThrowDist.length; i++) {
            System.out.printf("%.3f ", randomThrowDist[i]);
        }
        System.out.println();
        for (int i = 2; i < randomThrowDist.length; i++) {
            if ((int) (exactDist[i] * 1000) != (int) (randomThrowDist[i] * 1000)) {
                System.out.println("Index: " + i + "not equal");
            }
        }
    }

    private static double[] diceProbabilityDistributionByTwo() {
        double[] dist = new double[2 * SIDES + 1];

        for (int i = 1; i <= SIDES; i++)
            for (int j = 1; j <= SIDES; j++)
                dist[i + j] += 1.0;

        for (int k = 2; k <= 2 * SIDES; k++)
            dist[k] /= 36.0;

        return dist;
    }
}
