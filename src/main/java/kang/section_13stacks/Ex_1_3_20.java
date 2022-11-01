package kang.section_13stacks;

/**
 * Write a method {@link LinkedList#delete(int)} that takes an int argument k and deletes the kth element
 * in a linked list, if it exists.
 */
public class Ex_1_3_20 {
    public static void main(String[] args) {
        Integer[] integers = {1, 3, 2, 4, 5, 6};

        LinkedList<Integer> linkedList = new LinkedList<>(integers);

        System.out.println(linkedList);

        linkedList.delete(0);

        System.out.println(linkedList);
    }
}
