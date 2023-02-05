public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        String s = "[";

        ListNode node = new ListNode(0, this);
        node = node.next;

        while (node != null) {
            s += node.val;
            if (node.next != null) {
                s += ",";
            }
            node = node.next;
        }

        s += "]";
        return s;
    }

    public static ListNode of(String string) {
        ListNode head = null;
        ListNode node = null;

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (Character.isDigit(ch)) {
                if (node == null) {
                    node = new ListNode(Integer.parseInt(ch + ""));
                    head = node;
                } else {
                    node.next = new ListNode(Integer.parseInt(ch + ""));
                    node = node.next;
                }
            }
        }

        return head;
    }
}
