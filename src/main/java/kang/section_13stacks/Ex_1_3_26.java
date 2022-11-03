package kang.section_13stacks;

/**
 * Write a method {@link LinkedList#remove(Object)} that takes a linked list and a string key as
 * arguments and removes all of the nodes in the list that have key as its item field.
 */
public class Ex_1_3_26 {
    public static void main(String[] args) {
        Integer[] integers = {1, 1, 2, 4, 5, 6};

        LinkedList<Integer> linkedList = new LinkedList<>(integers);

        System.out.println(linkedList);
        linkedList.remove(1);
        System.out.println(linkedList);
    }
}
