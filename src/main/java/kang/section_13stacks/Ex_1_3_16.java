package kang.section_13stacks;

import kang.section_12oop.SmartDate;

import java.util.Arrays;

/**
 * Using {@code readInts()} on page 126 as a model, write a static method {@link  SmartDate#readDates(String)}
 * for Date that reads dates from standard input in the format specified in the table on page 119 and
 * returns an array containing them.
 */
public class Ex_1_3_16 {
    public static void main(String[] args) {
        SmartDate[] smartDates = SmartDate.readDates("Ex_1_3_16.txt");
        System.out.println(Arrays.toString(smartDates));
    }
}
