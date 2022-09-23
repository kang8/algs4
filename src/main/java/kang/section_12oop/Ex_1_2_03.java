package kang.section_12oop;

import algs4.StdRandom;

/**
 * Write an {@link Interval2D} client that takes command-line arguments N, min, and max
 * and generates N random 2D intervals whose width and height are uniformly distributed
 * between min and max in the unit square, Draw them on {@link algs4.StdDraw} and print
 * the number of pairs of intervals that intersect and the number of intervals that are
 * contained in one another.
 */
public class Ex_1_2_03 {
    public static void main(String[] args) {
        int N = 20;
        double min = 0;
        double max = 1;

        Interval2D[] rectangles = new Interval2D[N];
        for (int i = 0; i < N; i++) {
            rectangles[i] = new Interval2D(randomInterval1D(min, max), randomInterval1D(min, max));
            rectangles[i].draw();
        }

        int number_of_intersect = 0;
        int number_of_contained = 0;

        for (int from = 0; from < N; from++) {
            for (int to = 0; to < N; to++) {
                if (rectangles[from].intersects(rectangles[to])) number_of_intersect++;

                if (rectangles[from].contains(rectangles[to])) number_of_contained++;
            }
        }

        System.out.println("Intersect rectangle: " + number_of_intersect);
        System.out.println("Contained rectangle: " + number_of_contained);
    }

    private static Interval1D randomInterval1D(double min, double max) {
        double first = StdRandom.uniformDouble(min, max);
        double second = StdRandom.uniformDouble(min, max);
        return new Interval1D(Math.min(first, second), Math.max(first, second));
    }
}
