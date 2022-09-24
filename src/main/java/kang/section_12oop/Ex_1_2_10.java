package kang.section_12oop;

import algs4.StdDraw;
import algs4.StdRandom;

/**
 * Develop a class {@code VisualCounter} that allows both increment and decrement operations.
 * Take two arguments N and max in the constructor, where N specifies the maximum number
 * of operations and max specifies the maximum absolute value for the counter. As a side
 * effect, create a plot showing the value of the counter each time its tally changes.
 */
public class Ex_1_2_10 {
    private final int N;
    private final int max;
    private int count;
    private int operationCount;

    public Ex_1_2_10(int N, int max) {
        this.N = N;
        this.max = max;

        StdDraw.setXscale(0, N);
        StdDraw.setYscale(-max, max);
    }

    public void increment() {
        if (count + 1 > max) {
            throw new IllegalArgumentException("can not greater than " + this.max);
        }

        count++;
        operationCount++;

        StdDraw.point(operationCount, count);
    }

    public void decrement() {
        if (count - 1 < -max) {
            throw new IllegalArgumentException("can not less that " + (-this.max));
        }

        count--;
        operationCount++;

        StdDraw.point(operationCount, count);
    }

    public int tally() {
        return count;
    }

    public String toString() {
        return tally() + "";
    }

    public static void main(String[] args) {
        int N = 1000;
        int max = 1000;
        Ex_1_2_10 visualCounter = new Ex_1_2_10(N, max);

        for (int i = 0; i < N; i++) {
            if (i > N / 2) {
                if (StdRandom.bernoulli(0.85)) visualCounter.increment();
                else visualCounter.decrement();
            } else {
                if (StdRandom.bernoulli(0.85)) visualCounter.decrement();
                else visualCounter.increment();
            }
        }
    }
}
