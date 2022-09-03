package kang.section_11model;

import algs4.In;
import algs4.StdOut;

/**
 * Write a program that reads in lines from standard input with each line containing
 * a name and two integers and then uses {@link algs4.StdOut#printf(String, Object...)}
 * to print a table with a column of the names, the integers, and the result of dividing
 * the first by the second, accurate to three decimal places. You could use a program
 * like this to tabulate batting averages for baseball players or grades for students
 */
public class Ex_1_1_21 {

    private static final String FILE_NAME = "Ex_1_1_21.txt";

    public static void main(String[] args) {
        String[] lines = new In(FILE_NAME).readAllLines();
        for (String line : lines) {
            String[] split = line.split(" ");

            String name = split[0];
            int first = Integer.parseInt(split[1]);
            int second = Integer.parseInt(split[2]);

            double firstDividedBySecond = first * 1.0 / second;

            StdOut.printf("%6s %3d %3d %.3f\n", name, first, second, firstDividedBySecond);
        }
    }
}
