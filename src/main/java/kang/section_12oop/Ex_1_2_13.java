package kang.section_12oop;

/**
 * Using our implementation of {@link Date} as a model, develop an implementation of {@link BasicTransaction}
 */
public class Ex_1_2_13 {
    public static void main(String[] args) {
        BasicTransaction transaction = new BasicTransaction("kang", new Date(9, 27, 2022), 300.3);
        System.out.println(transaction);
    }
}
