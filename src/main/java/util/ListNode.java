package util;

/**
 * Created by ad on 2017/8/8.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        ListNode tmp = next;
        while (tmp != null && tmp != this) {
            sb.append("->").append(tmp.val);
            tmp = tmp.next;
        }

        if (tmp == this) {
            sb.append("->");
        }
        return sb.toString();
    }

    public static ListNode range(int start, int end) {
        ListNode head = new ListNode(start);
        ListNode tmp = head;
        for (int i = start + 1; i <= end; i++) {
            ListNode newNode = new ListNode(i);
            tmp.next = newNode;
            tmp = newNode;
        }
        return head;
    }

    public static ListNode from(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        ListNode head = new ListNode(values[0]);
        ListNode tmp = head;
        for (int i = 1; i < values.length; i++) {
            ListNode newNode = new ListNode(values[i]);
            tmp.next = newNode;
            tmp = newNode;
        }
        return head;
    }
}
