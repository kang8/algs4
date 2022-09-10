package kang.section_11model;

import algs4.StdDraw;
import algs4.StdRandom;

/**
 * Random connections. Write a program that takes as command-line arguments
 * an integer N and a double value p (between 0 and 1), plots N equally spaced
 * dots of size .05 on the circumference of a circle, and then, with probability
 * p for each pair of points, draws a gray line connecting them.
 */
public class Ex_1_1_31 {
    public static void drawRandConn(int N, double p)
    {
        StdDraw.setScale(-1.2, 1.2); // 设置缩放比例，通常来说 1.2 很不错
        StdDraw.setPenRadius(.05);

        double[][] d = new double[N][2];
        for (int i = 0; i < N; i++)
        {
            d[i][0] = Math.cos(2 * Math.PI * i / N);
            d[i][1] = Math.sin(2 * Math.PI * i / N);
            StdDraw.point(d[i][0], d[i][1]);
        }

        StdDraw.setPenRadius();

        for (int i = 0; i < N - 1; i++)
            for (int j = i + 1; j < N; j++)
                if (StdRandom.bernoulli(p))
                    StdDraw.line(d[i][0], d[i][1], d[j][0], d[j][1]);
    }

    public static void main(String[] args)
    {
        int N = 10;
        double p = 0.5;

        drawRandConn(N, p);
    }
}
