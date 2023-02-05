/**
 * https://leetcode.com/problems/reverse-integer/
 */
public class Solution_ReverseInteger {

    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            int d = x % 10;
            result = result * 10 + d;

            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }

            x = x / 10;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        Solution_ReverseInteger solution = new Solution_ReverseInteger();
        solution.test(123, 321);
        solution.test(-123, -321);
        solution.test(120, 21);
        solution.test(1534236469, 0);
    }

    void test(int input, int expected) {
        if (reverse(input) == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }
}
