package kang.section_12oop;

/**
 * Using our implementation of {@code equals()} in {@link Date} as a model, develop
 * implementation of {@code equals()} for {@link BasicTransaction}
 */
public class Ex_1_2_14 {
    public static void main(String[] args) {
        BasicTransaction first = new BasicTransaction("kang", new Date(9, 27, 2022), 300.3);
        BasicTransaction second = new BasicTransaction("kang", new Date(9, 27, 2022), 300.3);
        BasicTransaction third = new BasicTransaction("Kang", new Date(9, 27, 2022), 300.3);

        if (first.equals(second)) {
            System.out.println("first is equals second");
        } else {
            System.out.println("first is not equal second");
        }

        if (third.equals(second)) {
            System.out.println("third is equals second");
        } else {
            System.out.println("third is not equal second");
        }
    }
}
