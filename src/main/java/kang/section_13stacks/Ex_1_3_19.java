package kang.section_13stacks;

/**
 * Give a code fragment that removes the last node in a linked list whose first node is first.
 */
public class Ex_1_3_19 {
    private static class Node<Item> {
        Item item;
        Node next;
    }

    public static void main(String[] args) {
        Node<Integer> first = new Node<>();
        first.item = 1;

        Node<Integer> second = new Node<>();
        second.item = 2;
        first.next  = second;

        Node<Integer> third = new Node<>();
        third.item  = 3;
        second.next = third;

        Node<Integer> fourth = new Node<>();
        fourth.item = 4;
        third.next  = fourth;

        Node<Integer> temp = first;

        while (temp != null) {
            System.out.println(temp.item);
            temp = temp.next;
        }

        // region Answer
        temp = first;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        // endregion

        temp = first;

        while (temp != null) {
            System.out.println(temp.item);
            temp = temp.next;
        }
    }
}
