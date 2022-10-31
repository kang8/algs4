package kang.section_13stacks;

/**
 * Suppose that a client performs an intermixed sequence of (stack) {@link Stack#push(Object)}
 * and {@link Stack#pop()} operations. The push operations put the integers 0 through 9 in order
 * onto the stack; the {@code pop()} operations print out the return values. Which of the
 * following sequence(s) could not occur?
 * <pre>{@code
 * a. 4 3 2 1 0 9 8 7 6 5 // will occur
 * b. 4 6 8 7 5 3 2 9 0 1 // not occur, must first pop 1 then pop 0
 * c. 2 5 6 7 4 8 9 3 1 0 // will occur
 * d. 4 3 2 1 0 5 6 7 8 9 // will occur
 * e. 1 2 3 4 5 6 9 8 7 0 // will occur
 * f. 0 4 6 5 3 8 1 7 2 9 // not occur, must first pop 2 then pop 1
 * g. 1 4 7 9 8 6 5 3 0 2 // not occur, must first pop 2 then pop 0
 * h. 2 1 4 3 6 5 8 7 9 0 // will occur
 * }</pre>
 */
public class Ex_1_3_03 {
}
