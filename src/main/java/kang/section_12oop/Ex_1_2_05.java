package kang.section_12oop;

import java.util.Locale;

/**
 * What dose the following code fragment print?
 *
 * @Answer: "Hello World". String objects are immutable -- string methods return
 * a new String object with the appropriate value(bue they do not change the value
 * of the object that was used to invoke them). This code ignores the objects returned
 * and just prints the original string. To print "WORLD", use {@code s = s.toUpperCase() and
 * s = s.substring(6, 11)}.
 */
public class Ex_1_2_05 {
    public static void main(String[] args) {
        String s = "Hello World";
        s.toUpperCase();
        s.substring(6, 11);
        System.out.println(s); // Hello World
    }
}
