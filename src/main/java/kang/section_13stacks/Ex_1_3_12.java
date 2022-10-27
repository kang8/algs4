package kang.section_13stacks;

/**
 * Write an iterable {@link Stack} client that has a static method copy() that takes a stack of
 * strings as argument and returns a copy of the stack. Note: This ability is a prime example of
 * the value of having an iterator, because it allows development of such functionality without
 * changing the basic API.
 */
public class Ex_1_3_12 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.push("hello");
        stack.push("world");

        System.out.println("stack = " + stack);
        Stack<String> copy = Stack.copy(stack);
        System.out.println("copy = " + copy);
    }
}
