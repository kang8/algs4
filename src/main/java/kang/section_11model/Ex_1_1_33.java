package kang.section_11model;

import algs4.StdOut;

import java.util.Arrays;

/**
 * Matrix library. Write a library Matrix that implements the following API:
 * <pre>{@code
 * public interface Matrix {
 *     static double     dot(double[] x, double[] y);     // vector dot product
 *     static double[][] mult(double[][] a, double[][] b) // matrix-matrix product
 *     static double[][] transpose(double[][] a)          // transpose
 *     static double[]   mult(double[][] a, double[] x)   // matrix-vector product
 *     static double[]   mult(double[] y, double[][] a)   // vector-matrix product
 * }
 * }</pre>
 * Develop a test client that reads values from standard input and tests all the methods.
 *
 * @Tips: vector product online website: https://www.symbolab.com/solver/vector-dot-product-calculator
 */
public class Ex_1_1_33 {
    public static void main(String[] args) {
        double[] x = {2.0, 3.0, 4.0};
        double[] y = {3.0, 2.0, 5.5};

        StdOut.println("Dot: " + dot(x, y));

        double[][] a = {
                {2.0, 3.0, 4.0},
                {3.0, 2.0, 5.5}
        };
        double[][] b = {
                {1.0, 2.0},
                {4.0, -2.0},
                {3.0, 7.0}
        };
        System.out.println("Matrix-matrix: ");
        double[][] product = mult(a, b);
        for (double[] row : product) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("Transpose: ");
        double[][] transposeA = transpose(a);
        for (double[] row : transposeA) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("Matrix-vector: ");
        double[] matrixVector = mult(a, x);
        for (double column : matrixVector) {
            System.out.println(column);
        }

        System.out.println("Vector-matrix: ");
        double[] vectorMatrix = mult(y, b);
        System.out.println(Arrays.toString(vectorMatrix));
    }

    public static double dot(double[] x, double[] y) {
        checkArgumentCannotBeNull(x, y);

        if (x.length != y.length) {
            throw new IllegalArgumentException("Vector length not equal!");
        }

        int len = x.length;
        double dotResult = 0;

        for (int i = 0; i < len; i++) {
            dotResult += x[i] * y[i];
        }

        return dotResult;
    }

    public static double[][] mult(double[][] a, double[][] b) {
        checkArgumentCannotBeNull(a, b);

        int rowA = a.length;
        int columnA = a[0].length;
        int rowB = b.length;
        int columnB = b[0].length;

        if (columnA != rowB) {
            throw new IllegalArgumentException("Matrix-matrix can't product, because first matrix column not equal second matrix row.");
        }

        double[][] product = new double[rowA][columnB];

        for (int productRow = 0; productRow < rowA; productRow++) {
            for (int productColumn = 0; productColumn < columnB; productColumn++) {
                for (int i = 0; i < columnA; i++) {
                    product[productRow][productColumn] += a[productRow][i] * b[i][productColumn];
                }
            }
        }

        return product;
    }

    public static double[][] transpose(double[][] a) {
        checkArgumentCannotBeNull(a);

        int rowP = a[0].length;
        int columnP = a.length;

        double[][] transpose = new double[rowP][columnP];

        for (int row = 0; row < rowP; row++) {
            for (int column = 0; column < columnP; column++) {
                transpose[row][column] = a[column][row];
            }
        }

        return transpose;
    }

    public static double[] mult(double[][] a, double[] x) {
        checkArgumentCannotBeNull(a, x);

        int rowA = a.length;
        int columnA = a[0].length;
        int rowX = x.length;

        if (columnA != rowX) {
            throw new IllegalArgumentException("Matrix-vector can't product, because matrix column not equal vector length");
        }

        double[] product = new double[rowA];

        for (int column = 0; column < rowA; column++) {
            for (int i = 0; i < columnA; i++) {
                product[column] += a[column][i] * x[i];
            }
        }

        return product;
    }

    public static double[] mult(double[] y, double[][] b) {
        checkArgumentCannotBeNull(y, b);

        int columnY = y.length;
        int rowB = b.length;
        int columnB = b[0].length;

        if (columnY != rowB) {
            throw new IllegalArgumentException("Vector-matrix can't product, because vector column not equal matrix row.");
        }

        double product[] = new double[columnB];

        for (int column = 0; column < columnB; column++) {
            for (int i = 0; i < columnY; i++) {
                product[column] += y[i] * b[i][column];
            }
        }

        return product;
    }

    private static void checkArgumentCannotBeNull(Object x, Object y) {
        if (x == null || y == null) {
            throw new IllegalArgumentException("Array can't be null.");
        }
    }

    private static void checkArgumentCannotBeNull(Object x) {
        if (x == null) {
            throw new IllegalArgumentException("Array can't be null.");
        }
    }
}
