package kang.section_13stacks;

import algs4.In;

public class FixedCapacityStackOfStrings {
    private String[] a;
    private int      N;

    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }

    public void push(String item) {
        a[N++] = item;
    }

    public String pop() {
        return a[--N];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean isFull() {
        return N == a.length;
    }

    public int size() {
        return N;
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings fixedCapacity = new FixedCapacityStackOfStrings(100);

        String[] strings = new In("tobe.txt").readAllStrings();

        for (String s : strings) {
            if (!s.equals("-")) {
                fixedCapacity.push(s);
            } else if (!fixedCapacity.isEmpty()) {
                System.out.print(fixedCapacity.pop() + " ");
            }
        }
        System.out.println("(" + fixedCapacity.size() + " left on stack)");
    }
}
