/**
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class Solution_HasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode step = new ListNode(0);
        ListNode jump = new ListNode(0);

        step.next = head;
        jump.next = head;

        while (step.next != null) {
            if (step == jump) {
                return true;
            }

            step = step.next;

            if (jump != null && jump.next != null) {
                jump = jump.next.next;
            }
        }

        return false;
    }
}
