package kang.section_13stacks;

import java.util.Iterator;

/**
 * @Reference: <a href="https://en.wikipedia.org/wiki/Doubly_linked_list">Doubly linked list</a>
 * @Node: All of insert function will return inserted Node on doubly linked list
 */
public class DoublyLinkedList<Item> implements Iterable<Item> {
    private DoublyLinkedNode<Item> first;
    private DoublyLinkedNode<Item> last;
    private int                    size;

    private static class DoublyLinkedNode<Item> {

        Item                   item;
        DoublyLinkedNode<Item> prev;
        DoublyLinkedNode<Item> next;

        public DoublyLinkedNode(Item item) {
            this.item = item;
            prev      = null;
            next      = null;
        }

    }

    public DoublyLinkedList() {
        size  = 0;
        first = null;
        last  = null;
    }

    public DoublyLinkedNode<Item> insertBeginning(Item item) {
        DoublyLinkedNode<Item> node = new DoublyLinkedNode<>(item);

        if (first == null) {
            first = node;
            last  = first;
        } else {
            node.next  = first;
            first.prev = node;
            first      = node;
        }
        size++;

        return node;
    }

    public DoublyLinkedNode<Item> insertEnd(Item item) {
        DoublyLinkedNode<Item> node = new DoublyLinkedNode<>(item);

        if (last == null) {
            last  = node;
            first = last;
        } else {
            last.next = node;
            node.prev = last;
            last      = node;
        }
        size++;

        return node;
    }

    public DoublyLinkedNode<Item> insertAfter(DoublyLinkedNode<Item> search, Item item) {
        DoublyLinkedNode<Item> inserter = new DoublyLinkedNode<>(item);

        DoublyLinkedNode<Item> list = first;

        while (list != null && list != search) {
            list = list.next;
        }

        if (list == search) {
            if (list.next == null) {
                list.next = inserter;
                inserter.prev = list;
                last = inserter;
            } else {
                inserter.next      = list.next;
                inserter.next.prev = inserter;
                list.next          = inserter;
                inserter.prev      = list;
            }
        }
        size++;

        return inserter;
    }

    public DoublyLinkedNode<Item> insertBefore(DoublyLinkedNode<Item> search, Item item) {
        DoublyLinkedNode<Item> inserter = new DoublyLinkedNode<>(item);

        DoublyLinkedNode<Item> list   = first;

        while (list != null && list != search) {
            list = list.next;
        }

        if (list == search) {
            if (list.prev == null) {
                inserter.next = list;
                list.prev = inserter;
                first = inserter;
            } else {
                inserter.prev = list.prev;
                inserter.prev.next = inserter;
                inserter.next = list;
                list.prev = inserter;
            }
        }
        size++;

        return inserter;
    }

    public void removeBeginning() {
        if (size == 0) {
            throw new IllegalArgumentException("Doubly linked list is Empty");
        }

        if (first.next == null) {
            first = null;
            last = null;
            return;
        }

        first = first.next;
        first.prev = null;
    }

    public void removeEnd() {
        if (size == 0) {
            throw new IllegalArgumentException("Doubly linked list is Empty");
        }

        if (last.prev == null) {
            first = null;
            last = null;
            return;
        }

        last = last.prev;
        last.next = null;
    }

    public void remove(DoublyLinkedNode<Item> search) {
        if (size ==  0) {
            throw new IllegalArgumentException("Doubly linked list is Empty");
        }

        DoublyLinkedNode<Item> list = first;

        while (list != null && list != search) {
            list = list.next;
        }

        if (list == search){
            if (list.next == null) {
                list.prev.next = null;
                last = list.prev;
            } else if (list.prev == null) {
                first = first.next;
            } else {
                list.prev.next = list.next;
            }
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new DoublyLinkedIterator(first);
    }
    private class DoublyLinkedIterator implements Iterator<Item> {

        private DoublyLinkedNode<Item> current;

        public DoublyLinkedIterator(DoublyLinkedNode<Item> current) {
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

    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list  = new DoublyLinkedList<>();
        DoublyLinkedNode<Integer> one = list.insertBeginning(1);
        DoublyLinkedNode<Integer> five  = list.insertEnd(5);
        DoublyLinkedNode<Integer> two = list.insertAfter(one, 2);

        list.insertAfter(five, 7);
        list.insertAfter(two, 3);
        list.insertBefore(five, 4);
        DoublyLinkedNode<Integer> zero = list.insertBefore(one, 0);

        list.removeBeginning();
        list.removeEnd();
        list.remove(two);
        list.remove(one);
        list.remove(five);
        print(list);
    }

    private static void print(DoublyLinkedList<Integer> list) {
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
