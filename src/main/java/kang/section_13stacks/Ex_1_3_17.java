package kang.section_13stacks;

import kang.section_12oop.BasicTransaction;

import java.util.Arrays;

/**
 * Do {@link kang.section_12oop.Ex_1_2_16} for {@link kang.section_12oop.Transaction}
 */
public class Ex_1_3_17 {
    public static void main(String[] args) {
        BasicTransaction[] transactions = BasicTransaction.readTransactions("tinyBatch.txt");
        System.out.println(Arrays.toString(transactions));
    }
}
