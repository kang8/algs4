package kang.section_13stacks;


import java.util.Objects;

/**
 * Write a program that takes form standard input an expression without left parentheses and
 * prints the equivalent infix expression with the parentheses inserted. For example, given the
 * input:
 * <pre>{@code
 * 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
 * }</pre>
 * your program should print
 * <pre>{@code
 * ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
 * }</pre>
 */
public class Ex_1_3_09 {
    public static void main(String[] args) {
        String   str    = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        String[] splits = str.split("\\s+");

        Stack<String> operator = new Stack<>();
        Stack<String> number   = new Stack<>();

        for (String s : splits) {
            if (Objects.equals(s, ")")) {
                String ope    = operator.pop();
                String second = number.pop();
                String first  = number.pop();

                String newOutput = "(" + first + ope + second + ")";

                number.push(newOutput);
            } else if (isOperator(s)) {
                operator.push(s);
            } else {
                number.push(s);
            }

        }

        System.out.println(number.peek());
    }

    private static boolean isOperator(String s) {
        return Objects.equals(s, "+") || Objects.equals(s, "-") || Objects.equals(s, "*") || Objects.equals(s, "/");
    }
}
