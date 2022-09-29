package kang.section_12oop;

/**
 * Robust implementation of rational numbers. Use assertions to develop an implementation of
 * {@link BasicRational}(see {@link Ex_1_2_16}) that is immune to overflow.
 *
 * @Answer: add -> {@link Math#addExact(long, long)}; product -> {@link Math#multiplyExact(long, long)}
 * @Tips: Don't forget add `-ea` to enable assertion statement
 */
public class Ex_1_2_17 {
    public static void main(String[] args) {
        BasicRational first  = new BasicRational(1, 1);
        BasicRational second = new BasicRational(1, 1);

        System.out.println(first.plus(second));

        first = new BasicRational(Long.MAX_VALUE, 1);
        second = new BasicRational(Long.MAX_VALUE, 1);

        System.out.println(first.times(second));
    }
}
