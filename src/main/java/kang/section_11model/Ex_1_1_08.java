package kang.section_11model;

/**
 * What do each of the following print?
 * <pre>{@code
 * a. System.out.println('b');
 * b. System.out.println('b' + 'c');
 * c. System.out.println((char) ('a' + 4));
 * }</pre>
 * Explain each outcome.
 */
public class Ex_1_1_08 {
    public static void main(String[] args) {
        System.out.println('b'); // b
        /*
        并不是字符串相加，字符串使用 `"` 来表示
         */
        System.out.println('b' + 'c'); // 197
        /*
        使用来 `(char)` 强制符来转换成字符
         */
        System.out.println((char) ('a' + 4)); // e
    }
}
