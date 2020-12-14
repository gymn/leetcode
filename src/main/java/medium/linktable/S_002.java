package medium.linktable;

import org.junit.Test;
import util.ListNode;

public class S_002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p3 = head;
        int jw = 0;
        while (p1 != null || p2 != null) {
            int sum = (p1 == null ? 0 : p1.val) + (p2 == null ? 0 : p2.val) + jw;
            if (sum >= 10) {
                jw = 1;
            } else {
                jw = 0;
            }
            p3.next = new ListNode(sum - 10);
            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
            p3 = p3.next;
        }
        if (jw > 0) {
            p3.next = new ListNode(jw);
        }
        return head.next;
    }

    @Test
    public void test() {

    }
}
