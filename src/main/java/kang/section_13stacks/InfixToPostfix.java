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
        Queue<String> characterQueue = new Queue<>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (c == ' ') continue;

            int next = i;
            while (isNumber(c) && isNumber(infix.charAt(++next))) {
                characterQueue.enqueue(characterQueue.dequeue() + infix.charAt(next));
            }

            characterQueue.enqueue(Character.toString(c));
        }

        String[] res = new String[characterQueue.size()];
        int      len = 0;

        while (!characterQueue.isEmpty()) {
            res[len++] = characterQueue.dequeue();
        }

        return res;
    }
}
