package kang.section_13stacks;

public class DoublingStackOfStrings {
    private String[] a;
    private int      N;

    public DoublingStackOfStrings() {
        a = new String[1];
        N = 0;
    }

    public void push(String item) {
        if (a.length == N) {
            resize(2 * N);
        }
        a[N++] = item;
    }

    public String pop() {
        String item = a[--N];
        a[N] = null;

        if (N > 0 && a.length / 4 == N) {
            resize(a.length / 2);
        }
        return item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public int sizeOfArray() {
        return a.length;
    }

    private void resize(int capacity) {
        String[] temp = new String[capacity];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }
}
