package kang.section_12oop;

/**
 * A string s is a circular rotation of a string t if it matches when the characters
 * are circularly shifted by any number of positions; e.g. ACTGACG is a circular shift
 * of TGACGAC, and vice versa. Detecting this condition is important in the study of
 * genomic sequences. Write a program that checks whether two given strings s and t
 * are circular shifts of one another.
 *
 * @Hint: The solution is a noe-liner with {@link String#indexOf(int)}, {@link String#length()},
 * and string concatenation.
 */
public class Ex_1_2_06 {
    public static void main(String[] args) {
        String s = "ACTGACG";
        String t = "ACTGACG";

        System.out.println(isCircularRotation(s, t));
    }

    private static boolean isCircularRotation(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            if (s.equals(t.substring(i) + t.substring(0, i))) {
                return true;
            }
        }

        return false;
    }

}
