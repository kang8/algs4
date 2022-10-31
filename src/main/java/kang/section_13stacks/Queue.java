package kang.section_13stacks;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int  N;

    public Queue() {
        first = null;
        last  = null;
        N     = 0;
    }

    public void enqueue(Item item) {
        Node oldLast = last;

        last      = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }

        N++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }

        Item item = first.item;
        first = first.next;

        if (isEmpty()) {
            last = null;
        }

        N--;

        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Item item : this) {
            res.append(item);
            res.append(' ');
        }
        return res.toString().trim();
    }

    private class Node {
        Item item;
        Node next;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator<Item> {
        private Node current;

        public LinkedIterator(Node current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
