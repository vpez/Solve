import java.math.BigInteger;

/**
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class Solution_AddTwoNumbers {

    public static void main(String[] args) {
        Solution_AddTwoNumbers solution = new Solution_AddTwoNumbers();
        solution.test("[3,2,1]", "[1,2,3]", "[4,4,4]");
        solution.test("[2,4,3]", "[5,6,4]", "[7,0,8]");
        solution.test("[0]", "[0]", "[0]");
        solution.test("[9,9,9,9,9,9,9]", "[9,9,9,9]", "[8,9,9,9,0,0,0,1]");
        solution.test("[2,8,9]", "[8,1,2]", "[0,0,2,1]");
        solution.test("[2,8,9,9,9,9,8,9,9,9]", "[8,1,2]", "[0,0,2,0,0,0,9,9,9,9]");
    }

    private void test(String s1, String s2, String expect) {
        ListNode l1 = ListNode.of(s1);
        ListNode l2 = ListNode.of(s2);
        ListNode l3 = addTwoNumbers(l1, l2);

        String result = l3.toString();
        if (!expect.equals(result)) {
            System.out.println("FAIL");
        } else {
            System.out.println("PASS");
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr = null;
        ListNode head = null;

        int curry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + curry;
            curry = sum < 10 ? 0 : 1;

            ListNode node;
            if (sum < 10) {
                node = new ListNode(sum);
            }
            else {
                node = new ListNode(sum % 10);
                node.next = new ListNode(1);
            }

            if (head == null) {
                head = node;
                curr = head;
            } else {
                curr.next = node;
                curr = curr.next;
            }

            l1 = l1.next;
            l2 = l2.next;

        }

        while (l1 != null) {
            int sum = l1.val % 10 + curry;
            int value = sum % 10;
            curry = sum / 10;
            curr.next = new ListNode(value);
            curr = curr.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val % 10 + curry;
            int value = sum % 10;
            curry = sum / 10;
            curr.next = new ListNode(value);
            curr = curr.next;
            l2 = l2.next;
        }

        if (curry > 0) {
            curr.next = new ListNode(curry);
        }

        return head;
    }


    /**
     * Slow solution
     */
    public ListNode addTwoNumbers_UsingBigInteger(ListNode l1, ListNode l2) {
        BigInteger x = toNumber(l1);
        BigInteger y = toNumber(l2);
        return toList(x.add(y));
    }

    private BigInteger toNumber(ListNode p) {
        BigInteger value = new BigInteger("0");
        int pow = 0;
        BigInteger ten = new BigInteger("10");
        while (p != null) {
            BigInteger add = new BigInteger(String.valueOf(p.val))
                    .multiply(ten.pow(pow++));
            value = value.add(add);
            p = p.next;
        }
        return value;
    }

    private ListNode toList(BigInteger val) {
        ListNode head = null;
        ListNode p = null;
        BigInteger zero = new BigInteger("0");
        BigInteger ten = new BigInteger("10");
        while (val.compareTo(zero) != 0) {
            int value = val.mod(ten).intValue();
            ListNode node = new ListNode(value);
            if (head == null) {
                head = node;
                p = head;
            } else {
                p.next = node;
                p = p.next;
            }
            val = val.divide(ten);
        }

        if (head == null) {
            head = new ListNode(0);
        }

        return head;
    }
}