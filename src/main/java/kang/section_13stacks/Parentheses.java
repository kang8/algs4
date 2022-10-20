package kang.section_13stacks;

public class Parentheses {
    private Node top;
    private int  N;

    private static class Node {
        char symbol;
        Node next;
    }

    public Parentheses() {
        top = null;
        N   = 0;
    }

    public void push(char symbol) {
        Node oldTop = top;

        top        = new Node();
        top.symbol = symbol;
        top.next   = oldTop;
        N++;
    }

    public char pop() {
        char symbol = top.symbol;

        top = top.next;
        N--;

        return symbol;
    }

    public boolean isValid(String parentheses) {
        for (char symbol : parentheses.toCharArray()) {
            if (isLeftParenthesis(symbol)) {
                push(symbol);
            } else if (isRightParenthesis(symbol)) {
                char leftParenthesis = pop();

                if (!isMatch(leftParenthesis, symbol)) {
                    return false;
                }
            } else {
                throw new IllegalArgumentException("Invalid parenthesis: [" + symbol + "]");
            }
        }

        return true;
    }

    private boolean isMatch(char leftParenthesis, char rightParenthesis) {
        return switch (leftParenthesis) {
            case '(' -> rightParenthesis == ')';
            case '[' -> rightParenthesis == ']';
            case '{' -> rightParenthesis == '}';
            default -> {
                throw new IllegalArgumentException("Not support left parenthesis [" + leftParenthesis + "]");
            }
        };
    }

    private boolean isLeftParenthesis(char symbol) {
        return symbol == '(' || symbol == '[' || symbol == '{';
    }

    private boolean isRightParenthesis(char symbol) {
        return symbol == ')' || symbol == ']' || symbol == '}';
    }

    private boolean isParenthesis(char symbol) {
        return isLeftParenthesis(symbol) || isRightParenthesis(symbol);
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return N;
    }
}
