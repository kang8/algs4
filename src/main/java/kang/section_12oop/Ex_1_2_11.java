package kang.section_12oop;

/**
 * Develop an implementation {@link SmartDate} of our {@link Date} API that
 * raises an exception if the date is not legal.
 */
public class Ex_1_2_11 {
    public static void main(String[] args) {
        SmartDate validDate = new SmartDate(9, 26, 2022);
        System.out.println(validDate);

        SmartDate monthInvalid         = new SmartDate(19, 26, 2022);
        SmartDate dayInvalid           = new SmartDate(9, 36, 2022);
        SmartDate leapYearInvalid      = new SmartDate(2, 29, 2022);
        SmartDate leapYearValid        = new SmartDate(2, 29, 2024);
        SmartDate leapYearInvalidBy100 = new SmartDate(2, 29, 1000);
    }
}
