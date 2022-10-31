package kang.section_12oop;

import algs4.In;
import kang.section_13stacks.Queue;

public class SmartDate {
    private final int month;
    private final int day;
    private final int year;

    private final int[] DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // Calendar from 12/31/1999 - Firday
    private final String[] DAY_OF_WEEK = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};

    public SmartDate(int m, int d, int y) {
        if (!isValid(m, d, y)) {
            System.out.println("Invalid date: " + m + "/" + d + "/" + y);
        }
        this.month = m;
        this.day   = d;
        this.year  = y;
    }

    /**
     * Parse date with 5/22/1939, month/day/year
     */
    public SmartDate(String date) {
        String[] split = date.split("/");

        if (split.length != 3) {
            throw new IllegalArgumentException("Invalid date: " + date);
        }

        month = Integer.parseInt(split[0]);
        day   = Integer.parseInt(split[1]);
        year  = Integer.parseInt(split[2]);

        if (!isValid(month, day, year)) {
            throw new IllegalArgumentException("Invalid date: " + date);
        }
    }

    public static SmartDate[] readDates(String name) {
        In in = new In(name);

        Queue<SmartDate> queue = new Queue<>();
        while (!in.isEmpty()) {
            SmartDate item = new SmartDate(in.readString());
            queue.enqueue(item);
        }

        int         size       = queue.size();
        SmartDate[] smartDates = new SmartDate[size];

        for (int i = 0; i < size; i++) {
            smartDates[i] = queue.dequeue();
        }

        return smartDates;
    }

    public int month() {
        return month;
    }

    public int day() {
        return day;
    }

    public int year() {
        return year;
    }

    /**
     * Assume the date is in the 21st century.
     *
     * @return day of week. e.g. monday
     */
    public String dayOfTheWeek() {
        int baseMonth = 1;
        int baseYear  = 2000;

        int days = 0;

        while (baseYear < this.year) {
            days += isLeapYear(baseYear) ? 366 : 365;

            baseYear++;
        }

        while (baseMonth < this.month) {
            if (baseMonth == 2) {
                days += isLeapYear(this.year) ? 29 : 28;
            } else {
                days += DAYS[baseMonth - 1];
            }

            baseMonth++;
        }

        days += this.day;

        return DAY_OF_WEEK[days % 7];
    }

    private boolean isValid(int m, int d, int y) {
        if (y <= 0) return false;
        if (m < 1 || m > 12) return false;
        if (d < 1 || d > DAYS[m - 1]) return false;
        if (m == 2 && d == 29 && !isLeapYear(y)) return false;

        return true;
    }

    private boolean isLeapYear(int y) {
        if (y % 400 == 0) return true;
        if (y % 100 == 0) return false;
        return y % 4 == 0;
    }

    public String toString() {
        return month() + "/" + day() + "/" + year();
    }

    public boolean equals(Object x) {
        if (this == x) return true;
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;

        SmartDate that = (SmartDate) x;

        if (this.day != that.day) return false;
        if (this.month != that.month) return false;
        if (this.year != that.year) return false;

        return true;
    }
}
