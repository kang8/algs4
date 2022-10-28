package kang.section_13stacks;

import java.util.Arrays;

public class ResizingArrayQueueOfStrings {
    private String[] a;
    private int      N;
    private int      first;
    private int      last;

    public ResizingArrayQueueOfStrings() {
        this.a     = new String[1];
        this.N     = a.length;
        this.first = 0;
        this.last  = 0;
    }

    public void enqueue(String s) {
        if (N == a.length) {
            resize(N * 2);
        }

        N++;

        a[last] = s;
                  last = nextOne(last);
    }

    public String dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty!");
        }

        if (N == a.length / 4) {
            resize(a.length / 2);
        }

        N--;

        String item = a[first];
        first = nextOne(first);

        return item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public String toString() {
        return Arrays.toString(a);
    }

    private void resize(int capacity) {
        String[] newOne = new String[capacity];

        int len = 0;

        while (first != last) {
            newOne[len++] = a[first];
            first         = nextOne(first);
        }

        first = 0;
        last  = len;

        a = newOne;
    }

    private int nextOne(int index) {
        if (index == a.length) {
            return 0;
        } else {
            return index + 1;
        }
    }
}
