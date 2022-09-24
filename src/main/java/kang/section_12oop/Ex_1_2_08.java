package kang.section_12oop;

/**
 * Suppose that a[] and b[] are each integer arrays consisting of millions
 * of integers. What does the follow code do? Is it reasonable efficient?
 * <pre>{@code
 * int[] t = a; a = b; b = t;
 * }</pre>
 *
 * <h3>What dose the follow code do?</h3>
 * Swap array by a[], b[].
 *
 * <p><h3>Is it reasonable efficient?</h3>
 * Yes, copy reference is more efficient.
 *
 * @Answer: It swaps them. It could hardly be more efficient because it does so by copying
 * references, so that it is not necessary to copy millions of elements.
 */
public class Ex_1_2_08 {
}
