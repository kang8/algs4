package kang.section_13stacks;

/**
 * Develop a recursive solution to the previous question.
 */
public class Ex_1_3_28 {
    private static class Node {
        Integer        item;
        Node next;

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

        Integer max = max(first, 0);
        System.out.println(max);

        max = max(first, 0);
        System.out.println(max);
    }

    private static Integer max(Node node, int max) {
        if (node == null) return max;

        return max(node.next, Math.max(max, node.item));

    }
}
