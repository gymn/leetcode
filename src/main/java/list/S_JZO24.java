package list;

import org.junit.Test;
import util.ListNode;

/**
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 */
public class S_JZO24 {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode(0);
        ListNode p1 = head;

        while (p1 != null) {
            ListNode tmp = p1.next;
            p1.next = newHead.next;
            newHead.next = p1;
            p1 = tmp;
        }
        return newHead.next;
    }

    @Test
    public void test() {
        ListNode l1 = ListNode.range(1,10);
        System.out.println(l1);
        System.out.println(reverseList(l1));
    }
}
