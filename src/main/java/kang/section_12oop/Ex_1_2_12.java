package kang.section_12oop;

/**
 * Add a method {@code dayOfTheWeek()} to {@code SmartDate} that returns a
 * {@link String} value Monday, Tuesday, Wednesday, Thursday, Friday, Saturday,
 * or Sunday, giving the appropriate day of the week for the date. You may
 * assume that the date is in the 21st century.
 */
public class Ex_1_2_12 {
    public static void main(String[] args) {
        System.out.println(new SmartDate(9, 27, 2022).dayOfTheWeek()); // match Tuesday
        System.out.println(new SmartDate(1, 1, 2000).dayOfTheWeek()); // match Saturday
        System.out.println(new SmartDate(1, 1, 2001).dayOfTheWeek()); // match Monday
    }
}
