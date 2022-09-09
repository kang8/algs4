package kang.section_11model;

import algs4.StdDraw;
import algs4.StdIn;

/**
 * Histogram. Suppose that the standard input stream is a sequence of double
 * values. Write a program that takes an integer N and two double values `l`
 * and `r` from the command line and uses {@link algs4.StdDraw} to plot a
 * histogram of the count of the numbers in the standard input stream that
 * fall in each of the N intervals defined by dividing (l,r) into N equal-sized
 * intervals.
 */
public class Ex_1_1_32 {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double l = Double.parseDouble(args[1]);
        double r = Double.parseDouble(args[2]);

        int[] histogram = new int[N];
        double lengthOfSection = (r - l) / N;

        while (!StdIn.isEmpty()) {
            double value = StdIn.readDouble();
            value -= l;

            int index = (int) (value % lengthOfSection == 0 ? value / lengthOfSection : value / lengthOfSection + 1);

            histogram[index - 1]++;
        }

        int max = 0;
        for (int i : histogram) {
            max = Math.max(i, max);
        }
        StdDraw.setXscale(l, r);
        StdDraw.setYscale(0, max);

        drawHistogram(histogram, l, lengthOfSection);
    }

    private static void drawHistogram(int[] histogram, double l, double lengthOfSection) {
        for (int i = 0; i < histogram.length; i++) {
            double x = l + (i + 0.5) * lengthOfSection; // 更具画幅等比例的 x 坐标
            double hx = 0.5 * histogram.length; // 两点之间的间隙

            // y 和 hy 比较固定，保证比例就行
            double y = histogram[i] / 2.0;
            double hy = histogram[i] / 2.0;
            StdDraw.filledRectangle(x, y, hx, hy);
        }
    }
}
