package kang.section_13stacks;

/**
 * Write a function that takes the first Node in a linked list as argument and (destructively)
 * reverses the list, returning the first Node in the result.
 */
public class Ex_1_3_30 {
    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3, 4, 5, 6};

        LinkedList<Integer> linkedList = new LinkedList<>(integers);

        System.out.println(linkedList);
        linkedList.revert();
        System.out.println(linkedList);
    }
}
