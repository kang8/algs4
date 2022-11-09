package kang.section_13stacks;

/**
 * Write a method {@link LinkedList#removeAfter(LinkedList.Node)} that takes a linked-list Node as argument and removes the
 * node following the given one (and does nothing if the argument or the next field in the
 * argument node is null).
 */
public class Ex_1_3_24 {
    private static class Node<Item> {
        Item       item;
        Node<Item> next;

        Node(Item element, Node<Item> next) {
            this.item = element;
            this.next = next;
        }

        Node() {
            this(null, null);
        }
    }

    public static Node<Integer> createLinkedList(int l) {
        Node<Integer> first = new Node<>();
        Node<Integer> node  = first;


        for (int i = 1; i <= l; i++) {
            node.item = i;

            if (i == l) break;

            Node<Integer> temp = new Node<>();
            node.next = temp;
            node      = temp;
        }

        return first;
    }


    public static void print(Node<Integer> node) {
        StringBuilder str = new StringBuilder();

        while (node != null) {
            str.append(node.item).append(" ");
            node = node.next;
        }

        System.out.println(str.toString().trim());
    }

    public static void main(String[] args) {
        Node<Integer> linkedList = createLinkedList(6);
        print(linkedList);

        removeAfter(linkedList);
        print(linkedList);

        removeAfter(linkedList);
        print(linkedList);
    }

    private static void removeAfter(Node<Integer> node) {
        if (node == null || node.next == null) return;

        node.next = node.next.next;
    }
}
