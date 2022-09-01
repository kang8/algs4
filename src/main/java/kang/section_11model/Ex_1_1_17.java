package kang.section_11model;

/**
 * Criticize the following recursive function:
 * <pre>{@code
 * public static String exR2(int n)
 * {
 *     String s = exR2(n - 3) + n + exR2(n - 2) + n;
 *     if (n <= 0) return "";  <-- 问题出在这部，递归中应该先判断边界条件并返回
 *     return s;
 * }
 * }</pre>
 *
 * @Answer: The base case will never be reached. A call to exR2(3) will result in calls to
 * exR2(0), exR2(-3), exR2(-6), and so forth until a StackOverflowError occurs.
 */
public class Ex_1_1_17 {
}
