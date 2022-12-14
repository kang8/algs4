package kang.section_13stacks;

public class LinkedList<Item> {
    private Node<Item> first;

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

    public LinkedList() {
        first = null;
    }

    public LinkedList(Item[] items) {
        first = new Node<>();
        Node<Item> node = first;

        for (Item item : items) {
            Node<Item> temp = new Node<>();

            insertAfter(node, temp);

            node.item = item;
            node      = temp;
        }

        this.removeListNode();
    }

    public void removeListNode() {
        Node<Item> node = first;

        // Find the second last node.
        while (node.next.next != null) {
            node = node.next;
        }

        node.next = null;
    }

    public void remove(Item key) {
        while (first.item == key) {
            first = first.next;
        }

        Node<Item> node = new Node<>();
        node.next = first;
        while (node != null && node.next != null) {
            if (node.next.item == key) {
                node.next = node.next.next;
            }

            node = node.next;
        }
    }

    public void revert() {
        Node<Item> current = first.next;
        Node<Item> previous = first;
        Node<Item> next;

        while (current != null) {
            next = current.next;

            current.next = previous;
            previous = current;
            current = next;
        }
        first.next = null;

        first = previous;
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

    private void removeAfter(Node<Item> node) {
        if (node == null || node.next == null) return;

        node.next = node.next.next;
    }

    private void insertAfter(Node<Item> node, Node<Item> append) {
        if (node == null || append == null) {
            return;
        }

        append.next = node.next;
        node.next   = append;
    }
}
