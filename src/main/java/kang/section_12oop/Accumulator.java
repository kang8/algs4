package kang.section_12oop;

import algs4.StdRandom;

public class Accumulator {
    private double total;
    private int n;

    public Accumulator() {

    }

    public void addDataValue(double value) {
        n++;
        total += value;
    }

    public double mean() {
        return total / n;
    }

    public String toString() {
        return "n = " + n + ", mean = " + mean();
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
