package kang.section_11model;

/**
 * Give the sequence of values of p and q that are computed when Euclid's algorithm
 * is used to compute the greatest common divisor of 105 and 24. Extend the code
 * given on page 4 to develop a program Euclid that takes two integers from the
 * command line and computes their greatest common divisor, printing out the two
 * arguments for each call on the recursive method. Use your program to compute
 * the greatest common divisor or 1111111 and 1234567.
 *
 * @Resource: <a href="https://zh.wikipedia.org/wiki/%E6%AC%A7%E5%87%A0%E9%87%8C%E5%BE%97">Euclid - 欧几里得</a> <br>
 * <a href="https://zh.wikipedia.org/wiki/%E6%9C%80%E5%A4%A7%E5%85%AC%E5%9B%A0%E6%95%B8">最大公约数</a> <br>
 * <a href="https://zh.wikipedia.org/wiki/%E8%BC%BE%E8%BD%89%E7%9B%B8%E9%99%A4%E6%B3%95">辗转相除法</a> <br>
 */
public class Ex_1_1_24 {
    public static void main(String[] args) {
        int p = 1111111;
        int q = 1234567;

        int gcdOfMode = euclidOfModVersion(p, q);
        System.out.println("result: " + gcdOfMode);

        System.out.println("---------------------");
        int gcdOfSubtraction = euclidOfSubtractionVersion(p, q);
        System.out.println("result: " + gcdOfSubtraction);
    }

    private static int euclidOfModVersion(int p, int q) {
        System.out.println(p + " " + q);

        if (q == 0) return p;

        return euclidOfModVersion(q, p % q);
    }

    private static int euclidOfSubtractionVersion(int p, int q) {
        System.out.println(p + " " + q);
        if (p == q) return p;
        else if (p > q) return euclidOfSubtractionVersion(p - q, q);
        else return euclidOfSubtractionVersion(p, q - p);
    }

}
