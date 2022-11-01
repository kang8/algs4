package kang.section_13stacks;

/**
 * Write a method {@link LinkedList#find(Object)} that takes a linked list and a string key as arguments and
 * returns true if some node in the list has key as its item field, false otherwise.
 */
class Ex_1_3_21 {
    public static void main(String[] args) {
        Integer[] integers = {1, 3, 2, 4, 5, 6};

        LinkedList<Integer> linkedList = new LinkedList<>(integers);

        System.out.println(linkedList.find(6));
        System.out.println(linkedList.find(7));
    }
}
