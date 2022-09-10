package kang.section_11model;

import java.util.Arrays;

/**
 * Array exercise. Write a code fragment that creates a N-by-N boolean array a[][] such
 * that a [i][j] is true if i and j are relatively prime (have no common factors), and
 * false otherwise.
 *
 * @Word: relatively prime, 互质 <br>
 * common factors, 公因数
 */
public class Ex_1_1_30 {
    public static void main(String[] args) {
        int N = 50;

        int[] primeArr = getPrimeArr(N);

        boolean[][] a = new boolean[N + 1][N + 1];

        for (int row = 1; row <= N; row++) {
            Arrays.fill(a[row], true);
        }

        for (int prime : primeArr) {
            for (int row = prime; row <= N; row += prime) {
                for (int col = row; col <= N; col += prime) {
                    a[row][col] = false;
                    a[col][row] = false;
                }
            }
        }

        printArray(a);

        verify(N, a);
    }

    private static void verify(int N, boolean[][] a) {
        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= N; col++) {
                if (Ex_1_1_24.euclidOfModVersion(row, col) == 1 && !a[row][col]) {
                    System.out.println("Error: " + row + " " + col);
                }
            }
        }
    }

    private static int[] getPrimeArr(int n) {
        boolean[] p = new boolean[n + 1];
        int primeCount = 1;

        Arrays.fill(p, true);

        for (int i = 2; i <= n; i++) {
            if (p[i] == false) continue;
            primeCount++;
            for (int j = i + i; j <= n; j += i) {
                p[j] = false;
            }
        }

        int[] primes = new int[primeCount - 1];
        int index = 0;

        for (int i = 2; i <= n; i++) {
            if (p[i]) primes[index++] = i;
        }

        return primes;
    }

    private static void printArray(boolean[][] a) {
        int N = a.length - 1;

        System.out.print(" ");
        for (int row = 1; row <= N; row++) {
            System.out.printf("%3d", row);
        }
        System.out.println();

        for (int row = 1; row <= N; row++) {
            System.out.printf("%-3d", row);
            for (int col = 1; col <= N; col++) {
                System.out.printf("%2s", (a[row][col] ? "*" : "-") + "  ");
            }
            System.out.println();
        }
    }
}
