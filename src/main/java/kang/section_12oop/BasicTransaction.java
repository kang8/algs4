package kang.section_12oop;

public class BasicTransaction {
    private final String who;
    private final Date   when;
    private final double amount;

    BasicTransaction(String who, Date when, double amount) {
        this.who    = who;
        this.when   = when;
        this.amount = amount;
    }

    BasicTransaction(String transaction) {
        String[] split = transaction.split("\\s+");

        if (split.length != 3) {
            throw new IllegalArgumentException("Invalid transaction: " + transaction);
        }

        who = split[0];
        when = new Date(split[1]);
        amount = Double.parseDouble(split[2]);
    }

    public String who() {
        return who;
    }

    public Date when() {
        return when;
    }

    public double amount() {
        return amount;
    }

    public String toString() {
        return String.format("%-10s %10s %8.2f", who, when, amount);
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (this.getClass() != other.getClass()) return false;

        BasicTransaction that = (BasicTransaction) other;

        return (this.amount == that.amount) && (this.who.equals(that.who)) && (this.when.equals(that.when));
    }
}
