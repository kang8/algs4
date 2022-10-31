package kang.section_13stacks;

/**
 * Add a method {@link Stack#peek()} to {@link Stack} that returns the most recently inserted item on
 * the stack(without popping it).
 */
public class Ex_1_3_07 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("hello");
        stack.push("world");

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
