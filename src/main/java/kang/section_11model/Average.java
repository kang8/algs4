package kang.section_11model;

import algs4.StdIn;
import algs4.StdOut;

public class Average {
    public static void main(String[] args) {
        double sum = 0.0;
        int count = 0;

        while (!StdIn.isEmpty()) {
            double value = StdIn.readDouble();
            sum += value;
            count++;
        }

        double average = sum / count;

        StdOut.println("Average is " + average);
    }
}
