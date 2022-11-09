package kang.section_13stacks;

/**
 * Why does the following code fragment not do the same thing as in the previous question?
 * <pre>{@code
 * x.next = t;
 * t.next = x.next;
 * }</pre>
 *
 * @Official Answer: When it comes time to update t.next, x.next is no longer the original node
 * following x, but is instead t itself!
 */
public class Ex_1_3_23 {
}
