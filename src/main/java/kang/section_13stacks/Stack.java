package kang.section_13stacks;

import java.util.Iterator;

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
        top   = new Node();

        top.item = item;
        top.next = oldTop;
        N++;
    }

    public Item pop() {
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

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
