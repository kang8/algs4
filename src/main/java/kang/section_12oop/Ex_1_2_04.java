package kang.section_12oop;

/**
 * What dose the following code fragment print?
 */
public class Ex_1_2_04 {
    public static void main(String[] args) {
        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        System.out.println(string1); // world
        System.out.println(string2); // hello
    }
}
