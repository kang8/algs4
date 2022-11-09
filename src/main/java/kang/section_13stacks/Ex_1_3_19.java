package kang.section_13stacks;

/**
 * Give a code fragment that removes the last node in a linked list whose first node is first.
 */
public class Ex_1_3_19 {
    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3, 4, 5, 6};

        LinkedList<Integer> linkedList = new LinkedList<>(integers);

        System.out.println(linkedList);

        linkedList.removeListNode();

        System.out.println(linkedList);

    }
}
