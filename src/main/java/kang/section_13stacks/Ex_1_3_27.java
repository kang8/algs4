package kang.section_13stacks;

/**
 * Write a method {@link Ex_1_3_27#max(Node)} that takes a reference to the first node in a
 * linked list as argument and returns the values of the maximum key in the list. Assume that all
 * keys are positive integers, and return 0 if the list is empty.
 */
public class Ex_1_3_27 {
    private static class Node {
        Integer item;
        Node    next;

        public Node(Integer item, Node node) {
            this.item = item;
            this.next = node;
        }
    }

    public static void main(String[] args) {
        Node first = new Node(1, new Node(2, new Node(3, null)));

        Node node = first;
        while (node != null) {
            System.out.println(node.item);
            node = node.next;
        }

        Integer max = max(first);
        System.out.println(max);

        max = max(first);
        System.out.println(max);
    }

    private static Integer max(Node node) {
        if (node == null) return 0;

        int max = node.item;

        while (node != null) {
            if (node.item > max) max = node.item;

            node = node.next;
        }

        return max;
    }
}
