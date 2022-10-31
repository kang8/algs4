package kang.common;

public class Operator {
    public static boolean isOperator(String s) {
        return switch (s) {
            case "+", "-", "*", "/" -> true;
            default -> false;
        };
    }
}
