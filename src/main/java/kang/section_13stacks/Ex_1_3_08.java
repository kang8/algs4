package kang.section_13stacks;

/**
 * Give the contents and size of the array for {@link DoublingStackOfStrings} with the input
 * <pre>{@code
 * it was - the best - of times - - - it was - the - -
 * }</pre>
 */
public class Ex_1_3_08 {
    public static void main(String[] args) {
        DoublingStackOfStrings doublingStackOfStrings = new DoublingStackOfStrings();

        String[] strings = {"it", "was", "-", "the", "best", "-", "of", "times", "-", "-", "-",
                "it", "was", "-", "the", "-", "-"};
        for (String s : strings) {
            if (!s.equals("-")) {
                doublingStackOfStrings.push(s);
            } else if (!doublingStackOfStrings.isEmpty()) {
                System.out.print(doublingStackOfStrings.pop() + " ");
            }
        }

        System.out.print("(" + doublingStackOfStrings.size() + " left on stack, capacity is " + doublingStackOfStrings.sizeOfArray() +
                ")");
    }
}
