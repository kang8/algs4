package kang.section_13stacks;

/**
 * Write a stack client {@code Parentheses} that reads in a text stream from standard input and
 * uses a stack to determine whether its parentheses are properly balanced. For example. your
 * program should print true for {@code [()](){[()()]()} } and false for {@code [(]) }.
 */
public class Ex_1_3_04 {
    public static void main(String[] args) {
        Parentheses parentheses = new Parentheses();
        System.out.println(parentheses.isValid("[()](){[()()]()}"));
        System.out.println(parentheses.isValid("[(])"));
    }
}
