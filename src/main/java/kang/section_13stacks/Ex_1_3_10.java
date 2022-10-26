package kang.section_13stacks;

/**
 * Write a filter {@link InfixToPostfix} that coverts an arithmetic expression from infix to postfix
 */
public class Ex_1_3_10 {
    public static void main(String[] args) {
        System.out.println(InfixToPostfix.toPostfix("3 + 4 * 2 / (1 - 5)"));
        System.out.println(InfixToPostfix.toPostfix("(2 + ((3 + 4) * (5 * 6)))"));
        System.out.println(InfixToPostfix.toPostfix("(((5 + (7 * (1 + 1))) * 3) + (2 * (1 + 1)))"));
    }
}
