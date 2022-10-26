/******************************************************************************
 * Compilation: mvn compile
 * Execution: `java kang.section_13stacks.InfixToPostfix "infix_notation" | java kang.section_13stacks.EvaluatePostfix` in `target/classes` directory
 *
 * % java kang.section_13stacks.InfixToPostfix "(2 + ((3 + 4) * (5 * 6)))" | java kang.section_13stacks.EvaluatePostfix
 * 212.0
 *
 * % java kang.section_13stacks.InfixToPostfix "(((5 + (7 * (1 + 1))) * 3) + (2 * (1 + 1)))" | java kang.section_13stacks.EvaluatePostfix
 * 61.0
 ******************************************************************************/


package kang.section_13stacks;

import algs4.StdIn;
import kang.common.Operator;

public class EvaluatePostfix {
    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            String[] postfix = StdIn.readAllStrings();
            System.out.println(evaluate(postfix));
        }
    }

    private static double evaluate(String[] postfix) {
        Stack<Double> stack = new Stack<>();
        for (String token : postfix) {
            if (Operator.isOperator(token)) {
                double b = stack.pop();
                double a = stack.pop();

                double res = switch (token) {
                    case "+" -> a + b;
                    case "-" -> a - b;
                    case "*" -> a * b;
                    case "/" -> a / b;
                    default ->
                            throw new IllegalArgumentException("Not support operator [" + token + "].");
                };

                stack.push(res);
            } else {
                stack.push(Double.parseDouble(token));
            }
        }
        return stack.pop();
    }
}
