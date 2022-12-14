package kang.section_12oop;

/**
 * What does the following recursive function return?
 * <pre>{@code
 * public static String mystery(String s)
 * {
 *     int N = s.length();
 *     if (N <= 1) return s;
 *     String a = s.substring(0, N/2);
 *     String b = s.substring(N/2, N);
 *     return mystery(b) + mystery(a);
 * }
 * }</pre>
 *
 * @Answer: reverse string.
 */
public class Ex_1_2_07 {
    public static void main(String[] args) {
        System.out.println(mystery("Hello")); // olleH
    }

    private static String mystery(String s) {
        int N = s.length();
        if (N <= 1) return s;
        String a = s.substring(0, N / 2);
        String b = s.substring(N / 2, N);
        return mystery(b) + mystery(a);
    }
}
