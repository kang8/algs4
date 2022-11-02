package kang.section_13stacks;

public class LinkedList<Item> {
    private Node<Item> first;

    public void removeListNode() {
        Node<Item> node = first;

        // Find the second last node.
        while (node.next.next != null) {
            node = node.next;
        }

        node.next = null;
    }

    /**
     * Delete kth element
     */
    public void delete(int k) {
        if (k <= 0) {
            throw new IllegalArgumentException("Invalid index.");
        }

        if (k == 1) {
            if (first.next == null) {
                throw new IllegalArgumentException("Can't Delete [" + k + "]th element.");
            }

            first = first.next;
            return;
        }

        Node<Item> previous = first;

        for (int i = 1; i < k - 1; i++) {
            if (previous.next == null) {
                throw new IllegalArgumentException("Can't Delete [" + k + "]th element.");
            }

            previous = previous.next;
        }

        if (previous.next == null) {
            throw new IllegalArgumentException("Can't Delete [" + k + "]th element.");
        }

        removeAfter(previous);
    }

    public boolean find(Item i) {
        Node<Item> node = first;
        while (node != null) {
            if (node.item == i) return true;
            node = node.next;
        }

        return false;
    }

    private void removeAfter(Node<Item> node) {
        if (node == null || node.next == null) return;

        node.next = node.next.next;
    }

    private static class Node<Item> {
        Item item;
        Node<Item> next;

        Node(Item element, Node<Item> next) {
            this.item = element;
            this.next = next;
        }

        Node() {
            this(null, null);
        }
    }

    public LinkedList() {
        first = null;
    }

    public LinkedList(Item[] items) {
        first = new Node<>();
        Node<Item> node = first;

        for (Item item : items) {
            node.item = item;
            Node<Item> temp = new Node<>();

            node.next = temp;
            node      = temp;
        }

        this.removeListNode();
    }

    public String toString() {
        StringBuilder str = new StringBuilder();

        if (first == null) return str.toString();

        Node<Item> temp = first;
        while (temp != null) {
            str.append(temp.item).append(" ");
            temp = temp.next;
        }

        return str.toString().trim();
    }
}
