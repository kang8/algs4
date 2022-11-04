package kang.section_13stacks;

public class CircularQueue<Item> {
    private Node<Item> last;
    private int        length;

    private static class Node<T> {
        T       item;
        Node<T> next;

        Node(T item, Node<T> node) {
            this.item = item;
            this.next = node;
        }

        Node() {
            this(null, null);
        }
    }

    public CircularQueue() {
        last   = null;
        length = 0;
    }

    public void enqueue(Item item) {
        Node<Item> node = new Node<>(item, null);

        if (last == null) {
            last      = node;
            node.next = node;
        } else {
            node.next = last.next;
            last.next = node;
        }

        length++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Can't dequeue empty Queue.");
        }

        Item item = last.item;

        Node<Item> previousByLast = last;


        // get previous node with last
        while (previousByLast.next != last) {
            previousByLast = previousByLast.next;
        }

        // Delete last node
        if (previousByLast == last) { // length = 1;
            last = null;
        } else {
            Node<Item> first = last.next;
            previousByLast.next = first;
            last                = previousByLast;
        }

        length--;
        return item;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int size() {
        return length;
    }

    public String toString() {
        if (isEmpty()) {
            return "";
        }

        StringBuilder str  = new StringBuilder();
        Node<Item>    node = last.next;

        int i = 0;

        while (node != last && i < 10) {
            str.append(node.item).append(" ");
            node = node.next;
            i++;
        }
        str.append(node.item).append(" ");

        return str.toString().trim();
    }
}
