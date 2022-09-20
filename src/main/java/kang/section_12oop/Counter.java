package kang.section_12oop;

public class Counter {
    private final String name;
    private int count;

    public Counter(String id) {
        name = id;
    }

    public void increment() {
        count++;
    }

    public int tally() {
        return count;
    }

    public String toString() {
        return count + " " + name;
    }

    public static void main(String[] args) {
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");

        heads.increment();
        heads.increment();
        tails.increment();

        System.out.println(heads + " " + tails);
        System.out.println(heads.tally() + tails.tally());
    }
}
