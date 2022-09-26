package kang.section_12oop;

/**
 * Develop an implementation {@link SmartDate} of our {@link Date} API that
 * raises an exception if the date is not legal.
 */
public class Ex_1_2_11 {

    static class SmartDate {
        private final int month;
        private final int day;
        private final int year;

        private final int[] DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        public SmartDate(int m, int d, int y) {
            if (!isValid(m, d, y)) {
                throw new IllegalArgumentException("Invalid date");
            }
            this.month = m;
            this.day   = d;
            this.year  = y;
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


    public static void main(String[] args) {
        SmartDate validDate = new SmartDate(9, 26, 2022);
        System.out.println(validDate);

        SmartDate monthInvalid         = new SmartDate(19, 26, 2022);
        SmartDate dayInvalid           = new SmartDate(9, 36, 2022);
        SmartDate leapYearInvalid      = new SmartDate(2, 29, 2022);
        SmartDate leapYearValid        = new SmartDate(2, 29, 2024);
        SmartDate leapYearInvalidBy100 = new SmartDate(2, 29, 1000);
    }
}
