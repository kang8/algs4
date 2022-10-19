package kang.section_13stacks;

/**
 * Add a method {@link  FixedCapacityStackOfStrings#isFull()} to {@link FixedCapacityStackOfStrings}.
 */
public class Ex_1_3_01 {
    public static void main(String[] args) {
        FixedCapacityStackOfStrings fixedCapacity = new FixedCapacityStackOfStrings(1);
        System.out.println(fixedCapacity.isFull());
        fixedCapacity.push("Hello");
        System.out.println(fixedCapacity.isFull());
    }
}
