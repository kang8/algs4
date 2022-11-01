package kang.section_13stacks;

public class LinkedList<Item> {
    public Node first;

    public void removeListNode() {
        Node node = first;

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

        Node previous = first;

        for (int i = 1; i < k - 1; i++) {
            if (previous.next == null) {
                throw new IllegalArgumentException("Can't Delete [" + k + "]th element.");
            }

            previous = previous.next;
        }

        if (previous.next == null) {
            throw new IllegalArgumentException("Can't Delete [" + k + "]th element.");
        }

        previous.next = previous.next.next;
    }

    public boolean find(Item i) {
        Node node = first;
        while (node != null) {
            if (node.item == i) return true;
            node = node.next;
        }

        return false;
    }

    private class Node {
        Item item;
        Node next;

        Node(Item element, Node next) {
            this.item = element;
            this.next = next;
        }

        Node() {
            this.item = null;
            this.next = null;
        }
    }

    public LinkedList() {
        first = null;
    }

    public LinkedList(Item[] items) {
        first = new Node();
        Node node = first;

        for (Item item : items) {
            node.item = item;
            Node temp = new Node();

            node.next = temp;
            node      = temp;
        }

        this.removeListNode();
    }

    public String toString() {
        StringBuilder str = new StringBuilder();

        if (first == null) return str.toString();

        Node temp = first;
        while (temp != null) {
            str.append(temp.item).append(" ");
            temp = temp.next;
        }

        return str.toString().trim();
    }
}
