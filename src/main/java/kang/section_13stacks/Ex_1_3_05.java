package kang.section_13stacks;

/**
 * What dose the following code fragment print when N is 50? Give a high-level description of
 * what it does when presented with a positive integer N.
 * <pre>{@code
 * Stack<Integer> stack = new Stack<Integer>();
 * while(N > 0)
 * {
 *      stack.push(N % 2);
 *      N = N / 2;
 * }
 * for (int d : stack) StdOut.print(d);
 * StdOut.println();
 * }</pre>
 *
 * @Answer: Prints the binary representation of N (110010 when N is 50)
 * 输出 N 的二进制。
 */
public class Ex_1_3_05 {
}
