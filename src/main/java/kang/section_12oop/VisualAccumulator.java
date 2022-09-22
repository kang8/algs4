package kang.section_12oop;

import algs4.StdDraw;
import algs4.StdRandom;

public class VisualAccumulator {
    private double total;
    private int n;

    public VisualAccumulator(int trials, double max) {
        StdDraw.setXscale(0, trials);
        StdDraw.setYscale(0, max);
        StdDraw.setPenRadius(0.005);
    }

    public void addDataValue(double value) {
        n++;
        total += value;
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(n, value);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(n, mean());
    }

    public double mean() {
        return total / n;
    }

    public String toString() {
        return "n = " + n + ", mean = " + mean();
    }

    public static void main(String[] args) {
        int T = 20000;
        VisualAccumulator visualAccumulator = new VisualAccumulator(T, 1.0);

        for (int i = 0; i < T; i++) {
            visualAccumulator.addDataValue(StdRandom.uniformDouble());
        }

        System.out.println(visualAccumulator);
    }
}
