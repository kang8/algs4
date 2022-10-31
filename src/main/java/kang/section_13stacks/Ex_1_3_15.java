/******************************************************************************
 * Compilation: mvn compile
 * Execution: `java kang.section_13stacks.Ex_1_3_15 <kth>` in `target/classes` directory
 *
 * Windows users: replace [Ctrl-d] with [Ctrl-z] to signify end of file.
 *
 * % java kang.section_13stacks.Ex_1_3_15 4
 * hello world kang yi chinese football
 * [Ctrl-d]
 * yi
 ******************************************************************************/


package kang.section_13stacks;

import algs4.StdIn;

/**
 * Write a Queue client that takes a command-line argument k and prints the kth from the last
 * string found on standard input (assuming that standard input has k or more strings).
 */
public class Ex_1_3_15 {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);

        Queue<String> queue = new Queue<>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            queue.enqueue(item);
        }

        for (int i = 0; i < k - 1; i++) {
            queue.dequeue();
        }

        System.out.println(queue.dequeue());
    }
}
