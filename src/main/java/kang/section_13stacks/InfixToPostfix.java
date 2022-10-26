/******************************************************************************
 * Compilation: mvn compile
 * Execution: `java kang.section_13stacks.InfixToPostfix "infix_notation"` in `target/classes` directory
 *
 * % java kang.section_13stacks.InfixToPostfix "(2 + ((3 + 4) * (5 * 6)))"
 * 2 3 4 + 5 6 * * +
 *
 * % java kang.section_13stacks.InfixToPostfix "(((5 + (7 * (1 + 1))) * 3) + (2 * (1 + 1)))"
 * 5 7 1 1 + * + 3 * 2 1 1 + * +
 ******************************************************************************/


package kang.section_13stacks;

import java.util.Objects;

public class InfixToPostfix {
    public static String toPostfix(String infix) {
        String[] tokens = splitExpression(infix);

        Queue<String> output   = new Queue<>();
        Stack<String> operator = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+", "-", "*", "/" -> {
                    while (!operator.isEmpty() && !Objects.equals(operator.peek(), "(") && precedence(operator.peek()) >= precedence(token)) {
                        output.enqueue(operator.pop());
                    }
                    operator.push(token);
                }
                case "(" -> operator.push(token);
                case ")" -> {
                    while (!Objects.equals(operator.peek(), "(")) {
                        output.enqueue(operator.pop());

                        if (operator.isEmpty()) {
                            throw new IllegalArgumentException("mismatched parentheses.");
                        }
                    }
                    operator.pop(); // discard '('
                }
                default -> { // number
                    if (!isNumber(token)) {
                        throw new IllegalArgumentException("Invalid token [" + token + "].");
                    }
                    output.enqueue(token);
                }
            }
        }

        while (!operator.isEmpty()) {
            output.enqueue(operator.pop());
        }

        return output.toString();
    }

    private static boolean isNumber(String tokens) {
        for (int i = 0; i < tokens.length(); i++) {
            if (!isNumber(tokens.charAt(i))) return false;
        }

        return true;
    }

    private static boolean isNumber(char token) {
        return ((token >= '0') && (token <= '9'));
    }

    private static int precedence(String token) {
        return switch (token) {
            case "-", "+" -> 1;
            case "*", "/" -> 2;
            default -> throw new IllegalArgumentException("Not support [" + token + "] operator.");
        };
    }

    private static String[] splitExpression(String infix) {
        Queue<String> queue = new Queue<>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (c == ' ') continue;

            int next = i;
            while (isNumber(c) && isNumber(infix.charAt(next + 1))) {
                queue.enqueue(Character.toString(c) + infix.charAt(++next));
            }

            if (i != next) {
                i = next;
                continue;
            }

            queue.enqueue(Character.toString(c));
        }

        String[] res = new String[queue.size()];
        int      len = 0;

        while (!queue.isEmpty()) {
            res[len++] = queue.dequeue();
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(InfixToPostfix.toPostfix(args[0]));
    }
}
