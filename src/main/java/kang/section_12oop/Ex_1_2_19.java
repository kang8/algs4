package kang.section_12oop;

/**
 * Parsing. Develop the parse constructors for your {@link Date} and {@link Transaction}
 * implementations of {@link Ex_1_2_13} that take a single {@link String} argument to specify the
 * initialization values, using the formats given in the table below.
 * <pre>{@code
 * Partial solution:
 * public Date(String date)
 * {
 *     String[] fields = date.split("/");
 *     month = Integer.parseInt(fields[0];
 *     day   = Integer.parseInt(fields[1];
 *     year  = Integer.parseInt(fields[2];
 * }
 * }</pre>
 * <table border="6">
 *   <thead>
 *     <tr>
 *       <th colspan="1">type</th>
 *       <th colspan="5">format</th>
 *       <th colspan="2">example</th>
 *     </tr>
 *   </thead>
 *   <tbody>
 *     <tr>
 *       <td colspan="1">Date</td>
 *       <td colspan="5">integers separated by slashes</td>
 *       <td colspan="2">5/22/1939</td>
 *     </tr>
 *     <tr>
 *       <td colspan="1">Transaction</td>
 *       <td colspan="5">customer, date, and amount, separated by whitespace</td>
 *       <td colspan="2">Turing 5/22/1939 11.99</td>
 *     </tr>
 *   </tbody>
 * </table>
 */
public class Ex_1_2_19 {
    public static void main(String[] args) {
        SmartDate smartDate = new SmartDate("5/22/1938");
        System.out.println(smartDate);

        BasicTransaction basicTransaction = new BasicTransaction("Turing 5/22/1939 11.99");
        System.out.println(basicTransaction);
    }
}
