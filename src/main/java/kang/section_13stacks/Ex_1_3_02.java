package kang.section_13stacks;

/**
 * Give the output printed by {@code java Stack} for the input
 * <pre>{@code
 * it was - the best - of times - - - it was - the - -
 * }</pre>
 *
 * @Output: was best times of the was the it (1 left on stack)
 */
public class Ex_1_3_02 {
    public static void main(String[] args) {
        String[] strings = {"it", "was", "-", "the", "best", "-", "of", "times", "-", "-", "-",
                "it", "was", "-", "the", "-", "-"};

//        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(100);
        Stack<String> stack = new Stack<>();

        for (String s : strings) {
            if (!s.equals("-")) {
                stack.push(s);
            } else if (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
        }
        System.out.println("(" + stack.size() + " left on stack)");

    }
}
