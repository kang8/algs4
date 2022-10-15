package kang.section_12oop;

import algs4.StdRandom;

/**
 * Variance for accumulator. Validate that the following code, which adds the methods {@code var()}
 * and {@code stddev()} to {@link Accumulator}, computes both the mean and variance of the
 * numbers presented as arguments to {@code addDataValue()}:
 * <pre>{@code
 * public class Accumulator
 * {
 *     private double m;
 *     private double s;
 *     private int N;
 *
 *     public void addDateValue(double x)
 *     {
 *         N++;
 *         s = s + 1.0 * (N-1) / N * (x-m) * (x-m);
 *         m = m + (x - m) / N;
 *     }
 *
 *     public double mean()
 *     {
 *         return m;
 *     }
 *
 *     public double var()
 *     {
 *         return s/(N-1);
 *     }
 *
 *     public double stddev()
 *     {
 *         return Math.sqrt(this.var());
 *     }
 * }
 * }</pre>
 * <p>
 * This implementation is less susceptible to roundoff error than the straightforward
 * implementation based on saving the sum of the squares of the numbers.
 */
public class Ex_1_2_18 {
    public static void main(String[] args) {
        double[] arr = new double[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = StdRandom.uniformDouble(1, 1000);
        }

        Accumulator accumulator = new Accumulator();
        for (double v : arr) {
            accumulator.addDataValue(v);
        }

        System.out.println("Online algorithm:");
        System.out.println("mean: " + accumulator.mean());
        System.out.println("simple variance: " + accumulator.var());
        System.out.println("standard deviation: " + accumulator.stddev());

        System.out.println();
        System.out.println("Classical algorithm:");

        double total = 0;
        for (double v : arr) {
            total += v;
        }
        double mean = total / arr.length;

        double sample_variance = 0;
        for (double v : arr) {
            sample_variance += (v - mean) * (v - mean);
        }
        sample_variance = sample_variance / (arr.length - 1);

        double standard_deviation = Math.sqrt(sample_variance);

        System.out.println("mean: " + total / arr.length);
        System.out.println("simple variance: " + sample_variance);
        System.out.println("standard deviation: " + standard_deviation);
    }
}
