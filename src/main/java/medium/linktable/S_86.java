package medium.linktable;

import util.ListNode;

/**
 * @author hunan
 * @date 2020-01-17
 * @time 16:06
 */
public class S_86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode h = new ListNode(0);
        ListNode p = h;
        ListNode prev = null, cur = head;
        while (cur != null) {
            if (cur.val < x) {
                p.next = cur;
                p = p.next;
                if (prev == null) {
                    cur = cur.next;
                } else {
                    prev.next = cur.next;
                    cur = prev.next;
                }
                p.next = null;
            } else {
                if (prev == null) {
                    head = cur;
                }
                prev = cur;
                cur = cur.next;
            }
        }

        if (prev != null) {
            p.next = head;
        }
        return h.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.from(new int[]{1, 2, 3});
        System.out.println(new S_86().partition(head, 4));
    }
}
