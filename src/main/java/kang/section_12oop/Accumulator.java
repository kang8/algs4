package kang.section_12oop;

import algs4.StdRandom;

public class Accumulator {
    private int n;
    private double m; // mean
    private double s; // sample variance * (n-1)

    public Accumulator() {

    }

    public void addDataValue(double value) {
        n++;
        s = s + (1.0 * (n - 1) / n) * (value - m) * (value - m); // m here is m-1
        m = m + (value - m) / n;
    }

    public double mean() {
        return m;
    }

    /**
     * sample variance
     */
    public double var() {
        return s / (n - 1);
    }

    /**
     * standard deviation
     */
    public double stddev() {
        return Math.sqrt(this.var());
    }

    public String toString() {
        return "n = " + n + ", mean = " + mean() + ", sample variance = " + var() + ", sample " +
                "standard deviation = " + stddev();
    }

    public static void main(String[] args) {
        int T = 20000;
        Accumulator accumulator = new Accumulator();

        for (int i = 0; i < T; i++) {
            accumulator.addDataValue(StdRandom.uniformDouble());
        }

        System.out.println(accumulator);
    }
}
