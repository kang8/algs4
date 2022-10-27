package kang.section_13stacks;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {
    private Node top;
    private int  N;

    private class Node {
        Item item;
        Node next;
    }

    public Stack() {
        top = null;
        N   = 0;
    }

    public void push(Item item) {
        Node oldTop = top;
        top = new Node();

        top.item = item;
        top.next = oldTop;
        N++;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }

        Item item = top.item;
        top = top.next;
        N--;

        return item;
    }

    public Item peek() {
        return top.item;
    }

    public boolean isEmpty() {
        return top == null; // or N == 0
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

    public static Stack<String> copy(Stack<String> stack) {
        String[]      strings   = new String[stack.size()];
        Stack<String> copyStack = new Stack<>();
        int           len       = 0;

        for (String str : stack) {
            strings[len++] = stack.pop();
        }

        for (int i = strings.length - 1; i >= 0; i--) {
            copyStack.push(strings[i]);
        }

        return copyStack;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator(top);
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
