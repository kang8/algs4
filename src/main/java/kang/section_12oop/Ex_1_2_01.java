package kang.section_12oop;

import algs4.StdDraw;
import algs4.StdRandom;

/**
 * Write a {@link Point2D} client that takes an integer value N from the command line,
 * generates N random points in the unit square, and computes the distance
 * separating the closest pair of points.
 */
public class Ex_1_2_01 {
    public static void main(String[] args) {
        int N = 20;

        Point2D[] points = new Point2D[N];

        for (int i = 0; i < points.length; i++) {
            points[i] = new Point2D(StdRandom.uniformDouble(), StdRandom.uniformDouble());
            points[i].draw();
        }

        double min_distance = Double.MAX_VALUE;
        Point2D min_from = null;
        Point2D min_to = null;

        for (int from = 0; from < points.length; from++) {
            for (int to = from + 1; to < points.length; to++) {
                points[from].drawTo(points[to]);

                double distance = points[from].distanceTo(points[to]);
                if (min_distance > distance) {
                    min_distance = Math.min(min_distance, distance);
                    min_from = points[from];
                    min_to = points[to];
                }
            }
        }

        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.RED);
        min_from.drawTo(min_to);

        System.out.println(min_distance);
    }
}
