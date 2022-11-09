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

        Node<Item> first = last.next;
        Item item = first.item;

        if (first == last) {
            last = null;
        } else {
            last.next = first.next;
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
            return "Empty queue.";
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
