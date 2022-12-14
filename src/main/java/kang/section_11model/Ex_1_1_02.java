package kang.section_11model;

/**
 * Give the type and value of each of the following expressions:
 * <pre>{@code
 * a. (1 + 2.236) / 2
 * b. 1 + 2 + 3 + 4.0
 * c. 4.1 >= 4
 * d. 1 + 2 + "3"
 * }</pre>
 */
public class Ex_1_1_02 {
    public static void main(String[] args) {
        System.out.println((1 + 2.236) / 2); // double, 1.618
        System.out.println(1 + 2 + 3 + 4.0); // double, 10.0
        System.out.println(4.1 >= 4); //  boolean, true
        System.out.println(1 + 2 + "3"); // String, 33
    }
}
